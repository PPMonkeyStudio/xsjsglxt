package com.xsjsglxt.domain.DTO.User;

public class meetingSearchDTO {
	private String meeting_id;
	private String meeting_title;
	private String meeting_start_time;
	private String meeting_end_time;
	private String meeting_place;
	private String meeting_compere;

	public meetingSearchDTO(String meeting_id, String meeting_title, String meeting_start_time, String meeting_end_time,
			String meeting_place, String meeting_compere) {
		// TODO Auto-generated constructor stub
		this.meeting_id = meeting_id;
		this.meeting_title = meeting_title;
		this.meeting_start_time = meeting_start_time;
		this.meeting_end_time = meeting_end_time;
		this.meeting_place = meeting_place;
		this.meeting_compere = meeting_compere;
	}

	public meetingSearchDTO() {
		// TODO Auto-generated constructor stub
	}

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

	@Override
	public String toString() {
		return "meetingSearchDTO [meeting_id=" + meeting_id + ", meeting_title=" + meeting_title
				+ ", meeting_start_time=" + meeting_start_time + ", meeting_end_time=" + meeting_end_time
				+ ", meeting_place=" + meeting_place + ", meeting_compere=" + meeting_compere + "]";
	}
}
