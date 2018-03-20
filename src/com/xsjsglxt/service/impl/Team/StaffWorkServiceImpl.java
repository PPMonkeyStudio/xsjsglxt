package com.xsjsglxt.service.impl.Team;

import com.xsjsglxt.dao.Team.StaffWorkDao;
import com.xsjsglxt.service.Team.StaffWorkService;

public class StaffWorkServiceImpl implements StaffWorkService {
	private StaffWorkDao staffWorkDao;

	public StaffWorkDao getStaffWorkDao() {
		return staffWorkDao;
	}

	public void setStaffWorkDao(StaffWorkDao staffWorkDao) {
		this.staffWorkDao = staffWorkDao;
	}
}
