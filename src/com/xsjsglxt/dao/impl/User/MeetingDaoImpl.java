package com.xsjsglxt.dao.impl.User;

import java.util.List;

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
			session.save(meet);
			// 事务未提交不能清除session
		} catch (Exception e) {
			// TODO: handle exception
			return "saveFail";
		}

		return "saveSuccess";
	}

	// 修改会议记录书

	@Override
	public String updateMeetingRecords(xsjsglxt_meeting meet) {
		// TODO Auto-generated method stub
		try {
			Session session = this.getSession();
			session.saveOrUpdate(meet);
		} catch (Exception e) {
			// TODO: handle exception
			return "updateFail";
		}

		return "updateSuccess";
	}

	// 删除会议记录书

	@Override
	public String deleteMeetingRecords(String meeting_id) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		try {
			String hql = "delete from xsjsglxt_meeting where meeting_id = '" + meeting_id + "'";
			Query query = session.createQuery(hql);
			query.executeUpdate();
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
		String hql = "select count(*) from xsjsglxt_meeting meet where 1=1";
		if (meetVO.getQuery_start_time_start() != null && meetVO.getQuery_start_time_start().trim().length() > 0) {
			hql = hql + " and meet.meeting_start_time >= '" + meetVO.getQuery_start_time_start() + "'";
		}
		if (meetVO.getQueryTitle() != null && meetVO.getQueryTitle().trim().length() > 0) {
			hql = hql + " and meet.meeting_title = '" + meetVO.getQueryTitle() + "'";
		}
		if (meetVO.getQuery_start_time_end() != null && meetVO.getQuery_start_time_end().trim().length() > 0) {
			hql = hql + " and meet.meeting_start_time <= '" + meetVO.getQuery_start_time_end() + "'";
		}
		long count = (long) this.getSession().createQuery(hql).uniqueResult();
		this.getSession().clear();
		return (int) count;
	}

	// 通过筛选获得所有会议记录书
	@Override
	public List<meetingSearchDTO> ListMeetRecordsBySearch(meetingByPageAndSerarchVO meetVO) {
		// TODO Auto-generated method stub

		String hql = "select new com.xsjsglxt.domain.DTO.User.meetingSearchDTO(meeting_id,meeting_title,meeting_start_time,meeting_end_time,meeting_place,meeting_compere) from xsjsglxt_meeting meet where 1=1";
		if (meetVO.getQuery_start_time_start() != null && meetVO.getQuery_start_time_start().trim().length() > 0) {
			hql = hql + " and meet.meeting_start_time >= '" + meetVO.getQuery_start_time_start() + "'";
		}
		if (meetVO.getQueryTitle() != null && meetVO.getQueryTitle().trim().length() > 0) {
			hql = hql + " and meet.meeting_title = '" + meetVO.getQueryTitle() + "'";
		}
		if (meetVO.getQuery_start_time_end() != null && meetVO.getQuery_start_time_end().trim().length() > 0) {
			hql = hql + " and meet.meeting_start_time <= '" + meetVO.getQuery_start_time_end() + "'";
		}
		if (true) {
			hql = hql + " order by meeting_start_time " + meetVO.getStartTimeSort();
		}
		Session session = this.getSession();
		Query query = session.createQuery(hql).setFirstResult((meetVO.getCurrPage() - 1) * meetVO.getPageSize())
				.setMaxResults(meetVO.getPageSize());
		List<meetingSearchDTO> list = query.list();
		System.out.println(list.size());
		session.clear();
		return list;
	}

}
