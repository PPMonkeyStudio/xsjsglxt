package xsjsglxt;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xsjsglxt.dao.Case.SenceDao;
import com.xsjsglxt.domain.DO.xsjsglxt_case;
import com.xsjsglxt.domain.DO.xsjsglxt_parallel;
import com.xsjsglxt.domain.VO.Case.page_list_CasematerialVO;
import com.xsjsglxt.domain.VO.Case.page_list_senceInformationVO;
import com.xsjsglxt.service.Case.LostService;
import com.xsjsglxt.service.Case.ParallelService;
import com.xsjsglxt.service.Case.SenceService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext*.xml" })
public class Casetest {
	@Resource
	private SenceService senceService;

	
	public void setSenceService(SenceService senceService) {
		this.senceService = senceService;
	}
@Resource
private SenceDao senceDao;

	
	public void setSenceDao(SenceDao senceDao) {
	this.senceDao = senceDao;
}
	@Resource
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Test
	public void test(){
//		xsjsglxt_case Case=new xsjsglxt_case();
//		Case.setCase_address("sdsvda");
//		senceService.save(Case);
//		System.out.println(senceService);
	}
	@Test
	public void test1(){
		System.out.println(senceService.getMaxSenceInquestId());
	}
	@Test
	public void test2(){
		page_list_senceInformationVO page_list_senceInformation=new page_list_senceInformationVO();
		page_list_senceInformation.setCase_totalCategory("FHJVF");
	int i=	senceDao.getCountSenceInformationByPage(page_list_senceInformation);
	System.out.println(i);
	}
	@Test
	public void test3(){
		System.out.println(senceService.getMaxSenceInquestId());
	}
	@Test
	public void tesrr(){
//		page_list_senceInformationVO page_list_senceInformation=new page_list_senceInformationVO();
//		//page_list_senceInformation.setCase_classify("类别");
//		page_list_senceInformation.setStart_time("2017-11-20");
//		page_list_senceInformation.setStop_time("2017-11-30");
//		
//		//page_list_senceInformation.setSnece_inquestPerson("����ƽ");
//		//System.out.println(senceDao.getCountSenceInformationByPage(page_list_senceInformation));
//		senceService.VO_SneceInformation_By_PageAndSearch(page_list_senceInformation);
//	  System.out.println(page_list_senceInformation.getTotalRecords());
	  
	
	}
	@Resource
	private ParallelService parallelService;


	public void setParallelService(ParallelService parallelService) {
		this.parallelService = parallelService;
	}
	@Test
	public void save(){
	    String caeNumList="1,2,3,4,5,6,7";
	    xsjsglxt_parallel parallel=new xsjsglxt_parallel();
	    parallel.setParallel_accordingAddress("fggn");
		parallelService.saveParallel(caeNumList, parallel);
		
	}
	@Resource
	private LostService lostService;


	public void setLostService(LostService lostService) {
		this.lostService = lostService;
	}
	@Test
	public void t(){
		page_list_CasematerialVO page_list_Casematerial=new page_list_CasematerialVO();
	page_list_Casematerial.setLost_name("2");
		
		lostService.VO_Lostformation_By_PageAndSearch(page_list_Casematerial);
	}
}
