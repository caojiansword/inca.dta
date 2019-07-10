package com.inca.service.impl;



import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inca.entity.pub.Customer;
import com.inca.mapper.CustomerMapper;
import com.inca.service.CustomerService;

@Service
@Transactional(rollbackFor=Exception.class)
public class CustomerServiceImpl  implements CustomerService {
    @Autowired
    CustomerMapper customerMapper;
	@Override
	public List<Customer> getCustomerList() {
		List<Customer> customerList = customerMapper.getCustomerList();
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


}