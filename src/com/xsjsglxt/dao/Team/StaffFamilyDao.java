package com.xsjsglxt.dao.Team;

import java.util.List;

import com.xsjsglxt.domain.DO.xsjsglxt_staffFamily;

public interface StaffFamilyDao {

	String deleteFamilyByFamilyId(xsjsglxt_staffFamily family);

	String deleteFamilyByStaffId(xsjsglxt_staffFamily family);

	xsjsglxt_staffFamily getFamilyByFamilyID(String xsjsglxt_staffFamily_id);

	String updateFamilyByFamilyId(xsjsglxt_staffFamily family);

	List<xsjsglxt_staffFamily> getFamilyByStaffId(String staffFamily_staff);

	String saveFamily(List<xsjsglxt_staffFamily> familys);

}
