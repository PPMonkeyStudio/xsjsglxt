package com.xsjsglxt.service.impl.Team;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.xsjsglxt.dao.Team.StaffDao;
import com.xsjsglxt.domain.DO.xsjsglxt_breakecase;
import com.xsjsglxt.domain.DO.xsjsglxt_case;
import com.xsjsglxt.domain.DO.xsjsglxt_snece;
import com.xsjsglxt.domain.DO.xsjsglxt_staff;
import com.xsjsglxt.domain.DTO.Case.BreakecaseInformationDTO;
import com.xsjsglxt.domain.VO.Team.page_list_staffInformationVO;
import com.xsjsglxt.service.Team.StaffService;

import util.TeamUtil;

public class StaffServiceImpl implements StaffService {
private StaffDao staffDao;

public StaffDao getStaffDao() {
	return staffDao;
}

public void setStaffDao(StaffDao staffDao) {
	this.staffDao = staffDao;
}

@Override
public boolean saveStaff(xsjsglxt_staff staff) {
	// TODO Auto-generated method stub
	staff.setXsjsglxt_staff_id(TeamUtil.getUuid());
	System.out.println("id"+staff.getXsjsglxt_staff_id());
	staff.setStaff_gmt_create(TeamUtil.getStringSecond());
	System.out.println("创建时间"+staff.getStaff_gmt_create());
	staff.setStaff_gmt_modified(staff.getStaff_gmt_create());
	if(staffDao.saveStaff(staff)){
		return true;
	}else{
		return false;
	}
}

@Override
public page_list_staffInformationVO VO_StaffInformation_By_PageAndSearch(
		page_list_staffInformationVO page_list_staffInformation) {
	// TODO Auto-generated method stub
	//List<BreakecaseInformationDTO> BreakecaseInformationDTOList = new ArrayList<BreakecaseInformationDTO>();
	List<xsjsglxt_staff> listStaff = new ArrayList<xsjsglxt_staff>();
	//BreakecaseInformationDTO breakecaseInformationDTO;

	int i = staffDao.getCountStaffInformationByPage(page_list_staffInformation);

	page_list_staffInformation.setTotalRecords(i);
	page_list_staffInformation.setTotalPages(((i - 1) / page_list_staffInformation.getPageSize()) + 1);
	if (page_list_staffInformation.getPageIndex() <= 1) {
		page_list_staffInformation.setHavePrePage(false);
	} else {
		page_list_staffInformation.setHavePrePage(true);
	}
	if (page_list_staffInformation.getPageIndex() >= page_list_staffInformation.getTotalPages()) {
		page_list_staffInformation.setHaveNextPage(false);
	} else {
		page_list_staffInformation.setHaveNextPage(true);
	}

	// 符合条件的记录
	listStaff = staffDao.getListStaffInformatioByPage(page_list_staffInformation);

	
	page_list_staffInformation.setListStaff(listStaff);
	
	return page_list_staffInformation;
}

@Override
public xsjsglxt_staff StaffInformationOne(xsjsglxt_staff staff) {
	// TODO Auto-generated method stub
	return staffDao.StaffInformationOne(staff);
}

@Override
public void updateStaffInformation(xsjsglxt_staff staff) {
	// TODO Auto-generated method stub
	staff.setStaff_gmt_modified(TeamUtil.getStringSecond());
	staffDao.updateStaffInformation(staff);
}

@Override
public boolean remove_StaffInformationList(String useStaffInformationNumList) {
	// TODO Auto-generated method stub
	boolean flag = false;
	String sourceStr = useStaffInformationNumList;
	String[] sourceStrArray = sourceStr.split(",");
	for (String staff_id : sourceStrArray) {
		xsjsglxt_staff xsjsglxt_staff = staffDao.getStaffByNum(staff_id);
		flag = staffDao.deleteStaffById(xsjsglxt_staff.getXsjsglxt_staff_id());// ����
	  // flag=removeStaffImgByNewsID(xsjsglxt_staff);
	}
	return flag;
}

private boolean removeStaffImgByNewsID(xsjsglxt_staff xsjsglxt_staff) {
	// TODO Auto-generated method stub
	if (xsjsglxt_staff.getStaff_photo().equals("default.jpg")) {

	} else {
		System.out.println("删除照片：" + xsjsglxt_staff.getStaff_photo());
		File Img = new File("C://xsjsglxt_img/bimg/" + xsjsglxt_staff.getStaff_photo());
		Img.delete();
	
		return true;
	}
	
	return false;
}



}

