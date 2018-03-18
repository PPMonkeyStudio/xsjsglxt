package com.xsjsglxt.service.Case;

import java.util.List;

import com.xsjsglxt.domain.DO.xsjsglxt_case;
import com.xsjsglxt.domain.DO.xsjsglxt_parallel;
import com.xsjsglxt.domain.DTO.Case.ParallelInformationDTO;
import com.xsjsglxt.domain.VO.Case.page_list_parallelInformationVO;

public interface ParallelService {

/*
 * 串并案件的列表信息
 */
public page_list_parallelInformationVO VO_Parallelformation_By_PageAndSearch(
		page_list_parallelInformationVO page_list_parallelInformation);
/*
 * 串并案件的详细信息
 */
public ParallelInformationDTO ParallelInformationOne(xsjsglxt_parallel parallel);
/*
 * 获得串并号
 */
public String getMaxParallelNum();
/*
 * 保存串并案件的信息
 */
public void saveParallel(String caeNumList, xsjsglxt_parallel parallel);
/*
 * 修改串并案件的信息
 */
public void updateParallel(xsjsglxt_parallel parallel);
public boolean remove_ParallelInformationList(List<String> useParallelInformationNumList);
}
