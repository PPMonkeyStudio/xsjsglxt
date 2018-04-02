package com.xsjsglxt.domain.DO;

/*
 * @author 
 *       孙毅
 * @description
 *       警员休假情况表
 */
public class xsjsglxt_staffFurlough {
	private String xsjsglxt_staffFurlough_id;
	private String staffFurlough_staff;
	private String staffFurlough_mainContent;
	private String staffFurlough_startTime;
	private String staffFurlough_days;
	private String staffFurlough_whetherStop;
	private String staffFurlough_stopTime;
	private String staffFurlough_remarks;
	private String staffFurlough_gmt_create;
	private String staffFurlough_gmt_modified;

	@Override
	public String toString() {
		return "xsjsglxt_staffFurlough [xsjsglxt_staffFurlough_id=" + xsjsglxt_staffFurlough_id
				+ ", staffFurlough_staff=" + staffFurlough_staff + ", staffFurlough_mainContent="
				+ staffFurlough_mainContent + ", staffFurlough_startTime=" + staffFurlough_startTime
				+ ", staffFurlough_days=" + staffFurlough_days + ", staffFurlough_whetherStop="
				+ staffFurlough_whetherStop + ", staffFurlough_stopTime=" + staffFurlough_stopTime
				+ ", staffFurlough_remarks=" + staffFurlough_remarks + ", staffFurlough_gmt_create="
				+ staffFurlough_gmt_create + ", staffFurlough_gmt_modified=" + staffFurlough_gmt_modified + "]";
	}

	public String getXsjsglxt_staffFurlough_id() {
		return xsjsglxt_staffFurlough_id;
	}

	public void setXsjsglxt_staffFurlough_id(String xsjsglxt_staffFurlough_id) {
		this.xsjsglxt_staffFurlough_id = xsjsglxt_staffFurlough_id;
	}

	public String getStaffFurlough_staff() {
		return staffFurlough_staff;
	}

	public void setStaffFurlough_staff(String staffFurlough_staff) {
		this.staffFurlough_staff = staffFurlough_staff;
	}

	public String getStaffFurlough_mainContent() {
		return staffFurlough_mainContent;
	}

	public void setStaffFurlough_mainContent(String staffFurlough_mainContent) {
		this.staffFurlough_mainContent = staffFurlough_mainContent;
	}

	public String getStaffFurlough_startTime() {
		return staffFurlough_startTime;
	}

	public void setStaffFurlough_startTime(String staffFurlough_startTime) {
		this.staffFurlough_startTime = staffFurlough_startTime;
	}

	public String getStaffFurlough_days() {
		return staffFurlough_days;
	}

	public void setStaffFurlough_days(String staffFurlough_days) {
		this.staffFurlough_days = staffFurlough_days;
	}

	public String getStaffFurlough_whetherStop() {
		return staffFurlough_whetherStop;
	}

	public void setStaffFurlough_whetherStop(String staffFurlough_whetherStop) {
		this.staffFurlough_whetherStop = staffFurlough_whetherStop;
	}

	public String getStaffFurlough_stopTime() {
		return staffFurlough_stopTime;
	}

	public void setStaffFurlough_stopTime(String staffFurlough_stopTime) {
		this.staffFurlough_stopTime = staffFurlough_stopTime;
	}

	public String getStaffFurlough_remarks() {
		return staffFurlough_remarks;
	}

	public void setStaffFurlough_remarks(String staffFurlough_remarks) {
		this.staffFurlough_remarks = staffFurlough_remarks;
	}

	public String getStaffFurlough_gmt_create() {
		return staffFurlough_gmt_create;
	}

	public void setStaffFurlough_gmt_create(String staffFurlough_gmt_create) {
		this.staffFurlough_gmt_create = staffFurlough_gmt_create;
	}

	public String getStaffFurlough_gmt_modified() {
		return staffFurlough_gmt_modified;
	}

	public void setStaffFurlough_gmt_modified(String staffFurlough_gmt_modified) {
		this.staffFurlough_gmt_modified = staffFurlough_gmt_modified;
	}

}
