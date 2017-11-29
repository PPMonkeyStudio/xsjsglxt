package com.xsjsglxt.action.Case;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.ActionSupport;
import com.xsjsglxt.domain.DO.xsjsglxt_case;
import com.xsjsglxt.domain.DO.xsjsglxt_parallel;
import com.xsjsglxt.domain.VO.Case.page_list_parallelInformationVO;
import com.xsjsglxt.service.Case.ParallelService;

public class ParallelAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {
 
	private ParallelService parallelService;
	private HttpServletResponse http_response;

	private HttpServletRequest http_request;
	
	private xsjsglxt_case Case;
	private xsjsglxt_parallel parallel;
	
	private page_list_parallelInformationVO page_list_parallelInformation;
	
	private List<String> CaeNumList;
	/*
	 * (non-Javadoc)保存
	 * @see org.apache.struts2.interceptor.ServletResponseAware#setServletResponse(javax.servlet.http.HttpServletResponse)
	 */
	public void saveparallel() {
		
		try {
			
			parallelService.saveParallel(CaeNumList, parallel);
			http_response.setContentType("text/html;charset=utf-8");
			http_response.getWriter().write("success");	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
	}
	/*
	 * (non-Javadoc)串并列表信息
	 * @see org.apache.struts2.interceptor.ServletResponseAware#setServletResponse(javax.servlet.http.HttpServletResponse)
	 */
	public void ListParallelInformationByPageAndSearch() throws IOException{
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();
		page_list_parallelInformation = parallelService
					.VO_Parallelformation_By_PageAndSearch(page_list_parallelInformation);

				http_response.setContentType("text/html;charset=utf-8");

				http_response.getWriter().write(gson.toJson(page_list_parallelInformation));
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
	public ParallelService getParallelService() {
		return parallelService;
	}
	public void setParallelService(ParallelService parallelService) {
		this.parallelService = parallelService;
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
	public xsjsglxt_case getCase() {
		return Case;
	}
	public void setCase(xsjsglxt_case case1) {
		Case = case1;
	}
	public xsjsglxt_parallel getParallel() {
		return parallel;
	}
	public void setParallel(xsjsglxt_parallel parallel) {
		this.parallel = parallel;
	}
	public page_list_parallelInformationVO getPage_list_parallelInformation() {
		return page_list_parallelInformation;
	}
	public void setPage_list_parallelInformation(page_list_parallelInformationVO page_list_parallelInformation) {
		this.page_list_parallelInformation = page_list_parallelInformation;
	}
	public List<String> getCaeNumList() {
		return CaeNumList;
	}
	public void setCaeNumList(List<String> caeNumList) {
		CaeNumList = caeNumList;
	}

}
