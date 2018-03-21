package com.xsjsglxt.service.Team;

import com.xsjsglxt.domain.DO.xsjsglxt_staff;

public interface StaffService {
	/*
	 * 保存人员信息
	 */
	String saveStaff(xsjsglxt_staff policeman);

	String deletePoliceman(xsjsglxt_staff policeman);

	String updatePoliceman(xsjsglxt_staff policeman);

	xsjsglxt_staff getPolicemanByStaffId(String xsjsglxt_staff_id);
}
