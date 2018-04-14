package com.xsjsglxt.domain.DO;

public class xsjsglxt_scheduling {
	private String xsjsglxt_scheduling_id; // 排班表id
	private String scheduling_leader; // 带班领导
	private String scheduling_main; // 主班
	private String scheduling_assistant; // 副班
	private String scheduling_time; // 时间
	private String scheduling_gmt_create;
	private String scheduling_gmt_modified;

	@Override
	public String toString() {
		return "xsjsglxt_scheduling [xsjsglxt_scheduling_id=" + xsjsglxt_scheduling_id + ", scheduling_leader="
				+ scheduling_leader + ", scheduling_main=" + scheduling_main + ", scheduling_assistant="
				+ scheduling_assistant + ", scheduling_gmt_create=" + scheduling_gmt_create
				+ ", scheduling_gmt_modified=" + scheduling_gmt_modified + "]";
	}

	public String getScheduling_time() {
		return scheduling_time;
	}

	public void setScheduling_time(String scheduling_time) {
		this.scheduling_time = scheduling_time;
	}

	public String getXsjsglxt_scheduling_id() {
		return xsjsglxt_scheduling_id;
	}

	public void setXsjsglxt_scheduling_id(String xsjsglxt_scheduling_id) {
		this.xsjsglxt_scheduling_id = xsjsglxt_scheduling_id;
	}

	public String getScheduling_leader() {
		return scheduling_leader;
	}

	public void setScheduling_leader(String scheduling_leader) {
		this.scheduling_leader = scheduling_leader;
	}

	public String getScheduling_main() {
		return scheduling_main;
	}

	public void setScheduling_main(String scheduling_main) {
		this.scheduling_main = scheduling_main;
	}

	public String getScheduling_assistant() {
		return scheduling_assistant;
	}

	public void setScheduling_assistant(String scheduling_assistant) {
		this.scheduling_assistant = scheduling_assistant;
	}

	public String getScheduling_gmt_create() {
		return scheduling_gmt_create;
	}

	public void setScheduling_gmt_create(String scheduling_gmt_create) {
		this.scheduling_gmt_create = scheduling_gmt_create;
	}

	public String getScheduling_gmt_modified() {
		return scheduling_gmt_modified;
	}

	public void setScheduling_gmt_modified(String scheduling_gmt_modified) {
		this.scheduling_gmt_modified = scheduling_gmt_modified;
	}
}
