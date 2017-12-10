package com.xsjsglxt.service.Case;

import com.xsjsglxt.domain.DO.xsjsglxt_breakecase;
import com.xsjsglxt.domain.DO.xsjsglxt_case;
import com.xsjsglxt.domain.DTO.Case.BreakecaseInformationDTO;
import com.xsjsglxt.domain.VO.Case.page_list_BreakecaseInformationVO;

public interface BreakecaseService {

public	void saveBreakecase(xsjsglxt_breakecase breakecase);

public page_list_BreakecaseInformationVO VO_BreakecaseInformation_By_PageAndSearch(
		page_list_BreakecaseInformationVO page_list_BreakecaseInformation);

public BreakecaseInformationDTO BreakecaseInformationOne(xsjsglxt_case case1);

}
