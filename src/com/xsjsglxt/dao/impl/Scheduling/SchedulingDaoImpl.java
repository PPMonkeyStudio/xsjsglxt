package com.xsjsglxt.dao.impl.Scheduling;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xsjsglxt.dao.Scheduling.SchedulingDao;
import com.xsjsglxt.domain.DO.xsjsglxt_scheduling;

/**
 * 
 * @author 孙毅
 *排班dao层
 */
public class SchedulingDaoImpl implements SchedulingDao {
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	// 通过日期获得一个排班
	@Override
	public xsjsglxt_scheduling getSchedulingByDate(xsjsglxt_scheduling scheduling) {
		// TODO Auto-generated method stub
		String hql = "from xsjsglxt_scheduling where scheduling_time = '" + scheduling.getScheduling_time() + "'";
		Session session = this.getSession();
		xsjsglxt_scheduling oldScheduling = (xsjsglxt_scheduling) session.createQuery(hql).uniqueResult();
		return oldScheduling;
	}

	@Override
	public boolean saveScheduling(xsjsglxt_scheduling scheduling) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		try {
			session.save(scheduling);
			return true;
		} catch (HibernateException e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public xsjsglxt_scheduling getSchedulingById(String xsjsglxt_scheduling_id) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		return (xsjsglxt_scheduling) session.get(xsjsglxt_scheduling.class, xsjsglxt_scheduling_id);
	}

	@Override
	public boolean deleteScheduling(String string) {
		// TODO Auto-generated method stub
		xsjsglxt_scheduling scheduling = new xsjsglxt_scheduling();
		scheduling.setXsjsglxt_scheduling_id(string);
		Session session = this.getSession();
		try {
			session.delete(scheduling);
			return true;
		} catch (HibernateException e) {
			// TODO: handle exception
			return false;
		}

	}

	@Override
	public void updateScheduling(xsjsglxt_scheduling scheduling) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		session.saveOrUpdate(scheduling);
	}
}
