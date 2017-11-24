package com.xsjsglxt.domain.DO;

//检验记录及结论表
public class xsjsglxt_check_record_conclusion {
	private String xsjsglxt_check_record_conclusion_id;// 检验记录及结论ID
	private String check_record_conclusion_gmt_create;// 创建时间
	private String check_record_conclusion_gmt_modified;// 修改时间

	@Override
	public String toString() {
		return "xsjsglxt_check_record_conclusion [xsjsglxt_check_record_conclusion_id="
				+ xsjsglxt_check_record_conclusion_id + ", check_record_conclusion_gmt_create="
				+ check_record_conclusion_gmt_create + ", check_record_conclusion_gmt_modified="
				+ check_record_conclusion_gmt_modified + "]";
	}

	public String getXsjsglxt_check_record_conclusion_id() {
		return xsjsglxt_check_record_conclusion_id;
	}

	public void setXsjsglxt_check_record_conclusion_id(String xsjsglxt_check_record_conclusion_id) {
		this.xsjsglxt_check_record_conclusion_id = xsjsglxt_check_record_conclusion_id;
	}

	public String getCheck_record_conclusion_gmt_create() {
		return check_record_conclusion_gmt_create;
	}

	public void setCheck_record_conclusion_gmt_create(String check_record_conclusion_gmt_create) {
		this.check_record_conclusion_gmt_create = check_record_conclusion_gmt_create;
	}

	public String getCheck_record_conclusion_gmt_modified() {
		return check_record_conclusion_gmt_modified;
	}

	public void setCheck_record_conclusion_gmt_modified(String check_record_conclusion_gmt_modified) {
		this.check_record_conclusion_gmt_modified = check_record_conclusion_gmt_modified;
	}

}
