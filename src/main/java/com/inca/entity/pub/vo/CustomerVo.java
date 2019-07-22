package com.inca.entity.pub.vo;

import java.io.Serializable;

import com.inca.base.BaseQuery;

public class CustomerVo extends BaseQuery implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5250577446339790677L;
	String methodName;
	Integer type;
	Integer status;
	String customerCode;
	String customerName;
	public String getMethodName() {
		return methodName;
	}
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getCustomerCode() {
		return customerCode;
	}
	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

}
