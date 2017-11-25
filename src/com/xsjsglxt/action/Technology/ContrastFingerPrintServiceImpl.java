package com.xsjsglxt.action.Technology;

import java.util.List;

import com.xsjsglxt.dao.Technology.ContrastFingerPrintDao;
import com.xsjsglxt.domain.DO.xsjsglxt_contrast_fingerprint;
import com.xsjsglxt.domain.DO.xsjsglxt_dna;
import com.xsjsglxt.service.Technology.ContrastFingerPrintService;

import util.TeamUtil;

public class ContrastFingerPrintServiceImpl implements ContrastFingerPrintService {
	
	private ContrastFingerPrintDao contrastFingerPrintDao;

	@Override
	public int saveDNA(xsjsglxt_contrast_fingerprint contrastFingerPrint) {
		contrastFingerPrint.setContrast_fingerprint_id(TeamUtil.getUuid());
		contrastFingerPrint.setContrast_fingerprint_gmt_modified(TeamUtil.getStringSecond());
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
		int result = contrastFingerPrintDao.modifiedDNA(contrastFingerPrint);
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

}
