package com.xsjsglxt.action.User;

import com.opensymphony.xwork2.ActionSupport;
import com.xsjsglxt.domain.DO.xsjsglxt_meeting;
import com.xsjsglxt.service.User.MeetingService;

public class MeetingAction extends ActionSupport {
	private MeetingService meetingService;
	private xsjsglxt_meeting meet;

	public String skipToMeetRecords() {
		return "intoMeeting";
	}

	// -----------------------------------------------------------setter/getter方法----------------------------------------------//

	public MeetingService getMeetingService() {
		return meetingService;
	}

	public void setMeetingService(MeetingService meetingService) {
		this.meetingService = meetingService;
	}

	public xsjsglxt_meeting getMeet() {
		return meet;
	}

	public void setMeet(xsjsglxt_meeting meet) {
		this.meet = meet;
	}
}
