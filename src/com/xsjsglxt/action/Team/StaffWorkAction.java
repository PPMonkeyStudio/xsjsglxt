package com.xsjsglxt.action.Team;

import com.opensymphony.xwork2.ActionSupport;
import com.xsjsglxt.service.Team.StaffWorkService;

/*
 * @author 孙毅
 * @description 工作经历表
 */
public class StaffWorkAction extends ActionSupport {
	private StaffWorkService staffWorkService;

	public StaffWorkService getStaffWorkService() {
		return staffWorkService;
	}

	public void setStaffWorkService(StaffWorkService staffWorkService) {
		this.staffWorkService = staffWorkService;
	}
}
