package com.xsjsglxt.dao.impl.InspectionIdentification;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.opensymphony.xwork2.ActionSupport;
import com.xsjsglxt.dao.InspectionIdentification.InspectionIdentificationDao;

public class InspectionIdentificationDaoImpl implements InspectionIdentificationDao {
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}
	
	
	
	
	
}
