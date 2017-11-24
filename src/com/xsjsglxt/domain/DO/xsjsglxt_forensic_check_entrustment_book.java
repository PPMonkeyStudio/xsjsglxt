package com.xsjsglxt.domain.DO;

//法医检验委托书表
public class xsjsglxt_forensic_check_entrustment_book {
	private String xsjsglxt_forensic_check_entrustment_book_id;// 法医检验委托书ID
	private String forensic_check_entrustment_book_case_name;// 所属案件名称
	private String forensic_check_entrustment_book_case_num;// 所属案件编号
	private String forensic_check_entrustment_book_entrustment_unit;// 委托鉴定单位
	private String forensic_check_entrustment_book_entrustment_time;// 委托时间
	private String forensic_check_entrustment_book_inspectors_name;// 送检人——姓名
	private String forensic_check_entrustment_book_inspectors_duty;// 送检人——职务
	private String forensic_check_entrustment_book_inspectors_certificate_name_num;// 送检人——证件名称及号码
	private String forensic_check_entrustment_book_inspectors_communication_address;// 送检人——通讯地址
	private String forensic_check_entrustment_book_inspectors_phone;// 送检人——联系电话
	private String forensic_check_entrustment_book_inspectors_zip_code;// 送检人——邮编
	private String forensic_check_entrustment_book_inspectors_fax_number;// 送检人——传真号码
	private String forensic_check_entrustment_book_identifieder_name;// 被鉴定人——姓名
	private String forensic_check_entrustment_book_identifieder_sex;// 被鉴定人——性别
	private int forensic_check_entrustment_book_identifieder_age;// 被鉴定人——年龄
	private String forensic_check_entrustment_book_identifieder_phone;// 被鉴定人——电话
	private String forensic_check_entrustment_book_identifieder_unit;// 被鉴定人——单位
	private String forensic_check_entrustment_book_identifieder_address;// 被鉴定人——现住址
	private String forensic_check_entrustment_book_entrustment_name;// 鉴定机构名称
	private String forensic_check_entrustment_book_case_situation;// 案（事）件简要情况
	private String forensic_check_entrustment_book_old_entrustment_situation;// 原鉴定情况
	private String forensic_check_entrustment_book_sample_situation;// 送检的检材和样本等情况
	private String forensic_check_entrustment_book_entrustment_request;// 鉴定要求
	private String forensic_check_entrustment_book_entrustment_unit_responsible_person;// 鉴定委托单位负责人
	private String forensic_check_entrustment_book_signature_time;// 签字时间
	private String forensic_check_entrustment_book_state;// 检验状态
	private String forensic_check_entrustment_book_gmt_create;// 创建时间
	private String forensic_check_entrustment_book_gmt_modified;// 修改时间

