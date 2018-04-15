package com.xsjsglxt.action.User;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.xsjsglxt.domain.DO.xsjsglxt_user;
import com.xsjsglxt.domain.VO.User.showUserVO;
import com.xsjsglxt.service.User.UserService;

import util.TeamUtil;
import util.md5;

public class UserAction extends ActionSupport {

	private UserService userService;

	/*
	 * 
	 * 
	 * 
	 */

	public String skipToUser() {
		return "skipToUser";
	}

	public void skipToTechnologyIndex() {
		HttpServletRequest request = ServletActionContext.getRequest();
		try {
			request.getRequestDispatcher("/WEB-INF/view/technologyIndex.jsp").forward(request,
					ServletActionContext.getResponse());
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void getCurrUser() throws IOException {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		Gson gson = new Gson();
		String user_id = (String) ActionContext.getContext().getSession().get("user_id");
		if (user_id == null || user_id == "") {
			pw.write("exception");
		} else {
			xsjsglxt_user xu = userService.getUserById(user_id);
			String result = gson.toJson(xu);
			System.out.println(result);
			pw.write(result);
		}
	}

	public void judgePower() throws IOException, NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		String user_id = (String) ActionContext.getContext().getSession().get("user_id");
		if (user_id == null || user_id == "") {
			pw.write("exception");
		} else {
			xsjsglxt_user xu = userService.getUserById(user_id);
			// userBlock = userBlock.substring(0, 1).toUpperCase() +
			// userBlock.substring(1);
			// System.out.println(userBlock);
			// Method method = xu.getClass().getMethod("get" + userBlock, null);
			// String result = (String) method.invoke(xu, null);
			Gson gson = new Gson();
			String result = gson.toJson(xu);
			System.out.println(result);
			pw.write(result);
		}
	}

	public void login() throws IOException {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		if (!userService.judgeUserByUsername(user_username)) {

			pw.write("UserNoExist");
		} else {
			xsjsglxt_user xu = userService.getUserByUsername(user_username);
			String password = md5.GetMD5Code(user_password);

			if (xu.getUser_password().equals(password)) {
				pw.write("loginSuccess");
				ActionContext.getContext().getSession().put("user_id", xu.getUser_id());
				ActionContext.getContext().getSession().put("user_name", xu.getUser_name());
				ActionContext.getContext().getSession().put("userSession", xu);
			} else {
				pw.write("passwordError");
			}
		}
		pw.flush();
		pw.close();

	}

	public String logout() {
		ActionContext.getContext().getSession().remove("user_id");
		ActionContext.getContext().getSession().remove("user_name");
		return "logoutSuccess";
	}

	public void updatePassword() throws IOException {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		String user_id = (String) ActionContext.getContext().getSession().get("user_id");
		if (user_id != null || user_id != "") {
			xsjsglxt_user xu = userService.getUserById(user_id);
			if (xu.getUser_password().equals(md5.GetMD5Code(oldPassword))) {
				userService.updatePassword(user_id, md5.GetMD5Code(newPassword));
				pw.write("updateSuccess");
			} else {
				pw.write("oldPasswordError");
			}
		} else

		{
			pw.write("updateFail");
		}
	}

	public String index() {
		return "index";
	}

	public String navbar() {
		return "navbar";
	}

	/**
	 * ��������ҳ��ȡ�û�
	 * 
	 * @param queryString
	 *            ��ѯ����
	 * @param currPage
	 *            ��ǰҳ��
	 * @return void
	 * @throws IOException
	 */

	public void getUser() throws IOException {
		showUserVO suv = userService.getUserByPage(queryString, currPage);
		Gson gson = new Gson();
		String result = gson.toJson(suv);
		System.out.println(result);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		pw.write(result);
		pw.flush();
		pw.close();
	}

	/**
	 * �����û�
	 * 
	 * @return void
	 * @throws IOException
	 */

	public void addUser() throws IOException {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		xsjsglxt_user xu = new xsjsglxt_user();
		xu.setUser_army_manager_power(user_army_manager_power);
		xu.setUser_case_query_power(user_case_query_power);
		xu.setUser_case_technology_power(user_case_technology_power);
		xu.setUser_check_power(user_check_power);
		xu.setUser_gmt_create(TeamUtil.getStringSecond());
		xu.setUser_gmt_modified(TeamUtil.getStringSecond());
		xu.setUser_id(TeamUtil.getUuid());
		xu.setUser_name(user_name);
		xu.setUser_number(user_number);
		xu.setUser_password(user_password);
		xu.setUser_duty(user_duty);
		xu.setUser_idCard(user_idCard);
		xu.setUser_statistics_power(user_statistics_power);
		xu.setUser_technology_manager_power(user_technology_manager_power);
		xu.setUser_units(user_units);
		xu.setUser_user_manager_power(user_user_manager_power);
		// �ж��û����Ƿ�Ψһ
		if (userService.judgeUserByUsername(user_username)) {
			pw.write("用户名已经存在");
		} else {
			xu.setUser_username(user_username);
			userService.addUser(xu);
			pw.write("添加成功");
		}

		pw.flush();
		pw.close();
	}

	/**
	 * ͨ���û�id����û�
	 * 
	 * @param user_id
	 * @return void
	 * @throws IOException
	 * 
	 */

	public void getUserById() throws IOException {
		xsjsglxt_user xu = userService.getUserById(user_id);
		Gson gson = new Gson();
		String result = gson.toJson(xu);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		pw.write(result);
		pw.flush();
		pw.close();
	}

	/**
	 * @return void
	 */

	public void updateUser() {
		xsjsglxt_user xuGet = userService.getUserById(user_id);
		xsjsglxt_user xu = new xsjsglxt_user();
		xu.setUser_army_manager_power(user_army_manager_power);
		xu.setUser_case_query_power(user_case_query_power);
		xu.setUser_case_technology_power(user_case_technology_power);
		xu.setUser_check_power(user_check_power);
		xu.setUser_gmt_create(xuGet.getUser_gmt_create());
		xu.setUser_gmt_modified(TeamUtil.getStringSecond());
		xu.setUser_id(user_id);
		xu.setUser_duty(user_duty);
		xu.setUser_idCard(user_idCard);
		xu.setUser_name(user_name);
		xu.setUser_number(user_number);
		if (user_password == "" || user_password.equals("")) {
			xu.setUser_password(xuGet.getUser_password());
		} else {
			xu.setUser_password(user_password);
		}
		xu.setUser_statistics_power(user_statistics_power);
		xu.setUser_technology_manager_power(user_technology_manager_power);
		xu.setUser_units(user_units);
		xu.setUser_user_manager_power(user_user_manager_power);
		xu.setUser_username(user_username);
		userService.updateUser(xu);
	}

	/**
	 * @param user_id
	 * 
	 * @return void
	 * @throws IOException
	 */

	public void deleteUser() throws IOException {
		userService.deleteUser(user_id);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		pw.write("删除成功");
		pw.flush();
		pw.close();
	}

	// --------------------------------------------------------�������--------------------------------------------------------------
	/*
	 *
	 * 
	 * 
	 * 
	 */
	private String queryString;
	private int currPage;
	private String user_id;
	private String user_username;
	private String user_password;
	private String user_name;
	private String user_number;
	private String user_units;
	private String user_case_technology_power;
	private String user_case_query_power;
	private String user_check_power;
	private String user_army_manager_power;
	private String user_technology_manager_power;
	private String user_statistics_power;
	private String user_user_manager_power;
	private String oldPassword;
	private String newPassword;
	private String userBlock;
	private String user_duty;
	private String user_idCard;

	public String getUser_duty() {
		return user_duty;
	}

	public void setUser_duty(String user_duty) {
		this.user_duty = user_duty;
	}

	public String getUser_idCard() {
		return user_idCard;
	}

	public void setUser_idCard(String user_idCard) {
		this.user_idCard = user_idCard;
	}

	public String getUserBlock() {
		return userBlock;
	}

	public void setUserBlock(String userBlock) {
		this.userBlock = userBlock;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_username() {
		return user_username;
	}

	public void setUser_username(String user_username) {
		this.user_username = user_username;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_number() {
		return user_number;
	}

	public void setUser_number(String user_number) {
		this.user_number = user_number;
	}

	public String getUser_units() {
		return user_units;
	}

	public void setUser_units(String user_units) {
		this.user_units = user_units;
	}

	public String getUser_case_technology_power() {
		return user_case_technology_power;
	}

	public void setUser_case_technology_power(String user_case_technology_power) {
		this.user_case_technology_power = user_case_technology_power;
	}

	public String getUser_case_query_power() {
		return user_case_query_power;
	}

	public void setUser_case_query_power(String user_case_query_power) {
		this.user_case_query_power = user_case_query_power;
	}

	public String getUser_check_power() {
		return user_check_power;
	}

	public void setUser_check_power(String user_check_power) {
		this.user_check_power = user_check_power;
	}

	public String getUser_army_manager_power() {
		return user_army_manager_power;
	}

	public void setUser_army_manager_power(String user_army_manager_power) {
		this.user_army_manager_power = user_army_manager_power;
	}

	public String getUser_technology_manager_power() {
		return user_technology_manager_power;
	}

	public void setUser_technology_manager_power(String user_technology_manager_power) {
		this.user_technology_manager_power = user_technology_manager_power;
	}

	public String getUser_statistics_power() {
		return user_statistics_power;
	}

	public void setUser_statistics_power(String user_statistics_power) {
		this.user_statistics_power = user_statistics_power;
	}

	public String getUser_user_manager_power() {
		return user_user_manager_power;
	}

	public void setUser_user_manager_power(String user_user_manager_power) {
		this.user_user_manager_power = user_user_manager_power;
	}

	public String getQueryString() {
		return queryString;
	}

	public void setQueryString(String queryString) {
		this.queryString = queryString;
	}

	public int getCurrPage() {
		return currPage;
	}

	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
