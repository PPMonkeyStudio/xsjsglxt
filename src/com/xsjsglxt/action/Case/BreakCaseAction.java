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
import com.xsjsglxt.domain.DO.xsjsglxt_breakcase;
import com.xsjsglxt.domain.DO.xsjsglxt_briefdetails;
import com.xsjsglxt.domain.VO.Case.page_list_BreakecaseInformationVO;
import com.xsjsglxt.service.Case.BreakCaseService;

public class BreakCaseAction extends ActionSupport implements ServletResponseAware, ServletRequestAware {
	
	public String page_BreakCaseList() {
		return "page_BreakCaseList";
	}
	
	/*
	 * 保存破案信息
	 * 
	 * 
	 */
	public void saveBreakecase() throws IOException {
		http_response.setContentType("text/html;charset=utf-8");
		try {
			breakCaseService.saveBreakCaseInfo(breakCase, briefDetails);
			http_response.getWriter().write("success");
		} catch (Exception e) {
			e.printStackTrace();
			http_response.setContentType("text/html;charset=utf-8");
			http_response.getWriter().write("error");
		}
	}
	
	/*
	 * 删除信息,也可以批量删除
	 */
	public void removeBreakCaseInfo() throws IOException {
		http_response.setContentType("text/html;charset=utf-8");
		if (breakCaseService.removeBreakCaseInfo(breakCaseInIdList)) {
			http_response.getWriter().write("success");
		} else {
			http_response.getWriter().write("error");
		}
	}
	
	/*
	 * 修改信息，这个页面，需要把简要案情的input命名为breakcase_case_note_new,原来的简要案情id设置为hidden
	 */
	public void updateBreakcase() throws IOException {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();
		breakCaseService.updateBreakCase(breakCase, briefDetails);
		http_response.setContentType("text/html;charset=utf-8");
		http_response.getWriter().write(gson.toJson("success"));
	}
	
	/*
	 * 列表信息
	 */
	public void ListBreakCaseInformationByPageAndSearch() throws IOException {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();
		page_list_BreakecaseInformation = breakCaseService
																.VO_BreakecaseInformation_By_PageAndSearch(page_list_BreakecaseInformation);
		http_response.setContentType("text/html;charset=utf-8");
		http_response.getWriter().write(gson.toJson(page_list_BreakecaseInformation));
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		
	}

	public String getBreakcase_case_id() {
		return breakcase_case_id;
	}

	public void setBreakcase_case_id(String breakcase_case_id) {
		this.breakcase_case_id = breakcase_case_id;
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		response = this.http_response;
	}
	
	private BreakCaseService breakCaseService;
	private xsjsglxt_breakcase breakCase;
	private xsjsglxt_briefdetails briefDetails;
	public xsjsglxt_briefdetails getBriefDetails() {
		return briefDetails;
	}

	public void setBriefDetails(xsjsglxt_briefdetails briefDetails) {
		this.briefDetails = briefDetails;
	}

	private HttpServletResponse http_response;
	private List<String> breakCaseInIdList;//破案信息id的集合
	private String breakcase_case_id;//所属案件的id
	private String xsjsglxt_breakcase_id;//破案id
	private String breakcase_case;//简要案情id
	private page_list_BreakecaseInformationVO page_list_BreakecaseInformation;
	
	public page_list_BreakecaseInformationVO getPage_list_BreakecaseInformation() {
		return page_list_BreakecaseInformation;
	}

	public void setPage_list_BreakecaseInformation(page_list_BreakecaseInformationVO page_list_BreakecaseInformation) {
		this.page_list_BreakecaseInformation = page_list_BreakecaseInformation;
	}

	public List<String> getBreakCaseInIdList() {
		return breakCaseInIdList;
	}

	public void setBreakCaseInIdList(List<String> breakCaseInIdList) {
		this.breakCaseInIdList = breakCaseInIdList;
	}

	public String getBreakcase_case() {
		return breakcase_case;
	}

	public void setBreakcase_case(String breakcase_case) {
		this.breakcase_case = breakcase_case;
	}

	public String getXsjsglxt_breakcase_id() {
		return xsjsglxt_breakcase_id;
	}

	public void setXsjsglxt_breakcase_id(String xsjsglxt_breakcase_id) {
		this.xsjsglxt_breakcase_id = xsjsglxt_breakcase_id;
	}

	public BreakCaseService getBreakCaseService() {
		return breakCaseService;
	}

	public void setBreakCaseService(BreakCaseService breakCaseService) {
		this.breakCaseService = breakCaseService;
	}

	public xsjsglxt_breakcase getBreakCase() {
		return breakCase;
	}

	public void setBreakCase(xsjsglxt_breakcase breakCase) {
		this.breakCase = breakCase;
	}

	public HttpServletResponse getHttp_response() {
		return http_response;
	}

	public void setHttp_response(HttpServletResponse http_response) {
		this.http_response = http_response;
	}
	
}
