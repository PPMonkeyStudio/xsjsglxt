package com.xsjsglxt.service.impl.InspectionIdentification;

import java.util.ArrayList;
import java.util.List;

import com.xsjsglxt.dao.InspectionIdentification.InspectionIdentificationDao;
import com.xsjsglxt.domain.DO.xsjsglxt_check_entrustment_book;
import com.xsjsglxt.domain.DO.xsjsglxt_identifieder_case_confirm_book;
import com.xsjsglxt.domain.DO.xsjsglxt_not_acceptance_entrustment_inform;
import com.xsjsglxt.domain.DTO.InspectionIdentification.EntrustmentBookManagementDTO;
import com.xsjsglxt.domain.VO.InspectionIdentification.EntrustmentBookManagementVO;
import com.xsjsglxt.service.InspectionIdentification.InspectionIdentificationService;

import util.TeamUtil;

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
		System.out.println(i);
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
		xsjsglxt_identifieder_case_confirm_book identifiederCaseConfirmBook = new xsjsglxt_identifieder_case_confirm_book();
		xsjsglxt_not_acceptance_entrustment_inform notAcceptanceEntrustmentInform = new xsjsglxt_not_acceptance_entrustment_inform();
		List<xsjsglxt_check_entrustment_book> listCheckEntrustmentBook = new ArrayList<xsjsglxt_check_entrustment_book>();
		// 根据筛选获取总计路数
		int i = inspectionIdentificationDao.getCountByPageAndSearch(checkEntrustmentBookVO);
		System.out.println(i);
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
			listEntrustmentBookManagementDTO.add(entrustmentBookManagementDTO);
		}
		checkEntrustmentBookVO.setListEntrustmentBookManagementDTO(listEntrustmentBookManagementDTO);
		return checkEntrustmentBookVO;
	}

	// 批量删除委托书ID
	@Override
	public int deleteListCheckEntrustmentBook(List<String> listCheckEntrustmentBookId) {
		int i = 0;
		for (String checkEntrustmentBookId : listCheckEntrustmentBookId) {
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
		// 填写鉴定事项确认书
		identifiederCaseConfirmBook.setXsjsglxt_identifieder_case_confirm_book_id(TeamUtil.getUuid());
		identifiederCaseConfirmBook.setIdentifieder_case_confirm_book_acceptance_num("待定");
		identifiederCaseConfirmBook.setIdentifieder_case_confirm_book_gmt_create(TeamUtil.getStringSecond());
		identifiederCaseConfirmBook.setIdentifieder_case_confirm_book_gmt_modified(TeamUtil.getStringSecond());
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
		notAcceptanceEntrustmentInform.setXsjsglxt_not_acceptance_entrustment_inform_id(TeamUtil.getUuid());
		notAcceptanceEntrustmentInform.setNot_acceptance_entrustment_inform_num("待定");
		notAcceptanceEntrustmentInform.setNot_acceptance_entrustment_inform_gmt_create(TeamUtil.getStringSecond());
		notAcceptanceEntrustmentInform.setNot_acceptance_entrustment_inform_gmt_modified(TeamUtil.getStringSecond());
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

	/**
	 *
	 * 
	 * 方法
	 * 
	 * 
	 */
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
