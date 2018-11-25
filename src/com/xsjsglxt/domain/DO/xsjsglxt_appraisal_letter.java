package com.xsjsglxt.domain.DO;

//鉴定文书表
public class xsjsglxt_appraisal_letter {
	private String xsjsglxt_appraisal_letter_id;// 鉴定文书ID
	private String appraisal_letter_belong_entrustment_book;// 所属委托书
	private String appraisal_letter_num;// 鉴定书编号
	private String appraisal_letter_simple_case_situation;// 案件情况摘要
	private String appraisal_letter_sample_situation;// 检材和样本（或检验对象）
	private String appraisal_letter_man1_duty;// 鉴定人1职务
	private String appraisal_letter_man1_name;// 鉴定人1姓名
	private String appraisal_letter_man2_duty;// 鉴定人2职务
	private String appraisal_letter_man2_name;// 鉴定人2姓名
	private String appraisal_letter_authorization_duty;// 授权签字人职务
	private String appraisal_letter_authorization_name;// 授权签字人姓名
	private String appraisal_letter_mark;// 备注
	private String appraisal_letter_date;// 鉴定日期
	private String appraisal_letter_inspection;// 检验
	private String appraisal_letter_argumentation;// 论证
	private String appraisal_letter_expert_opinion;// 鉴定意见
	private String appraisal_letter_type;// 鉴定文书类型
	private String appraisal_letter_gmt_create;
	private String appraisal_letter_gmt_modified;

	@Override
	public String toString() {
		return "xsjsglxt_appraisal_letter [xsjsglxt_appraisal_letter_id=" + xsjsglxt_appraisal_letter_id
				+ ", appraisal_letter_belong_entrustment_book=" + appraisal_letter_belong_entrustment_book
				+ ", appraisal_letter_num=" + appraisal_letter_num + ", appraisal_letter_simple_case_situation="
				+ appraisal_letter_simple_case_situation + ", appraisal_letter_sample_situation="
				+ appraisal_letter_sample_situation + ", appraisal_letter_man1_duty=" + appraisal_letter_man1_duty
				+ ", appraisal_letter_man1_name=" + appraisal_letter_man1_name + ", appraisal_letter_man2_duty="
				+ appraisal_letter_man2_duty + ", appraisal_letter_man2_name=" + appraisal_letter_man2_name
				+ ", appraisal_letter_authorization_duty=" + appraisal_letter_authorization_duty
				+ ", appraisal_letter_authorization_name=" + appraisal_letter_authorization_name
				+ ", appraisal_letter_mark=" + appraisal_letter_mark + ", appraisal_letter_date="
				+ appraisal_letter_date + ", appraisal_letter_inspection=" + appraisal_letter_inspection
				+ ", appraisal_letter_argumentation=" + appraisal_letter_argumentation
				+ ", appraisal_letter_expert_opinion=" + appraisal_letter_expert_opinion + ", appraisal_letter_type="
				+ appraisal_letter_type + ", appraisal_letter_gmt_create=" + appraisal_letter_gmt_create
				+ ", appraisal_letter_gmt_modified=" + appraisal_letter_gmt_modified + "]";
	}

	public String getAppraisal_letter_simple_case_situation() {
		return appraisal_letter_simple_case_situation;
	}

	public String getAppraisal_letter_sample_situation() {
		return appraisal_letter_sample_situation;
	}

	public String getAppraisal_letter_man1_duty() {
		return appraisal_letter_man1_duty;
	}

	public String getAppraisal_letter_man1_name() {
		return appraisal_letter_man1_name;
	}

	public String getAppraisal_letter_man2_duty() {
		return appraisal_letter_man2_duty;
	}

	public String getAppraisal_letter_man2_name() {
		return appraisal_letter_man2_name;
	}

	public String getAppraisal_letter_authorization_duty() {
		return appraisal_letter_authorization_duty;
	}

	public String getAppraisal_letter_authorization_name() {
		return appraisal_letter_authorization_name;
	}

	public String getAppraisal_letter_mark() {
		return appraisal_letter_mark;
	}

	public String getAppraisal_letter_date() {
		return appraisal_letter_date;
	}

