package com.xsjsglxt.service.impl.Team;

import com.xsjsglxt.dao.Team.StaffRewardDao;
import com.xsjsglxt.service.Team.StaffRewardService;

public class StaffRewardServiceImpl implements StaffRewardService {
	private StaffRewardDao staffRewardDao;

	public StaffRewardDao getStaffRewardDao() {
		return staffRewardDao;
	}

	public void setStaffRewardDao(StaffRewardDao staffRewardDao) {
		this.staffRewardDao = staffRewardDao;
	}
}
