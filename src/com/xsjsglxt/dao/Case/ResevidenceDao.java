package com.xsjsglxt.dao.Case;

import java.util.List;

import com.xsjsglxt.domain.DO.xsjsglxt_case;
import com.xsjsglxt.domain.DO.xsjsglxt_circulation;
import com.xsjsglxt.domain.DO.xsjsglxt_resevidence;
import com.xsjsglxt.domain.DO.xsjsglxt_snece;
import com.xsjsglxt.domain.VO.Case.page_list_ResevidenceInformationVO;

public interface ResevidenceDao {

public	void save(xsjsglxt_resevidence resevidence);

public int getCountResevidenceInformationByPage(page_list_ResevidenceInformationVO page_list_ResevidenceInformation);

public List<xsjsglxt_resevidence> getListResevidenceInformatioByPage(
		page_list_ResevidenceInformationVO page_list_ResevidenceInformation);

public xsjsglxt_case getCaseByxsjsglxt_resevidence_id(xsjsglxt_resevidence resevidence);

public xsjsglxt_snece getSenceByxsjsglxt_case_id(xsjsglxt_case case1);

public xsjsglxt_circulation getCirculationByxsjsglxt_resevidence_id(xsjsglxt_resevidence resevidence);

public xsjsglxt_resevidence getResevidenceById(xsjsglxt_resevidence resevidence);

public xsjsglxt_case getcaseByresevidenceId(xsjsglxt_resevidence resevidence);

public xsjsglxt_snece getsenceBycase1Id(xsjsglxt_case case1);

public xsjsglxt_circulation getcirculationByresevidenceId(xsjsglxt_resevidence resevidence);

public void saveCirculation(xsjsglxt_circulation circulation);

public xsjsglxt_resevidence getByResevidenceNum(String resevidence_id);

public boolean deleteResevidenceById(String xsjsglxt_resevidence_id);

public boolean deleteCirculationById(String xsjsglxt_resevidence_id);
/*
 * 修改物证信息
 */
public void updateResevidenceIn(xsjsglxt_resevidence resevidence);



}
