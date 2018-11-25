package com.xsjsglxt.dao.Case;

import java.util.List;

import com.xsjsglxt.domain.DO.xsjsglxt_briefdetails;
import com.xsjsglxt.domain.DO.xsjsglxt_case;
import com.xsjsglxt.domain.DO.xsjsglxt_parallel;
import com.xsjsglxt.domain.DO.xsjsglxt_resevidence;
import com.xsjsglxt.domain.DO.xsjsglxt_snece;
import com.xsjsglxt.domain.VO.Case.page_list_parallelInformationVO;

public interface ParallelDao {

public 	void saveparallel(xsjsglxt_parallel parallel);



public void save(xsjsglxt_case xsjsglxt_case);



public com.xsjsglxt.domain.DO.xsjsglxt_case getCaseByNum(String case_id);



public int getCountParallelInformationByPage(page_list_parallelInformationVO page_list_parallelInformation);



public List<xsjsglxt_parallel> getListParallelInformatioByPage(
		page_list_parallelInformationVO page_list_parallelInformation);



public xsjsglxt_parallel getparallelById(xsjsglxt_parallel parallel);



public List<xsjsglxt_case> getcaseByparallelId(xsjsglxt_parallel parallel);



public xsjsglxt_snece getsneceByCaseId(xsjsglxt_case case1);



public xsjsglxt_briefdetails getbriefdetailsByCaseId(xsjsglxt_case case1);



public xsjsglxt_resevidence getresevidenceByCaseId(xsjsglxt_case case1);



public int getMaxParallelNum();


/*
 * 修改串并案件信息
 */
public void updateParallel(xsjsglxt_parallel parallel);



public com.xsjsglxt.domain.DO.xsjsglxt_parallel getParallelByNum(String parallel_id);



public boolean deleteParallelById(String xsjsglxt_parallel_id);



public void updateObject(Object object);









}
