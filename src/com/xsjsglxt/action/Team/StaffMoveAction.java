package com.xsjsglxt.action.Team;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import com.xsjsglxt.domain.DO.xsjsglxt_staffMove;
import com.xsjsglxt.service.Team.StaffMoveService;

/*
 * @author 孙毅
 * @description 调动情况管理
 */
public class StaffMoveAction extends ActionSupport {
	private StaffMoveService staffMoveService;
	private xsjsglxt_staffMove move;
	private List<xsjsglxt_staffMove> moves;

	// -----------------------保存调动情况-------------------------------
	public void saveMoves() {
		String result = staffMoveService.saveMove(moves);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw;
		try {
			pw = response.getWriter();
			pw.write(result);
			pw.flush();
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// -----------------------删除单个调动情况------------------------------

	public void deleteMove() {
		String result = staffMoveService.deleteMove(move);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw;
		try {
			pw = response.getWriter();
			pw.write(result);
			pw.flush();
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// ---------------------------删除多个调动情况---------------------------
	public void deleteMoves() {
		String result = staffMoveService.deleteMoves(move.getStaffMove_staff());
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw;
		try {
			pw = response.getWriter();
			pw.write(result);
			pw.flush();
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// ---------------------------修改调动情况--------------------------------
	public void updateMove() {
		String result = staffMoveService.updateMove(move);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw;
		try {
			pw = response.getWriter();
			pw.write(result);
			pw.flush();
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// ---------------------------获取一个调动情况-----------------------------
	public void getMoveByMoveId() {
		xsjsglxt_staffMove oldMove = staffMoveService.getMoveByMoveId(move.getXsjsglxt_staffMove_id());
		Gson gson = new Gson();
		String result = gson.toJson(oldMove);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw;
		try {
			pw = response.getWriter();
			pw.write(result);
			pw.flush();
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// --------------------------获取多个调动情况--------------------------------
	public void getMoveByStaffId() {
		List<xsjsglxt_staffMove> xsjsglxt_staffMoves = staffMoveService.getMoveByStaffId(move.getStaffMove_staff());
		Gson gson = new Gson();
		String result = gson.toJson(xsjsglxt_staffMoves);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw;
		try {
			pw = response.getWriter();
			pw.write(result);
			pw.flush();
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// -----------------------setter/getter-----------------------------
	public xsjsglxt_staffMove getMove() {
		return move;
	}

	public void setMove(xsjsglxt_staffMove move) {
		this.move = move;
	}

	public List<xsjsglxt_staffMove> getMoves() {
		return moves;
	}

	public void setMoves(List<xsjsglxt_staffMove> moves) {
		this.moves = moves;
	}

	public StaffMoveService getStaffMoveService() {
		return staffMoveService;
	}

	public void setStaffMoveService(StaffMoveService staffMoveService) {
		this.staffMoveService = staffMoveService;
	}
}
