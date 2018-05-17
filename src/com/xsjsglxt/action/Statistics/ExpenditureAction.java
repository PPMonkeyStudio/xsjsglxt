package com.xsjsglxt.action.Statistics;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.xsjsglxt.domain.DO.xsjsglxt_expenditure;
import com.xsjsglxt.service.Statistics.ExpenditureService;

public class ExpenditureAction {

	private ExpenditureService expenditureService;
	private xsjsglxt_expenditure expenditure;
	private String[] expenditure_id;

	public String intoMain() {
		return "intoMain";
	}

	public void saveExpenditure() throws IOException {
		boolean flag = expenditureService.saveExpenditure(expenditure);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		if (flag) {
			pw.write("saveSuccess");
		} else {
			pw.write("saveError");
		}
	}

	public void deleteExpenditure() throws IOException {
		boolean flag = expenditureService.deleteExpenditure(expenditure_id);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		if (flag) {
			pw.write("deleteSuccess");
		} else {
			pw.write("deleteError");
		}
	}

	public void updateExpenditure() throws IOException {
		boolean flag = expenditureService.updateExpenditure(expenditure);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		if (flag) {
			pw.write("updateSuccess");
		} else {
			pw.write("updateError");
		}
	}

	public xsjsglxt_expenditure getExpenditure() {
		return expenditure;
	}

	public void setExpenditure(xsjsglxt_expenditure expenditure) {
		this.expenditure = expenditure;
	}

	public ExpenditureService getExpenditureService() {
		return expenditureService;
	}

	public void setExpenditureService(ExpenditureService expenditureService) {
		this.expenditureService = expenditureService;
	}

	public String[] getExpenditure_id() {
		return expenditure_id;
	}

	public void setExpenditure_id(String[] expenditure_id) {
		this.expenditure_id = expenditure_id;
	}

}
