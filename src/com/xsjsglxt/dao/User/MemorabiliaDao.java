package com.xsjsglxt.dao.User;

import java.util.List;

import com.xsjsglxt.domain.DO.xsjsglxt_memorabilia;
import com.xsjsglxt.domain.DTO.User.memorabiliaListDTO;
import com.xsjsglxt.domain.VO.User.memorabiliaByPageAndSearchVO;

public interface MemorabiliaDao {
	public String saveMemorablilia(xsjsglxt_memorabilia memorabilia);

	String updateMemorabilia(xsjsglxt_memorabilia memorabilia);

	xsjsglxt_memorabilia getMemorabiliaById(String memorabilia_id);

	String deleteMemorabiliaById(String memorabilia_id);

	int getMemorabiliaCount(memorabiliaByPageAndSearchVO memorabiliaVO);

	List<memorabiliaListDTO> getMemorabiliaByPageAndSearch(memorabiliaByPageAndSearchVO memorabiliaVO);
}
