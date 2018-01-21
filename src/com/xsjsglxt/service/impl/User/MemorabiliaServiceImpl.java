package com.xsjsglxt.service.impl.User;

import com.xsjsglxt.dao.User.MemorabiliaDao;
import com.xsjsglxt.service.User.MemorabiliaService;

public class MemorabiliaServiceImpl implements MemorabiliaService {
	private MemorabiliaDao memorabiliaDao;

	public MemorabiliaDao getMemorabiliaDao() {
		return memorabiliaDao;
	}

	public void setMemorabiliaDao(MemorabiliaDao memorabiliaDao) {
		this.memorabiliaDao = memorabiliaDao;
	}
}
