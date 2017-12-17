package com.xsjsglxt.service.User;

import com.xsjsglxt.domain.DO.xsjsglxt_user;
import com.xsjsglxt.domain.VO.User.showUserVO;

public interface UserService {

	public showUserVO getUserByPage(String queryString, int currPage);

	public void addUser(xsjsglxt_user xu);

	public xsjsglxt_user getUserById(String user_id);

	public void updateUser(xsjsglxt_user xu);

	public void deleteUser(String user_id);

	public boolean judgeUserByUsername(String user_username);

	public xsjsglxt_user getUserByUsername(String user_username);

	public void updatePassword(String user_id, String newPassword);

}
