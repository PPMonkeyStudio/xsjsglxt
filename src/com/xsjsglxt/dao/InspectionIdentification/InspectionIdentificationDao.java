package com.xsjsglxt.dao.InspectionIdentification;

import java.util.List;

import com.xsjsglxt.domain.DO.xsjsglxt_appraisal_letter;
import com.xsjsglxt.domain.DO.xsjsglxt_check_entrustment_book;
import com.xsjsglxt.domain.DO.xsjsglxt_damage_inspection_record;
import com.xsjsglxt.domain.DO.xsjsglxt_death_inspection_record;
import com.xsjsglxt.domain.DO.xsjsglxt_entrustment_sample;
import com.xsjsglxt.domain.DO.xsjsglxt_inspection_record;
import com.xsjsglxt.domain.DO.xsjsglxt_not_acceptance_entrustment_inform;
import com.xsjsglxt.domain.VO.InspectionIdentification.EntrustmentBookManagementVO;

public interface InspectionIdentificationDao {

	public List<?> listObject(String hql);

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

	public com.xsjsglxt.domain.DO.xsjsglxt_identifieder_case_confirm_book getIdentifiederCaseConfirmBookByOwnId(
			String xsjsglxt_identifieder_case_confirm_book_id);

	public com.xsjsglxt.domain.DO.xsjsglxt_not_acceptance_entrustment_inform getNotAcceptanceEntrustmentInformByOwnId(
			String xsjsglxt_not_acceptance_entrustment_inform_id);

	public com.xsjsglxt.domain.DO.xsjsglxt_inspection_record getInspectionRecordByOwnId(
			String xsjsglxt_inspection_record_id);

	public com.xsjsglxt.domain.DO.xsjsglxt_appraisal_letter getAppraisalLetterByOwnId(
			String xsjsglxt_appraisal_letter_id);

	public int deleteIdentifiederCaseConfirmBookId(String xsjsglxt_identifieder_case_confirm_book_id);

	public int deleteNotAcceptanceEntrusmentInformById(String xsjsglxt_not_acceptance_entrustment_inform_id);

	public int deleteInsoectionRecordById(String xsjsglxt_inspection_record_id);

	public int deleteAppraisalLetter(String xsjsglxt_appraisal_letter_id);

	public int getMaxCofirmBook(String currentYear, String type);

	public xsjsglxt_death_inspection_record getDeathInspectionRecordById(String xsjsglxt_check_entrustment_book_id);

	public xsjsglxt_damage_inspection_record getDamageInspectionRecordById(String xsjsglxt_check_entrustment_book_id);

	public int deleteDeathInspectionRecordById(String xsjsglxt_death_inspection_record_id);

	public int deleteDamageInspectionRecordById(String xsjsglxt_damage_inspection_record_id);

	public com.xsjsglxt.domain.DO.xsjsglxt_death_inspection_record getDeathInspectionRecordOwnId(
			String xsjsglxt_death_inspection_record_id);

	public com.xsjsglxt.domain.DO.xsjsglxt_damage_inspection_record getDamageInspectionRecordByOwnId(
			String xsjsglxt_damage_inspection_record_id);

	public int getMaxLetterNum(String currentYear, String appraisal_letter_type);

	public int getMaxEntrustmentSample(String entrustment_sample_belong_entrustment_book);

	public List<xsjsglxt_entrustment_sample> getListEntrustmentSampleByEnId(String xsjsglxt_check_entrustment_book_id);

	public int deleteEntrustmentSampleByBookId(String checkEntrustmentBookId);

	public com.xsjsglxt.domain.DO.xsjsglxt_entrustment_sample getEentrustment_sample(String id);

	public int deleteCheckEntrustmentByOwnId(String xsjsglxt_entrustment_sample_id);

	public void saveInspectionRecords(xsjsglxt_inspection_record inspectionRecord);

}
