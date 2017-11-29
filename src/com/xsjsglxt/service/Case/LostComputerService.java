package com.xsjsglxt.service.Case;

import com.xsjsglxt.domain.DO.xsjsglxt_lost_computer;
import com.xsjsglxt.domain.VO.Case.page_list_CasematerialVO;

public interface LostComputerService {

public	void saveLostComputer(xsjsglxt_lost_computer lost_computer);

public page_list_CasematerialVO VO_LostComputerformation_By_PageAndSearch(
		page_list_CasematerialVO page_list_Casematerial);

}
