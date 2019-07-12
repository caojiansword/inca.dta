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
		return OptionMap.getOptions("customertype");
	}
	@ModelAttribute("status")
	public String getStatus() throws Exception {
		return OptionMap.getOptions("status");
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
		if(json!=null){
	    JSONObject jsonObject = JSONObject.parseObject(json);
	    String  customerCode= jsonObject.getString("customerCode");
	    String  customerName= jsonObject.getString("customerName");
	    String  domain= jsonObject.getString("domain");
	    Integer type= jsonObject.getInteger("type");
	    String  orgCode= jsonObject.getString("orgCode");
	    Integer status= jsonObject.getInteger("status");
	    String  phoneNo= jsonObject.getString("phoneNo");
	    Integer id = jsonObject.getInteger("id");
	    Customer customer = new Customer();
	    customer.setCustomerCode(customerCode);
	    customer.setCustomerName(customerName);
	    customer.setDomain(domain);
	    customer.setType(type);
	    customer.setOrgCode(orgCode);
	    customer.setStatus(status);
	    customer.setPhoneNo(phoneNo);
	    customer.setCreateTime(new Date());
	    customer.setOnlineDate(null);
	    customer.setStopDate(null);
			if (id != null) {
				customer.setId(id);
				int h = customerService.updateCustomer(customer);
				if (h == 1) {
					map.put("result", "1");
				}
				return map;
			} else {
				int h = customerService.addCustomer(customer);
				if (h == 1) {
					map.put("result", "1");
				}
			}
		}
		return map;
	}
	
	
	/*
	 * delleteuser 删除用户
	 */
	@RequestMapping(value="/delleteuser")
	@ResponseBody
	public Map<String, Object> deleteuser(Integer[] ids){
		Map<String, Object> map = new HashMap<String, Object>();
		int h=0;
		if(ids != null && ids.length > 0){
			for(Integer id:ids){
			  h=customerService.deleteCustomer(id);
			}
		}
		if (h==1) {
			map.put("result", "1");
		}else{
			map.put("result", "2");
		}
		return map;
	}
	@RequestMapping(value="/findCustomserById")
	@ResponseBody
	public  CustomerView findCustomerById(Integer id){
		CustomerView customers = customerService.getCustomerById(id);
		return customers;
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
	
	/*
	 * doOnline 确定
	 * 
	 */
	@RequestMapping(value = "/doOnline")
	@ResponseBody
	public Map<String, Object> doOnline(Integer[] ids) {
		Map<String, Object> map = new HashMap<String, Object>();
		int h = 0;
		if (ids != null && ids.length > 0) {
			for (Integer id : ids) {
				CustomerView customer = customerService.getCustomerById(id);
				h = customerService.doEnableCustomer(customer);
				if (h == 1) {
					map.put("result", "1");
				} else {
					map.put("result", "2");
				}
			}
		}
		return map;
	}
	/*
	 * doStop 停用
	 * 
	 */
	@RequestMapping(value = "/doStop")
	@ResponseBody
	public Map<String, Object> doStop(Integer[] ids) {
		Map<String, Object> map = new HashMap<String, Object>();
		int h = 0;
		if (ids != null && ids.length > 0) {
			for (Integer id : ids) {
				CustomerView customer = customerService.getCustomerById(id);
				h = customerService.doStopCustomer(customer);
				if (h == 1) {
					map.put("result", "1");
				} else {
					map.put("result", "2");
				}
			}
		}
		return map;
	}
}
