package com.xsjsglxt.domain.DO;

/*
 * @author 
 *       孙毅
 * @description
 *       警员违纪情况类
 */
public class xsjsglxt_staffPrinciple {
	private String xsjsglxt_staffPrinciple_id;
	private String staffPrinciple_staff;
	private String staffPrinciple_situation;
	private String staffPrinciple_Time;
	private String staffPrinciple_remarks;
	private String staffPrinciple_gmt_create;
	private String staffPrinciple_gmt_modified;

	@Override
	public String toString() {
		return "xsjsglxt_staffPrinciple [xsjsglxt_staffPrinciple_id=" + xsjsglxt_staffPrinciple_id
				+ ", staffPrinciple_staff=" + staffPrinciple_staff + ", staffPrinciple_situation="
				+ staffPrinciple_situation + ", staffPrinciple_Time=" + staffPrinciple_Time
				+ ", staffPrinciple_remarks=" + staffPrinciple_remarks + ", staffPrinciple_gmt_create="
				+ staffPrinciple_gmt_create + ", staffPrinciple_gmt_modified=" + staffPrinciple_gmt_modified + "]";
	}

	public String getXsjsglxt_staffPrinciple_id() {
		return xsjsglxt_staffPrinciple_id;
	}

	public void setXsjsglxt_staffPrinciple_id(String xsjsglxt_staffPrinciple_id) {
		this.xsjsglxt_staffPrinciple_id = xsjsglxt_staffPrinciple_id;
	}

	public String getStaffPrinciple_staff() {
		return staffPrinciple_staff;
	}

	public void setStaffPrinciple_staff(String staffPrinciple_staff) {
		this.staffPrinciple_staff = staffPrinciple_staff;
	}

	public String getStaffPrinciple_situation() {
		return staffPrinciple_situation;
	}

	public void setStaffPrinciple_situation(String staffPrinciple_situation) {
		this.staffPrinciple_situation = staffPrinciple_situation;
	}

	public String getStaffPrinciple_Time() {
		return staffPrinciple_Time;
	}

	public void setStaffPrinciple_Time(String staffPrinciple_Time) {
		this.staffPrinciple_Time = staffPrinciple_Time;
	}

	public String getStaffPrinciple_remarks() {
		return staffPrinciple_remarks;
	}

	public void setStaffPrinciple_remarks(String staffPrinciple_remarks) {
		this.staffPrinciple_remarks = staffPrinciple_remarks;
	}

	public String getStaffPrinciple_gmt_create() {
		return staffPrinciple_gmt_create;
	}

	public void setStaffPrinciple_gmt_create(String staffPrinciple_gmt_create) {
		this.staffPrinciple_gmt_create = staffPrinciple_gmt_create;
	}

	public String getStaffPrinciple_gmt_modified() {
		return staffPrinciple_gmt_modified;
	}

	public void setStaffPrinciple_gmt_modified(String staffPrinciple_gmt_modified) {
		this.staffPrinciple_gmt_modified = staffPrinciple_gmt_modified;
	}
}
