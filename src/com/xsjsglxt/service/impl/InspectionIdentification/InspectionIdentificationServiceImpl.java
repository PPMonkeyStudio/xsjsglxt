package com.xsjsglxt.service.impl.InspectionIdentification;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xwpf.usermodel.XWPFDocument;

import com.xsjsglxt.dao.InspectionIdentification.InspectionIdentificationDao;
import com.xsjsglxt.domain.DO.xsjsglxt_appraisal_letter;
import com.xsjsglxt.domain.DO.xsjsglxt_check_entrustment_book;
import com.xsjsglxt.domain.DO.xsjsglxt_identifieder_case_confirm_book;
import com.xsjsglxt.domain.DO.xsjsglxt_inspection_record;
import com.xsjsglxt.domain.DO.xsjsglxt_not_acceptance_entrustment_inform;
import com.xsjsglxt.domain.DTO.InspectionIdentification.EntrustmentBookManagementDTO;
import com.xsjsglxt.domain.VO.InspectionIdentification.EntrustmentBookManagementVO;
import com.xsjsglxt.service.InspectionIdentification.InspectionIdentificationService;

import util.TeamUtil;
import util.XwpfTUtil;

public class InspectionIdentificationServiceImpl implements InspectionIdentificationService {
	private InspectionIdentificationDao inspectionIdentificationDao;

	public void setInspectionIdentificationDao(InspectionIdentificationDao inspectionIdentificationDao) {
		this.inspectionIdentificationDao = inspectionIdentificationDao;
	}

	// 保存痕迹检验委托书
	@Override
	public int saveTranceCheckBook(xsjsglxt_check_entrustment_book tranceCheckBook) {
		// 状态 已申请、已受理、已记录、鉴定完成
		tranceCheckBook.setCheck_entrustment_book_state("正在申请");
		tranceCheckBook.setXsjsglxt_check_entrustment_book_id(TeamUtil.getUuid());
		// 查找最大值,并且填写编号
		int i = inspectionIdentificationDao.getMaxCheckNum(TeamUtil.getCurrentYear(),
				tranceCheckBook.getCheck_entrustment_book_type()) + 1;
		tranceCheckBook.setCheck_entrustment_book_num(TeamUtil.getCurrentYear() + String.format("%04d", i));
		tranceCheckBook.setCheck_entrustment_book_gmt_create(TeamUtil.getStringSecond());
		tranceCheckBook.setCheck_entrustment_book_gmt_modified(tranceCheckBook.getCheck_entrustment_book_gmt_create());
		return inspectionIdentificationDao.saveObject(tranceCheckBook);
	}

	// 分页获取委托书
	@Override
	public EntrustmentBookManagementVO getListCheckEntrustmentBook(EntrustmentBookManagementVO checkEntrustmentBookVO) {
		EntrustmentBookManagementDTO entrustmentBookManagementDTO = new EntrustmentBookManagementDTO();
		List<EntrustmentBookManagementDTO> listEntrustmentBookManagementDTO = new ArrayList<EntrustmentBookManagementDTO>();
		xsjsglxt_appraisal_letter appraisalLetter = new xsjsglxt_appraisal_letter();
		xsjsglxt_identifieder_case_confirm_book identifiederCaseConfirmBook = new xsjsglxt_identifieder_case_confirm_book();
		xsjsglxt_inspection_record inspectionRecord = new xsjsglxt_inspection_record();
		xsjsglxt_not_acceptance_entrustment_inform notAcceptanceEntrustmentInform = new xsjsglxt_not_acceptance_entrustment_inform();
		List<xsjsglxt_check_entrustment_book> listCheckEntrustmentBook = new ArrayList<xsjsglxt_check_entrustment_book>();
		// 根据筛选获取总计路数
		int i = inspectionIdentificationDao.getCountByPageAndSearch(checkEntrustmentBookVO);
		checkEntrustmentBookVO.setTotalRecords(i);
		checkEntrustmentBookVO.setTotalPages(((i - 1) / checkEntrustmentBookVO.getPageSize()) + 1);
		if (checkEntrustmentBookVO.getPageIndex() <= 1) {
			checkEntrustmentBookVO.setHavePrePage(false);
		} else {
			checkEntrustmentBookVO.setHavePrePage(true);
		}
		if (checkEntrustmentBookVO.getPageIndex() >= checkEntrustmentBookVO.getTotalPages()) {
			checkEntrustmentBookVO.setHaveNextPage(false);
		} else {
			checkEntrustmentBookVO.setHaveNextPage(true);
		}
		// 获取分页所有
		listCheckEntrustmentBook = inspectionIdentificationDao
				.getListCheckEntrustmentBookByPage(checkEntrustmentBookVO);
		for (xsjsglxt_check_entrustment_book xsjsglxt_check_entrustment_book : listCheckEntrustmentBook) {
			appraisalLetter = new xsjsglxt_appraisal_letter();
			inspectionRecord = new xsjsglxt_inspection_record();
			entrustmentBookManagementDTO = new EntrustmentBookManagementDTO();
			identifiederCaseConfirmBook = new xsjsglxt_identifieder_case_confirm_book();
			notAcceptanceEntrustmentInform = new xsjsglxt_not_acceptance_entrustment_inform();
			entrustmentBookManagementDTO.setXsjsglxt_check_entrustment_book(xsjsglxt_check_entrustment_book);
			// 根据Id获取鉴定事项确认书表
			identifiederCaseConfirmBook = inspectionIdentificationDao.getIdentifiederCaseConfirmBookById(
					xsjsglxt_check_entrustment_book.getXsjsglxt_check_entrustment_book_id());
			if (identifiederCaseConfirmBook != null) {
				entrustmentBookManagementDTO.setXsjsglxt_identifieder_case_confirm_book(identifiederCaseConfirmBook);
			}
			// 根据Id获取不受理委托鉴定告知表
			notAcceptanceEntrustmentInform = inspectionIdentificationDao.getNotAcceptanceEntrustmentInform(
					xsjsglxt_check_entrustment_book.getXsjsglxt_check_entrustment_book_id());

			if (notAcceptanceEntrustmentInform != null) {
				entrustmentBookManagementDTO
						.setXsjsglxt_not_acceptance_entrustment_inform(notAcceptanceEntrustmentInform);
			}
			// 根据委托ID获取检验记录表
			inspectionRecord = inspectionIdentificationDao.getInspectionRecordById(xsjsglxt_check_entrustment_book.getXsjsglxt_check_entrustment_book_id());
			if (inspectionRecord != null) {
				entrustmentBookManagementDTO.setXsjsglxt_inspection_record(inspectionRecord);
			}
			listEntrustmentBookManagementDTO.add(entrustmentBookManagementDTO);
			// 根据委托Id获取鉴定文书
			appraisalLetter = inspectionIdentificationDao.getAppraisalLetterById(xsjsglxt_check_entrustment_book.getXsjsglxt_check_entrustment_book_id());
			if (appraisalLetter != null) {
				entrustmentBookManagementDTO.setXsjsglxt_appraisal_letter(appraisalLetter);
			}
		}
		checkEntrustmentBookVO.setListEntrustmentBookManagementDTO(listEntrustmentBookManagementDTO);
		return checkEntrustmentBookVO;
	}

