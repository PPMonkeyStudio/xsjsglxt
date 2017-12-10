package com.xsjsglxt.service.Case;

import com.xsjsglxt.domain.DO.xsjsglxt_lost_computer;
import com.xsjsglxt.domain.DTO.Case.LostComputerInformationDTO;
import com.xsjsglxt.domain.VO.Case.page_list_CasematerialVO;

public interface LostComputerService {

public	void saveLostComputer(xsjsglxt_lost_computer lost_computer);

public page_list_CasematerialVO VO_LostComputerformation_By_PageAndSearch(
		page_list_CasematerialVO page_list_Casematerial);


public LostComputerInformationDTO LostComputerInformationOne(xsjsglxt_lost_computer lost_computer);
/*
 * 修改损失电脑信息
 */
public void updateLostComputer(xsjsglxt_lost_computer lost_computer);

}
