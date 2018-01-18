package com.xsjsglxt.dao.impl.User;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xsjsglxt.dao.User.MeetingDao;

public class MeetingDaoImpl implements MeetingDao {
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
