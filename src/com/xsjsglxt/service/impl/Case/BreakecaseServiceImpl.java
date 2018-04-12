package com.xsjsglxt.service.impl.Case;

import java.util.List;

import com.xsjsglxt.dao.Case.BreakecaseDao;
import com.xsjsglxt.domain.DO.xsjsglxt_breakecase;
import com.xsjsglxt.domain.DO.xsjsglxt_breakecasesuspect;
import com.xsjsglxt.service.Case.BreakecaseService;

import util.TeamUtil;

public class BreakecaseServiceImpl implements BreakecaseService {
	private BreakecaseDao breakecaseDao;

	public BreakecaseDao getBreakecaseDao() {
		return breakecaseDao;
	}

	public void setBreakecaseDao(BreakecaseDao breakecaseDao) {
		this.breakecaseDao = breakecaseDao;
	}

	@Override
	public boolean saveBreakeCase(xsjsglxt_breakecase breakeCase, List<xsjsglxt_breakecasesuspect> suspectList) {
		// TODO Auto-generated method stub
		breakeCase.setXsjsglxt_breakecase_id(TeamUtil.getUuid());
		breakeCase.setBreakecase_gmt_create(TeamUtil.getStringSecond());
		breakeCase.setBreakecase_gmt_modified(TeamUtil.getStringSecond());
		String result = breakecaseDao.saveBreakeCase(breakeCase);
		if (suspectList != null && suspectList.size() > 0)
			for (xsjsglxt_breakecasesuspect xsjsglxt_breakecasesuspect : suspectList) {
				xsjsglxt_breakecasesuspect.setXsjsglxt_breakecaseSuspect_id(TeamUtil.getStringSecond());
				xsjsglxt_breakecasesuspect.setBreakecaseSuspect_gmt_create(TeamUtil.getStringSecond());
				xsjsglxt_breakecasesuspect.setBreakecaseSuspect_gmt_modified(TeamUtil.getStringSecond());
				xsjsglxt_breakecasesuspect.setBreakecaseSuspect_breakecase(result);
				String suspectResult = breakecaseDao.saveBreakecaseSuspect(xsjsglxt_breakecasesuspect);
			}

		if (result != null && !"".equals(result.trim()))
			return true;
		else
			return false;
	}

}
