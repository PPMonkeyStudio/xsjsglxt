package com.xsjsglxt.domain.DO;

//办案案件信息
public class xsjsglxt_handle_case {
	private String handle_case_id;// 案件id
	private String handle_case_name;// 案件名称
	private int handle_case_state;// 案件状态：0在侦1已破
	private String handle_main_police;// 主办民警
	private String handle_assistant_police;// 协办民警
	private String handle_middle_captain;// 中队长
	private String handle_gmt_create;// 创建时间
	private String handle_gmt_modified;// 修改时间

	public String getHandle_case_id() {
		return handle_case_id;
	}

	public void setHandle_case_id(String handle_case_id) {
		this.handle_case_id = handle_case_id;
	}

	public String getHandle_case_name() {
		return handle_case_name;
	}

	public void setHandle_case_name(String handle_case_name) {
		this.handle_case_name = handle_case_name;
	}

	public int getHandle_case_state() {
		return handle_case_state;
	}

	public void setHandle_case_state(int handle_case_state) {
		this.handle_case_state = handle_case_state;
	}

	public String getHandle_main_police() {
		return handle_main_police;
	}

	public void setHandle_main_police(String handle_main_police) {
		this.handle_main_police = handle_main_police;
	}

	public String getHandle_assistant_police() {
		return handle_assistant_police;
	}

	public void setHandle_assistant_police(String handle_assistant_police) {
		this.handle_assistant_police = handle_assistant_police;
	}

	public String getHandle_middle_captain() {
		return handle_middle_captain;
	}

	public void setHandle_middle_captain(String handle_middle_captain) {
		this.handle_middle_captain = handle_middle_captain;
	}

	public String getHandle_gmt_create() {
		return handle_gmt_create;
	}

	public void setHandle_gmt_create(String handle_gmt_create) {
		this.handle_gmt_create = handle_gmt_create;
	}

	public String getHandle_gmt_modified() {
		return handle_gmt_modified;
	}

	public void setHandle_gmt_modified(String handle_gmt_modified) {
		this.handle_gmt_modified = handle_gmt_modified;
	}

}
