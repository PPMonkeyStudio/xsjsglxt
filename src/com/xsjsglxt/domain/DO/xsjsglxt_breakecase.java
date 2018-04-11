package com.xsjsglxt.domain.DO;

public class xsjsglxt_breakecase {

	private String xsjsglxt_breakecase_id;// 破案记录ID

	private String breakecase_type;// 案件类型

	private String breakecase_case;// 所属案件

	private String breakecase_according;// 破案依据

	private String breakecase_caseTime;// 破案时间

	private String breakecase_waitbreakecase;// 带破案件

	private String breakecase_remarks;// 备注

	private String breakecase_gmt_create;// 创建时间

	private String breakecase_gmt_modified;// 修改时间

	public xsjsglxt_breakecase() {

		// TODO Auto-generated constructor stub
	}

	public xsjsglxt_breakecase(String xsjsglxt_breakecase_id, String breakecase_type, String breakecase_case,
			String breakecase_according, String breakecase_caseTime, String breakecase_waitbreakecase,
			String breakecase_remarks, String breakecase_gmt_create, String breakecase_gmt_modified) {
		super();
		this.xsjsglxt_breakecase_id = xsjsglxt_breakecase_id;
		this.breakecase_type = breakecase_type;
		this.breakecase_case = breakecase_case;
		this.breakecase_according = breakecase_according;
		this.breakecase_caseTime = breakecase_caseTime;
		this.breakecase_waitbreakecase = breakecase_waitbreakecase;
		this.breakecase_remarks = breakecase_remarks;
		this.breakecase_gmt_create = breakecase_gmt_create;
		this.breakecase_gmt_modified = breakecase_gmt_modified;
	}

	@Override
	public String toString() {
		return "xsjsglxt_breakecase [xsjsglxt_breakecase_id=" + xsjsglxt_breakecase_id + ", breakecase_type="
				+ breakecase_type + ", breakecase_case=" + breakecase_case + ", breakecase_according="
				+ breakecase_according + ", breakecase_caseTime=" + breakecase_caseTime + ", breakecase_waitbreakecase="
				+ breakecase_waitbreakecase + ", breakecase_remarks=" + breakecase_remarks + ", breakecase_gmt_create="
				+ breakecase_gmt_create + ", breakecase_gmt_modified=" + breakecase_gmt_modified + "]";
	}

	public String getXsjsglxt_breakecase_id() {
		return xsjsglxt_breakecase_id;
	}

	public void setXsjsglxt_breakecase_id(String xsjsglxt_breakecase_id) {
		this.xsjsglxt_breakecase_id = xsjsglxt_breakecase_id;
	}

	public String getBreakecase_type() {
		return breakecase_type;
	}

	public void setBreakecase_type(String breakecase_type) {
		this.breakecase_type = breakecase_type;
	}

	public String getBreakecase_case() {
		return breakecase_case;
	}

	public void setBreakecase_case(String breakecase_case) {
		this.breakecase_case = breakecase_case;
	}

	public String getBreakecase_according() {
		return breakecase_according;
	}

	public void setBreakecase_according(String breakecase_according) {
		this.breakecase_according = breakecase_according;
	}

	public String getBreakecase_caseTime() {
		return breakecase_caseTime;
	}

	public void setBreakecase_caseTime(String breakecase_caseTime) {
		this.breakecase_caseTime = breakecase_caseTime;
	}

	public String getBreakecase_waitbreakecase() {
		return breakecase_waitbreakecase;
	}

	public void setBreakecase_waitbreakecase(String breakecase_waitbreakecase) {
		this.breakecase_waitbreakecase = breakecase_waitbreakecase;
	}

	public String getBreakecase_remarks() {
		return breakecase_remarks;
	}

	public void setBreakecase_remarks(String breakecase_remarks) {
		this.breakecase_remarks = breakecase_remarks;
	}

	public String getBreakecase_gmt_create() {
		return breakecase_gmt_create;
	}

	public void setBreakecase_gmt_create(String breakecase_gmt_create) {
		this.breakecase_gmt_create = breakecase_gmt_create;
	}

	public String getBreakecase_gmt_modified() {
		return breakecase_gmt_modified;
	}

	public void setBreakecase_gmt_modified(String breakecase_gmt_modified) {
		this.breakecase_gmt_modified = breakecase_gmt_modified;
	}

}
