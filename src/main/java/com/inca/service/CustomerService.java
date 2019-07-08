package com.inca.service;

import java.util.List;

import com.inca.entity.pub.Customer;

public interface CustomerService {
	//获取客户列表
	public List<Customer> getCustomerList();
    //客户管理-添加用户
	public int addCustomer(Customer cm);
	
	//客户管理-删除用户
	public int deleteCustomer(Integer id);
	
	//客户管理-编辑用户
	public int updateCustomer(Customer c);
}
