package com.xsjsglxt.service.impl.Team;

import java.util.List;

import com.xsjsglxt.dao.Team.StaffMoveDao;
import com.xsjsglxt.domain.DO.xsjsglxt_staffMove;
import com.xsjsglxt.service.Team.StaffMoveService;

import util.TeamUtil;

public class StaffMoveServiceImpl implements StaffMoveService {
	private StaffMoveDao staffMoveDao;

	public StaffMoveDao getStaffMoveDao() {
		return staffMoveDao;
	}

	public void setStaffMoveDao(StaffMoveDao staffMoveDao) {
		this.staffMoveDao = staffMoveDao;
	}

	@Override
	public String saveMove(List<xsjsglxt_staffMove> moves) {
		// TODO Auto-generated method stub
		for (xsjsglxt_staffMove xsjsglxt_staffMove : moves) {
			xsjsglxt_staffMove.setStaffMove_gmt_create(TeamUtil.getStringSecond());
			xsjsglxt_staffMove.setStaffMove_gmt_modified(TeamUtil.getStringSecond());
			xsjsglxt_staffMove.setXsjsglxt_staffMove_id(TeamUtil.getUuid());
		}

		String result = staffMoveDao.saveMove(moves);
		return result;
	}

	@Override
	public String deleteMove(xsjsglxt_staffMove move) {
		// TODO Auto-generated method stub
		String result = staffMoveDao.deleteMove(move);
		return result;
	}

	@Override
	public String deleteMoves(String staffMove_staff) {
		// TODO Auto-generated method stub
		String result = staffMoveDao.deleteMoves(staffMove_staff);
		return result;
	}

	@Override
	public String updateMove(xsjsglxt_staffMove move) {
		// TODO Auto-generated method stub
		xsjsglxt_staffMove oldMove = staffMoveDao.getMoveByMoveId(move.getXsjsglxt_staffMove_id());
		oldMove.setStaffMove_gmt_modified(TeamUtil.getStringSecond());
		oldMove.setStaffMove_guard(move.getStaffMove_guard());
		oldMove.setStaffMove_inTime(move.getStaffMove_inTime());
		oldMove.setStaffMove_outTime(move.getStaffMove_outTime());
		oldMove.setStaffMove_remarks(move.getStaffMove_remarks());
		return "updateSuccess";
	}

	@Override
	public xsjsglxt_staffMove getMoveByMoveId(String xsjsglxt_staffMove_id) {
		// TODO Auto-generated method stub
		return staffMoveDao.getMoveByMoveId(xsjsglxt_staffMove_id);
	}

	@Override
	public List<xsjsglxt_staffMove> getMoveByStaffId(String staffMove_staff) {
		// TODO Auto-generated method stub
		return staffMoveDao.getMoveByStaffId(staffMove_staff);
	}
}
