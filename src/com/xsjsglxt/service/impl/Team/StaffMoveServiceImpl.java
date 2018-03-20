package com.xsjsglxt.service.impl.Team;

import com.xsjsglxt.dao.Team.StaffMoveDao;
import com.xsjsglxt.service.Team.StaffMoveService;

public class StaffMoveServiceImpl implements StaffMoveService {
	private StaffMoveDao staffMoveDao;

	public StaffMoveDao getStaffMoveDao() {
		return staffMoveDao;
	}

	public void setStaffMoveDao(StaffMoveDao staffMoveDao) {
		this.staffMoveDao = staffMoveDao;
	}
}
