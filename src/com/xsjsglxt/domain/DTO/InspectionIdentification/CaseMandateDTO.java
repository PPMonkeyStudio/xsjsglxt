package com.xsjsglxt.domain.DTO.InspectionIdentification;

public class CaseMandateDTO {
	private String xsjsglxt_check_entrustment_book_id; // 委托书id
	private String resevidence_name; // 物证名
	private String check_entrustment_book_num;// 委托书编号
	private String check_entrustment_book_entrustment_unit;// 委托单位
	private String check_entrustment_book_entrustment_unit_name; // 鉴定机构
	private String check_entrustment_book_inspect_time; // 委托时间

	@Override
	public String toString() {
		return "CaseMandateDTO [xsjsglxt_check_entrustment_book_id=" + xsjsglxt_check_entrustment_book_id
				+ ", resevidence_name=" + resevidence_name + ", check_entrustment_book_num="
				+ check_entrustment_book_num + ", check_entrustment_book_entrustment_unit="
				+ check_entrustment_book_entrustment_unit + ", check_entrustment_book_entrustment_unit_name="
				+ check_entrustment_book_entrustment_unit_name + ", check_entrustment_book_inspect_time="
				+ check_entrustment_book_inspect_time + "]";
	}

	public CaseMandateDTO(String xsjsglxt_check_entrustment_book_id, String resevidence_name,
			String check_entrustment_book_num, String check_entrustment_book_entrustment_unit,
			String check_entrustment_book_entrustment_unit_name, String check_entrustment_book_inspect_time) {
		super();
		this.xsjsglxt_check_entrustment_book_id = xsjsglxt_check_entrustment_book_id;
		this.resevidence_name = resevidence_name;
		this.check_entrustment_book_num = check_entrustment_book_num;
		this.check_entrustment_book_entrustment_unit = check_entrustment_book_entrustment_unit;
		this.check_entrustment_book_entrustment_unit_name = check_entrustment_book_entrustment_unit_name;
		this.check_entrustment_book_inspect_time = check_entrustment_book_inspect_time;
	}

	public String getXsjsglxt_check_entrustment_book_id() {
		return xsjsglxt_check_entrustment_book_id;
	}

	public void setXsjsglxt_check_entrustment_book_id(String xsjsglxt_check_entrustment_book_id) {
		this.xsjsglxt_check_entrustment_book_id = xsjsglxt_check_entrustment_book_id;
	}

	public String getResevidence_name() {
		return resevidence_name;
	}

	public void setResevidence_name(String resevidence_name) {
		this.resevidence_name = resevidence_name;
	}

	public String getCheck_entrustment_book_num() {
		return check_entrustment_book_num;
	}

	public void setCheck_entrustment_book_num(String check_entrustment_book_num) {
		this.check_entrustment_book_num = check_entrustment_book_num;
	}

	public String getCheck_entrustment_book_entrustment_unit() {
		return check_entrustment_book_entrustment_unit;
	}

	public void setCheck_entrustment_book_entrustment_unit(String check_entrustment_book_entrustment_unit) {
		this.check_entrustment_book_entrustment_unit = check_entrustment_book_entrustment_unit;
	}

	public String getCheck_entrustment_book_entrustment_unit_name() {
		return check_entrustment_book_entrustment_unit_name;
	}

	public void setCheck_entrustment_book_entrustment_unit_name(String check_entrustment_book_entrustment_unit_name) {
		this.check_entrustment_book_entrustment_unit_name = check_entrustment_book_entrustment_unit_name;
	}

	public String getCheck_entrustment_book_inspect_time() {
		return check_entrustment_book_inspect_time;
	}

	public void setCheck_entrustment_book_inspect_time(String check_entrustment_book_inspect_time) {
		this.check_entrustment_book_inspect_time = check_entrustment_book_inspect_time;
	}

}
