package com.xsjsglxt.service.Team;

import java.util.List;

import com.xsjsglxt.domain.DO.xsjsglxt_staff;
import com.xsjsglxt.domain.VO.Team.page_list_staffInformationVO;

public interface StaffService {
/*
 * 保存人员信息
 */
public 	boolean saveStaff(xsjsglxt_staff staff);
/*
 * 列表信息
 */
public page_list_staffInformationVO VO_StaffInformation_By_PageAndSearch(
		page_list_staffInformationVO page_list_staffInformation);
public xsjsglxt_staff StaffInformationOne(xsjsglxt_staff staff);
public void updateStaffInformation(xsjsglxt_staff staff);
public boolean remove_StaffInformationList(String useStaffInformationNumList);

}
