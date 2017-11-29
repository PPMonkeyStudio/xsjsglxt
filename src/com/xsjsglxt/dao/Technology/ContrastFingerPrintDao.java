package com.xsjsglxt.dao.Technology;

import java.util.List;

import com.xsjsglxt.domain.DO.xsjsglxt_contrast_fingerprint;
import com.xsjsglxt.domain.VO.Technology.ContrastFingerPrintVO;

public interface ContrastFingerPrintDao {

	int saveContrast(xsjsglxt_contrast_fingerprint contrastFingerPrint);

	int deleteContrast(String contrast_fingerprint_id);

	int modifiedDNA(xsjsglxt_contrast_fingerprint contrastFingerPrint);

	xsjsglxt_contrast_fingerprint get_contrast(String contrast_fingerprint_id);

	int count_contrast_all();

	List<xsjsglxt_contrast_fingerprint> list_xsjsglxt_contrast(ContrastFingerPrintVO contrastFingerPrintVO);

}