	// 批量删除委托书ID
	@Override
	public int deleteListCheckEntrustmentBook(List<String> listCheckEntrustmentBookId) {
		int i = 0;
		xsjsglxt_not_acceptance_entrustment_inform xsjsglxt_not_acceptance_entrustment_inform = null;
		xsjsglxt_inspection_record xsjsglxt_inspection_record = null;
		xsjsglxt_appraisal_letter xsjsglxt_appraisal_letter = null;
		xsjsglxt_identifieder_case_confirm_book xsjsglxt_identifieder_case_confirm_book = null;
		for (String checkEntrustmentBookId : listCheckEntrustmentBookId) {
			xsjsglxt_identifieder_case_confirm_book = new xsjsglxt_identifieder_case_confirm_book();
			xsjsglxt_inspection_record = new xsjsglxt_inspection_record();
			xsjsglxt_appraisal_letter = new xsjsglxt_appraisal_letter();
			xsjsglxt_not_acceptance_entrustment_inform = new xsjsglxt_not_acceptance_entrustment_inform();
			// 根据ID删除确认书
			xsjsglxt_identifieder_case_confirm_book = inspectionIdentificationDao.getIdentifiederCaseConfirmBookById(checkEntrustmentBookId);
			if (xsjsglxt_identifieder_case_confirm_book != null) {
				i = inspectionIdentificationDao.deleteIdentifiederCaseConfirmBookId(xsjsglxt_identifieder_case_confirm_book.getXsjsglxt_identifieder_case_confirm_book_id());
				if (i == 2)
					return -1;
			}
			// 根据ID删除不受理书
			xsjsglxt_not_acceptance_entrustment_inform = inspectionIdentificationDao.getNotAcceptanceEntrustmentInform(checkEntrustmentBookId);
			if (xsjsglxt_not_acceptance_entrustment_inform != null) {
				i = inspectionIdentificationDao
						.deleteNotAcceptanceEntrusmentInformById(xsjsglxt_not_acceptance_entrustment_inform.getXsjsglxt_not_acceptance_entrustment_inform_id());
				if (i == 2)
					return -1;
			}
			// 根据ID删除记录表
			xsjsglxt_inspection_record = inspectionIdentificationDao.getInspectionRecordById(checkEntrustmentBookId);
			if (xsjsglxt_inspection_record != null) {
				i = inspectionIdentificationDao.deleteInsoectionRecordById(xsjsglxt_inspection_record.getXsjsglxt_inspection_record_id());
				if (i == 2)
					return -1;
			}
			// 删除鉴定文书
			xsjsglxt_appraisal_letter = inspectionIdentificationDao.getAppraisalLetterById(checkEntrustmentBookId);
			if (xsjsglxt_inspection_record != null) {
				i = inspectionIdentificationDao.deleteAppraisalLetter(xsjsglxt_appraisal_letter.getXsjsglxt_appraisal_letter_id());
				if (i == 2)
					return -1;
			}
			// 删除委托书
			i = inspectionIdentificationDao.deleteCheckEntrustmentBookById(checkEntrustmentBookId);
			if (i == 2) {
				return -1;
			}
		}
		return i;
	}

	// 填写鉴定事项确认书
	@Override
	public int saveIdentifiederCaseConfirmBook(xsjsglxt_identifieder_case_confirm_book identifiederCaseConfirmBook) {
		int i = 2;
		// 处于正在申请
		if (!("正在申请".equals(entrustmentBookState(identifiederCaseConfirmBook.getIdentifieder_case_confirm_book_belong_entrustment_book().trim())))) {
			return 3;
		}
		// 填写鉴定事项确认书
		identifiederCaseConfirmBook.setXsjsglxt_identifieder_case_confirm_book_id(TeamUtil.getUuid());
		identifiederCaseConfirmBook.setIdentifieder_case_confirm_book_acceptance_num("待定");
		identifiederCaseConfirmBook.setIdentifieder_case_confirm_book_gmt_create(TeamUtil.getStringSecond());
		identifiederCaseConfirmBook.setIdentifieder_case_confirm_book_gmt_modified(identifiederCaseConfirmBook.getIdentifieder_case_confirm_book_gmt_create());
		i = inspectionIdentificationDao.saveObject(identifiederCaseConfirmBook);
		if (i == 2)
			return i;
		// 更改委托书状态
		// 1.判断委托书Id是否为空
		if (identifiederCaseConfirmBook.getIdentifieder_case_confirm_book_belong_entrustment_book() != null
				&& identifiederCaseConfirmBook.getIdentifieder_case_confirm_book_belong_entrustment_book().trim()
						.length() > 0) {
			i = updateEntrustmentBookState(
					identifiederCaseConfirmBook.getIdentifieder_case_confirm_book_belong_entrustment_book().trim(),
					"申请已受理");
		}
		return i;
	}

