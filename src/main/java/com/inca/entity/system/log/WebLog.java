package com.inca.entity.system.log;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.inca.entity.BaseEntity;
@Component
public class WebLog extends BaseEntity {

	private static final long serialVersionUID = 855661552801488671L;
	private Integer id ;
   // @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	private Date accessTime;//访问时间
	private Integer webType;//访问类型
	private String url;//访问地址
	private String methodPath;
	private String methodName;
	private String ip;//访问者ip
	private String args;//访问参数
	private boolean result;//结果成功or失败
	private String msg;//访问信息
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Date getAccessTime() {
		return accessTime;
	}
	public void setAccessTime(Date accessTime) {
		this.accessTime = accessTime;
	}
	public Integer getWebType() {
		return webType;
	}
	public void setWebType(Integer webType) {
		this.webType = webType;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getArgs() {
		return args;
	}
	public void setArgs(String args) {
		this.args = args;
	}
	public boolean isResult() {
		return result;
	}
	public void setResult(boolean result) {
		this.result = result;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public String getMethodPath() {
		return methodPath;
	}
	public void setMethodPath(String methodPath) {
		this.methodPath = methodPath;
	}
	public String getMethodName() {
		return methodName;
	}
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public String toString() {
		return "WebLog [id=" + id + ", accessTime=" + accessTime + ", webType=" + webType + ", methodPath=" + methodPath
				+ ", methodName=" + methodName + ", ip=" + ip + ", args=" + args + ", result=" + result + ", msg=" + msg
				+ "]";
	}
	
	
	
}
