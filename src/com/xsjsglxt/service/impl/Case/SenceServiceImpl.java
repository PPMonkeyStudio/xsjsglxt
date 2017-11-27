package com.xsjsglxt.service.impl.Case;

import java.util.ArrayList;
import java.util.List;

import com.xsjsglxt.dao.Case.SenceDao;
import com.xsjsglxt.domain.DO.xsjsglxt_briefdetails;
import com.xsjsglxt.domain.DO.xsjsglxt_case;
import com.xsjsglxt.domain.DO.xsjsglxt_lost;
import com.xsjsglxt.domain.DO.xsjsglxt_lost_computer;
import com.xsjsglxt.domain.DO.xsjsglxt_lost_mobilephone;
import com.xsjsglxt.domain.DO.xsjsglxt_picture;
import com.xsjsglxt.domain.DO.xsjsglxt_resevidence;
import com.xsjsglxt.domain.DO.xsjsglxt_snece;
import com.xsjsglxt.domain.DTO.Case.SenceInformationDTO;
import com.xsjsglxt.domain.VO.Case.page_list_senceInformationVO;
import com.xsjsglxt.service.Case.SenceService;

import util.TeamUtil;

public class SenceServiceImpl implements SenceService {
private SenceDao  senceDao;

public SenceDao getSenceDao() {
	return senceDao;
}

public void setSenceDao(SenceDao senceDao) {
	this.senceDao = senceDao;
}

@Override
public void save(xsjsglxt_snece sence) {
	// TODO Auto-generated method stub
	sence.setXsjsglxt_snece_id(TeamUtil.getUuid());
	sence.setSnece_gmt_create(TeamUtil.getStringSecond());
	sence.setSnece_gmt_modified(sence.getSnece_gmt_create());
	senceDao.save(sence);
}

@Override
public void save(xsjsglxt_case case1) {
	// TODO Auto-generated method stub
	case1.setXsjsglxt_case_id(TeamUtil.getUuid());
	case1.setCase_gmt_create(TeamUtil.getStringSecond());
	case1.setCase_gmt_modified(case1.getCase_gmt_create());
	senceDao.save(case1);
}

@Override
public void save(xsjsglxt_briefdetails briefdetails) {
	// TODO Auto-generated method stub
	briefdetails.setXsjsglxt_briefdetails_id(TeamUtil.getUuid());
	briefdetails.setBriefdetails_gmt_create(TeamUtil.getStringSecond());
	briefdetails.setBriefdetails_details_modified(briefdetails.getBriefdetails_gmt_create());
	senceDao.save(briefdetails);
}

@Override
public void save(xsjsglxt_lost lost) {
	// TODO Auto-generated method stub
	lost.setXsjsglxt_lost_id(TeamUtil.getUuid());
	lost.setLost_gmt_create(TeamUtil.getStringSecond());
	lost.setLost_gmt_modified(lost.getLost_gmt_create());
	senceDao.save(lost);
}

@Override
public void save(xsjsglxt_lost_mobilephone lost_mobilephone) {
	// TODO Auto-generated method stub
	lost_mobilephone.setXsjsglxt_lost_mobilephone_id(TeamUtil.getUuid());
	lost_mobilephone.setLost_mobilephone_gmt_create(TeamUtil.getStringSecond());
	lost_mobilephone.setLost_mobilephone_gmt_modified(lost_mobilephone.getLost_mobilephone_gmt_create());
	senceDao.save(lost_mobilephone);
}

@Override
public void save(xsjsglxt_lost_computer lost_computer) {
	// TODO Auto-generated method stub
	lost_computer.setXsjsglxt_lost_computer_id(TeamUtil.getUuid());
	lost_computer.setLost_computer_gmt_create(TeamUtil.getStringSecond());
	lost_computer.setLost_computer_gmt_modified(lost_computer.getLost_computer_gmt_create());
	senceDao.save(lost_computer);
}
/*
 * (non-Javadoc)获得勘探编号
 * @see com.xsjsglxt.service.Case.SenceService#getSenceInformationInquestId()
 */
@Override
public String getSenceInformationInquestId() {
	// TODO Auto-generated method stub
       String senceInformationId = senceDao.getSenceInformationInquestId();
	return senceInformationId;
}

@Override
public page_list_senceInformationVO VO_SneceInformation_By_PageAndSearch(
		page_list_senceInformationVO page_list_senceInformation) {
	// TODO Auto-generated method stub
	List<SenceInformationDTO> SenceInformationDTOList = new ArrayList<SenceInformationDTO>();
	List<xsjsglxt_case> listCase = new ArrayList<xsjsglxt_case>();
	SenceInformationDTO senceInformationDTO;
	
	xsjsglxt_briefdetails briefdetails;//
	
	xsjsglxt_lost_computer lost_computer;//
	
	xsjsglxt_lost_mobilephone lost_mobilephone;//
	
	 xsjsglxt_lost lost;//
	 
     xsjsglxt_picture picture;//
     
     xsjsglxt_snece sence;//
     
     xsjsglxt_resevidence resevidence;//
	// 获取筛选后所有的记录
	int i = senceDao.getCountSenceInformationByPage(page_list_senceInformation);
	System.out.println(i);
	page_list_senceInformation.setTotalRecords(i);
	page_list_senceInformation.setTotalPages(((i - 1) / page_list_senceInformation.getPageSize()) + 1);
	if (page_list_senceInformation.getPageIndex() <= 1) {
		page_list_senceInformation.setHavePrePage(false);
	} else {
		page_list_senceInformation.setHavePrePage(true);
	}
	if (page_list_senceInformation.getPageIndex() >= page_list_senceInformation.getTotalPages()) {
		page_list_senceInformation.setHaveNextPage(false);
	} else {
		page_list_senceInformation.setHaveNextPage(true);
	}
	
	// 根据筛选条件获取list数据
	listCase = senceDao.getListSenceInformatioByPage(page_list_senceInformation);
	for (xsjsglxt_case Case : listCase) {
     // 1
	if (page_list_senceInformation.getCase_totalCategory() != null&& page_list_senceInformation.getCase_totalCategory().trim().length() > 0) {
						Case.setCase_totalCategory(Case.getCase_totalCategory().replaceAll(Case.getCase_totalCategory(),"<span style='color: #ff5063;'>" + Case.getCase_totalCategory().trim()+ "</span>" ));
	}
	// 2
	if (page_list_senceInformation.getCase_sonCategory() != null&& page_list_senceInformation.getCase_sonCategory().trim().length() > 0) {
						Case.setCase_sonCategory(Case.getCase_sonCategory().replaceAll(Case.getCase_sonCategory(),"<span style='color: #ff5063;'>" + Case.getCase_sonCategory().trim()+ "</span>" ));
	}
	// 3
	if (page_list_senceInformation.getCase_classify() != null&&page_list_senceInformation.getCase_classify().trim().length() > 0) {
						Case.setCase_classify(Case.getCase_classify().replaceAll(Case.getCase_classify(),"<span style='color:#ff5063;'>" + Case.getCase_classify().trim()+ "</span>" ));
	}
	// 4
	if (page_list_senceInformation.getCase_residence() != null&&page_list_senceInformation.getCase_residence().trim().length() > 0) {
						Case.setCase_sonCategory(Case.getCase_residence().replaceAll(Case.getCase_residence(),"<span style='color:#ff5063;'>" + Case.getCase_residence().trim()+ "</span>" ));
	}
	// 5
	if(page_list_senceInformation.getCase_concreteResidence() != null&&page_list_senceInformation.getCase_concreteResidence().trim().length() > 0) {
						Case.setCase_sonCategory(Case.getCase_concreteResidence().replaceAll(Case.getCase_concreteResidence(),"<span style='color: #ff5063;'>" + Case.getCase_concreteResidence().trim()+ "</span>" ));
	}
	// 6
    if (page_list_senceInformation.getSnece_inquestPerson() != null&&page_list_senceInformation.getSnece_inquestPerson().trim().length() > 0) {
						
	}
	// 7
    if (page_list_senceInformation.getCase_makeTime() != null&&page_list_senceInformation.getCase_makeTime().trim().length() > 0) {
						Case.setCase_sonCategory(Case.getCase_makeTime().replaceAll(Case.getCase_makeTime(),"<span style='color:#ff5063;'>" + Case.getCase_makeTime().trim()+ "</span>" ));
	}
	// 8
   if (page_list_senceInformation.getCase_makeMeans() != null&&page_list_senceInformation.getCase_makeMeans().trim().length() > 0) {
						Case.setCase_sonCategory(Case.getCase_makeMeans().replaceAll(Case.getCase_makeMeans(),"<span style='color:#ff5063;'>" + Case.getCase_makeMeans().trim()+ "</span>" ));
	}
	// 9
	if (page_list_senceInformation.getCase_concreteMakeMeans() != null&&page_list_senceInformation.getCase_concreteMakeMeans().trim().length() > 0) {
						Case.setCase_sonCategory(Case.getCase_concreteMakeMeans().replaceAll(Case.getCase_concreteMakeMeans(),"<span style='color: #ff5063;'>" + Case.getCase_concreteMakeMeans().trim()+ "</span>" ));
    }
		
			briefdetails = senceDao.get_briefdetails_Byxsjsglxt_case_id(Case);// 1

			lost_computer = senceDao.get_lost_computer_Byxsjsglxt_case_id(Case);// 2

			lost_mobilephone = senceDao.get_lost_mobilephone_Byxsjsglxt_case_id(Case);// 3

			lost = senceDao.get_lost_Byxsjsglxt_case_id(Case);// 4

			picture = senceDao.get_picture_Byxsjsglxt_case_id(Case);// 5

			sence = senceDao.get_sence_Byxsjsglxt_case_id(Case);// 6

			resevidence = senceDao.get_resevidence_Byxsjsglxt_case_id(Case);

			senceInformationDTO = new SenceInformationDTO(briefdetails, Case, lost_computer, lost_mobilephone, lost,
					picture, sence, resevidence);

			SenceInformationDTOList.add(senceInformationDTO);
		}
		page_list_senceInformation.setSenceInformationDTOList(SenceInformationDTOList);
		return page_list_senceInformation;

}

@Override
public boolean remove_SenceInformationList(List<String> useSenceInformationNumList) {
	// TODO Auto-generated method stub
	boolean flag = false;
	for (String Case_id : useSenceInformationNumList) {
		xsjsglxt_case xsjsglxt_case = senceDao.getCaseByNum(Case_id);
		flag = senceDao.deleteCaseById(xsjsglxt_case.getXsjsglxt_case_id());//案件
		flag = senceDao.deleteBriefdetailsById(xsjsglxt_case.getXsjsglxt_case_id());//简要详情
		flag = senceDao.deleteLost_computerById(xsjsglxt_case.getXsjsglxt_case_id());//损失电脑
		flag = senceDao.deleteLost_mobilephoneById(xsjsglxt_case.getXsjsglxt_case_id());//损失手机
		flag = senceDao.deleteLostById(xsjsglxt_case.getXsjsglxt_case_id());//损失物品
		flag = senceDao.deletePictureById(xsjsglxt_case.getXsjsglxt_case_id());//照片
		flag = senceDao.deleteSenceById(xsjsglxt_case.getXsjsglxt_case_id());//勘探现场
	}
return flag;
}





}
