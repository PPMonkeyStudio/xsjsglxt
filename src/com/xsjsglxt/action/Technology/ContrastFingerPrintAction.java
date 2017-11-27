package com.xsjsglxt.action.Technology;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.ActionSupport;
import com.xsjsglxt.domain.DO.xsjsglxt_contrast_fingerprint;
import com.xsjsglxt.domain.DO.xsjsglxt_dna;
import com.xsjsglxt.domain.VO.Technology.ContrastFingerPrintVO;
import com.xsjsglxt.service.Technology.ContrastFingerPrintService;

public class ContrastFingerPrintAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {

	private ContrastFingerPrintService contrastFingerPrintService;

	private HttpServletResponse http_response;

	private HttpServletRequest http_request;

	private ContrastFingerPrintVO contrastFingerPrintVO;

	private xsjsglxt_contrast_fingerprint contrastFingerPrint;
	
	public void CreateContrast() throws IOException {
		int result = contrastFingerPrintService.saveContrast(contrastFingerPrint);
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();
		http_response.setContentType("text/html;charset=utf-8");
		http_response.getWriter().write(gson.toJson(result));
	}
	
	public void deleteContrast() throws IOException {
		int result = contrastFingerPrintService.deleteContrast(contrast_fingerprint_id);
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();
		http_response.setContentType("text/html;charset=utf-8");
		http_response.getWriter().write(gson.toJson(result));
	}
	
	public void deleteListContrast() throws IOException {
		int result = contrastFingerPrintService.deleteListContrast(listDeleteContrastID);
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();
		http_response.setContentType("text/html;charset=utf-8");
		http_response.getWriter().write(gson.toJson(result));
	}
	
	public void modifiedContrast() throws IOException {
		int result = contrastFingerPrintService.modifiedContrast(contrastFingerPrint);
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();
		http_response.setContentType("text/html;charset=utf-8");
		http_response.getWriter().write(gson.toJson(result));
	}

	public void get_contrast() throws IOException {
		xsjsglxt_contrast_fingerprint contrast = contrastFingerPrintService.get_contrast(contrast_fingerprint_id);
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();
		http_response.setContentType("text/html;charset=utf-8");
		http_response.getWriter().write(gson.toJson(contrast));
	}
	
	public String ContrastFingerPrintManagementPage() {
		return "ContrastFingerPrintManagementPage";
	}
	
	@Override
	public String toString() {
		return "ContrastFingerPrintAction [contrastFingerPrintService=" + contrastFingerPrintService
				+ ", http_response=" + http_response + ", http_request=" + http_request + ", contrastFingerPrintVO="
				+ contrastFingerPrintVO + ", contrastFingerPrint=" + contrastFingerPrint + ", listDeleteContrastID="
				+ listDeleteContrastID + ", contrast_fingerprint_id=" + contrast_fingerprint_id + "]";
	}

	public ContrastFingerPrintService getContrastFingerPrintService() {
		return contrastFingerPrintService;
	}

	public void setContrastFingerPrintService(ContrastFingerPrintService contrastFingerPrintService) {
		this.contrastFingerPrintService = contrastFingerPrintService;
	}

	public HttpServletResponse getHttp_response() {
		return http_response;
	}

	public void setHttp_response(HttpServletResponse http_response) {
		this.http_response = http_response;
	}

	public HttpServletRequest getHttp_request() {
		return http_request;
	}

	public void setHttp_request(HttpServletRequest http_request) {
		this.http_request = http_request;
	}

	public ContrastFingerPrintVO getContrastFingerPrintVO() {
		return contrastFingerPrintVO;
	}

	public void setContrastFingerPrintVO(ContrastFingerPrintVO contrastFingerPrintVO) {
		this.contrastFingerPrintVO = contrastFingerPrintVO;
	}

	public xsjsglxt_contrast_fingerprint getContrastFingerPrint() {
		return contrastFingerPrint;
	}

	public void setContrastFingerPrint(xsjsglxt_contrast_fingerprint contrastFingerPrint) {
		this.contrastFingerPrint = contrastFingerPrint;
	}

	public List<String> getListDeleteContrastID() {
		return listDeleteContrastID;
	}

	public void setListDeleteContrastID(List<String> listDeleteContrastID) {
		this.listDeleteContrastID = listDeleteContrastID;
	}

	public String getContrast_fingerprint_id() {
		return contrast_fingerprint_id;
	}

	public void setContrast_fingerprint_id(String contrast_fingerprint_id) {
		this.contrast_fingerprint_id = contrast_fingerprint_id;
	}

	private List<String> listDeleteContrastID;
	
	private String contrast_fingerprint_id;
	
	@Override
	public void setServletResponse(HttpServletResponse http_response) {
		this.http_response = http_response;
	}

	@Override
	public void setServletRequest(HttpServletRequest http_request) {
		this.http_request = http_request;
	}

}
