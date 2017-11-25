package com.xsjsglxt.service.impl.InspectionIdentification;

import com.xsjsglxt.dao.InspectionIdentification.InspectionIdentificationDao;
import com.xsjsglxt.domain.DO.xsjsglxt_check_entrustment_book;
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
		tranceCheckBook.setXsjsglxt_check_entrustment_book_id(TeamUtil.getUuid());
		// 给年份
		tranceCheckBook.setCheck_entrustment_book_year(TeamUtil.getCurrentYear());
		// 查找数量,并且填写编号
		tranceCheckBook.setCheck_entrustment_book_num(
				inspectionIdentificationDao.getCountCheckNum(tranceCheckBook.getCheck_entrustment_book_year(),
						tranceCheckBook.getCheck_entrustment_book_type()) + 1+"");
		tranceCheckBook.setCheck_entrustment_book_gmt_create(TeamUtil.getStringSecond());
		tranceCheckBook.setCheck_entrustment_book_gmt_modified(tranceCheckBook.getCheck_entrustment_book_gmt_create());
		return inspectionIdentificationDao.saveObject(tranceCheckBook);
	}

}
