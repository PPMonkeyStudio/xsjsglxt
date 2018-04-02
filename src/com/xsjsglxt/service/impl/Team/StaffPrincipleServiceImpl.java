package com.xsjsglxt.service.impl.Team;

import java.util.List;

import com.xsjsglxt.dao.Team.StaffPrincipleDao;
import com.xsjsglxt.domain.DO.xsjsglxt_staffPrinciple;
import com.xsjsglxt.service.Team.StaffPrincipleService;

import util.TeamUtil;

public class StaffPrincipleServiceImpl implements StaffPrincipleService {
	private StaffPrincipleDao staffPrincipleDao;

	public StaffPrincipleDao getStaffPrincipleDao() {
		return staffPrincipleDao;
	}

	public void setStaffPrincipleDao(StaffPrincipleDao staffPrincipleDao) {
		this.staffPrincipleDao = staffPrincipleDao;
	}

	@Override
	public String savePrinciples(List<xsjsglxt_staffPrinciple> principles) {
		// TODO Auto-generated method stub
		for (xsjsglxt_staffPrinciple xsjsglxt_staffPrinciple : principles) {
			xsjsglxt_staffPrinciple.setStaffPrinciple_gmt_create(TeamUtil.getStringSecond());
			xsjsglxt_staffPrinciple.setStaffPrinciple_gmt_modified(TeamUtil.getStringSecond());
			xsjsglxt_staffPrinciple.setXsjsglxt_staffPrinciple_id(TeamUtil.getUuid());
		}
		String result = staffPrincipleDao.savePrinciples(principles);
		return result;
	}

	@Override
	public String deletePrinciple(xsjsglxt_staffPrinciple principle) {
		// TODO Auto-generated method stub
		String result = staffPrincipleDao.deletePrinciple(principle);
		return result;
	}

	@Override
	public String deletePrinciples(String staffPrinciple_staff) {
		// TODO Auto-generated method stub
		String result = staffPrincipleDao.deletePrinciples(staffPrinciple_staff);
		return result;
	}

	@Override
	public String updatePrinciple(xsjsglxt_staffPrinciple principle) {
		// TODO Auto-generated method stub
		xsjsglxt_staffPrinciple oldPrinciple = staffPrincipleDao
				.getPrincipleByPrincipleId(principle.getXsjsglxt_staffPrinciple_id());
		oldPrinciple.setStaffPrinciple_gmt_modified(TeamUtil.getStringSecond());
		oldPrinciple.setStaffPrinciple_remarks(principle.getStaffPrinciple_remarks());
		oldPrinciple.setStaffPrinciple_situation(principle.getStaffPrinciple_situation());
		oldPrinciple.setStaffPrinciple_Time(principle.getStaffPrinciple_Time());
		return "updateSuccess";
	}

	@Override
	public xsjsglxt_staffPrinciple getPrinciple(String xsjsglxt_staffPrinciple_id) {
		// TODO Auto-generated method stub
		xsjsglxt_staffPrinciple oldPrinciple = staffPrincipleDao.getPrincipleByPrincipleId(xsjsglxt_staffPrinciple_id);
		return oldPrinciple;
	}

	@Override
	public List<xsjsglxt_staffPrinciple> getPrinciples(String staffPrinciple_staff) {
		// TODO Auto-generated method stub
		return staffPrincipleDao.getPrinciples(staffPrinciple_staff);
	}

}
