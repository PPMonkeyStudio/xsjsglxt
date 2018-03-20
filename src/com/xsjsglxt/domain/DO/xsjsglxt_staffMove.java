package com.xsjsglxt.domain.DO;

/*
 * @author 
 *       孙毅
 * @description 
 *       警员工作调动表
 */
public class xsjsglxt_staffMove {
	private String xsjsglxt_staffMove_id;
	private String staffMove_staff;
	private String staffMove_inTime;
	private String staffMove_outTime;
	private String staffMove_guard;
	private String staffMove_remarks;
	private String staffMove_gmt_create;
	private String staffMove_gmt_modified;

	@Override
	public String toString() {
		return "xsjsglxt_staffMove [xsjsglxt_staffMove_id=" + xsjsglxt_staffMove_id + ", staffMove_staff="
				+ staffMove_staff + ", staffMove_inTime=" + staffMove_inTime + ", staffMove_outTime="
				+ staffMove_outTime + ", staffMove_guard=" + staffMove_guard + ", staffMove_remarks="
				+ staffMove_remarks + ", staffMove_gmt_create=" + staffMove_gmt_create + ", staffMove_gmt_modified="
				+ staffMove_gmt_modified + "]";
	}

	public String getXsjsglxt_staffMove_id() {
		return xsjsglxt_staffMove_id;
	}

	public void setXsjsglxt_staffMove_id(String xsjsglxt_staffMove_id) {
		this.xsjsglxt_staffMove_id = xsjsglxt_staffMove_id;
	}

	public String getStaffMove_staff() {
		return staffMove_staff;
	}

	public void setStaffMove_staff(String staffMove_staff) {
		this.staffMove_staff = staffMove_staff;
	}

	public String getStaffMove_inTime() {
		return staffMove_inTime;
	}

	public void setStaffMove_inTime(String staffMove_inTime) {
		this.staffMove_inTime = staffMove_inTime;
	}

	public String getStaffMove_outTime() {
		return staffMove_outTime;
	}

	public void setStaffMove_outTime(String staffMove_outTime) {
		this.staffMove_outTime = staffMove_outTime;
	}

	public String getStaffMove_guard() {
		return staffMove_guard;
	}

	public void setStaffMove_guard(String staffMove_guard) {
		this.staffMove_guard = staffMove_guard;
	}

	public String getStaffMove_remarks() {
		return staffMove_remarks;
	}

	public void setStaffMove_remarks(String staffMove_remarks) {
		this.staffMove_remarks = staffMove_remarks;
	}

	public String getStaffMove_gmt_create() {
		return staffMove_gmt_create;
	}

	public void setStaffMove_gmt_create(String staffMove_gmt_create) {
		this.staffMove_gmt_create = staffMove_gmt_create;
	}

	public String getStaffMove_gmt_modified() {
		return staffMove_gmt_modified;
	}

	public void setStaffMove_gmt_modified(String staffMove_gmt_modified) {
		this.staffMove_gmt_modified = staffMove_gmt_modified;
	}
}
