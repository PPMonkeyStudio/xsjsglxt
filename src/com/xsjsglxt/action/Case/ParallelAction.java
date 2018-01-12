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
import com.xsjsglxt.domain.DO.xsjsglxt_parallel;
import com.xsjsglxt.domain.DTO.Case.ParallelInformationDTO;
import com.xsjsglxt.domain.VO.Case.page_list_parallelInformationVO;
import com.xsjsglxt.service.Case.ParallelService;

public class ParallelAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {

	private ParallelService parallelService;
	private HttpServletResponse http_response;

	private HttpServletRequest http_request;

	private xsjsglxt_case case1;
	private xsjsglxt_parallel parallel;

	private page_list_parallelInformationVO page_list_parallelInformation;
	private List<String> useParallelInformationNumList;
	private String caeNumList;
	
	private ParallelInformationDTO parallelInformationDTO;

	/*
	 *保存串并案件信息
	 * 
	 */
	public void saveparallel() {

		try {

			parallelService.saveParallel(caeNumList, parallel);
			http_response.setContentType("text/html;charset=utf-8");
			http_response.getWriter().write("success");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}

	/*
	 * 列表信息
	 * 
	 */
	public void ListParallelInformationByPageAndSearch() throws IOException {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();
		page_list_parallelInformation = parallelService
				.VO_Parallelformation_By_PageAndSearch(page_list_parallelInformation);

		http_response.setContentType("text/html;charset=utf-8");

		http_response.getWriter().write(gson.toJson(page_list_parallelInformation));
	}

	/*
	 *串并案件的详细信息
	 * 
	 */
	public void ParallelInformationOne() throws IOException{
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();
		parallelInformationDTO = parallelService.ParallelInformationOne(parallel);
		http_response.setContentType("text/html;charset=utf-8");

		http_response.getWriter().write(gson.toJson(parallelInformationDTO));
	}
	/*
	 * 获得串并编号
	 *
	 */
	public void getParallelNum() throws IOException {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();
		String ParallelNum = parallelService.getMaxParallelNum();
		System.out.println("串并号"+ParallelNum);
		http_response.setContentType("text/html;charset=utf-8");
		http_response.getWriter().write(gson.toJson(ParallelNum));
	}   
	/*
	 *修改串并案件的信息 
	 */
	public void updateParallel() throws IOException{
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();
		parallelService.updateParallel(parallel);
		http_response.setContentType("text/html;charset=utf-8");
		http_response.getWriter().write(gson.toJson("success"));
	}
	/*
	 *删除信息 
	 */
	public void remove_ParallelInformationList(){

		if(	parallelService.remove_ParallelInformationList( useParallelInformationNumList)){
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
	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
		this.http_response = arg0;
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		this.http_request = arg0;
	}

	public ParallelService getParallelService() {
		return parallelService;
	}

	public void setParallelService(ParallelService parallelService) {
		this.parallelService = parallelService;
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

	

	public xsjsglxt_case getCase1() {
		return case1;
	}

	public void setCase1(xsjsglxt_case case1) {
		this.case1 = case1;
	}

	public xsjsglxt_parallel getParallel() {
		return parallel;
	}

	public void setParallel(xsjsglxt_parallel parallel) {
		this.parallel = parallel;
	}

	public page_list_parallelInformationVO getPage_list_parallelInformation() {
		return page_list_parallelInformation;
	}

	public void setPage_list_parallelInformation(page_list_parallelInformationVO page_list_parallelInformation) {
		this.page_list_parallelInformation = page_list_parallelInformation;
	}

	

	

	public String getCaeNumList() {
		return caeNumList;
	}

	public void setCaeNumList(String caeNumList) {
		this.caeNumList = caeNumList;
	}

	public ParallelInformationDTO getParallelInformationDTO() {
		return parallelInformationDTO;
	}

	public void setParallelInformationDTO(ParallelInformationDTO parallelInformationDTO) {
		this.parallelInformationDTO = parallelInformationDTO;
	}

	public List<String> getUseParallelInformationNumList() {
		return useParallelInformationNumList;
	}

	public void setUseParallelInformationNumList(List<String> useParallelInformationNumList) {
		this.useParallelInformationNumList = useParallelInformationNumList;
	}

}
