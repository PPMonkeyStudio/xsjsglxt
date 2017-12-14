
package com.xsjsglxt.service.impl.Case;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.xsjsglxt.dao.Case.ParallelDao;
import com.xsjsglxt.domain.DO.xsjsglxt_briefdetails;
import com.xsjsglxt.domain.DO.xsjsglxt_case;
import com.xsjsglxt.domain.DO.xsjsglxt_lost;
import com.xsjsglxt.domain.DO.xsjsglxt_lost_computer;
import com.xsjsglxt.domain.DO.xsjsglxt_lost_mobilephone;
import com.xsjsglxt.domain.DO.xsjsglxt_parallel;
import com.xsjsglxt.domain.DO.xsjsglxt_picture;
import com.xsjsglxt.domain.DO.xsjsglxt_resevidence;
import com.xsjsglxt.domain.DO.xsjsglxt_snece;
import com.xsjsglxt.domain.DTO.Case.ParallelInformationDTO;
import com.xsjsglxt.domain.DTO.Case.SenceInformationDTO;
import com.xsjsglxt.domain.VO.Case.page_list_parallelInformationVO;
import com.xsjsglxt.service.Case.ParallelService;

import util.TeamUtil;

public class ParallelServiceImpl implements ParallelService {

	private ParallelDao parallelDao;
	public ParallelDao getParallelDao() {
		return parallelDao;
	}
	public void setParallelDao(ParallelDao parallelDao) {
		this.parallelDao = parallelDao;
	}

	@Override
	public void saveParallel(String caeNumList,xsjsglxt_parallel parallel) {
		// TODO Auto-generated method stub
		parallel.setXsjsglxt_parallel_id(TeamUtil.getUuid());
		parallel.setParallel_gmt_create(TeamUtil.getStringSecond());
		parallel.setParallel_gmt_modified(parallel.getParallel_gmt_create());
		parallelDao.saveparallel(parallel);
		
		List<String> result = Arrays.asList(caeNumList.split(","));  
		System.out.println("a"+caeNumList);
		System.out.println("b"+result);
		for(String Case_id : result){
			xsjsglxt_case xsjsglxt_case = parallelDao.getCaseByNum(Case_id);
			xsjsglxt_case.setCase_parallel(parallel.getXsjsglxt_parallel_id());
			parallelDao.save(xsjsglxt_case);
		}
	}

	@Override
	public page_list_parallelInformationVO VO_Parallelformation_By_PageAndSearch(
			page_list_parallelInformationVO page_list_parallelInformation) {
		// TODO Auto-generated method stub
		List<xsjsglxt_parallel> parallelList = new ArrayList<xsjsglxt_parallel>();
		List<xsjsglxt_parallel> listParallel = new ArrayList<xsjsglxt_parallel>();
		
		
		// 符合筛选条件的记录数
		int i = parallelDao.getCountParallelInformationByPage(page_list_parallelInformation);
		System.out.println(i);
		page_list_parallelInformation.setTotalRecords(i);
		page_list_parallelInformation.setTotalPages(((i - 1) / page_list_parallelInformation.getPageSize()) + 1);
		if (page_list_parallelInformation.getPageIndex() <= 1) {
			page_list_parallelInformation.setHavePrePage(false);
		} else {
			page_list_parallelInformation.setHavePrePage(true);
		}
		if (page_list_parallelInformation.getPageIndex() >= page_list_parallelInformation.getTotalPages()) {
			page_list_parallelInformation.setHaveNextPage(false);
		} else {
			page_list_parallelInformation.setHaveNextPage(true);
		}
		
		// 符合筛选条件的记录
		listParallel = parallelDao.getListParallelInformatioByPage(page_list_parallelInformation);
		for (xsjsglxt_parallel parallel : listParallel) {
	     // 1
		if (page_list_parallelInformation.getParallel_casename() != null&& page_list_parallelInformation.getParallel_casename().trim().length() > 0) {
			parallel.setParallel_casename(parallel.getParallel_casename().replaceAll(parallel.getParallel_casename(),"<span style='color: #ff5063;'>" + parallel.getParallel_casename().trim()+ "</span>" ));
		}
		// 2
		if (page_list_parallelInformation.getParallel_person() != null&& page_list_parallelInformation.getParallel_person().trim().length() > 0) {
			parallel.setParallel_person(parallel.getParallel_person().replaceAll(parallel.getParallel_person(),"<span style='color: #ff5063;'>" + parallel.getParallel_person().trim()+ "</span>" ));
		}
		
		parallelList.add(parallel);
			}
		page_list_parallelInformation.setParallelList(parallelList);
			return page_list_parallelInformation;

	}
	/*
	 * 串并案件的详细信息
	 */
	@Override
	public ParallelInformationDTO ParallelInformationOne(xsjsglxt_parallel parallel) {
		// TODO Auto-generated method stub
		parallel=parallelDao.getparallelById(parallel);
		xsjsglxt_case case1=parallelDao.getcaseByparallelId(parallel);
		 xsjsglxt_snece snece=parallelDao.getsneceByCaseId(case1);
		 xsjsglxt_briefdetails briefdetails=parallelDao.getbriefdetailsByCaseId(case1);
		 xsjsglxt_resevidence resevidence=parallelDao.getresevidenceByCaseId(case1);
		 ParallelInformationDTO parallelInformationDTO=new ParallelInformationDTO(parallel,snece,case1,briefdetails,resevidence);
		return parallelInformationDTO;
	}
	/*
	 * 得到串并号
	 *
	 */
	@Override
	public String getMaxParallelNum() {
		// TODO Auto-generated method stub
		int i = parallelDao.getMaxParallelNum();
		System.out.println("aaaaaaaaa"+i);
		//System.out.println("iiiiii"+i);
		String num = "";
		num = num.format("%04d", i+1);
		Date date = new Date();
		DateFormat format = new SimpleDateFormat("yyyy");
		String time = format.format(date);
		String ParallelNum = time + num  ;
		//System.out.println("SenceInformationInquestIdSenceInformationInquestIdSenceInformationInquestId"+SenceInformationInquestId);
		return ParallelNum;
	}
	/*
	 *修改串并案件信息
	 */
	@Override
	public void updateParallel(xsjsglxt_parallel parallel) {
		// TODO Auto-generated method stub
		parallel.setParallel_gmt_modified(TeamUtil.getStringSecond());
		parallelDao.updateParallel(parallel);
	}
	@Override
	public boolean remove_ParallelInformationList(List<String> useParallelInformationNumList) {
		// TODO Auto-generated method stub
		boolean flag = false;
		for (String parallel_id : useParallelInformationNumList) {
			xsjsglxt_parallel xsjsglxt_parallel = parallelDao.getParallelByNum(parallel_id);
			flag = parallelDao.deleteParallelById(xsjsglxt_parallel.getXsjsglxt_parallel_id());// ����
			
		}
		return flag;
	}


	
}

