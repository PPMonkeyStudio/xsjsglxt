package com.xsjsglxt.service.Case;

import com.xsjsglxt.domain.DO.xsjsglxt_resevidence;
import com.xsjsglxt.domain.VO.Case.page_list_ResevidenceInformationVO;

public interface ResevidenceService {

public void saveResevidence(xsjsglxt_resevidence resevidence);

public page_list_ResevidenceInformationVO VO_Resevidenceformation_By_PageAndSearch(
		page_list_ResevidenceInformationVO page_list_ResevidenceInformation);

}
