package com.xsjsglxt.action.Case;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.xsjsglxt.dao.Case.SenceDao;
import com.xsjsglxt.domain.DO.xsjsglxt_briefdetails;
import com.xsjsglxt.domain.DO.xsjsglxt_case;
import com.xsjsglxt.domain.DO.xsjsglxt_lost;
import com.xsjsglxt.domain.DO.xsjsglxt_lost_computer;
import com.xsjsglxt.domain.DO.xsjsglxt_lost_mobilephone;
import com.xsjsglxt.domain.DO.xsjsglxt_picture;
import com.xsjsglxt.domain.DO.xsjsglxt_snece;
import com.xsjsglxt.domain.DTO.Case.SenceInformationDTO;
import com.xsjsglxt.domain.VO.Case.page_list_senceInformationVO;
import com.xsjsglxt.service.Case.SenceService;


public class SenceAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {
	private SenceService senceService;
	private xsjsglxt_snece sence;
	private xsjsglxt_case case1;
	private xsjsglxt_briefdetails briefdetails;
	private xsjsglxt_lost lost;
	private xsjsglxt_lost_mobilephone lost_mobilephone;
	private xsjsglxt_picture picture;
	private xsjsglxt_lost_computer lost_computer;
	private List<String> useSenceInformationNumList;
	private HttpServletResponse http_response;

	private HttpServletRequest http_request;

	private page_list_senceInformationVO page_list_senceInformation;

	private SenceInformationDTO senceInformationDTO;

	/*
	 * 跳转页面
	 */
	public String page_SiteManagement() {
		return "page_SiteManagement";
	}

	/*
	 * 跳转现场录入页面
	 */
	public String page_Sneceinput() {
		return "page_Sneceinput";
	}

	/*
	 * ��ת�ֳ�¼��ҳ��
	 */
	public String page_CaseMergerList() {
		return "page_CaseMergerList";
	}



	/*
	 * 跳转现场录入页面
	 */
	public String page_CaseMerger() {
		return "page_CaseMerger";
	}

	/*

	 * ��ת�ֳ�¼��ҳ��

	 */
	public String page_CaseMaterials() {
		return "page_CaseMaterials";
	}

	/*

	 * ��ת��������ҳ��

	 */
	public String page_CaseDetails() {
		ActionContext.getContext().getValueStack().set("id", http_request.getParameter("id"));
		return "page_CaseDetails";
	}

	/*

	 * 保存信息

	 */
	public void saveSenceInformation() {

		try {
			GsonBuilder gsonBuilder = new GsonBuilder();
			gsonBuilder.setPrettyPrinting();// 格式化json数据
			Gson gson = gsonBuilder.create();
			
			senceService.save(case1);

			sence.setSnece_case(case1.getXsjsglxt_case_id());
			senceService.save(sence);

			briefdetails.setBriefdetails_case(case1.getXsjsglxt_case_id());
			senceService.save(briefdetails);

			// lost.setLost_case(Case.getXsjsglxt_case_id());
			// senceService.save(lost);

			// lost_mobilephone.setLost_mobilephone_case(Case.getXsjsglxt_case_id());
			// senceService.save(lost_mobilephone);

			// lost_computer.setLost_computer_case(Case.getXsjsglxt_case_id());
			// senceService.save(lost_computer);

			// picture.setPicture_case(Case.getXsjsglxt_case_id());
			// senceService.save(picture);
			http_response.setContentType("text/html;charset=utf-8");
			http_response.getWriter().write(gson.toJson(case1.getXsjsglxt_case_id()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			http_response.setContentType("text/html;charset=utf-8");
			try {
				http_response.getWriter().write("error");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}

	/*
	 * 得到勘验编号
	 */
	public void getSenceInquestId() throws IOException {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();
		String senceInformationInquestId = senceService.getMaxSenceInquestId();
		http_response.setContentType("text/html;charset=utf-8");
		http_response.getWriter().write(gson.toJson(senceInformationInquestId));
	}

	/*
	 * 列表信息
	 */
	public void ListSneceInformationByPageAndSearch() throws IOException {

		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();

	
		page_list_senceInformation = senceService.VO_SneceInformation_By_PageAndSearch(page_list_senceInformation);

		http_response.setContentType("text/html;charset=utf-8");

		http_response.getWriter().write(gson.toJson(page_list_senceInformation));

	}

	/*
	 * 详细信息
	 */
	public void SecneInformationOne() throws IOException {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();//格式化json数据
		Gson gson = gsonBuilder.create();
		senceInformationDTO = senceService.SecneInformationOne(case1);
		http_response.setContentType("text/html;charset=utf-8");

		http_response.getWriter().write(gson.toJson(senceInformationDTO));
	}
/*
 *修改信息 
 */
	public void updateSenceInformation() throws IOException{
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();//格式化json数据
		Gson gson = gsonBuilder.create();
		senceService.updateSence(sence);
		senceService.updateCase(case1);
		senceService.updateBriefdetails(briefdetails);
		http_response.setContentType("text/html;charset=utf-8");

		http_response.getWriter().write(gson.toJson("success"));
		
	}
	/*
	 * 删除信息
	 */
	public void remove_SenceInformationList(){
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();//格式化json数据
		Gson gson = gsonBuilder.create();
		if(	senceService.remove_SenceInformationList( useSenceInformationNumList)){
			http_response.setContentType("text/html;charset=utf-8");
			try {
				http_response.getWriter().write(gson.toJson("success"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
							}
		}
	
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

	public xsjsglxt_case getCase1() {
		return case1;
	}

	public void setCase1(xsjsglxt_case case1) {
		this.case1 = case1;
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

	public xsjsglxt_picture getPicture() {
		return picture;
	}

	public void setPicture(xsjsglxt_picture picture) {
		this.picture = picture;
	}

	public page_list_senceInformationVO getPage_list_senceInformation() {
		return page_list_senceInformation;
	}

	public void setPage_list_senceInformation(page_list_senceInformationVO page_list_senceInformation) {
		this.page_list_senceInformation = page_list_senceInformation;
	}

	public SenceInformationDTO getSenceInformationDTO() {
		return senceInformationDTO;
	}

	public void setSenceInformationDTO(SenceInformationDTO senceInformationDTO) {
		this.senceInformationDTO = senceInformationDTO;
	}

	public List<String> getUseSenceInformationNumList() {
		return useSenceInformationNumList;
	}

	public void setUseSenceInformationNumList(List<String> useSenceInformationNumList) {
		this.useSenceInformationNumList = useSenceInformationNumList;
	}

}