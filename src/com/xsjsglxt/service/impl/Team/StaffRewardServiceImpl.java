package com.xsjsglxt.service.impl.Team;

import java.util.List;

import com.xsjsglxt.dao.Team.StaffRewardDao;
import com.xsjsglxt.domain.DO.xsjsglxt_staffReward;
import com.xsjsglxt.service.Team.StaffRewardService;

import util.TeamUtil;

public class StaffRewardServiceImpl implements StaffRewardService {
	private StaffRewardDao staffRewardDao;
	private final static String UPDATE = "updateSuccess";

	public StaffRewardDao getStaffRewardDao() {
		return staffRewardDao;
	}

	public void setStaffRewardDao(StaffRewardDao staffRewardDao) {
		this.staffRewardDao = staffRewardDao;
	}

	@Override
	public String saveRewards(List<xsjsglxt_staffReward> rewards) {
		// TODO Auto-generated method stub
		for (xsjsglxt_staffReward xsjsglxt_staffReward : rewards) {
			xsjsglxt_staffReward.setStaffReward_gmt_create(TeamUtil.getStringSecond());
			xsjsglxt_staffReward.setStaffReward_gmt_modified(TeamUtil.getStringSecond());
			xsjsglxt_staffReward.setXsjsglxt_staffReward_id(TeamUtil.getUuid());
		}
		String result = staffRewardDao.saveRewards(rewards);
		return result;
	}

	@Override
	public String deleteReward(String xsjsglxt_staffReward_id) {
		// TODO Auto-generated method stub
		String result = staffRewardDao.deleteReward(xsjsglxt_staffReward_id);
		return result;
	}

	@Override
	public String deleteRewards(String staffReward_staff) {
		// TODO Auto-generated method stub
		String result = staffRewardDao.deleteRewards(staffReward_staff);
		return result;
	}

	@Override
	public String upadteReward(xsjsglxt_staffReward reward) {
		// TODO Auto-generated method stub
		xsjsglxt_staffReward oldReward = staffRewardDao.getReward(reward.getXsjsglxt_staffReward_id());
		oldReward.setStaffReward_gmt_modified(TeamUtil.getStringSecond());
		oldReward.setStaffReward_remarks(reward.getStaffReward_remarks());
		oldReward.setStaffReward_situation(reward.getStaffReward_situation());
		oldReward.setStaffReward_Time(reward.getStaffReward_Time());
		return UPDATE;
	}

	@Override
	public xsjsglxt_staffReward getReward(String xsjsglxt_staffReward_id) {
		// TODO Auto-generated method stub
		return staffRewardDao.getReward(xsjsglxt_staffReward_id);
	}

	@Override
	public List<xsjsglxt_staffReward> getRewards(String staffReward_staff) {
		// TODO Auto-generated method stub
		return staffRewardDao.getRewards(staffReward_staff);
	}
}
