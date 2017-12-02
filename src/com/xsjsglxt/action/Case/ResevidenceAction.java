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
import com.xsjsglxt.domain.DO.xsjsglxt_circulation;
import com.xsjsglxt.domain.DO.xsjsglxt_resevidence;
import com.xsjsglxt.domain.DTO.Case.ResevidenceInformationDTO;
import com.xsjsglxt.domain.VO.Case.page_list_ResevidenceInformationVO;
import com.xsjsglxt.service.Case.ResevidenceService;

public class ResevidenceAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {
   private ResevidenceService resevidenceService;
   
	private HttpServletResponse http_response;

	private HttpServletRequest http_request;	
	
	private xsjsglxt_resevidence resevidence;
	
	private xsjsglxt_case case1;
	
	private xsjsglxt_circulation circulation;
	
	private ResevidenceInformationDTO resevidenceInformationDTO;
	
	private	page_list_ResevidenceInformationVO page_list_ResevidenceInformation;
	
	/*
	 * (non-Javadoc)������֤
	 * @see org.apache.struts2.interceptor.ServletResponseAware#setServletResponse(javax.servlet.http.HttpServletResponse)
	 */
	public void saveResevidence() throws IOException{
		try {
			resevidence.setResevidence_case(case1.getXsjsglxt_case_id());
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
	 * �б���Ϣ
	 */
	public void  ListResevidenceInformationByPageAndSearch() throws IOException{
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// ��ʽ��json����
		Gson gson = gsonBuilder.create();
		page_list_ResevidenceInformation = resevidenceService
					.VO_Resevidenceformation_By_PageAndSearch(page_list_ResevidenceInformation);

				http_response.setContentType("text/html;charset=utf-8");

				http_response.getWriter().write(gson.toJson(page_list_ResevidenceInformation));
	}
	/*
	 * ��֤��ϸ��Ϣ
	 */
	public void ResevidenceInformationOne() throws IOException{
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// ��ʽ��json����
		Gson gson = gsonBuilder.create();
		resevidenceInformationDTO = resevidenceService.ResevidenceInformationOne(resevidence);
		http_response.setContentType("text/html;charset=utf-8");

		http_response.getWriter().write(gson.toJson(resevidenceInformationDTO));
	}
	/*
	 * ������֤��ת��Ϣ
	 */
	public void saveCirculation() throws IOException{
		try {
			circulation.setCirculation_resevidence(resevidence.getXsjsglxt_resevidence_id());
			resevidenceService.saveCirculation(circulation);
			http_response.setContentType("text/html;charset=utf-8");
			http_response.getWriter().write("success");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			http_response.setContentType("text/html;charset=utf-8");
			http_response.getWriter().write("error");
		}
	}
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

	public xsjsglxt_resevidence getResevidence() {
		return resevidence;
	}

	public void setResevidence(xsjsglxt_resevidence resevidence) {
		this.resevidence = resevidence;
	}

	public xsjsglxt_case getCase1() {
		return case1;
	}

	public void setCase1(xsjsglxt_case case1) {
		this.case1 = case1;
	}

	public xsjsglxt_circulation getCirculation() {
		return circulation;
	}

	public void setCirculation(xsjsglxt_circulation circulation) {
		this.circulation = circulation;
	}

	public ResevidenceInformationDTO getResevidenceInformationDTO() {
		return resevidenceInformationDTO;
	}

	public void setResevidenceInformationDTO(ResevidenceInformationDTO resevidenceInformationDTO) {
		this.resevidenceInformationDTO = resevidenceInformationDTO;
	}

	public page_list_ResevidenceInformationVO getPage_list_ResevidenceInformation() {
		return page_list_ResevidenceInformation;
	}

	public void setPage_list_ResevidenceInformation(page_list_ResevidenceInformationVO page_list_ResevidenceInformation) {
		this.page_list_ResevidenceInformation = page_list_ResevidenceInformation;
	}

}