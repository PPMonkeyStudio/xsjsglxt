package com.xsjsglxt.dao.impl.Case;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xsjsglxt.dao.Case.BreakecaseDao;

public class BreakecaseDaoImpl implements BreakecaseDao {
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;

	}

	public Session getSession() {

		return this.sessionFactory.getCurrentSession();
	}

}
