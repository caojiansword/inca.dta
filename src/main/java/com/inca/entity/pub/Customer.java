package com.inca.entity.pub;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.inca.entity.BaseEntity;
import com.inca.utils.excel.ExcelVOAttribute;
@Component
@Table(name="pub_customer")
public class Customer extends BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7413903709562215395L;
	
	private Integer id;
	@ExcelVOAttribute(name="客户名称",column="A")
	private String customerName;
	@ExcelVOAttribute(name="客户编码",column="B")
	private String customerCode;
	@ExcelVOAttribute(name="客户域名",column="C")
	private String domain;
	private Integer type;
	@ExcelVOAttribute(name="组织机构编码",column="H")
	private String orgCode;
	
	private Integer status;
	@ExcelVOAttribute(name="联系方式",column="E")
	private String phoneNo;
	
	private Date onlineDate;
	private Date stopDate;
	
	
	
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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public Date getOnlineDate() {
		return onlineDate;
	}

	public void setOnlineDate(Date onlineDate) {
		this.onlineDate = onlineDate;
	}

	public Date getStopDate() {
		return stopDate;
	}

	public void setStopDate(Date stopDate) {
		this.stopDate = stopDate;
	}

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", customerName=" + customerName + ", customerCode=" + customerCode + ", domain="
				+ domain + ", type=" + type + "]";
	}
	
	

}
