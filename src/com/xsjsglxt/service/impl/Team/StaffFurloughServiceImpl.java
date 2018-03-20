package com.xsjsglxt.service.impl.Team;

import com.xsjsglxt.dao.Team.StaffFurloughDao;
import com.xsjsglxt.domain.DO.xsjsglxt_staffFurlough;
import com.xsjsglxt.service.Team.StaffFurloughService;

import util.TeamUtil;

public class StaffFurloughServiceImpl implements StaffFurloughService {
	private StaffFurloughDao staffFurloughDao;

	public StaffFurloughDao getStaffFurloughDao() {
		return staffFurloughDao;
	}

	public void setStaffFurloughDao(StaffFurloughDao staffFurloughDao) {
		this.staffFurloughDao = staffFurloughDao;
	}

	@Override
	public String saveFurlough(xsjsglxt_staffFurlough furlough) {
		// TODO Auto-generated method stub
		furlough.setXsjsglxt_staffFurlough_id(TeamUtil.getUuid());
		furlough.setStaffFurlough_gmt_create(TeamUtil.getStringSecond());
		furlough.setStaffFurlough_gmt_modified(TeamUtil.getStringSecond());
		String result = staffFurloughDao.saveFurlough(furlough);
		return result;
	}

	@Override
	public String deleteFurloughByFurloughId(xsjsglxt_staffFurlough furlough) {
		// TODO Auto-generated method stub
		String result = staffFurloughDao.deleteFurloughByFurloughId(furlough);
		return result;
	}

	@Override
	public String deleteFurloughByStaffId(String staffFurlough_staff) {
		// TODO Auto-generated method stub
		String result = staffFurloughDao.deleteFurloughByStaffId(staffFurlough_staff);
		return result;
	}

	@Override
	public xsjsglxt_staffFurlough getFurloughByFurloughId(String xsjsglxt_staffFurlough_id) {
		// TODO Auto-generated method stub
		xsjsglxt_staffFurlough furlough = staffFurloughDao.getFurloughByFurloughId(xsjsglxt_staffFurlough_id);
		return furlough;
	}
}
