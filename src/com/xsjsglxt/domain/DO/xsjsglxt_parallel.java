package com.xsjsglxt.domain.DO;

public class xsjsglxt_parallel {
	
private String xsjsglxt_parallel_id;//案件串并ID

private String parallel_num;//串并号

private String parallel_casename;//案件串并名称

private String parallel_person;//串并人

private String parallel_date;//串并时间

private String parallel_breakecaseSituation;//破案情况

private String parallel_accordingAddress;//串并依据——处所

private String parallel_makeMeans;//串并依据——作案手段

private String parallel_makeTarget;//串并依据——作案目标

private String parallel_makeTime;//串并依据——作案时段

private String parallel_skillMerge;//串并依据——技术并案

private String parallel_othermakePoint;//串并依据——其他作案特点

private String parallel_gmt_create;//创建时间

private String parallel_gmt_modified;//修改时间

public xsjsglxt_parallel() {

	// TODO Auto-generated constructor stub
}

public xsjsglxt_parallel(String xsjsglxt_parallel_id, String parallel_num, String parallel_casename, String parallel_person,
		String parallel_date, String parallel_breakecaseSituation, String parallel_accordingAddress,
		String parallel_makeMeans, String parallel_makeTarget, String parallel_makeTime, String parallel_skillMerge,
		String parallel_othermakePoint, String parallel_gmt_create, String parallel_gmt_modified) {
	
	this.xsjsglxt_parallel_id = xsjsglxt_parallel_id;
	this.parallel_num = parallel_num;
	this.parallel_casename = parallel_casename;
	this.parallel_person = parallel_person;
	this.parallel_date = parallel_date;
	this.parallel_breakecaseSituation = parallel_breakecaseSituation;
	this.parallel_accordingAddress = parallel_accordingAddress;
	this.parallel_makeMeans = parallel_makeMeans;
	this.parallel_makeTarget = parallel_makeTarget;
	this.parallel_makeTime = parallel_makeTime;
	this.parallel_skillMerge = parallel_skillMerge;
	this.parallel_othermakePoint = parallel_othermakePoint;
	this.parallel_gmt_create = parallel_gmt_create;
	this.parallel_gmt_modified = parallel_gmt_modified;
}

@Override
public String toString() {
	return "parallel [xsjsglxt_parallel_id=" + xsjsglxt_parallel_id + ", parallel_num=" + parallel_num
			+ ", parallel_casename=" + parallel_casename + ", parallel_person=" + parallel_person + ", parallel_date="
			+ parallel_date + ", parallel_breakecaseSituation=" + parallel_breakecaseSituation
			+ ", parallel_accordingAddress=" + parallel_accordingAddress + ", parallel_makeMeans=" + parallel_makeMeans
			+ ", parallel_makeTarget=" + parallel_makeTarget + ", parallel_makeTime=" + parallel_makeTime
			+ ", parallel_skillMerge=" + parallel_skillMerge + ", parallel_othermakePoint=" + parallel_othermakePoint
			+ ", parallel_gmt_create=" + parallel_gmt_create + ", parallel_gmt_modified=" + parallel_gmt_modified + "]";
}

public String getXsjsglxt_parallel_id() {
	return xsjsglxt_parallel_id;
}

public void setXsjsglxt_parallel_id(String xsjsglxt_parallel_id) {
	this.xsjsglxt_parallel_id = xsjsglxt_parallel_id;
}

public String getParallel_num() {
	return parallel_num;
}

public void setParallel_num(String parallel_num) {
	this.parallel_num = parallel_num;
}

public String getParallel_casename() {
	return parallel_casename;
}

public void setParallel_casename(String parallel_casename) {
	this.parallel_casename = parallel_casename;
}

public String getParallel_person() {
	return parallel_person;
}

public void setParallel_person(String parallel_person) {
	this.parallel_person = parallel_person;
}

public String getParallel_date() {
	return parallel_date;
}

public void setParallel_date(String parallel_date) {
	this.parallel_date = parallel_date;
}

public String getParallel_breakecaseSituation() {
	return parallel_breakecaseSituation;
}

public void setParallel_breakecaseSituation(String parallel_breakecaseSituation) {
	this.parallel_breakecaseSituation = parallel_breakecaseSituation;
}

public String getParallel_accordingAddress() {
	return parallel_accordingAddress;
}

public void setParallel_accordingAddress(String parallel_accordingAddress) {
	this.parallel_accordingAddress = parallel_accordingAddress;
}

public String getParallel_makeMeans() {
	return parallel_makeMeans;
}

public void setParallel_makeMeans(String parallel_makeMeans) {
	this.parallel_makeMeans = parallel_makeMeans;
}

public String getParallel_makeTarget() {
	return parallel_makeTarget;
}

public void setParallel_makeTarget(String parallel_makeTarget) {
	this.parallel_makeTarget = parallel_makeTarget;
}

public String getParallel_makeTime() {
	return parallel_makeTime;
}

public void setParallel_makeTime(String parallel_makeTime) {
	this.parallel_makeTime = parallel_makeTime;
}

public String getParallel_skillMerge() {
	return parallel_skillMerge;
}

public void setParallel_skillMerge(String parallel_skillMerge) {
	this.parallel_skillMerge = parallel_skillMerge;
}

public String getParallel_othermakePoint() {
	return parallel_othermakePoint;
}

public void setParallel_othermakePoint(String parallel_othermakePoint) {
	this.parallel_othermakePoint = parallel_othermakePoint;
}

public String getParallel_gmt_create() {
	return parallel_gmt_create;
}

public void setParallel_gmt_create(String parallel_gmt_create) {
	this.parallel_gmt_create = parallel_gmt_create;
}

public String getParallel_gmt_modified() {
	return parallel_gmt_modified;
}

public void setParallel_gmt_modified(String parallel_gmt_modified) {
	this.parallel_gmt_modified = parallel_gmt_modified;
}


} 
