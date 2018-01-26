package com.xsjsglxt.action.User;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import com.xsjsglxt.domain.DO.xsjsglxt_meeting;
import com.xsjsglxt.domain.VO.User.meetingByPageAndSerarchVO;
import com.xsjsglxt.service.User.MeetingService;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import util.TeamUtil;

public class MeetingAction extends ActionSupport {
	private MeetingService meetingService;
	private xsjsglxt_meeting meet;
	private HttpServletResponse response;
	private meetingByPageAndSerarchVO meetVO;
	private String meeting_id;

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
			writer.flush();
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void showMeetingByPageAndList() throws IOException {
		System.out.println(meetVO.getStartTimeSort());
		response = ServletActionContext.getResponse();
		meetingByPageAndSerarchVO meetVOReturn = meetingService.getMeetingByPageAndList(meetVO);
		Gson gson = new Gson();
		String result = gson.toJson(meetVOReturn);
		System.out.println(result);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter write = response.getWriter();
		write.write(result);
		write.flush();
		write.close();
	}

	public void deleteMeetingRecord() throws IOException {
		System.out.println(meeting_id);
		String result = meetingService.deleteMeetingRecord(meeting_id);
		response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter write = response.getWriter();
		write.write(result);
		write.flush();
		write.close();
	}

	public void getMeetingById() throws IOException {
		xsjsglxt_meeting meet = meetingService.getMeetingById(meeting_id);
		Gson gson = new Gson();
		String result = gson.toJson(meet);
		response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter write = response.getWriter();
		write.write(result);
		write.flush();
		write.close();
	}

	public void updateMeetingRecord() throws IOException {
		xsjsglxt_meeting meetOld = meetingService.getMeetingById(meet.getMeeting_id());
		meet.setMeeting_gmt_create(meetOld.getMeeting_gmt_create());
		meet.setMeeting_gmt_modified(TeamUtil.getStringSecond());
		String result = meetingService.updateMeetingRecord(meet);
		response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter write = response.getWriter();
		write.write(result);
		write.flush();
		write.close();
	}

	public void exportMeetingRecord() throws IOException, TemplateException {
		response = ServletActionContext.getResponse();
		xsjsglxt_meeting meeting = meetingService.getMeetingById(meeting_id);
		Map<String, String> mapData = new HashMap<String, String>();
		mapData.put("meeting_place", meeting.getMeeting_place());
		mapData.put("meeting_title", meeting.getMeeting_title());
		mapData.put("meeting_compere", meeting.getMeeting_compere());
		mapData.put("meeting_record_human", meeting.getMeeting_record_human());
		mapData.put("meeting_start_time", meeting.getMeeting_start_time());
		mapData.put("meeting_end_time", meeting.getMeeting_end_time());
		mapData.put("meeting_join_human", meeting.getMeeting_join_human());
		mapData.put("meeting_leave_human", meeting.getMeeting_leave_human());
		mapData.put("meeting_content", meeting.getMeeting_content());
		Configuration configuration = new Configuration();
		configuration.setDefaultEncoding("utf-8");
		// 设置默认的编码方式，将数据以utf-8的方式进行编码
		configuration.setClassForTemplateLoading(this.getClass(), "");
		String filename = meeting.getMeeting_start_time();
		response.setCharacterEncoding("utf-8");
		// 设置响应的编码方式(以utf-8的方式将字符编码成字节)
		response.setContentType("application/msword");
		response.addHeader("Content-Disposition", "attachment;filename=\"" + filename + ".doc\"");
		PrintWriter pw = response.getWriter();
		Template t = configuration.getTemplate("meetingRecord.ftl", "utf-8");
		t.process(mapData, pw);
		pw.flush();
		pw.close();
	}

	// -----------------------------------------------------------setter/getter方法----------------------------------------------//

	public MeetingService getMeetingService() {
		return meetingService;
	}

	public String getMeeting_id() {
		return meeting_id;
	}

	public void setMeeting_id(String meeting_id) {
		this.meeting_id = meeting_id;
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
