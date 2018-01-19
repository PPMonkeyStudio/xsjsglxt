package com.xsjsglxt.service.impl.User;

import com.xsjsglxt.dao.User.MeetingDao;
import com.xsjsglxt.domain.DO.xsjsglxt_meeting;
import com.xsjsglxt.service.User.MeetingService;

import util.TeamUtil;

public class MeetingServiceImpl implements MeetingService {
	private MeetingDao meetingDao;

	public MeetingDao getMeetingDao() {
		return meetingDao;
	}

	public void setMeetingDao(MeetingDao meetingDao) {
		this.meetingDao = meetingDao;
	}

	@Override
	public String saveMeetRecord(xsjsglxt_meeting meet) {
		// TODO Auto-generated method stub
		meet.setMeeting_id(TeamUtil.getUuid());
		meet.setMeeting_gmt_create(TeamUtil.getStringSecond());
		meet.setMeeting_gmt_modified(TeamUtil.getStringSecond());
		String result = meetingDao.saveMeetingRecords(meet);
		return result;
	}
}
