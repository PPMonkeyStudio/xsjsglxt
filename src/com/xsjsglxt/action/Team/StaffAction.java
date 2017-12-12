package com.xsjsglxt.action.Team;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.ActionSupport;
import com.xsjsglxt.domain.DO.xsjsglxt_staff;
import com.xsjsglxt.domain.VO.Team.page_list_staffInformationVO;
import com.xsjsglxt.service.Team.StaffService;

public class StaffAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {

	private StaffService staffService;
	private xsjsglxt_staff staff;
	private HttpServletResponse http_response;

	private HttpServletRequest http_request;
	private page_list_staffInformationVO  page_list_staffInformation;
	/*
	 * 跳转列表页
	 */
	public String page_staffList(){
		System.out.println("第一步");
		return "page_staffList";
	}
	/*
	 *保存人员信息
	 */
	public void saveStaff() throws IOException{
		try {
			
			staffService.saveStaff(staff);
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
	public void ListStaffInformationByPageAndSearch() throws IOException{
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();

	
		page_list_staffInformation = staffService.VO_StaffInformation_By_PageAndSearch(page_list_staffInformation);

		http_response.setContentType("text/html;charset=utf-8");

		http_response.getWriter().write(gson.toJson(page_list_staffInformation));
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
	public StaffService getStaffService() {
		return staffService;
	}
	public void setStaffService(StaffService staffService) {
		this.staffService = staffService;
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
	public xsjsglxt_staff getStaff() {
		return staff;
	}
	public void setStaff(xsjsglxt_staff staff) {
		this.staff = staff;
	}
	public page_list_staffInformationVO getPage_list_staffInformation() {
		return page_list_staffInformation;
	}
	public void setPage_list_staffInformation(page_list_staffInformationVO page_list_staffInformation) {
		this.page_list_staffInformation = page_list_staffInformation;
	}

}
