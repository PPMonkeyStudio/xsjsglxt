package com.xsjsglxt.service.Case;

import java.util.List;

import com.xsjsglxt.domain.DO.xsjsglxt_case;
import com.xsjsglxt.domain.DO.xsjsglxt_parallel;
import com.xsjsglxt.domain.VO.Case.page_list_parallelInformationVO;

public interface ParallelService {

public void saveParallel(List<String> CaseNumList, xsjsglxt_parallel parallel);

public page_list_parallelInformationVO VO_Parallelformation_By_PageAndSearch(
		page_list_parallelInformationVO page_list_parallelInformation);
}
