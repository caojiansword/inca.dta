package com.inca.controller.customer;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.inca.entity.pub.Customer;
import com.inca.entity.pub.view.CustomerView;
import com.inca.service.CustomerService;
import com.inca.service.OptionNewService;
import com.inca.utils.OptionMap;


@Controller
@RequestMapping(CustomerControler.FUNC_PATH)
public class CustomerControler {
    public static final String FUNC_PATH = "/DTA001";
	@Autowired
	CustomerService customerService;
	
	@Autowired
	OptionNewService optionNewService;
	
	@ModelAttribute("funcPath")
    public String funcPath() {
        return FUNC_PATH;
    }
	@ModelAttribute("type")
	public String getTypes() throws Exception {
		return optionNewService.getOptionValues("customertype");
	}
	@ModelAttribute("status")
	public String getStatus() throws Exception {
		return optionNewService.getOptionValues("status");
	}
   @RequestMapping("/customer")
    public String main() {
        return "customer/home";
    }
	@RequestMapping(value="/search")
	@ResponseBody
	public  List<CustomerView> search(String keyword,String type){
		List<CustomerView> customers = customerService.getCustomerList();
		if(!StringUtils.isEmpty(keyword)){
			//编码 名称精确匹配
			//customers=customers.stream().filter(p->p.getCustomerName().equals(keyword)||p.getCustomerCode().equals(keyword)).collect(Collectors.toList());
			//模糊匹配
			customers = customerService.getCustomerListByKeyWord(keyword);
		}
		//客户类型
		if(!StringUtils.isEmpty(type)){
			Integer typeInt = Integer.valueOf(type);
			customers=customers.stream().filter(p->p.getType().equals(typeInt)).collect(Collectors.toList());
		}
		return customers;
	}
	/*
	 * 客户管理页面添加用户
	 */
	@RequestMapping(value="/addsure")
	@ResponseBody
	public  Map<String, Object> insertuser(String json){
		Map<String, Object> map = new HashMap<String, Object>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		if(StringUtils.isEmpty(json)){
			map.put("result", "1");
			return map;
		}
		Customer customer = new Customer();
		if(json!=null){
	    JSONObject jsonObject = JSONObject.parseObject(json);
	    String  customerCode= jsonObject.getString("customerCode");
	    String  customerName= jsonObject.getString("customerName");
	    String  domain= jsonObject.getString("domain");
	    Integer type= jsonObject.getInteger("type");
	    String  orgCode= jsonObject.getString("orgCode");
	    Integer status= jsonObject.getInteger("status");
	    String  phoneNo= jsonObject.getString("phoneNo");
	    Date createDate = null;
	    customer.setCustomerCode(customerCode);
	    customer.setCustomerName(customerName);
	    customer.setDomain(domain);
	    customer.setType(type);
	    customer.setOrgCode(orgCode);
	    customer.setStatus(status);
	    customer.setPhoneNo(phoneNo);
	    /* try {
			createDate =sdf.parse(sdf.format(new Date()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    customer.setCreateTime(createDate);*/
	    customer.setCreateTime(null);
	    customer.setOnlineDate(null);
	    customer.setStopDate(null);
		}  
		int h =customerService.addCustomer(customer);
		if (h==1) {
			map.put("result", "1");
		}else{
			map.put("result", "2");
		}
		return map;
	}
	
	
	/*
	 * delleteuser 删除用户
	 */
	@RequestMapping(value="/delleteuser")
	@ResponseBody
	public Map<String, Object> deleteuser(String str){
		  Map<String, Object> map = new HashMap<String, Object>();
		String[] array=new String[100];
		array=str.split(",");
		int h=0;
		for(String id:array){
		 Integer _id = Integer.valueOf(id);
	     h=customerService.deleteCustomer(_id);
		}
		if (h==1) {
			map.put("result", "1");
		}else{
			map.put("result", "2");
		}
		return map;
	}
	
	/*
	 * updatesure 客户管理编辑
	 * 
	 */
	@RequestMapping(value="/updatesure")
	@ResponseBody
	public Map<String, Object> updateuser(Customer customer){
		  Map<String, Object> map = new HashMap<String, Object>();
	
		  int h =customerService.updateCustomer(customer);
			if (h==1) {
				map.put("result", "1");
			}else{
				map.put("result", "2");
			}
		  return map;
	}
}
