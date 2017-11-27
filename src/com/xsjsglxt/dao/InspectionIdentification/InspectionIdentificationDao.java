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
}
