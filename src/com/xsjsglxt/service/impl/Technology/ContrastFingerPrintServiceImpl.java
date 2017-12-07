package com.xsjsglxt.service.impl.Technology;

import java.util.List;

import com.xsjsglxt.dao.Technology.ContrastFingerPrintDao;
import com.xsjsglxt.domain.DO.xsjsglxt_contrast_fingerprint;
import com.xsjsglxt.domain.DO.xsjsglxt_dna;
import com.xsjsglxt.domain.VO.Technology.ContrastFingerPrintVO;
import com.xsjsglxt.domain.VO.Technology.DNAVO;
import com.xsjsglxt.service.Technology.ContrastFingerPrintService;

import util.TeamUtil;

public class ContrastFingerPrintServiceImpl implements ContrastFingerPrintService {
	
	public ContrastFingerPrintDao getContrastFingerPrintDao() {
		return contrastFingerPrintDao;
	}

	public void setContrastFingerPrintDao(ContrastFingerPrintDao contrastFingerPrintDao) {
		this.contrastFingerPrintDao = contrastFingerPrintDao;
	}

	private ContrastFingerPrintDao contrastFingerPrintDao;

	@Override
	public int saveContrast(xsjsglxt_contrast_fingerprint contrastFingerPrint) {
		contrastFingerPrint.setContrast_fingerprint_id(TeamUtil.getUuid());
//		contrastFingerPrint.setContrast_fingerprint_time(TeamUtil.getStringSecond());
//		contrastFingerPrint.setContrast_fingerprint_gmt_modified(TeamUtil.getStringSecond());
		contrastFingerPrint.setContrast_fingerprint_gmt_create(TeamUtil.getStringSecond());
		int result = contrastFingerPrintDao.saveContrast(contrastFingerPrint);
		if (result > 0) {
			return 1;
		}
		return 2;
	}

	@Override
	public int deleteContrast(String contrast_fingerprint_id) {
		int result = contrastFingerPrintDao.deleteContrast(contrast_fingerprint_id);
		if (result > 0) {
			return 1;
		}
		return 2;
	}

	@Override
	public int deleteListContrast(List<String> listDeleteContrastID) {
		int result = 0;
		for (String id : listDeleteContrastID) {
			result += contrastFingerPrintDao.deleteContrast(id);
		}
		if (result == listDeleteContrastID.size()) {
			return 1;
		}
		return 2;
	}

	@Override
	public int modifiedContrast(xsjsglxt_contrast_fingerprint contrastFingerPrint) {
		contrastFingerPrint.setContrast_fingerprint_gmt_modified(TeamUtil.getStringSecond());
		int result = contrastFingerPrintDao.modifiedContrast(contrastFingerPrint);
		if (result > 0) {
			return 1;
		}
		return 2;
	}

	@Override
	public xsjsglxt_contrast_fingerprint get_contrast(String contrast_fingerprint_id) {
		xsjsglxt_contrast_fingerprint contrast = contrastFingerPrintDao.get_contrast(contrast_fingerprint_id);
		return contrast;
	}

	@Override
	public ContrastFingerPrintVO list_xsjsglxt_contrast(ContrastFingerPrintVO contrastFingerPrintVO) {
		int totalRecords = contrastFingerPrintDao.count_contrast_all(contrastFingerPrintVO);
		ContrastFingerPrintVO vo = new ContrastFingerPrintVO();
		vo.setPageIndex(contrastFingerPrintVO.getPageIndex());
		vo.setPageSize(contrastFingerPrintVO.getPageSize());
		vo.setTotalRecords(totalRecords);
		vo.setTotalPages(((totalRecords - 1) / vo.getPageSize()) + 1);
		if (vo.getPageIndex() <= 1) {
			vo.setHavePrePage(false);
		} else {
			vo.setHavePrePage(true);
		}
		if (vo.getPageIndex() >= vo.getTotalPages()) {
			vo.setHaveNextPage(false);
		} else {
			vo.setHaveNextPage(true);
		}
		List<xsjsglxt_contrast_fingerprint> list = contrastFingerPrintDao.list_xsjsglxt_contrast(contrastFingerPrintVO);
		/*高亮现场指纹编号、按印指纹编号*/
		for (xsjsglxt_contrast_fingerprint cotrast : list) {
			if (contrastFingerPrintVO.getSearch() != null && contrastFingerPrintVO.getSearch().trim().length() > 0) {
				cotrast.setContrast_fingerprint_locale_fingerprint_number(cotrast.getContrast_fingerprint_locale_fingerprint_number().replaceAll(contrastFingerPrintVO.getSearch(),
						"<span style='color: #ff5063;'>" + contrastFingerPrintVO.getSearch() + "</span>"));
				cotrast.setContrast_fingerprint_press_fingerprint_number(cotrast.getContrast_fingerprint_press_fingerprint_number().replaceAll(contrastFingerPrintVO.getSearch(),
						"<span style='color: #ff5063;'>" + contrastFingerPrintVO.getSearch() + "</span>"));
			}
		}
		vo.setList_xsjsglxt_contrast_fingerprint(list);
		return vo;
	}

}
