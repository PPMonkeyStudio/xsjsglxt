package com.xsjsglxt.dao.Team;

import java.util.List;

import com.xsjsglxt.domain.DO.xsjsglxt_staff;
import com.xsjsglxt.domain.DTO.Team.policemanListDTO;
import com.xsjsglxt.domain.VO.Team.policemanListVO;

public interface StaffDao {
	String savePoliceman(xsjsglxt_staff policeman);

	String deletePoliceman(xsjsglxt_staff policeman);

	xsjsglxt_staff getPolicemanByStaffId(String xsjsglxt_staff_id);

	String updatePoliceman(xsjsglxt_staff policeman);

	int getPolicemanCount(policemanListVO policemanVO);

	List<policemanListDTO> getPolicemansByPage(policemanListVO policemanVO);
}
