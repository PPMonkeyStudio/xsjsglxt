<<<<<<< HEAD
package com.xsjsglxt.service.impl.Case;

import java.util.ArrayList;
import java.util.List;

import com.xsjsglxt.dao.Case.BreakecaseDao;
import com.xsjsglxt.domain.DO.xsjsglxt_breakecase;
import com.xsjsglxt.domain.DO.xsjsglxt_briefdetails;
import com.xsjsglxt.domain.DO.xsjsglxt_case;
import com.xsjsglxt.domain.DO.xsjsglxt_lost;
import com.xsjsglxt.domain.DO.xsjsglxt_lost_computer;
import com.xsjsglxt.domain.DO.xsjsglxt_lost_mobilephone;
import com.xsjsglxt.domain.DO.xsjsglxt_picture;
import com.xsjsglxt.domain.DO.xsjsglxt_resevidence;
import com.xsjsglxt.domain.DO.xsjsglxt_snece;
import com.xsjsglxt.domain.DTO.Case.BreakecaseInformationDTO;
import com.xsjsglxt.domain.DTO.Case.SenceInformationDTO;
import com.xsjsglxt.domain.VO.Case.page_list_BreakecaseInformationVO;
import com.xsjsglxt.service.Case.BreakecaseService;

import util.TeamUtil;

public class BreakecaseServiceImpl implements BreakecaseService {
private BreakecaseDao breakecaseDao;

public BreakecaseDao getBreakecaseDao() {
	return breakecaseDao;
}

public void setBreakecaseDao(BreakecaseDao breakecaseDao) {
	this.breakecaseDao = breakecaseDao;
}

@Override
public void saveBreakecase(xsjsglxt_breakecase breakecase) {
	// TODO Auto-generated method stub
	breakecase.setXsjsglxt_breakecase_id(TeamUtil.getUuid());
	breakecase.setBreakecase_gmt_create(TeamUtil.getStringSecond());
	breakecase.setBreakecase_gmt_modified(breakecase.getBreakecase_gmt_create());
	breakecaseDao.saveBreakecase(breakecase);
}

@Override
public page_list_BreakecaseInformationVO VO_BreakecaseInformation_By_PageAndSearch(
		page_list_BreakecaseInformationVO page_list_BreakecaseInformation) {
	// TODO Auto-generated method stub
	List<BreakecaseInformationDTO> BreakecaseInformationDTOList = new ArrayList<BreakecaseInformationDTO>();
	List<xsjsglxt_breakecase> listBreakecase = new ArrayList<xsjsglxt_breakecase>();
	BreakecaseInformationDTO breakecaseInformationDTO;

	

	xsjsglxt_snece sence;//现场勘验表

	xsjsglxt_case case1;//案件表
	
	int i = breakecaseDao.getCountBreakecaseInformationByPage(page_list_BreakecaseInformation);

	page_list_BreakecaseInformation.setTotalRecords(i);
	page_list_BreakecaseInformation.setTotalPages(((i - 1) / page_list_BreakecaseInformation.getPageSize()) + 1);
	if (page_list_BreakecaseInformation.getPageIndex() <= 1) {
		page_list_BreakecaseInformation.setHavePrePage(false);
	} else {
		page_list_BreakecaseInformation.setHavePrePage(true);
	}
	if (page_list_BreakecaseInformation.getPageIndex() >= page_list_BreakecaseInformation.getTotalPages()) {
		page_list_BreakecaseInformation.setHaveNextPage(false);
	} else {
		page_list_BreakecaseInformation.setHaveNextPage(true);
	}

	// 符合条件的记录
	listBreakecase = breakecaseDao.getListBreakecaseInformatioByPage(page_list_BreakecaseInformation);

	for (xsjsglxt_breakecase breakecase : listBreakecase) {
		case1=breakecaseDao.get_case_ByBreakecaseId(breakecase);
		sence = breakecaseDao.get_sence_Byxsjsglxt_case_id(case1);// 6
		sence.setSnece_inquestId(sence.getSnece_inquestId().substring(10));
	
	
		breakecaseInformationDTO = new BreakecaseInformationDTO(breakecase,sence,case1);
				

		BreakecaseInformationDTOList.add(breakecaseInformationDTO);
	}
	page_list_BreakecaseInformation.setBreakecaseInformationDTOList(BreakecaseInformationDTOList);
	
	return page_list_BreakecaseInformation;
}

@Override
public BreakecaseInformationDTO BreakecaseInformationOne(xsjsglxt_breakecase breakecase) {
	// TODO Auto-generated method stub
	 breakecase=breakecaseDao.getBreakecaseById(breakecase);
	 xsjsglxt_case 	case1=breakecaseDao.getCaseById(breakecase);
	xsjsglxt_snece sence=breakecaseDao.getSenceByID(case1);
	
	BreakecaseInformationDTO breakecaseInformationDTO= new BreakecaseInformationDTO(breakecase,sence,case1);
	return breakecaseInformationDTO;
}

@Override
public void updateCase(xsjsglxt_case case1) {
	// TODO Auto-generated method stub
	case1.setCase_gmt_modified(TeamUtil.getStringSecond());
	breakecaseDao.updateCase(case1);
}

@Override
public void updateBreakcase(xsjsglxt_breakecase breakecase) {
	// TODO Auto-generated method stub
	//xsjsglxt_breakecase  oldbreakecase=breakecaseDao.getByID(xsjsglxt_case_id);
	//breakecase.setXsjsglxt_breakecase_id(oldbreakecase.getXsjsglxt_breakecase_id());
	//breakecase.setBreakecase_case(oldbreakecase.getBreakecase_case());
	//breakecase.setBreakecase_gmt_create(oldbreakecase.getBreakecase_gmt_create());
	breakecase.setBreakecase_gmt_modified(TeamUtil.getStringSecond());
	breakecaseDao.updateBreakcase(breakecase);
}

@Override
public void updateSence(xsjsglxt_snece sence, String xsjsglxt_case_id) {
	// TODO Auto-generated method stub
	xsjsglxt_snece oldsence=breakecaseDao.getByCID(xsjsglxt_case_id);
	sence.setXsjsglxt_snece_id(oldsence.getXsjsglxt_snece_id());
	sence.setSnece_case(oldsence.getSnece_case());
	sence.setSnece_gmt_create(oldsence.getSnece_gmt_create());
	sence.setSnece_gmt_modified(TeamUtil.getStringSecond());
	breakecaseDao.updateSence(sence);
}

@Override
public boolean remove_BreakecaseInformationList(List<String> useBreakecaseInformationNumList) {
	// TODO Auto-generated method stub
	boolean flag = false;
	for (String breakecase_id : useBreakecaseInformationNumList) {
		xsjsglxt_breakecase xsjsglxt_breakecase = breakecaseDao.getBreakecaseByNum(breakecase_id);
		flag = breakecaseDao.deleteBreakecaseById(xsjsglxt_breakecase.getXsjsglxt_breakecase_id());// ����
		
	}
	return flag;
}

}
=======
package com.xsjsglxt.service.impl.Case;

