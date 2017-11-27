package com.xsjsglxt.service.InspectionIdentification;

import java.util.List;

import com.xsjsglxt.domain.DO.xsjsglxt_check_entrustment_book;
import com.xsjsglxt.domain.DO.xsjsglxt_identifieder_case_confirm_book;
import com.xsjsglxt.domain.DO.xsjsglxt_not_acceptance_entrustment_inform;
import com.xsjsglxt.domain.VO.InspectionIdentification.EntrustmentBookManagementVO;

public interface InspectionIdentificationService {

	public int saveTranceCheckBook(xsjsglxt_check_entrustment_book tranceCheckBook);

	public EntrustmentBookManagementVO getListCheckEntrustmentBook(EntrustmentBookManagementVO checkEntrustmentBookVO);

	public int deleteListCheckEntrustmentBook(List<String> listCheckEntrustmentBookId);

	public int saveIdentifiederCaseConfirmBook(xsjsglxt_identifieder_case_confirm_book identifiederCaseConfirmBook);

	public int saveNotAcceptanceInform(xsjsglxt_not_acceptance_entrustment_inform notAcceptanceEntrustmentInform);

}
