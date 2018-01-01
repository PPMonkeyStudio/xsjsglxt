package com.xsjsglxt.service.Technology;

import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.xsjsglxt.domain.DO.xsjsglxt_contrast_fingerprint;
import com.xsjsglxt.domain.VO.Technology.ContrastFingerPrintVO;

public interface ContrastFingerPrintService {

	int deleteContrast(String contrast_fingerprint_id);

	int deleteListContrast(List<String> listDeleteContrastID);

	int modifiedContrast(xsjsglxt_contrast_fingerprint contrastFingerPrint);

	xsjsglxt_contrast_fingerprint get_contrast(String contrast_fingerprint_id);

	int saveContrast(xsjsglxt_contrast_fingerprint contrastFingerPrint);

	ContrastFingerPrintVO list_xsjsglxt_contrast(ContrastFingerPrintVO contrastFingerPrintVO);
/*
 * 导出
 */
	XSSFWorkbook getExcel(String query_name, String tableName, String query_id);

public	boolean addinfo(List<Object> list);

}