	@Override
	public String toString() {
		return "xsjsglxt_forensic_check_entrustment_book [xsjsglxt_forensic_check_entrustment_book_id="
				+ xsjsglxt_forensic_check_entrustment_book_id + ", forensic_check_entrustment_book_case_name="
				+ forensic_check_entrustment_book_case_name + ", forensic_check_entrustment_book_case_num="
				+ forensic_check_entrustment_book_case_num + ", forensic_check_entrustment_book_entrustment_unit="
				+ forensic_check_entrustment_book_entrustment_unit
				+ ", forensic_check_entrustment_book_entrustment_time="
				+ forensic_check_entrustment_book_entrustment_time
				+ ", forensic_check_entrustment_book_inspectors_name=" + forensic_check_entrustment_book_inspectors_name
				+ ", forensic_check_entrustment_book_inspectors_duty=" + forensic_check_entrustment_book_inspectors_duty
				+ ", forensic_check_entrustment_book_inspectors_certificate_name_num="
				+ forensic_check_entrustment_book_inspectors_certificate_name_num
				+ ", forensic_check_entrustment_book_inspectors_communication_address="
				+ forensic_check_entrustment_book_inspectors_communication_address
				+ ", forensic_check_entrustment_book_inspectors_phone="
				+ forensic_check_entrustment_book_inspectors_phone
				+ ", forensic_check_entrustment_book_inspectors_zip_code="
				+ forensic_check_entrustment_book_inspectors_zip_code
				+ ", forensic_check_entrustment_book_inspectors_fax_number="
				+ forensic_check_entrustment_book_inspectors_fax_number
				+ ", forensic_check_entrustment_book_identifieder_name="
				+ forensic_check_entrustment_book_identifieder_name
				+ ", forensic_check_entrustment_book_identifieder_sex="
				+ forensic_check_entrustment_book_identifieder_sex
				+ ", forensic_check_entrustment_book_identifieder_age="
				+ forensic_check_entrustment_book_identifieder_age
				+ ", forensic_check_entrustment_book_identifieder_phone="
				+ forensic_check_entrustment_book_identifieder_phone
				+ ", forensic_check_entrustment_book_identifieder_unit="
				+ forensic_check_entrustment_book_identifieder_unit
				+ ", forensic_check_entrustment_book_identifieder_address="
				+ forensic_check_entrustment_book_identifieder_address
				+ ", forensic_check_entrustment_book_entrustment_name="
				+ forensic_check_entrustment_book_entrustment_name + ", forensic_check_entrustment_book_case_situation="
				+ forensic_check_entrustment_book_case_situation
				+ ", forensic_check_entrustment_book_old_entrustment_situation="
				+ forensic_check_entrustment_book_old_entrustment_situation
				+ ", forensic_check_entrustment_book_sample_situation="
				+ forensic_check_entrustment_book_sample_situation
				+ ", forensic_check_entrustment_book_entrustment_request="
				+ forensic_check_entrustment_book_entrustment_request
				+ ", forensic_check_entrustment_book_entrustment_unit_responsible_person="
				+ forensic_check_entrustment_book_entrustment_unit_responsible_person
				+ ", forensic_check_entrustment_book_signature_time=" + forensic_check_entrustment_book_signature_time
				+ ", forensic_check_entrustment_book_state=" + forensic_check_entrustment_book_state
				+ ", forensic_check_entrustment_book_gmt_create=" + forensic_check_entrustment_book_gmt_create
				+ ", forensic_check_entrustment_book_gmt_modified=" + forensic_check_entrustment_book_gmt_modified
				+ "]";
	}

	/**
	 * 
	 * 
	 * 
	 * 
	 */

	public String getXsjsglxt_forensic_check_entrustment_book_id() {
		return xsjsglxt_forensic_check_entrustment_book_id;
	}

	public void setXsjsglxt_forensic_check_entrustment_book_id(String xsjsglxt_forensic_check_entrustment_book_id) {
		this.xsjsglxt_forensic_check_entrustment_book_id = xsjsglxt_forensic_check_entrustment_book_id;
	}

	public String getForensic_check_entrustment_book_case_name() {
		return forensic_check_entrustment_book_case_name;
	}

	public void setForensic_check_entrustment_book_case_name(String forensic_check_entrustment_book_case_name) {
		this.forensic_check_entrustment_book_case_name = forensic_check_entrustment_book_case_name;
	}

	public String getForensic_check_entrustment_book_case_num() {
		return forensic_check_entrustment_book_case_num;
	}

	public void setForensic_check_entrustment_book_case_num(String forensic_check_entrustment_book_case_num) {
		this.forensic_check_entrustment_book_case_num = forensic_check_entrustment_book_case_num;
	}

	public String getForensic_check_entrustment_book_entrustment_unit() {
		return forensic_check_entrustment_book_entrustment_unit;
	}

	public void setForensic_check_entrustment_book_entrustment_unit(
			String forensic_check_entrustment_book_entrustment_unit) {
		this.forensic_check_entrustment_book_entrustment_unit = forensic_check_entrustment_book_entrustment_unit;
	}

	public String getForensic_check_entrustment_book_entrustment_time() {
		return forensic_check_entrustment_book_entrustment_time;
	}

	public void setForensic_check_entrustment_book_entrustment_time(
			String forensic_check_entrustment_book_entrustment_time) {
		this.forensic_check_entrustment_book_entrustment_time = forensic_check_entrustment_book_entrustment_time;
	}

	public String getForensic_check_entrustment_book_inspectors_name() {
		return forensic_check_entrustment_book_inspectors_name;
	}

	public void setForensic_check_entrustment_book_inspectors_name(
			String forensic_check_entrustment_book_inspectors_name) {
		this.forensic_check_entrustment_book_inspectors_name = forensic_check_entrustment_book_inspectors_name;
	}