	// 填写不受理书
	@Override
	public int saveNotAcceptanceInform(xsjsglxt_not_acceptance_entrustment_inform notAcceptanceEntrustmentInform) {
		int i = 2;
		// 处于正在申请
		if (!("正在申请".equals(entrustmentBookState(notAcceptanceEntrustmentInform.getNot_acceptance_entrustment_inform_belong_entrustment_book().trim())))) {
			return 3;
		}
		notAcceptanceEntrustmentInform.setXsjsglxt_not_acceptance_entrustment_inform_id(TeamUtil.getUuid());
		//notAcceptanceEntrustmentInform.setNot_acceptance_entrustment_inform_num("待定");
		notAcceptanceEntrustmentInform.setNot_acceptance_entrustment_inform_gmt_create(TeamUtil.getStringSecond());
		notAcceptanceEntrustmentInform.setNot_acceptance_entrustment_inform_gmt_modified(notAcceptanceEntrustmentInform.getNot_acceptance_entrustment_inform_gmt_create());
		i = inspectionIdentificationDao.saveObject(notAcceptanceEntrustmentInform);
		if (i == 2)
			return i;
		// 更改委托书状态
		// 1.判断委托书Id是否为空
		if (notAcceptanceEntrustmentInform.getNot_acceptance_entrustment_inform_belong_entrustment_book() != null
				&& notAcceptanceEntrustmentInform.getNot_acceptance_entrustment_inform_belong_entrustment_book().trim()
						.length() > 0) {
			i = updateEntrustmentBookState(notAcceptanceEntrustmentInform
					.getNot_acceptance_entrustment_inform_belong_entrustment_book().trim(), "申请被拒绝");
		}
		return i;
	}

	// 填写检验记录表
	/**
	 * 1 OK 2 失败 3 未达到执行条件
	 */
	@Override
	public int saveInspectionRecord(xsjsglxt_inspection_record inspectionRecord) {
		int i = 2;
		// 1.查询委托书表
		/**
		 * 这里是否需要我来进行判断
		 */
		if (!("申请已受理".equals(entrustmentBookState(inspectionRecord.getInspection_belong_entrustment_book().trim())))) {
			return 3;
		}
		/**
		 * 
		 */
		// 填写检验记录表
		inspectionRecord.setXsjsglxt_inspection_record_id(TeamUtil.getUuid());
		inspectionRecord.setInspection_gmt_create(TeamUtil.getStringSecond());
		inspectionRecord.setInspection_gmt_modified(inspectionRecord.getInspection_gmt_create());
		i = inspectionIdentificationDao.saveObject(inspectionRecord);
		if (i == 2)
			return i;
		// 更改委托书状态
		i = updateEntrustmentBookState(inspectionRecord.getInspection_belong_entrustment_book().trim(), "已记录");
		return i;
	}

	@Override
	public int saveAppraisalLetter(xsjsglxt_appraisal_letter appraisalLetter) {
		int i = 2;
		// 1.查询委托书表
		if (!("已记录".equals(entrustmentBookState(appraisalLetter.getAppraisal_letter_belong_entrustment_book().trim())))) {
			return 3;
		}
		// 填写
		appraisalLetter.setXsjsglxt_appraisal_letter_id(TeamUtil.getUuid());
		appraisalLetter.setAppraisal_letter_gmt_create(TeamUtil.getStringSecond());
		appraisalLetter.setAppraisal_letter_gmt_modified(appraisalLetter.getAppraisal_letter_gmt_create());
		i = inspectionIdentificationDao.saveObject(appraisalLetter);
		if (i == 2)
			return i;
		// 更改委托书状态
		i = updateEntrustmentBookState(appraisalLetter.getAppraisal_letter_belong_entrustment_book().trim(), "已鉴定");
		return i;
	}

	// 更改委托书
	// 3 传过来的参数有误
	@Override
	public int updateTranceCheckBook(xsjsglxt_check_entrustment_book tranceCheckBook) {
		xsjsglxt_check_entrustment_book xsjsglxt_check_entrustment_book = new xsjsglxt_check_entrustment_book();
		// 获取原有对象
		xsjsglxt_check_entrustment_book = inspectionIdentificationDao.getCheckEntrustmentBookById(tranceCheckBook.getXsjsglxt_check_entrustment_book_id());
		if (xsjsglxt_check_entrustment_book == null)
			return 3;
		tranceCheckBook.setCheck_entrustment_book_physical_evidence(xsjsglxt_check_entrustment_book.getCheck_entrustment_book_physical_evidence());
		tranceCheckBook.setCheck_entrustment_book_num(xsjsglxt_check_entrustment_book.getCheck_entrustment_book_num());
		tranceCheckBook.setCheck_entrustment_book_gmt_modified(TeamUtil.getStringSecond());
		tranceCheckBook.setCheck_entrustment_book_type(xsjsglxt_check_entrustment_book.getCheck_entrustment_book_type());
		tranceCheckBook.setCheck_entrustment_book_state(xsjsglxt_check_entrustment_book.getCheck_entrustment_book_state());
		tranceCheckBook.setCheck_entrustment_book_gmt_create(xsjsglxt_check_entrustment_book.getCheck_entrustment_book_gmt_create());
		return inspectionIdentificationDao.saveObject(tranceCheckBook);
	}

	// 更改鉴定事项确认书表
	@Override
	public int updateIdentifiederCaseConfirmBook(xsjsglxt_identifieder_case_confirm_book identifiederCaseConfirmBook) {
		xsjsglxt_identifieder_case_confirm_book xsjsglxt_identifieder_case_confirm_book = new xsjsglxt_identifieder_case_confirm_book();
		xsjsglxt_identifieder_case_confirm_book = inspectionIdentificationDao
				.getIdentifiederCaseConfirmBookByOwnId(identifiederCaseConfirmBook.getXsjsglxt_identifieder_case_confirm_book_id());
		if (xsjsglxt_identifieder_case_confirm_book == null)
			return 3;
		identifiederCaseConfirmBook
				.setIdentifieder_case_confirm_book_belong_entrustment_book(xsjsglxt_identifieder_case_confirm_book.getIdentifieder_case_confirm_book_belong_entrustment_book());
		identifiederCaseConfirmBook.setIdentifieder_case_confirm_book_acceptance_num(xsjsglxt_identifieder_case_confirm_book.getIdentifieder_case_confirm_book_acceptance_num());
		identifiederCaseConfirmBook.setIdentifieder_case_confirm_book_gmt_create(xsjsglxt_identifieder_case_confirm_book.getIdentifieder_case_confirm_book_gmt_create());
		identifiederCaseConfirmBook.setIdentifieder_case_confirm_book_gmt_modified(TeamUtil.getStringSecond());
		return inspectionIdentificationDao.saveObject(identifiederCaseConfirmBook);
	}

