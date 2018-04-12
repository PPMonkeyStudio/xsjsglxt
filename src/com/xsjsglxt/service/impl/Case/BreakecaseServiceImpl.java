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

	// 删除破案，连带删除嫌疑人
	@Override
	public boolean deleteBreakeCase(String[] breakeCaseId) {
		// TODO Auto-generated method stub
		boolean result = false;
		boolean resultSus = false;
		for (int i = 0; i < breakeCaseId.length; i++) {
			result = breakecaseDao.deleteBreakeCase(breakeCaseId[i]); // 删除一个案件
			resultSus = breakecaseDao.deleteSuspectByCaseId(breakeCaseId[i]); // 删除所有连带嫌疑人
		}
		return result;
	}

	@Override
	public boolean addOneSuspect(xsjsglxt_breakecasesuspect suspect) {
		// TODO Auto-generated method stub

		suspect.setXsjsglxt_breakecaseSuspect_id(TeamUtil.getUuid());
		suspect.setBreakecaseSuspect_gmt_create(TeamUtil.getStringSecond());
		suspect.setBreakecaseSuspect_gmt_modified(TeamUtil.getStringSecond());
		boolean flag = breakecaseDao.addOneSuspect(suspect);
		return flag;
	}

	@Override
	public boolean deleteSuspect(String[] suspectId) {
		// TODO Auto-generated method stub
		xsjsglxt_breakecasesuspect suspect;
		for (int i = 0; i < suspectId.length; i++) {
			suspect = new xsjsglxt_breakecasesuspect();
			suspect.setXsjsglxt_breakecaseSuspect_id(suspectId[i]);
			breakecaseDao.deleteSuspectBySuspectId(suspect);
		}
		return true;
	}

}
