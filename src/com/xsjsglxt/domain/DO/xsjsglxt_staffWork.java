package com.xsjsglxt.domain.DO;

/*
 * @author 
 *       孙毅
 * @description
 *       警员工作经历类
 */
public class xsjsglxt_staffWork {
	private String xsjsglxt_staffWork_id;
	private String staffWork_staff;
	private String staffWork_address;
	private String staffWork_duty;
	private String staffWork_startTime;
	private String staffWork_stopTime;
	private String staffWork_remarks;
	private String staffWork_gmt_create;
	private String staffWork_gmt_modified;

	@Override
	public String toString() {
		return "xsjsglxt_staffWork [xsjsglxt_staffWork_id=" + xsjsglxt_staffWork_id + ", staffWork_staff="
				+ staffWork_staff + ", staffWork_address=" + staffWork_address + ", staffWork_duty=" + staffWork_duty
				+ ", staffWork_startTime=" + staffWork_startTime + ", staffWork_stopTime=" + staffWork_stopTime
				+ ", staffWork_remarks=" + staffWork_remarks + ", staffWork_gmt_create=" + staffWork_gmt_create
				+ ", staffWork_gmt_modified=" + staffWork_gmt_modified + "]";
	}

	public String getXsjsglxt_staffWork_id() {
		return xsjsglxt_staffWork_id;
	}

	public void setXsjsglxt_staffWork_id(String xsjsglxt_staffWork_id) {
		this.xsjsglxt_staffWork_id = xsjsglxt_staffWork_id;
	}

	public String getStaffWork_staff() {
		return staffWork_staff;
	}

	public void setStaffWork_staff(String staffWork_staff) {
		this.staffWork_staff = staffWork_staff;
	}

	public String getStaffWork_address() {
		return staffWork_address;
	}

	public void setStaffWork_address(String staffWork_address) {
		this.staffWork_address = staffWork_address;
	}

	public String getStaffWork_duty() {
		return staffWork_duty;
	}

	public void setStaffWork_duty(String staffWork_duty) {
		this.staffWork_duty = staffWork_duty;
	}

	public String getStaffWork_startTime() {
		return staffWork_startTime;
	}

	public void setStaffWork_startTime(String staffWork_startTime) {
		this.staffWork_startTime = staffWork_startTime;
	}

	public String getStaffWork_stopTime() {
		return staffWork_stopTime;
	}

	public void setStaffWork_stopTime(String staffWork_stopTime) {
		this.staffWork_stopTime = staffWork_stopTime;
	}

	public String getStaffWork_remarks() {
		return staffWork_remarks;
	}

	public void setStaffWork_remarks(String staffWork_remarks) {
		this.staffWork_remarks = staffWork_remarks;
	}

	public String getStaffWork_gmt_create() {
		return staffWork_gmt_create;
	}

	public void setStaffWork_gmt_create(String staffWork_gmt_create) {
		this.staffWork_gmt_create = staffWork_gmt_create;
	}

	public String getStaffWork_gmt_modified() {
		return staffWork_gmt_modified;
	}

	public void setStaffWork_gmt_modified(String staffWork_gmt_modified) {
		this.staffWork_gmt_modified = staffWork_gmt_modified;
	}
}
