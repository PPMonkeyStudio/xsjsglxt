package com.xsjsglxt.dao.Technology;

import java.util.List;

import com.xsjsglxt.domain.DO.xsjsglxt_equipment;
import com.xsjsglxt.domain.VO.Technology.EquipmentVO;

public interface EquipmentDao {

	int saveEquipment(xsjsglxt_equipment equipment);
	
	int count_equipment_all(EquipmentVO equipmentVO);

	int deleteEquipment(String xsjsglxt_equipment_id);

	int modifiedEquipment(xsjsglxt_equipment equipment);

	xsjsglxt_equipment get_equipment(String xsjsglxt_equipment_id);

	List<xsjsglxt_equipment> list_xsjsglxt_equipment(EquipmentVO equipmentVO);

	int getMaxSerialNum();

}
