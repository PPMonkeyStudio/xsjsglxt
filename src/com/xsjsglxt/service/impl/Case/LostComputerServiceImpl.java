package com.xsjsglxt.service.impl.Case;

import java.util.ArrayList;
import java.util.List;

import com.xsjsglxt.dao.Case.LostComputerDao;
import com.xsjsglxt.domain.DO.xsjsglxt_case;
import com.xsjsglxt.domain.DO.xsjsglxt_lost_computer;
import com.xsjsglxt.domain.DO.xsjsglxt_snece;
import com.xsjsglxt.domain.DTO.Case.LostComputerInformationDTO;
import com.xsjsglxt.domain.VO.Case.page_list_CasematerialVO;
import com.xsjsglxt.service.Case.LostComputerService;

import util.TeamUtil;

public class LostComputerServiceImpl implements LostComputerService {
	private LostComputerDao lostComputerDao;

	public LostComputerDao getLostComputerDao() {
		return lostComputerDao;
	}

	public void setLostComputerDao(LostComputerDao lostComputerDao) {
		this.lostComputerDao = lostComputerDao;
	}

	@Override
	public void saveLostComputer(xsjsglxt_lost_computer lost_computer) {
		// TODO Auto-generated method stub
		lost_computer.setLost_computer_gmt_create(TeamUtil.getStringSecond());
		lost_computer.setLost_computer_gmt_modified(lost_computer.getLost_computer_gmt_create());
		lostComputerDao.saveLostComputer(lost_computer);
	}

	@Override
	public page_list_CasematerialVO VO_LostComputerformation_By_PageAndSearch(
			page_list_CasematerialVO page_list_Casematerial) {
		// TODO Auto-generated method stub
		List<LostComputerInformationDTO> LostComputerInformationDTOList = new ArrayList<LostComputerInformationDTO>();
		List<xsjsglxt_lost_computer> lost_computerList = new ArrayList<xsjsglxt_lost_computer>();
		LostComputerInformationDTO lostComputerInformationDTO;

		xsjsglxt_case case1;
		xsjsglxt_snece snece;
		// 符合筛选条件的记录数
		int i = lostComputerDao.getCountLostComputerInformationByPage(page_list_Casematerial);
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
		lost_computerList = lostComputerDao.getListLostComputerInformatioByPage(page_list_Casematerial);
		for (xsjsglxt_lost_computer lost_computer : lost_computerList) {
			// 1
			if (page_list_Casematerial.getLost_computer_brand() != null
					&& page_list_Casematerial.getLost_computer_brand().trim().length() > 0) {
				lost_computer.setLost_computer_brand(lost_computer.getLost_computer_brand().replaceAll(
						lost_computer.getLost_computer_brand(),
						"<span style='color: #ff5063;'>" + lost_computer.getLost_computer_brand().trim() + "</span>"));
			}
			// 2
			if (page_list_Casematerial.getLost_computer_internetAccount() != null
					&& page_list_Casematerial.getLost_computer_internetAccount().trim().length() > 0) {
				lost_computer.setLost_computer_internetAccount(lost_computer.getLost_computer_internetAccount()
						.replaceAll(lost_computer.getLost_computer_internetAccount(), "<span style='color: #ff5063;'>"
								+ lost_computer.getLost_computer_internetAccount().trim() + "</span>"));
			}
			// 3
			if (page_list_Casematerial.getLost_computer_MAC() != null
					&& page_list_Casematerial.getLost_computer_MAC().trim().length() > 0) {
				lost_computer.setLost_computer_MAC(
						lost_computer.getLost_computer_MAC().replaceAll(lost_computer.getLost_computer_MAC(),
								"<span style='color: #ff5063;'>" + lost_computer.getLost_computer_MAC() + "</span>"));
			}
			case1 = lostComputerDao.getCaseByxsjsglxt_lost_computer_id(lost_computer);
			snece = lostComputerDao.getSenceByxsjsglxt_case_id(case1);
			lostComputerInformationDTO = new LostComputerInformationDTO(case1, snece, lost_computer);
			LostComputerInformationDTOList.add(lostComputerInformationDTO);
		}
		page_list_Casematerial.setLostComputerInformationDTOList(LostComputerInformationDTOList);
		return page_list_Casematerial;
	}

	@Override
	public LostComputerInformationDTO LostComputerInformationOne(xsjsglxt_lost_computer lost_computer) {
		// TODO Auto-generated method stub
		lost_computer = lostComputerDao.getLostComputerById(lost_computer);
		xsjsglxt_case case1 = lostComputerDao.getCaseByxsjsglxt_lost_computer_id(lost_computer);
		xsjsglxt_snece snece = lostComputerDao.getSenceByxsjsglxt_case_id(case1);
		LostComputerInformationDTO lostComputerInformationDTO = new LostComputerInformationDTO(case1, snece,
				lost_computer);
		return lostComputerInformationDTO;
	}

	@Override
	public void updateLostComputer(xsjsglxt_lost_computer lost_computer) {
		// TODO Auto-generated method stub
		lost_computer.setLost_computer_gmt_modified(TeamUtil.getStringSecond());
		lostComputerDao.updateLostComputer(lost_computer);
	}

	@Override
	public boolean remove_Lost_computerInformationList(List<String> useLost_computerInformationNumList) {
		// TODO Auto-generated method stub
		boolean flag = false;
		for (String lost_computer_id : useLost_computerInformationNumList) {
			xsjsglxt_lost_computer xsjsglxt_lost_computer = lostComputerDao.getLostByNum(lost_computer_id);
			flag = lostComputerDao.deleteLost_computerById(xsjsglxt_lost_computer.getXsjsglxt_lost_computer_id());// ����

		}
		return flag;
	}

}
