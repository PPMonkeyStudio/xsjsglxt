package com.xsjsglxt.service.impl.Technology;

import java.util.List;

import com.xsjsglxt.dao.Technology.EquipmentDao;
import com.xsjsglxt.domain.DO.xsjsglxt_equipment;
import com.xsjsglxt.domain.VO.Technology.EquipmentVO;
import com.xsjsglxt.service.Technology.EquipmentService;

import util.TeamUtil;

public class EquipmentServiceImpl implements EquipmentService {
	
	private EquipmentDao equipmentDao;

	public EquipmentDao getEquipmentDao() {
		return equipmentDao;
	}

	public void setEquipmentDao(EquipmentDao equipmentDao) {
		this.equipmentDao = equipmentDao;
	}

	@Override
	public int saveEquipment(xsjsglxt_equipment equipment) {
		equipment.setXsjsglxt_equipment_id(TeamUtil.getUuid());
		String i = this.create_equipment_serial();
		equipment.setEquipment_serial_number(i);
		equipment.setEquipment_gmt_create(TeamUtil.getStringSecond());
		equipment.setEquipment_gmt_modified(TeamUtil.getStringSecond());
		int result = equipmentDao.saveEquipment(equipment);
		if (result > 0) {
			return 1;
		}
		return 2;
	}

	private String create_equipment_serial() {
		int i = equipmentDao.getMaxSerialNum() + 1;
		String serial = String.valueOf(i);
		return serial;
	}

	@Override
	public int deleteEquipment(String xsjsglxt_equipment_id) {
		int result = equipmentDao.deleteEquipment(xsjsglxt_equipment_id);
		if (result > 0) {
			return 1;
		}
		return 2;
	}

	@Override
	public int deleteListEquipment(List<String> listDeleteEquipmentID) {
		int result = 0;
		for (String equipment_id : listDeleteEquipmentID) {
			result += equipmentDao.deleteEquipment(equipment_id);
		}
		if (result == listDeleteEquipmentID.size()) {
			return 1;
		}
		return 2;
	}

	@Override
	public int modifiedEquipment(xsjsglxt_equipment equipment) {
		equipment.setEquipment_gmt_modified(TeamUtil.getStringSecond());
		int result = equipmentDao.modifiedEquipment(equipment);
		if (result > 0) {
			return 1;
		}
		return 2;
	}

	@Override
	public xsjsglxt_equipment get_equipment(String xsjsglxt_equipment_id) {
		xsjsglxt_equipment equipment = equipmentDao.get_equipment(xsjsglxt_equipment_id);
		return equipment;
	}

	@Override
	public EquipmentVO list_xsjsglxt_equipment(EquipmentVO equipmentVO) {
		int totalRecords = equipmentDao.count_equipment_all(equipmentVO);
		EquipmentVO vo = new EquipmentVO();
		vo.setPageIndex(equipmentVO.getPageIndex());
		vo.setPageSize(equipmentVO.getPageSize());
		vo.setTotalRecords(totalRecords);
		vo.setTotalPages(((totalRecords - 1) / vo.getPageSize()) + 1);
		if (vo.getPageIndex() <= 1) {
			vo.setHavePrePage(false);
		} else {
			vo.setHavePrePage(true);
		}
		if (vo.getPageIndex() >= vo.getTotalPages()) {
			vo.setHaveNextPage(false);
		} else {
			vo.setHaveNextPage(true);
		}
		List<xsjsglxt_equipment> list = equipmentDao.list_xsjsglxt_equipment(equipmentVO);
		for (xsjsglxt_equipment equipment : list) {
			if (equipmentVO.getSearch() != null && equipmentVO.getSearch().trim().length() > 0) {
				equipment.setEquipment_serial_number(equipment.getEquipment_serial_number().replaceAll(equipmentVO.getSearch(),
						"<span style='color: #ff5063;'>" + equipmentVO.getSearch() + "</span>"));
				equipment.setEquipment_name(equipment.getEquipment_name().replaceAll(equipmentVO.getSearch(),
						"<span style='color: #ff5063;'>" + equipmentVO.getSearch() + "</span>"));
			}
		}
		vo.setList_xsjsglxt_equipment(list);
		return vo;
	}

}
