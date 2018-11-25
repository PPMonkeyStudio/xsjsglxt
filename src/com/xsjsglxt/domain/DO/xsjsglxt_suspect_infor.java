package com.xsjsglxt.domain.DO;

//办案模块嫌疑人信息表
public class xsjsglxt_suspect_infor {
	private String suspect_id;// 嫌疑人id
	private String suspect_case;// 所属案件
	private String suspect_name;// 嫌疑人姓名
	private int suspect_sex;// 嫌疑人性别
	private String suspect_identification;// 嫌疑人身份证号码
	private String suspect_captured_time;// 抓获时间
	private String suspect_crime_name;// 涉嫌罪名
	private int suspect_process_type;// 处理类型
	private String suspect_start_time;// 起始时间
	private int suspect_process_long;// 处理时长
	private int suspect_warn_time;// 提醒区间
	private String suspect_end_time;// 结束时间
	private String suspect_gmt_create;// 创建时间
	private String suspect_gmt_modified;// 修改时间

	public String getSuspect_id() {
		return suspect_id;
	}

	public void setSuspect_id(String suspect_id) {
		this.suspect_id = suspect_id;
	}

	public String getSuspect_case() {
		return suspect_case;
	}

	public void setSuspect_case(String suspect_case) {
		this.suspect_case = suspect_case;
	}

	public String getSuspect_name() {
		return suspect_name;
	}

	public void setSuspect_name(String suspect_name) {
		this.suspect_name = suspect_name;
	}

	public int getSuspect_sex() {
		return suspect_sex;
	}

	public void setSuspect_sex(int suspect_sex) {
		this.suspect_sex = suspect_sex;
	}

	public String getSuspect_identification() {
		return suspect_identification;
	}

	public void setSuspect_identification(String suspect_identification) {
		this.suspect_identification = suspect_identification;
	}

	public String getSuspect_captured_time() {
		return suspect_captured_time;
	}

	public void setSuspect_captured_time(String suspect_captured_time) {
		this.suspect_captured_time = suspect_captured_time;
	}

	public String getSuspect_crime_name() {
		return suspect_crime_name;
	}

	public void setSuspect_crime_name(String suspect_crime_name) {
		this.suspect_crime_name = suspect_crime_name;
	}

	public int getSuspect_process_type() {
		return suspect_process_type;
	}

	public void setSuspect_process_type(int suspect_process_type) {
		this.suspect_process_type = suspect_process_type;
	}

	public String getSuspect_start_time() {
		return suspect_start_time;
	}

	public void setSuspect_start_time(String suspect_start_time) {
		this.suspect_start_time = suspect_start_time;
	}

	public int getSuspect_process_long() {
		return suspect_process_long;
	}

	public void setSuspect_process_long(int suspect_process_long) {
		this.suspect_process_long = suspect_process_long;
	}

	public int getSuspect_warn_time() {
		return suspect_warn_time;
	}

	public void setSuspect_warn_time(int suspect_warn_time) {
		this.suspect_warn_time = suspect_warn_time;
	}

	public String getSuspect_gmt_create() {
		return suspect_gmt_create;
	}

	public void setSuspect_gmt_create(String suspect_gmt_create) {
		this.suspect_gmt_create = suspect_gmt_create;
	}

	public String getSuspect_gmt_modified() {
		return suspect_gmt_modified;
	}

	public void setSuspect_gmt_modified(String suspect_gmt_modified) {
		this.suspect_gmt_modified = suspect_gmt_modified;
	}

	public String getSuspect_end_time() {
		return suspect_end_time;
	}

	public void setSuspect_end_time(String suspect_end_time) {
		this.suspect_end_time = suspect_end_time;
	}

}
