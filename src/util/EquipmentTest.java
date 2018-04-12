package util;

import java.util.UUID;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xsjsglxt.dao.Technology.EquipmentDao;
import com.xsjsglxt.domain.DO.xsjsglxt_dna;
import com.xsjsglxt.domain.DO.xsjsglxt_equipment;
import com.xsjsglxt.domain.DO.xsjsglxt_fingerprint;
import com.xsjsglxt.domain.VO.Technology.DNAVO;
import com.xsjsglxt.domain.VO.Technology.EquipmentVO;
import com.xsjsglxt.domain.VO.Technology.FingerPrintVO;
import com.xsjsglxt.service.Technology.DNAService;
import com.xsjsglxt.service.Technology.EquipmentService;
import com.xsjsglxt.service.Technology.FingerPrintService;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations={"classpath:applicationContext*.xml"})
public class EquipmentTest {
	
	@Resource
	private EquipmentService equipmentService;
	@Resource
	private EquipmentDao dao;


	@Test
	public void ttt() {
		xsjsglxt_equipment x = new xsjsglxt_equipment();
		x.setXsjsglxt_equipment_id(UUID.randomUUID().toString());
		int i = equipmentService.saveEquipment(x);
		System.out.println(i);
	}
	/*public void get_dna() {
		System.out.println(equipmentService.get_equipment("1416e2cd-f1df-4edd-a336-bf23ab9854cb"));
	}*/
	/*public void list() {
		EquipmentVO vo = new EquipmentVO();
		System.out.println(equipmentService.list_xsjsglxt_equipment(vo));
	}*/
	/*public void save() {
		xsjsglxt_equipment equipment = new xsjsglxt_equipment();
		equipment.setEquipment_name("gggggggggggggggggggggg");
		System.out.println(equipmentService.saveEquipment(equipment));
	}*/
	/*public void delete() {
		System.out.println(equipmentService.deleteEquipment("f4b32b0f-3d9b-420a-b279-fd716888b150"));
	}*/
	/*public void modified() {
		xsjsglxt_equipment equipment = new xsjsglxt_equipment();
		equipment.setEquipment_name("sdfasdfdsffffffffffffffffffffffffffffff");
		equipment.setXsjsglxt_equipment_id("1416e2cd-f1df-4edd-a336-bf23ab9854cb");
		equipment.setEquipment_number(2);
		System.out.println(equipmentService.modifiedEquipment(equipment));
	}*/
	
}
