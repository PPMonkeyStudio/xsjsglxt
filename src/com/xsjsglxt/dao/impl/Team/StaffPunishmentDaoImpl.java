package com.xsjsglxt.dao.impl.Team;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xsjsglxt.dao.Team.StaffPunishmentDao;
import com.xsjsglxt.domain.DO.xsjsglxt_staffPunishment;

public class StaffPunishmentDaoImpl implements StaffPunishmentDao {
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
	public String savePunishment(List<xsjsglxt_staffPunishment> punishments) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		for (xsjsglxt_staffPunishment xsjsglxt_staffPunishment : punishments) {
			session.save(xsjsglxt_staffPunishment);
		}
		return "saveSuccess";
	}

	@Override
	public String deletePunishment(String xsjsglxt_staffPunishment_id) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		String hql = "delete from xsjsglxt_staffPunishment where xsjsglxt_staffPunishment_id ='"
				+ xsjsglxt_staffPunishment_id + "'";
		session.createQuery(hql).executeUpdate();
		return "deleteSuccess";
	}

	@Override
	public String deletePunishments(String staffPunishment_staff) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		String hql = "delete from xsjsglxt_staffPunishment where staffPunishment_staff='" + staffPunishment_staff + "'";
		session.createQuery(hql).executeUpdate();
		return "deleteSuccess";
	}

	@Override
	public xsjsglxt_staffPunishment getPunishment(String xsjsglxt_staffPunishment_id) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		xsjsglxt_staffPunishment oldPunishment = (xsjsglxt_staffPunishment) session.get(xsjsglxt_staffPunishment.class,
				xsjsglxt_staffPunishment_id);
		return oldPunishment;
	}

	@Override
	public List<xsjsglxt_staffPunishment> getPunishments(String staffPunishment_staff) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		String hql = "from xsjsglxt_staffPunishment where staffPunishment_staff='" + staffPunishment_staff + "'";
		List<xsjsglxt_staffPunishment> punishments = session.createQuery(hql).list();
		return punishments;
	}

}
