package com.xsjsglxt.dao.impl.Case;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xsjsglxt.dao.Case.HandleDao;

public class HandleDaoImpl implements HandleDao {
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
