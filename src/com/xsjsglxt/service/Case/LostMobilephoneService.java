package com.xsjsglxt.service.Case;

import com.xsjsglxt.domain.DO.xsjsglxt_lost_mobilephone;
import com.xsjsglxt.domain.DTO.Case.LostMobilephoneInformationDTO;
import com.xsjsglxt.domain.VO.Case.page_list_CasematerialVO;

public interface LostMobilephoneService {

public	void saveLostMobilephone(xsjsglxt_lost_mobilephone lost_mobilephone);

public page_list_CasematerialVO VO_LostMobilephoneformation_By_PageAndSearch(
		page_list_CasematerialVO page_list_Casematerial);

public LostMobilephoneInformationDTO LostMobiephoneInformationOne(xsjsglxt_lost_mobilephone lost_mobilephone);
/*
 * 修改损失手机信息
 */
public void updateParallel(xsjsglxt_lost_mobilephone lost_mobilephone);

}
