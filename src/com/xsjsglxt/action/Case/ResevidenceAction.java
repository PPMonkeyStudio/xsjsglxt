package com.xsjsglxt.action.Case;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.ActionSupport;
import com.xsjsglxt.domain.DO.xsjsglxt_case;
import com.xsjsglxt.domain.DO.xsjsglxt_resevidence;
import com.xsjsglxt.domain.VO.Case.page_list_ResevidenceInformationVO;
import com.xsjsglxt.service.Case.ResevidenceService;

public class ResevidenceAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {
   private ResevidenceService resevidenceService;
   
	private HttpServletResponse http_response;

	private HttpServletRequest http_request;	
	
	private xsjsglxt_resevidence resevidence;
	
	private xsjsglxt_case Case;
	
	private	page_list_ResevidenceInformationVO page_list_ResevidenceInformation;
	
	/*
	 * (non-Javadoc)保存物证
	 * @see org.apache.struts2.interceptor.ServletResponseAware#setServletResponse(javax.servlet.http.HttpServletResponse)
	 */
	public void saveResevidence() throws IOException{
		try {
			resevidence.setResevidence_case(Case.getXsjsglxt_case_id());
			resevidenceService.saveResevidence(resevidence);
			http_response.setContentType("text/html;charset=utf-8");
			http_response.getWriter().write("success");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			http_response.setContentType("text/html;charset=utf-8");
			http_response.getWriter().write("error");
		}
	}
	
	/*
	 * 列表信息
	 */
	public void  ListResevidenceInformationByPageAndSearch() throws IOException{
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();
		page_list_ResevidenceInformation = resevidenceService
					.VO_Resevidenceformation_By_PageAndSearch(page_list_ResevidenceInformation);

				http_response.setContentType("text/html;charset=utf-8");

				http_response.getWriter().write(gson.toJson(page_list_ResevidenceInformation));
	}
	/*
	 * 
	 */
	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
		this.http_response = arg0;
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		this.http_request = arg0;
	}

	public ResevidenceService getResevidenceService() {
		return resevidenceService;
	}

	public void setResevidenceService(ResevidenceService resevidenceService) {
		this.resevidenceService = resevidenceService;
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

}
