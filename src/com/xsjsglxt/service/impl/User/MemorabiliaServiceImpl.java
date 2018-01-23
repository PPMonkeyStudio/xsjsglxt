package com.xsjsglxt.service.impl.User;

import com.xsjsglxt.dao.User.MemorabiliaDao;
import com.xsjsglxt.domain.DO.xsjsglxt_memorabilia;
import com.xsjsglxt.service.User.MemorabiliaService;

public class MemorabiliaServiceImpl implements MemorabiliaService {
	private MemorabiliaDao memorabiliaDao;

	public MemorabiliaDao getMemorabiliaDao() {
		return memorabiliaDao;
	}

	public void setMemorabiliaDao(MemorabiliaDao memorabiliaDao) {
		this.memorabiliaDao = memorabiliaDao;
	}

	@Override
	public String saveMemorabilia(xsjsglxt_memorabilia memorabilia) {
		// TODO Auto-generated method stub

		return memorabiliaDao.saveMemorablilia(memorabilia);
	}

	@Override
	public String updateMemorabilia(xsjsglxt_memorabilia memorabilia) {
		// TODO Auto-generated method stub
		return memorabiliaDao.updateMemorabilia(memorabilia);
	}

	@Override
	public String delteMemorabilia(String memorabilia_id) {
		// TODO Auto-generated method stub
		return memorabiliaDao.deleteMemorabiliaById(memorabilia_id);
	}

	@Override
	public xsjsglxt_memorabilia getMemorabiliaById(String memorabilia_id) {
		// TODO Auto-generated method stub
		return memorabiliaDao.getMemorabiliaById(memorabilia_id);
	}
}
