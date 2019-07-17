package com.inca.entity.system.log.vo;

import org.springframework.stereotype.Component;

import com.inca.base.BaseQuery;
@Component
public class WebLogVo extends BaseQuery {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3475610090961921989L;
	
	String methodName;
	String ip;
	
	public String getMethodName() {
		return methodName;
	}
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	
	
	
}
