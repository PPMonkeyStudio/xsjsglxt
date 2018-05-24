package com.xsjsglxt.service.InspectionIdentification;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.xsjsglxt.domain.DO.xsjsglxt_appraisal_letter;
import com.xsjsglxt.domain.DO.xsjsglxt_check_entrustment_book;
import com.xsjsglxt.domain.DO.xsjsglxt_damage_inspection_record;
import com.xsjsglxt.domain.DO.xsjsglxt_death_inspection_record;
import com.xsjsglxt.domain.DO.xsjsglxt_entrustment_sample;
import com.xsjsglxt.domain.DO.xsjsglxt_identifieder_case_confirm_book;
import com.xsjsglxt.domain.DO.xsjsglxt_inspection_record;
import com.xsjsglxt.domain.DO.xsjsglxt_not_acceptance_entrustment_inform;
import com.xsjsglxt.domain.DTO.InspectionIdentification.CaseCheckDTO;
import com.xsjsglxt.domain.DTO.InspectionIdentification.CaseMandateDTO;
import com.xsjsglxt.domain.VO.InspectionIdentification.EntrustmentBookManagementVO;

public interface InspectionIdentificationService {

	public int saveTranceCheckBook(xsjsglxt_check_entrustment_book tranceCheckBook);

	public EntrustmentBookManagementVO getListCheckEntrustmentBook(EntrustmentBookManagementVO checkEntrustmentBookVO);

	public int deleteListCheckEntrustmentBook(List<String> listCheckEntrustmentBookId);

	public int saveIdentifiederCaseConfirmBook(xsjsglxt_identifieder_case_confirm_book identifiederCaseConfirmBook);

	public int saveNotAcceptanceInform(xsjsglxt_not_acceptance_entrustment_inform notAcceptanceEntrustmentInform);

	public int saveInspectionRecord(xsjsglxt_inspection_record inspectionRecord);

	public int saveDeathInspectionRecord(xsjsglxt_death_inspection_record deathInspectionRecord, File[] file,
			String[] fileName, String[] positionFile) throws IOException;

	public int saveDamageInspectionRecord(xsjsglxt_damage_inspection_record damageInspectionRecord, File[] file,
			String[] fileName, String[] positionFile) throws IOException;

	public int saveAppraisalLetter(xsjsglxt_appraisal_letter appraisalLetter);

	public int updateTranceCheckBook(xsjsglxt_check_entrustment_book tranceCheckBook);

	public int updateDamageInspectionRecord(xsjsglxt_damage_inspection_record damageInspectionRecord,
			File[] updateDamageFile, String[] updateDamageFileName, String[] positionFile) throws IOException;

	public int updateIdentifiederCaseConfirmBook(xsjsglxt_identifieder_case_confirm_book identifiederCaseConfirmBook);

	public int updateDeathInspectionRecord(xsjsglxt_death_inspection_record deathInspectionRecord,
			File[] updateDeathFile, String[] updateDeathFileName, String[] positionFile) throws IOException;

	public int updateNotAcceptanceInform(xsjsglxt_not_acceptance_entrustment_inform notAcceptanceEntrustmentInform);

	public int updateInspectionRecord(xsjsglxt_inspection_record inspectionRecord);

	public int updateAppraisalLetter(xsjsglxt_appraisal_letter appraisalLetter);

	public String exportIdentifiederCaseConfirmBookName(String id);

	public String exportTraceCheckBookName(String id);

	// 这个获取得到的是委托书的编号
	public String exportNotAccetpBookName(String id);

	//public File exportTranceCheckBook(String id) throws Exception;

	//public File exportIdentifiederCaseConfirmBook(String id) throws Exception;

	//public File exportAcceptanceReturnReceipt(String id) throws Exception;

	//public File exportNotAcceptanceIdentifieder(String id) throws Exception;

	//public File exportInspectionRecord(String id) throws Exception;

	//public File exportDeathInspectionRecord(String id) throws Exception;

	//public File exportDamageInspectionRecord(String id) throws Exception;

	//public File exportAppraisalLetter(String id) throws Exception;

	public String exportAppraisalLetterName(String xsjsglxt_appraisal_letter_id);

	public String exportInspectionRecordName(String xsjsglxt_inspection_record_id);

	public String exportDeathInspectionRecordName(String xsjsglxt_death_inspection_record_id);

	public String exportDamageInspectionRecordName(String xsjsglxt_damage_inspection_record_id);

	public int saveEntrustmentSample(xsjsglxt_entrustment_sample entrustment_sample);

	public int deleteEntrustmentSample(List<String> listEntrustmentSample);

	public List<CaseMandateDTO> getListEnstrustmentByCaseId(String checkCaseId);

	public List<xsjsglxt_check_entrustment_book> getListEnstrustmentByEvidenceId(String checkEvidenceId);

	public List<CaseCheckDTO> listInspectionRecordByCaseId(String inspectionCaseId);

	public List<xsjsglxt_inspection_record> listInspectionRecordByEvidenceId(String inspectionEvidenceId);

	public void saveInspectionRecords(xsjsglxt_inspection_record inspectionRecord);

	// 委托书
	public Map<String, Object> mapTranceCheckBook(String id);

	// 确认书
	public Map<String, Object> mapIdentifiederCaseConfirmBook(String id);

	// 受理回执
	public Map<String, Object> mapAcceptanceIdentifieder(String id);

	// 不受理回执
	public Map<String, Object> mapNotAcceptanceIdentifieder(String id);

	// 痕迹检验 记录
	public Map<String, Object> mapInspectionRecord(String id);

	// 死因检验记录
	public Map<String, Object> mapDeathInspectionRecord(String id);

	// 损伤检验记录
	public Map<String, Object> mapDamageInspectionRecord(String id);

	// 获取鉴定书类型
	public String getAppraisalLetterType(String id);

	// 损伤鉴定书
	public Map<String, Object> mapSunShangAppraisalLetter(String id);

	// 痕迹以及尸体鉴定书
	public Map<String, Object> mapHenShiAppraisalLetter(String id);

}
