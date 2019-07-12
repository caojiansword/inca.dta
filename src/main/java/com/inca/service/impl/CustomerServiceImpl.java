package com.inca.service.impl;



import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inca.entity.pub.Customer;
import com.inca.entity.pub.view.CustomerView;
import com.inca.mapper.CustomerMapper;
import com.inca.service.CustomerService;
import com.inca.utils.OptionMap;

@Service
@Transactional(rollbackFor=Exception.class)
public class CustomerServiceImpl  implements CustomerService {
    @Autowired
    CustomerMapper customerMapper;
	@Override
	public List<CustomerView> getCustomerList(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式

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
		return customerList;
	}
    //新增客户
	@Override
	public int addCustomer(Customer c) {
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
		Customer customer = new Customer();
		customer.setId(c.getId());
		customer.setDomain(c.getDomain());
		customer.setUpdateTime(new Date());
		customer.setCustomerName(c.getCustomerName());
		int  h=customerMapper.update(customer);
		return h;
	}
	@Override
	public List<CustomerView> getCustomerListByKeyWord(String keyWord) {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		List<CustomerView> customerList = customerMapper.getCustomerListByKeyWord(keyWord);
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

}
