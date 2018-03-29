package com.xsjsglxt.service.impl.Case;

import java.util.ArrayList;
import java.util.List;

import com.xsjsglxt.dao.Case.BreakCaseDao;
import com.xsjsglxt.domain.DO.xsjsglxt_breakcase;
import com.xsjsglxt.domain.DO.xsjsglxt_briefdetails;
import com.xsjsglxt.domain.DO.xsjsglxt_case;
import com.xsjsglxt.domain.DO.xsjsglxt_snece;
import com.xsjsglxt.domain.DTO.Case.BreakecaseInformationDTO;
import com.xsjsglxt.domain.VO.Case.page_list_BreakecaseInformationVO;
import com.xsjsglxt.service.Case.BreakCaseService;

import util.TeamUtil;

public class BreakCaseServiceImpl implements BreakCaseService {

	@Override
	public void saveBreakCaseInfo(xsjsglxt_breakcase breakCase, xsjsglxt_briefdetails briefDetails) {
		//存入简要案情表
		String briefdetails_id = TeamUtil.getUuid();
		details.setXsjsglxt_briefdetails_id(briefdetails_id);
		details.setBriefdetails_case(breakCase.getBreakcase_case());//所属案件id
		details.setBriefdetails_details(briefDetails.getBriefdetails_details());//简要案情内容
		details.setBriefdetails_gmt_create(TeamUtil.getStringSecond());
		details.setBriefdetails_details_modified(TeamUtil.getStringSecond());
		breakCaseDao.saveBriefDetails(details);
		//存入破案表
		breakCase.setXsjsglxt_breakcase_id(TeamUtil.getUuid());
		breakCase.setBreakcase_case_note(briefdetails_id);//简要案情表id
		breakCase.setBreakcase_gmt_create(TeamUtil.getStringSecond());
		breakCase.setBreakcase_gmt_modified(TeamUtil.getStringSecond());
		breakCaseDao.saveBreakecase(breakCase);
	}
	
	public xsjsglxt_briefdetails getDetails() {
		return details;
	}

	public void setDetails(xsjsglxt_briefdetails details) {
		this.details = details;
	}

	private BreakCaseDao breakCaseDao;
	xsjsglxt_briefdetails details;

	@Override
	public boolean removeBreakCaseInfo(List<String> breakCaseInIdList) {
		for (String breakcase_id : breakCaseInIdList) {
			xsjsglxt_breakcase bc = breakCaseDao.getBreakCaseById(breakcase_id);
			breakCaseDao.deleteBriefDetailsById(bc.getBreakcase_case_note());
			breakCaseDao.deleteBreakCaseById(breakcase_id);
		}
		return true;
	}

	public BreakCaseDao getBreakCaseDao() {
		return breakCaseDao;
	}

	public void setBreakCaseDao(BreakCaseDao breakCaseDao) {
		this.breakCaseDao = breakCaseDao;
	}

	@Override
	public void updateBreakCase(xsjsglxt_breakcase breakCase, xsjsglxt_briefdetails briefDetails) {
		String case_note_id = breakCase.getBreakcase_case_note();//简要案情表id
		xsjsglxt_briefdetails old_details = breakCaseDao.getBriedDetailsById(case_note_id);
		briefDetails.setBriefdetails_gmt_create(old_details.getBriefdetails_gmt_create());
		briefDetails.setBriefdetails_case(breakCase.getBreakcase_case());
		briefDetails.setBriefdetails_details_modified(TeamUtil.getStringSecond());
		breakCaseDao.updateBriefDetails(briefDetails);

		String breakcase_id = breakCase.getXsjsglxt_breakcase_id();
		xsjsglxt_breakcase old_breakCase = breakCaseDao.getBreakCaseById(breakcase_id);
		breakCase.setBreakcase_gmt_create(old_breakCase.getBreakcase_gmt_create());
		breakCaseDao.updateBreakCase(breakCase);
	}

	public page_list_BreakecaseInformationVO VO_BreakecaseInformation_By_PageAndSearch(page_list_BreakecaseInformationVO page_list_BreakecaseInformation) {
		xsjsglxt_snece sence;//现场勘验表
		xsjsglxt_case case1;//案件表
		List<BreakecaseInformationDTO> BreakecaseInformationDTOList = new ArrayList<BreakecaseInformationDTO>();
		List<xsjsglxt_breakcase> listBreakcase = new ArrayList<xsjsglxt_breakcase>();
		BreakecaseInformationDTO breakecaseInformationDTO;
		int i = breakCaseDao.getCountBreakecaseInformationByPage(page_list_BreakecaseInformation);
		//符合条件总记录数
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
		listBreakcase = breakCaseDao.getListBreakecaseInformatioByPage(page_list_BreakecaseInformation);
		for (xsjsglxt_breakcase breakecase : listBreakcase) {
			case1=breakCaseDao.get_case_ByBreakecaseId(breakecase);
			sence = breakCaseDao.get_sence_Byxsjsglxt_case_id(case1);// 6
			sence.setSnece_inquestId(sence.getSnece_inquestId().substring(10));
			breakecaseInformationDTO = new BreakecaseInformationDTO(breakecase,sence,case1);
			BreakecaseInformationDTOList.add(breakecaseInformationDTO);
		}
		page_list_BreakecaseInformation.setBreakecaseInformationDTOList(BreakecaseInformationDTOList);
		return page_list_BreakecaseInformation;
	}

	@Override
	public xsjsglxt_breakcase getBreakCaseInfo(xsjsglxt_breakcase breakCase) {
		return breakCaseDao.getBreakCaseById(breakCase.getXsjsglxt_breakcase_id());
	}

}
