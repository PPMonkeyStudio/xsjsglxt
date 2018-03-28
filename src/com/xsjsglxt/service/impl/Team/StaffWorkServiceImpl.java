package com.xsjsglxt.service.impl.Team;

import java.util.List;

import com.xsjsglxt.dao.Team.StaffWorkDao;
import com.xsjsglxt.domain.DO.xsjsglxt_staffWork;
import com.xsjsglxt.service.Team.StaffWorkService;

import util.TeamUtil;

public class StaffWorkServiceImpl implements StaffWorkService {
	private StaffWorkDao staffWorkDao;

	public StaffWorkDao getStaffWorkDao() {
		return staffWorkDao;
	}

	public void setStaffWorkDao(StaffWorkDao staffWorkDao) {
		this.staffWorkDao = staffWorkDao;
	}

	@Override
	public List<xsjsglxt_staffWork> getWorks(String staffWork_staff) {
		// TODO Auto-generated method stub
		return staffWorkDao.getWorks(staffWork_staff);
	}

	@Override
	public xsjsglxt_staffWork getWork(String xsjsglxt_staffWork_id) {
		// TODO Auto-generated method stub
		return staffWorkDao.getWork(xsjsglxt_staffWork_id);
	}

	@Override
	public String upadteWork(xsjsglxt_staffWork work) {
		// TODO Auto-generated method stub
		xsjsglxt_staffWork oldWork = staffWorkDao.getWork(work.getXsjsglxt_staffWork_id());
		oldWork.setStaffWork_address(work.getStaffWork_address());
		oldWork.setStaffWork_duty(work.getStaffWork_duty());
		oldWork.setStaffWork_gmt_modified(TeamUtil.getStringSecond());
		oldWork.setStaffWork_remarks(work.getStaffWork_remarks());
		oldWork.setStaffWork_startTime(work.getStaffWork_startTime());
		oldWork.setStaffWork_stopTime(work.getStaffWork_stopTime());
		return "updateSuccess";
	}

	@Override
	public String deleteWorks(String staffWork_staff) {
		// TODO Auto-generated method stub
		String result = staffWorkDao.deleteWorks(staffWork_staff);
		return result;
	}

	@Override
	public String deleteWork(String xsjsglxt_staffWork_id) {
		// TODO Auto-generated method stub
		String result = staffWorkDao.deleteWork(xsjsglxt_staffWork_id);
		return result;
	}

	@Override
	public String saveWorks(List<xsjsglxt_staffWork> works) {
		// TODO Auto-generated method stub
		for (xsjsglxt_staffWork xsjsglxt_staffWork : works) {
			xsjsglxt_staffWork.setStaffWork_gmt_create(TeamUtil.getStringSecond());
			xsjsglxt_staffWork.setStaffWork_gmt_modified(TeamUtil.getStringSecond());
			xsjsglxt_staffWork.setXsjsglxt_staffWork_id(TeamUtil.getUuid());
		}
		String result = staffWorkDao.saveWorks(works);
		return result;
	}
}
