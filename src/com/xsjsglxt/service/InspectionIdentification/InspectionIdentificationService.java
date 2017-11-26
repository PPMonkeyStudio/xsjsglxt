package com.xsjsglxt.service.InspectionIdentification;

import java.util.List;

import com.xsjsglxt.domain.DO.xsjsglxt_check_entrustment_book;
import com.xsjsglxt.domain.VO.InspectionIdentification.CheckEntrustmentBookVO;

public interface InspectionIdentificationService {

	public int saveTranceCheckBook(xsjsglxt_check_entrustment_book tranceCheckBook);

	public CheckEntrustmentBookVO getListCheckEntrustmentBook(CheckEntrustmentBookVO checkEntrustmentBookVO);
	
	public int deleteListCheckEntrustmentBook(List<String> listCheckEntrustmentBookId);

}
