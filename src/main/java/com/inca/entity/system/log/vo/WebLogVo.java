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
	Integer webType;
	String accessTimeFrom;
	String accessTimeTo;
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
	public Integer getWebType() {
		return webType;
	}
	public void setWebType(Integer webType) {
		this.webType = webType;
	}
	public String getAccessTimeFrom() {
		return accessTimeFrom;
	}
	public void setAccessTimeFrom(String accessTimeFrom) {
		this.accessTimeFrom = accessTimeFrom;
	}
	public String getAccessTimeTo() {
		return accessTimeTo;
	}
	public void setAccessTimeTo(String accessTimeTo) {
		this.accessTimeTo = accessTimeTo;
	}
	
	
	
}
