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
public boolean saveStaff(xsjsglxt_staff staff) {
	// TODO Auto-generated method stub
	staff.setXsjsglxt_staff_id(TeamUtil.getUuid());
	staff.setStaff_gmt_create(TeamUtil.getStringSecond());
	staff.setStaff_gmt_modified(staff.getStaff_gmt_create());
	if(staffDao.saveStaff(staff)){
		return true;
	}else{
		return false;
	}
}

}
