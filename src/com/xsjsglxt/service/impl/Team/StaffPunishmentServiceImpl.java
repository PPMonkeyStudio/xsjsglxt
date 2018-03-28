package com.xsjsglxt.service.impl.Team;

import java.util.List;

import com.xsjsglxt.dao.Team.StaffPunishmentDao;
import com.xsjsglxt.domain.DO.xsjsglxt_staffPunishment;
import com.xsjsglxt.service.Team.StaffPunishmentService;

import util.TeamUtil;

public class StaffPunishmentServiceImpl implements StaffPunishmentService {
	private StaffPunishmentDao staffPunishmentDao;

	public StaffPunishmentDao getStaffPunishmentDao() {
		return staffPunishmentDao;
	}

	public void setStaffPunishmentDao(StaffPunishmentDao staffPunishmentDao) {
		this.staffPunishmentDao = staffPunishmentDao;
	}

	@Override
	public String savePunishment(List<xsjsglxt_staffPunishment> punishments) {
		// TODO Auto-generated method stub
		for (xsjsglxt_staffPunishment xsjsglxt_staffPunishment : punishments) {
			xsjsglxt_staffPunishment.setXsjsglxt_staffPunishment_id(TeamUtil.getStringSecond());
			xsjsglxt_staffPunishment.setStaffPunishment_gmt_create(TeamUtil.getStringSecond());
			xsjsglxt_staffPunishment.setStaffPunishment_gmt_modified(TeamUtil.getStringSecond());
		}
		String result = staffPunishmentDao.savePunishment(punishments);
		return result;
	}

	@Override
	public String deletePunishment(String xsjsglxt_staffPunishment_id) {
		// TODO Auto-generated method stub

		return staffPunishmentDao.deletePunishment(xsjsglxt_staffPunishment_id);
	}

	@Override
	public String deletePunishments(String staffPunishment_staff) {
		// TODO Auto-generated method stub
		return staffPunishmentDao.deletePunishments(staffPunishment_staff);
	}

	@Override
	public String updatePunishment(xsjsglxt_staffPunishment punishment) {
		// TODO Auto-generated method stub
		xsjsglxt_staffPunishment oldPunishment = staffPunishmentDao
				.getPunishment(punishment.getXsjsglxt_staffPunishment_id());
		oldPunishment.setStaffPunishment_gmt_modified(TeamUtil.getStringSecond());
		oldPunishment.setStaffPunishment_remarks(punishment.getStaffPunishment_remarks());
		oldPunishment.setStaffPunishment_situation(punishment.getStaffPunishment_situation());
		oldPunishment.setStaffPunishment_Time(punishment.getStaffPunishment_Time());
		return "updateSuccess";
	}

	@Override
	public xsjsglxt_staffPunishment getPunishment(String xsjsglxt_staffPunishment_id) {
		// TODO Auto-generated method stub
		return staffPunishmentDao.getPunishment(xsjsglxt_staffPunishment_id);
	}

	@Override
	public List<xsjsglxt_staffPunishment> getPunishments(String staffPunishment_staff) {
		// TODO Auto-generated method stub
		List<xsjsglxt_staffPunishment> punishments = staffPunishmentDao.getPunishments(staffPunishment_staff);
		return punishments;
	}
}
