package com.inca.service.impl;



import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.inca.entity.pub.Customer;
import com.inca.entity.pub.view.CustomerView;
import com.inca.mapper.CustomerMapper;
import com.inca.result.CodeMsg;
import com.inca.result.Result;
import com.inca.service.CustomerService;
import com.inca.utils.OptionMap;
import com.inca.utils.excel.ExcelService;

@Service
@Transactional(rollbackFor=Exception.class)
public class CustomerServiceImpl extends ExcelService<CustomerView> implements CustomerService {
    @Autowired
    CustomerMapper customerMapper;
    
    List<CustomerView> expList;
	@Override
	public List<CustomerView> getCustomerList(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		if(expList!=null&&expList.size()!=0){
			expList.clear();
		}
		List<CustomerView> customerList = customerMapper.getCustomerList();
		customerList.stream().forEach(c->{c.setTypeView(OptionMap.getValue("customertype", c.getType()));
										  c.setStatusView(OptionMap.getValue("status", c.getStatus()));
										  if(c.getOnlineDate()!=null){
											  c.setOnLineDateView(sdf.format(c.getOnlineDate()));
										  }else{
											  c.setOnLineDateView(null);
										  }
										  if(c.getStopDate()!=null){
											  c.setStopDateView(sdf.format(c.getStopDate()));  
										  }else{
											  c.setStopDateView(null);  
										  }
										  if(c.getCreateTime()!=null){
											 c.setCreateTimeView(sdf.format(c.getCreateTime())); 
										  }else{
											 c.setCreateTimeView(null);
										  }
										 
		});
		expList = customerList;
		return customerList;
	}
    //新增客户
	@Override
	public int addCustomer(Customer c) {
		List<CustomerView> customsers = customerMapper.getCustomerListByCode(c.getCustomerCode());
		if(customsers!=null&&customsers.size()>0){
			throw new RuntimeException("该客户编码已存在，请检查！");
		}
		int h=customerMapper.insert(c);
		return h;
	}
	//删除客户
	@Override
	public int deleteCustomer(Integer id) {
		Customer c= new Customer();
		c.setId(id);
		int  h=customerMapper.delete(c);
		return h;
	}
	//资源管理-编辑客户
	@Override
	public int updateCustomer(Customer c) {
		List<CustomerView> customsers = customerMapper.getCustomerListByCode(c.getCustomerCode());
		if(customsers!=null&&customsers.size()>0){
			throw new RuntimeException("该客户编码已存在，请检查！");
		}
		Customer customer = new Customer();
		customer.setId(c.getId());
		customer.setDomain(c.getDomain());
		customer.setUpdateTime(new Date());
		customer.setCustomerName(c.getCustomerName());
		customer.setCustomerCode(c.getCustomerCode());
		customer.setType(c.getType());
		customer.setOrgCode(c.getOrgCode());
		customer.setPhoneNo(c.getPhoneNo());
		int  h=customerMapper.update(customer);
		return h;
	}
	@Override
	public List<CustomerView> getCustomerListByKeyWord(String keyWord) {
		if(expList!=null&&expList.size()!=0){
			expList.clear();
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		List<CustomerView> customerList = customerMapper.getCustomerListByKeyWord(keyWord);
		expList = customerList;
		customerList.stream().forEach(c->{c.setTypeView(OptionMap.getValue("customertype", c.getType()));
		  c.setStatusView(OptionMap.getValue("status", c.getStatus()));
		  if(c.getOnlineDate()!=null){
			  c.setOnLineDateView(sdf.format(c.getOnlineDate()));
		  }else{
			  c.setOnLineDateView(null);
		  }
		  if(c.getStopDate()!=null){
			  c.setStopDateView(sdf.format(c.getStopDate()));  
		  }else{
			  c.setStopDateView(null);  
		  }
		  if(c.getCreateTime()!=null){
			 c.setCreateTimeView(sdf.format(c.getCreateTime())); 
		  }else{
			 c.setCreateTimeView(null);
		  }
    });
		return customerList;
	}
	@Override
	public CustomerView getCustomerById(Integer id) {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		CustomerView customer = customerMapper.getCustomerById(id);
		if(customer.getOnlineDate()!=null){
			customer.setOnLineDateView(sdf.format(customer.getOnlineDate()));
		  }else{
			  customer.setOnLineDateView(null);
		  }
		  if(customer.getStopDate()!=null){
			  customer.setStopDateView(sdf.format(customer.getStopDate()));  
		  }else{
			  customer.setStopDateView(null);  
		  }
		  if(customer.getCreateTime()!=null){
			  customer.setCreateTimeView(sdf.format(customer.getCreateTime())); 
		  }else{
			  customer.setCreateTimeView(null);
		  }
		return customer;
	}
	@Override
	public int doEnableCustomer(Customer c) {
		// TODO Auto-generated method stub
		Customer customer = new Customer();
		customer.setId(c.getId());
		customer.setStatus(1);
		customer.setOnlineDate(new Date());
		int  h=customerMapper.updateStatus(customer);
		return h;
	}
	@Override
	public int doStopCustomer(Customer c) {
		// TODO Auto-generated method stub
		Customer customer = new Customer();
		customer.setId(c.getId());
		customer.setOnlineDate(c.getOnlineDate());
		customer.setStatus(2);
		customer.setStopDate(new Date());
		int  h=customerMapper.updateStatus(customer);
		return h;
	}
	@Override
	public Result<String> doImpSave(List<CustomerView> list) throws Exception{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		List<CustomerView> list_old = this.customerMapper.getCustomerList();
	    List<CustomerView> new_list =  list;
	    for(CustomerView c : list_old){
			new_list = new_list.stream().filter(cc->c.getCustomerCode().equals(cc.getCustomerCode())).collect(Collectors.toList());
	    }
		if(new_list == null || new_list.size() == 0){
			throw new RuntimeException("没有可导入数据");
		}
		new_list.stream().forEach(c->{
			String typeView = c.getTypeView();
			if(!StringUtils.isEmpty(typeView)){
			   Integer type = OptionMap.getKeyByValue("customertype", typeView);
			   c.setType(type);
			}
			String onlineDateStr = c.getOnLineDateView();
			String stopDateStr = c.getStopDateView();
			try {
				if(onlineDateStr != null){
					Date onlineDate = sdf.parse(onlineDateStr);
					c.setOnlineDate(onlineDate);	
				}
				if(stopDateStr!=null){
					Date stopDate = sdf.parse(stopDateStr);
					c.setStopDate(stopDate);
				}
				c.setStatus(0);//初始状态为临时
				c.setCreateTime(new Date());
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		});
		this.customerMapper.saveForBatch(list);
		return Result.success("导入成功");
	}
	@Override
	public List<CustomerView> getExportList() {
		return expList;
	}
}
