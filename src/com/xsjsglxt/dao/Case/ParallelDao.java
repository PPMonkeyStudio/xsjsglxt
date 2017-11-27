package com.xsjsglxt.dao.Case;

import com.xsjsglxt.domain.DO.xsjsglxt_case;
import com.xsjsglxt.domain.DO.xsjsglxt_parallel;

public interface ParallelDao {

public 	void saveparallel(xsjsglxt_parallel parallel);



public void save(xsjsglxt_case xsjsglxt_case);



public com.xsjsglxt.domain.DO.xsjsglxt_case getCaseByNum(String case_id);









}
