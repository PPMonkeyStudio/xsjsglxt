package com.xsjsglxt.service.impl.Team;

import com.xsjsglxt.dao.Team.StaffStudentDao;
import com.xsjsglxt.service.Team.StaffStudentService;

public class StaffStudentServiceImpl implements StaffStudentService {
	private StaffStudentDao staffStudentDao;

	public StaffStudentDao getStaffStudentDao() {
		return staffStudentDao;
	}

	public void setStaffStudentDao(StaffStudentDao staffStudentDao) {
		this.staffStudentDao = staffStudentDao;
	}
}
