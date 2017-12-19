
<<<<<<< HEAD
package com.xsjsglxt.service.impl.Case;


import com.xsjsglxt.dao.Case.HandleDao;
import com.xsjsglxt.service.Case.HandleService;

import java.util.ArrayList;
import java.util.List;

import com.xsjsglxt.dao.Case.HandleDao;
import com.xsjsglxt.domain.DO.xsjsglxt_handle;
import com.xsjsglxt.domain.DO.xsjsglxt_staff;
import com.xsjsglxt.domain.VO.Case.page_list_HandleInformationVO;
import com.xsjsglxt.service.Case.HandleService;

import util.TeamUtil;


public class HandleServiceImpl implements HandleService {
private HandleDao handleDao;

public HandleDao getHandleDao() {
	return handleDao;
}

public void setHandleDao(HandleDao handleDao) {
	this.handleDao = handleDao;
}


@Override
public void saveHandle(xsjsglxt_handle handle) {
	// TODO Auto-generated method stub
	handle.setXsjsglxt_handle_id(TeamUtil.getUuid());
	handle.setHandle_gnt_create(TeamUtil.getStringSecond());
	handle.setHandle_gmt_modified(handle.getHandle_gnt_create());
	handleDao.saveHandle(handle);
}

@Override
public page_list_HandleInformationVO VO_HandleInformation_By_PageAndSearch(
		page_list_HandleInformationVO page_list_HandleInformation) {
	// TODO Auto-generated method stub
	List<xsjsglxt_handle> listHandle = new ArrayList<xsjsglxt_handle>();
	//BreakecaseInformationDTO breakecaseInformationDTO;

	int i = handleDao.getCountHandleInformationByPage(page_list_HandleInformation);

	page_list_HandleInformation.setTotalRecords(i);
	page_list_HandleInformation.setTotalPages(((i - 1) / page_list_HandleInformation.getPageSize()) + 1);
	if (page_list_HandleInformation.getPageIndex() <= 1) {
		page_list_HandleInformation.setHavePrePage(false);
	} else {
		page_list_HandleInformation.setHavePrePage(true);
	}
	if (page_list_HandleInformation.getPageIndex() >= page_list_HandleInformation.getTotalPages()) {
		page_list_HandleInformation.setHaveNextPage(false);
	} else {
		page_list_HandleInformation.setHaveNextPage(true);
	}

	// 符合条件的记录
	listHandle = handleDao.getListHandleInformatioByPage(page_list_HandleInformation);

	
	page_list_HandleInformation.setListHandle(listHandle);
	
	return page_list_HandleInformation;
}

@Override
public xsjsglxt_handle HandleInformationOne(xsjsglxt_handle handle) {
	// TODO Auto-generated method stub
	return handleDao.HandleInformationOne(handle);
}

@Override
public void updateHandleInformation(xsjsglxt_handle handle) {
	// TODO Auto-generated method stub
	handle.setHandle_gmt_modified(TeamUtil.getStringSecond());
	handleDao.updateHandleInformation(handle);
}

@Override
public boolean remove_HandleInformationList(List<String> useHandleInformationNumList) {
	// TODO Auto-generated method stub
	boolean flag = false;
	for (String handle_id : useHandleInformationNumList) {
		xsjsglxt_handle xsjsglxt_handle = handleDao.getHandleByNum(handle_id);
		flag = handleDao.deleteHandleById(xsjsglxt_handle.getXsjsglxt_handle_id());// ����
		
	}
	return flag;
}


@Override
public int getMaxId() {
	// TODO Auto-generated method stub
	int i=handleDao.getMaxId();
	return (i+1);
}

@Override
public List<xsjsglxt_handle> allPoliceInHandlingCases() {
	// TODO Auto-generated method stub
	
	return handleDao.allPoliceInHandlingCases();
}


}
=======
package com.xsjsglxt.service.impl.Case;


import com.xsjsglxt.dao.Case.HandleDao;
import com.xsjsglxt.service.Case.HandleService;

import java.util.ArrayList;
import java.util.List;

import com.xsjsglxt.dao.Case.HandleDao;
import com.xsjsglxt.domain.DO.xsjsglxt_handle;
import com.xsjsglxt.domain.DO.xsjsglxt_staff;
import com.xsjsglxt.domain.VO.Case.page_list_HandleInformationVO;
import com.xsjsglxt.service.Case.HandleService;

import util.TeamUtil;


public class HandleServiceImpl implements HandleService {
private HandleDao handleDao;

public HandleDao getHandleDao() {
	return handleDao;
}

public void setHandleDao(HandleDao handleDao) {
	this.handleDao = handleDao;
}


@Override
public void saveHandle(xsjsglxt_handle handle) {
	// TODO Auto-generated method stub
	handle.setXsjsglxt_handle_id(TeamUtil.getUuid());
	handle.setHandle_gnt_create(TeamUtil.getStringSecond());
	handle.setHandle_gmt_modified(handle.getHandle_gnt_create());
	handleDao.saveHandle(handle);
}

@Override
public page_list_HandleInformationVO VO_HandleInformation_By_PageAndSearch(
		page_list_HandleInformationVO page_list_HandleInformation) {
	// TODO Auto-generated method stub
	List<xsjsglxt_handle> listHandle = new ArrayList<xsjsglxt_handle>();
	//BreakecaseInformationDTO breakecaseInformationDTO;

	int i = handleDao.getCountHandleInformationByPage(page_list_HandleInformation);

	page_list_HandleInformation.setTotalRecords(i);
	page_list_HandleInformation.setTotalPages(((i - 1) / page_list_HandleInformation.getPageSize()) + 1);
	if (page_list_HandleInformation.getPageIndex() <= 1) {
		page_list_HandleInformation.setHavePrePage(false);
	} else {
		page_list_HandleInformation.setHavePrePage(true);
	}
	if (page_list_HandleInformation.getPageIndex() >= page_list_HandleInformation.getTotalPages()) {
		page_list_HandleInformation.setHaveNextPage(false);
	} else {
		page_list_HandleInformation.setHaveNextPage(true);
	}

	// 符合条件的记录
	listHandle = handleDao.getListHandleInformatioByPage(page_list_HandleInformation);

	
	page_list_HandleInformation.setListHandle(listHandle);
	
	return page_list_HandleInformation;
}

@Override
public xsjsglxt_handle HandleInformationOne(xsjsglxt_handle handle) {
	// TODO Auto-generated method stub
	return handleDao.HandleInformationOne(handle);
}

@Override
public void updateHandleInformation(xsjsglxt_handle handle) {
	// TODO Auto-generated method stub
	handle.setHandle_gmt_modified(TeamUtil.getStringSecond());
	handleDao.updateHandleInformation(handle);
}

@Override
public boolean remove_HandleInformationList(List<String> useHandleInformationNumList) {
	// TODO Auto-generated method stub
	boolean flag = false;
	for (String handle_id : useHandleInformationNumList) {
		xsjsglxt_handle xsjsglxt_handle = handleDao.getHandleByNum(handle_id);
		flag = handleDao.deleteHandleById(xsjsglxt_handle.getXsjsglxt_handle_id());// ����
		
	}
	return flag;
}


@Override
public int getMaxId() {
	// TODO Auto-generated method stub
	int i=handleDao.getMaxId();
	return (i+1);
}


}
>>>>>>> origin/SLL

