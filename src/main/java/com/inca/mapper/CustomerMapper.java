package com.inca.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.inca.entity.pub.Customer;
import com.inca.entity.pub.view.CustomerView;
@Repository
public interface CustomerMapper {
	List<CustomerView> getCustomerList();
	List<CustomerView> getCustomerListByKeyWord(String keyWord);
    int insert(Customer c);
    int delete(Customer c);
    int update(Customer c);
}