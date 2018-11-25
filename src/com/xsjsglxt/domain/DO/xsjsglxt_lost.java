package com.xsjsglxt.domain.DO;

/**
 * 
 * @author 孙毅
 *修改时间： 2018-04-22
 */
public class xsjsglxt_lost {

	private String xsjsglxt_lost_id;// 损失物品ID

	private String lost_case;// 所属案件

	private String lost_name;// 名称

	private String lost_model;// 型号

	private String lost_number;// 丢失数量

	private String lost_price;// 价值

	private String lost_remarks;// 特征描述

	private String lost_gmt_create;// 创建时间

	private String lost_gmt_modified;// 修改时间

	public xsjsglxt_lost() {

		// TODO Auto-generated constructor stub
	}

	public xsjsglxt_lost(String xsjsglxt_lost_id, String lost_case, String lost_name, String lost_remarks,
			String lost_gmt_create, String lost_gmt_modified) {

		this.xsjsglxt_lost_id = xsjsglxt_lost_id;
		this.lost_case = lost_case;
		this.lost_name = lost_name;
		this.lost_remarks = lost_remarks;
		this.lost_gmt_create = lost_gmt_create;
		this.lost_gmt_modified = lost_gmt_modified;
	}

	@Override
	public String toString() {
		return "lost [xsjsglxt_lost_id=" + xsjsglxt_lost_id + ", lost_case=" + lost_case + ", lost_name=" + lost_name
				+ ", lost_remarks=" + lost_remarks + ", lost_gmt_create=" + lost_gmt_create + ", lost_gmt_modified="
				+ lost_gmt_modified + "]";
	}

	public String getXsjsglxt_lost_id() {
		return xsjsglxt_lost_id;
	}

	public void setXsjsglxt_lost_id(String xsjsglxt_lost_id) {
		this.xsjsglxt_lost_id = xsjsglxt_lost_id;
	}

	public String getLost_model() {
		return lost_model;
	}

	public void setLost_model(String lost_model) {
		this.lost_model = lost_model;
	}

	public String getLost_number() {
		return lost_number;
	}

	public void setLost_number(String lost_number) {
		this.lost_number = lost_number;
	}

	public String getLost_price() {
		return lost_price;
	}

	public void setLost_price(String lost_price) {
		this.lost_price = lost_price;
	}

	public String getLost_case() {
		return lost_case;
	}

	public void setLost_case(String lost_case) {
		this.lost_case = lost_case;
	}

	public String getLost_name() {
		return lost_name;
	}

	public void setLost_name(String lost_name) {
		this.lost_name = lost_name;
	}

	public String getLost_remarks() {
		return lost_remarks;
	}

	public void setLost_remarks(String lost_remarks) {
		this.lost_remarks = lost_remarks;
	}

	public String getLost_gmt_create() {
		return lost_gmt_create;
	}

	public void setLost_gmt_create(String lost_gmt_create) {
		this.lost_gmt_create = lost_gmt_create;
	}

	public String getLost_gmt_modified() {
		return lost_gmt_modified;
	}

	public void setLost_gmt_modified(String lost_gmt_modified) {
		this.lost_gmt_modified = lost_gmt_modified;
	}

}
