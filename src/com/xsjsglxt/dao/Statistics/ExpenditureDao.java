package com.xsjsglxt.dao.Statistics;

import java.util.List;

import com.xsjsglxt.domain.DO.xsjsglxt_expenditure;
import com.xsjsglxt.domain.VO.Statistics.ExpenditureVO;

public interface ExpenditureDao {

	boolean saveExpenditure(xsjsglxt_expenditure expenditure);

	boolean deleteExpenditure(xsjsglxt_expenditure expenditure);

	xsjsglxt_expenditure getExpenditureById(String expenditure_id);

	boolean updateExpenditure(xsjsglxt_expenditure expenditure);

	int getCountBySearch(ExpenditureVO expenditureVO);

	List<xsjsglxt_expenditure> getSearchExpenditureByPage(ExpenditureVO expenditureVO);

	int getTotalMoneyBySearch(ExpenditureVO expenditureVO);

}
