package com.inca.entity.pub.view;

import com.inca.entity.pub.Customer;

public class CustomerView extends Customer {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6433891937639353205L;
	private String typeView;
    private String statusView;
	public String getTypeView() {
		return typeView;
	}
	public void setTypeView(String typeView) {
		this.typeView = typeView;
	}
	public String getStatusView() {
		return statusView;
	}
	public void setStatusView(String statusView) {
		this.statusView = statusView;
	}
    
}
