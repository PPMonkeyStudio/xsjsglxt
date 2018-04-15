package com.xsjsglxt.service.impl.User;

import java.util.List;

import com.xsjsglxt.dao.User.UserDao;
import com.xsjsglxt.domain.DO.xsjsglxt_user;
import com.xsjsglxt.domain.VO.User.showUserVO;
import com.xsjsglxt.service.User.UserService;

import util.md5;

public class UserServiceImpl implements UserService {

	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public showUserVO getUserByPage(String queryString, int currPage) {
		// TODO Auto-generated method stub

		showUserVO suv = new showUserVO();

		suv.setCurrPage(currPage);
		suv.setQueryString(queryString);
		suv.setPageSize(10);

		int count = userDao.getUserCount(queryString, currPage);

		suv.setCount(count);
		double c = count;
		int totalPage = (int) Math.ceil(c / 10);
		suv.setTotalPage(totalPage);

		List<xsjsglxt_user> list = userDao.getUserByPage(queryString, currPage);
		suv.setList(list);
		return suv;
	}

	@Override
	public void addUser(xsjsglxt_user xu) {
		// TODO Auto-generated method stub
		xu.setUser_password(md5.GetMD5Code(xu.getUser_password()));
		userDao.addUser(xu);
	}

	@Override
	public xsjsglxt_user getUserById(String user_id) {
		// TODO Auto-generated method stub
		xsjsglxt_user xu = userDao.getUserById(user_id);
		return xu;
	}

	@Override
	public void updateUser(xsjsglxt_user xu) {
		// TODO Auto-generated method stub
		userDao.updateUser(xu);
	}

	@Override
	public void deleteUser(String user_id) {
		// TODO Auto-generated method stub
		userDao.deleteUser(user_id);
	}

	@Override
	public boolean judgeUserByUsername(String user_username) {
		// TODO Auto-generated method stub

		return userDao.judgeUserByUsername(user_username);
	}

	@Override
	public xsjsglxt_user getUserByUsername(String user_username) {
		// TODO Auto-generated method stub

		return userDao.getUserByUsername(user_username);
	}

	@Override
	public void updatePassword(String user_id, String newPassword) {
		// TODO Auto-generated method stub
		userDao.updatePassword(user_id, newPassword);
	}

}
