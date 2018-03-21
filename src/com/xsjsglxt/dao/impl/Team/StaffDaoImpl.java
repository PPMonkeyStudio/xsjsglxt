
package com.xsjsglxt.dao.impl.Team;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xsjsglxt.dao.Team.StaffDao;
import com.xsjsglxt.domain.DO.xsjsglxt_staff;

public class StaffDaoImpl implements StaffDao {
	private SessionFactory sessionFactory;
	private final static String DELETE = "deleteSuccess";
	private final static String UPDATE = "updateSuccess";

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

	@Override
	public String deletePoliceman(xsjsglxt_staff policeman) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		session.delete(policeman);
		return DELETE;
	}

	@Override
	public xsjsglxt_staff getPolicemanByStaffId(String xsjsglxt_staff_id) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		return (xsjsglxt_staff) session.get(xsjsglxt_staff.class, xsjsglxt_staff_id);
	}

	@Override
	public String updatePoliceman(xsjsglxt_staff policeman) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		session.saveOrUpdate(policeman);
		return UPDATE;
	}

}
