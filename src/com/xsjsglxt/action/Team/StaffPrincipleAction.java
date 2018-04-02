package com.xsjsglxt.action.Team;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import com.xsjsglxt.domain.DO.xsjsglxt_staffPrinciple;
import com.xsjsglxt.service.Team.StaffPrincipleService;

/*
 * @author 孙毅
 * @description 违纪管理
 */
public class StaffPrincipleAction extends ActionSupport {
	private StaffPrincipleService staffPrincipleService;
	private xsjsglxt_staffPrinciple principle;
	private List<xsjsglxt_staffPrinciple> principles;

	// -----------------------------保存违纪信息-----------------------------------
	public void savePrinciples() {
		String result = staffPrincipleService.savePrinciples(principles);
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

	// -----------------------------删除单个违纪信息--------------------------------
	public void deletePrinciple() {
		String result = staffPrincipleService.deletePrinciple(principle);
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

	// ------------------------------删除多个违纪信息--------------------------------
	public void deletePrinciples() {
		String result = staffPrincipleService.deletePrinciples(principle.getStaffPrinciple_staff());
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

	// ------------------------------修改违纪信息------------------------------------
	public void updatePrinciple() {
		String result = staffPrincipleService.updatePrinciple(principle);
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

	// -------------------------------获取单个违纪信息---------------------------------
	public void getPrincipleByPrincipleId() {
		xsjsglxt_staffPrinciple oldPrinciple = staffPrincipleService
				.getPrinciple(principle.getXsjsglxt_staffPrinciple_id());
		Gson gson = new Gson();
		String result = gson.toJson(oldPrinciple);
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

	// --------------------------------获取多个违纪信息--------------------------------
	public void getPrincipleByStaffId() {
		List<xsjsglxt_staffPrinciple> principles = staffPrincipleService
				.getPrinciples(principle.getStaffPrinciple_staff());
		String result;
		if (principles.size() <= 0) {
			result = "principleIsNull";
		} else {
			Gson gson = new Gson();
			result = gson.toJson(principles);
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

	// ------------------------setter/getter-------------------------------
	public StaffPrincipleService getStaffPrincipleService() {
		return staffPrincipleService;
	}

	public void setStaffPrincipleService(StaffPrincipleService staffPrincipleService) {
		this.staffPrincipleService = staffPrincipleService;
	}

	public xsjsglxt_staffPrinciple getPrinciple() {
		return principle;
	}

	public void setPrinciple(xsjsglxt_staffPrinciple principle) {
		this.principle = principle;
	}

	public List<xsjsglxt_staffPrinciple> getPrinciples() {
		return principles;
	}

	public void setPrinciples(List<xsjsglxt_staffPrinciple> principles) {
		this.principles = principles;
	}

}
