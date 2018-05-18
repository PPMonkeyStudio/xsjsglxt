package com.xsjsglxt.service.impl.Statistics;

import com.xsjsglxt.dao.Statistics.ExpenditureDao;
import com.xsjsglxt.domain.DO.xsjsglxt_expenditure;
import com.xsjsglxt.service.Statistics.ExpenditureService;

import util.TeamUtil;

public class ExpenditureServiceImpl implements ExpenditureService {
	private ExpenditureDao expenditureDao;

	public ExpenditureDao getExpenditureDao() {
		return expenditureDao;
	}

	public void setExpenditureDao(ExpenditureDao expenditureDao) {
		this.expenditureDao = expenditureDao;
	}

	@Override
	public boolean saveExpenditure(xsjsglxt_expenditure expenditure) {
		// TODO Auto-generated method stub

		expenditure.setExpenditure_id(TeamUtil.getUuid());
		expenditure.setExpenditure_gmt_create(TeamUtil.getStringSecond());
		expenditure.setExpenditure_gmt_modified(TeamUtil.getStringSecond());
		return expenditureDao.saveExpenditure(expenditure);
	}

	@Override
	public boolean deleteExpenditure(String[] expenditure_id) {
		// TODO Auto-generated method stub

		boolean flag = false;
		int length = expenditure_id.length;
		xsjsglxt_expenditure expenditure;
		for (int i = 0; i < length; i++) {
			expenditure = new xsjsglxt_expenditure();
			expenditure.setExpenditure_id(expenditure_id[i]);
			flag = expenditureDao.deleteExpenditure(expenditure);
		}

		return flag;
	}

	@Override
	public boolean updateExpenditure(xsjsglxt_expenditure expenditure) {
		// TODO Auto-generated method stub
		boolean flag = false;
		xsjsglxt_expenditure oldExpenditure = expenditureDao.getExpenditureById(expenditure.getExpenditure_id());
		if (oldExpenditure != null) {
			expenditure.setExpenditure_gmt_create(oldExpenditure.getExpenditure_gmt_create());
			expenditure.setExpenditure_gmt_modified(TeamUtil.getStringSecond());
			flag = expenditureDao.updateExpenditure(expenditure);
			return flag;
		} else {
			return false;
		}
	}

}
