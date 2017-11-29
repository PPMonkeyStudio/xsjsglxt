package com.xsjsglxt.service.Case;

import com.xsjsglxt.domain.DO.xsjsglxt_lost;
import com.xsjsglxt.domain.VO.Case.page_list_CasematerialVO;

public interface LostService {
/*
 * 保存损失物品
 */
public 	void saveLost(xsjsglxt_lost lost);

public page_list_CasematerialVO VO_Lostformation_By_PageAndSearch(page_list_CasematerialVO page_list_Casematerial);

}
