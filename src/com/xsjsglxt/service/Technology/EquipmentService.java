package com.xsjsglxt.service.Technology;

import java.util.List;

import com.xsjsglxt.domain.DO.xsjsglxt_equipment;
import com.xsjsglxt.domain.VO.Technology.EquipmentVO;

public interface EquipmentService {

	int saveEquipment(xsjsglxt_equipment equipment);

	int deleteEquipment(String xsjsglxt_equipment_id);

	int deleteListEquipment(List<String> listDeleteEquipmentID);

	int modifiedEquipment(xsjsglxt_equipment equipment);

	xsjsglxt_equipment get_equipment(String xsjsglxt_equipment_id);

	EquipmentVO list_xsjsglxt_equipment(EquipmentVO equipmentVO);

}
