package com.inca.controller.login;


import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.inca.entity.pub.Customer;
import com.inca.service.CustomerService;


@Controller
public class CustomerControler {
	
	@Autowired
	CustomerService resourceService;
	
   @RequestMapping("/customer")
    public String main() {
        return "customer/home";
    }
	/*
	 * 客户管理页面添加用户
	 */
	@RequestMapping(value="/addsure")
	@ResponseBody
	public  Map<String, Object> insertuser(Customer customer){
		   Map<String, Object> map = new HashMap<String, Object>();
		
		int h =resourceService.addCustomer(customer);
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
	     h=resourceService.deleteCustomer(_id);
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
	
		  int h =resourceService.updateCustomer(customer);
			if (h==1) {
				map.put("result", "1");
			}else{
				map.put("result", "2");
			}
		  return map;
	}
}
