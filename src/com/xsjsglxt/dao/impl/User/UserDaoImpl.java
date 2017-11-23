package com.xsjsglxt.dao.impl.User;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xsjsglxt.dao.User.UserDao;

public class UserDaoImpl implements UserDao {
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

}