package com.inca.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.inca.entity.pub.Customer;
@Repository
public interface CustomerMapper {
	List<Customer> getCustomerList();
    int insert(Customer c);
    int delete(Customer c);
    int update(Customer c);
}