package com.xsjsglxt.service.impl.Case;

import com.xsjsglxt.dao.Case.BreakecaseDao;
import com.xsjsglxt.service.Case.BreakecaseService;

public class BreakecaseServiceImpl implements BreakecaseService {
	private BreakecaseDao breakecaseDao;

	public BreakecaseDao getBreakecaseDao() {
		return breakecaseDao;
	}

	public void setBreakecaseDao(BreakecaseDao breakecaseDao) {
		this.breakecaseDao = breakecaseDao;
	}

}
