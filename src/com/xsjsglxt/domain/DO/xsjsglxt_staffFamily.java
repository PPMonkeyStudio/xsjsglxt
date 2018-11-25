package com.xsjsglxt.domain.DO;

/*
 * @author 
 *       孙毅
 * @description
 *       警员家庭成员信息
 */
public class xsjsglxt_staffFamily {
	private String xsjsglxt_staffFamily_id;// 家庭成员id
	private String staffFamily_staff;// 所属警员
	private String staffFamily_contactsRelationship;// 关系
	private String staffFamily_name;// 名字
	private String staffFamily_IDcard;// 身份证号码
	private String staffFamily_birthday;// 出生日期
	private String staffFamily_tel;// 手机号码
	private String staffFamily_WeiXin;// 微信号
	private String staffFamily_workSpace;// 工作地点
	private String staffFamily_duty;// 职务
	private String staffFamily_remarks;// 备注
	private String staffFamily_gmt_create;
	private String staffFamily_gmt_modified;

	@Override
	public String toString() {
		return "xsjsglxt_staffFamily [xsjsglxt_staffFamily_id=" + xsjsglxt_staffFamily_id + ", staffFamily_staff="
				+ staffFamily_staff + ", staffFamily_contactsRelationship=" + staffFamily_contactsRelationship
				+ ", staffFamily_name=" + staffFamily_name + ", staffFamily_IDcard=" + staffFamily_IDcard
				+ ", staffFamily_birthday=" + staffFamily_birthday + ", staffFamily_tel=" + staffFamily_tel
				+ ", staffFamily_WeiXin=" + staffFamily_WeiXin + ", staffFamily_workSpace=" + staffFamily_workSpace
				+ ", staffFamily_duty=" + staffFamily_duty + ", staffFamily_remarks=" + staffFamily_remarks
				+ ", staffFamily_gmt_create=" + staffFamily_gmt_create + ", staffFamily_gmt_modified="
				+ staffFamily_gmt_modified + "]";
	}

	public String getXsjsglxt_staffFamily_id() {
		return xsjsglxt_staffFamily_id;
	}

	public void setXsjsglxt_staffFamily_id(String xsjsglxt_staffFamily_id) {
		this.xsjsglxt_staffFamily_id = xsjsglxt_staffFamily_id;
	}

	public String getStaffFamily_staff() {
		return staffFamily_staff;
	}

	public void setStaffFamily_staff(String staffFamily_staff) {
		this.staffFamily_staff = staffFamily_staff;
	}

	public String getStaffFamily_contactsRelationship() {
		return staffFamily_contactsRelationship;
	}

	public void setStaffFamily_contactsRelationship(String staffFamily_contactsRelationship) {
		this.staffFamily_contactsRelationship = staffFamily_contactsRelationship;
	}

	public String getStaffFamily_name() {
		return staffFamily_name;
	}

	public void setStaffFamily_name(String staffFamily_name) {
		this.staffFamily_name = staffFamily_name;
	}

	public String getStaffFamily_IDcard() {
		return staffFamily_IDcard;
	}

	public void setStaffFamily_IDcard(String staffFamily_IDcard) {
		this.staffFamily_IDcard = staffFamily_IDcard;
	}

	public String getStaffFamily_birthday() {
		return staffFamily_birthday;
	}

	public void setStaffFamily_birthday(String staffFamily_birthday) {
		this.staffFamily_birthday = staffFamily_birthday;
	}

	public String getStaffFamily_tel() {
		return staffFamily_tel;
	}

	public void setStaffFamily_tel(String staffFamily_tel) {
		this.staffFamily_tel = staffFamily_tel;
	}

	public String getStaffFamily_WeiXin() {
		return staffFamily_WeiXin;
	}

	public void setStaffFamily_WeiXin(String staffFamily_WeiXin) {
		this.staffFamily_WeiXin = staffFamily_WeiXin;
	}

	public String getStaffFamily_workSpace() {
		return staffFamily_workSpace;
	}

	public void setStaffFamily_workSpace(String staffFamily_workSpace) {
		this.staffFamily_workSpace = staffFamily_workSpace;
	}

	public String getStaffFamily_duty() {
		return staffFamily_duty;
	}

	public void setStaffFamily_duty(String staffFamily_duty) {
		this.staffFamily_duty = staffFamily_duty;
	}

	public String getStaffFamily_remarks() {
		return staffFamily_remarks;
	}

	public void setStaffFamily_remarks(String staffFamily_remarks) {
		this.staffFamily_remarks = staffFamily_remarks;
	}

	public String getStaffFamily_gmt_create() {
		return staffFamily_gmt_create;
	}

	public void setStaffFamily_gmt_create(String staffFamily_gmt_create) {
		this.staffFamily_gmt_create = staffFamily_gmt_create;
	}

	public String getStaffFamily_gmt_modified() {
		return staffFamily_gmt_modified;
	}

	public void setStaffFamily_gmt_modified(String staffFamily_gmt_modified) {
		this.staffFamily_gmt_modified = staffFamily_gmt_modified;
	}
}
