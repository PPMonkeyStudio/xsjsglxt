package com.xsjsglxt.service.impl.User;

import com.xsjsglxt.dao.User.MeetingDao;
import com.xsjsglxt.service.User.MeetingService;

public class MeetingServiceImpl implements MeetingService {
	private MeetingDao meetingDao;

	public MeetingDao getMeetingDao() {
		return meetingDao;
	}

	public void setMeetingDao(MeetingDao meetingDao) {
		this.meetingDao = meetingDao;
	}
}
