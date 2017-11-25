package com.xsjsglxt.domain.DO;

public class xsjsglxt_resevidence {
	
private String xsjsglxt_resevidence_id;//物证ID

private String resevidence_case;//所属案件

private String resevidence_name;//物证名称

private String resevidence_extractUnit;//提取单位

private String resevidence_type;//物证类型

private String resevidence_extractPart;//提取部位

private String resevidence_extractMethod;//提取方法

private int resevidence_extractNumber;//提取数量

private String resevidence_extractPerson;//提取人

private String resevidence_extractTime;//提取日期

private String resevidence_remarks;//备注

private String resevidence_teststate;//检验状态

private String resevidence_gmt_create;//创建时间

private String resevidence_gmt_modified;//修改时间

public xsjsglxt_resevidence() {

	// TODO Auto-generated constructor stub
}


public xsjsglxt_resevidence(String xsjsglxt_resevidence_id, String resevidence_case, String resevidence_name,
		String resevidence_extractUnit, String resevidence_type, String resevidence_extractPart,
		String resevidence_extractMethod, int resevidence_extractNumber, String resevidence_extractPerson,
		String resevidence_extractTime, String resevidence_remarks, String resevidence_teststate,
		String resevidence_gmt_create, String resevidence_gmt_modified) {

	this.xsjsglxt_resevidence_id = xsjsglxt_resevidence_id;
	this.resevidence_case = resevidence_case;
	this.resevidence_name = resevidence_name;
	this.resevidence_extractUnit = resevidence_extractUnit;
	this.resevidence_type = resevidence_type;
	this.resevidence_extractPart = resevidence_extractPart;
	this.resevidence_extractMethod = resevidence_extractMethod;
	this.resevidence_extractNumber = resevidence_extractNumber;
	this.resevidence_extractPerson = resevidence_extractPerson;
	this.resevidence_extractTime = resevidence_extractTime;
	this.resevidence_remarks = resevidence_remarks;
	this.resevidence_teststate = resevidence_teststate;
	this.resevidence_gmt_create = resevidence_gmt_create;
	this.resevidence_gmt_modified = resevidence_gmt_modified;
}


@Override
public String toString() {
	return "resevidence [xsjsglxt_resevidence_id=" + xsjsglxt_resevidence_id + ", resevidence_case=" + resevidence_case
			+ ", resevidence_name=" + resevidence_name + ", resevidence_extractUnit=" + resevidence_extractUnit
			+ ", resevidence_type=" + resevidence_type + ", resevidence_extractPart=" + resevidence_extractPart
			+ ", resevidence_extractMethod=" + resevidence_extractMethod + ", resevidence_extractNumber="
			+ resevidence_extractNumber + ", resevidence_extractPerson=" + resevidence_extractPerson
			+ ", resevidence_extractTime=" + resevidence_extractTime + ", resevidence_remarks=" + resevidence_remarks
			+ ", resevidence_teststate=" + resevidence_teststate + ", resevidence_gmt_create=" + resevidence_gmt_create
			+ ", resevidence_gmt_modified=" + resevidence_gmt_modified + "]";
}

public String getXsjsglxt_resevidence_id() {
	return xsjsglxt_resevidence_id;
}

public void setXsjsglxt_resevidence_id(String xsjsglxt_resevidence_id) {
	this.xsjsglxt_resevidence_id = xsjsglxt_resevidence_id;
}

public String getResevidence_case() {
	return resevidence_case;
}

public void setResevidence_case(String resevidence_case) {
	this.resevidence_case = resevidence_case;
}

public String getResevidence_name() {
	return resevidence_name;
}

public void setResevidence_name(String resevidence_name) {
	this.resevidence_name = resevidence_name;
}

public String getResevidence_extractUnit() {
	return resevidence_extractUnit;
}

public void setResevidence_extractUnit(String resevidence_extractUnit) {
	this.resevidence_extractUnit = resevidence_extractUnit;
}

public String getResevidence_type() {
	return resevidence_type;
}

public void setResevidence_type(String resevidence_type) {
	this.resevidence_type = resevidence_type;
}

public String getResevidence_extractPart() {
	return resevidence_extractPart;
}

public void setResevidence_extractPart(String resevidence_extractPart) {
	this.resevidence_extractPart = resevidence_extractPart;
}

public String getResevidence_extractMethod() {
	return resevidence_extractMethod;
}

public void setResevidence_extractMethod(String resevidence_extractMethod) {
	this.resevidence_extractMethod = resevidence_extractMethod;
}



public int getResevidence_extractNumber() {
	return resevidence_extractNumber;
}


public void setResevidence_extractNumber(int resevidence_extractNumber) {
	this.resevidence_extractNumber = resevidence_extractNumber;
}


public String getResevidence_extractPerson() {
	return resevidence_extractPerson;
}

public void setResevidence_extractPerson(String resevidence_extractPerson) {
	this.resevidence_extractPerson = resevidence_extractPerson;
}

public String getResevidence_extractTime() {
	return resevidence_extractTime;
}

public void setResevidence_extractTime(String resevidence_extractTime) {
	this.resevidence_extractTime = resevidence_extractTime;
}

public String getResevidence_remarks() {
	return resevidence_remarks;
}

public void setResevidence_remarks(String resevidence_remarks) {
	this.resevidence_remarks = resevidence_remarks;
}

public String getResevidence_teststate() {
	return resevidence_teststate;
}

public void setResevidence_teststate(String resevidence_teststate) {
	this.resevidence_teststate = resevidence_teststate;
}

public String getResevidence_gmt_create() {
	return resevidence_gmt_create;
}

public void setResevidence_gmt_create(String resevidence_gmt_create) {
	this.resevidence_gmt_create = resevidence_gmt_create;
}

public String getResevidence_gmt_modified() {
	return resevidence_gmt_modified;
}

public void setResevidence_gmt_modified(String resevidence_gmt_modified) {
	this.resevidence_gmt_modified = resevidence_gmt_modified;
}


}
