package com.xsjsglxt.dao.Team;

import java.util.List;

import com.xsjsglxt.domain.DO.xsjsglxt_staff;
import com.xsjsglxt.domain.VO.Team.page_list_staffInformationVO;

public interface StaffDao {

public	boolean saveStaff(xsjsglxt_staff staff);

public int getCountStaffInformationByPage(page_list_staffInformationVO page_list_staffInformation);

public List<xsjsglxt_staff> getListStaffInformatioByPage(page_list_staffInformationVO page_list_staffInformation);

public xsjsglxt_staff StaffInformationOne(xsjsglxt_staff staff);

public void updateStaffInformation(xsjsglxt_staff staff);

public com.xsjsglxt.domain.DO.xsjsglxt_staff getStaffByNum(String staff_id);

public boolean deleteStaffById(String xsjsglxt_staff_id);



}
