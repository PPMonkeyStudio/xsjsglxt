
package com.xsjsglxt.service.Case;

import java.util.List;

import com.xsjsglxt.domain.DO.xsjsglxt_breakecase;
import com.xsjsglxt.domain.DO.xsjsglxt_breakecasesuspect;
import com.xsjsglxt.domain.VO.Case.BreakeCaseDetailsVO;

public interface BreakecaseService {

	boolean saveBreakeCase(xsjsglxt_breakecase breakeCase, List<xsjsglxt_breakecasesuspect> suspectList);

	boolean deleteBreakeCase(String[] breakeCaseId);

	boolean addOneSuspect(xsjsglxt_breakecasesuspect suspect);

	boolean deleteSuspect(String[] suspectId);

	boolean updateBreakeCase(xsjsglxt_breakecase breakeCase);

	boolean updateSuspect(xsjsglxt_breakecasesuspect suspect);

	BreakeCaseDetailsVO getBreakeCaseDetails(String xsjsglxt_breakecase_id);

}
