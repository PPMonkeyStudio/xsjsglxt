package com.xsjsglxt.action.User;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.xsjsglxt.domain.DO.xsjsglxt_meeting;
import com.xsjsglxt.service.User.MeetingService;

public class MeetingAction extends ActionSupport {
	private MeetingService meetingService;
	private xsjsglxt_meeting meet;
	private HttpServletResponse response;

	public HttpServletResponse getResponse() {
		response = ServletActionContext.getResponse();
		return response;
	}

	public String skipToMeetRecords() {
		return "intoMeeting";
	}

	public void saveMeetRecord() {
		String result = meetingService.saveMeetRecord(meet);
		getResponse().setContentType("text/html;charset=utf-8");
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.write(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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
