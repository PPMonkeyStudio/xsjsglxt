package com.xsjsglxt.dao.Case;

import com.xsjsglxt.domain.DO.xsjsglxt_breakecase;
import com.xsjsglxt.domain.DO.xsjsglxt_breakecasesuspect;

public interface BreakecaseDao {

	String saveBreakeCase(xsjsglxt_breakecase breakeCase);

	String saveBreakecaseSuspect(xsjsglxt_breakecasesuspect xsjsglxt_breakecasesuspect);

	boolean deleteBreakeCase(String string);

	boolean deleteSuspectByCaseId(String string);

}
