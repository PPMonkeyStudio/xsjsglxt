package com.xsjsglxt.action.informationmanagement;

import com.opensymphony.xwork2.ActionSupport;
import com.xsjsglxt.domain.DO.test;
import com.xsjsglxt.service.informationmanagement.LoginOrLogoutService;

public class LoginOrLogoutAction extends ActionSupport {
	private test te;
	public test getTest() {
		return te;
	}
	public void setTest(test test) {
		this.te = test;
	}

	private LoginOrLogoutService loginOrLogoutService;

	/*
	 * 
	 * 
	 * 
	 */
	public void login() {
	}

	public String index() {
		System.out.println("fff");
		System.out.println(te.getUsername());
		System.out.println(te.getPassword());
		int i = loginOrLogoutService.saveTest(te);
		return "index";
	}

	/*
	 * 
	 * 
	 * 
	 */
	public void setLoginOrLogoutService(LoginOrLogoutService loginOrLogoutService) {
		this.loginOrLogoutService = loginOrLogoutService;
	}

	
}
