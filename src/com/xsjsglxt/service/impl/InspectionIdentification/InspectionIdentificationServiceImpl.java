package com.xsjsglxt.service.impl.InspectionIdentification;

import com.xsjsglxt.dao.InspectionIdentification.InspectionIdentificationDao;
import com.xsjsglxt.domain.DO.xsjsglxt_trance_check_entrustment_book;
import com.xsjsglxt.service.InspectionIdentification.InspectionIdentificationService;

import util.TeamUtil;

public class InspectionIdentificationServiceImpl implements InspectionIdentificationService {
	private InspectionIdentificationDao inspectionIdentificationDao;

	public void setInspectionIdentificationDao(InspectionIdentificationDao inspectionIdentificationDao) {
		this.inspectionIdentificationDao = inspectionIdentificationDao;
	}

	// 保存痕迹检验委托书
	@Override
	public int saveTranceCheckBook(xsjsglxt_trance_check_entrustment_book tranceCheckBook) {
		tranceCheckBook.setXsjsglxt_trance_check_entrustment_book_id(TeamUtil.getUuid());
		tranceCheckBook.setTrance_check_entrustment_book_gmt_create(TeamUtil.getStringSecond());
		tranceCheckBook.setTrance_check_entrustment_book_gmt_modified(
				tranceCheckBook.getTrance_check_entrustment_book_gmt_create());
		return inspectionIdentificationDao.saveObject(tranceCheckBook);
	}

}
