package com.xsjsglxt.domain.VO.Team;

import java.util.List;

import com.xsjsglxt.domain.DO.xsjsglxt_staff;

public class policemanDutyVO {
	private List<xsjsglxt_staff> staffLeader; // 带班领导
	private List<xsjsglxt_staff> staffMain; // 主班
	private List<xsjsglxt_staff> staffAssitant; // 副班

	public List<xsjsglxt_staff> getStaffLeader() {
		return staffLeader;
	}

	public void setStaffLeader(List<xsjsglxt_staff> staffLeader) {
		this.staffLeader = staffLeader;
	}

	public List<xsjsglxt_staff> getStaffMain() {
		return staffMain;
	}

	public void setStaffMain(List<xsjsglxt_staff> staffMain) {
		this.staffMain = staffMain;
	}

	public List<xsjsglxt_staff> getStaffAssitant() {
		return staffAssitant;
	}

	public void setStaffAssitant(List<xsjsglxt_staff> staffAssitant) {
		this.staffAssitant = staffAssitant;
	}
}
