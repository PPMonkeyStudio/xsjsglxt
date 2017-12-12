package xsjsglxt;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xsjsglxt.dao.Case.SenceDao;
import com.xsjsglxt.domain.DO.xsjsglxt_briefdetails;
import com.xsjsglxt.domain.DO.xsjsglxt_case;
import com.xsjsglxt.domain.DO.xsjsglxt_parallel;
import com.xsjsglxt.domain.VO.Case.page_list_CasematerialVO;
import com.xsjsglxt.domain.VO.Case.page_list_senceInformationVO;
import com.xsjsglxt.service.Case.ImageService;
import com.xsjsglxt.service.Case.LostService;
import com.xsjsglxt.service.Case.ParallelService;
import com.xsjsglxt.service.Case.SenceService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext*.xml" })
public class Casetest {
	@Resource
	private SenceService senceService;
	private	xsjsglxt_briefdetails briefdetails;
	
	public xsjsglxt_briefdetails getBriefdetails() {
		return briefdetails;
	}
	public void setBriefdetails(xsjsglxt_briefdetails briefdetails) {
		this.briefdetails = briefdetails;
	}
	public void setSenceService(SenceService senceService) {
		this.senceService = senceService;
	}
	@Test
	
	public void test(){
	
		String  case1="0f3d9d00-2b01-4a5c-8a53-d8bcfb8a12d1";
		briefdetails.setBriefdetails_details("asaaaaa");
		senceService.updateBriefdetails(briefdetails, case1);
		
	}

}
