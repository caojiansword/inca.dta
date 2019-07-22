package com.inca.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.inca.entity.pub.Customer;
import com.inca.entity.pub.view.CustomerView;
import com.inca.entity.pub.vo.CustomerVo;
@Repository
public interface CustomerMapper {
	List<CustomerView> getCustomerList(CustomerVo customerVo);
    int insert(Customer c);
    int delete(Customer c);
    int update(Customer c);
    CustomerView getCustomerById(Integer id);
    int updateStatus(Customer c);
    List<CustomerView> getCustomerListByCode(String code);
	void saveForBatch(@Param("list") List<CustomerView> list);
}