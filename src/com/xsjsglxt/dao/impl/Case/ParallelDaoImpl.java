package com.xsjsglxt.dao.impl.Case;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xsjsglxt.dao.Case.ParallelDao;
import com.xsjsglxt.domain.DO.xsjsglxt_case;
import com.xsjsglxt.domain.DO.xsjsglxt_parallel;

public class ParallelDaoImpl implements ParallelDao {
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
	public void saveparallel(xsjsglxt_parallel parallel) {
		try {
			// TODO Auto-generated method stub
			getSession().save(parallel);
		} catch (Error e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public void save(xsjsglxt_case xsjsglxt_case) {
		// TODO Auto-generated method stub
		try {
			getSession().save(xsjsglxt_case);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public xsjsglxt_case getCaseByNum(String case_id) {
		// TODO Auto-generated method stub
		Session session = getSession();
		xsjsglxt_case CaseInformation = null;
		String hql = "from xsjsglxt_case Case where Case.xsjsglxt_case_id='" + case_id + "'";
		Query query = session.createQuery(hql);
		CaseInformation = (xsjsglxt_case) query.uniqueResult();
       return CaseInformation;
	}
}
