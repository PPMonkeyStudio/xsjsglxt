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
import com.xsjsglxt.domain.VO.Case.page_list_parallelInformationVO;
import com.xsjsglxt.service.Case.ParallelService;

public class ParallelAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {
 
	private ParallelService parallelService;
	private HttpServletResponse http_response;

	private HttpServletRequest http_request;
	
	private xsjsglxt_case Case;
	private xsjsglxt_parallel parallel;
	
	private page_list_parallelInformationVO page_list_parallelInformation;
	
	/*
	 * (non-Javadoc)保存
	 * @see org.apache.struts2.interceptor.ServletResponseAware#setServletResponse(javax.servlet.http.HttpServletResponse)
	 */
	public void saveparallel() {
		
		try {
			
			//parallelService.saveParallel(CaseNumList, parallel);
			http_response.setContentType("text/html;charset=utf-8");
			http_response.getWriter().write("success");	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
	}
	/*
	 * (non-Javadoc)串并列表信息
	 * @see org.apache.struts2.interceptor.ServletResponseAware#setServletResponse(javax.servlet.http.HttpServletResponse)
	 */
	public void ListParallelInformationByPageAndSearch() throws IOException{
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();
		page_list_parallelInformation = parallelService
					.VO_Parallelformation_By_PageAndSearch(page_list_parallelInformation);

				http_response.setContentType("text/html;charset=utf-8");

				http_response.getWriter().write(gson.toJson(page_list_parallelInformation));
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

}
