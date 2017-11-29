package com.xsjsglxt.dao.Case;

import java.util.List;

import com.xsjsglxt.domain.DO.xsjsglxt_case;
import com.xsjsglxt.domain.DO.xsjsglxt_lost_mobilephone;
import com.xsjsglxt.domain.DO.xsjsglxt_snece;
import com.xsjsglxt.domain.VO.Case.page_list_CasematerialVO;

public interface LostMobilephoneDao {

public 	void saveLostMobilephone(xsjsglxt_lost_mobilephone lost_mobilephone);

public int getCountLostMobilephoneInformationByPage(page_list_CasematerialVO page_list_Casematerial);

public List<xsjsglxt_lost_mobilephone> getListLostMobilephoneInformatioByPage(
		page_list_CasematerialVO page_list_Casematerial);

public xsjsglxt_case getCaseByxsjsglxt_lost_mobilephone_id(xsjsglxt_lost_mobilephone lost_mobilephone);

public xsjsglxt_snece getSenceByxsjsglxt_case_id(xsjsglxt_case case1);

}
