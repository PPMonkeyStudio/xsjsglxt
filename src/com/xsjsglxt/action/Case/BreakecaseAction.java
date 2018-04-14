package com.xsjsglxt.action.Case;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import com.xsjsglxt.domain.DO.xsjsglxt_breakecase;
import com.xsjsglxt.domain.DO.xsjsglxt_breakecasesuspect;
import com.xsjsglxt.domain.VO.Case.BreakeCaseDetailsVO;
import com.xsjsglxt.domain.VO.Case.BreakeCaseListVO;
import com.xsjsglxt.service.Case.BreakecaseService;

/**
 * 
 * @author 孙毅 破案模块
 *
 */
public class BreakecaseAction extends ActionSupport {
	private BreakecaseService breakecaseService;
	private xsjsglxt_breakecase breakeCase;
	private xsjsglxt_breakecasesuspect suspect;
	private List<xsjsglxt_breakecasesuspect> suspectList;
	private String[] breakeCaseId;
	private String[] suspectId;
	private BreakeCaseListVO breakeCaseListVO;

	// -----------------------跳转页面
	public String page_BreakCaseList() {
		return "page_BreakCaseList";
	}

	// -----------------------保存破案
	public void saveBreakeCase() {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		List<xsjsglxt_breakecase> breakecaseIm = breakecaseService.getBreakeCaseByCaseId(breakeCase);
		if (breakecaseIm != null && breakecaseIm.size() > 0) {
			try {
				PrintWriter pw = response.getWriter();
				pw.write("caseIsBreake");
				pw.flush();
				pw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			boolean flag = breakecaseService.saveBreakeCase(breakeCase, suspectList);
			try {
				PrintWriter pw = response.getWriter();
				if (flag) {
					pw.write("saveSuccess");
					pw.flush();
					pw.close();
				} else {
					pw.write("saveError");
					pw.flush();
					pw.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	// -----------------------新增一个嫌疑人
	public void addOneSuspect() {
		boolean flag = breakecaseService.addOneSuspect(suspect);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		try {
			PrintWriter pw = response.getWriter();
			if (flag)
				pw.write("saveSuccess");
			else
				pw.write("saveError");
			pw.flush();
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// ------------------------删除破案
	public void deleteBreakeCase() {
		boolean flag = false;
		flag = breakecaseService.deleteBreakeCase(breakeCaseId);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		try {
			PrintWriter pw = response.getWriter();
			if (flag)
				pw.write("deleteSuccess");
			else
				pw.write("deleteError");
			pw.flush();
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// -------------------------删除嫌疑人
	public void deleteSuspect() {
		boolean flag = false;
		flag = breakecaseService.deleteSuspect(suspectId);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		try {
			PrintWriter pw = response.getWriter();
			if (flag)
				pw.write("deleteSuccess");
			else
				pw.write("deleteError");
			pw.flush();
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// ---------------------------修改破案信息
	public void updateBreakeCase() {
		boolean flag = false;
		flag = breakecaseService.updateBreakeCase(breakeCase);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		try {
			PrintWriter pw = response.getWriter();
			if (flag)
				pw.write("updateSuccess");
			else
				pw.write("updateError");
			pw.flush();
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// ----------------------------修改嫌疑人信息
	public void updateSuspect() {
		boolean flag = false;
		flag = breakecaseService.updateSuspect(suspect);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		try {
			PrintWriter pw = response.getWriter();
			if (flag)
				pw.write("updateSuccess");
			else
				pw.write("updateError");
			pw.flush();
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// -------------------------------破案详情
	public void breakeCaseDetails() {
		BreakeCaseDetailsVO breakeCaseDetailsVO = breakecaseService
				.getBreakeCaseDetails(breakeCase.getXsjsglxt_breakecase_id());
		Gson gson = new Gson();
		String result = gson.toJson(breakeCaseDetailsVO);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		try {
			PrintWriter pw = response.getWriter();
			pw.write(result);
			pw.flush();
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// -----------------------------破案列表查询
	public void breakeCaseByPage() {
		breakecaseService.breakeCaseByPage(breakeCaseListVO);
		Gson gson = new Gson();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		try {
			PrintWriter pw = response.getWriter();
			pw.write(gson.toJson(breakeCaseListVO));
			pw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// -------------------------------------setter/getter--------------------------------------
	public BreakecaseService getBreakecaseService() {
		return breakecaseService;
	}

	public void setBreakecaseService(BreakecaseService breakecaseService) {
		this.breakecaseService = breakecaseService;
	}

	public xsjsglxt_breakecase getBreakeCase() {
		return breakeCase;
	}

	public void setBreakeCase(xsjsglxt_breakecase breakeCase) {
		this.breakeCase = breakeCase;
	}

	public List<xsjsglxt_breakecasesuspect> getSuspectList() {
		return suspectList;
	}

	public void setSuspectList(List<xsjsglxt_breakecasesuspect> suspectList) {
		this.suspectList = suspectList;
	}

	/**
	 * @return the breakeCaseId
	 */
	public String[] getBreakeCaseId() {
		return breakeCaseId;
	}

	/**
	 * @param breakeCaseId
	 *            the breakeCaseId to set
	 */
	public void setBreakeCaseId(String[] breakeCaseId) {
		this.breakeCaseId = breakeCaseId;
	}

	/**
	 * @return the suspect
	 */
	public xsjsglxt_breakecasesuspect getSuspect() {
		return suspect;
	}

	/**
	 * @param suspect
	 *            the suspect to set
	 */
	public void setSuspect(xsjsglxt_breakecasesuspect suspect) {
		this.suspect = suspect;
	}

	/**
	 * @return the suspectId
	 */
	public String[] getSuspectId() {
		return suspectId;
	}

	/**
	 * @param suspectId
	 *            the suspectId to set
	 */
	public void setSuspectId(String[] suspectId) {
		this.suspectId = suspectId;
	}

	/**
	 * @return the breakeCaseListVO
	 */
	public BreakeCaseListVO getBreakeCaseListVO() {
		return breakeCaseListVO;
	}

	/**
	 * @param breakeCaseListVO
	 *            the breakeCaseListVO to set
	 */
	public void setBreakeCaseListVO(BreakeCaseListVO breakeCaseListVO) {
		this.breakeCaseListVO = breakeCaseListVO;
	}

}