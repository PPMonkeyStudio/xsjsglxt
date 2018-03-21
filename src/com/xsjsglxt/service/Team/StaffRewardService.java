package com.xsjsglxt.service.Team;

import java.util.List;

import com.xsjsglxt.domain.DO.xsjsglxt_staffReward;

public interface StaffRewardService {

	String saveRewards(List<xsjsglxt_staffReward> rewards);

	String deleteReward(String xsjsglxt_staffReward_id);

	String deleteRewards(String staffReward_staff);

	String upadteReward(xsjsglxt_staffReward reward);

	xsjsglxt_staffReward getReward(String xsjsglxt_staffReward_id);

	List<xsjsglxt_staffReward> getRewards(String staffReward_staff);

}
