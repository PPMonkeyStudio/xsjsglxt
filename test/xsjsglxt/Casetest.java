package xsjsglxt;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xsjsglxt.dao.Case.SenceDao;
import com.xsjsglxt.domain.DO.xsjsglxt_case;
import com.xsjsglxt.domain.VO.Case.page_list_senceInformationVO;
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
		xsjsglxt_case Case=new xsjsglxt_case();
		Case.setCase_address("sdsvda");
		senceService.save(Case);
		System.out.println(senceService);
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
		page_list_senceInformationVO page_list_senceInformation=new page_list_senceInformationVO();
		//page_list_senceInformation.setCase_classify("类别");
		page_list_senceInformation.setStart_time("2017-11-20");
		page_list_senceInformation.setStop_time("2017-11-27");
		page_list_senceInformation.setCase_classify("类别");
		//System.out.println(senceDao.getCountSenceInformationByPage(page_list_senceInformation));
		senceService.VO_SneceInformation_By_PageAndSearch(page_list_senceInformation);
	  //System.out.println(page_list_senceInformation.getTotalRecords());
	  System.out.println(page_list_senceInformation.getCase_classify());
		//System.out.println("aaa"+senceDao.getCountSenceInformationByPage(page_list_senceInformation));
	}
}
