package com.xsjsglxt.action.Team;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import com.xsjsglxt.domain.DO.xsjsglxt_staffReward;
import com.xsjsglxt.service.Team.StaffRewardService;

/*
 * @author 孙毅
 * @description 奖励管理
 */
public class StaffRewardAction extends ActionSupport {
	private StaffRewardService staffRewardService;
	private xsjsglxt_staffReward reward;
	private List<xsjsglxt_staffReward> rewards;

	// --------------------------------保存奖励信息——------------------------
	public void saveRewards() {
		String result = staffRewardService.saveRewards(rewards);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		try {
			PrintWriter pw = response.getWriter();
			pw.write(result);
			pw.flush();
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// ---------------------------------删除单个奖励信息--------------------------
	public void deleteReward() {
		String result = staffRewardService.deleteReward(reward.getXsjsglxt_staffReward_id());
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		try {
			PrintWriter pw = response.getWriter();
			pw.write(result);
			pw.flush();
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// ---------------------------------删除多个奖励信息--------------------------
	public void deleteRewards() {
		String result = staffRewardService.deleteRewards(reward.getStaffReward_staff());
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		try {
			PrintWriter pw = response.getWriter();
			pw.write(result);
			pw.flush();
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// ---------------------------------修改奖励信息----------------------------------
	public void updateReward() {
		String result = staffRewardService.upadteReward(reward);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		try {
			PrintWriter pw = response.getWriter();
			pw.write(result);
			pw.flush();
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// ------------------------------获得单个奖励信息---------------------------------
	public void getRewardByRewardId() {
		xsjsglxt_staffReward oldReward = staffRewardService.getReward(reward.getXsjsglxt_staffReward_id());
		Gson gson = new Gson();
		String result = gson.toJson(oldReward);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		try {
			PrintWriter pw = response.getWriter();
			pw.write(result);
			pw.flush();
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// ------------------------------获得多个奖励信息---------------------------------
	public void getRewardByStaffId() {
		List<xsjsglxt_staffReward> rewards = staffRewardService.getRewards(reward.getStaffReward_staff());
		String result;
		if (rewards.size() <= 0) {
			result = "rewardsIsNull";
		} else {
			Gson gson = new Gson();
			result = gson.toJson(rewards);
		}
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		try {
			PrintWriter pw = response.getWriter();
			pw.write(result);
			pw.flush();
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// ----------------------------setter/getter---------------------------

	public StaffRewardService getStaffRewardService() {
		return staffRewardService;
	}

	public xsjsglxt_staffReward getReward() {
		return reward;
	}

	public void setReward(xsjsglxt_staffReward reward) {
		this.reward = reward;
	}

	public List<xsjsglxt_staffReward> getRewards() {
		return rewards;
	}

	public void setRewards(List<xsjsglxt_staffReward> rewards) {
		this.rewards = rewards;
	}

	public void setStaffRewardService(StaffRewardService staffRewardService) {
		this.staffRewardService = staffRewardService;
	}
}
