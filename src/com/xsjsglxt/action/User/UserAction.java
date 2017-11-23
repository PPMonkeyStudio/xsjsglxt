package com.xsjsglxt.action.User;

import com.opensymphony.xwork2.ActionSupport;
import com.xsjsglxt.service.User.UserService;

public class UserAction extends ActionSupport {

	private UserService userService;

	/*
	 * 
	 * 
	 * 
	 */
	public void login() {
	}

	public String index() {
		return "index";
	}

	public String navbar() {
		return "navbar";
	}

	/*
	 *
	 * 
	 * 
	 * 
	 */
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
