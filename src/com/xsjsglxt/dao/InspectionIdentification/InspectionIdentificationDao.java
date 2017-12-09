package com.xsjsglxt.dao.InspectionIdentification;

import java.util.List;

import com.xsjsglxt.domain.DO.xsjsglxt_appraisal_letter;
import com.xsjsglxt.domain.DO.xsjsglxt_check_entrustment_book;
import com.xsjsglxt.domain.DO.xsjsglxt_inspection_record;
import com.xsjsglxt.domain.DO.xsjsglxt_not_acceptance_entrustment_inform;
import com.xsjsglxt.domain.VO.InspectionIdentification.EntrustmentBookManagementVO;

public interface InspectionIdentificationDao {

	public int saveObject(Object object);

	public int getMaxCheckNum(String check_entrustment_book_year, String type);

	public int getCountByPageAndSearch(EntrustmentBookManagementVO checkEntrustmentBookVO);

	public List<xsjsglxt_check_entrustment_book> getListCheckEntrustmentBookByPage(
			EntrustmentBookManagementVO checkEntrustmentBookVO);

	public int deleteCheckEntrustmentBookById(String checkEntrustmentBookId);

	public xsjsglxt_check_entrustment_book getCheckEntrustmentBookById(
			String identifieder_case_confirm_book_belong_entrustment_book);

	public com.xsjsglxt.domain.DO.xsjsglxt_identifieder_case_confirm_book getIdentifiederCaseConfirmBookById(
			String xsjsglxt_check_entrustment_book_id);

	public xsjsglxt_not_acceptance_entrustment_inform getNotAcceptanceEntrustmentInform(
			String xsjsglxt_check_entrustment_book_id);

	public xsjsglxt_inspection_record getInspectionRecordById(String xsjsglxt_check_entrustment_book_id);

	public xsjsglxt_appraisal_letter getAppraisalLetterById(String xsjsglxt_check_entrustment_book_id);

	public com.xsjsglxt.domain.DO.xsjsglxt_identifieder_case_confirm_book getIdentifiederCaseConfirmBookByOwnId(String xsjsglxt_identifieder_case_confirm_book_id);

	public com.xsjsglxt.domain.DO.xsjsglxt_not_acceptance_entrustment_inform getNotAcceptanceEntrustmentInformByOwnId(String xsjsglxt_not_acceptance_entrustment_inform_id);

	public com.xsjsglxt.domain.DO.xsjsglxt_inspection_record getInspectionRecordByOwnId(String xsjsglxt_inspection_record_id);

	public com.xsjsglxt.domain.DO.xsjsglxt_appraisal_letter getAppraisalLetterByOwnId(String xsjsglxt_appraisal_letter_id);

	public int deleteIdentifiederCaseConfirmBookId(String xsjsglxt_identifieder_case_confirm_book_id);

	public int deleteNotAcceptanceEntrusmentInformById(String xsjsglxt_not_acceptance_entrustment_inform_id);

	public int deleteInsoectionRecordById(String xsjsglxt_inspection_record_id);

	public int deleteAppraisalLetter(String xsjsglxt_appraisal_letter_id);

	public int getMaxCofirmBook(String currentYear);

}
