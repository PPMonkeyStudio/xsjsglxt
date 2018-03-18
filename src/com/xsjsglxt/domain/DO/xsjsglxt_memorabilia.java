package com.xsjsglxt.domain.DO;

public class xsjsglxt_memorabilia {
	private String memorabilia_id;
	private String memorabilia_title;
	private String memorabilia_time;
	private String memorabilia_join_human;
	private String memorabilia_content;
	private String memorabilia_gmt_create;
	private String memorabilia_gmt_modified;

	@Override
	public String toString() {
		return "xsjsglxt_memorabilia [memorabilia_id=" + memorabilia_id + ", memorabilia_title=" + memorabilia_title
				+ ", memorabilia_time=" + memorabilia_time + ", memorabilia_join_human=" + memorabilia_join_human
				+ ", memorabilia_content=" + memorabilia_content + ", memorabilia_gmt_create=" + memorabilia_gmt_create
				+ ", memorabilia_gmt_modified=" + memorabilia_gmt_modified + "]";
	}

	public String getMemorabilia_id() {
		return memorabilia_id;
	}

	public void setMemorabilia_id(String memorabilia_id) {
		this.memorabilia_id = memorabilia_id;
	}

	public String getMemorabilia_title() {
		return memorabilia_title;
	}

	public void setMemorabilia_title(String memorabilia_title) {
		this.memorabilia_title = memorabilia_title;
	}

	public String getMemorabilia_time() {
		return memorabilia_time;
	}

	public void setMemorabilia_time(String memorabilia_time) {
		this.memorabilia_time = memorabilia_time;
	}

	public String getMemorabilia_join_human() {
		return memorabilia_join_human;
	}

	public void setMemorabilia_join_human(String memorabilia_join_human) {
		this.memorabilia_join_human = memorabilia_join_human;
	}

	public String getMemorabilia_content() {
		return memorabilia_content;
	}

	public void setMemorabilia_content(String memorabilia_content) {
		this.memorabilia_content = memorabilia_content;
	}

	public String getMemorabilia_gmt_create() {
		return memorabilia_gmt_create;
	}

	public void setMemorabilia_gmt_create(String memorabilia_gmt_create) {
		this.memorabilia_gmt_create = memorabilia_gmt_create;
	}

	public String getMemorabilia_gmt_modified() {
		return memorabilia_gmt_modified;
	}

	public void setMemorabilia_gmt_modified(String memorabilia_gmt_modified) {
		this.memorabilia_gmt_modified = memorabilia_gmt_modified;
	}
}
