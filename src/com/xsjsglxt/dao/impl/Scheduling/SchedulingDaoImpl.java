package com.xsjsglxt.dao.impl.Scheduling;

import java.math.BigInteger;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xsjsglxt.dao.Scheduling.SchedulingDao;
import com.xsjsglxt.domain.DO.xsjsglxt_scheduling;
import com.xsjsglxt.domain.DO.xsjsglxt_staff;
import com.xsjsglxt.domain.DTO.Scheduling.schedulingDTO;
import com.xsjsglxt.domain.VO.Scheduling.SchedulingDTOListVO;
import com.xsjsglxt.domain.VO.Scheduling.schedulingTimeVO;

/**
 * 
 * @author 孙毅 排班dao层
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
		xsjsglxt_scheduling s = (xsjsglxt_scheduling) session.get(xsjsglxt_scheduling.class, xsjsglxt_scheduling_id);
		session.clear();
		return s;
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

	@Override
	public int getSchedulingCount(SchedulingDTOListVO schedulingListVO) {
		// TODO Auto-generated method stub

		String hql = "select count(*) from xsjsglxt_scheduling where 1=1";
		if (schedulingListVO.getQuery_name() != null && !"".equals(schedulingListVO.getQuery_name().trim()))
			hql = hql + " and ( scheduling_main like '%" + schedulingListVO.getQuery_name()
					+ "%' or scheduling_assistant_tech like '%" + schedulingListVO.getQuery_name()
					+ "%' or scheduling_assistant_spy like '%" + schedulingListVO.getQuery_name()
					+ "%' or scheduling_main_doctor like '%" + schedulingListVO.getQuery_name()
					+ "%' or scheduling_leader like '%" + schedulingListVO.getQuery_name()
					+ "%' or scheduling_main_technology like '%" + schedulingListVO.getQuery_name()
					+ "%' or scheduling_patrol like '%" + schedulingListVO.getQuery_name()
					+ "%' or scheduling_overtime like '%" + schedulingListVO.getQuery_name()
					+ "%' or scheduling_out_help like '%" + schedulingListVO.getQuery_name() + "%')";
		if (schedulingListVO.getQueryTimeStart() != null && !"".equals(schedulingListVO.getQueryTimeStart().trim()))
			hql = hql + " and scheduling_time >= '" + schedulingListVO.getQueryTimeStart() + "'";
		if (schedulingListVO.getQueryTimeEnd() != null && !"".equals(schedulingListVO.getQueryTimeEnd().trim()))
			hql = hql + " and scheduling_time <= '" + schedulingListVO.getQueryTimeEnd() + "'";
		Session session = this.getSession();
		long count = (long) session.createQuery(hql).uniqueResult();
		return (int) count;
	}

	@Override
	public List<schedulingDTO> getSchedulingByPage(SchedulingDTOListVO schedulingListVO) {
		// TODO Auto-generated method stub
		String hql = "select new com.xsjsglxt.domain.DTO.Scheduling.schedulingDTO(xsjsglxt_scheduling_id,scheduling_leader,scheduling_main , scheduling_main_technology as scheduling_mainTec, scheduling_main_doctor ,scheduling_assistant_tech,scheduling_assistant_spy,scheduling_overtime,scheduling_out_help,scheduling_evection,scheduling_time, scheduling_patrol as scheduling_patrol) from xsjsglxt_scheduling where 1=1";
		if (schedulingListVO.getQuery_name() != null && !"".equals(schedulingListVO.getQuery_name().trim()))
			hql = hql + " and ( scheduling_main like '%" + schedulingListVO.getQuery_name()
					+ "%' or scheduling_assistant_tech like '%" + schedulingListVO.getQuery_name()
					+ "%' or scheduling_assistant_spy like '%" + schedulingListVO.getQuery_name()
					+ "%' or scheduling_main_doctor like '%" + schedulingListVO.getQuery_name()
					+ "%' or scheduling_leader like '%" + schedulingListVO.getQuery_name()
					+ "%' or scheduling_patrol like '%" + schedulingListVO.getQuery_name()
					+ "%' or scheduling_main_technology like '%" + schedulingListVO.getQuery_name()
					+ "%' or scheduling_patrol like '%" + schedulingListVO.getQuery_name()
					+ "%' or scheduling_overtime like '%" + schedulingListVO.getQuery_name()
					+ "%' or scheduling_out_help like '%" + schedulingListVO.getQuery_name() + "%')";
		if (schedulingListVO.getQueryTimeStart() != null && !"".equals(schedulingListVO.getQueryTimeStart().trim()))
			hql = hql + " and scheduling_time >= '" + schedulingListVO.getQueryTimeStart() + "'";
		if (schedulingListVO.getQueryTimeEnd() != null && !"".equals(schedulingListVO.getQueryTimeEnd().trim()))
			hql = hql + " and scheduling_time <= '" + schedulingListVO.getQueryTimeEnd() + "'";
		hql = hql + " order by scheduling_time asc";
		Session session = this.getSession();
		Query query = session.createQuery(hql)
				.setFirstResult((schedulingListVO.getCurrPage() - 1) * schedulingListVO.getPageSize())
				.setMaxResults(schedulingListVO.getPageSize());
		List<schedulingDTO> dtoList = query.list();
		return dtoList;
	}

	// ----------------------------------以下为值班统计内容
	@Override
	public List<xsjsglxt_staff> getStaffByQuery(String queryName) {
		// TODO Auto-generated method stub
		String hql = "from xsjsglxt_staff where xsjsglxt_name like '%" + queryName + "%'";
		Session session = this.getSession();
		return session.createQuery(hql).list();
	}

	@Override
	public int getSchedulingTime(schedulingTimeVO schedulingTimeVO, String xsjsglxt_name) {
		// TODO Auto-generated method stub
		String hql = "select count(*) from xsjsglxt_scheduling where (scheduling_leader = '" + xsjsglxt_name
				+ "' or scheduling_main = '" + xsjsglxt_name + "' or scheduling_main_doctor = '" + xsjsglxt_name
				+ "' or scheduling_main_technology REGEXP '(^" + xsjsglxt_name + "、)|(^" + xsjsglxt_name + "$)|(、"
				+ xsjsglxt_name + "、)|(、" + xsjsglxt_name + "$)'" + " or scheduling_assistant_tech = '" + xsjsglxt_name
				+ "'  or scheduling_assistant_spy = '" + xsjsglxt_name + "')";
		if (schedulingTimeVO.getQueryTimeStart() != null && !"".equals(schedulingTimeVO.getQueryTimeStart().trim())) {
			hql = hql + " and scheduling_time >= '" + schedulingTimeVO.getQueryTimeStart() + "'";
		}
		if (schedulingTimeVO.getQueryTimeEnd() != null && !"".equals(schedulingTimeVO.getQueryTimeEnd().trim())) {
			hql = hql + " and scheduling_time <= '" + schedulingTimeVO.getQueryTimeEnd() + "'";
		}
		Session session = this.getSession();
		BigInteger count = (BigInteger) session.createSQLQuery(hql).uniqueResult();
		return count.intValue();
	}

	@Override
	public int getOutTime(schedulingTimeVO schedulingTimeVO, String xsjsglxt_name) {
		// TODO Auto-generated method stub
		String hql = "select count(*) from xsjsglxt_scheduling where scheduling_out_help REGEXP '(^" + xsjsglxt_name
				+ "、)|(^" + xsjsglxt_name + "$)|(、" + xsjsglxt_name + "、)|(、" + xsjsglxt_name + "$)'";
		if (schedulingTimeVO.getQueryTimeStart() != null && !"".equals(schedulingTimeVO.getQueryTimeStart().trim())) {
			hql = hql + " and scheduling_time >= '" + schedulingTimeVO.getQueryTimeStart() + "'";
		}
		if (schedulingTimeVO.getQueryTimeEnd() != null && !"".equals(schedulingTimeVO.getQueryTimeEnd().trim())) {
			hql = hql + " and scheduling_time <= '" + schedulingTimeVO.getQueryTimeEnd() + "'";
		}
		Session session = this.getSession();
		BigInteger count = (BigInteger) session.createSQLQuery(hql).uniqueResult();
		return count.intValue();
	}

	@Override
	public int getOverTime(schedulingTimeVO schedulingTimeVO, String xsjsglxt_name) {
		// TODO Auto-generated method stub
		String hql = "select count(*) from xsjsglxt_scheduling where scheduling_overtime REGEXP '(^" + xsjsglxt_name
				+ "、)|(^" + xsjsglxt_name + "$)|(、" + xsjsglxt_name + "、)|(、" + xsjsglxt_name + "$)'";
		if (schedulingTimeVO.getQueryTimeStart() != null && !"".equals(schedulingTimeVO.getQueryTimeStart().trim())) {
			hql = hql + " and scheduling_time >= '" + schedulingTimeVO.getQueryTimeStart() + "'";
		}
		if (schedulingTimeVO.getQueryTimeEnd() != null && !"".equals(schedulingTimeVO.getQueryTimeEnd().trim())) {
			hql = hql + " and scheduling_time <= '" + schedulingTimeVO.getQueryTimeEnd() + "'";
		}
		Session session = this.getSession();
		BigInteger count = (BigInteger) session.createSQLQuery(hql).uniqueResult();
		return count.intValue();
	}

	@Override
	public int getPatrolTime(schedulingTimeVO schedulingTimeVO, String xsjsglxt_name) {
		// TODO Auto-generated method stub
		String hql = "select count(*) from xsjsglxt_scheduling where scheduling_patrol REGEXP '(^" + xsjsglxt_name
				+ "、)|(^" + xsjsglxt_name + "$)|(、" + xsjsglxt_name + "、)|(、" + xsjsglxt_name + "$)'";
		if (schedulingTimeVO.getQueryTimeStart() != null && !"".equals(schedulingTimeVO.getQueryTimeStart().trim())) {
			hql = hql + " and scheduling_time >= '" + schedulingTimeVO.getQueryTimeStart() + "'";
		}
		if (schedulingTimeVO.getQueryTimeEnd() != null && !"".equals(schedulingTimeVO.getQueryTimeEnd().trim())) {
			hql = hql + " and scheduling_time <= '" + schedulingTimeVO.getQueryTimeEnd() + "'";
		}
		Session session = this.getSession();
		BigInteger count = (BigInteger) session.createSQLQuery(hql).uniqueResult();
		return count.intValue();
	}

	@Override
	public int getEvectionTime(schedulingTimeVO schedulingTimeVO, String xsjsglxt_staff_id) {
		// TODO Auto-generated method stub
		String hql = "select count(*) from xsjsglxt_staffStudent where staffStudent_staff = '" + xsjsglxt_staff_id
				+ "'";
		if (schedulingTimeVO.getQueryTimeStart() != null && !"".equals(schedulingTimeVO.getQueryTimeStart().trim())) {
			hql = hql + " and staffStudent_startTime >= '" + schedulingTimeVO.getQueryTimeStart() + "'";
		}
		if (schedulingTimeVO.getQueryTimeEnd() != null && !"".equals(schedulingTimeVO.getQueryTimeEnd().trim())) {
			hql = hql + " and staffStudent_startTime <= '" + schedulingTimeVO.getQueryTimeEnd() + "'";
		}
		Session session = this.getSession();
		BigInteger count = (BigInteger) session.createSQLQuery(hql).uniqueResult();
		return count.intValue();
	}

}
