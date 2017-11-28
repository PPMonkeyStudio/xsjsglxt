package com.xsjsglxt.dao.Case;

import java.util.List;

import com.xsjsglxt.domain.DO.xsjsglxt_case;
import com.xsjsglxt.domain.DO.xsjsglxt_parallel;
import com.xsjsglxt.domain.VO.Case.page_list_parallelInformationVO;

public interface ParallelDao {

public 	void saveparallel(xsjsglxt_parallel parallel);



public void save(xsjsglxt_case xsjsglxt_case);



public com.xsjsglxt.domain.DO.xsjsglxt_case getCaseByNum(String case_id);



public int getCountParallelInformationByPage(page_list_parallelInformationVO page_list_parallelInformation);



public List<xsjsglxt_parallel> getListParallelInformatioByPage(
		page_list_parallelInformationVO page_list_parallelInformation);









}
