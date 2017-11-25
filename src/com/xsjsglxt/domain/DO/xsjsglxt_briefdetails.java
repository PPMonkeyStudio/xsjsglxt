package com.xsjsglxt.domain.DO;

public class xsjsglxt_briefdetails {
	
private String xsjsglxt_briefdetails_id;//简要案情ID

private String briefdetails_case;//所属案件

private String briefdetails_details;//案情

private String briefdetails_gmt_create;//创建时间

private String briefdetails_details_modified;//修改时间

public xsjsglxt_briefdetails() {
	
	// TODO Auto-generated constructor stub
}

public xsjsglxt_briefdetails(String xsjsglxt_briefdetails_id, String briefdetails_case, String briefdetails_details,
		String briefdetails_gmt_create, String briefdetails_details_modified) {
	
	this.xsjsglxt_briefdetails_id = xsjsglxt_briefdetails_id;
	this.briefdetails_case = briefdetails_case;
	this.briefdetails_details = briefdetails_details;
	this.briefdetails_gmt_create = briefdetails_gmt_create;
	this.briefdetails_details_modified = briefdetails_details_modified;
}

@Override
public String toString() {
	return "xsjsglxt_briefdetails [xsjsglxt_briefdetails_id=" + xsjsglxt_briefdetails_id + ", briefdetails_case="
			+ briefdetails_case + ", briefdetails_details=" + briefdetails_details + ", briefdetails_gmt_create="
			+ briefdetails_gmt_create + ", briefdetails_details_modified=" + briefdetails_details_modified + "]";
}

public String getXsjsglxt_briefdetails_id() {
	return xsjsglxt_briefdetails_id;
}

public void setXsjsglxt_briefdetails_id(String xsjsglxt_briefdetails_id) {
	this.xsjsglxt_briefdetails_id = xsjsglxt_briefdetails_id;
}

public String getBriefdetails_case() {
	return briefdetails_case;
}

public void setBriefdetails_case(String briefdetails_case) {
	this.briefdetails_case = briefdetails_case;
}

public String getBriefdetails_details() {
	return briefdetails_details;
}

public void setBriefdetails_details(String briefdetails_details) {
	this.briefdetails_details = briefdetails_details;
}

public String getBriefdetails_gmt_create() {
	return briefdetails_gmt_create;
}

public void setBriefdetails_gmt_create(String briefdetails_gmt_create) {
	this.briefdetails_gmt_create = briefdetails_gmt_create;
}

public String getBriefdetails_details_modified() {
	return briefdetails_details_modified;
}

public void setBriefdetails_details_modified(String briefdetails_details_modified) {
	this.briefdetails_details_modified = briefdetails_details_modified;
}


}
