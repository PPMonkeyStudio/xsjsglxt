package com.xsjsglxt.domain.DO;

//不受理委托鉴定告知表
public class xsjsglxt_not_acceptance_entrustment_inform {
	private String xsjsglxt_not_acceptance_entrustment_inform_id;// 不受理委托鉴定告知ID
	private String not_acceptance_entrustment_inform_belong_entrustment_book;// 所属委托书
	private String not_acceptance_entrustment_inform_reason;// 不予受理理由
	private String not_acceptance_entrustment_inform_inputhuman_name;// 填表人
	private String not_acceptance_entrustment_inform_approvalhuman_name;// 批准人
	private String not_acceptance_entrustment_inform_approval_time;// 批准时间
	private String not_acceptance_entrustment_inform_gmt_create;//
	private String not_acceptance_entrustment_inform_gmt_modified;//

	@Override
	public String toString() {
		return "xsjsglxt_not_acceptance_entrustment_inform [xsjsglxt_not_acceptance_entrustment_inform_id="
				+ xsjsglxt_not_acceptance_entrustment_inform_id
				+ ", not_acceptance_entrustment_inform_belong_entrustment_book="
				+ not_acceptance_entrustment_inform_belong_entrustment_book
				+ ", not_acceptance_entrustment_inform_reason=" + not_acceptance_entrustment_inform_reason
				+ ", not_acceptance_entrustment_inform_inputhuman_name="
				+ not_acceptance_entrustment_inform_inputhuman_name
				+ ", not_acceptance_entrustment_inform_approvalhuman_name="
				+ not_acceptance_entrustment_inform_approvalhuman_name
				+ ", not_acceptance_entrustment_inform_approval_time=" + not_acceptance_entrustment_inform_approval_time
				+ ", not_acceptance_entrustment_inform_gmt_create=" + not_acceptance_entrustment_inform_gmt_create
				+ ", not_acceptance_entrustment_inform_gmt_modified=" + not_acceptance_entrustment_inform_gmt_modified
				+ "]";
	}

	public String getXsjsglxt_not_acceptance_entrustment_inform_id() {
		return xsjsglxt_not_acceptance_entrustment_inform_id;
	}

	public String getNot_acceptance_entrustment_inform_belong_entrustment_book() {
		return not_acceptance_entrustment_inform_belong_entrustment_book;
	}

	public String getNot_acceptance_entrustment_inform_reason() {
		return not_acceptance_entrustment_inform_reason;
	}

	public String getNot_acceptance_entrustment_inform_inputhuman_name() {
		return not_acceptance_entrustment_inform_inputhuman_name;
	}

	public String getNot_acceptance_entrustment_inform_approvalhuman_name() {
		return not_acceptance_entrustment_inform_approvalhuman_name;
	}

	public String getNot_acceptance_entrustment_inform_approval_time() {
		return not_acceptance_entrustment_inform_approval_time;
	}

	public String getNot_acceptance_entrustment_inform_gmt_create() {
		return not_acceptance_entrustment_inform_gmt_create;
	}

	public String getNot_acceptance_entrustment_inform_gmt_modified() {
		return not_acceptance_entrustment_inform_gmt_modified;
	}

	public void setXsjsglxt_not_acceptance_entrustment_inform_id(String xsjsglxt_not_acceptance_entrustment_inform_id) {
		this.xsjsglxt_not_acceptance_entrustment_inform_id = xsjsglxt_not_acceptance_entrustment_inform_id;
	}

	public void setNot_acceptance_entrustment_inform_belong_entrustment_book(
			String not_acceptance_entrustment_inform_belong_entrustment_book) {
		this.not_acceptance_entrustment_inform_belong_entrustment_book = not_acceptance_entrustment_inform_belong_entrustment_book;
	}

	public void setNot_acceptance_entrustment_inform_reason(String not_acceptance_entrustment_inform_reason) {
		this.not_acceptance_entrustment_inform_reason = not_acceptance_entrustment_inform_reason;
	}

	public void setNot_acceptance_entrustment_inform_inputhuman_name(
			String not_acceptance_entrustment_inform_inputhuman_name) {
		this.not_acceptance_entrustment_inform_inputhuman_name = not_acceptance_entrustment_inform_inputhuman_name;
	}

	public void setNot_acceptance_entrustment_inform_approvalhuman_name(
			String not_acceptance_entrustment_inform_approvalhuman_name) {
		this.not_acceptance_entrustment_inform_approvalhuman_name = not_acceptance_entrustment_inform_approvalhuman_name;
	}

	public void setNot_acceptance_entrustment_inform_approval_time(
			String not_acceptance_entrustment_inform_approval_time) {
		this.not_acceptance_entrustment_inform_approval_time = not_acceptance_entrustment_inform_approval_time;
	}

	public void setNot_acceptance_entrustment_inform_gmt_create(String not_acceptance_entrustment_inform_gmt_create) {
		this.not_acceptance_entrustment_inform_gmt_create = not_acceptance_entrustment_inform_gmt_create;
	}

	public void setNot_acceptance_entrustment_inform_gmt_modified(
			String not_acceptance_entrustment_inform_gmt_modified) {
		this.not_acceptance_entrustment_inform_gmt_modified = not_acceptance_entrustment_inform_gmt_modified;
	}

}
