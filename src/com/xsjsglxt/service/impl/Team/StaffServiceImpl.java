package com.xsjsglxt.service.impl.Team;

import com.xsjsglxt.dao.Team.StaffDao;
import com.xsjsglxt.service.Team.StaffService;

public class StaffServiceImpl implements StaffService {
	private StaffDao staffDao;

	public StaffDao getStaffDao() {
		return staffDao;
	}

	public void setStaffDao(StaffDao staffDao) {
		this.staffDao = staffDao;
	}

}