	public String getForensic_check_entrustment_book_inspectors_duty() {
		return forensic_check_entrustment_book_inspectors_duty;
	}

	public void setForensic_check_entrustment_book_inspectors_duty(
			String forensic_check_entrustment_book_inspectors_duty) {
		this.forensic_check_entrustment_book_inspectors_duty = forensic_check_entrustment_book_inspectors_duty;
	}

	public String getForensic_check_entrustment_book_inspectors_certificate_name_num() {
		return forensic_check_entrustment_book_inspectors_certificate_name_num;
	}

	public void setForensic_check_entrustment_book_inspectors_certificate_name_num(
			String forensic_check_entrustment_book_inspectors_certificate_name_num) {
		this.forensic_check_entrustment_book_inspectors_certificate_name_num = forensic_check_entrustment_book_inspectors_certificate_name_num;
	}

	public String getForensic_check_entrustment_book_inspectors_communication_address() {
		return forensic_check_entrustment_book_inspectors_communication_address;
	}

	public void setForensic_check_entrustment_book_inspectors_communication_address(
			String forensic_check_entrustment_book_inspectors_communication_address) {
		this.forensic_check_entrustment_book_inspectors_communication_address = forensic_check_entrustment_book_inspectors_communication_address;
	}

	public String getForensic_check_entrustment_book_inspectors_phone() {
		return forensic_check_entrustment_book_inspectors_phone;
	}

	public void setForensic_check_entrustment_book_inspectors_phone(
			String forensic_check_entrustment_book_inspectors_phone) {
		this.forensic_check_entrustment_book_inspectors_phone = forensic_check_entrustment_book_inspectors_phone;
	}

	public String getForensic_check_entrustment_book_inspectors_zip_code() {
		return forensic_check_entrustment_book_inspectors_zip_code;
	}

	public void setForensic_check_entrustment_book_inspectors_zip_code(
			String forensic_check_entrustment_book_inspectors_zip_code) {
		this.forensic_check_entrustment_book_inspectors_zip_code = forensic_check_entrustment_book_inspectors_zip_code;
	}

	public String getForensic_check_entrustment_book_inspectors_fax_number() {
		return forensic_check_entrustment_book_inspectors_fax_number;
	}

	public void setForensic_check_entrustment_book_inspectors_fax_number(
			String forensic_check_entrustment_book_inspectors_fax_number) {
		this.forensic_check_entrustment_book_inspectors_fax_number = forensic_check_entrustment_book_inspectors_fax_number;
	}

	public String getForensic_check_entrustment_book_identifieder_name() {
		return forensic_check_entrustment_book_identifieder_name;
	}

	public void setForensic_check_entrustment_book_identifieder_name(
			String forensic_check_entrustment_book_identifieder_name) {
		this.forensic_check_entrustment_book_identifieder_name = forensic_check_entrustment_book_identifieder_name;
	}

	public String getForensic_check_entrustment_book_identifieder_sex() {
		return forensic_check_entrustment_book_identifieder_sex;
	}

	public void setForensic_check_entrustment_book_identifieder_sex(
			String forensic_check_entrustment_book_identifieder_sex) {
		this.forensic_check_entrustment_book_identifieder_sex = forensic_check_entrustment_book_identifieder_sex;
	}

	public int getForensic_check_entrustment_book_identifieder_age() {
		return forensic_check_entrustment_book_identifieder_age;
	}

	public void setForensic_check_entrustment_book_identifieder_age(
			int forensic_check_entrustment_book_identifieder_age) {
		this.forensic_check_entrustment_book_identifieder_age = forensic_check_entrustment_book_identifieder_age;
	}

	public String getForensic_check_entrustment_book_identifieder_phone() {
		return forensic_check_entrustment_book_identifieder_phone;
	}

	public void setForensic_check_entrustment_book_identifieder_phone(
			String forensic_check_entrustment_book_identifieder_phone) {
		this.forensic_check_entrustment_book_identifieder_phone = forensic_check_entrustment_book_identifieder_phone;
	}

	public String getForensic_check_entrustment_book_identifieder_unit() {
		return forensic_check_entrustment_book_identifieder_unit;
	}

