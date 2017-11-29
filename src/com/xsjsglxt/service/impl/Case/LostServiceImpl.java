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
 * (non-Javadoc)保存损失物品
 * @see com.xsjsglxt.service.Case.LostService#saveLost(com.xsjsglxt.domain.DO.xsjsglxt_lost)
 */
@Override
public void saveLost(xsjsglxt_lost lost) {
	// TODO Auto-generated method stub
	lost.setXsjsglxt_lost_id(TeamUtil.getUuid());
	lost.setLost_gmt_create(TeamUtil.getStringSecond());
	lost.setLost_gmt_modified(lost.getLost_gmt_create());
	lostDao.save(lost);
}
/*
 * (non-Javadoc)列表信息
 * @see com.xsjsglxt.service.Case.LostService#VO_Lostformation_By_PageAndSearch(com.xsjsglxt.domain.VO.Case.page_list_CasematerialVO)
 */
@Override
public page_list_CasematerialVO VO_Lostformation_By_PageAndSearch(page_list_CasematerialVO page_list_Casematerial) {
	// TODO Auto-generated method stub
	List<LostInformationDTO> LostInformationDTOList = new ArrayList<LostInformationDTO>();
	List<xsjsglxt_lost> lostList= new ArrayList<xsjsglxt_lost>();
	LostInformationDTO lostInformationDTO;
	   
	xsjsglxt_case case1;
	xsjsglxt_snece snece;
	// 获取筛选后所有的记录
	int i = lostDao.getCountLostInformationByPage(page_list_Casematerial);
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
	// 根据筛选条件获取list数据
	lostList = lostDao.getListLostInformatioByPage(page_list_Casematerial);
	for (xsjsglxt_lost lost : lostList) {
		if (page_list_Casematerial.getLost_name() != null
				&& page_list_Casematerial.getLost_name().trim().length() > 0) {
			lost.setLost_name(lost.getLost_name().replaceAll(lost.getLost_name(),
					"<span style='color: #ff5063;'>" + lost.getLost_name().trim() + "</span>"));
		}
		case1=lostDao.getCaseByxsjsglxt_lost_id(lost);
		snece=lostDao.getSenceByxsjsglxt_case_id(case1);
		lostInformationDTO = new LostInformationDTO(case1,snece,lost);
		LostInformationDTOList.add(lostInformationDTO);
	}
	page_list_Casematerial.setLostInformationDTOList(LostInformationDTOList);
	return page_list_Casematerial;
}

}
