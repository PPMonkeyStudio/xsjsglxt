package com.xsjsglxt.service.impl.User;

import java.util.List;

import com.xsjsglxt.dao.User.MemorabiliaDao;
import com.xsjsglxt.domain.DO.xsjsglxt_memorabilia;
import com.xsjsglxt.domain.DTO.User.memorabiliaListDTO;
import com.xsjsglxt.domain.VO.User.memorabiliaByPageAndSearchVO;
import com.xsjsglxt.service.User.MemorabiliaService;

import util.TeamUtil;

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
		memorabilia.setMemorabilia_id(TeamUtil.getUuid());
		memorabilia.setMemorabilia_gmt_create(TeamUtil.getStringSecond());
		memorabilia.setMemorabilia_gmt_modified(TeamUtil.getStringSecond());
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

	@Override
	public memorabiliaByPageAndSearchVO getMemorabiliaByList(memorabiliaByPageAndSearchVO memorabiliaVO) {
		// TODO Auto-generated method stub

		int count = memorabiliaDao.getMemorabiliaCount(memorabiliaVO);
		double c = count;
		memorabiliaVO.setPageCount((int) Math.ceil(c / memorabiliaVO.getPageSize()));
		memorabiliaVO.setTotalCount(count);
		List<memorabiliaListDTO> list = memorabiliaDao.getMemorabiliaByPageAndSearch(memorabiliaVO);
		memorabiliaVO.setMemorabiliaListDTO(list);
		return memorabiliaVO;
	}
}
