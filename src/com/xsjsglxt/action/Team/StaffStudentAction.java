package com.xsjsglxt.action.Team;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import com.xsjsglxt.domain.DO.xsjsglxt_staffStudent;
import com.xsjsglxt.service.Team.StaffStudentService;

/*
 * @author 孙毅
 * @description 学习经历管理
 */
public class StaffStudentAction extends ActionSupport {
	private StaffStudentService staffStudentService;
	private xsjsglxt_staffStudent student;
	private List<xsjsglxt_staffStudent> students;

	// -----------------------------保存学习信息----------------------------------------
	public void saveRewards() {
		String result = staffStudentService.saveStudents(students);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		try {
			PrintWriter pw = response.getWriter();
			pw.write(result);
			pw.flush();
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// ---------------------------------删除单个学习信息--------------------------
	public void deleteReward() {
		String result = staffStudentService.deleteStudent(student.getXsjsglxt_staffStudent_id());
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		try {
			PrintWriter pw = response.getWriter();
			pw.write(result);
			pw.flush();
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// ---------------------------------删除多个学习信息--------------------------
	public void deleteRewards() {
		String result = staffStudentService.deleteStudents(student.getStaffStudent_staff());
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		try {
			PrintWriter pw = response.getWriter();
			pw.write(result);
			pw.flush();
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// ---------------------------------修改学习信息----------------------------------
	public void updateReward() {
		String result = staffStudentService.upadteStudent(student);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		try {
			PrintWriter pw = response.getWriter();
			pw.write(result);
			pw.flush();
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// ------------------------------获得单个学习信息---------------------------------
	public void getRewardByRewardId() {
		xsjsglxt_staffStudent oldStudent = staffStudentService.getStudent(student.getXsjsglxt_staffStudent_id());
		Gson gson = new Gson();
		String result = gson.toJson(oldStudent);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		try {
			PrintWriter pw = response.getWriter();
			pw.write(result);
			pw.flush();
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// ------------------------------获得多个学习信息---------------------------------
	public void getRewardByStaffId() {
		List<xsjsglxt_staffStudent> students = staffStudentService.getStudents(student.getStaffStudent_staff());
		Gson gson = new Gson();
		String result = gson.toJson(students);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		try {
			PrintWriter pw = response.getWriter();
			pw.write(result);
			pw.flush();
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// -----------------setter/getter--------------------------------------
	public StaffStudentService getStaffStudentService() {
		return staffStudentService;
	}

	public void setStaffStudentService(StaffStudentService staffStudentService) {
		this.staffStudentService = staffStudentService;
	}

	public xsjsglxt_staffStudent getStudent() {
		return student;
	}

	public void setStudent(xsjsglxt_staffStudent student) {
		this.student = student;
	}

	public List<xsjsglxt_staffStudent> getStudents() {
		return students;
	}

	public void setStudents(List<xsjsglxt_staffStudent> students) {
		this.students = students;
	}
}
