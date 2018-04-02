package util;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xsjsglxt.domain.DO.xsjsglxt_dna;
import com.xsjsglxt.domain.DO.xsjsglxt_fingerprint;
import com.xsjsglxt.domain.VO.Technology.DNAVO;
import com.xsjsglxt.domain.VO.Technology.FingerPrintVO;
import com.xsjsglxt.service.Technology.DNAService;
import com.xsjsglxt.service.Technology.FingerPrintService;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations={"classpath:applicationContext*.xml"})
public class FingerPrintTest {
	
	@Resource
	private FingerPrintService fingerPrintService;


	@Test
	/*public void get_dna() {
		System.out.println(fingerPrintService.get_fingerprint("5dbd4269-6a1a-4439-bb8a-c520432dc03b"));
	}*/
	public void list() {
		FingerPrintVO vo = new FingerPrintVO();
		System.out.println(fingerPrintService.list_xsjsglxt_fingerprint(vo));
	}
	/*public void save() {
		xsjsglxt_fingerprint fingerprint = new xsjsglxt_fingerprint();
		fingerprint.setFingerprint_name("sdfjakfj");
		System.out.println(fingerPrintService.saveFingerPrint(fingerprint));
	}*/
	/*public void delete() {
		System.out.println(fingerPrintService.deleteFingerPrint("a7977203-be9c-4bf8-92b4-9a5867f4c60c"));
	}*/
	
}
