
package com.xsjsglxt.service.Case;

import java.util.List;

import com.xsjsglxt.domain.DO.xsjsglxt_breakecase;
import com.xsjsglxt.domain.DO.xsjsglxt_breakecasesuspect;
import com.xsjsglxt.domain.DO.xsjsglxt_takeBreakeCase;
import com.xsjsglxt.domain.VO.Case.BreakeCaseDetailsVO;
import com.xsjsglxt.domain.VO.Case.BreakeCaseListVO;

public interface BreakecaseService {

	boolean saveBreakeCase(xsjsglxt_breakecase breakeCase, List<xsjsglxt_breakecasesuspect> suspectList);

	boolean deleteBreakeCase(String[] breakeCaseId);

	String addOneSuspect(xsjsglxt_breakecasesuspect suspect);

	boolean deleteSuspect(String[] suspectId);

	boolean updateBreakeCase(xsjsglxt_breakecase breakeCase);

	boolean updateSuspect(xsjsglxt_breakecasesuspect suspect);

	BreakeCaseDetailsVO getBreakeCaseDetails(String xsjsglxt_breakecase_id);

	List<xsjsglxt_breakecase> getBreakeCaseByCaseId(xsjsglxt_breakecase breakeCase);

	void breakeCaseByPage(BreakeCaseListVO breakeCaseListVO);

	void saveTakeBreakeCase(String[] takeBreakeCase, xsjsglxt_breakecase breakeCase);

	List<xsjsglxt_takeBreakeCase> getTakeBreakeCaseByBreakeCaseId(String xsjsglxt_breakecase_id);

}
