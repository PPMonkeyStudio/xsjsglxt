package com.xsjsglxt.dao.impl.informationmanagement;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xsjsglxt.dao.informationmanagement.LoginOrLogoutDao;

public class LoginOrLogoutDaoImpl implements LoginOrLogoutDao {
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public int saveTest(Object object) {
		int i = 1;
		try {
			getSession().saveOrUpdate(object);
		} catch (Exception e) {
			i = 2;
			e.printStackTrace();
		}
		return i;
	}

}