package com.xsjsglxt.action.Case;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.ActionSupport;
import com.xsjsglxt.domain.DO.xsjsglxt_handle;
import com.xsjsglxt.domain.VO.Case.page_list_HandleInformationVO;
import com.xsjsglxt.service.Case.HandleService;

public class HandleAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {
private HandleService handleService;
private xsjsglxt_handle handle;
private HttpServletResponse http_response;
private HttpServletRequest http_request;	
private page_list_HandleInformationVO page_list_HandleInformation;
/*
 * 保存办案信息
 */
public void saveHandle() throws IOException{
	try {
		
		handleService.saveHandle(handle);
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
public void ListHandleInformationByPageAndSearch() throws IOException{
	GsonBuilder gsonBuilder = new GsonBuilder();
	gsonBuilder.setPrettyPrinting();// 格式化json数据
	Gson gson = gsonBuilder.create();


	page_list_HandleInformation = handleService.VO_HandleInformation_By_PageAndSearch(page_list_HandleInformation);

	http_response.setContentType("text/html;charset=utf-8");

	http_response.getWriter().write(gson.toJson(page_list_HandleInformation));
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

	public HandleService getHandleService() {
		return handleService;
	}

	public void setHandleService(HandleService handleService) {
		this.handleService = handleService;
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
	public xsjsglxt_handle getHandle() {
		return handle;
	}
	public void setHandle(xsjsglxt_handle handle) {
		this.handle = handle;
	}
	public page_list_HandleInformationVO getPage_list_HandleInformation() {
		return page_list_HandleInformation;
	}
	public void setPage_list_HandleInformation(page_list_HandleInformationVO page_list_HandleInformation) {
		this.page_list_HandleInformation = page_list_HandleInformation;
	}

}
