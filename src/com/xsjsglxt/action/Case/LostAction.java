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
import com.xsjsglxt.domain.DO.xsjsglxt_lost;
import com.xsjsglxt.domain.DTO.Case.LostInformationDTO;
import com.xsjsglxt.domain.VO.Case.page_list_CasematerialVO;
import com.xsjsglxt.service.Case.LostService;

public class LostAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {
private LostService lostService;
private xsjsglxt_case case1;
private xsjsglxt_lost lost;
private HttpServletResponse http_response;

private HttpServletRequest http_request;	

private LostInformationDTO lostInformationDTO;

private page_list_CasematerialVO page_list_Casematerial;

/*
 * 保存损失物品
 */
public void saveLost() throws IOException{
	try {
		lost.setLost_case(case1.getXsjsglxt_case_id());
		lostService.saveLost(lost);
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
public void  ListLostInformationByPageAndSearch() throws IOException{
	GsonBuilder gsonBuilder = new GsonBuilder();
	gsonBuilder.setPrettyPrinting();// 格式化json数据
	Gson gson = gsonBuilder.create();
	page_list_Casematerial = lostService
				.VO_Lostformation_By_PageAndSearch(page_list_Casematerial);

			http_response.setContentType("text/html;charset=utf-8");

			http_response.getWriter().write(gson.toJson(page_list_Casematerial));
}
/*
 * 详细信息
 */
public void LostInformationOne() throws IOException {
	GsonBuilder gsonBuilder = new GsonBuilder();
	gsonBuilder.setPrettyPrinting();// 格式化json数据
	Gson gson = gsonBuilder.create();
	lostInformationDTO = lostService.LostInformationOne(lost);
	http_response.setContentType("text/html;charset=utf-8");

	http_response.getWriter().write(gson.toJson(lostInformationDTO));
}


public LostService getLostService() {
	return lostService;
}

public void setLostService(LostService lostService) {
	this.lostService = lostService;
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
	public xsjsglxt_lost getLost() {
		return lost;
	}
	public void setLost(xsjsglxt_lost lost) {
		this.lost = lost;
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
	public LostInformationDTO getLostInformationDTO() {
		return lostInformationDTO;
	}
	public void setLostInformationDTO(LostInformationDTO lostInformationDTO) {
		this.lostInformationDTO = lostInformationDTO;
	}

}
