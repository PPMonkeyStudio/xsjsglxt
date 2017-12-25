package com.xsjsglxt.dao.Technology;

import java.util.List;

import com.xsjsglxt.domain.DO.xsjsglxt_fingerprint;
import com.xsjsglxt.domain.VO.Technology.FingerPrintVO;

public interface FingerPrintDao {

	int saveFingerPrint(xsjsglxt_fingerprint fingerprint);

	int deleteFingerPrint(String xsjsglxt_fingerprint_id);

	xsjsglxt_fingerprint get_fingerprint(String xsjsglxt_fingerprint_id);

	int modifiedFingerPrint(xsjsglxt_fingerprint fingerprint);

	List<xsjsglxt_fingerprint> list_xsjsglxt_finger(FingerPrintVO fingerprintVO);

	int count_fingerprint_all(FingerPrintVO fingerprintVO);

	int getFeild();

}
