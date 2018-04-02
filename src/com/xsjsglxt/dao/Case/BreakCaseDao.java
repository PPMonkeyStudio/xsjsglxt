package com.xsjsglxt.dao.Case;

import java.util.List;

import com.xsjsglxt.domain.DO.xsjsglxt_breakcase;
import com.xsjsglxt.domain.DO.xsjsglxt_breakecase;
import com.xsjsglxt.domain.DO.xsjsglxt_briefdetails;
import com.xsjsglxt.domain.DO.xsjsglxt_case;
import com.xsjsglxt.domain.DO.xsjsglxt_snece;
import com.xsjsglxt.domain.VO.Case.page_list_BreakecaseInformationVO;

public interface BreakCaseDao {

	void saveBreakecase(xsjsglxt_breakcase breakCase);

	Boolean deleteBreakCaseById(String breakcase_id);
	
	void updateBreakCase(xsjsglxt_breakcase breakCase);

	void saveBriefDetails(xsjsglxt_briefdetails details);

	xsjsglxt_breakcase getBreakCaseById(String breakcase_id);

	void deleteBriefDetailsById(String breakcase_case_note);

	xsjsglxt_briefdetails getBriedDetailsById(String case_note_id);

	void updateBriefDetails(xsjsglxt_briefdetails briefDetails);

	int getCountBreakecaseInformationByPage(page_list_BreakecaseInformationVO page_list_BreakecaseInformation);

	List<xsjsglxt_breakcase> getListBreakecaseInformatioByPage(
			page_list_BreakecaseInformationVO page_list_BreakecaseInformation);

	xsjsglxt_case get_case_ByBreakecaseId(xsjsglxt_breakcase breakecase);

	xsjsglxt_snece get_sence_Byxsjsglxt_case_id(xsjsglxt_case case1);

//	xsjsglxt_breakcase getBreakCaseInfo(xsjsglxt_breakcase breakCase);


}
