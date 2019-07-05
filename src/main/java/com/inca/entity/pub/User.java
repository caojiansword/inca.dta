package com.inca.entity.pub;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import com.inca.entity.BaseEntity;
@Component
public class User extends BaseEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1772078449608288841L;
	
	private Integer id ;
	
	private String userName;
	
	private String password;
	
	private String userCode;
	
	private String phone;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", password=" + password + ", userCode=" + userCode
				+ ", phone=" + phone + "]";
	}
	
	
	

}
