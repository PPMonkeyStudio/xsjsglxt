package com.xsjsglxt.dao.impl.User;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xsjsglxt.dao.User.MeetingDao;
import com.xsjsglxt.domain.DO.xsjsglxt_meeting;
import com.xsjsglxt.domain.DTO.User.meetingSearchDTO;
import com.xsjsglxt.domain.VO.User.meetingByPageAndSerarchVO;

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
	public String deleteMeetingRecords(String[] meeting_ids) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		try {

			for (int i = 0; i < meeting_ids.length; i++) {
				String hql = "delete xsjsglxt_meeting where meeting_id = '" + meeting_ids[i] + "'";
				Query query = session.createQuery(hql);
				query.executeUpdate();
			}
			session.clear();
		} catch (Exception e) {
			// TODO: handle exception
			return "deleteFail";
		}

		return "deleteSuccess";
	}

	// 通过id获得会议记录书
	@Override
	public xsjsglxt_meeting getMeetingRecordsById(String meeting_id) {
		// TODO Auto-generated method stub
		meeting_id = "1";
		Session session = this.getSession();
		xsjsglxt_meeting meet = (xsjsglxt_meeting) session.get(xsjsglxt_meeting.class, meeting_id);
		return meet;
	}

	// 通过筛选获得会议记录书全部数据
	@Override
	public int getCountMeetRecordsBySearch(meetingByPageAndSerarchVO meetVO) {
		// TODO Auto-generated method stub
		String queryContent = "%" + meetVO.getQueryCondition() + "%";

		String hql = "select count(*) from xsjsglxt_meeting meet where meet.meeting_title like'" + queryContent
				+ "' and meet.meeting_place like '" + queryContent + "' and meet.meeting_compere like '" + queryContent
				+ "'";
		long count = (long) this.getSession().createQuery(hql).uniqueResult();
		return (int) count;
	}

	// 通过筛选获得所有会议记录书
	@Override
	public meetingSearchDTO ListMeetRecordsBySearch(meetingByPageAndSerarchVO meetVO) {
		// TODO Auto-generated method stub
		return null;
	}

}
