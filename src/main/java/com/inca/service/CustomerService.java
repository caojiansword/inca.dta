package com.inca.service;

import java.util.List;

import com.inca.entity.pub.Customer;
import com.inca.entity.pub.view.CustomerView;
import com.inca.entity.pub.vo.CustomerVo;
import com.inca.result.PageResult;

public interface CustomerService {
	//获取客户列表
	public PageResult<CustomerView> getCustomerList(CustomerVo customerVo);
	//按照关键字过滤客户列表
	//public PageResult<CustomerView> getCustomerListByKeyWord(String keyWord);
    //客户管理-添加用户
	public int addCustomer(Customer cm);
	
	//客户管理-删除用户
	public int deleteCustomer(Integer id);
	
	//客户管理-编辑用户
	public int updateCustomer(Customer c);
	
	//根据用户id查询用户信息
	public CustomerView getCustomerById(Integer id);
	
	//客户管理-确定用户
	public int doEnableCustomer(Customer c);
	//客户管理-停用用户
	public int doStopCustomer(Customer c);
	

}
