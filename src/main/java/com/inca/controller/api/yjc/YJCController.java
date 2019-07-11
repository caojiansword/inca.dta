package com.inca.controller.api.yjc;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inca.entity.pub.Customer;
import com.inca.result.Result;

@RestController
@RequestMapping(YJCController.API_PATH)
public class YJCController {
	final Log log = LogFactory.getLog(getClass());
	//定义药京采访问路径
	public static final String API_PATH = "/incayjc";
	
	@RequestMapping("/getCustomer")
	public Result<Customer> getCustomerList(){
		Customer cc = new Customer();
		cc.setCustomerCode("ssss");
		cc.setCustomerName("测试使用");
		cc.setStatus(1);
		return Result.success(cc);
	}
	
	

}
