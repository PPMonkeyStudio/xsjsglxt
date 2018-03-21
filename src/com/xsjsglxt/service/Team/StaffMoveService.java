package com.xsjsglxt.service.Team;

import java.util.List;

import com.xsjsglxt.domain.DO.xsjsglxt_staffMove;

public interface StaffMoveService {

	String saveMove(List<xsjsglxt_staffMove> moves);

	String deleteMove(xsjsglxt_staffMove move);

	String deleteMoves(String staffMove_staff);

	String updateMove(xsjsglxt_staffMove move);

	xsjsglxt_staffMove getMoveByMoveId(String xsjsglxt_staffMove_id);

	List<xsjsglxt_staffMove> getMoveByStaffId(String staffMove_staff);

}
