package com.xsjsglxt.service.impl.User;

import com.xsjsglxt.dao.User.UserDao;
import com.xsjsglxt.service.User.UserService;

public class UserServiceImpl implements UserService {

	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
