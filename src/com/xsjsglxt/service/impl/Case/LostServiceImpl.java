package com.xsjsglxt.service.impl.Case;

import java.util.ArrayList;
import java.util.List;

import com.xsjsglxt.dao.Case.LostDao;
import com.xsjsglxt.domain.DO.xsjsglxt_case;
import com.xsjsglxt.domain.DO.xsjsglxt_lost;
import com.xsjsglxt.domain.DO.xsjsglxt_snece;
import com.xsjsglxt.domain.DTO.Case.LostInformationDTO;
import com.xsjsglxt.domain.VO.Case.page_list_CasematerialVO;
import com.xsjsglxt.service.Case.LostService;

import util.TeamUtil;

public class LostServiceImpl implements LostService {
	private LostDao lostDao;

	public LostDao getLostDao() {
		return lostDao;
	}

	public void setLostDao(LostDao lostDao) {
		this.lostDao = lostDao;
	}

	/*
	 * 保存损失物信息
	 */
	@Override
	public void saveLost(xsjsglxt_lost lost) {
		// TODO Auto-generated method stub

		lost.setLost_gmt_create(TeamUtil.getStringSecond());
		lost.setLost_gmt_modified(lost.getLost_gmt_create());
		lostDao.save(lost);
	}

	/*
	 * 
	 * 损失物列表信息
	 */
	@Override
	public page_list_CasematerialVO VO_Lostformation_By_PageAndSearch(page_list_CasematerialVO page_list_Casematerial) {
		// TODO Auto-generated method stub
		List<LostInformationDTO> LostInformationDTOList = new ArrayList<LostInformationDTO>();
		List<xsjsglxt_lost> lostList = new ArrayList<xsjsglxt_lost>();
		LostInformationDTO lostInformationDTO;

		xsjsglxt_case case1;
		xsjsglxt_snece snece;
		// 符合筛选条件的记录数
		int i = lostDao.getCountLostInformationByPage(page_list_Casematerial);
		System.out.println(i);
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
		lostList = lostDao.getListLostInformatioByPage(page_list_Casematerial);
		for (xsjsglxt_lost lost : lostList) {
			if (page_list_Casematerial.getLost_name() != null
					&& page_list_Casematerial.getLost_name().trim().length() > 0) {
				lost.setLost_name(lost.getLost_name().replaceAll(lost.getLost_name(),
						"<span style='color: #ff5063;'>" + lost.getLost_name().trim() + "</span>"));
			}
			case1 = lostDao.getCaseByxsjsglxt_lost_id(lost);
			snece = lostDao.getSenceByxsjsglxt_case_id(case1);
			lostInformationDTO = new LostInformationDTO(case1, snece, lost);
			LostInformationDTOList.add(lostInformationDTO);
		}
		page_list_Casematerial.setLostInformationDTOList(LostInformationDTOList);
		return page_list_Casematerial;
	}

	@Override
	public LostInformationDTO LostInformationOne(xsjsglxt_lost lost) {
		// TODO Auto-generated method stub
		lost = lostDao.getLostById(lost);
		xsjsglxt_case case1 = lostDao.getCaseByxsjsglxt_lost_id(lost);
		xsjsglxt_snece snece = lostDao.getSenceByxsjsglxt_case_id(case1);
		LostInformationDTO lostInformationDTO = new LostInformationDTO(case1, snece, lost);
		return lostInformationDTO;
	}

	@Override
	public void updateLost(xsjsglxt_lost lost) {
		// TODO Auto-generated method stub
		lost.setLost_gmt_modified(TeamUtil.getStringSecond());
		lostDao.updateLost(lost);

	}

	@Override
	public boolean remove_LostInformationList(List<String> useLostInformationNumList) {
		// TODO Auto-generated method stub
		boolean flag = false;
		for (String lost_id : useLostInformationNumList) {
			xsjsglxt_lost xsjsglxt_lost = lostDao.getLostByNum(lost_id);
			flag = lostDao.deleteLostById(xsjsglxt_lost.getXsjsglxt_lost_id());// ����

		}
		return flag;
	}

}
