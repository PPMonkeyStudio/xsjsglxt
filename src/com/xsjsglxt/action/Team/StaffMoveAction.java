package com.xsjsglxt.action.Team;

import com.opensymphony.xwork2.ActionSupport;
import com.xsjsglxt.service.Team.StaffMoveService;

/*
 * @author 孙毅
 * @description 调动情况管理
 */
public class StaffMoveAction extends ActionSupport {
	private StaffMoveService staffMoveService;

	public StaffMoveService getStaffMoveService() {
		return staffMoveService;
	}

	public void setStaffMoveService(StaffMoveService staffMoveService) {
		this.staffMoveService = staffMoveService;
	}
}
