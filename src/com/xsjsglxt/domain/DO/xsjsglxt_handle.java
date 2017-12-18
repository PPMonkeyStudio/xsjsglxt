package com.xsjsglxt.domain.DO;

public class xsjsglxt_handle {
private String xsjsglxt_handle_id;//办案ID
private String handle_orderNumber;//序号
private String handle_administrativeCase;//行政案件名称
private String handle_suspectName;//违法嫌疑人姓名
private String handle_administrativeAttachment;//行政拘留
private String handle_arrest;//逮捕
private String handle_prosecute;//起诉
private String handle_checkback;//退查
private String handle_pbat;//取保候审
private String handle_lhus;//监视居住
private String handle_StartTimeaOfDetention;//拘留起始时间
private String handle_arrestTime;//逮捕时间
private String handle_prosecuteTime;//起诉时间
private String handle_checkbackTime;//退查时间
private String handle_pbatTime;//取保候审时间
private String handle_lhusTime;//监视居住时间
<<<<<<< HEAD
=======
private String handle_detentionDay;//拘留时间
private String handle_FinancialName;// 财物名称
private String handle_handTime;//上交时间
private String handle_handleTime;//处理时间
private String handle_processMode;//处理方式
private String handle_squadronleader;//中队长
private String handle_PoliceInHandlingCases;//办案民警
private String handle_gnt_create;//创建时间
private String handle_gmt_modified;//修改时间
public xsjsglxt_handle() {

	// TODO Auto-generated constructor stub
}
public xsjsglxt_handle(String xsjsglxt_handle_id, String handle_orderNumber, String handle_administrativeCase,
		String handle_suspectName, String handle_administrativeAttachment, String handle_arrest,
		String handle_prosecute, String handle_checkback, String handle_pbat, String handle_lhus,
		String handle_StartTimeaOfDetention, String handle_arrestTime, String handle_prosecuteTime,
		String handle_checkbackTime, String handle_pbatTime, String handle_lhusTime, String handle_detentionDay,
		String handle_FinancialName, String handle_handTime, String handle_handleTime, String handle_processMode,
		String handle_squadronleader, String handle_PoliceInHandlingCases, String handle_gnt_create,
		String handle_gmt_modified) {

	this.xsjsglxt_handle_id = xsjsglxt_handle_id;
	this.handle_orderNumber = handle_orderNumber;
	this.handle_administrativeCase = handle_administrativeCase;
	this.handle_suspectName = handle_suspectName;
	this.handle_administrativeAttachment = handle_administrativeAttachment;
	this.handle_arrest = handle_arrest;
	this.handle_prosecute = handle_prosecute;
	this.handle_checkback = handle_checkback;
	this.handle_pbat = handle_pbat;
	this.handle_lhus = handle_lhus;
	this.handle_StartTimeaOfDetention = handle_StartTimeaOfDetention;
	this.handle_arrestTime = handle_arrestTime;
	this.handle_prosecuteTime = handle_prosecuteTime;
	this.handle_checkbackTime = handle_checkbackTime;
	this.handle_pbatTime = handle_pbatTime;
	this.handle_lhusTime = handle_lhusTime;
	this.handle_detentionDay = handle_detentionDay;
	this.handle_FinancialName = handle_FinancialName;
	this.handle_handTime = handle_handTime;
	this.handle_handleTime = handle_handleTime;
	this.handle_processMode = handle_processMode;
	this.handle_squadronleader = handle_squadronleader;
	this.handle_PoliceInHandlingCases = handle_PoliceInHandlingCases;
	this.handle_gnt_create = handle_gnt_create;
	this.handle_gmt_modified = handle_gmt_modified;
}
@Override
public String toString() {
	return "xsjsglxt_handle [xsjsglxt_handle_id=" + xsjsglxt_handle_id + ", handle_orderNumber=" + handle_orderNumber
			+ ", handle_administrativeCase=" + handle_administrativeCase + ", handle_suspectName=" + handle_suspectName
			+ ", handle_administrativeAttachment=" + handle_administrativeAttachment + ", handle_arrest="
			+ handle_arrest + ", handle_prosecute=" + handle_prosecute + ", handle_checkback=" + handle_checkback
			+ ", handle_pbat=" + handle_pbat + ", handle_lhus=" + handle_lhus + ", handle_StartTimeaOfDetention="
			+ handle_StartTimeaOfDetention + ", handle_arrestTime=" + handle_arrestTime + ", handle_prosecuteTime="
			+ handle_prosecuteTime + ", handle_checkbackTime=" + handle_checkbackTime + ", handle_pbatTime="
			+ handle_pbatTime + ", handle_lhusTime=" + handle_lhusTime + ", handle_detentionDay=" + handle_detentionDay
			+ ", handle_FinancialName=" + handle_FinancialName + ", handle_handTime=" + handle_handTime
			+ ", handle_handleTime=" + handle_handleTime + ", handle_processMode=" + handle_processMode
			+ ", handle_squadronleader=" + handle_squadronleader + ", handle_PoliceInHandlingCases="
			+ handle_PoliceInHandlingCases + ", handle_gnt_create=" + handle_gnt_create + ", handle_gmt_modified="
			+ handle_gmt_modified + "]";
}
public String getXsjsglxt_handle_id() {
	return xsjsglxt_handle_id;
}
public void setXsjsglxt_handle_id(String xsjsglxt_handle_id) {
	this.xsjsglxt_handle_id = xsjsglxt_handle_id;
}
public String getHandle_orderNumber() {
	return handle_orderNumber;
}
public void setHandle_orderNumber(String handle_orderNumber) {
	this.handle_orderNumber = handle_orderNumber;
}
public String getHandle_administrativeCase() {
	return handle_administrativeCase;
}
public void setHandle_administrativeCase(String handle_administrativeCase) {
	this.handle_administrativeCase = handle_administrativeCase;
}
public String getHandle_suspectName() {
	return handle_suspectName;
}
public void setHandle_suspectName(String handle_suspectName) {
	this.handle_suspectName = handle_suspectName;
}
public String getHandle_administrativeAttachment() {
	return handle_administrativeAttachment;
}
public void setHandle_administrativeAttachment(String handle_administrativeAttachment) {
	this.handle_administrativeAttachment = handle_administrativeAttachment;
}
public String getHandle_arrest() {
	return handle_arrest;
}
public void setHandle_arrest(String handle_arrest) {
	this.handle_arrest = handle_arrest;
}
public String getHandle_prosecute() {
	return handle_prosecute;
}
public void setHandle_prosecute(String handle_prosecute) {
	this.handle_prosecute = handle_prosecute;
}
public String getHandle_checkback() {
	return handle_checkback;
}
public void setHandle_checkback(String handle_checkback) {
	this.handle_checkback = handle_checkback;
}
public String getHandle_pbat() {
	return handle_pbat;
}
public void setHandle_pbat(String handle_pbat) {
	this.handle_pbat = handle_pbat;
}
public String getHandle_lhus() {
	return handle_lhus;
}
public void setHandle_lhus(String handle_lhus) {
	this.handle_lhus = handle_lhus;
}
public String getHandle_StartTimeaOfDetention() {
	return handle_StartTimeaOfDetention;
}
public void setHandle_StartTimeaOfDetention(String handle_StartTimeaOfDetention) {
	this.handle_StartTimeaOfDetention = handle_StartTimeaOfDetention;
}
public String getHandle_arrestTime() {
	return handle_arrestTime;
}
public void setHandle_arrestTime(String handle_arrestTime) {
	this.handle_arrestTime = handle_arrestTime;
}
public String getHandle_prosecuteTime() {
	return handle_prosecuteTime;
}
public void setHandle_prosecuteTime(String handle_prosecuteTime) {
	this.handle_prosecuteTime = handle_prosecuteTime;
}
public String getHandle_checkbackTime() {
	return handle_checkbackTime;
}
public void setHandle_checkbackTime(String handle_checkbackTime) {
	this.handle_checkbackTime = handle_checkbackTime;
}
public String getHandle_pbatTime() {
	return handle_pbatTime;
}
public void setHandle_pbatTime(String handle_pbatTime) {
	this.handle_pbatTime = handle_pbatTime;
}
public String getHandle_lhusTime() {
	return handle_lhusTime;
}
public void setHandle_lhusTime(String handle_lhusTime) {
	this.handle_lhusTime = handle_lhusTime;
}
public String getHandle_detentionDay() {
	return handle_detentionDay;
}
public void setHandle_detentionDay(String handle_detentionDay) {
	this.handle_detentionDay = handle_detentionDay;
}
public String getHandle_FinancialName() {
	return handle_FinancialName;
}
public void setHandle_FinancialName(String handle_FinancialName) {
	this.handle_FinancialName = handle_FinancialName;
}
public String getHandle_handTime() {
	return handle_handTime;
}
public void setHandle_handTime(String handle_handTime) {
	this.handle_handTime = handle_handTime;
}
public String getHandle_handleTime() {
	return handle_handleTime;
}
public void setHandle_handleTime(String handle_handleTime) {
	this.handle_handleTime = handle_handleTime;
}
public String getHandle_processMode() {
	return handle_processMode;
}
public void setHandle_processMode(String handle_processMode) {
	this.handle_processMode = handle_processMode;
}
public String getHandle_squadronleader() {
	return handle_squadronleader;
}
public void setHandle_squadronleader(String handle_squadronleader) {
	this.handle_squadronleader = handle_squadronleader;
}
public String getHandle_PoliceInHandlingCases() {
	return handle_PoliceInHandlingCases;
}
public void setHandle_PoliceInHandlingCases(String handle_PoliceInHandlingCases) {
	this.handle_PoliceInHandlingCases = handle_PoliceInHandlingCases;
}
public String getHandle_gnt_create() {
	return handle_gnt_create;
}
public void setHandle_gnt_create(String handle_gnt_create) {
	this.handle_gnt_create = handle_gnt_create;
}
public String getHandle_gmt_modified() {
	return handle_gmt_modified;
}
public void setHandle_gmt_modified(String handle_gmt_modified) {
	this.handle_gmt_modified = handle_gmt_modified;
}
>>>>>>> LWK

}
