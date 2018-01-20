package com.xsjsglxt.action.User;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import com.xsjsglxt.domain.DO.xsjsglxt_meeting;
import com.xsjsglxt.domain.VO.User.meetingByPageAndSerarchVO;
import com.xsjsglxt.service.User.MeetingService;

public class MeetingAction extends ActionSupport {
	private MeetingService meetingService;
	private xsjsglxt_meeting meet;
	private HttpServletResponse response;
	private meetingByPageAndSerarchVO meetVO;

	public String skipToMeetRecords() {
		return "intoMeeting";
	}

	public void saveMeetRecord() {
		response = ServletActionContext.getResponse();
		String result = meetingService.saveMeetRecord(meet);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.write(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void showMeetingByPageAndList() throws IOException {
		response = ServletActionContext.getResponse();
		meetingByPageAndSerarchVO meetVOReturn = meetingService.getMeetingByPageAndList(meetVO);
		Gson gson = new Gson();
		String result = gson.toJson(meetVOReturn);
		System.out.println(result);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter write = response.getWriter();
		write.write(result);
	}

	// -----------------------------------------------------------setter/getter方法----------------------------------------------//

	public MeetingService getMeetingService() {
		return meetingService;
	}

	public meetingByPageAndSerarchVO getMeetVO() {
		return meetVO;
	}

	public void setMeetVO(meetingByPageAndSerarchVO meetVO) {
		this.meetVO = meetVO;
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
