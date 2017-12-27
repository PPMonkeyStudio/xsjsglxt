package com.xsjsglxt.service.Case;

import java.util.List;

import com.xsjsglxt.domain.DO.xsjsglxt_lost;
import com.xsjsglxt.domain.DTO.Case.LostInformationDTO;
import com.xsjsglxt.domain.VO.Case.page_list_CasematerialVO;

public interface LostService {
/*
 * 保存损失物信息
 */
public 	void saveLost(xsjsglxt_lost lost);

public page_list_CasematerialVO VO_Lostformation_By_PageAndSearch(page_list_CasematerialVO page_list_Casematerial);

public LostInformationDTO LostInformationOne(xsjsglxt_lost lost);
/*
 * 修改损失物信息
 */
public void updateLost(xsjsglxt_lost lost);

public boolean remove_LostInformationList(List<String> useLostInformationNumList);

}
