package com.xsjsglxt.domain.DO;

/**
 * 
 * @author 孙毅
 * 介绍信
 *
 */
public class xsjsglxt_introduce_letter {
	private String xsjsglxt_introduce_letter_id;
	private String introduce_letter_serial_number;// 介绍信编号
	private String introduce_letter_tounit;// 目的单位
	private String introduce_letter_introduceMan;// 介绍人
	private String introduce_letter_number;// 介绍人数量
	private String introduce_letter_reasons;// 事由
	private String introduce_time;// 开始时间
	private String introduce_time_limit;// 界限
	private String introduce_approve_man;// 审批人
	private String introduce_approve_time;// 审批时间
	private String introduce_approve_status;// 审批状态
	private String introduce_gmt_create;// 创建时间
	private String introduce_gmt_modified;// 修改时间

	public xsjsglxt_introduce_letter() {
		// TODO Auto-generated constructor stub
	}

	public String getXsjsglxt_introduce_letter_id() {
		return xsjsglxt_introduce_letter_id;
	}

	public void setXsjsglxt_introduce_letter_id(String xsjsglxt_introduce_letter_id) {
		this.xsjsglxt_introduce_letter_id = xsjsglxt_introduce_letter_id;
	}

	public String getIntroduce_letter_serial_number() {
		return introduce_letter_serial_number;
	}

	public void setIntroduce_letter_serial_number(String introduce_letter_serial_number) {
		this.introduce_letter_serial_number = introduce_letter_serial_number;
	}

	public String getIntroduce_letter_tounit() {
		return introduce_letter_tounit;
	}

	public void setIntroduce_letter_tounit(String introduce_letter_tounit) {
		this.introduce_letter_tounit = introduce_letter_tounit;
	}

	public String getIntroduce_letter_introduceMan() {
		return introduce_letter_introduceMan;
	}

	public void setIntroduce_letter_introduceMan(String introduce_letter_introduceMan) {
		this.introduce_letter_introduceMan = introduce_letter_introduceMan;
	}

	public String getIntroduce_letter_number() {
		return introduce_letter_number;
	}

	public void setIntroduce_letter_number(String introduce_letter_number) {
		this.introduce_letter_number = introduce_letter_number;
	}

	public String getIntroduce_letter_reasons() {
		return introduce_letter_reasons;
	}

	public void setIntroduce_letter_reasons(String introduce_letter_reasons) {
		this.introduce_letter_reasons = introduce_letter_reasons;
	}

	public String getIntroduce_time() {
		return introduce_time;
	}

	public void setIntroduce_time(String introduce_time) {
		this.introduce_time = introduce_time;
	}

	public String getIntroduce_time_limit() {
		return introduce_time_limit;
	}

	public void setIntroduce_time_limit(String introduce_time_limit) {
		this.introduce_time_limit = introduce_time_limit;
	}

	public String getIntroduce_approve_man() {
		return introduce_approve_man;
	}

	public void setIntroduce_approve_man(String introduce_approve_man) {
		this.introduce_approve_man = introduce_approve_man;
	}

	public String getIntroduce_approve_time() {
		return introduce_approve_time;
	}

	public void setIntroduce_approve_time(String introduce_approve_time) {
		this.introduce_approve_time = introduce_approve_time;
	}

	public String getIntroduce_gmt_create() {
		return introduce_gmt_create;
	}

	public void setIntroduce_gmt_create(String introduce_gmt_create) {
		this.introduce_gmt_create = introduce_gmt_create;
	}

	public String getIntroduce_gmt_modified() {
		return introduce_gmt_modified;
	}

	public void setIntroduce_gmt_modified(String introduce_gmt_modified) {
		this.introduce_gmt_modified = introduce_gmt_modified;
	}

	public String getIntroduce_approve_status() {
		return introduce_approve_status;
	}

	public void setIntroduce_approve_status(String introduce_approve_status) {
		this.introduce_approve_status = introduce_approve_status;
	}

	@Override
	public String toString() {
		return "xsjsglxt_introduce_letter [xsjsglxt_introduce_letter_id=" + xsjsglxt_introduce_letter_id
				+ ", introduce_letter_serial_number=" + introduce_letter_serial_number + ", introduce_letter_tounit="
				+ introduce_letter_tounit + ", introduce_letter_introduceMan=" + introduce_letter_introduceMan
				+ ", introduce_letter_number=" + introduce_letter_number + ", introduce_letter_reasons="
				+ introduce_letter_reasons + ", introduce_time=" + introduce_time + ", introduce_time_limit="
				+ introduce_time_limit + ", introduce_approve_man=" + introduce_approve_man
				+ ", introduce_approve_time=" + introduce_approve_time + ", introduce_gmt_create="
				+ introduce_gmt_create + ", introduce_gmt_modified=" + introduce_gmt_modified + "]";
	}

	public xsjsglxt_introduce_letter(String xsjsglxt_introduce_letter_id, String introduce_letter_serial_number,
			String introduce_letter_tounit, String introduce_letter_introduceMan, String introduce_letter_number,
			String introduce_letter_reasons, String introduce_time, String introduce_time_limit,
			String introduce_approve_man, String introduce_approve_time, String introduce_gmt_create,
			String introduce_gmt_modified) {
		super();
		this.xsjsglxt_introduce_letter_id = xsjsglxt_introduce_letter_id;
		this.introduce_letter_serial_number = introduce_letter_serial_number;
		this.introduce_letter_tounit = introduce_letter_tounit;
		this.introduce_letter_introduceMan = introduce_letter_introduceMan;
		this.introduce_letter_number = introduce_letter_number;
		this.introduce_letter_reasons = introduce_letter_reasons;
		this.introduce_time = introduce_time;
		this.introduce_time_limit = introduce_time_limit;
		this.introduce_approve_man = introduce_approve_man;
		this.introduce_approve_time = introduce_approve_time;
		this.introduce_gmt_create = introduce_gmt_create;
		this.introduce_gmt_modified = introduce_gmt_modified;
	}

}
