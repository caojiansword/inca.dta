package com.inca.entity.system.log.vo;

import org.springframework.stereotype.Component;

import com.inca.entity.system.log.WebLog;
@Component
public class WebLogVo extends WebLog {
	public String keyword;

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	
}
