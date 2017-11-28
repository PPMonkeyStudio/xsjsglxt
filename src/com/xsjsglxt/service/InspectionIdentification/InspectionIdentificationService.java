package com.xsjsglxt.service.InspectionIdentification;

import java.util.List;

import com.xsjsglxt.domain.DO.xsjsglxt_appraisal_letter;
import com.xsjsglxt.domain.DO.xsjsglxt_check_entrustment_book;
import com.xsjsglxt.domain.DO.xsjsglxt_identifieder_case_confirm_book;
import com.xsjsglxt.domain.DO.xsjsglxt_inspection_record;
import com.xsjsglxt.domain.DO.xsjsglxt_not_acceptance_entrustment_inform;
import com.xsjsglxt.domain.VO.InspectionIdentification.EntrustmentBookManagementVO;

public interface InspectionIdentificationService {

	public int saveTranceCheckBook(xsjsglxt_check_entrustment_book tranceCheckBook);

	public EntrustmentBookManagementVO getListCheckEntrustmentBook(EntrustmentBookManagementVO checkEntrustmentBookVO);

	public int deleteListCheckEntrustmentBook(List<String> listCheckEntrustmentBookId);

	public int saveIdentifiederCaseConfirmBook(xsjsglxt_identifieder_case_confirm_book identifiederCaseConfirmBook);

	public int saveNotAcceptanceInform(xsjsglxt_not_acceptance_entrustment_inform notAcceptanceEntrustmentInform);

	public int saveInspectionRecord(xsjsglxt_inspection_record inspectionRecord);

	public int saveAppraisalLetter(xsjsglxt_appraisal_letter appraisalLetter);

	public int updateTranceCheckBook(xsjsglxt_check_entrustment_book tranceCheckBook);

	public int updateIdentifiederCaseConfirmBook(xsjsglxt_identifieder_case_confirm_book identifiederCaseConfirmBook);

	public int updateNotAcceptanceInform(xsjsglxt_not_acceptance_entrustment_inform notAcceptanceEntrustmentInform);

	public int updateInspectionRecord(xsjsglxt_inspection_record inspectionRecord);
	
	public int updateAppraisalLetter(xsjsglxt_appraisal_letter appraisalLetter);
	
}
