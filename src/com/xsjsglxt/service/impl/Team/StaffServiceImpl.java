package com.xsjsglxt.service.impl.Team;

import java.util.List;

import org.junit.Test;

import com.xsjsglxt.dao.Team.StaffDao;
import com.xsjsglxt.domain.DO.xsjsglxt_staff;
import com.xsjsglxt.domain.DTO.Team.policemanListDTO;
import com.xsjsglxt.domain.VO.Team.policemanDutyVO;
import com.xsjsglxt.domain.VO.Team.policemanListVO;
import com.xsjsglxt.service.Team.StaffService;

import util.TeamUtil;

public class StaffServiceImpl implements StaffService {
	private StaffDao staffDao;

	public StaffDao getStaffDao() {
		return staffDao;
	}

	public void setStaffDao(StaffDao staffDao) {
		this.staffDao = staffDao;
	}

	@Override
	public String saveStaff(xsjsglxt_staff policeman) {
		// TODO Auto-generated method stub
		policeman.setXsjsglxt_staff_id(TeamUtil.getUuid());
		policeman.setStaff_gmt_create(TeamUtil.getStringSecond());
		policeman.setStaff_gmt_modified(TeamUtil.getStringSecond());
		String result = staffDao.savePoliceman(policeman);
		return result;
	}

	@Override
	public String deletePoliceman(xsjsglxt_staff policeman) {
		// TODO Auto-generated method stub
		String result = staffDao.deletePoliceman(policeman);
		return result;
	}

	@Override
	public String updatePoliceman(xsjsglxt_staff policeman) {
		// TODO Auto-generated method stub
		policeman.setStaff_gmt_modified(TeamUtil.getStringSecond());
		String result = staffDao.updatePoliceman(policeman);
		return result;
	}

	@Override
	public xsjsglxt_staff getPolicemanByStaffId(String xsjsglxt_staff_id) {
		// TODO Auto-generated method stub
		return staffDao.getPolicemanByStaffId(xsjsglxt_staff_id);
	}

	@Override
	public void getPolicemansByPage(policemanListVO policemanVO) {
		// TODO Auto-generated method stub
		int count = staffDao.getPolicemanCount(policemanVO);
		policemanVO.setTotalPage((int) Math.ceil((double) count / (double) policemanVO.getPageCount()));
		policemanVO.setTotalCount(count);
		List<policemanListDTO> policemans = staffDao.getPolicemansByPage(policemanVO);
		policemanVO.setPolicemans(policemans);
	}

	@Test
	public void getConnect() {
		staffDao.getConnect();
	}

	@Override
	public List<xsjsglxt_staff> getAllPoliceman() {
		// TODO Auto-generated method stub
		List<xsjsglxt_staff> result = staffDao.getAllPoliceman();
		return result;
	}

	@Override
	public policemanDutyVO getSchedulingStaff() {
		// TODO Auto-generated method stub
		String pointer = "leader";
		List<xsjsglxt_staff> leader = staffDao.getSchedulingStaff(pointer);
		pointer = "main";
		List<xsjsglxt_staff> main = staffDao.getSchedulingStaff(pointer);
		pointer = "assistant";
		List<xsjsglxt_staff> assistant = staffDao.getSchedulingStaff(pointer);
		policemanDutyVO pVo = new policemanDutyVO();
		pVo.setStaffLeader(leader);
		pVo.setStaffAssitant(assistant);
		pVo.setStaffMain(main);
		return pVo;
	}
}
