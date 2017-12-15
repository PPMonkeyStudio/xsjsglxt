package com.xsjsglxt.service.impl.Case;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
	private SenceDao senceDao;
    
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
	public boolean save(xsjsglxt_case case1) {
		// TODO Auto-generated method stub
		case1.setXsjsglxt_case_id(TeamUtil.getUuid());
		//System.out.println("UUID"+case1.getXsjsglxt_case_id());
		case1.setCase_gmt_create(TeamUtil.getStringSecond());
		case1.setCase_gmt_modified(case1.getCase_gmt_create());
		senceDao.save(case1);
		return true;
	}

	@Override
	public void save(xsjsglxt_briefdetails briefdetails) {
		// TODO Auto-generated method stub
		briefdetails.setXsjsglxt_briefdetails_id(TeamUtil.getUuid());
		briefdetails.setBriefdetails_gmt_create(TeamUtil.getStringSecond());
		briefdetails.setBriefdetails_details_modified(briefdetails.getBriefdetails_gmt_create());
		senceDao.save(briefdetails);
	}


	/*
	 * (non-Javadoc)��ÿ�̽���
	 * 
	 * @see
	 * com.xsjsglxt.service.Case.SenceService#getSenceInformationInquestId()
	 */
	

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
		// ��ȡɸѡ�����еļ�¼
		int i = senceDao.getCountSenceInformationByPage(page_list_senceInformation);
	//	System.out.println(i);
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

		// ����ɸѡ������ȡlist����
		listCase = senceDao.getListSenceInformatioByPage(page_list_senceInformation);
		System.out.println("listcase"+listCase);
		for (xsjsglxt_case case1 : listCase) {
			// 1
			if (page_list_senceInformation.getCase_totalCategory() != null
					&& page_list_senceInformation.getCase_totalCategory().trim().length() > 0) {
				case1.setCase_totalCategory(case1.getCase_totalCategory().replaceAll(case1.getCase_totalCategory(),
						"<span style='color: #ff5063;'>" + case1.getCase_totalCategory().trim() + "</span>"));
			}
			// 2
			if (page_list_senceInformation.getCase_sonCategory() != null
					&& page_list_senceInformation.getCase_sonCategory().trim().length() > 0) {
				case1.setCase_sonCategory(case1.getCase_sonCategory().replaceAll(case1.getCase_sonCategory(),
						"<span style='color: #ff5063;'>" + case1.getCase_sonCategory().trim() + "</span>"));
			}
			// 3
			if (page_list_senceInformation.getCase_classify() != null
					&& page_list_senceInformation.getCase_classify().trim().length() > 0) {
				case1.setCase_classify(case1.getCase_classify().replaceAll(case1.getCase_classify(),
						"<span style='color:#ff5063;'>" + case1.getCase_classify().trim() + "</span>"));
			}
			// 4
			if (page_list_senceInformation.getCase_residence() != null
					&& page_list_senceInformation.getCase_residence().trim().length() > 0) {
				case1.setCase_sonCategory(case1.getCase_residence().replaceAll(case1.getCase_residence(),
						"<span style='color:#ff5063;'>" + case1.getCase_residence().trim() + "</span>"));
			}
			// 5
			if (page_list_senceInformation.getCase_concreteResidence() != null
					&& page_list_senceInformation.getCase_concreteResidence().trim().length() > 0) {
				case1.setCase_sonCategory(case1.getCase_concreteResidence().replaceAll(case1.getCase_concreteResidence(),
						"<span style='color: #ff5063;'>" + case1.getCase_concreteResidence().trim() + "</span>"));
			}
			// 6
//			if (page_list_senceInformation.getSnece_inquestPerson() != null
//					&& page_list_senceInformation.getSnece_inquestPerson().trim().length() > 0) {
//
//			}
			// 7
			if (page_list_senceInformation.getCase_makeTime() != null
					&& page_list_senceInformation.getCase_makeTime().trim().length() > 0) {
				case1.setCase_sonCategory(case1.getCase_makeTime().replaceAll(case1.getCase_makeTime(),
						"<span style='color:#ff5063;'>" + case1.getCase_makeTime().trim() + "</span>"));
			}
			// 8
			if (page_list_senceInformation.getCase_makeMeans() != null
					&& page_list_senceInformation.getCase_makeMeans().trim().length() > 0) {
				case1.setCase_sonCategory(case1.getCase_makeMeans().replaceAll(case1.getCase_makeMeans(),
						"<span style='color:#ff5063;'>" + case1.getCase_makeMeans().trim() + "</span>"));
			}
			// 9
			if (page_list_senceInformation.getCase_concreteMakeMeans() != null
					&& page_list_senceInformation.getCase_concreteMakeMeans().trim().length() > 0) {
				case1.setCase_sonCategory(case1.getCase_concreteMakeMeans().replaceAll(case1.getCase_concreteMakeMeans(),
						"<span style='color: #ff5063;'>" + case1.getCase_concreteMakeMeans().trim() + "</span>"));
			}
 
			briefdetails = senceDao.get_briefdetails_Byxsjsglxt_case_id(case1);// 1
			

			lost_computer = senceDao.get_lost_computer_Byxsjsglxt_case_id(case1);// 2

			lost_mobilephone = senceDao.get_lost_mobilephone_Byxsjsglxt_case_id(case1);// 3

			lost = senceDao.get_lost_Byxsjsglxt_case_id(case1);// 4

			picture = senceDao.get_picture_Byxsjsglxt_case_id(case1);// 5
			sence = senceDao.get_sence_Byxsjsglxt_case_id(case1);// 6
			sence.setSnece_inquestId(sence.getSnece_inquestId().substring(10));
			System.out.println("getSnece_inquestId:"+sence.getSnece_inquestId());
			resevidence = senceDao.get_resevidence_Byxsjsglxt_case_id(case1);
			senceInformationDTO = new SenceInformationDTO(briefdetails, case1, lost_computer, lost_mobilephone, lost,
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
			flag = senceDao.deleteCaseById(xsjsglxt_case.getXsjsglxt_case_id());// ����
			flag = senceDao.deleteBriefdetailsById(xsjsglxt_case.getXsjsglxt_case_id());// ��Ҫ����
			flag = senceDao.deleteLost_computerById(xsjsglxt_case.getXsjsglxt_case_id());// ��ʧ����
			flag = senceDao.deleteLost_mobilephoneById(xsjsglxt_case.getXsjsglxt_case_id());// ��ʧ�ֻ�
			flag = senceDao.deleteLostById(xsjsglxt_case.getXsjsglxt_case_id());// ��ʧ��Ʒ
			flag = senceDao.deletePictureById(xsjsglxt_case.getXsjsglxt_case_id());// ��Ƭ
			flag = senceDao.deleteSenceById(xsjsglxt_case.getXsjsglxt_case_id());// ��̽�ֳ�
			xsjsglxt_resevidence resevidence = senceDao.getResevidenceById(xsjsglxt_case.getXsjsglxt_case_id());
			flag=senceDao.deleteCirculationById(resevidence.getXsjsglxt_resevidence_id());
			flag=senceDao.deleteResevidenceById(xsjsglxt_case.getXsjsglxt_case_id());
			flag=senceDao.deleteBreakecaseById(xsjsglxt_case.getXsjsglxt_case_id());
		}
		return flag;
	}

	@Override
	public String getMaxSenceInquestId() {
		// TODO Auto-generated method stub
		int i = senceDao.getMaxSenceInquestId();
		System.out.println("���ֵ"+i);
		//System.out.println("iiiiii"+i);
		String num = "";
		num = num.format("%04d", i+1);
		System.out.println("mummunmumn"+num);
		Date date = new Date();
		DateFormat format = new SimpleDateFormat("yyyyMM");
		String time = format.format(date);
		String SenceInformationInquestId ="K360302001" + time + num ;
		//System.out.println("SenceInformationInquestIdSenceInformationInquestIdSenceInformationInquestId"+SenceInformationInquestId);
		return SenceInformationInquestId;
	}

	@Override
	public SenceInformationDTO SecneInformationOne(xsjsglxt_case case1) {
		// TODO Auto-generated method stub
		xsjsglxt_snece	sence=senceDao.getSeceByCaseId(case1);
		 case1 =  senceDao.getCaseByCaseId(case1);
		xsjsglxt_briefdetails briefdetails=senceDao.getBriefdetailsByCaseID(case1);
		xsjsglxt_lost lost = senceDao.getLostByCaseID(case1);
		xsjsglxt_lost_mobilephone lost_mobilephone =senceDao.getLost_mobilephoneByCaseId(case1);
		xsjsglxt_lost_computer lost_computer=senceDao.getLost_computerByCaseId(case1);
		xsjsglxt_resevidence resevidence =senceDao.getResevidenceByCaseId(case1);
		xsjsglxt_picture picture=senceDao.getPicturtByCaseId(case1);
		SenceInformationDTO senceInformationDTO =new SenceInformationDTO(briefdetails, case1, lost_computer, lost_mobilephone, lost,
				picture, sence, resevidence);
		return senceInformationDTO;
	}

	@Override
	public void updateSence(xsjsglxt_snece sence, String case1) {
		// TODO Auto-generated method stub
		
		xsjsglxt_snece	oldsence=senceDao.getSenceById(case1);
	
		sence.setXsjsglxt_snece_id(oldsence.getXsjsglxt_snece_id());
		sence.setSnece_case(oldsence.getSnece_case());
		sence.setSnece_gmt_create(oldsence.getSnece_gmt_create());
		sence.setSnece_gmt_modified(TeamUtil.getStringSecond());
		senceDao.updateSence(sence);
	}

	@Override
	public void updateCase(xsjsglxt_case case1) {
		// TODO Auto-generated method stub
		case1.setCase_gmt_modified(TeamUtil.getStringSecond());
		senceDao.updateCase(case1);
	}

	@Override
	public void updateBriefdetails(xsjsglxt_briefdetails briefdetails,String case1) {
		// TODO Auto-generated method stub
		xsjsglxt_briefdetails	oldbriefdetails=senceDao.getBriefdetailsById(case1);
		briefdetails.setXsjsglxt_briefdetails_id(oldbriefdetails.getXsjsglxt_briefdetails_id());
		briefdetails.setBriefdetails_case(oldbriefdetails.getBriefdetails_case());
		briefdetails.setBriefdetails_gmt_create(oldbriefdetails.getBriefdetails_gmt_create());
		briefdetails.setBriefdetails_details_modified(TeamUtil.getStringSecond());
    	senceDao.updateBriefdetails(briefdetails);
	}

	@Override
	public List<xsjsglxt_case> AllCase() {
		// TODO Auto-generated method stub
		return senceDao.AllCase() ;
	}


}
