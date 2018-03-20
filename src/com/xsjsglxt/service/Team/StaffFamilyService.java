package com.xsjsglxt.service.Team;

import java.util.List;

import com.xsjsglxt.domain.DO.xsjsglxt_staffFamily;

public interface StaffFamilyService {

	String saveFamily(xsjsglxt_staffFamily family);

	String deleteFamilyByFamilyId(xsjsglxt_staffFamily family);

	String deleteFamilyByStaffId(xsjsglxt_staffFamily family);

	String updateFamily(xsjsglxt_staffFamily family);

	xsjsglxt_staffFamily getFamilyByFamilyId(String xsjsglxt_staffFamily_id);

	List<xsjsglxt_staffFamily> getFamilyByStaffId(String staffFamily_staff);

}
