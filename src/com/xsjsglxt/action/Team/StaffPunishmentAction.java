package com.xsjsglxt.action.Team;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import com.xsjsglxt.domain.DO.xsjsglxt_staffPunishment;
import com.xsjsglxt.service.Team.StaffPunishmentService;

/*
 * @author 孙毅
 * @description 处分管理
 */
public class StaffPunishmentAction extends ActionSupport {
	private StaffPunishmentService staffPunishmentService;
	private xsjsglxt_staffPunishment punishment;
	private List<xsjsglxt_staffPunishment> punishments;

	// ----------------------保存处分信息-------------------------
	public void savePunishments() {
		String result = staffPunishmentService.savePunishment(punishments);
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

	// -----------------------删除单个处分信息-------------------------
	public void deletePunishment() {
		String result = staffPunishmentService.deletePunishment(punishment.getXsjsglxt_staffPunishment_id());
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

	// --------------------------删除多个处分信息——-------------------------
	public void deletePunishments() {
		String result = staffPunishmentService.deletePunishments(punishment.getStaffPunishment_staff());
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

	// ---------------------------修改处分信息------------------------------
	public void updatePunishment() {
		String result = staffPunishmentService.updatePunishment(punishment);
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

	// ---------------------------获取单个处分信息----------------------------
	public void getPunishmentByPunishmentId() {
		xsjsglxt_staffPunishment oldPunishment = staffPunishmentService
				.getPunishment(punishment.getXsjsglxt_staffPunishment_id());
		Gson gson = new Gson();
		String result = gson.toJson(oldPunishment);
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

	// ----------------------------获取多条处分信息---------------------------
	public void getPunishmentByStaffId() {
		List<xsjsglxt_staffPunishment> punishments = staffPunishmentService
				.getPunishments(punishment.getStaffPunishment_staff());
		String result;
		if (punishments.size() <= 0) {
			result = "punishmentIsNull";
		} else {
			Gson gson = new Gson();
			result = gson.toJson(punishments);
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

	// --------------------setter/getter-------------------------------

	public StaffPunishmentService getStaffPunishmentService() {
		return staffPunishmentService;
	}

	public xsjsglxt_staffPunishment getPunishment() {
		return punishment;
	}

	public void setPunishment(xsjsglxt_staffPunishment punishment) {
		this.punishment = punishment;
	}

	public List<xsjsglxt_staffPunishment> getPunishments() {
		return punishments;
	}

	public void setPunishments(List<xsjsglxt_staffPunishment> punishments) {
		this.punishments = punishments;
	}

	public void setStaffPunishmentService(StaffPunishmentService staffPunishmentService) {
		this.staffPunishmentService = staffPunishmentService;
	}
}
