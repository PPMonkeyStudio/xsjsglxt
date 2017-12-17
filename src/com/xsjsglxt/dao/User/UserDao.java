package com.xsjsglxt.dao.User;

import java.util.List;

import com.xsjsglxt.domain.DO.xsjsglxt_user;

public interface UserDao {

	int getUserCount(String queryString, int currPage);

	List<xsjsglxt_user> getUserByPage(String queryString, int currPage);

	void addUser(xsjsglxt_user xu);

	xsjsglxt_user getUserById(String user_id);

	void updateUser(xsjsglxt_user xu);

	void deleteUser(String user_id);

	boolean judgeUserByUsername(String user_username);

	xsjsglxt_user getUserByUsername(String user_username);

	void updatePassword(String user_id, String newPassword);

}
