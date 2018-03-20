package com.xsjsglxt.action.Team;

import com.opensymphony.xwork2.ActionSupport;
import com.xsjsglxt.domain.DO.xsjsglxt_staffFurlough;
import com.xsjsglxt.service.Team.StaffFurloughService;

/*
 * @author 孙毅
 * @description 休假管理
 * @function 增删改查
 */
public class StaffFurloughAction extends ActionSupport {
	private StaffFurloughService staffFurloughService;
	private xsjsglxt_staffFurlough furlough;

	// --------------setter/getter------------------------------------
	public StaffFurloughService getStaffFurloughService() {
		return staffFurloughService;
	}

	public xsjsglxt_staffFurlough getFurlough() {
		return furlough;
	}

	public void setFurlough(xsjsglxt_staffFurlough furlough) {
		this.furlough = furlough;
	}

	public void setStaffFurloughService(StaffFurloughService staffFurloughService) {
		this.staffFurloughService = staffFurloughService;
	}
}
