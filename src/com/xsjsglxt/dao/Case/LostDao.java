package com.xsjsglxt.dao.Case;

import java.util.List;

import com.xsjsglxt.domain.DO.xsjsglxt_case;
import com.xsjsglxt.domain.DO.xsjsglxt_lost;
import com.xsjsglxt.domain.DO.xsjsglxt_snece;
import com.xsjsglxt.domain.VO.Case.page_list_CasematerialVO;

public interface LostDao {
/*
 * ±£´æËðÊ§ÎïÆ·
 */
public 	void save(xsjsglxt_lost lost);

public int getCountLostInformationByPage(page_list_CasematerialVO page_list_Casematerial);

public List<xsjsglxt_lost> getListLostInformatioByPage(page_list_CasematerialVO page_list_Casematerial);

public xsjsglxt_case getCaseByxsjsglxt_lost_id(xsjsglxt_lost lost);

public xsjsglxt_snece getSenceByxsjsglxt_case_id(xsjsglxt_case case1);

public xsjsglxt_lost getLostById(xsjsglxt_lost lost);

}
