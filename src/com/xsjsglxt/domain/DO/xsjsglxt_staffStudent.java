package com.xsjsglxt.domain.DO;

/*
 * @author
 *      孙毅
 * @description
 *      警员学习经历类
 */
public class xsjsglxt_staffStudent {
	private String xsjsglxt_staffStudent_id;
	private String staffStudent_staff;
	private String staffStudent_evection; // 出差还是学习
	private String staffStudent_address;
	private String staffStudent_startTime;
	private String staffStudent_stopTime;
	private String staffStudent_remarks;
	private String staffStudent_gmt_create;
	private String staffStudent_gmt_modified;

	@Override
	public String toString() {
		return "xsjsglxt_staffStudent [xsjsglxt_staffStudent_id=" + xsjsglxt_staffStudent_id + ", staffStudent_staff="
				+ staffStudent_staff + ", staffStudent_address=" + staffStudent_address + ", staffStudent_startTime="
				+ staffStudent_startTime + ", staffStudent_stopTime=" + staffStudent_stopTime
				+ ", staffStudent_remarks=" + staffStudent_remarks + ", staffStudent_gmt_create="
				+ staffStudent_gmt_create + ", staffStudent_gmt_modified=" + staffStudent_gmt_modified + "]";
	}

	public String getXsjsglxt_staffStudent_id() {
		return xsjsglxt_staffStudent_id;
	}

	public void setXsjsglxt_staffStudent_id(String xsjsglxt_staffStudent_id) {
		this.xsjsglxt_staffStudent_id = xsjsglxt_staffStudent_id;
	}

	public String getStaffStudent_staff() {
		return staffStudent_staff;
	}

	public void setStaffStudent_staff(String staffStudent_staff) {
		this.staffStudent_staff = staffStudent_staff;
	}

	public String getStaffStudent_evection() {
		return staffStudent_evection;
	}

	public void setStaffStudent_evection(String staffStudent_evection) {
		this.staffStudent_evection = staffStudent_evection;
	}

	public String getStaffStudent_address() {
		return staffStudent_address;
	}

	public void setStaffStudent_address(String staffStudent_address) {
		this.staffStudent_address = staffStudent_address;
	}

	public String getStaffStudent_startTime() {
		return staffStudent_startTime;
	}

	public void setStaffStudent_startTime(String staffStudent_startTime) {
		this.staffStudent_startTime = staffStudent_startTime;
	}

	public String getStaffStudent_stopTime() {
		return staffStudent_stopTime;
	}

	public void setStaffStudent_stopTime(String staffStudent_stopTime) {
		this.staffStudent_stopTime = staffStudent_stopTime;
	}

	public String getStaffStudent_remarks() {
		return staffStudent_remarks;
	}

	public void setStaffStudent_remarks(String staffStudent_remarks) {
		this.staffStudent_remarks = staffStudent_remarks;
	}

	public String getStaffStudent_gmt_create() {
		return staffStudent_gmt_create;
	}

	public void setStaffStudent_gmt_create(String staffStudent_gmt_create) {
		this.staffStudent_gmt_create = staffStudent_gmt_create;
	}

	public String getStaffStudent_gmt_modified() {
		return staffStudent_gmt_modified;
	}

	public void setStaffStudent_gmt_modified(String staffStudent_gmt_modified) {
		this.staffStudent_gmt_modified = staffStudent_gmt_modified;
	}
}
