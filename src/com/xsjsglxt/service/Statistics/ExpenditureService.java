package com.xsjsglxt.service.Statistics;

import com.xsjsglxt.domain.DO.xsjsglxt_expenditure;
import com.xsjsglxt.domain.VO.Statistics.ExpenditureVO;

public interface ExpenditureService {

	boolean saveExpenditure(xsjsglxt_expenditure expenditure);

	boolean deleteExpenditure(String[] expenditure_id);

	boolean updateExpenditure(xsjsglxt_expenditure expenditure);

	xsjsglxt_expenditure getExpenditureById(String expenditure_id);

	void searchExpenditureByPage(ExpenditureVO expenditureVO);

}
