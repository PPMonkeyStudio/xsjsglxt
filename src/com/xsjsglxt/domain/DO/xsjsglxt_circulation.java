package com.xsjsglxt.domain.DO;

public class xsjsglxt_circulation {
	
private String xsjsglxt_circulation_id;//流转记录ID

private String circulation_resevidence;//所属物证p

private String circulation_situation;//流转情况

private String circulation_position;//存放位置

private String circulation_date;//流转日期

private String circulation_transferperson;//移交人

private String circulation_recipient;//接收人

private String circulation_gmt_create;//创建时间

private String circulation_gmt_modified;//修改时间

public xsjsglxt_circulation() {
	
	// TODO Auto-generated constructor stub
}

public xsjsglxt_circulation(String xsjsglxt_circulation_id, String circulation_resevidence, String circulation_situation,
		String circulation_position, String circulation_date, String circulation_transferperson,
		String circulation_recipient, String circulation_gmt_create, String circulation_gmt_modified) {

	this.xsjsglxt_circulation_id = xsjsglxt_circulation_id;
	this.circulation_resevidence = circulation_resevidence;
	this.circulation_situation = circulation_situation;
	this.circulation_position = circulation_position;
	this.circulation_date = circulation_date;
	this.circulation_transferperson = circulation_transferperson;
	this.circulation_recipient = circulation_recipient;
	this.circulation_gmt_create = circulation_gmt_create;
	this.circulation_gmt_modified = circulation_gmt_modified;
}

@Override
public String toString() {
	return "circulation [xsjsglxt_circulation_id=" + xsjsglxt_circulation_id + ", circulation_resevidence="
			+ circulation_resevidence + ", circulation_situation=" + circulation_situation + ", circulation_position="
			+ circulation_position + ", circulation_date=" + circulation_date + ", circulation_transferperson="
			+ circulation_transferperson + ", circulation_recipient=" + circulation_recipient
			+ ", circulation_gmt_create=" + circulation_gmt_create + ", circulation_gmt_modified="
			+ circulation_gmt_modified + "]";
}

public String getXsjsglxt_circulation_id() {
	return xsjsglxt_circulation_id;
}

public void setXsjsglxt_circulation_id(String xsjsglxt_circulation_id) {
	this.xsjsglxt_circulation_id = xsjsglxt_circulation_id;
}

public String getCirculation_resevidence() {
	return circulation_resevidence;
}

public void setCirculation_resevidence(String circulation_resevidence) {
	this.circulation_resevidence = circulation_resevidence;
}

public String getCirculation_situation() {
	return circulation_situation;
}

public void setCirculation_situation(String circulation_situation) {
	this.circulation_situation = circulation_situation;
}

public String getCirculation_position() {
	return circulation_position;
}

public void setCirculation_position(String circulation_position) {
	this.circulation_position = circulation_position;
}

public String getCirculation_date() {
	return circulation_date;
}

public void setCirculation_date(String circulation_date) {
	this.circulation_date = circulation_date;
}

public String getCirculation_transferperson() {
	return circulation_transferperson;
}

public void setCirculation_transferperson(String circulation_transferperson) {
	this.circulation_transferperson = circulation_transferperson;
}

public String getCirculation_recipient() {
	return circulation_recipient;
}

public void setCirculation_recipient(String circulation_recipient) {
	this.circulation_recipient = circulation_recipient;
}

public String getCirculation_gmt_create() {
	return circulation_gmt_create;
}

public void setCirculation_gmt_create(String circulation_gmt_create) {
	this.circulation_gmt_create = circulation_gmt_create;
}

public String getCirculation_gmt_modified() {
	return circulation_gmt_modified;
}

public void setCirculation_gmt_modified(String circulation_gmt_modified) {
	this.circulation_gmt_modified = circulation_gmt_modified;
}


}
