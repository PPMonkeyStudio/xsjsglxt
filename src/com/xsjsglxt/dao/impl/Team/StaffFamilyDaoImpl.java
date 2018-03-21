package com.xsjsglxt.dao.impl.Team;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xsjsglxt.dao.Team.StaffFamilyDao;
import com.xsjsglxt.domain.DO.xsjsglxt_staffFamily;

public class StaffFamilyDaoImpl implements StaffFamilyDao {
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
	public String saveFamily(List<xsjsglxt_staffFamily> family) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		for (xsjsglxt_staffFamily xsjsglxt_staffFamily : family) {
			session.save(xsjsglxt_staffFamily);
		}
		return "saveSuccess";
	}

	@Override
	public String deleteFamilyByFamilyId(xsjsglxt_staffFamily family) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		session.delete(family);
		return "deleteSuccess";
	}

	@Override
	public String deleteFamilyByStaffId(xsjsglxt_staffFamily family) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		String hql = "delete from xsjsglxt_staffFamily where staffFamily_staff = '" + family.getStaffFamily_staff()
				+ "'";
		Query query = session.createQuery(hql);
		query.executeUpdate();
		return "deleteSuccess";
	}

	@Override
	public xsjsglxt_staffFamily getFamilyByFamilyID(String xsjsglxt_staffFamily_id) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		xsjsglxt_staffFamily oldFamily = (xsjsglxt_staffFamily) session.get(xsjsglxt_staffFamily.class,
				xsjsglxt_staffFamily_id);
		session.clear();
		return oldFamily;
	}

	@Override
	public String updateFamilyByFamilyId(xsjsglxt_staffFamily family) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		session.clear();
		session.saveOrUpdate(family);
		return "updateSuccess";
	}

	@Override
	public List<xsjsglxt_staffFamily> getFamilyByStaffId(String staffFamily_staff) {
		// TODO Auto-generated method stub

		Session session = this.getSession();
		String hql = "from xsjsglxt_staffFamily where staffFamily_staff= '" + staffFamily_staff + "'";
		Query query = session.createQuery(hql);
		return query.list();
	}

}
