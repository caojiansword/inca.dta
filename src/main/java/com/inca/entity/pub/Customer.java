package com.inca.entity.pub;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import com.inca.entity.BaseEntity;
@Component
public class Customer extends BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7413903709562215395L;
	
	private Integer id;
	
	private String customerName;
	
	private String customerCode;
	
	private String domain;
	
	private Integer type;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", customerName=" + customerName + ", customerCode=" + customerCode + ", domain="
				+ domain + ", type=" + type + "]";
	}
	
	

}
