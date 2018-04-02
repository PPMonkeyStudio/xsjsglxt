package com.xsjsglxt.dao.impl.Team;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xsjsglxt.dao.Team.StaffPrincipleDao;
import com.xsjsglxt.domain.DO.xsjsglxt_staffPrinciple;

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

	@Override
	public String savePrinciples(List<xsjsglxt_staffPrinciple> principles) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		for (xsjsglxt_staffPrinciple xsjsglxt_staffPrinciple : principles) {
			session.save(xsjsglxt_staffPrinciple);
		}
		return "saveSuccess";
	}

	@Override
	public String deletePrinciple(xsjsglxt_staffPrinciple principle) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		session.delete(principle);
		return "deleteSuccess";
	}

	@Override
	public String deletePrinciples(String staffPrinciple_staff) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		String hql = "delete from xsjsglxt_staffPrinciple where staffPrinciple_staff='" + staffPrinciple_staff + "'";
		session.createQuery(hql).executeUpdate();
		return "deleteSuccess";
	}

	@Override
	public xsjsglxt_staffPrinciple getPrincipleByPrincipleId(String xsjsglxt_staffPrinciple_id) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		return (xsjsglxt_staffPrinciple) session.get(xsjsglxt_staffPrinciple.class, xsjsglxt_staffPrinciple_id);
	}

	@Override
	public List<xsjsglxt_staffPrinciple> getPrinciples(String staffPrinciple_staff) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		String hql = "from xsjsglxt_staffPrinciple where staffPrinciple_staff='" + staffPrinciple_staff + "'";
		Query query = session.createQuery(hql);
		return query.list();
	}

}
