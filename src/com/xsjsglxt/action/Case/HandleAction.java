package com.xsjsglxt.action.Case;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;
import com.xsjsglxt.service.Case.HandleService;

public class HandleAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {
private HandleService handleService;
private HttpServletResponse http_response;
private HttpServletRequest http_request;	

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

}
