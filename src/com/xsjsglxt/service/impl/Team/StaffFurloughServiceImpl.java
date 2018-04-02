package com.xsjsglxt.service.impl.Team;

import java.util.List;

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
	public String saveFurlough(List<xsjsglxt_staffFurlough> furlough) {
		// TODO Auto-generated method stub
		for (xsjsglxt_staffFurlough xsjsglxt_staffFurlough : furlough) {
			xsjsglxt_staffFurlough.setXsjsglxt_staffFurlough_id(TeamUtil.getUuid());
			xsjsglxt_staffFurlough.setStaffFurlough_gmt_create(TeamUtil.getStringSecond());
			xsjsglxt_staffFurlough.setStaffFurlough_gmt_modified(TeamUtil.getStringSecond());
		}
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

	@Override
	public List<xsjsglxt_staffFurlough> getFurloughByStaffId(String staffFurlough_staff) {
		// TODO Auto-generated method stub
		List<xsjsglxt_staffFurlough> furloughs = staffFurloughDao.getFurloughByStaffId(staffFurlough_staff);
		return furloughs;
	}

	@Override
	public String updateFurlough(xsjsglxt_staffFurlough furlough) {
		// TODO Auto-generated method stub
		xsjsglxt_staffFurlough oldFurlough = staffFurloughDao
				.getFurloughByFurloughId(furlough.getXsjsglxt_staffFurlough_id());
		furlough.setStaffFurlough_staff(oldFurlough.getStaffFurlough_staff());
		furlough.setStaffFurlough_gmt_create(oldFurlough.getStaffFurlough_gmt_create());
		furlough.setStaffFurlough_gmt_modified(TeamUtil.getStringSecond());
		String result = staffFurloughDao.updateFurlough(furlough);
		return "updateSuccess";
	}
}