import java.util.ArrayList;
import java.util.List;

import com.xsjsglxt.dao.Case.BreakecaseDao;
import com.xsjsglxt.domain.DO.xsjsglxt_breakecase;
import com.xsjsglxt.domain.DO.xsjsglxt_briefdetails;
import com.xsjsglxt.domain.DO.xsjsglxt_case;
import com.xsjsglxt.domain.DO.xsjsglxt_lost;
import com.xsjsglxt.domain.DO.xsjsglxt_lost_computer;
import com.xsjsglxt.domain.DO.xsjsglxt_lost_mobilephone;
import com.xsjsglxt.domain.DO.xsjsglxt_picture;
import com.xsjsglxt.domain.DO.xsjsglxt_resevidence;
import com.xsjsglxt.domain.DO.xsjsglxt_snece;
import com.xsjsglxt.domain.DTO.Case.BreakecaseInformationDTO;
import com.xsjsglxt.domain.DTO.Case.SenceInformationDTO;
import com.xsjsglxt.domain.VO.Case.page_list_BreakecaseInformationVO;
import com.xsjsglxt.service.Case.BreakecaseService;

import util.TeamUtil;

public class BreakecaseServiceImpl implements BreakecaseService {
private BreakecaseDao breakecaseDao;

public BreakecaseDao getBreakecaseDao() {
	return breakecaseDao;
}

public void setBreakecaseDao(BreakecaseDao breakecaseDao) {
	this.breakecaseDao = breakecaseDao;
}

@Override
public void saveBreakecase(xsjsglxt_breakecase breakecase) {
	// TODO Auto-generated method stub
	breakecase.setXsjsglxt_breakecase_id(TeamUtil.getUuid());
	breakecase.setBreakecase_gmt_create(TeamUtil.getStringSecond());
	breakecase.setBreakecase_gmt_modified(breakecase.getBreakecase_gmt_create());
	breakecaseDao.saveBreakecase(breakecase);
}

@Override
public page_list_BreakecaseInformationVO VO_BreakecaseInformation_By_PageAndSearch(
		page_list_BreakecaseInformationVO page_list_BreakecaseInformation) {
	// TODO Auto-generated method stub
	List<BreakecaseInformationDTO> BreakecaseInformationDTOList = new ArrayList<BreakecaseInformationDTO>();
	List<xsjsglxt_breakecase> listBreakecase = new ArrayList<xsjsglxt_breakecase>();
	BreakecaseInformationDTO breakecaseInformationDTO;

	

	xsjsglxt_snece sence;//现场勘验表

	xsjsglxt_case case1;//案件表
	
	int i = breakecaseDao.getCountBreakecaseInformationByPage(page_list_BreakecaseInformation);

	page_list_BreakecaseInformation.setTotalRecords(i);
	page_list_BreakecaseInformation.setTotalPages(((i - 1) / page_list_BreakecaseInformation.getPageSize()) + 1);
	if (page_list_BreakecaseInformation.getPageIndex() <= 1) {
		page_list_BreakecaseInformation.setHavePrePage(false);
	} else {
		page_list_BreakecaseInformation.setHavePrePage(true);
	}
	if (page_list_BreakecaseInformation.getPageIndex() >= page_list_BreakecaseInformation.getTotalPages()) {
		page_list_BreakecaseInformation.setHaveNextPage(false);
	} else {
		page_list_BreakecaseInformation.setHaveNextPage(true);
	}

	// 符合条件的记录
	listBreakecase = breakecaseDao.getListBreakecaseInformatioByPage(page_list_BreakecaseInformation);

	for (xsjsglxt_breakecase breakecase : listBreakecase) {
		case1=breakecaseDao.get_case_ByBreakecaseId(breakecase);
		sence = breakecaseDao.get_sence_Byxsjsglxt_case_id(case1);// 6
		sence.setSnece_inquestId(sence.getSnece_inquestId().substring(10));
	
	
		breakecaseInformationDTO = new BreakecaseInformationDTO(breakecase,sence,case1);
				

		BreakecaseInformationDTOList.add(breakecaseInformationDTO);
	}
	page_list_BreakecaseInformation.setBreakecaseInformationDTOList(BreakecaseInformationDTOList);
	
	return page_list_BreakecaseInformation;
}

@Override
public BreakecaseInformationDTO BreakecaseInformationOne(xsjsglxt_case case1) {
	// TODO Auto-generated method stub
	case1=breakecaseDao.getCaseById(case1);
	xsjsglxt_snece sence=breakecaseDao.getSenceByID(case1);
	xsjsglxt_breakecase breakecase=breakecaseDao.getBreakecaseById(case1);
	BreakecaseInformationDTO breakecaseInformationDTO= new BreakecaseInformationDTO(breakecase,sence,case1);
	return breakecaseInformationDTO;
}

@Override
public void updateCase(xsjsglxt_case case1) {
	// TODO Auto-generated method stub
	case1.setCase_gmt_modified(TeamUtil.getStringSecond());
	breakecaseDao.updateCase(case1);
}

@Override
public void updateBreakcase(xsjsglxt_breakecase breakecase, String xsjsglxt_case_id) {
	// TODO Auto-generated method stub
	xsjsglxt_breakecase  oldbreakecase=breakecaseDao.getByID(xsjsglxt_case_id);
	breakecase.setXsjsglxt_breakecase_id(oldbreakecase.getXsjsglxt_breakecase_id());
	breakecase.setBreakecase_case(oldbreakecase.getBreakecase_case());
	breakecase.setBreakecase_gmt_create(oldbreakecase.getBreakecase_gmt_create());
	breakecase.setBreakecase_gmt_modified(TeamUtil.getStringSecond());
	breakecaseDao.updateBreakcase(breakecase);
}

@Override
public void updateSence(xsjsglxt_snece sence, String xsjsglxt_case_id) {
	// TODO Auto-generated method stub
	xsjsglxt_snece oldsence=breakecaseDao.getByCID(xsjsglxt_case_id);
	sence.setXsjsglxt_snece_id(oldsence.getXsjsglxt_snece_id());
	sence.setSnece_case(oldsence.getSnece_case());
	sence.setSnece_gmt_create(oldsence.getSnece_gmt_create());
	sence.setSnece_gmt_modified(TeamUtil.getStringSecond());
	breakecaseDao.updateSence(sence);
}

@Override
public boolean remove_BreakecaseInformationList(List<String> useBreakecaseInformationNumList) {
	// TODO Auto-generated method stub
	boolean flag = false;
	for (String breakecase_id : useBreakecaseInformationNumList) {
		xsjsglxt_breakecase xsjsglxt_breakecase = breakecaseDao.getBreakecaseByNum(breakecase_id);
		flag = breakecaseDao.deleteBreakecaseById(xsjsglxt_breakecase.getXsjsglxt_breakecase_id());// ����
		
	}
	return flag;
}

}
>>>>>>> origin/SLL
