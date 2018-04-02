package com.xsjsglxt.service.impl.Team;

import java.util.List;

import com.xsjsglxt.dao.Team.StaffFamilyDao;
import com.xsjsglxt.domain.DO.xsjsglxt_staffFamily;
import com.xsjsglxt.service.Team.StaffFamilyService;

import util.TeamUtil;

public class StaffFamilyServiceImpl implements StaffFamilyService {
	private StaffFamilyDao staffFamilyDao;

	public StaffFamilyDao getStaffFamilyDao() {
		return staffFamilyDao;
	}

	public void setStaffFamilyDao(StaffFamilyDao staffFamilyDao) {
		this.staffFamilyDao = staffFamilyDao;
	}

	// saveFamily
	@Override
	public String saveFamily(List<xsjsglxt_staffFamily> familys) {
		// TODO Auto-generated method stub

		for (xsjsglxt_staffFamily xsjsglxt_staffFamily : familys) {
			xsjsglxt_staffFamily.setXsjsglxt_staffFamily_id(TeamUtil.getUuid());
			xsjsglxt_staffFamily.setStaffFamily_gmt_create(TeamUtil.getStringSecond());
			xsjsglxt_staffFamily.setStaffFamily_gmt_modified(TeamUtil.getStringSecond());
		}
		String result = staffFamilyDao.saveFamily(familys);
		return result;
	}

	// delteFamilyByFamily
	/*
	 * 删除前未检测数据是否存在，并发情况下会存在bug
	 */
	@Override
	public String deleteFamilyByFamilyId(xsjsglxt_staffFamily family) {
		// TODO Auto-generated method stub
		String result = staffFamilyDao.deleteFamilyByFamilyId(family);
		return result;
	}

	// 删除家庭成员信息通过警员id
	@Override
	public String deleteFamilyByStaffId(xsjsglxt_staffFamily family) {
		// TODO Auto-generated method stub
		String result = staffFamilyDao.deleteFamilyByStaffId(family);
		return result;
	}

	// 第一次查询获得的持久化类可以直接进行修改并在事务结束后保存到数据库中

	@Override
	public String updateFamily(xsjsglxt_staffFamily family) {
		// TODO Auto-generated method stub
		xsjsglxt_staffFamily oldFamily = staffFamilyDao.getFamilyByFamilyID(family.getXsjsglxt_staffFamily_id());
		family.setStaffFamily_staff(oldFamily.getStaffFamily_staff());
		family.setStaffFamily_gmt_create(oldFamily.getStaffFamily_gmt_create());
		family.setStaffFamily_gmt_modified(TeamUtil.getStringSecond());
		String result = staffFamilyDao.updateFamilyByFamilyId(family);
		return "updateSuccess";
	}

	@Override
	public xsjsglxt_staffFamily getFamilyByFamilyId(String xsjsglxt_staffFamily_id) {
		// TODO Auto-generated method stub
		return staffFamilyDao.getFamilyByFamilyID(xsjsglxt_staffFamily_id);
	}

	@Override
	public List<xsjsglxt_staffFamily> getFamilyByStaffId(String staffFamily_staff) {
		// TODO Auto-generated method stub

		List<xsjsglxt_staffFamily> familyList = staffFamilyDao.getFamilyByStaffId(staffFamily_staff);

		return familyList;
	}

}
