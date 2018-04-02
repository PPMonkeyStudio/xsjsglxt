package com.xsjsglxt.dao.impl.Team;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xsjsglxt.dao.Team.StaffRewardDao;
import com.xsjsglxt.domain.DO.xsjsglxt_staffReward;

public class StaffRewardDaoImpl implements StaffRewardDao {
	private SessionFactory sessionFactory;

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
	public String saveRewards(List<xsjsglxt_staffReward> rewards) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		for (xsjsglxt_staffReward xsjsglxt_staffReward : rewards) {
			session.save(xsjsglxt_staffReward);
		}
		return "saveSuccess";
	}

	@Override
	public String deleteReward(String xsjsglxt_staffReward_id) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		xsjsglxt_staffReward x = new xsjsglxt_staffReward();
		x.setXsjsglxt_staffReward_id(xsjsglxt_staffReward_id);
		session.delete(x);
		return "deleteSuccess";
	}

	@Override
	public String deleteRewards(String staffReward_staff) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		String hql = "delete from xsjsglxt_staffReward where staffReward_staff='" + staffReward_staff + "'";
		session.createQuery(hql).executeUpdate();
		return "deleteSuccess";
	}

	@Override
	public xsjsglxt_staffReward getReward(String xsjsglxt_staffReward_id) {
		// TODO Auto-generated method stub
		return (xsjsglxt_staffReward) this.getSession().get(xsjsglxt_staffReward.class, xsjsglxt_staffReward_id);
	}

	@Override
	public List<xsjsglxt_staffReward> getRewards(String staffReward_staff) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		String hql = "from xsjsglxt_staffReward where staffReward_staff = '" + staffReward_staff + "'";
		List<xsjsglxt_staffReward> rewards = session.createQuery(hql).list();
		return rewards;
	}

}
