package com.inca.entity.system.log.view;

import org.springframework.stereotype.Component;

import com.inca.entity.system.log.WebLog;
@Component
public class WebLogView extends WebLog {
	private static final long serialVersionUID = -2902856027645312346L;
	String webTypeView;
	String resultView;
	public String getWebTypeView() {
		return webTypeView;
	}
	public void setWebTypeView(String webTypeView) {
		this.webTypeView = webTypeView;
	}
	public String getResultView() {
		return resultView;
	}
	public void setResultView(String resultView) {
		this.resultView = resultView;
	}
	
	@Override
	public String toString() {
		return "WebLogView [webTypeView=" + webTypeView + ", resultView=" + resultView + "]";
	}

}
