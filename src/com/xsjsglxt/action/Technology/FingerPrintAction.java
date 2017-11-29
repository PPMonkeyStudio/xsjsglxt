package com.xsjsglxt.action.Technology;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.xsjsglxt.domain.DO.xsjsglxt_fingerprint;
import com.xsjsglxt.domain.VO.Technology.FingerPrintVO;
import com.xsjsglxt.service.Technology.FingerPrintService;

public class FingerPrintAction implements ServletRequestAware, ServletResponseAware {
	
	
	private FingerPrintService fingerPrintService;
	
	private HttpServletResponse http_response;

	private HttpServletRequest http_request;
	
	private xsjsglxt_fingerprint fingerprint;
	
	private FingerPrintVO fingerprintVO;
	
	
	private List<String> listDeleteFingerPrintID;
	
	private String xsjsglxt_fingerprint_id;
	
	
	/**
	 * @author gxr
	 * 查询单个
	 * */
	public void get_fingerprint() throws IOException {
		xsjsglxt_fingerprint finger = fingerPrintService.get_fingerprint(xsjsglxt_fingerprint_id);
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据	
		Gson gson = gsonBuilder.create();
		http_response.setContentType("text/html;charset=utf-8");
		http_response.getWriter().write(gson.toJson(finger));
	}
	
	/**
	 * @author gxr
	 * 修改
	 * 
	 * */
	public void modifiedFingerPrint() throws IOException {
		int result = fingerPrintService.modifiedFingerPrint(fingerprint);
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();
		http_response.setContentType("text/html;charset=utf-8");
		http_response.getWriter().write(gson.toJson(result));
	}
	
	/**
	 * @author gxr
	 *删除
	 * */
	public void deleteFingerPrint() throws IOException {
		int result = fingerPrintService.deleteFingerPrint(xsjsglxt_fingerprint_id);
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();
		http_response.setContentType("text/html;charset=utf-8");
		http_response.getWriter().write(gson.toJson(result));
	}
	
	/**
	 * @author gxr
	 * 批量删除
	 * */
	public void deleteListFingerPrint() throws IOException {
		int result = fingerPrintService.deleteListFingerPrint(listDeleteFingerPrintID);
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();
		http_response.setContentType("text/html;charset=utf-8");
		http_response.getWriter().write(gson.toJson(result));
	}
	
	/**
	 * @author gxr
	 * 分页查询记录
	 * */
	public void list_xsjsglxt_fingerprint() throws IOException {
		FingerPrintVO vo = fingerPrintService.list_xsjsglxt_fingerprint(fingerprintVO);
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();
		http_response.setContentType("text/html;charset=utf-8");
		http_response.getWriter().write(gson.toJson(vo));
	}
	
	/**
	 * @author gxr
	 * 添加
	 * */
	public void saveFingerPrint() throws IOException {
		int result = fingerPrintService.saveFingerPrint(fingerprint);
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();
		http_response.setContentType("text/html;charset=utf-8");
		http_response.getWriter().write(gson.toJson(result));
	}
	
	public FingerPrintService getFingerPrintService() {
		return fingerPrintService;
	}

	public void setFingerPrintService(FingerPrintService fingerPrintService) {
		this.fingerPrintService = fingerPrintService;
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

	public xsjsglxt_fingerprint getFingerprint() {
		return fingerprint;
	}

	public void setFingerprint(xsjsglxt_fingerprint fingerprint) {
		this.fingerprint = fingerprint;
	}

	public FingerPrintVO getFingerprintVO() {
		return fingerprintVO;
	}

	public void setFingerprintVO(FingerPrintVO fingerprintVO) {
		this.fingerprintVO = fingerprintVO;
	}

	public List<String> getListDeleteFingerPrintID() {
		return listDeleteFingerPrintID;
	}

	public void setListDeleteFingerPrintID(List<String> listDeleteFingerPrintID) {
		this.listDeleteFingerPrintID = listDeleteFingerPrintID;
	}

	public String getXsjsglxt_fingerprint_id() {
		return xsjsglxt_fingerprint_id;
	}

	public void setXsjsglxt_fingerprint_id(String xsjsglxt_fingerprint_id) {
		this.xsjsglxt_fingerprint_id = xsjsglxt_fingerprint_id;
	}

	public String FingerPrintManagementPage() {
		return "FingerPrintManagementPage";
	}
	
	public String CreateFingerPrintPage() {
		return"CreateFingerPrintPage";
	}

	@Override
	public void setServletResponse(HttpServletResponse http_response) {
		this.http_response = http_response;
	}

	@Override
	public void setServletRequest(HttpServletRequest http_request) {
		this.http_request = http_request;
	}
}
