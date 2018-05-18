package com.xsjsglxt.dao.impl.Statistics;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xsjsglxt.dao.Statistics.ExpenditureDao;
import com.xsjsglxt.domain.DO.xsjsglxt_expenditure;

public class ExpenditureDaoImpl implements ExpenditureDao {
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

	@Override
	public boolean saveExpenditure(xsjsglxt_expenditure expenditure) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		try {
			session.save(expenditure);
			return true;
		} catch (HibernateException e) {
			// TODO: handle exception
			return false;
		}

	}

	@Override
	public boolean deleteExpenditure(xsjsglxt_expenditure expenditure) {
		// TODO Auto-generated method stub
		Session session = this.getSession();

		try {
			session.delete(expenditure);
			return true;
		} catch (HibernateException e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public xsjsglxt_expenditure getExpenditureById(String expenditure_id) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		xsjsglxt_expenditure expenditure = (xsjsglxt_expenditure) session.get(xsjsglxt_expenditure.class,
				expenditure_id);
		session.clear();
		return expenditure;
	}

	@Override
	public boolean updateExpenditure(xsjsglxt_expenditure expenditure) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		try {
			session.update(expenditure);
			return true;
		} catch (HibernateException e) {
			// TODO: handle exception
			return false;
		}

	}

}