	// 不受理委托鉴定告知表
	@Override
	public int updateNotAcceptanceInform(xsjsglxt_not_acceptance_entrustment_inform notAcceptanceEntrustmentInform) {
		xsjsglxt_not_acceptance_entrustment_inform xsjsglxt_not_acceptance_entrustment_inform = new xsjsglxt_not_acceptance_entrustment_inform();
		xsjsglxt_not_acceptance_entrustment_inform = inspectionIdentificationDao
				.getNotAcceptanceEntrustmentInformByOwnId(notAcceptanceEntrustmentInform.getXsjsglxt_not_acceptance_entrustment_inform_id());
		if (xsjsglxt_not_acceptance_entrustment_inform == null)
			return 3;
		notAcceptanceEntrustmentInform.setNot_acceptance_entrustment_inform_belong_entrustment_book(
				xsjsglxt_not_acceptance_entrustment_inform.getNot_acceptance_entrustment_inform_belong_entrustment_book());
		//notAcceptanceEntrustmentInform.setNot_acceptance_entrustment_inform_num(xsjsglxt_not_acceptance_entrustment_inform.getNot_acceptance_entrustment_inform_num());
		notAcceptanceEntrustmentInform
				.setNot_acceptance_entrustment_inform_gmt_create(xsjsglxt_not_acceptance_entrustment_inform.getNot_acceptance_entrustment_inform_gmt_create());
		notAcceptanceEntrustmentInform.setNot_acceptance_entrustment_inform_gmt_modified(TeamUtil.getStringSecond());
		return inspectionIdentificationDao.saveObject(notAcceptanceEntrustmentInform);
	}

	// 检验记录表
	@Override
	public int updateInspectionRecord(xsjsglxt_inspection_record inspectionRecord) {
		xsjsglxt_inspection_record xsjsglxt_inspection_record = new xsjsglxt_inspection_record();
		xsjsglxt_inspection_record = inspectionIdentificationDao.getInspectionRecordByOwnId(inspectionRecord.getXsjsglxt_inspection_record_id());
		if (xsjsglxt_inspection_record == null)
			return 3;
		inspectionRecord.setInspection_belong_entrustment_book(xsjsglxt_inspection_record.getInspection_belong_entrustment_book());
		inspectionRecord.setInspection_gmt_create(xsjsglxt_inspection_record.getInspection_gmt_create());
		inspectionRecord.setInspection_gmt_modified(TeamUtil.getStringSecond());
		return inspectionIdentificationDao.saveObject(inspectionRecord);
	}

	// 更改鉴定文书
	@Override
	public int updateAppraisalLetter(xsjsglxt_appraisal_letter appraisalLetter) {
		xsjsglxt_appraisal_letter xsjsglxt_appraisal_letter = new xsjsglxt_appraisal_letter();
		xsjsglxt_appraisal_letter = inspectionIdentificationDao.getAppraisalLetterByOwnId(appraisalLetter.getXsjsglxt_appraisal_letter_id());
		if (xsjsglxt_appraisal_letter == null)
			return 3;
		appraisalLetter.setAppraisal_letter_belong_entrustment_book(xsjsglxt_appraisal_letter.getAppraisal_letter_belong_entrustment_book());
		appraisalLetter.setAppraisal_letter_gmt_create(xsjsglxt_appraisal_letter.getAppraisal_letter_gmt_create());
		appraisalLetter.setAppraisal_letter_gmt_modified(TeamUtil.getStringSecond());
		return inspectionIdentificationDao.saveObject(appraisalLetter);
	}

	@Override
	public String exportTraceCheckBookName(String id) {
		xsjsglxt_check_entrustment_book xsjsglxt_check_entrustment_book = new xsjsglxt_check_entrustment_book();
		xsjsglxt_check_entrustment_book = inspectionIdentificationDao.getCheckEntrustmentBookById(id);
		if (xsjsglxt_check_entrustment_book != null) {
			return xsjsglxt_check_entrustment_book.getCheck_entrustment_book_num();
		}
		return null;
	}

