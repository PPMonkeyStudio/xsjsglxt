<<<<<<< HEAD
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
import com.xsjsglxt.domain.DO.xsjsglxt_breakecase;
import com.xsjsglxt.domain.DO.xsjsglxt_case;
import com.xsjsglxt.domain.DO.xsjsglxt_snece;
import com.xsjsglxt.domain.DTO.Case.BreakecaseInformationDTO;
import com.xsjsglxt.domain.VO.Case.page_list_BreakecaseInformationVO;
import com.xsjsglxt.service.Case.BreakecaseService;

public class BreakecaseAction extends ActionSupport implements ServletResponseAware, ServletRequestAware {
	private  BreakecaseService breakecaseService;
	private xsjsglxt_breakecase breakecase ;
	private xsjsglxt_case case1;
	private xsjsglxt_snece sence;
	private List<String> useBreakecaseInformationNumList;
	private HttpServletResponse http_response;

	private HttpServletRequest http_request;
	
   
	private BreakecaseInformationDTO breakecaseInformationDTO;
	
	private page_list_BreakecaseInformationVO page_list_BreakecaseInformation;
	/*
	 *跳转刑事破案列表 
	 */
	public String page_BreakCaseList(){
		return "page_BreakCaseList";
	}
	
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
		breakecaseInformationDTO = breakecaseService.BreakecaseInformationOne(breakecase);
		http_response.setContentType("text/html;charset=utf-8");

		http_response.getWriter().write(gson.toJson(breakecaseInformationDTO));
	}
	/*
	 *修改信息 
	 */
	public void updateBreakcase() throws IOException{
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();
		//breakecaseService.updateCase(case1);
		breakecaseService.updateBreakcase(breakecase);
		//breakecaseService.updateSence(sence,case1.getXsjsglxt_case_id());
		http_response.setContentType("text/html;charset=utf-8");
		http_response.getWriter().write(gson.toJson("success"));
	}
	/*
	 *删除信息 
	 */
	public void remove_BreakecaseInformationList(){

		if(	breakecaseService.remove_BreakecaseInformationList( useBreakecaseInformationNumList)){
			http_response.setContentType("text/html;charset=utf-8");
			try {
				http_response.getWriter().write("success");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}else{
				http_response.setContentType("text/html;charset=utf-8");
				try {
					http_response.getWriter().write("error");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
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

	public xsjsglxt_breakecase getBreakecase() {
		return breakecase;
	}

	public void setBreakecase(xsjsglxt_breakecase breakecase) {
		this.breakecase = breakecase;
	}

	public xsjsglxt_case getCase1() {
		return case1;
	}

	public void setCase1(xsjsglxt_case case1) {
		this.case1 = case1;
	}

	public xsjsglxt_snece getSence() {
		return sence;
	}

	public void setSence(xsjsglxt_snece sence) {
		this.sence = sence;
	}

	public BreakecaseInformationDTO getBreakecaseInformationDTO() {
		return breakecaseInformationDTO;
	}

	public void setBreakecaseInformationDTO(BreakecaseInformationDTO breakecaseInformationDTO) {
		this.breakecaseInformationDTO = breakecaseInformationDTO;
	}

	public page_list_BreakecaseInformationVO getPage_list_BreakecaseInformation() {
		return page_list_BreakecaseInformation;
	}

	public void setPage_list_BreakecaseInformation(page_list_BreakecaseInformationVO page_list_BreakecaseInformation) {
		this.page_list_BreakecaseInformation = page_list_BreakecaseInformation;
	}

	public List<String> getUseBreakecaseInformationNumList() {
		return useBreakecaseInformationNumList;
	}

	public void setUseBreakecaseInformationNumList(List<String> useBreakecaseInformationNumList) {
		this.useBreakecaseInformationNumList = useBreakecaseInformationNumList;
	}

}
=======
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
import com.xsjsglxt.domain.DO.xsjsglxt_breakecase;
import com.xsjsglxt.domain.DO.xsjsglxt_case;
import com.xsjsglxt.domain.DO.xsjsglxt_snece;
import com.xsjsglxt.domain.DTO.Case.BreakecaseInformationDTO;
import com.xsjsglxt.domain.VO.Case.page_list_BreakecaseInformationVO;
import com.xsjsglxt.service.Case.BreakecaseService;

public class BreakecaseAction extends ActionSupport implements ServletResponseAware, ServletRequestAware {
	private  BreakecaseService breakecaseService;
	private xsjsglxt_breakecase breakecase ;
	private xsjsglxt_case case1;
	private xsjsglxt_snece sence;
	private List<String> useBreakecaseInformationNumList;
	private HttpServletResponse http_response;

	private HttpServletRequest http_request;
	
   
	private BreakecaseInformationDTO breakecaseInformationDTO;
	
	private page_list_BreakecaseInformationVO page_list_BreakecaseInformation;
	/*
	 *跳转刑事破案列表 
	 */
	public String page_BreakCaseList(){
		return "page_BreakCaseList";
	}
	
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
	/*
	 *修改信息 
	 */
	public void updateBreakcase() throws IOException{
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();
		breakecaseService.updateCase(case1);
		breakecaseService.updateBreakcase(breakecase,case1.getXsjsglxt_case_id());
		breakecaseService.updateSence(sence,case1.getXsjsglxt_case_id());
		http_response.setContentType("text/html;charset=utf-8");
		http_response.getWriter().write(gson.toJson("success"));
	}
	/*
	 *删除信息 
	 */
	public void remove_BreakecaseInformationList(){

		if(	breakecaseService.remove_BreakecaseInformationList( useBreakecaseInformationNumList)){
			http_response.setContentType("text/html;charset=utf-8");
			try {
				http_response.getWriter().write("success");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}else{
				http_response.setContentType("text/html;charset=utf-8");
				try {
					http_response.getWriter().write("error");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
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

	public xsjsglxt_breakecase getBreakecase() {
		return breakecase;
	}

	public void setBreakecase(xsjsglxt_breakecase breakecase) {
		this.breakecase = breakecase;
	}

	public xsjsglxt_case getCase1() {
		return case1;
	}

	public void setCase1(xsjsglxt_case case1) {
		this.case1 = case1;
	}

	public xsjsglxt_snece getSence() {
		return sence;
	}

	public void setSence(xsjsglxt_snece sence) {
		this.sence = sence;
	}

	public BreakecaseInformationDTO getBreakecaseInformationDTO() {
		return breakecaseInformationDTO;
	}

	public void setBreakecaseInformationDTO(BreakecaseInformationDTO breakecaseInformationDTO) {
		this.breakecaseInformationDTO = breakecaseInformationDTO;
	}

	public page_list_BreakecaseInformationVO getPage_list_BreakecaseInformation() {
		return page_list_BreakecaseInformation;
	}

	public void setPage_list_BreakecaseInformation(page_list_BreakecaseInformationVO page_list_BreakecaseInformation) {
		this.page_list_BreakecaseInformation = page_list_BreakecaseInformation;
	}

	public List<String> getUseBreakecaseInformationNumList() {
		return useBreakecaseInformationNumList;
	}

	public void setUseBreakecaseInformationNumList(List<String> useBreakecaseInformationNumList) {
		this.useBreakecaseInformationNumList = useBreakecaseInformationNumList;
	}

}
>>>>>>> origin/SLL
