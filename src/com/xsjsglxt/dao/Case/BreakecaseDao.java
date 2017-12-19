package com.xsjsglxt.dao.Case;

import java.util.List;

import com.xsjsglxt.domain.DO.xsjsglxt_breakecase;
import com.xsjsglxt.domain.DO.xsjsglxt_case;
import com.xsjsglxt.domain.DO.xsjsglxt_snece;
import com.xsjsglxt.domain.VO.Case.page_list_BreakecaseInformationVO;

public interface BreakecaseDao {

public 	void saveBreakecase(xsjsglxt_breakecase breakecase);

public int getCountBreakecaseInformationByPage(page_list_BreakecaseInformationVO page_list_BreakecaseInformation);

public List<xsjsglxt_breakecase> getListBreakecaseInformatioByPage(
		page_list_BreakecaseInformationVO page_list_BreakecaseInformation);

public xsjsglxt_case get_case_ByBreakecaseId(xsjsglxt_breakecase breakecase);

public xsjsglxt_snece get_sence_Byxsjsglxt_case_id(xsjsglxt_case case1);


public xsjsglxt_case getCaseById(xsjsglxt_breakecase breakecase);

public xsjsglxt_snece getSenceByID(xsjsglxt_case case1);

public xsjsglxt_breakecase getBreakecaseById(xsjsglxt_breakecase breakecase);


public void updateCase(xsjsglxt_case case1);

public xsjsglxt_breakecase getByID(String xsjsglxt_case_id);

public void updateBreakcase(xsjsglxt_breakecase breakecase);

public xsjsglxt_snece getByCID(String xsjsglxt_case_id);

public void updateSence(xsjsglxt_snece sence);

public com.xsjsglxt.domain.DO.xsjsglxt_breakecase getBreakecaseByNum(String breakecase_id);

public boolean deleteBreakecaseById(String xsjsglxt_breakecase_id);

}