	public void setForensic_check_entrustment_book_identifieder_unit(
			String forensic_check_entrustment_book_identifieder_unit) {
		this.forensic_check_entrustment_book_identifieder_unit = forensic_check_entrustment_book_identifieder_unit;
	}

	public String getForensic_check_entrustment_book_identifieder_address() {
		return forensic_check_entrustment_book_identifieder_address;
	}

	public void setForensic_check_entrustment_book_identifieder_address(
			String forensic_check_entrustment_book_identifieder_address) {
		this.forensic_check_entrustment_book_identifieder_address = forensic_check_entrustment_book_identifieder_address;
	}

	public String getForensic_check_entrustment_book_entrustment_name() {
		return forensic_check_entrustment_book_entrustment_name;
	}

	public void setForensic_check_entrustment_book_entrustment_name(
			String forensic_check_entrustment_book_entrustment_name) {
		this.forensic_check_entrustment_book_entrustment_name = forensic_check_entrustment_book_entrustment_name;
	}

	public String getForensic_check_entrustment_book_case_situation() {
		return forensic_check_entrustment_book_case_situation;
	}

	public void setForensic_check_entrustment_book_case_situation(
			String forensic_check_entrustment_book_case_situation) {
		this.forensic_check_entrustment_book_case_situation = forensic_check_entrustment_book_case_situation;
	}

	public String getForensic_check_entrustment_book_old_entrustment_situation() {
		return forensic_check_entrustment_book_old_entrustment_situation;
	}

	public void setForensic_check_entrustment_book_old_entrustment_situation(
			String forensic_check_entrustment_book_old_entrustment_situation) {
		this.forensic_check_entrustment_book_old_entrustment_situation = forensic_check_entrustment_book_old_entrustment_situation;
	}

	public String getForensic_check_entrustment_book_sample_situation() {
		return forensic_check_entrustment_book_sample_situation;
	}

	public void setForensic_check_entrustment_book_sample_situation(
			String forensic_check_entrustment_book_sample_situation) {
		this.forensic_check_entrustment_book_sample_situation = forensic_check_entrustment_book_sample_situation;
	}

	public String getForensic_check_entrustment_book_entrustment_request() {
		return forensic_check_entrustment_book_entrustment_request;
	}

	public void setForensic_check_entrustment_book_entrustment_request(
			String forensic_check_entrustment_book_entrustment_request) {
		this.forensic_check_entrustment_book_entrustment_request = forensic_check_entrustment_book_entrustment_request;
	}

	public String getForensic_check_entrustment_book_entrustment_unit_responsible_person() {
		return forensic_check_entrustment_book_entrustment_unit_responsible_person;
	}

	public void setForensic_check_entrustment_book_entrustment_unit_responsible_person(
			String forensic_check_entrustment_book_entrustment_unit_responsible_person) {
		this.forensic_check_entrustment_book_entrustment_unit_responsible_person = forensic_check_entrustment_book_entrustment_unit_responsible_person;
	}

	public String getForensic_check_entrustment_book_signature_time() {
		return forensic_check_entrustment_book_signature_time;
	}

	public void setForensic_check_entrustment_book_signature_time(
			String forensic_check_entrustment_book_signature_time) {
		this.forensic_check_entrustment_book_signature_time = forensic_check_entrustment_book_signature_time;
	}

	public String getForensic_check_entrustment_book_state() {
		return forensic_check_entrustment_book_state;
	}

	public void setForensic_check_entrustment_book_state(String forensic_check_entrustment_book_state) {
		this.forensic_check_entrustment_book_state = forensic_check_entrustment_book_state;
	}

	public String getForensic_check_entrustment_book_gmt_create() {
		return forensic_check_entrustment_book_gmt_create;
	}

	public void setForensic_check_entrustment_book_gmt_create(String forensic_check_entrustment_book_gmt_create) {
		this.forensic_check_entrustment_book_gmt_create = forensic_check_entrustment_book_gmt_create;
	}

	public String getForensic_check_entrustment_book_gmt_modified() {
		return forensic_check_entrustment_book_gmt_modified;
	}

	public void setForensic_check_entrustment_book_gmt_modified(String forensic_check_entrustment_book_gmt_modified) {
		this.forensic_check_entrustment_book_gmt_modified = forensic_check_entrustment_book_gmt_modified;
	}

}
