package com.xsjsglxt.dao.Team;

import java.util.List;

import com.xsjsglxt.domain.DO.xsjsglxt_staffMove;

public interface StaffMoveDao {

	String saveMove(List<xsjsglxt_staffMove> moves);

	String deleteMove(xsjsglxt_staffMove move);

	String deleteMoves(String staffMove_staff);

	xsjsglxt_staffMove getMoveByMoveId(String xsjsglxt_staffMove_id);

	List<xsjsglxt_staffMove> getMoveByStaffId(String staffMove_staff);

}