	// 导出委托书
	@Override
	public File exportTranceCheckBook(String id) throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		params.putAll(mapTranceCheckBook(id));
		XwpfTUtil xwpfTUtil = new XwpfTUtil();
		XWPFDocument doc;
		String fileNameInResource = "F:\\xsjsglxt.docx";
		InputStream is;
		is = new FileInputStream(fileNameInResource);
		doc = new XWPFDocument(is);
		xwpfTUtil.replaceInPara(doc, params);
		xwpfTUtil.replaceInTable(doc, params);
		OutputStream os = new FileOutputStream("F:\\kokokoko.docx");
		doc.write(os);
		xwpfTUtil.close(os);
		xwpfTUtil.close(is);
		os.flush();
		os.close();
		return new File("F:\\kokokoko.docx");
	}

	// 导出确认书
	@Override
	public File exportIdentifiederCaseConfirmBook(String id) throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		params.putAll(mapIdentifiederCaseConfirmBook(id));
		XwpfTUtil xwpfTUtil = new XwpfTUtil();
		XWPFDocument doc;
		String fileNameInResource = "F:\\xsjsglxt.docx";
		InputStream is;
		is = new FileInputStream(fileNameInResource);
		doc = new XWPFDocument(is);
		xwpfTUtil.replaceInPara(doc, params);
		xwpfTUtil.replaceInTable(doc, params);
		OutputStream os = new FileOutputStream("F:\\kokokoko.docx");
		doc.write(os);
		xwpfTUtil.close(os);
		xwpfTUtil.close(is);
		os.flush();
		os.close();
		return new File("F:\\kokokoko.docx");
	}

	/**
	 *
	 * 
	 * 方法
	 * 
	 * 
	 */

	// 鉴定确认书
	public Map<String, Object> mapIdentifiederCaseConfirmBook(String id) {
		xsjsglxt_check_entrustment_book xsjsglxt_check_entrustment_book = new xsjsglxt_check_entrustment_book();
		xsjsglxt_identifieder_case_confirm_book xsjsglxt_identifieder_case_confirm_book = new xsjsglxt_identifieder_case_confirm_book();
		Map<String, Object> params = new HashMap<String, Object>();
		xsjsglxt_identifieder_case_confirm_book = inspectionIdentificationDao.getIdentifiederCaseConfirmBookByOwnId(id);
		if (xsjsglxt_identifieder_case_confirm_book != null) {
			if (xsjsglxt_identifieder_case_confirm_book.getIdentifieder_case_confirm_book_belong_entrustment_book() != null
					&& xsjsglxt_identifieder_case_confirm_book.getIdentifieder_case_confirm_book_belong_entrustment_book().trim().length() > 0) {
				xsjsglxt_check_entrustment_book = inspectionIdentificationDao
						.getCheckEntrustmentBookById(xsjsglxt_identifieder_case_confirm_book.getIdentifieder_case_confirm_book_belong_entrustment_book().trim());
				if (xsjsglxt_check_entrustment_book.getCheck_entrustment_book_entrustment_unit_name() != null
						&& xsjsglxt_check_entrustment_book.getCheck_entrustment_book_entrustment_unit_name().trim().length() > 0) {
					params.put("${q3}", xsjsglxt_check_entrustment_book.getCheck_entrustment_book_entrustment_unit_name().trim());
				} else {
					params.put("${q3}", "");
				}
				if (xsjsglxt_check_entrustment_book.getCheck_entrustment_book_entrustment_unit() != null
						&& xsjsglxt_check_entrustment_book.getCheck_entrustment_book_entrustment_unit().trim().length() > 0) {
					params.put("${q4}", xsjsglxt_check_entrustment_book.getCheck_entrustment_book_entrustment_unit().trim());
				} else {
					params.put("${q4}", "");
				}
				if (xsjsglxt_check_entrustment_book.getCheck_entrustment_book_num() != null
						&& xsjsglxt_check_entrustment_book.getCheck_entrustment_book_num().trim().length() > 0) {
					params.put("${q5}", (xsjsglxt_check_entrustment_book.getCheck_entrustment_book_num().trim()).substring(0, 4));
					params.put("${q6}", (xsjsglxt_check_entrustment_book.getCheck_entrustment_book_num().trim()).substring(4));
				} else {
					params.put("${q5}", "");
					params.put("${q6}", "");
				}
				if (xsjsglxt_check_entrustment_book.getCheck_entrustment_book_inspectors1_name() != null
						&& xsjsglxt_check_entrustment_book.getCheck_entrustment_book_inspectors1_name().trim().length() > 0) {
					params.put("${q7}", xsjsglxt_check_entrustment_book.getCheck_entrustment_book_inspectors1_name().trim());
				} else {
					params.put("${q7}", "");
				}
				if (xsjsglxt_check_entrustment_book.getCheck_entrustment_book_inspectors2_name() != null
						&& xsjsglxt_check_entrustment_book.getCheck_entrustment_book_inspectors2_name().trim().length() > 0) {
					params.put("${q10}", xsjsglxt_check_entrustment_book.getCheck_entrustment_book_inspectors2_name().trim());
				} else {
					params.put("${q10}", "");
				}
				if (xsjsglxt_check_entrustment_book.getCheck_entrustment_book_inspectors1_duty() != null
						&& xsjsglxt_check_entrustment_book.getCheck_entrustment_book_inspectors1_duty().trim().length() > 0) {
					params.put("${q8}", xsjsglxt_check_entrustment_book.getCheck_entrustment_book_inspectors1_duty().trim());
				} else {
					params.put("${q8}", "");
				}
				if (xsjsglxt_check_entrustment_book.getCheck_entrustment_book_inspectors2_duty() != null
						&& xsjsglxt_check_entrustment_book.getCheck_entrustment_book_inspectors2_duty().trim().length() > 0) {
					params.put("${q11}", xsjsglxt_check_entrustment_book.getCheck_entrustment_book_inspectors2_duty().trim());
				} else {
					params.put("${q11}", "");
				}
				if (xsjsglxt_check_entrustment_book.getCheck_entrustment_book_inspectors1_jobcard_number() != null
						&& xsjsglxt_check_entrustment_book.getCheck_entrustment_book_inspectors1_jobcard_number().trim().length() > 0) {
					params.put("${q9}", xsjsglxt_check_entrustment_book.getCheck_entrustment_book_inspectors1_jobcard_number().trim());
				} else {
					params.put("${q9}", "");
				}
				if (xsjsglxt_check_entrustment_book.getCheck_entrustment_book_inspectors2_jobcard_number() != null
						&& xsjsglxt_check_entrustment_book.getCheck_entrustment_book_inspectors2_jobcard_number().trim().length() > 0) {
					params.put("${q12}", xsjsglxt_check_entrustment_book.getCheck_entrustment_book_inspectors2_jobcard_number().trim());
				} else {
					params.put("${q12}", "");
				}
				if (xsjsglxt_check_entrustment_book.getCheck_entrustment_book_communication_address() != null
						&& xsjsglxt_check_entrustment_book.getCheck_entrustment_book_communication_address().trim().length() > 0) {
					params.put("${q13}", xsjsglxt_check_entrustment_book.getCheck_entrustment_book_communication_address().trim());
				} else {
					params.put("${q13}", "");
				}
				if (xsjsglxt_check_entrustment_book.getCheck_entrustment_book_zip_code() != null
						&& xsjsglxt_check_entrustment_book.getCheck_entrustment_book_zip_code().trim().length() > 0) {
					params.put("${q14}", xsjsglxt_check_entrustment_book.getCheck_entrustment_book_zip_code().trim());
				} else {
					params.put("${q14}", "");
				}
				if (xsjsglxt_check_entrustment_book.getCheck_entrustment_book_phone() != null
						&& xsjsglxt_check_entrustment_book.getCheck_entrustment_book_phone().trim().length() > 0) {
					params.put("${q15}", xsjsglxt_check_entrustment_book.getCheck_entrustment_book_phone().trim());
				} else {
					params.put("${q15}", "");
				}
				if (xsjsglxt_check_entrustment_book.getCheck_entrustment_book_fax_num() != null
						&& xsjsglxt_check_entrustment_book.getCheck_entrustment_book_fax_num().trim().length() > 0) {
					params.put("${q16}", xsjsglxt_check_entrustment_book.getCheck_entrustment_book_fax_num().trim());
				} else {
					params.put("${q16}", "");
				}
				if (xsjsglxt_check_entrustment_book.getCheck_entrustment_book_case_name() != null
						&& xsjsglxt_check_entrustment_book.getCheck_entrustment_book_case_name().trim().length() > 0) {
					params.put("${q17}", xsjsglxt_check_entrustment_book.getCheck_entrustment_book_case_name().trim());
				} else {
					params.put("${q17}", "");
				}
				if (xsjsglxt_check_entrustment_book.getCheck_entrustment_book_case_num() != null
						&& xsjsglxt_check_entrustment_book.getCheck_entrustment_book_case_num().trim().length() > 0) {
					params.put("${q18}", xsjsglxt_check_entrustment_book.getCheck_entrustment_book_case_num().trim());
				} else {
					params.put("${q18}", "");
				}
				if ("痕迹检验".equals(xsjsglxt_check_entrustment_book.getCheck_entrustment_book_type())) {
					params.put("${q19}", "/");
					params.put("${q20}", "/");
					params.put("${q21}", "/");
					params.put("${q22}", "/");
					params.put("${q23}", "/");
					params.put("${q24}", "/");
				} else {
					if (xsjsglxt_check_entrustment_book.getCheck_entrustment_book_entrustmentor_name() != null
							&& xsjsglxt_check_entrustment_book.getCheck_entrustment_book_entrustmentor_name().trim().length() > 0) {
						params.put("${q19}", xsjsglxt_check_entrustment_book.getCheck_entrustment_book_entrustmentor_name().trim());
					} else {
						params.put("${q19}", "");
					}
					if (xsjsglxt_check_entrustment_book.getCheck_entrustment_book_entrustmentor_sex() != null
							&& xsjsglxt_check_entrustment_book.getCheck_entrustment_book_entrustmentor_sex().trim().length() > 0) {
						params.put("${q20}", xsjsglxt_check_entrustment_book.getCheck_entrustment_book_entrustmentor_sex().trim());
					} else {
						params.put("${q20}", "");
					}
					if (xsjsglxt_check_entrustment_book.getCheck_entrustment_book_entrustmentor_age() != null
							&& xsjsglxt_check_entrustment_book.getCheck_entrustment_book_entrustmentor_age().trim().length() > 0) {
						params.put("${q21}", xsjsglxt_check_entrustment_book.getCheck_entrustment_book_entrustmentor_age().trim());
					} else {
						params.put("${q21}", "");
					}
					if (xsjsglxt_check_entrustment_book.getCheck_entrustment_book_entrustmentor_phone() != null
							&& xsjsglxt_check_entrustment_book.getCheck_entrustment_book_entrustmentor_phone().trim().length() > 0) {
						params.put("${q22}", xsjsglxt_check_entrustment_book.getCheck_entrustment_book_entrustmentor_phone().trim());
					} else {
						params.put("${q22}", "");
					}
					if (xsjsglxt_check_entrustment_book.getCheck_entrustment_book_entrustment_unit() != null
							&& xsjsglxt_check_entrustment_book.getCheck_entrustment_book_entrustment_unit().trim().length() > 0) {
						params.put("${q23}", xsjsglxt_check_entrustment_book.getCheck_entrustment_book_entrustment_unit().trim());
					} else {
						params.put("${q23}", "");
					}
					if (xsjsglxt_check_entrustment_book.getCheck_entrustment_book_entrustmentor_address() != null
							&& xsjsglxt_check_entrustment_book.getCheck_entrustment_book_entrustmentor_address().trim().length() > 0) {
						params.put("${q24}", xsjsglxt_check_entrustment_book.getCheck_entrustment_book_entrustmentor_address().trim());
					} else {
						params.put("${q24}", "");
					}
				}
				if (xsjsglxt_check_entrustment_book.getCheck_entrustment_book_simple_case_situation() != null
						&& xsjsglxt_check_entrustment_book.getCheck_entrustment_book_simple_case_situation().trim().length() > 0) {
					params.put("${q25}", xsjsglxt_check_entrustment_book.getCheck_entrustment_book_simple_case_situation().trim());
				} else {
					params.put("${q25}", "");
				}
				if (xsjsglxt_check_entrustment_book.getCheck_entrustment_book_sample_situation() != null
						&& xsjsglxt_check_entrustment_book.getCheck_entrustment_book_sample_situation().trim().length() > 0) {
					params.put("${q26}", xsjsglxt_check_entrustment_book.getCheck_entrustment_book_sample_situation().trim());
				} else {
					params.put("${q26}", "");
				}
				if (xsjsglxt_check_entrustment_book.getCheck_entrustment_book_entrustment_request() != null
						&& xsjsglxt_check_entrustment_book.getCheck_entrustment_book_entrustment_request().trim().length() > 0) {
					params.put("${q27}", xsjsglxt_check_entrustment_book.getCheck_entrustment_book_entrustment_request().trim());
				} else {
					params.put("${q27}", "");
				}
			}
			if (xsjsglxt_identifieder_case_confirm_book.getIdentifieder_case_confirm_book_acceptance_human_name() != null
					&& xsjsglxt_identifieder_case_confirm_book.getIdentifieder_case_confirm_book_acceptance_human_name().trim().length() > 0) {
				params.put("${q28}", xsjsglxt_identifieder_case_confirm_book.getIdentifieder_case_confirm_book_acceptance_human_name().trim());
			} else {
				params.put("${q28}", "");
			}
		}
		return params;
	}

	// 鉴定委托书Map
	public Map<String, Object> mapTranceCheckBook(String id) {
		xsjsglxt_check_entrustment_book xsjsglxt_check_entrustment_book = new xsjsglxt_check_entrustment_book();
		Map<String, Object> params = new HashMap<String, Object>();
		// 根据ID获取委托书
		xsjsglxt_check_entrustment_book = inspectionIdentificationDao.getCheckEntrustmentBookById(id);
		if (xsjsglxt_check_entrustment_book != null) {
			if (xsjsglxt_check_entrustment_book.getCheck_entrustment_book_num() != null && xsjsglxt_check_entrustment_book.getCheck_entrustment_book_num().trim().length() > 0) {
				params.put("${x1}", (xsjsglxt_check_entrustment_book.getCheck_entrustment_book_num().trim()).substring(0, 4));
				params.put("${x2}", (xsjsglxt_check_entrustment_book.getCheck_entrustment_book_num().trim()).substring(4));
			} else {
				params.put("${x1}", "");
				params.put("${x2}", "");
			}
			if (xsjsglxt_check_entrustment_book.getCheck_entrustment_book_entrustment_unit() != null
					&& xsjsglxt_check_entrustment_book.getCheck_entrustment_book_entrustment_unit().trim().length() > 0) {
				params.put("${x3}", xsjsglxt_check_entrustment_book.getCheck_entrustment_book_entrustment_unit().trim());
			} else {
				params.put("${x3}", "");
			}
			if (xsjsglxt_check_entrustment_book.getCheck_entrustment_book_inspect_time() != null
					&& xsjsglxt_check_entrustment_book.getCheck_entrustment_book_inspect_time().trim().length() > 0) {
				params.put("${x4}", xsjsglxt_check_entrustment_book.getCheck_entrustment_book_inspect_time().trim());
			} else {
				params.put("${x4}", "");
			}
			if (xsjsglxt_check_entrustment_book.getCheck_entrustment_book_inspectors1_name() != null
					&& xsjsglxt_check_entrustment_book.getCheck_entrustment_book_inspectors1_name().trim().length() > 0) {
				params.put("${x5}", xsjsglxt_check_entrustment_book.getCheck_entrustment_book_inspectors1_name().trim());
			} else {
				params.put("${x5}", "");
			}
			if (xsjsglxt_check_entrustment_book.getCheck_entrustment_book_inspectors2_name() != null
					&& xsjsglxt_check_entrustment_book.getCheck_entrustment_book_inspectors2_name().trim().length() > 0) {
				params.put("${x8}", xsjsglxt_check_entrustment_book.getCheck_entrustment_book_inspectors2_name().trim());
			} else {
				params.put("${x8}", "");
			}
			if (xsjsglxt_check_entrustment_book.getCheck_entrustment_book_inspectors1_duty() != null
					&& xsjsglxt_check_entrustment_book.getCheck_entrustment_book_inspectors1_duty().trim().length() > 0) {
				params.put("${x6}", xsjsglxt_check_entrustment_book.getCheck_entrustment_book_inspectors1_duty().trim());
			} else {
				params.put("${x6}", "");
			}
			if (xsjsglxt_check_entrustment_book.getCheck_entrustment_book_inspectors2_duty() != null
					&& xsjsglxt_check_entrustment_book.getCheck_entrustment_book_inspectors2_duty().trim().length() > 0) {
				params.put("${x9}", xsjsglxt_check_entrustment_book.getCheck_entrustment_book_inspectors2_duty().trim());
			} else {
				params.put("${x9}", "");
			}
			if (xsjsglxt_check_entrustment_book.getCheck_entrustment_book_inspectors1_jobcard_number() != null
					&& xsjsglxt_check_entrustment_book.getCheck_entrustment_book_inspectors1_jobcard_number().trim().length() > 0) {
				params.put("${x7}", xsjsglxt_check_entrustment_book.getCheck_entrustment_book_inspectors1_jobcard_number().trim());
			} else {
				params.put("${x7}", "");
			}
			if (xsjsglxt_check_entrustment_book.getCheck_entrustment_book_inspectors2_jobcard_number() != null
					&& xsjsglxt_check_entrustment_book.getCheck_entrustment_book_inspectors2_jobcard_number().trim().length() > 0) {
				params.put("${x10}", xsjsglxt_check_entrustment_book.getCheck_entrustment_book_inspectors2_jobcard_number().trim());
			} else {
				params.put("${x10}", "");
			}
			if (xsjsglxt_check_entrustment_book.getCheck_entrustment_book_communication_address() != null
					&& xsjsglxt_check_entrustment_book.getCheck_entrustment_book_communication_address().trim().length() > 0) {
				params.put("${x11}", xsjsglxt_check_entrustment_book.getCheck_entrustment_book_communication_address().trim());
			} else {
				params.put("${x11}", "");
			}
			if (xsjsglxt_check_entrustment_book.getCheck_entrustment_book_zip_code() != null
					&& xsjsglxt_check_entrustment_book.getCheck_entrustment_book_zip_code().trim().length() > 0) {
				params.put("${x12}", xsjsglxt_check_entrustment_book.getCheck_entrustment_book_zip_code().trim());
			} else {
				params.put("${x12}", "");
			}
			if (xsjsglxt_check_entrustment_book.getCheck_entrustment_book_phone() != null
					&& xsjsglxt_check_entrustment_book.getCheck_entrustment_book_phone().trim().length() > 0) {
				params.put("${x13}", xsjsglxt_check_entrustment_book.getCheck_entrustment_book_phone().trim());
			} else {
				params.put("${x13}", "");
			}
			if (xsjsglxt_check_entrustment_book.getCheck_entrustment_book_fax_num() != null
					&& xsjsglxt_check_entrustment_book.getCheck_entrustment_book_fax_num().trim().length() > 0) {
				params.put("${x14}", xsjsglxt_check_entrustment_book.getCheck_entrustment_book_fax_num().trim());
			} else {
				params.put("${x14}", "");
			}
			if (xsjsglxt_check_entrustment_book.getCheck_entrustment_book_entrustment_unit_name() != null
					&& xsjsglxt_check_entrustment_book.getCheck_entrustment_book_entrustment_unit_name().trim().length() > 0) {
				params.put("${x15}", xsjsglxt_check_entrustment_book.getCheck_entrustment_book_entrustment_unit_name().trim());
			} else {
				params.put("${x15}", "");
			}
			if (xsjsglxt_check_entrustment_book.getCheck_entrustment_book_case_name() != null
					&& xsjsglxt_check_entrustment_book.getCheck_entrustment_book_case_name().trim().length() > 0) {
				params.put("${x16}", xsjsglxt_check_entrustment_book.getCheck_entrustment_book_case_name().trim());
			} else {
				params.put("${x16}", "");
			}
			if (xsjsglxt_check_entrustment_book.getCheck_entrustment_book_case_num() != null
					&& xsjsglxt_check_entrustment_book.getCheck_entrustment_book_case_num().trim().length() > 0) {
				params.put("${x17}", xsjsglxt_check_entrustment_book.getCheck_entrustment_book_case_num().trim());
			} else {
				params.put("${x17}", "");
			}
			if ("痕迹检验".equals(xsjsglxt_check_entrustment_book.getCheck_entrustment_book_type())) {
				params.put("${x18}", "/");
				params.put("${x19}", "/");
				params.put("${x20}", "/");
				params.put("${x21}", "/");
				params.put("${x22}", "/");
				params.put("${x23}", "/");
			} else {
				if (xsjsglxt_check_entrustment_book.getCheck_entrustment_book_entrustmentor_name() != null
						&& xsjsglxt_check_entrustment_book.getCheck_entrustment_book_entrustmentor_name().trim().length() > 0) {
					params.put("${x18}", xsjsglxt_check_entrustment_book.getCheck_entrustment_book_entrustmentor_name().trim());
				} else {
					params.put("${x18}", "");
				}
				if (xsjsglxt_check_entrustment_book.getCheck_entrustment_book_entrustmentor_sex() != null
						&& xsjsglxt_check_entrustment_book.getCheck_entrustment_book_entrustmentor_sex().trim().length() > 0) {
					params.put("${x19}", xsjsglxt_check_entrustment_book.getCheck_entrustment_book_entrustmentor_sex().trim());
				} else {
					params.put("${x19}", "");
				}
				if (xsjsglxt_check_entrustment_book.getCheck_entrustment_book_entrustmentor_age() != null
						&& xsjsglxt_check_entrustment_book.getCheck_entrustment_book_entrustmentor_age().trim().length() > 0) {
					params.put("${x20}", xsjsglxt_check_entrustment_book.getCheck_entrustment_book_entrustmentor_age().trim());
				} else {
					params.put("${x20}", "");
				}
				if (xsjsglxt_check_entrustment_book.getCheck_entrustment_book_entrustmentor_phone() != null
						&& xsjsglxt_check_entrustment_book.getCheck_entrustment_book_entrustmentor_phone().trim().length() > 0) {
					params.put("${x21}", xsjsglxt_check_entrustment_book.getCheck_entrustment_book_entrustmentor_phone().trim());
				} else {
					params.put("${x21}", "");
				}
				if (xsjsglxt_check_entrustment_book.getCheck_entrustment_book_entrustment_unit() != null
						&& xsjsglxt_check_entrustment_book.getCheck_entrustment_book_entrustment_unit().trim().length() > 0) {
					params.put("${x22}", xsjsglxt_check_entrustment_book.getCheck_entrustment_book_entrustment_unit().trim());
				} else {
					params.put("${x22}", "");
				}
				if (xsjsglxt_check_entrustment_book.getCheck_entrustment_book_entrustmentor_address() != null
						&& xsjsglxt_check_entrustment_book.getCheck_entrustment_book_entrustmentor_address().trim().length() > 0) {
					params.put("${x23}", xsjsglxt_check_entrustment_book.getCheck_entrustment_book_entrustmentor_address().trim());
				} else {
					params.put("${x23}", "");
				}
			}
			if (xsjsglxt_check_entrustment_book.getCheck_entrustment_book_simple_case_situation() != null
					&& xsjsglxt_check_entrustment_book.getCheck_entrustment_book_simple_case_situation().trim().length() > 0) {
				params.put("${x24}", xsjsglxt_check_entrustment_book.getCheck_entrustment_book_simple_case_situation().trim());
			} else {
				params.put("${x24}", "");
			}
			if (xsjsglxt_check_entrustment_book.getCheck_entrustment_book_old_entrustment_situation() != null
					&& xsjsglxt_check_entrustment_book.getCheck_entrustment_book_old_entrustment_situation().trim().length() > 0) {
				params.put("${x25}", xsjsglxt_check_entrustment_book.getCheck_entrustment_book_old_entrustment_situation().trim());
			} else {
				params.put("${x25}", "");
			}
			if (xsjsglxt_check_entrustment_book.getCheck_entrustment_book_sample_situation() != null
					&& xsjsglxt_check_entrustment_book.getCheck_entrustment_book_sample_situation().trim().length() > 0) {
				params.put("${x26}", xsjsglxt_check_entrustment_book.getCheck_entrustment_book_sample_situation().trim());
			} else {
				params.put("${x26}", "");
			}
			if (xsjsglxt_check_entrustment_book.getCheck_entrustment_book_entrustment_request() != null
					&& xsjsglxt_check_entrustment_book.getCheck_entrustment_book_entrustment_request().trim().length() > 0) {
				params.put("${x27}", xsjsglxt_check_entrustment_book.getCheck_entrustment_book_entrustment_request().trim());
			} else {
				params.put("${x27}", "");
			}
			if (xsjsglxt_check_entrustment_book.getCheck_entrustment_book_responsible_person() != null
					&& xsjsglxt_check_entrustment_book.getCheck_entrustment_book_responsible_person().trim().length() > 0) {
				params.put("${x28}", xsjsglxt_check_entrustment_book.getCheck_entrustment_book_responsible_person().trim());
			} else {
				params.put("${x28}", "");
			}
		}
		return params;
	}

	// 获取委托书状态
	public String entrustmentBookState(String id) {
		xsjsglxt_check_entrustment_book checkEntrustmentBook = new xsjsglxt_check_entrustment_book();
		checkEntrustmentBook = inspectionIdentificationDao.getCheckEntrustmentBookById(id);
		if (checkEntrustmentBook == null)
			return null;
		return checkEntrustmentBook.getCheck_entrustment_book_state();
	}

	// 更改委托书状态
	public int updateEntrustmentBookState(String id, String state) {
		int i = 0;
		xsjsglxt_check_entrustment_book checkEntrustmentBook = new xsjsglxt_check_entrustment_book();
		// 根据ID获取委托书
		checkEntrustmentBook = inspectionIdentificationDao.getCheckEntrustmentBookById(id);
		if (checkEntrustmentBook != null) {
			checkEntrustmentBook.setCheck_entrustment_book_state(state);
			checkEntrustmentBook.setCheck_entrustment_book_gmt_modified(TeamUtil.getStringSecond());
			// 保存
			i = inspectionIdentificationDao.saveObject(checkEntrustmentBook);
		}
		return i;
	}

}
