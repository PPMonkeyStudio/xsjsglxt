package com.xsjsglxt.dao.Case;

import java.util.List;

import com.xsjsglxt.domain.DO.xsjsglxt_breakecase;
import com.xsjsglxt.domain.DO.xsjsglxt_breakecasesuspect;

public interface BreakecaseDao {

	String saveBreakeCase(xsjsglxt_breakecase breakeCase);

	String saveBreakecaseSuspect(xsjsglxt_breakecasesuspect xsjsglxt_breakecasesuspect);

	boolean deleteBreakeCase(String string);

	boolean deleteSuspectByCaseId(String string);

	boolean addOneSuspect(xsjsglxt_breakecasesuspect suspect);

	void deleteSuspectBySuspectId(xsjsglxt_breakecasesuspect suspect);

	boolean updateBreakeCase(xsjsglxt_breakecase breakeCase);

	xsjsglxt_breakecase getBreakeCase(String xsjsglxt_breakecase_id);

	xsjsglxt_breakecasesuspect getBreakeCaseSuspect(String xsjsglxt_breakecaseSuspect_id);

	boolean updateBreakeCaseSuspect(xsjsglxt_breakecasesuspect suspect);

	List<xsjsglxt_breakecasesuspect> getBreakeCaseSuspectByBreakeCaseId(String xsjsglxt_breakecase_id);

}
