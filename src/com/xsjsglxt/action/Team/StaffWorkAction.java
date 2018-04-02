package com.xsjsglxt.action.Team;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import com.xsjsglxt.domain.DO.xsjsglxt_staffWork;
import com.xsjsglxt.service.Team.StaffWorkService;

/*
 * @author 孙毅
 * @description 工作经历表
 */
public class StaffWorkAction extends ActionSupport {
	private StaffWorkService staffWorkService;
	private xsjsglxt_staffWork work;
	private List<xsjsglxt_staffWork> works;

	// -----------------------------保存工作信息----------------------------------------
	public void saveWorks() {
		String result = staffWorkService.saveWorks(works);
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

	// ---------------------------------删除单个工作信息--------------------------
	public void deleteWork() {
		String result = staffWorkService.deleteWork(work.getXsjsglxt_staffWork_id());
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

	// ---------------------------------删除多个工作信息--------------------------
	public void deleteWorks() {
		String result = staffWorkService.deleteWorks(work.getStaffWork_staff());
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

	// ---------------------------------修改工作信息----------------------------------
	public void updateRewardWork() {
		String result = staffWorkService.upadteWork(work);
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

	// ------------------------------获得单个工作信息---------------------------------
	public void getWorkByWorkId() {
		xsjsglxt_staffWork oldWork = staffWorkService.getWork(work.getXsjsglxt_staffWork_id());
		Gson gson = new Gson();
		String result = gson.toJson(oldWork);
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

	// ------------------------------获得多个工作信息---------------------------------
	public void getWorkByStaffId() {
		List<xsjsglxt_staffWork> Works = staffWorkService.getWorks(work.getStaffWork_staff());
		String result;
		if (Works.size() <= 0) {
			result = "worksIsNull";
		} else {
			Gson gson = new Gson();
			result = gson.toJson(Works);
		}
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

	// -------------------------setter/getter--------------------------
	public StaffWorkService getStaffWorkService() {
		return staffWorkService;
	}

	public void setStaffWorkService(StaffWorkService staffWorkService) {
		this.staffWorkService = staffWorkService;
	}

	public xsjsglxt_staffWork getWork() {
		return work;
	}

	public void setWork(xsjsglxt_staffWork work) {
		this.work = work;
	}

	public List<xsjsglxt_staffWork> getWorks() {
		return works;
	}

	public void setWorks(List<xsjsglxt_staffWork> works) {
		this.works = works;
	}
}
