package com.xsjsglxt.service.Case;

import java.util.List;

import com.xsjsglxt.domain.DO.xsjsglxt_breakcase;
import com.xsjsglxt.domain.DO.xsjsglxt_briefdetails;
import com.xsjsglxt.domain.VO.Case.page_list_BreakecaseInformationVO;

public interface BreakCaseService {

	public void saveBreakCaseInfo(xsjsglxt_breakcase breakCase, xsjsglxt_briefdetails briefDetails);

	public boolean removeBreakCaseInfo(List<String> breakCaseInIdList);

	public void updateBreakCase(xsjsglxt_breakcase breakCase, xsjsglxt_briefdetails briefDetails);

	public page_list_BreakecaseInformationVO VO_BreakecaseInformation_By_PageAndSearch(
			page_list_BreakecaseInformationVO page_list_BreakecaseInformation);

}
