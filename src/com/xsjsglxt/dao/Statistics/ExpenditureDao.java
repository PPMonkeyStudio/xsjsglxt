package com.xsjsglxt.dao.Statistics;

import com.xsjsglxt.domain.DO.xsjsglxt_expenditure;

public interface ExpenditureDao {

	boolean saveExpenditure(xsjsglxt_expenditure expenditure);

	boolean deleteExpenditure(xsjsglxt_expenditure expenditure);

	xsjsglxt_expenditure getExpenditureById(String expenditure_id);

	boolean updateExpenditure(xsjsglxt_expenditure expenditure);

}
