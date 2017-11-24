package com.xsjsglxt.action.InspectionIdentification;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;
import com.xsjsglxt.domain.DO.xsjsglxt_trance_check_entrustment_book;
import com.xsjsglxt.service.InspectionIdentification.InspectionIdentificationService;

@SuppressWarnings("serial")
public class InspectionIdentificationAction extends ActionSupport implements ServletResponseAware, ServletRequestAware {
	private InspectionIdentificationService inspectionIdentificationService;
	private HttpServletResponse response;
	private HttpServletRequest request;

	public void setInspectionIdentificationService(InspectionIdentificationService inspectionIdentificationService) {
		this.inspectionIdentificationService = inspectionIdentificationService;
	}

	/**
	 * 
	 *
	 */
	// 痕迹检验委托书
	private xsjsglxt_trance_check_entrustment_book tranceCheckBook;

	// 点击进入检验鉴定委托管理
	public String TranceCheckEntrustmentBookManagement() {
		return "TranceCheckEntrustmentBookManagement";
	}

	// 点击保存
	public void addTranceCheckBook() {
		int i = inspectionIdentificationService.saveTranceCheckBook(tranceCheckBook);
		try {
			response.getWriter().write(i);
		} catch (IOException e) {
			System.out.println("保存痕迹鉴定委托书报错");
			e.printStackTrace();
		}
		;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;

	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public xsjsglxt_trance_check_entrustment_book getTranceCheckBook() {
		return tranceCheckBook;
	}

	public void setTranceCheckBook(xsjsglxt_trance_check_entrustment_book tranceCheckBook) {
		this.tranceCheckBook = tranceCheckBook;
	}

}
