
package com.xsjsglxt.dao.impl.Team;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xsjsglxt.dao.Team.StaffDao;
import com.xsjsglxt.domain.DO.xsjsglxt_staff;

public class StaffDaoImpl implements StaffDao {
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

	@Override
	public String savePoliceman(xsjsglxt_staff policeman) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		session.save(policeman);
		return "saveSuccess";
	}

}
