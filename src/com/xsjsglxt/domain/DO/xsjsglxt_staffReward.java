package com.xsjsglxt.domain.DO;

/*
 * @author 
 *       孙毅
 * @description
 *       警员立功获奖情况表
 */
public class xsjsglxt_staffReward {
	private String xsjsglxt_staffReward_id;
	private String staffReward_staff;
	private String staffReward_situation;
	private String staffReward_Time;
	private String staffReward_remarks;
	private String staffReward_gmt_create;
	private String staffReward_gmt_modified;

	@Override
	public String toString() {
		return "xsjsglxt_staffReward [xsjsglxt_staffReward_id=" + xsjsglxt_staffReward_id + ", staffReward_staff="
				+ staffReward_staff + ", staffReward_situation=" + staffReward_situation + ", staffReward_Time="
				+ staffReward_Time + ", staffReward_remarks=" + staffReward_remarks + ", staffReward_gmt_create="
				+ staffReward_gmt_create + ", staffReward_gmt_modified=" + staffReward_gmt_modified + "]";
	}

	public String getXsjsglxt_staffReward_id() {
		return xsjsglxt_staffReward_id;
	}

	public void setXsjsglxt_staffReward_id(String xsjsglxt_staffReward_id) {
		this.xsjsglxt_staffReward_id = xsjsglxt_staffReward_id;
	}

	public String getStaffReward_staff() {
		return staffReward_staff;
	}

	public void setStaffReward_staff(String staffReward_staff) {
		this.staffReward_staff = staffReward_staff;
	}

	public String getStaffReward_situation() {
		return staffReward_situation;
	}

	public void setStaffReward_situation(String staffReward_situation) {
		this.staffReward_situation = staffReward_situation;
	}

	public String getStaffReward_Time() {
		return staffReward_Time;
	}

	public void setStaffReward_Time(String staffReward_Time) {
		this.staffReward_Time = staffReward_Time;
	}

	public String getStaffReward_remarks() {
		return staffReward_remarks;
	}

	public void setStaffReward_remarks(String staffReward_remarks) {
		this.staffReward_remarks = staffReward_remarks;
	}

	public String getStaffReward_gmt_create() {
		return staffReward_gmt_create;
	}

	public void setStaffReward_gmt_create(String staffReward_gmt_create) {
		this.staffReward_gmt_create = staffReward_gmt_create;
	}

	public String getStaffReward_gmt_modified() {
		return staffReward_gmt_modified;
	}

	public void setStaffReward_gmt_modified(String staffReward_gmt_modified) {
		this.staffReward_gmt_modified = staffReward_gmt_modified;
	}
}
