package com.xsjsglxt.action.User;

import com.opensymphony.xwork2.ActionSupport;
import com.xsjsglxt.service.User.MemorabiliaService;

public class MemorabiliaAction extends ActionSupport {
	private MemorabiliaService memorabiliaService;

	// ----------------------------------------------getter/setter------------------------------------------------------
	public MemorabiliaService getMemorabiliaService() {
		return memorabiliaService;
	}

	public void setMemorabiliaService(MemorabiliaService memorabiliaService) {
		this.memorabiliaService = memorabiliaService;
	}
}
