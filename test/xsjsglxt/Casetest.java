package xsjsglxt;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xsjsglxt.domain.VO.Case.page_list_HandleInformationVO;
import com.xsjsglxt.service.Case.HandleService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext*.xml" })
public class Casetest {
@Resource
private HandleService handleService;


public void setHandleService(HandleService handleService) {
	this.handleService = handleService;
}


@Test
public void s(){
	page_list_HandleInformationVO page_list_HandleInformation=new page_list_HandleInformationVO();
	page_list_HandleInformation.setHandle_administrativeCase("1");
	handleService.VO_HandleInformation_By_PageAndSearch(page_list_HandleInformation);
	
}

}
