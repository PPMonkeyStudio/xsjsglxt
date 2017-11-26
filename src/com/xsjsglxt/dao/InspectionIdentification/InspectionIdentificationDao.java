package com.xsjsglxt.dao.InspectionIdentification;

import java.util.List;

import com.xsjsglxt.domain.DO.xsjsglxt_check_entrustment_book;
import com.xsjsglxt.domain.VO.InspectionIdentification.EntrustmentBookManagementVO;

public interface InspectionIdentificationDao {

	public int saveObject(Object object);

	public int getCountCheckNum(String check_entrustment_book_year,String type);

	public int getCountByPageAndSearch(EntrustmentBookManagementVO checkEntrustmentBookVO);

	public List<xsjsglxt_check_entrustment_book> getListCheckEntrustmentBookByPage(
			EntrustmentBookManagementVO checkEntrustmentBookVO);

	public int deleteCheckEntrustmentBookById(String checkEntrustmentBookId);

}
