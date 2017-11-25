package com.xsjsglxt.action.Case;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.ActionSupport;
import com.xsjsglxt.domain.DO.xsjsglxt_briefdetails;
import com.xsjsglxt.domain.DO.xsjsglxt_case;
import com.xsjsglxt.domain.DO.xsjsglxt_lost;
import com.xsjsglxt.domain.DO.xsjsglxt_lost_computer;
import com.xsjsglxt.domain.DO.xsjsglxt_lost_mobilephone;
import com.xsjsglxt.domain.DO.xsjsglxt_snece;
import com.xsjsglxt.domain.VO.Case.page_list_senceInformationVO;
import com.xsjsglxt.service.Case.SenceService;

public class SenceAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {
    private SenceService senceService;
    private xsjsglxt_snece sence;
    private xsjsglxt_case Case;
    private xsjsglxt_briefdetails briefdetails;
    private xsjsglxt_lost lost;
    private xsjsglxt_lost_mobilephone lost_mobilephone ;
    private xsjsglxt_lost_computer lost_computer;
    private HttpServletResponse http_response;

	private HttpServletRequest http_request;
	private page_list_senceInformationVO page_list_senceInformation;  
    /*
     *跳转页面 
     */
    public String  page_SiteManagement(){
    	return "page_SiteManagement";
    }
    /*
     * 保存基本信息
     */
    public void saveSenceInformation(){
    	senceService.save(sence);
    	senceService.save(Case);
    	senceService.save(briefdetails);
    	senceService.save(lost);
    	senceService.save(lost_mobilephone);
    	senceService.save(lost_computer);
    
    }
    /*
     * 获得勘探编号
     */
    public void getSenceInquestId() throws IOException{
    	GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();
		String senceInformationInquestId = senceService.getSenceInformationInquestId();
		http_response.setContentType("text/html;charset=utf-8");
		http_response.getWriter().write(gson.toJson(senceInformationInquestId));
    }
    /*
     * 现场信息列表
     */
	public void ListSneceInformationByPageAndSearch() throws IOException {

		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();

		// 获取所有现场录入信息列表
		page_list_senceInformation = senceService
				.VO_SneceInformation_By_PageAndSearch(page_list_senceInformation);

		http_response.setContentType("text/html;charset=utf-8");

		http_response.getWriter().write(gson.toJson(page_list_senceInformation));

	}
	public SenceService getSenceService() {
		return senceService;
	}

	public void setSenceService(SenceService senceService) {
		this.senceService = senceService;
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
	public xsjsglxt_snece getSence() {
		return sence;
	}
	public void setSence(xsjsglxt_snece sence) {
		this.sence = sence;
	}
	public xsjsglxt_case getCase() {
		return Case;
	}
	public void setCase(xsjsglxt_case case1) {
		Case = case1;
	}
	public xsjsglxt_briefdetails getBriefdetails() {
		return briefdetails;
	}
	public void setBriefdetails(xsjsglxt_briefdetails briefdetails) {
		this.briefdetails = briefdetails;
	}
	public xsjsglxt_lost getLost() {
		return lost;
	}
	public void setLost(xsjsglxt_lost lost) {
		this.lost = lost;
	}
	public xsjsglxt_lost_mobilephone getLost_mobilephone() {
		return lost_mobilephone;
	}
	public void setLost_mobilephone(xsjsglxt_lost_mobilephone lost_mobilephone) {
		this.lost_mobilephone = lost_mobilephone;
	}
	public xsjsglxt_lost_computer getLost_computer() {
		return lost_computer;
	}
	public void setLost_computer(xsjsglxt_lost_computer lost_computer) {
		this.lost_computer = lost_computer;
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
