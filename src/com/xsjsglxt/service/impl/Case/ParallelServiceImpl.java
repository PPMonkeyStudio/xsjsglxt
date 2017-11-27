package com.xsjsglxt.service.impl.Case;

import java.util.List;

import com.xsjsglxt.dao.Case.ParallelDao;
import com.xsjsglxt.domain.DO.xsjsglxt_case;
import com.xsjsglxt.domain.DO.xsjsglxt_parallel;
import com.xsjsglxt.service.Case.ParallelService;

import util.TeamUtil;

public class ParallelServiceImpl implements ParallelService {

	private ParallelDao parallelDao;


	

	@Override
	public void saveParallel(List<String> CaseNumList,xsjsglxt_parallel parallel) {
		// TODO Auto-generated method stub
		parallel.setXsjsglxt_parallel_id(TeamUtil.getUuid());
		parallel.setParallel_gmt_create(TeamUtil.getStringSecond());
		parallel.setParallel_gmt_modified(parallel.getParallel_gmt_create());
		parallelDao.saveparallel(parallel);
		for(String Case_id : CaseNumList){
			xsjsglxt_case xsjsglxt_case = parallelDao.getCaseByNum(Case_id);
			xsjsglxt_case.setCase_parallel(parallel.getXsjsglxt_parallel_id());
			parallelDao.save(xsjsglxt_case);
		}
	}


	public ParallelDao getParallelDao() {
		return parallelDao;
	}


	public void setParallelDao(ParallelDao parallelDao) {
		this.parallelDao = parallelDao;
	}


	



	
}
