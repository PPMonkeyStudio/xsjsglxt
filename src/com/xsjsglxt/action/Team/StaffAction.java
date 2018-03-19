package com.xsjsglxt.action.Team;

import com.opensymphony.xwork2.ActionSupport;
import com.xsjsglxt.domain.DO.xsjsglxt_staff;
import com.xsjsglxt.service.Team.StaffService;

/*
 * @author 孙毅
 * @description 警员管理Action
 */
public class StaffAction extends ActionSupport {

	private StaffService staffService;
	private xsjsglxt_staff policeman;

	// -----------------------------------进入人员管理---------------------------------------
	public String page_staffList() {
		return "StaffIndex";
	}

	// ------------------------------------setter/getter-----------------------------------
	public StaffService getStaffService() {
		return staffService;
	}

	public xsjsglxt_staff getPoliceman() {
		return policeman;
	}

	public void setPoliceman(xsjsglxt_staff policeman) {
		this.policeman = policeman;
	}

	public void setStaffService(StaffService staffService) {
		this.staffService = staffService;
	}
}
