package com.xsjsglxt.action.Team;

import com.opensymphony.xwork2.ActionSupport;
import com.xsjsglxt.service.Team.StaffPunishmentService;

/*
 * @author 孙毅
 * @description 处分管理
 */
public class StaffPunishmentAction extends ActionSupport {
	private StaffPunishmentService staffPunishmentService;

	public StaffPunishmentService getStaffPunishmentService() {
		return staffPunishmentService;
	}

	public void setStaffPunishmentService(StaffPunishmentService staffPunishmentService) {
		this.staffPunishmentService = staffPunishmentService;
	}
}
