package com.xsjsglxt.dao.impl.Team;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xsjsglxt.dao.Team.StaffWorkDao;
import com.xsjsglxt.domain.DO.xsjsglxt_staffWork;

public class StaffWorkDaoImpl implements StaffWorkDao {
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
	public List<xsjsglxt_staffWork> getWorks(String staffWork_staff) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		String hql = "from xsjsglxt_staffWork where staffWork_staff='" + staffWork_staff + "'";
		return session.createQuery(hql).list();
	}

	@Override
	public xsjsglxt_staffWork getWork(String xsjsglxt_staffWork_id) {
		// TODO Auto-generated method stub
		return (xsjsglxt_staffWork) this.getSession().get(xsjsglxt_staffWork.class, xsjsglxt_staffWork_id);
	}

	@Override
	public String deleteWorks(String staffWork_staff) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		String hql = "delete from xsjsglxt_staffWork where staffWork_staff='" + staffWork_staff + "'";
		session.createQuery(hql).executeUpdate();
		return "deleteSuccess";
	}

	@Override
	public String deleteWork(String xsjsglxt_staffWork_id) {
		// TODO Auto-generated method stub
		xsjsglxt_staffWork work = new xsjsglxt_staffWork();
		work.setXsjsglxt_staffWork_id(xsjsglxt_staffWork_id);
		this.getSession().delete(work);
		return "deleteSuccess";
	}

	@Override
	public String saveWorks(List<xsjsglxt_staffWork> works) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		for (xsjsglxt_staffWork xsjsglxt_staffWork : works) {
			session.save(xsjsglxt_staffWork);
		}
		return "saveSuccess";
	}

}
