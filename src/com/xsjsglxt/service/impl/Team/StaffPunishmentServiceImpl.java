package com.xsjsglxt.service.impl.Team;

import com.xsjsglxt.dao.Team.StaffPunishmentDao;
import com.xsjsglxt.service.Team.StaffPunishmentService;

public class StaffPunishmentServiceImpl implements StaffPunishmentService {
	private StaffPunishmentDao staffPunishmentDao;

	public StaffPunishmentDao getStaffPunishmentDao() {
		return staffPunishmentDao;
	}

	public void setStaffPunishmentDao(StaffPunishmentDao staffPunishmentDao) {
		this.staffPunishmentDao = staffPunishmentDao;
	}
}
