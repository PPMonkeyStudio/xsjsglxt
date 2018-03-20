package com.xsjsglxt.service.impl.Team;

import com.xsjsglxt.dao.Team.StaffPrincipleDao;
import com.xsjsglxt.service.Team.StaffPrincipleService;

public class StaffPrincipleServiceImpl implements StaffPrincipleService {
	private StaffPrincipleDao staffPrincipleDao;

	public StaffPrincipleDao getStaffPrincipleDao() {
		return staffPrincipleDao;
	}

	public void setStaffPrincipleDao(StaffPrincipleDao staffPrincipleDao) {
		this.staffPrincipleDao = staffPrincipleDao;
	}
}
