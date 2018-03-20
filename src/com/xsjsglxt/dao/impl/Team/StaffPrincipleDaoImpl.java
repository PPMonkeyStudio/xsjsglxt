package com.xsjsglxt.dao.impl.Team;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xsjsglxt.dao.Team.StaffPrincipleDao;

public class StaffPrincipleDaoImpl implements StaffPrincipleDao {
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
