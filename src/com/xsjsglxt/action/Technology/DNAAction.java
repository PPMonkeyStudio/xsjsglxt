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
import com.xsjsglxt.domain.DO.xsjsglxt_dna;
import com.xsjsglxt.domain.VO.Technology.DNAVO;
import com.xsjsglxt.service.Technology.DNAService;

public class DNAAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {

	private DNAService dNAService;

	private HttpServletResponse http_response;

	private HttpServletRequest http_request;

	private DNAVO dnaVO;

	private xsjsglxt_dna dna;

	private List<String> listDeleteDNAID;

	private String xsjsglxt_dna_id;

	public void get_dna() throws IOException {
		xsjsglxt_dna d = dNAService.get_dna(xsjsglxt_dna_id);
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();
		http_response.setContentType("text/html;charset=utf-8");
		http_response.getWriter().write(gson.toJson(d));
	}

	/**
	 * @author gxr 修改DNA
	 * 
	 */
	public void modifiedDNA() throws IOException {
		System.out.println("dna:" + dna);
		int result = dNAService.modifiedDNA(dna);
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();
		http_response.setContentType("text/html;charset=utf-8");
		http_response.getWriter().write(gson.toJson(result));
	}

	/**
	 * @author gxr 删除DNA根据xsjsglxt_dna_id
	 */
	public void deleteDNA() throws IOException {
		int result = dNAService.deleteDNA(xsjsglxt_dna_id);
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();
		http_response.setContentType("text/html;charset=utf-8");
		http_response.getWriter().write(gson.toJson(result));
	}

	/**
	 * @author gxr 批量删除DNA
	 */
	public void deleteListDNA() throws IOException {
		System.out.println(listDeleteDNAID);
		int result = dNAService.deleteListDNA(listDeleteDNAID);
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();
		http_response.setContentType("text/html;charset=utf-8");
		http_response.getWriter().write(gson.toJson(result));
	}

	public void ListDNAByPageAndSearch() throws IOException {
		DNAVO vo = dNAService.list_xsjsglxt_dna(dnaVO);
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();
		http_response.setContentType("text/html;charset=utf-8");
		http_response.getWriter().write(gson.toJson(vo));
	}

	/**
	 * @author gxr 添加DNA
	 */
	public void CreateDNA() throws IOException {
		int result = dNAService.saveDNA(dna);
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();
		http_response.setContentType("text/html;charset=utf-8");
		http_response.getWriter().write(gson.toJson(result));
	}

	public xsjsglxt_dna getDna() {
		return dna;
	}

	public void setDna(xsjsglxt_dna dna) {
		this.dna = dna;
	}

	public String DNAManagementPage() {
		return "DNAManagementPage";
	}

	public String CreateDNAPage() {
		return "CreateDNAPage";
	}



	public DNAVO getDnaVO() {
		return dnaVO;
	}

	public void setDnaVO(DNAVO dnaVO) {
		this.dnaVO = dnaVO;
	}

	public DNAService getdNAService() {
		return dNAService;
	}

	public void setdNAService(DNAService dNAService) {
		this.dNAService = dNAService;
	}

	@Override
	public void setServletRequest(HttpServletRequest http_request) {
		this.http_request = http_request;
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

	public void setServletResponse(HttpServletResponse http_response) {
		this.http_response = http_response;
	}

	public List<String> getListDeleteDNAID() {
		return listDeleteDNAID;
	}

	public void setListDeleteDNAID(List<String> listDeleteDNAID) {
		this.listDeleteDNAID = listDeleteDNAID;
	}

	public String getXsjsglxt_dna_id() {
		return xsjsglxt_dna_id;
	}

	public void setXsjsglxt_dna_id(String xsjsglxt_dna_id) {
		this.xsjsglxt_dna_id = xsjsglxt_dna_id;
	}

}
