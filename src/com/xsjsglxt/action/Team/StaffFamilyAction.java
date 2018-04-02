package com.xsjsglxt.action.Team;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import com.xsjsglxt.domain.DO.xsjsglxt_staffFamily;
import com.xsjsglxt.service.Team.StaffFamilyService;

/*
 * @author 孙毅
 * @description 家庭成员信息
 */
public class StaffFamilyAction extends ActionSupport {
	private StaffFamilyService staffFamilyService;
	private xsjsglxt_staffFamily family;
	private List<xsjsglxt_staffFamily> familys;
	// 添加家庭成员

	public void saveFamilys() {
		String result = staffFamilyService.saveFamily(familys);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw;
		try {
			pw = response.getWriter();
			pw.write(result);
			pw.flush();
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// 删除家庭成员通过家庭成员主键

	public void deleteFamilyByFamilyId() {
		String result = staffFamilyService.deleteFamilyByFamilyId(family);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw;
		try {
			pw = response.getWriter();
			pw.write(result);
			pw.flush();
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 删除家庭成员通过警员主键 批量删除
	public void deleteFamilyByStaffId() {
		String result = staffFamilyService.deleteFamilyByStaffId(family);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw;
		try {
			pw = response.getWriter();
			pw.write(result);
			pw.flush();
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 修改家庭成员信息
	public void updateFamily() {
		String result = staffFamilyService.updateFamily(family);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;cherset=utf-8");
		PrintWriter pw;
		try {
			pw = response.getWriter();
			pw.write(result);
			pw.flush();
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// 获得家庭成员信息通过家庭成员信息id
	public void getFamilyByFamilyId() {
		xsjsglxt_staffFamily newFamily = staffFamilyService.getFamilyByFamilyId(family.getXsjsglxt_staffFamily_id());
		// GsonBuilder gsonBuilder = new GsonBuilder();
		// gsonBuilder.setPrettyPrinting();
		// Gson gson = gsonBuilder.create();
		Gson gson = new Gson();
		String result = gson.toJson(newFamily);
		System.out.println(result);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw;
		try {
			pw = response.getWriter();
			pw.write(result);
			pw.flush();
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 获得所有家庭成员信息
	public void getFamilyByStaffId() {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		List<xsjsglxt_staffFamily> familyList = staffFamilyService.getFamilyByStaffId(family.getStaffFamily_staff());
		if (familyList.size() < 1) {
			PrintWriter pw;
			try {
				pw = response.getWriter();
				pw.write("familyIsNull");
				pw.flush();
				pw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			Gson gson = new Gson();
			String result = gson.toJson(familyList);
			PrintWriter pw;
			try {
				pw = response.getWriter();
				pw.write(result);
				pw.flush();
				pw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	// ----------------------setter/getter---------------------------

	public StaffFamilyService getStaffFamilyService() {
		return staffFamilyService;
	}

	public List<xsjsglxt_staffFamily> getFamilys() {
		return familys;
	}

	public void setFamilys(List<xsjsglxt_staffFamily> familys) {
		this.familys = familys;
	}

	public xsjsglxt_staffFamily getFamily() {
		return family;
	}

	public void setFamily(xsjsglxt_staffFamily family) {
		this.family = family;
	}

	public void setStaffFamilyService(StaffFamilyService staffFamilyService) {
		this.staffFamilyService = staffFamilyService;
	}
}
