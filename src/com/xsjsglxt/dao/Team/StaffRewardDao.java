package com.xsjsglxt.dao.Team;

import java.util.List;

import com.xsjsglxt.domain.DO.xsjsglxt_staffReward;

public interface StaffRewardDao {

	String saveRewards(List<xsjsglxt_staffReward> rewards);

	String deleteReward(String xsjsglxt_staffReward_id);

	String deleteRewards(String staffReward_staff);

	xsjsglxt_staffReward getReward(String xsjsglxt_staffReward_id);

	List<xsjsglxt_staffReward> getRewards(String staffReward_staff);

}
