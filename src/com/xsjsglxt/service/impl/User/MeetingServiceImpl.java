package com.xsjsglxt.service.impl.User;

import com.xsjsglxt.dao.User.MeetingDao;
import com.xsjsglxt.domain.DO.xsjsglxt_meeting;
import com.xsjsglxt.domain.VO.User.meetingByPageAndSerarchVO;
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

	@Override
	public meetingByPageAndSerarchVO getMeetingByPageAndList(meetingByPageAndSerarchVO meetVO) {
		// TODO Auto-generated method stub

		int count = meetingDao.getCountMeetRecordsBySearch(meetVO);
		double countD = count;
		meetVO.setPageCount((int) Math.ceil(countD / meetVO.getPageSize()));
		meetVO.setTotalCount(count);
		meetVO.setMeetDTO(meetingDao.ListMeetRecordsBySearch(meetVO));
		return meetVO;
	}

	@Override
	public String deleteMeetingRecord(String meeting_id) {
		// TODO Auto-generated method stub
		String result = meetingDao.deleteMeetingRecords(meeting_id);
		return result;
	}

	@Override
	public xsjsglxt_meeting getMeetingById(String meeting_id) {
		// TODO Auto-generated method stub
		return meetingDao.getMeetingRecordsById(meeting_id);
	}

	@Override
	public String updateMeetingRecord(xsjsglxt_meeting meet) {
		// TODO Auto-generated method stub
		return meetingDao.updateMeetingRecords(meet);
	}
}
