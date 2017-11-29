package com.xsjsglxt.service.impl.Technology;

import java.util.Calendar;
import java.util.List;

import com.xsjsglxt.dao.Technology.FingerPrintDao;
import com.xsjsglxt.domain.DO.xsjsglxt_dna;
import com.xsjsglxt.domain.DO.xsjsglxt_fingerprint;
import com.xsjsglxt.domain.VO.Technology.FingerPrintVO;
import com.xsjsglxt.service.Technology.FingerPrintService;

import util.TeamUtil;

public class FingerPrintServiceImpl implements FingerPrintService {
	
	private FingerPrintDao fingerPrintDao;

	public FingerPrintDao getFingerPrintDao() {
		return fingerPrintDao;
	}

	public void setFingerPrintDao(FingerPrintDao fingerPrintDao) {
		this.fingerPrintDao = fingerPrintDao;
	}

	@Override
	public int deleteFingerPrint(String xsjsglxt_fingerprint_id) {
		int result = fingerPrintDao.deleteFingerPrint(xsjsglxt_fingerprint_id);
		return result;
	}

	@Override
	public int deleteListFingerPrint(List<String> listDeleteFingerPrintID) {
		int result = 0;
		for (String xsjsglxt_fingerprint_id : listDeleteFingerPrintID) {
			result += fingerPrintDao.deleteFingerPrint(xsjsglxt_fingerprint_id);
		}
		if (result == listDeleteFingerPrintID.size()) {
			return 1;
		}
		return 2;
	}

	@Override
public FingerPrintVO list_xsjsglxt_fingerprint(FingerPrintVO fingerprintVO) {
		int totalRecords = fingerPrintDao.count_fingerprint_all();
		FingerPrintVO vo = new FingerPrintVO();
		vo.setPageIndex(fingerprintVO.getPageIndex());
		vo.setPageSize(fingerprintVO.getPageSize());
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
		List<xsjsglxt_fingerprint> list = fingerPrintDao.list_xsjsglxt_finger(fingerprintVO);
		for (xsjsglxt_fingerprint finger : list) {
			if (fingerprintVO.getSearch() != null && fingerprintVO.getSearch().trim().length() > 0) {
				finger.setFingerprint_num(finger.getFingerprint_num().replaceAll(fingerprintVO.getSearch(),
						"<span style='color: #ff5063;'>" + fingerprintVO.getSearch() + "</span>"));
				finger.setFingerprint_name(finger.getFingerprint_name().replaceAll(fingerprintVO.getSearch(),
						"<span style='color: #ff5063;'>" + fingerprintVO.getSearch() + "</span>"));
			}
		}
		vo.setList_xsjsglxt_fingerprint(list);
		return vo;
	}

	@Override
	public int saveFingerPrint(xsjsglxt_fingerprint fingerprint) {
		fingerprint.setXsjsglxt_fingerprint_id(TeamUtil.getUuid());
		fingerprint.setFingerprint_num(this.create_fingerprint_num());
		fingerprint.setFingerprint_gmt_create(TeamUtil.getStringSecond());
		fingerprint.setFingerprint_gmt_modified(TeamUtil.getStringSecond());
		int result = fingerPrintDao.saveFingerPrint(fingerprint);
		if (result > 0) {
			return 1;
		}
		return 2;
	}

	/**
	 * @author gxr
	 * 生成指纹编号
	 * */
	private String create_fingerprint_num() {
		String fingerprint_num = "Z360302001";
		String year_month = String.valueOf(Calendar.getInstance().get(Calendar.YEAR)) + String.valueOf(Calendar.getInstance().get(Calendar.MONTH));
		fingerprint_num += year_month;
		fingerprint_num += String.valueOf(fingerPrintDao.count_fingerprint_all()+1);
		return fingerprint_num;
	}

	@Override
	public int modifiedFingerPrint(xsjsglxt_fingerprint fingerprint) {
		fingerprint.setFingerprint_gmt_modified(TeamUtil.getStringSecond());
		int result = fingerPrintDao.modifiedFingerPrint(fingerprint);
		if (result > 0) {
			return 1;
		}
		return 2;
	}

	@Override
	public xsjsglxt_fingerprint get_fingerprint(String xsjsglxt_fingerprint_id) {
		xsjsglxt_fingerprint finger = fingerPrintDao.get_fingerprint(xsjsglxt_fingerprint_id);
		return finger;
	}

}
