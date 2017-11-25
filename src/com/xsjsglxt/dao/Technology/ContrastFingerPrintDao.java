package com.xsjsglxt.dao.Technology;

import com.xsjsglxt.domain.DO.xsjsglxt_contrast_fingerprint;

public interface ContrastFingerPrintDao {

	int saveContrast(xsjsglxt_contrast_fingerprint contrastFingerPrint);

	int deleteContrast(String contrast_fingerprint_id);

	int modifiedDNA(xsjsglxt_contrast_fingerprint contrastFingerPrint);

	xsjsglxt_contrast_fingerprint get_contrast(String contrast_fingerprint_id);

}
