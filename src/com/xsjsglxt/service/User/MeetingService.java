package com.xsjsglxt.service.User;

import com.xsjsglxt.domain.DO.xsjsglxt_meeting;
import com.xsjsglxt.domain.VO.User.meetingByPageAndSerarchVO;

public interface MeetingService {

	String saveMeetRecord(xsjsglxt_meeting meet);

	meetingByPageAndSerarchVO getMeetingByPageAndList(meetingByPageAndSerarchVO meetVO);

	String deleteMeetingRecord(String meeting_id);

	xsjsglxt_meeting getMeetingById(String meeting_id);

	String updateMeetingRecord(xsjsglxt_meeting meet);

}
