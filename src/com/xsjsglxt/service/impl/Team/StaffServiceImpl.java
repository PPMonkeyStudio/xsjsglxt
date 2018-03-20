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

}
