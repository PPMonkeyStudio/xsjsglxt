package com.xsjsglxt.action.User;

import com.xsjsglxt.service.User.MeetingService;

public class MeetingAction {
	private MeetingService meetingService;

	// -----------------------------------------------------------setter/getter方法----------------------------------------------//

	public MeetingService getMeetingService() {
		return meetingService;
	}

	public void setMeetingService(MeetingService meetingService) {
		this.meetingService = meetingService;
	}
}
