package com.xsjsglxt.dao.impl.Case;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xsjsglxt.dao.Case.BreakecaseDao;
import com.xsjsglxt.domain.DO.xsjsglxt_breakecase;
import com.xsjsglxt.domain.DO.xsjsglxt_breakecasesuspect;

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

	@Override
	public String saveBreakeCase(xsjsglxt_breakecase breakeCase) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		String result = (String) session.save(breakeCase);
		return result;
	}

	@Override
	public String saveBreakecaseSuspect(xsjsglxt_breakecasesuspect xsjsglxt_breakecasesuspect) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		String result = (String) session.save(xsjsglxt_breakecasesuspect);
		return result;
	}

}
