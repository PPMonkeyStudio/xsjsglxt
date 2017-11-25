package com.xsjsglxt.dao.InspectionIdentification;


public interface InspectionIdentificationDao {

	public int saveObject(Object object);

	public int getCountCheckNum(String check_entrustment_book_year,String type);

}
