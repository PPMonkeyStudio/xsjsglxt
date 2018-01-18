package com.xsjsglxt.dao.impl.User;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xsjsglxt.dao.User.MeetingDao;
import com.xsjsglxt.domain.DO.xsjsglxt_meeting;

public class MeetingDaoImpl implements MeetingDao {
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

	// 保存会议记录书

	@Override
	public String saveMeetingRecords(xsjsglxt_meeting meet) {
		// TODO Auto-generated method stub

		try {
			Session session = this.getSession();
			session.saveOrUpdate(meet);
			session.clear();
		} catch (Exception e) {
			// TODO: handle exception
			return "saveFail";
		}

		return "savueSuccess";
	}

	// 修改会议记录书
	@Override
	public String updateMeetingRecords(xsjsglxt_meeting meet) {
		// TODO Auto-generated method stub
		try {
			Session session = this.getSession();
			session.saveOrUpdate(meet);
			session.clear();
		} catch (Exception e) {
			// TODO: handle exception
			return "updateFail";
		}

		return "updateSuccess";
	}

	// 批量删除会议记录书

	@Override
	public String deleteMeetingRecords(String[] meeting_id) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		try {

			for (int i = 0; i < meeting_id.length; i++) {
				String hql = "delete xsjsglxt_meeting where meeting_id = '" + meeting_id[i] + "'";
				Query query = session.createQuery(hql);
				query.executeUpdate();
			}
		} catch (Exception e) {
			// TODO: handle exception
			return "deleteFail";
		}

		return "deleteSuccess";
	}
}
