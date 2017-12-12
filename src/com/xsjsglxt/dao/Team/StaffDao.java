package com.xsjsglxt.dao.Team;

import java.util.List;

import com.xsjsglxt.domain.DO.xsjsglxt_staff;
import com.xsjsglxt.domain.VO.Team.page_list_staffInformationVO;

public interface StaffDao {

public	boolean saveStaff(xsjsglxt_staff staff);

public int getCountStaffInformationByPage(page_list_staffInformationVO page_list_staffInformation);

public List<xsjsglxt_staff> getListStaffInformatioByPage(page_list_staffInformationVO page_list_staffInformation);

}
