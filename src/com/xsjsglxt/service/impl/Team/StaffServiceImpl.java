package com.xsjsglxt.service.impl.Team;

import com.xsjsglxt.dao.Team.StaffDao;
import com.xsjsglxt.domain.DO.xsjsglxt_staff;
import com.xsjsglxt.service.Team.StaffService;

import util.TeamUtil;

public class StaffServiceImpl implements StaffService {
	private StaffDao staffDao;

	public StaffDao getStaffDao() {
		return staffDao;
	}

	public void setStaffDao(StaffDao staffDao) {
		this.staffDao = staffDao;
	}

	@Override
	public String saveStaff(xsjsglxt_staff policeman) {
		// TODO Auto-generated method stub
		policeman.setXsjsglxt_staff_id(TeamUtil.getUuid());
		policeman.setStaff_gmt_create(TeamUtil.getStringSecond());
		policeman.setStaff_gmt_modified(TeamUtil.getStringSecond());
		String result = staffDao.savePoliceman(policeman);
		return result;
	}

	@Override
	public String deletePoliceman(xsjsglxt_staff policeman) {
		// TODO Auto-generated method stub
		String result = staffDao.deletePoliceman(policeman);
		return result;
	}

	@Override
	public String updatePoliceman(xsjsglxt_staff policeman) {
		// TODO Auto-generated method stub
		policeman.setStaff_gmt_modified(TeamUtil.getStringSecond());
		String result = staffDao.updatePoliceman(policeman);
		return result;
	}

	@Override
	public xsjsglxt_staff getPolicemanByStaffId(String xsjsglxt_staff_id) {
		// TODO Auto-generated method stub
		return staffDao.getPolicemanByStaffId(xsjsglxt_staff_id);
	}

}
