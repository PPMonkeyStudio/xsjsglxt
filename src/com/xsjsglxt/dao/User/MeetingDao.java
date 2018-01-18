package com.xsjsglxt.dao.User;

import com.xsjsglxt.domain.DO.xsjsglxt_meeting;

public interface MeetingDao {
	public String saveMeetingRecords(xsjsglxt_meeting meet);

	public String updateMeetingRecords(xsjsglxt_meeting meet);

	public String deleteMeetingRecords(String[] meeting_id);

}
