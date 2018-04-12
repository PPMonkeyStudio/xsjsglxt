package com.xsjsglxt.action.Case;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.xsjsglxt.domain.DO.xsjsglxt_breakecase;
import com.xsjsglxt.domain.DO.xsjsglxt_breakecasesuspect;
import com.xsjsglxt.service.Case.BreakecaseService;

/**
 * 
 * @author 孙毅
 * 破案模块
 *
 */
public class BreakecaseAction extends ActionSupport {
	private BreakecaseService breakecaseService;

	private xsjsglxt_breakecase breakeCase;

	private List<xsjsglxt_breakecasesuspect> suspectList;

	private String[] breakeCaseId;

	// -----------------------跳转页面
	public String page_BreakCaseList() {
		return "page_BreakCaseList";
	}

	// -----------------------保存破案
	public void saveBreakeCase() {
		boolean flag = breakecaseService.saveBreakeCase(breakeCase, suspectList);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
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

	// -----------------------新增一个嫌疑人
	public void addOneSuspect() {

	}

	// ------------------------删除破案
	public void deleteBreakeCase() {
		boolean flag = false;
		flag = breakecaseService.deleteBreakeCase(breakeCaseId);
		HttpServletResponse response = ServletActionContext.getResponse();
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
	 * @param breakeCaseId the breakeCaseId to set
	 */
	public void setBreakeCaseId(String[] breakeCaseId) {
		this.breakeCaseId = breakeCaseId;
	}

}