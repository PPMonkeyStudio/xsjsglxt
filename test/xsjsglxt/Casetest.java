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
	xsjsglxt_case case1 = null;
	case1.setCase_address("江西");
		senceService.save(case1);
		
	}
	@Resource
	private StaffService staffService;
	
	public void setStaffService(StaffService staffService) {
		this.staffService = staffService;
	}
	@Test
	public void t(){
		page_list_staffInformationVO page_list_staffInformation= new page_list_staffInformationVO();
		page_list_staffInformation.setStaff_name("历史");
		staffService.VO_StaffInformation_By_PageAndSearch(page_list_staffInformation);
	}
	@Test
	public void d(){
		xsjsglxt_staff staff=new xsjsglxt_staff();
		//staff.setXsjsglxt_staff_id("f943814d-7cee-4062-bde0-f3c5bebbae6a");
		staff.setStaff_address("jianxi");
		staff.setStaff_thePoliceTime("2017/12/12");
		staffService.saveStaff(staff);
	}
	@Test
	public void i(){
		xsjsglxt_staff staff=new xsjsglxt_staff();
		staff.setXsjsglxt_staff_id("7fddb8c7-aabc-4f96-a219-861031d18a12");
	staff=	staffService.StaffInformationOne(staff);
		System.out.println("kkk"+staff);
	}
	@Test
	public void v(){
		xsjsglxt_staff staff=new xsjsglxt_staff();
		staff.setXsjsglxt_staff_id("7fddb8c7-aabc-4f96-a219-861031d18a13");
		staff.setStaff_age("2");
		staffService.updateStaffInformation(staff);
	}
	@Test
	public void o(){
		List<String> useStaffInformationNumList=new ArrayList<String>();
		xsjsglxt_staff staff=new xsjsglxt_staff();
		useStaffInformationNumList.add("7fddb8c7-aabc-4f96-a219-861031d18a13");
		staffService.remove_StaffInformationList(useStaffInformationNumList);
	}
}
