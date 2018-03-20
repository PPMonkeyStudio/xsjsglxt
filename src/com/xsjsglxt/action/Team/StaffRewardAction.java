package com.xsjsglxt.action.Team;

import com.opensymphony.xwork2.ActionSupport;
import com.xsjsglxt.service.Team.StaffRewardService;

/*
 * @author 孙毅
 * @description 奖励管理
 */
public class StaffRewardAction extends ActionSupport {
	private StaffRewardService staffRewardService;

	public StaffRewardService getStaffRewardService() {
		return staffRewardService;
	}

	public void setStaffRewardService(StaffRewardService staffRewardService) {
		this.staffRewardService = staffRewardService;
	}
}
