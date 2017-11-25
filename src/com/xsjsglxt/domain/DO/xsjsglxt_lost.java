package com.xsjsglxt.domain.DO;

public class xsjsglxt_lost {
	
private String xsjsglxt_lost_id;//损失物品ID

private String lost_case;//所属案件

private String lost_name;//名称

private String lost_remarks;//备注

private String lost_gmt_create;//创建时间

private String lost_gmt_modified;//修改时间

public xsjsglxt_lost() {

	// TODO Auto-generated constructor stub
}

public xsjsglxt_lost(String xsjsglxt_lost_id, String lost_case, String lost_name, String lost_remarks, String lost_gmt_create,
		String lost_gmt_modified) {

	this.xsjsglxt_lost_id = xsjsglxt_lost_id;
	this.lost_case = lost_case;
	this.lost_name = lost_name;
	this.lost_remarks = lost_remarks;
	this.lost_gmt_create = lost_gmt_create;
	this.lost_gmt_modified = lost_gmt_modified;
}

@Override
public String toString() {
	return "lost [xsjsglxt_lost_id=" + xsjsglxt_lost_id + ", lost_case=" + lost_case + ", lost_name=" + lost_name
			+ ", lost_remarks=" + lost_remarks + ", lost_gmt_create=" + lost_gmt_create + ", lost_gmt_modified="
			+ lost_gmt_modified + "]";
}

public String getXsjsglxt_lost_id() {
	return xsjsglxt_lost_id;
}

public void setXsjsglxt_lost_id(String xsjsglxt_lost_id) {
	this.xsjsglxt_lost_id = xsjsglxt_lost_id;
}

public String getLost_case() {
	return lost_case;
}

public void setLost_case(String lost_case) {
	this.lost_case = lost_case;
}

public String getLost_name() {
	return lost_name;
}

public void setLost_name(String lost_name) {
	this.lost_name = lost_name;
}

public String getLost_remarks() {
	return lost_remarks;
}

public void setLost_remarks(String lost_remarks) {
	this.lost_remarks = lost_remarks;
}

public String getLost_gmt_create() {
	return lost_gmt_create;
}

public void setLost_gmt_create(String lost_gmt_create) {
	this.lost_gmt_create = lost_gmt_create;
}

public String getLost_gmt_modified() {
	return lost_gmt_modified;
}

public void setLost_gmt_modified(String lost_gmt_modified) {
	this.lost_gmt_modified = lost_gmt_modified;
}



}
