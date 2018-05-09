package com.xsjsglxt.domain.DO;

/**
 * 
 * @author 孙毅
 *	修改时间：2018-04-17
 */
public class xsjsglxt_case {

	private String xsjsglxt_case_id;// 案件ID

	private String case_parallel;// 所属串并

	private String case_name;// 案件名称

	private String case_classify;// 案件分类

	private String case_totalCategory;// 案件总类别

	private String case_sonCategory;// 案件子类别

	private String case_extentOfInjury;// 危害程度

	private String case_receivingAlarmDate;// 接警时间

	private int case_register;// 是否立案

	private String case_registerTime;// 立案时间

	private String case_address;// 案发地点

	private String case_makeTime;// 作案时段

	private String case_jurisdiction;// 发案辖区

	private String case_makeMeans;// 作案手段

	private String case_concreteMakeMeans;// 具体手段

	private String case_residence;// 处所

	private String case_concreteResidence;// 具体处所

	private String case_exit;// 进出口

	private String case_process;// 作案过程

	private String case_reporterName;// 报案人姓名

	private int case_reporterSex;// 报案人年龄

	private String case_reporterJobUnit;// 报案人工作单位

	private String case_reporterPhone;// 报案人联系电话

	private String case_reporterAddress;// 报案人家庭住址

	private String case_imageFile; // 物证图片

	private String case_writeFile;// 笔录文件

	private String case_senceImageFile;// 现场图文件

	private String case_gmt_create;// 创建时间

	private String case_gmt_modified;// 修改时间

	public xsjsglxt_case() {

		// TODO Auto-generated constructor stub
	}

	public xsjsglxt_case(String xsjsglxt_case_id, String case_parallel, String case_name, String case_classify,
			String case_totalCategory, String case_sonCategory, String case_extentOfInjury,
			String case_receivingAlarmDate, int case_register, String case_address, String case_makeTime,
			String case_jurisdiction, String case_makeMeans, String case_concreteMakeMeans, String case_residence,
			String case_concreteResidence, String case_exit, String case_process, String case_reporterName,
			int case_reporterSex, String case_reporterJobUnit, String case_reporterPhone, String case_reporterAddress,
			String case_gmt_create, String case_gmt_modified) {

		this.xsjsglxt_case_id = xsjsglxt_case_id;
		this.case_parallel = case_parallel;
		this.case_name = case_name;
		this.case_classify = case_classify;
		this.case_totalCategory = case_totalCategory;
		this.case_sonCategory = case_sonCategory;
		this.case_extentOfInjury = case_extentOfInjury;
		this.case_receivingAlarmDate = case_receivingAlarmDate;
		this.case_register = case_register;
		this.case_address = case_address;
		this.case_makeTime = case_makeTime;
		this.case_jurisdiction = case_jurisdiction;
		this.case_makeMeans = case_makeMeans;
		this.case_concreteMakeMeans = case_concreteMakeMeans;
		this.case_residence = case_residence;
		this.case_concreteResidence = case_concreteResidence;
		this.case_exit = case_exit;
		this.case_process = case_process;
		this.case_reporterName = case_reporterName;
		this.case_reporterSex = case_reporterSex;
		this.case_reporterJobUnit = case_reporterJobUnit;
		this.case_reporterPhone = case_reporterPhone;
		this.case_reporterAddress = case_reporterAddress;
		this.case_gmt_create = case_gmt_create;
		this.case_gmt_modified = case_gmt_modified;
	}

	@Override
	public String toString() {
		return "Case [xsjsglxt_case_id=" + xsjsglxt_case_id + ", case_parallel=" + case_parallel + ", case_name="
				+ case_name + ", case_classify=" + case_classify + ", case_totalCategory=" + case_totalCategory
				+ ", case_sonCategory=" + case_sonCategory + ", case_extentOfInjury=" + case_extentOfInjury
				+ ", case_receivingAlarmDate=" + case_receivingAlarmDate + ", case_register=" + case_register
				+ ", case_address=" + case_address + ", case_makeTime=" + case_makeTime + ", case_jurisdiction="
				+ case_jurisdiction + ", case_makeMeans=" + case_makeMeans + ", case_concreteMakeMeans="
				+ case_concreteMakeMeans + ", case_residence=" + case_residence + ", case_concreteResidence="
				+ case_concreteResidence + ", case_exit=" + case_exit + ", case_process=" + case_process
				+ ", case_reporterName=" + case_reporterName + ", case_reporterSex=" + case_reporterSex
				+ ", case_reporterJobUnit=" + case_reporterJobUnit + ", case_reporterPhone=" + case_reporterPhone
				+ ", case_reporterAddress=" + case_reporterAddress + ", case_gmt_create=" + case_gmt_create
				+ ", case_gmt_modified=" + case_gmt_modified + "]";
	}

	public String getXsjsglxt_case_id() {
		return xsjsglxt_case_id;
	}

	public void setXsjsglxt_case_id(String xsjsglxt_case_id) {
		this.xsjsglxt_case_id = xsjsglxt_case_id;
	}

	public String getCase_parallel() {
		return case_parallel;
	}

