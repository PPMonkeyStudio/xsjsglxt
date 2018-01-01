package com.xsjsglxt.domain.DO;

public class xsjsglxt_lost_mobilephone {
	
private String xsjsglxt_lost_mobilephone_id;//损失手机ID

private String lost_mobilephone_case;//所属案件

private String lost_mobilephone_phone;//手机号码

private String lost_mobilephone_IMEI;//手机串号

private String lost_mobilephone_feature;//手机特征

private String lost_mobilephone_remarks;//备注

private String lost_mobilephone_gmt_create;//创建时间

private String lost_mobilephone_gmt_modified;//修改时间

public xsjsglxt_lost_mobilephone() {

	// TODO Auto-generated constructor stub
}

public xsjsglxt_lost_mobilephone(String xsjsglxt_lost_mobilephone_id, String lost_mobilephone_case,
		String lost_mobilephone_phone, String lost_mobilephone_IMEI, String lost_mobilephone_feature,
		String lost_mobilephone_remarks, String lost_mobilephone_gmt_create, String lost_mobilephone_gmt_modified) {

	this.xsjsglxt_lost_mobilephone_id = xsjsglxt_lost_mobilephone_id;
	this.lost_mobilephone_case = lost_mobilephone_case;
	this.lost_mobilephone_phone = lost_mobilephone_phone;
	this.lost_mobilephone_IMEI = lost_mobilephone_IMEI;
	this.lost_mobilephone_feature = lost_mobilephone_feature;
	this.lost_mobilephone_remarks = lost_mobilephone_remarks;
	this.lost_mobilephone_gmt_create = lost_mobilephone_gmt_create;
	this.lost_mobilephone_gmt_modified = lost_mobilephone_gmt_modified;
}

@Override
public String toString() {
	return "lost_mobilephone [xsjsglxt_lost_mobilephone_id=" + xsjsglxt_lost_mobilephone_id + ", lost_mobilephone_case="
			+ lost_mobilephone_case + ", lost_mobilephone_phone=" + lost_mobilephone_phone + ", lost_mobilephone_IMEI="
			+ lost_mobilephone_IMEI + ", lost_mobilephone_feature=" + lost_mobilephone_feature
			+ ", lost_mobilephone_remarks=" + lost_mobilephone_remarks + ", lost_mobilephone_gmt_create="
			+ lost_mobilephone_gmt_create + ", lost_mobilephone_gmt_modified=" + lost_mobilephone_gmt_modified + "]";
}

public String getXsjsglxt_lost_mobilephone_id() {
	return xsjsglxt_lost_mobilephone_id;
}

public void setXsjsglxt_lost_mobilephone_id(String xsjsglxt_lost_mobilephone_id) {
	this.xsjsglxt_lost_mobilephone_id = xsjsglxt_lost_mobilephone_id;
}

public String getLost_mobilephone_case() {
	return lost_mobilephone_case;
}

public void setLost_mobilephone_case(String lost_mobilephone_case) {
	this.lost_mobilephone_case = lost_mobilephone_case;
}

public String getLost_mobilephone_phone() {
	return lost_mobilephone_phone;
}

public void setLost_mobilephone_phone(String lost_mobilephone_phone) {
	this.lost_mobilephone_phone = lost_mobilephone_phone;
}

public String getLost_mobilephone_IMEI() {
	return lost_mobilephone_IMEI;
}

public void setLost_mobilephone_IMEI(String lost_mobilephone_IMEI) {
	this.lost_mobilephone_IMEI = lost_mobilephone_IMEI;
}

public String getLost_mobilephone_feature() {
	return lost_mobilephone_feature;
}

public void setLost_mobilephone_feature(String lost_mobilephone_feature) {
	this.lost_mobilephone_feature = lost_mobilephone_feature;
}

public String getLost_mobilephone_remarks() {
	return lost_mobilephone_remarks;
}

public void setLost_mobilephone_remarks(String lost_mobilephone_remarks) {
	this.lost_mobilephone_remarks = lost_mobilephone_remarks;
}

public String getLost_mobilephone_gmt_create() {
	return lost_mobilephone_gmt_create;
}

public void setLost_mobilephone_gmt_create(String lost_mobilephone_gmt_create) {
	this.lost_mobilephone_gmt_create = lost_mobilephone_gmt_create;
}

public String getLost_mobilephone_gmt_modified() {
	return lost_mobilephone_gmt_modified;
}

public void setLost_mobilephone_gmt_modified(String lost_mobilephone_gmt_modified) {
	this.lost_mobilephone_gmt_modified = lost_mobilephone_gmt_modified;
}


}
