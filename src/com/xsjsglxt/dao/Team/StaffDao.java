package com.xsjsglxt.dao.Team;

import java.util.List;
import java.util.Map;

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

	public void getConnect();

	List<xsjsglxt_staff> getAllPoliceman();

	List<xsjsglxt_staff> getSchedulingStaff(String pointer);

	List<xsjsglxt_staff> getMeetCompere();

	List<xsjsglxt_staff> getMeetRecorder();

	Map<String, List<xsjsglxt_staff>> getInquestPerson();

	List<xsjsglxt_staff> getHandleCenter();

	List<xsjsglxt_staff> getHandleCheck();

	List<xsjsglxt_staff> getAllStaff(String duty,String auty);
}
