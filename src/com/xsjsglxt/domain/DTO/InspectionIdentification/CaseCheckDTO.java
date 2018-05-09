package com.xsjsglxt.domain.DTO.InspectionIdentification;

public class CaseCheckDTO {
	private String xsjsglxt_inspection_record_id;
	private String resevidence_name; // 物证名
	private String inspection_start_time;
	private String inspection_method; // 检验方法
	private String inspection_location;// 检验地点
	private String inspection_option; // 检验意见

	public CaseCheckDTO(String xsjsglxt_inspection_record_id, String resevidence_name, String inspection_start_time,
			String inspection_method, String inspection_location, String inspection_option) {
		super();
		this.xsjsglxt_inspection_record_id = xsjsglxt_inspection_record_id;
		this.resevidence_name = resevidence_name;
		this.inspection_start_time = inspection_start_time;
		this.inspection_method = inspection_method;
		this.inspection_location = inspection_location;
		this.inspection_option = inspection_option;
	}

	@Override
	public String toString() {
		return "CaseCheckDTO [xsjsglxt_inspection_record_id=" + xsjsglxt_inspection_record_id + ", resevidence_name="
				+ resevidence_name + ", inspection_method=" + inspection_method + ", inspection_location="
				+ inspection_location + ", inspection_option=" + inspection_option + "]";
	}

	public String getInspection_start_time() {
		return inspection_start_time;
	}

	public void setInspection_start_time(String inspection_start_time) {
		this.inspection_start_time = inspection_start_time;
	}

	public String getXsjsglxt_inspection_record_id() {
		return xsjsglxt_inspection_record_id;
	}

	public void setXsjsglxt_inspection_record_id(String xsjsglxt_inspection_record_id) {
		this.xsjsglxt_inspection_record_id = xsjsglxt_inspection_record_id;
	}

	public String getResevidence_name() {
		return resevidence_name;
	}

	public void setResevidence_name(String resevidence_name) {
		this.resevidence_name = resevidence_name;
	}

	public String getInspection_method() {
		return inspection_method;
	}

	public void setInspection_method(String inspection_method) {
		this.inspection_method = inspection_method;
	}

	public String getInspection_location() {
		return inspection_location;
	}

	public void setInspection_location(String inspection_location) {
		this.inspection_location = inspection_location;
	}

	public String getInspection_option() {
		return inspection_option;
	}

	public void setInspection_option(String inspection_option) {
		this.inspection_option = inspection_option;
	}

}
