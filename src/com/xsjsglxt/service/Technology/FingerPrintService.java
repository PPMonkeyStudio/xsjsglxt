package com.xsjsglxt.service.Technology;

import java.util.List;

import com.xsjsglxt.domain.DO.xsjsglxt_fingerprint;
import com.xsjsglxt.domain.VO.Technology.FingerPrintVO;

public interface FingerPrintService {

	int deleteFingerPrint(String xsjsglxt_fingerprint_id);

	int deleteListFingerPrint(List<String> listDeleteFingerPrintID);

	FingerPrintVO list_xsjsglxt_fingerprint(FingerPrintVO fingerprintVO);

	int saveFingerPrint(xsjsglxt_fingerprint fingerprint);

	int modifiedFingerPrint(xsjsglxt_fingerprint fingerprint);

	xsjsglxt_fingerprint get_fingerprint(String xsjsglxt_fingerprint_id);

}
