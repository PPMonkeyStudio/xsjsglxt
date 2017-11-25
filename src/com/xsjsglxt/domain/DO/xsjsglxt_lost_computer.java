package com.xsjsglxt.domain.DO;

public class xsjsglxt_lost_computer {
	
private String xsjsglxt_lost_computer_id;//损失电脑ID

private String lost_computer_case;//所属案件

private String lost_computer_brand;//电脑品牌

private String lost_computer_internetAccount;//上网账号

private String lost_computer_MAC;//MAC地址

private String lost_computer_remarks;//备注

private String lost_computer_gmt_create;//创建时间

private String lost_computer_gmt_modified;//修改时间

public xsjsglxt_lost_computer() {

	// TODO Auto-generated constructor stub
}

public xsjsglxt_lost_computer(String xsjsglxt_lost_computer_id, String lost_computer_case, String lost_computer_brand,
		String lost_computer_internetAccount, String lost_computer_MAC, String lost_computer_remarks,
		String lost_computer_gmt_create, String lost_computer_gmt_modified) {

	this.xsjsglxt_lost_computer_id = xsjsglxt_lost_computer_id;
	this.lost_computer_case = lost_computer_case;
	this.lost_computer_brand = lost_computer_brand;
	this.lost_computer_internetAccount = lost_computer_internetAccount;
	this.lost_computer_MAC = lost_computer_MAC;
	this.lost_computer_remarks = lost_computer_remarks;
	this.lost_computer_gmt_create = lost_computer_gmt_create;
	this.lost_computer_gmt_modified = lost_computer_gmt_modified;
}

@Override
public String toString() {
	return "lost_computer [xsjsglxt_lost_computer_id=" + xsjsglxt_lost_computer_id + ", lost_computer_case="
			+ lost_computer_case + ", lost_computer_brand=" + lost_computer_brand + ", lost_computer_internetAccount="
			+ lost_computer_internetAccount + ", lost_computer_MAC=" + lost_computer_MAC + ", lost_computer_remarks="
			+ lost_computer_remarks + ", lost_computer_gmt_create=" + lost_computer_gmt_create
			+ ", lost_computer_gmt_modified=" + lost_computer_gmt_modified + "]";
}

public String getXsjsglxt_lost_computer_id() {
	return xsjsglxt_lost_computer_id;
}

public void setXsjsglxt_lost_computer_id(String xsjsglxt_lost_computer_id) {
	this.xsjsglxt_lost_computer_id = xsjsglxt_lost_computer_id;
}

public String getLost_computer_case() {
	return lost_computer_case;
}

public void setLost_computer_case(String lost_computer_case) {
	this.lost_computer_case = lost_computer_case;
}

public String getLost_computer_brand() {
	return lost_computer_brand;
}

public void setLost_computer_brand(String lost_computer_brand) {
	this.lost_computer_brand = lost_computer_brand;
}

public String getLost_computer_internetAccount() {
	return lost_computer_internetAccount;
}

public void setLost_computer_internetAccount(String lost_computer_internetAccount) {
	this.lost_computer_internetAccount = lost_computer_internetAccount;
}

public String getLost_computer_MAC() {
	return lost_computer_MAC;
}

public void setLost_computer_MAC(String lost_computer_MAC) {
	this.lost_computer_MAC = lost_computer_MAC;
}

public String getLost_computer_remarks() {
	return lost_computer_remarks;
}

public void setLost_computer_remarks(String lost_computer_remarks) {
	this.lost_computer_remarks = lost_computer_remarks;
}

public String getLost_computer_gmt_create() {
	return lost_computer_gmt_create;
}

public void setLost_computer_gmt_create(String lost_computer_gmt_create) {
	this.lost_computer_gmt_create = lost_computer_gmt_create;
}

public String getLost_computer_gmt_modified() {
	return lost_computer_gmt_modified;
}

public void setLost_computer_gmt_modified(String lost_computer_gmt_modified) {
	this.lost_computer_gmt_modified = lost_computer_gmt_modified;
}


}
