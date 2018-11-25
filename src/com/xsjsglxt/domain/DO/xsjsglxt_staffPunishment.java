package com.xsjsglxt.domain.DO;

/*
 * @author 
 *       孙毅
 * @description
 *        警员处分情况类
 */
public class xsjsglxt_staffPunishment {
	private String xsjsglxt_staffPunishment_id;// 处分id
	private String staffPunishment_staff;
	private String staffPunishment_situation;// 处分情况
	private String staffPunishment_Time;// 处分时间
	private String staffPunishment_remarks;// 备注
	private String staffPunishment_gmt_create;
	private String staffPunishment_gmt_modified;

	@Override
	public String toString() {
		return "xsjsglxt_staffPunishment [xsjsglxt_staffPunishment_id=" + xsjsglxt_staffPunishment_id
				+ ", staffPunishment_staff=" + staffPunishment_staff + ", staffPunishment_situation="
				+ staffPunishment_situation + ", staffPunishment_Time=" + staffPunishment_Time
				+ ", staffPunishment_remarks=" + staffPunishment_remarks + ", staffPunishment_gmt_create="
				+ staffPunishment_gmt_create + ", staffPunishment_gmt_modified=" + staffPunishment_gmt_modified + "]";
	}

	public String getXsjsglxt_staffPunishment_id() {
		return xsjsglxt_staffPunishment_id;
	}

	public void setXsjsglxt_staffPunishment_id(String xsjsglxt_staffPunishment_id) {
		this.xsjsglxt_staffPunishment_id = xsjsglxt_staffPunishment_id;
	}

	public String getStaffPunishment_staff() {
		return staffPunishment_staff;
	}

	public void setStaffPunishment_staff(String staffPunishment_staff) {
		this.staffPunishment_staff = staffPunishment_staff;
	}

	public String getStaffPunishment_situation() {
		return staffPunishment_situation;
	}

	public void setStaffPunishment_situation(String staffPunishment_situation) {
		this.staffPunishment_situation = staffPunishment_situation;
	}

	public String getStaffPunishment_Time() {
		return staffPunishment_Time;
	}

	public void setStaffPunishment_Time(String staffPunishment_Time) {
		this.staffPunishment_Time = staffPunishment_Time;
	}

	public String getStaffPunishment_remarks() {
		return staffPunishment_remarks;
	}

	public void setStaffPunishment_remarks(String staffPunishment_remarks) {
		this.staffPunishment_remarks = staffPunishment_remarks;
	}

	public String getStaffPunishment_gmt_create() {
		return staffPunishment_gmt_create;
	}

	public void setStaffPunishment_gmt_create(String staffPunishment_gmt_create) {
		this.staffPunishment_gmt_create = staffPunishment_gmt_create;
	}

	public String getStaffPunishment_gmt_modified() {
		return staffPunishment_gmt_modified;
	}

	public void setStaffPunishment_gmt_modified(String staffPunishment_gmt_modified) {
		this.staffPunishment_gmt_modified = staffPunishment_gmt_modified;
	}

}
