package com.xsjsglxt.domain.DO;

/*
 * 
 * 
 * @author 孙毅
 */

public class xsjsglxt_meeting {

	private String meeting_id; // 会议记录id
	private String meeting_title; // 会议标题
	private String meeting_start_time; // 会议开始时间 精确到分
	private String meeting_end_time; // 会议结束时间 精确到分
	private String meeting_place; // 会议地点
	private String meeting_compere; // 会议主持人
	private String meeting_record_human; // 会议记录人
	private String meeting_join_human; // 会议参与人
	private String meeting_leave_human; // 会议请假人
	private String meeting_content; // 会议内容
	private String meeting_gmt_create; // 会议对象创建时间
	private String meeting_gmt_modified; // 会议对象修改时间

	public String getMeeting_id() {
		return meeting_id;
	}

	public void setMeeting_id(String meeting_id) {
		this.meeting_id = meeting_id;
	}

	public String getMeeting_title() {
		return meeting_title;
	}

	public void setMeeting_title(String meeting_title) {
		this.meeting_title = meeting_title;
	}

	public String getMeeting_start_time() {
		return meeting_start_time;
	}

	public void setMeeting_start_time(String meeting_start_time) {
		this.meeting_start_time = meeting_start_time;
	}

	public String getMeeting_end_time() {
		return meeting_end_time;
	}

	public void setMeeting_end_time(String meeting_end_time) {
		this.meeting_end_time = meeting_end_time;
	}

	public String getMeeting_place() {
		return meeting_place;
	}

	public void setMeeting_place(String meeting_place) {
		this.meeting_place = meeting_place;
	}

	public String getMeeting_compere() {
		return meeting_compere;
	}

	public void setMeeting_compere(String meeting_compere) {
		this.meeting_compere = meeting_compere;
	}

	public String getMeeting_record_human() {
		return meeting_record_human;
	}

	public void setMeeting_record_human(String meeting_record_human) {
		this.meeting_record_human = meeting_record_human;
	}

	public String getMeeting_join_human() {
		return meeting_join_human;
	}

	public void setMeeting_join_human(String meeting_join_human) {
		this.meeting_join_human = meeting_join_human;
	}

	public String getMeeting_leave_human() {
		return meeting_leave_human;
	}

	public void setMeeting_leave_human(String meeting_leave_human) {
		this.meeting_leave_human = meeting_leave_human;
	}

	public String getMeeting_content() {
		return meeting_content;
	}

	public void setMeeting_content(String meeting_content) {
		this.meeting_content = meeting_content;
	}

	public String getMeeting_gmt_create() {
		return meeting_gmt_create;
	}

	public void setMeeting_gmt_create(String meeting_gmt_create) {
		this.meeting_gmt_create = meeting_gmt_create;
	}

	public String getMeeting_gmt_modified() {
		return meeting_gmt_modified;
	}

	public void setMeeting_gmt_modified(String meeting_gmt_modified) {
		this.meeting_gmt_modified = meeting_gmt_modified;
	}

}
