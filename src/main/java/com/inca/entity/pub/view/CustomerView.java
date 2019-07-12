package com.inca.entity.pub.view;

import com.inca.entity.pub.Customer;

public class CustomerView extends Customer {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6433891937639353205L;
	private String typeView;
    private String statusView;
    private String stopDateView;
    private String onLineDateView;
    private String createTimeView;
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
	public String getStopDateView() {
		return stopDateView;
	}
	public void setStopDateView(String stopDateView) {
		this.stopDateView = stopDateView;
	}
	public String getOnLineDateView() {
		return onLineDateView;
	}
	public void setOnLineDateView(String onLineDateView) {
		this.onLineDateView = onLineDateView;
	}
	public String getCreateTimeView() {
		return createTimeView;
	}
	public void setCreateTimeView(String createTimeView) {
		this.createTimeView = createTimeView;
	}
    
}
