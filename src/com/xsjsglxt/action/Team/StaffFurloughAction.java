package com.xsjsglxt.action.Team;

import com.opensymphony.xwork2.ActionSupport;
import com.xsjsglxt.service.Team.StaffFurloughService;

/*
 * @author 孙毅
 * @description 休假管理
 */
public class StaffFurloughAction extends ActionSupport {
	private StaffFurloughService staffFurloughService;

	public StaffFurloughService getStaffFurloughService() {
		return staffFurloughService;
	}

	public void setStaffFurloughService(StaffFurloughService staffFurloughService) {
		this.staffFurloughService = staffFurloughService;
	}
}
