package com.xsjsglxt.dao.impl.User;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xsjsglxt.dao.User.UserDao;
import com.xsjsglxt.domain.DO.xsjsglxt_user;

public class UserDaoImpl implements UserDao {
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public int getUserCount(String queryString, int currPage) {
		// TODO Auto-generated method stub
		String query = "%" + queryString + "%";
		String hql = "select count(*) from xsjsglxt_user where (user_name like '" + query + "' or user_units like '"
				+ query + "' or user_number like '" + query + "')";
		System.out.println(hql);
		int count = ((Number) getSession().createQuery(hql).uniqueResult()).intValue();
		return count;
	}

	@Override
	public List<xsjsglxt_user> getUserByPage(String queryString, int currPage) {
		// TODO Auto-generated method stub
		String query = "%" + queryString + "%";
		String hql = "from xsjsglxt_user where (user_name like '" + query + "' or user_units like '" + query
				+ "' or user_number like '" + query + "') order by user_gmt_create desc";
		List<xsjsglxt_user> list = getSession().createQuery(hql).setFirstResult((currPage - 1) * 10).setMaxResults(10)
				.list();
		System.out.println("得到十条用户信息:" + list.size());
		return list;
	}

	@Override
	public void addUser(xsjsglxt_user xu) {
		// TODO Auto-generated method stub
		getSession().save(xu);
	}

	@Override
	public xsjsglxt_user getUserById(String user_id) {
		// TODO Auto-generated method stub
		xsjsglxt_user xu = (xsjsglxt_user) getSession().get(xsjsglxt_user.class, user_id);
		return xu;
	}

	@Override
	public void updateUser(xsjsglxt_user xu) {
		// TODO Auto-generated method stub
		getSession().saveOrUpdate(xu);
	}

	@Override
	public void deleteUser(String user_id) {
		// TODO Auto-generated method stub
		String hql = "delete from xsjsglxt_user where user_id = '" + user_id + "'";
		getSession().createQuery(hql).executeUpdate();
	}

	@Override
	public boolean judgeUserByUsername(String user_username) {
		// TODO Auto-generated method stub

		String hql = "from xsjsglxt_user where user_username = '" + user_username + "'";
		Query query = getSession().createQuery(hql);
		List<xsjsglxt_user> list = query.list();
		if (list.size() <= 0) {
			return false; // 用户名不存在
		} else {
			return true; // 用户名存在
		}

	}

	@Override
	public xsjsglxt_user getUserByUsername(String user_username) {
		// TODO Auto-generated method stub
		String hql = "from xsjsglxt_user where user_username = '" + user_username + "'";
		Query query = getSession().createQuery(hql);
		List<xsjsglxt_user> list = query.list();
		return list.get(0);
	}

	@Override
	public void updatePassword(String user_id, String newPassword) {
		// TODO Auto-generated method stub
		String hql = "update xsjsglxt_user set user_password ='" + newPassword + "' where user_id = '" + user_id + "'";
		getSession().createQuery(hql).executeUpdate();
	}

}