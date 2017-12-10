package com.xsjsglxt.service.impl.Case;

import java.util.ArrayList;
import java.util.List;

import com.xsjsglxt.dao.Case.LostMobilephoneDao;
import com.xsjsglxt.domain.DO.xsjsglxt_case;
import com.xsjsglxt.domain.DO.xsjsglxt_lost;
import com.xsjsglxt.domain.DO.xsjsglxt_lost_mobilephone;
import com.xsjsglxt.domain.DO.xsjsglxt_snece;
import com.xsjsglxt.domain.DTO.Case.LostInformationDTO;
import com.xsjsglxt.domain.DTO.Case.LostMobilephoneInformationDTO;
import com.xsjsglxt.domain.VO.Case.page_list_CasematerialVO;
import com.xsjsglxt.service.Case.LostMobilephoneService;

import util.TeamUtil;

public class LostMobilephoneServiceImpl implements LostMobilephoneService {
private LostMobilephoneDao lostMobilephoneDao;

public LostMobilephoneDao getLostMobilephoneDao() {
	return lostMobilephoneDao;
}

public void setLostMobilephoneDao(LostMobilephoneDao lostMobilephoneDao) {
	this.lostMobilephoneDao = lostMobilephoneDao;
}
/*
 *保存损失手机信息 
 */
@Override
public void saveLostMobilephone(xsjsglxt_lost_mobilephone lost_mobilephone) {
	// TODO Auto-generated method stub
	lost_mobilephone.setXsjsglxt_lost_mobilephone_id(TeamUtil.getUuid());
	lost_mobilephone.setLost_mobilephone_gmt_create(TeamUtil.getStringSecond());
	lost_mobilephone.setLost_mobilephone_gmt_modified(lost_mobilephone.getLost_mobilephone_gmt_create());
	lostMobilephoneDao.saveLostMobilephone(lost_mobilephone);
}

@Override
public page_list_CasematerialVO VO_LostMobilephoneformation_By_PageAndSearch(
		page_list_CasematerialVO page_list_Casematerial) {
	// TODO Auto-generated method stub
	List<LostMobilephoneInformationDTO> LostMobilephoneInformationDTOList = new ArrayList<LostMobilephoneInformationDTO>();
	List<xsjsglxt_lost_mobilephone> lost_mobilephoneList= new ArrayList<xsjsglxt_lost_mobilephone>();
	LostMobilephoneInformationDTO lostMobilephoneInformationDTO;
	   
	xsjsglxt_case case1;
	xsjsglxt_snece snece;
	// 符合筛选条件的记录数
	int i = lostMobilephoneDao.getCountLostMobilephoneInformationByPage(page_list_Casematerial);
	page_list_Casematerial.setTotalRecords(i);
	page_list_Casematerial.setTotalPages(((i - 1) / page_list_Casematerial.getPageSize()) + 1);
	if (page_list_Casematerial.getPageIndex() <= 1) {
		page_list_Casematerial.setHavePrePage(false);
	} else {
		page_list_Casematerial.setHavePrePage(true);
	}
	if (page_list_Casematerial.getPageIndex() >= page_list_Casematerial.getTotalPages()) {
		page_list_Casematerial.setHaveNextPage(false);
	} else {
		page_list_Casematerial.setHaveNextPage(true);
	}
	// 符合筛选条件的记录
	lost_mobilephoneList = lostMobilephoneDao.getListLostMobilephoneInformatioByPage(page_list_Casematerial);
	for (xsjsglxt_lost_mobilephone lost_mobilephone : lost_mobilephoneList) {
		//1
		if (page_list_Casematerial.getLost_mobilephone_phone() != null
				&& page_list_Casematerial.getLost_mobilephone_phone().trim().length() > 0) {
			lost_mobilephone.setLost_mobilephone_phone(lost_mobilephone.getLost_mobilephone_phone().replaceAll(lost_mobilephone.getLost_mobilephone_phone(),
					"<span style='color: #ff5063;'>" + lost_mobilephone.getLost_mobilephone_phone().trim() + "</span>"));
		}
		//2
		if (page_list_Casematerial.getLost_mobilephone_IMEI() != null
				&& page_list_Casematerial.getLost_mobilephone_IMEI().trim().length() > 0) {
			lost_mobilephone.setLost_mobilephone_IMEI(lost_mobilephone.getLost_mobilephone_IMEI().replaceAll(lost_mobilephone.getLost_mobilephone_IMEI(),
					"<span style='color: #ff5063;'>" + lost_mobilephone.getLost_mobilephone_IMEI().trim() + "</span>"));
		}
		//3
		if (page_list_Casematerial.getLost_mobilephone_feature() != null
				&& page_list_Casematerial.getLost_mobilephone_feature().trim().length() > 0) {
			lost_mobilephone.setLost_mobilephone_feature(lost_mobilephone.getLost_mobilephone_feature().replaceAll(lost_mobilephone.getLost_mobilephone_feature(),
					"<span style='color: #ff5063;'>" + lost_mobilephone.getLost_mobilephone_feature() + "</span>"));
		}
		case1=lostMobilephoneDao.getCaseByxsjsglxt_lost_mobilephone_id(lost_mobilephone);
		snece=lostMobilephoneDao.getSenceByxsjsglxt_case_id(case1);
		lostMobilephoneInformationDTO = new LostMobilephoneInformationDTO(case1,snece,lost_mobilephone);
		LostMobilephoneInformationDTOList.add(lostMobilephoneInformationDTO);
	}
	page_list_Casematerial.setLostMobilephoneInformationDTOList(LostMobilephoneInformationDTOList);
	return page_list_Casematerial;
}

@Override
public LostMobilephoneInformationDTO LostMobiephoneInformationOne(xsjsglxt_lost_mobilephone lost_mobilephone) {
	// TODO Auto-generated method stub
	lost_mobilephone=lostMobilephoneDao.getLostMobiephoneById(lost_mobilephone);
	xsjsglxt_case case1=lostMobilephoneDao.getCaseByxsjsglxt_lost_mobilephone_id(lost_mobilephone);
	xsjsglxt_snece snece=lostMobilephoneDao.getSenceByxsjsglxt_case_id(case1);
	LostMobilephoneInformationDTO lostMobilephoneInformationDTO=new LostMobilephoneInformationDTO(case1,snece,lost_mobilephone);
	
	return lostMobilephoneInformationDTO;
	
}

@Override
public void updateParallel(xsjsglxt_lost_mobilephone lost_mobilephone) {
	// TODO Auto-generated method stub
	lost_mobilephone.setLost_mobilephone_gmt_modified(TeamUtil.getStringSecond());
	lostMobilephoneDao.updateParallel(lost_mobilephone);
}

}
