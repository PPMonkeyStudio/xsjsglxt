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
import com.xsjsglxt.domain.DO.xsjsglxt_staff;
import com.xsjsglxt.domain.VO.Case.page_list_CasematerialVO;
import com.xsjsglxt.domain.VO.Case.page_list_senceInformationVO;
import com.xsjsglxt.domain.VO.Team.page_list_staffInformationVO;
import com.xsjsglxt.service.Case.ImageService;
import com.xsjsglxt.service.Case.LostService;
import com.xsjsglxt.service.Case.ParallelService;
import com.xsjsglxt.service.Case.SenceService;
import com.xsjsglxt.service.Team.StaffService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext*.xml" })
public class Casetest {
@Resource
private StaffService staffService;

public void setStaffService(StaffService staffService) {
	this.staffService = staffService;
}
@Test
public void s(){
	xsjsglxt_staff staff=new xsjsglxt_staff();
	staff.setStaff_age("18");
	staffService.saveStaff(staff);
	
}
}
