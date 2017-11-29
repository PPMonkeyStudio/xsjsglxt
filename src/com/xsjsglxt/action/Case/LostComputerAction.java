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
import com.xsjsglxt.domain.DO.xsjsglxt_lost_computer;
import com.xsjsglxt.domain.DO.xsjsglxt_lost_mobilephone;
import com.xsjsglxt.domain.VO.Case.page_list_CasematerialVO;
import com.xsjsglxt.service.Case.LostComputerService;

public class LostComputerAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {
 private LostComputerService lostComputerService;
	private xsjsglxt_case Case;
	private xsjsglxt_lost_computer lost_computer;
	private HttpServletResponse http_response;

	private HttpServletRequest http_request;	

	private page_list_CasematerialVO page_list_Casematerial;
	
	/*
	 * 保存损失电脑
	 */
	public void saveLostComputer() throws IOException{
		try {
			lost_computer.setLost_computer_case(Case.getXsjsglxt_case_id());
			lostComputerService.saveLostComputer(lost_computer);
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
	 * 损失电脑列表
	 */
	public void  ListLostComputerInformationByPageAndSearch() throws IOException{
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();
		page_list_Casematerial = lostComputerService
					.VO_LostComputerformation_By_PageAndSearch(page_list_Casematerial);

				http_response.setContentType("Computerztext/html;charset=utf-8");

				http_response.getWriter().write(gson.toJson(page_list_Casematerial));
	}
	
	public LostComputerService getLostComputerService() {
	return lostComputerService;
}

public void setLostComputerService(LostComputerService lostComputerService) {
	this.lostComputerService = lostComputerService;
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
	public xsjsglxt_case getCase() {
		return Case;
	}
	public void setCase(xsjsglxt_case case1) {
		Case = case1;
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
	public page_list_CasematerialVO getPage_list_Casematerial() {
		return page_list_Casematerial;
	}
	public void setPage_list_Casematerial(page_list_CasematerialVO page_list_Casematerial) {
		this.page_list_Casematerial = page_list_Casematerial;
	}

}
