package com.xsjsglxt.service.impl.informationmanagement;

import com.xsjsglxt.dao.informationmanagement.LoginOrLogoutDao;
import com.xsjsglxt.domain.DO.test;
import com.xsjsglxt.service.informationmanagement.LoginOrLogoutService;

public class LoginOrLogoutServiceImpl implements LoginOrLogoutService {

	private LoginOrLogoutDao loginOrLogoutDao;

	public LoginOrLogoutDao getLoginOrLogoutDao() {
		return loginOrLogoutDao;
	}

	public void setLoginOrLogoutDao(LoginOrLogoutDao loginOrLogoutDao) {
		this.loginOrLogoutDao = loginOrLogoutDao;
	}

	@Override
	public int saveTest(test test) {
		int i = loginOrLogoutDao.saveTest(test);
		return i;
	}

	
}
