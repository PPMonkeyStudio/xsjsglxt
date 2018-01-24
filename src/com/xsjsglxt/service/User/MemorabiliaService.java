package com.xsjsglxt.service.User;

import com.xsjsglxt.domain.DO.xsjsglxt_memorabilia;
import com.xsjsglxt.domain.VO.User.memorabiliaByPageAndSearchVO;

public interface MemorabiliaService {

	String saveMemorabilia(xsjsglxt_memorabilia memorabilia);

	String updateMemorabilia(xsjsglxt_memorabilia memorabilia);

	String delteMemorabilia(String memorabilia_id);

	xsjsglxt_memorabilia getMemorabiliaById(String memorabilia_id);

	memorabiliaByPageAndSearchVO getMemorabiliaByList(memorabiliaByPageAndSearchVO memorabiliaVO);

}
