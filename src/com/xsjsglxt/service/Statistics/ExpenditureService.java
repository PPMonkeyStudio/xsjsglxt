package com.xsjsglxt.service.Statistics;

import com.xsjsglxt.domain.DO.xsjsglxt_expenditure;

public interface ExpenditureService {

	boolean saveExpenditure(xsjsglxt_expenditure expenditure);

	boolean deleteExpenditure(String[] expenditure_id);

	boolean updateExpenditure(xsjsglxt_expenditure expenditure);

}
