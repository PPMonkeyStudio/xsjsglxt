package com.xsjsglxt.dao.InspectionIdentification;

import java.util.List;

import com.xsjsglxt.domain.DO.xsjsglxt_check_entrustment_book;
import com.xsjsglxt.domain.VO.InspectionIdentification.CheckEntrustmentBookVO;

public interface InspectionIdentificationDao {

	public int saveObject(Object object);

	public int getCountCheckNum(String check_entrustment_book_year,String type);

	public int getCountByPageAndSearch(CheckEntrustmentBookVO checkEntrustmentBookVO);

	public List<xsjsglxt_check_entrustment_book> getListCheckEntrustmentBookByPage(
			CheckEntrustmentBookVO checkEntrustmentBookVO);

}
