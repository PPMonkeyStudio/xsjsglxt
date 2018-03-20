package com.xsjsglxt.action.Team;

import com.opensymphony.xwork2.ActionSupport;
import com.xsjsglxt.service.Team.StaffStudentService;

/*
 * @author 孙毅
 * @description 学习经历管理
 */
public class StaffStudentAction extends ActionSupport {
	private StaffStudentService staffStudentService;

	public StaffStudentService getStaffStudentService() {
		return staffStudentService;
	}

	public void setStaffStudentService(StaffStudentService staffStudentService) {
		this.staffStudentService = staffStudentService;
	}
}
