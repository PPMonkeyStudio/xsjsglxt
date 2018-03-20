package com.xsjsglxt.service.impl.Team;

import com.xsjsglxt.dao.Team.StaffFurloughDao;
import com.xsjsglxt.service.Team.StaffFurloughService;

public class StaffFurloughServiceImpl implements StaffFurloughService {
	private StaffFurloughDao staffFurloughDao;

	public StaffFurloughDao getStaffFurloughDao() {
		return staffFurloughDao;
	}

	public void setStaffFurloughDao(StaffFurloughDao staffFurloughDao) {
		this.staffFurloughDao = staffFurloughDao;
	}
}
