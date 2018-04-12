package com.xsjsglxt.action.Case;

import com.opensymphony.xwork2.ActionSupport;
import com.xsjsglxt.service.Case.BreakecaseService;

public class BreakecaseAction extends ActionSupport {
	private BreakecaseService breakecaseService;

	public BreakecaseService getBreakecaseService() {
		return breakecaseService;
	}

	public void setBreakecaseService(BreakecaseService breakecaseService) {
		this.breakecaseService = breakecaseService;
	}

}