	public void setCase_parallel(String case_parallel) {
		this.case_parallel = case_parallel;
	}

	public String getCase_name() {
		return case_name;
	}

	public void setCase_name(String case_name) {
		this.case_name = case_name;
	}

	public String getCase_classify() {
		return case_classify;
	}

	public void setCase_classify(String case_classify) {
		this.case_classify = case_classify;
	}

	public String getCase_totalCategory() {
		return case_totalCategory;
	}

	public void setCase_totalCategory(String case_totalCategory) {
		this.case_totalCategory = case_totalCategory;
	}

	public String getCase_sonCategory() {
		return case_sonCategory;
	}

	public void setCase_sonCategory(String case_sonCategory) {
		this.case_sonCategory = case_sonCategory;
	}

	public String getCase_extentOfInjury() {
		return case_extentOfInjury;
	}

	public void setCase_extentOfInjury(String case_extentOfInjury) {
		this.case_extentOfInjury = case_extentOfInjury;
	}

	public String getCase_receivingAlarmDate() {
		return case_receivingAlarmDate;
	}

	public void setCase_receivingAlarmDate(String case_receivingAlarmDate) {
		this.case_receivingAlarmDate = case_receivingAlarmDate;
	}

	public int getCase_register() {
		return case_register;
	}

	public void setCase_register(int case_register) {
		this.case_register = case_register;
	}

	public String getCase_address() {
		return case_address;
	}

	public void setCase_address(String case_address) {
		this.case_address = case_address;
	}

	public String getCase_makeTime() {
		return case_makeTime;
	}

	public void setCase_makeTime(String case_makeTime) {
		this.case_makeTime = case_makeTime;
	}

	public String getCase_jurisdiction() {
		return case_jurisdiction;
	}

	public void setCase_jurisdiction(String case_jurisdiction) {
		this.case_jurisdiction = case_jurisdiction;
	}

	public String getCase_makeMeans() {
		return case_makeMeans;
	}

	public void setCase_makeMeans(String case_makeMeans) {
		this.case_makeMeans = case_makeMeans;
	}

	public String getCase_concreteMakeMeans() {
		return case_concreteMakeMeans;
	}

	public void setCase_concreteMakeMeans(String case_concreteMakeMeans) {
		this.case_concreteMakeMeans = case_concreteMakeMeans;
	}

	public String getCase_residence() {
		return case_residence;
	}

	public void setCase_residence(String case_residence) {
		this.case_residence = case_residence;
	}

	public String getCase_concreteResidence() {
		return case_concreteResidence;
	}

	public void setCase_concreteResidence(String case_concreteResidence) {
		this.case_concreteResidence = case_concreteResidence;
	}

	public String getCase_exit() {
		return case_exit;
	}

	public void setCase_exit(String case_exit) {
		this.case_exit = case_exit;
	}

	public String getCase_process() {
		return case_process;
	}

	public void setCase_process(String case_process) {
		this.case_process = case_process;
	}

	public String getCase_reporterName() {
		return case_reporterName;
	}

	public void setCase_reporterName(String case_reporterName) {
		this.case_reporterName = case_reporterName;
	}

	public int getCase_reporterSex() {
		return case_reporterSex;
	}

	public void setCase_reporterSex(int case_reporterSex) {
		this.case_reporterSex = case_reporterSex;
	}

	public String getCase_reporterJobUnit() {
		return case_reporterJobUnit;
	}

	public void setCase_reporterJobUnit(String case_reporterJobUnit) {
		this.case_reporterJobUnit = case_reporterJobUnit;
	}

	public String getCase_reporterPhone() {
		return case_reporterPhone;
	}

	public void setCase_reporterPhone(String case_reporterPhone) {
		this.case_reporterPhone = case_reporterPhone;
	}

	public String getCase_reporterAddress() {
		return case_reporterAddress;
	}

	public void setCase_reporterAddress(String case_reporterAddress) {
		this.case_reporterAddress = case_reporterAddress;
	}

	public String getCase_gmt_create() {
		return case_gmt_create;
	}

	public void setCase_gmt_create(String case_gmt_create) {
		this.case_gmt_create = case_gmt_create;
	}

	public String getCase_gmt_modified() {
		return case_gmt_modified;
	}

	public void setCase_gmt_modified(String case_gmt_modified) {
		this.case_gmt_modified = case_gmt_modified;
	}

	public String getCase_imageFile() {
		return case_imageFile;
	}

	public void setCase_imageFile(String case_imageFile) {
		this.case_imageFile = case_imageFile;
	}

	public String getCase_writeFile() {
		return case_writeFile;
	}

	public void setCase_writeFile(String case_writeFile) {
		this.case_writeFile = case_writeFile;
	}

	public String getCase_senceImageFile() {
		return case_senceImageFile;
	}

	public void setCase_senceImageFile(String case_senceImageFile) {
		this.case_senceImageFile = case_senceImageFile;
	}

	public String getCase_registerTime() {
		return case_registerTime;
	}

	public void setCase_registerTime(String case_registerTime) {
		this.case_registerTime = case_registerTime;
	}

}
