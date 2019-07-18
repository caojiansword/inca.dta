package com.inca.entity.pub.view;

import org.springframework.stereotype.Component;

import com.inca.entity.pub.Customer;
import com.inca.utils.excel.ExcelVOAttribute;
@Component
public class CustomerView extends Customer {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6433891937639353205L;
	@ExcelVOAttribute(name="客户类型",column="D")
	private String typeView;
    private String statusView;
	@ExcelVOAttribute(name="停用日期",column="G")
    private String stopDateView;
    @ExcelVOAttribute(name="启用日期",column="F")
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
