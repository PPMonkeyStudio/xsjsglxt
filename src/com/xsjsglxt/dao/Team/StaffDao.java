package com.xsjsglxt.dao.Team;

import com.xsjsglxt.domain.DO.xsjsglxt_staff;

public interface StaffDao {
	String savePoliceman(xsjsglxt_staff policeman);

	String deletePoliceman(xsjsglxt_staff policeman);

	xsjsglxt_staff getPolicemanByStaffId(String xsjsglxt_staff_id);

	String updatePoliceman(xsjsglxt_staff policeman);
}
