package com.xsjsglxt.action.Team;

import com.opensymphony.xwork2.ActionSupport;
import com.xsjsglxt.service.Team.StaffPrincipleService;

/*
 * @author 孙毅
 * @description 违纪管理
 */
public class StaffPrincipleAction extends ActionSupport {
	private StaffPrincipleService staffPrincipleService;

	public StaffPrincipleService getStaffPrincipleService() {
		return staffPrincipleService;
	}

	public void setStaffPrincipleService(StaffPrincipleService staffPrincipleService) {
		this.staffPrincipleService = staffPrincipleService;
	}
}
