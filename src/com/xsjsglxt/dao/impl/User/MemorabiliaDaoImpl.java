package com.xsjsglxt.dao.impl.User;

import org.hibernate.SessionFactory;

import com.xsjsglxt.dao.User.MemorabiliaDao;

public class MemorabiliaDaoImpl implements MemorabiliaDao {
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
