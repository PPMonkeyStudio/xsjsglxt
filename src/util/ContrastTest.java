package util;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xsjsglxt.domain.DO.xsjsglxt_contrast_fingerprint;
import com.xsjsglxt.domain.DO.xsjsglxt_dna;
import com.xsjsglxt.domain.VO.Case.page_list_HandleInformationVO;
import com.xsjsglxt.domain.VO.Technology.DNAVO;
import com.xsjsglxt.service.Case.HandleService;
import com.xsjsglxt.service.Technology.ContrastFingerPrintService;
import com.xsjsglxt.service.Technology.DNAService;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations={"classpath:applicationContext*.xml"})
public class ContrastTest {
	
	@Resource
	private ContrastFingerPrintService contrast;

	@Autowired
	private HandleService handleService;
	@Test
	public void myTest(){
		page_list_HandleInformationVO page_list_HandleInformationVO = new page_list_HandleInformationVO();
		System.out.println(handleService.VO_HandleInformation_By_PageAndSearch(page_list_HandleInformationVO));
	}
	
/*	@Test
	public void list() {
		DNAVO vo = new DNAVO();
		System.out.println(dNAService.list_xsjsglxt_dna(vo));
	}*/
	
	/*@Test
	public void modified() {
		xsjsglxt_contrast_fingerprint contrastFingerPrint = new xsjsglxt_contrast_fingerprint();
		contrastFingerPrint.setContrast_fingerprint_suspecter_name("sdjjfklsj");
		contrastFingerPrint.setContrast_fingerprint_time("2017-11-25");
		contrastFingerPrint.setContrast_fingerprint_id("8f2998ad-ba68-4863-96a9-93fb47cc2d36");
		contrastFingerPrint.setContrast_fingerprint_suspecter_sex("男");
		contrastFingerPrint.setContrast_fingerprint_suspecter_arrested(1);
		System.out.println(contrast.modifiedContrast(contrastFingerPrint));
	}*/

	/*public void get_dna() {
		System.out.println(contrast.get_contrast("8	f2998ad-ba68-4863-96a9-93fb47cc2d36"));
	}*/
	/*public void list() {
		DNAVO dNAVO = new DNAVO();
		System.out.println(dNAService.list_xsjsglxt_dna(dNAVO));
	}*/
	/*public void save() {
		xsjsglxt_contrast_fingerprint contrastFingerPrint = new xsjsglxt_contrast_fingerprint();
		contrastFingerPrint.setContrast_fingerprint_suspecter_name("sdjjfklsj");
		System.out.println(contrast.saveContrast(contrastFingerPrint));
	}*/
	@Test
	public void delete() {
		System.out.println(contrast.deleteContrast("8f2998ad-ba68-4863-96a9-93fb47cc2d36"));
	}
	/*0*/
}
