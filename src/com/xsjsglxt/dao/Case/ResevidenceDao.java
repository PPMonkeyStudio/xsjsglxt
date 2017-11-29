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

}