	public void setAppraisal_letter_simple_case_situation(String appraisal_letter_simple_case_situation) {
		this.appraisal_letter_simple_case_situation = appraisal_letter_simple_case_situation;
	}

	public void setAppraisal_letter_sample_situation(String appraisal_letter_sample_situation) {
		this.appraisal_letter_sample_situation = appraisal_letter_sample_situation;
	}

	public void setAppraisal_letter_man1_duty(String appraisal_letter_man1_duty) {
		this.appraisal_letter_man1_duty = appraisal_letter_man1_duty;
	}

	public void setAppraisal_letter_man1_name(String appraisal_letter_man1_name) {
		this.appraisal_letter_man1_name = appraisal_letter_man1_name;
	}

	public void setAppraisal_letter_man2_duty(String appraisal_letter_man2_duty) {
		this.appraisal_letter_man2_duty = appraisal_letter_man2_duty;
	}

	public void setAppraisal_letter_man2_name(String appraisal_letter_man2_name) {
		this.appraisal_letter_man2_name = appraisal_letter_man2_name;
	}

	public void setAppraisal_letter_authorization_duty(String appraisal_letter_authorization_duty) {
		this.appraisal_letter_authorization_duty = appraisal_letter_authorization_duty;
	}

	public void setAppraisal_letter_authorization_name(String appraisal_letter_authorization_name) {
		this.appraisal_letter_authorization_name = appraisal_letter_authorization_name;
	}

	public void setAppraisal_letter_mark(String appraisal_letter_mark) {
		this.appraisal_letter_mark = appraisal_letter_mark;
	}

	public void setAppraisal_letter_date(String appraisal_letter_date) {
		this.appraisal_letter_date = appraisal_letter_date;
	}

	public String getAppraisal_letter_num() {
		return appraisal_letter_num;
	}

	public void setAppraisal_letter_num(String appraisal_letter_num) {
		this.appraisal_letter_num = appraisal_letter_num;
	}

	public String getAppraisal_letter_type() {
		return appraisal_letter_type;
	}

	public void setAppraisal_letter_type(String appraisal_letter_type) {
		this.appraisal_letter_type = appraisal_letter_type;
	}

	public String getXsjsglxt_appraisal_letter_id() {
		return xsjsglxt_appraisal_letter_id;
	}

	public String getAppraisal_letter_belong_entrustment_book() {
		return appraisal_letter_belong_entrustment_book;
	}

	public String getAppraisal_letter_inspection() {
		return appraisal_letter_inspection;
	}

	public String getAppraisal_letter_argumentation() {
		return appraisal_letter_argumentation;
	}

	public String getAppraisal_letter_expert_opinion() {
		return appraisal_letter_expert_opinion;
	}

	public String getAppraisal_letter_gmt_create() {
		return appraisal_letter_gmt_create;
	}

	public String getAppraisal_letter_gmt_modified() {
		return appraisal_letter_gmt_modified;
	}

	public void setXsjsglxt_appraisal_letter_id(String xsjsglxt_appraisal_letter_id) {
		this.xsjsglxt_appraisal_letter_id = xsjsglxt_appraisal_letter_id;
	}

	public void setAppraisal_letter_belong_entrustment_book(String appraisal_letter_belong_entrustment_book) {
		this.appraisal_letter_belong_entrustment_book = appraisal_letter_belong_entrustment_book;
	}

	public void setAppraisal_letter_inspection(String appraisal_letter_inspection) {
		this.appraisal_letter_inspection = appraisal_letter_inspection;
	}

	public void setAppraisal_letter_argumentation(String appraisal_letter_argumentation) {
		this.appraisal_letter_argumentation = appraisal_letter_argumentation;
	}

	public void setAppraisal_letter_expert_opinion(String appraisal_letter_expert_opinion) {
		this.appraisal_letter_expert_opinion = appraisal_letter_expert_opinion;
	}

	public void setAppraisal_letter_gmt_create(String appraisal_letter_gmt_create) {
		this.appraisal_letter_gmt_create = appraisal_letter_gmt_create;
	}

	public void setAppraisal_letter_gmt_modified(String appraisal_letter_gmt_modified) {
		this.appraisal_letter_gmt_modified = appraisal_letter_gmt_modified;
	}

}
