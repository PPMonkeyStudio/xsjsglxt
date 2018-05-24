package com.xsjsglxt.action.Statistics;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.xsjsglxt.domain.DO.xsjsglxt_expenditure;
import com.xsjsglxt.domain.VO.Statistics.ExpenditureVO;
import com.xsjsglxt.service.Statistics.ExpenditureService;

public class ExpenditureAction {

	private ExpenditureService expenditureService;
	private xsjsglxt_expenditure expenditure;
	private String[] expenditure_id;
	private ExpenditureVO expenditureVO;

	public String intoMain() {
		return "intoMain";
	}

	public void searchExpenditureByPage() throws IOException {
		expenditureService.searchExpenditureByPage(expenditureVO);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		Gson gson = new Gson();
		String result = gson.toJson(expenditureVO);
		pw.write(result);
		pw.flush();
		pw.close();
	}

	public void saveExpenditure() throws IOException {
		boolean flag = expenditureService.saveExpenditure(expenditure);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
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
	}

	public void deleteExpenditure() throws IOException {
		boolean flag = expenditureService.deleteExpenditure(expenditure_id);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		if (flag) {
			pw.write("deleteSuccess");
			pw.flush();
			pw.close();
		} else {
			pw.write("deleteError");
			pw.flush();
			pw.close();
		}
	}

	public void updateExpenditure() throws IOException {
		boolean flag = expenditureService.updateExpenditure(expenditure);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		if (flag) {
			pw.write("updateSuccess");
			pw.flush();
			pw.close();
		} else {
			pw.write("updateError");
			pw.flush();
			pw.close();
		}
	}

	public void getExpenditureById() throws IOException {
		xsjsglxt_expenditure result = expenditureService.getExpenditureById(expenditure.getExpenditure_id());
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		if (result == null) {
			pw.write("notExist");
			pw.flush();
			pw.close();
		} else {
			Gson gson = new Gson();
			pw.write(gson.toJson(result));
			pw.flush();
			pw.close();
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

	public ExpenditureVO getExpenditureVO() {
		return expenditureVO;
	}

	public void setExpenditureVO(ExpenditureVO expenditureVO) {
		this.expenditureVO = expenditureVO;
	}

}
