package com.xsjsglxt.action.Case;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.ActionSupport;
import com.xsjsglxt.domain.DO.xsjsglxt_breakecase;
import com.xsjsglxt.domain.DO.xsjsglxt_case;
import com.xsjsglxt.domain.DTO.Case.BreakecaseInformationDTO;
import com.xsjsglxt.domain.VO.Case.page_list_BreakecaseInformationVO;
import com.xsjsglxt.service.Case.BreakecaseService;

public class BreakecaseAction extends ActionSupport implements ServletResponseAware, ServletRequestAware {
	private  BreakecaseService breakecaseService;
	private xsjsglxt_breakecase breakecase ;
	private xsjsglxt_case case1;
	private HttpServletResponse http_response;

	private HttpServletRequest http_request;
	
   
	private BreakecaseInformationDTO breakecaseInformationDTO;
	
	private page_list_BreakecaseInformationVO page_list_BreakecaseInformation;
	
	/*
	 * 保存破案信息
	 */
	public void saveBreakecase() throws IOException{
		try {
			breakecase.setBreakecase_case(case1.getXsjsglxt_case_id());
			breakecaseService.saveBreakecase(breakecase);
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
	 *列表信息 
	 */
	public void ListBreakecaseInformationByPageAndSearch() throws IOException {

		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();

	
		page_list_BreakecaseInformation = breakecaseService.VO_BreakecaseInformation_By_PageAndSearch(page_list_BreakecaseInformation);

		http_response.setContentType("text/html;charset=utf-8");

		http_response.getWriter().write(gson.toJson(page_list_BreakecaseInformation));

	}

	/*
	 * 
	 * 详细信息
	 */
	public void BreakecaseInformationOne() throws IOException {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();//格式化json数据
		Gson gson = gsonBuilder.create();
		breakecaseInformationDTO = breakecaseService.BreakecaseInformationOne(case1);
		http_response.setContentType("text/html;charset=utf-8");

		http_response.getWriter().write(gson.toJson(breakecaseInformationDTO));
	}
	
	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		this.http_request = arg0;
	}

	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
		this.http_response = arg0;
	}

	public BreakecaseService getBreakecaseService() {
		return breakecaseService;
	}

	public void setBreakecaseService(BreakecaseService breakecaseService) {
		this.breakecaseService = breakecaseService;
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
