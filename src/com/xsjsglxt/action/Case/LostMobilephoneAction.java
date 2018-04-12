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
import com.xsjsglxt.domain.DO.xsjsglxt_lost;
import com.xsjsglxt.domain.DO.xsjsglxt_lost_mobilephone;
import com.xsjsglxt.domain.DTO.Case.LostMobilephoneInformationDTO;
import com.xsjsglxt.domain.VO.Case.page_list_CasematerialVO;
import com.xsjsglxt.service.Case.LostMobilephoneService;
import com.xsjsglxt.service.Case.LostService;

public class LostMobilephoneAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {

	private LostMobilephoneService lostMobilephoneService;
	
	private xsjsglxt_case case1;
	private xsjsglxt_lost_mobilephone lost_mobilephone;
	private List<String> useLost_mobilephoneInformationNumList;
	private HttpServletResponse http_response;

	private HttpServletRequest http_request;	
	
	private LostMobilephoneInformationDTO lostMobilephoneInformationDTO;

	private page_list_CasematerialVO page_list_Casematerial;
	
	/*
	 *保存损失手机
	 */
	public void saveLostMobilephone() throws IOException{
		try {
			lost_mobilephone.setLost_mobilephone_case(case1.getXsjsglxt_case_id());
			lostMobilephoneService.saveLostMobilephone(lost_mobilephone);
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
	 *损失手机列表
	 */
	public void  ListLostMobilephoneInformationByPageAndSearch() throws IOException{
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();
		page_list_Casematerial = lostMobilephoneService
					.VO_LostMobilephoneformation_By_PageAndSearch(page_list_Casematerial);

				http_response.setContentType("text/html;charset=utf-8");

				http_response.getWriter().write(gson.toJson(page_list_Casematerial));
	}
/*
 *  详细信息
 */
	public void LostMobiephoneInformationOne() throws IOException {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();
		lostMobilephoneInformationDTO = lostMobilephoneService.LostMobiephoneInformationOne(lost_mobilephone);
		http_response.setContentType("text/html;charset=utf-8");

		http_response.getWriter().write(gson.toJson(lostMobilephoneInformationDTO));
	}
	/*
	 * 修改损失手机信息 
	 */
		public void updateLostMobilephone() throws IOException{
			GsonBuilder gsonBuilder = new GsonBuilder();
			gsonBuilder.setPrettyPrinting();// 格式化json数据
			Gson gson = gsonBuilder.create();
			lostMobilephoneService.updateParallel(lost_mobilephone);
			http_response.setContentType("text/html;charset=utf-8");
			http_response.getWriter().write(gson.toJson("success"));
		}
		/*
		 *删除信息 
		 */
		public void remove_Lost_mobilephoneInformationList(){

			if(	lostMobilephoneService.remove_Lost_mobilephoneInformationList( useLost_mobilephoneInformationNumList)){
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
	public LostMobilephoneService getLostMobilephoneService() {
		return lostMobilephoneService;
	}

	public void setLostMobilephoneService(LostMobilephoneService lostMobilephoneService) {
		this.lostMobilephoneService = lostMobilephoneService;
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
	
	public xsjsglxt_case getCase1() {
		return case1;
	}
	public void setCase1(xsjsglxt_case case1) {
		this.case1 = case1;
	}
	public xsjsglxt_lost_mobilephone getLost_mobilephone() {
		return lost_mobilephone;
	}
	public void setLost_mobilephone(xsjsglxt_lost_mobilephone lost_mobilephone) {
		this.lost_mobilephone = lost_mobilephone;
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
	public page_list_CasematerialVO getPage_list_Casematerial() {
		return page_list_Casematerial;
	}
	public void setPage_list_Casematerial(page_list_CasematerialVO page_list_Casematerial) {
		this.page_list_Casematerial = page_list_Casematerial;
	}
	public LostMobilephoneInformationDTO getLostMobilephoneInformationDTO() {
		return lostMobilephoneInformationDTO;
	}
	public void setLostMobilephoneInformationDTO(LostMobilephoneInformationDTO lostMobilephoneInformationDTO) {
		this.lostMobilephoneInformationDTO = lostMobilephoneInformationDTO;
	}
	public List<String> getUseLost_mobilephoneInformationNumList() {
		return useLost_mobilephoneInformationNumList;
	}
	public void setUseLost_mobilephoneInformationNumList(List<String> useLost_mobilephoneInformationNumList) {
		this.useLost_mobilephoneInformationNumList = useLost_mobilephoneInformationNumList;
	}

}
