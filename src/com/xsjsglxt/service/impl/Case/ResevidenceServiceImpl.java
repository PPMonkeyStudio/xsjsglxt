package com.xsjsglxt.service.impl.Case;

import java.util.ArrayList;
import java.util.List;

import com.xsjsglxt.dao.Case.ResevidenceDao;
import com.xsjsglxt.domain.DO.xsjsglxt_case;
import com.xsjsglxt.domain.DO.xsjsglxt_circulation;
import com.xsjsglxt.domain.DO.xsjsglxt_lost_computer;
import com.xsjsglxt.domain.DO.xsjsglxt_resevidence;
import com.xsjsglxt.domain.DO.xsjsglxt_snece;
import com.xsjsglxt.domain.DTO.Case.LostComputerInformationDTO;
import com.xsjsglxt.domain.DTO.Case.ResevidenceInformationDTO;
import com.xsjsglxt.domain.VO.Case.page_list_ResevidenceInformationVO;
import com.xsjsglxt.service.Case.ResevidenceService;

import util.TeamUtil;

public class ResevidenceServiceImpl implements ResevidenceService {
private ResevidenceDao resevidenceDao;

public ResevidenceDao getResevidenceDao() {
	return resevidenceDao;
}

public void setResevidenceDao(ResevidenceDao resevidenceDao) {
	this.resevidenceDao = resevidenceDao;
}
/*
 *保存物证基本信息 
 */
@Override
public void saveResevidence(xsjsglxt_resevidence resevidence) {
	// TODO Auto-generated method stub
	resevidence.setXsjsglxt_resevidence_id(TeamUtil.getUuid());
	resevidence.setResevidence_gmt_create(TeamUtil.getStringSecond());
	resevidence.setResevidence_gmt_modified(resevidence.getResevidence_gmt_create());
	resevidenceDao.save(resevidence);
}
/*
 *物证的列表信息 
 */
@Override
public page_list_ResevidenceInformationVO VO_Resevidenceformation_By_PageAndSearch(
		page_list_ResevidenceInformationVO page_list_ResevidenceInformation) {
	// TODO Auto-generated method stub
	List<ResevidenceInformationDTO> ResevidenceInformationDTOList = new ArrayList<ResevidenceInformationDTO>();
	List<xsjsglxt_resevidence> resevidenceList= new ArrayList<xsjsglxt_resevidence>();
	ResevidenceInformationDTO resevidenceInformationDTO;
	   
	xsjsglxt_case case1;
	xsjsglxt_snece snece;
	xsjsglxt_circulation circulation;
	// 符合筛选条件的物证记录数
	int i = resevidenceDao.getCountResevidenceInformationByPage(page_list_ResevidenceInformation);
	page_list_ResevidenceInformation.setTotalRecords(i);
	page_list_ResevidenceInformation.setTotalPages(((i - 1) / page_list_ResevidenceInformation.getPageSize()) + 1);
	if (page_list_ResevidenceInformation.getPageIndex() <= 1) {
		page_list_ResevidenceInformation.setHavePrePage(false);
	} else {
		page_list_ResevidenceInformation.setHavePrePage(true);
	}
	if (page_list_ResevidenceInformation.getPageIndex() >= page_list_ResevidenceInformation.getTotalPages()) {
		page_list_ResevidenceInformation.setHaveNextPage(false);
	} else {
		page_list_ResevidenceInformation.setHaveNextPage(true);
	}
	// 符合筛选条件的物证的记录
	resevidenceList = resevidenceDao.getListResevidenceInformatioByPage(page_list_ResevidenceInformation);
	for (xsjsglxt_resevidence resevidence : resevidenceList) {
		//1
				if (page_list_ResevidenceInformation.getResevidence_extractPerson() != null
						&& page_list_ResevidenceInformation.getResevidence_extractPerson().trim().length() > 0) {
					resevidence.setResevidence_extractPerson(resevidence.getResevidence_extractPerson().replaceAll(resevidence.getResevidence_extractPerson(),
							"<span style='color: #ff5063;'>" + resevidence.getResevidence_extractPerson().trim() + "</span>"));
				}
				
		case1=resevidenceDao.getCaseByxsjsglxt_resevidence_id(resevidence);
		snece=resevidenceDao.getSenceByxsjsglxt_case_id(case1);
		circulation=resevidenceDao.getCirculationByxsjsglxt_resevidence_id(resevidence);
		resevidenceInformationDTO = new ResevidenceInformationDTO(resevidence,case1,snece,circulation);
		ResevidenceInformationDTOList.add(resevidenceInformationDTO);
	}
	page_list_ResevidenceInformation.setResevidenceInformationDTOList(ResevidenceInformationDTOList);
	return page_list_ResevidenceInformation;
}

@Override
public ResevidenceInformationDTO ResevidenceInformationOne(xsjsglxt_resevidence resevidence) {
	// TODO Auto-generated method stub
	resevidence=resevidenceDao.getResevidenceById(resevidence);
	xsjsglxt_case case1=resevidenceDao.getcaseByresevidenceId(resevidence);
	xsjsglxt_snece sence=resevidenceDao.getsenceBycase1Id(case1);
	xsjsglxt_circulation circulation=resevidenceDao.getcirculationByresevidenceId(resevidence);
	ResevidenceInformationDTO resevidenceInformationDTO=new ResevidenceInformationDTO(resevidence,case1,sence,circulation);
	return resevidenceInformationDTO;
}
/*
 *保存物证流转信息 
 */
@Override
public void saveCirculation(xsjsglxt_circulation circulation) {
	// TODO Auto-generated method stub
	circulation.setXsjsglxt_circulation_id(TeamUtil.getUuid());
	circulation.setCirculation_gmt_create(TeamUtil.getStringSecond());
	circulation.setCirculation_gmt_modified(circulation.getCirculation_gmt_create());
	resevidenceDao.saveCirculation(circulation);
}
/*
 * 删除物证信息
 */

@Override
public boolean removeResevidenceInformationList(List<String> useResevidenceInformationNumList) {
	// TODO Auto-generated method stub
	boolean flag = false;
	for (String Resevidence_id : useResevidenceInformationNumList) {
		xsjsglxt_resevidence resevidence = resevidenceDao.getByResevidenceNum(Resevidence_id);
		flag = resevidenceDao.deleteResevidenceById(resevidence.getXsjsglxt_resevidence_id());// ��֤
		flag = resevidenceDao.deleteCirculationById(resevidence.getXsjsglxt_resevidence_id());// ��֤��ת��Ϣ
		
	}
	return flag;
}
/*
 * 修改物证信息
 */
@Override
public void updateResevidenceIn(xsjsglxt_resevidence resevidence) {
	// TODO Auto-generated method stub
	resevidence.setResevidence_gmt_modified(TeamUtil.getStringSecond());
	resevidenceDao.updateResevidenceIn(resevidence);
}




}
