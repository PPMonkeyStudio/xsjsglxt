package com.xsjsglxt.domain.DO;

/**
 * 
 * @author 孙毅
 * 	经费表
 */
public class xsjsglxt_expenditure {
	private String expenditure_id; // 经费id
	private String expenditure_name; // 经费报账人
	private String expenditure_type; // 报销经费种类
	private String expenditure_time;// 报账时间
	private String expenditure_detachment;// 所属中队
	private String expenditure_money;// 保障金额（元）
	private String expenditure_gmt_create;
	private String expenditure_gmt_modified;

	public String getExpenditure_id() {
		return expenditure_id;
	}

	public void setExpenditure_id(String expenditure_id) {
		this.expenditure_id = expenditure_id;
	}

	public String getExpenditure_name() {
		return expenditure_name;
	}

	public void setExpenditure_name(String expenditure_name) {
		this.expenditure_name = expenditure_name;
	}

	public String getExpenditure_type() {
		return expenditure_type;
	}

	public void setExpenditure_type(String expenditure_type) {
		this.expenditure_type = expenditure_type;
	}

	public String getExpenditure_time() {
		return expenditure_time;
	}

	public void setExpenditure_time(String expenditure_time) {
		this.expenditure_time = expenditure_time;
	}

	public String getExpenditure_detachment() {
		return expenditure_detachment;
	}

	public void setExpenditure_detachment(String expenditure_detachment) {
		this.expenditure_detachment = expenditure_detachment;
	}

	public String getExpenditure_money() {
		return expenditure_money;
	}

	public void setExpenditure_money(String expenditure_money) {
		this.expenditure_money = expenditure_money;
	}

	public String getExpenditure_gmt_create() {
		return expenditure_gmt_create;
	}

	public void setExpenditure_gmt_create(String expenditure_gmt_create) {
		this.expenditure_gmt_create = expenditure_gmt_create;
	}

	public String getExpenditure_gmt_modified() {
		return expenditure_gmt_modified;
	}

	public void setExpenditure_gmt_modified(String expenditure_gmt_modified) {
		this.expenditure_gmt_modified = expenditure_gmt_modified;
	}

}
