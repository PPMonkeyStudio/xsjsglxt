package util;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.xsjsglxt.dao.Technology.DNADao;
import com.xsjsglxt.domain.DO.xsjsglxt_dna;
import com.xsjsglxt.service.Technology.DNAService;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations={"classpath:applicationContext*.xml"})
public class DNATest {
	
	@Resource
	private DNAService dNAService;
	
	@Resource
	private DNADao dao;
	
	
/*	@Test
	public void list() {
		DNAVO vo = new DNAVO();
		System.out.println(dNAService.list_xsjsglxt_dna(vo));
	}*/
	
	/*@Test
	public void modified() {
		xsjsglxt_dna dna = new xsjsglxt_dna();
		dna.setDna_name("45611313132");
		dna.setXsjsglxt_dna_id("6556ea03-6eaa-4b21-9ae5-d850bb3865b3");
		System.out.println(dNAService.modifiedDNA(dna));
		
	}*/

	//@Test
	/*public void get_dna() {
		System.out.println(dNAService.get_dna("6556ea03-6eaa-4b21-9ae5-d850bb3865b3"));
	}*/
	/*public void list() {
		DNAVO dNAVO = new DNAVO();
		System.out.println(dNAService.list_xsjsglxt_dna(dNAVO));
	}*/
	@Test
	public void save() {
		xsjsglxt_dna dna = new xsjsglxt_dna();
		dna.setDna_name("4651312321");
		System.out.println(dNAService.saveDNA(dna));
	}
	/*public void delete() {
		System.out.println(dNAService.deleteDNA("7d21f3be-e0ff-4fa4-8b91-72dcd5ccd80c"));
	}*/
	/*0*/
}
