package com.xsjsglxt.dao.impl.Team;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xsjsglxt.dao.Team.StaffFurloughDao;
import com.xsjsglxt.domain.DO.xsjsglxt_staffFurlough;

public class StaffFurloughDaoImpl implements StaffFurloughDao {
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
	public String saveFurlough(xsjsglxt_staffFurlough furlough) {
		// TODO Auto-generated method stub

		Session session = this.getSession();
		session.save(furlough);
		return "saveSuccess";
	}

	@Override
	public String deleteFurloughByFurloughId(xsjsglxt_staffFurlough furlough) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		session.delete(furlough);
		return "deleteSuccess";
	}

	@Override
	public String deleteFurloughByStaffId(String staffFurlough_staff) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		String hql = "delete from xsjsglxt_staffFurlough where staffFurlough_staff = '" + staffFurlough_staff + "'";
		Query query = session.createQuery(hql);
		query.executeUpdate();
		return "deleteSuccess";
	}

	@Override
	public xsjsglxt_staffFurlough getFurloughByFurloughId(String xsjsglxt_staffFurlough_id) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		xsjsglxt_staffFurlough furlough = (xsjsglxt_staffFurlough) session.get(xsjsglxt_staffFurlough.class,
				xsjsglxt_staffFurlough_id);
		session.clear();
		return furlough;
	}

	@Override
	public List<xsjsglxt_staffFurlough> getFurloughByStaffId(String staffFurlough_staff) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		String hql = "from xsjsglxt_staffFurlough where staffFurlough_staff ='" + staffFurlough_staff + "'";
		Query query = session.createQuery(hql);
		return query.list();
	}

}
