package com.xsjsglxt.dao.impl.Statistics;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xsjsglxt.dao.Statistics.StatisticsDao;
import com.xsjsglxt.domain.DO.xsjsglxt_staff;
import com.xsjsglxt.domain.DTO.Statistics.ComparisonTimeDTO;
import com.xsjsglxt.domain.DTO.Statistics.policemanOutTimesDTO;
import com.xsjsglxt.domain.VO.Statistics.ComparisonTimeVO;
import com.xsjsglxt.domain.VO.Statistics.OutTimeVO;

public class StatisticsDaoImpl implements StatisticsDao {
	private SessionFactory sessionFactory;

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Override
	public List<xsjsglxt_staff> getPolicemanByName(String policemanName) {
		// TODO Auto-generated method stub
		String hql = "from xsjsglxt_staff where 1=1";
		System.out.println(hql);
		if (policemanName != null && !"".equals(policemanName)) {
			hql = hql + " and xsjsglxt_name like '%" + policemanName + "%'";
		}
		Session session = this.getSession();
		List<xsjsglxt_staff> policemans = session.createQuery(hql).list();
		return policemans;
	}

	@Override
	public List<policemanOutTimesDTO> getTimes(List<xsjsglxt_staff> policeman, OutTimeVO outTimeVO) {
		// TODO Auto-generated method stub
		List<policemanOutTimesDTO> policemanDTO = new ArrayList<policemanOutTimesDTO>();
		Session session = this.getSession();
		String hql = null;
		String queryCondition = "";
		if (outTimeVO.getTimeStart() != null && !"".equals(outTimeVO.getTimeStart())) {
			queryCondition = queryCondition + " and c.case_receivingAlarmDate>='" + outTimeVO.getTimeStart() + "'";
		}
		if (outTimeVO.getTimeEnd() != null && !"".equals(outTimeVO.getTimeEnd())) {
			queryCondition = queryCondition + " and c.case_receivingAlarmDate<='" + outTimeVO.getTimeEnd() + "'";
		}
		for (xsjsglxt_staff xsjsglxt_staff : policeman) {
			hql = "select count(*) from xsjsglxt_snece as s , xsjsglxt_case as c where s.snece_case=c.xsjsglxt_case_id and s.snece_inquestPerson like '%"
					+ xsjsglxt_staff.getXsjsglxt_name() + "%'";
			hql = hql + queryCondition;
			System.out.println(hql);
			long count = (long) session.createQuery(hql).uniqueResult();
			policemanOutTimesDTO p = new policemanOutTimesDTO();
			p.setOutTimes(new Long(count).intValue());
			p.setPolicemanName(xsjsglxt_staff.getXsjsglxt_name());
			policemanDTO.add(p);
		}
		return policemanDTO;
	}

	@Override
	public List<ComparisonTimeDTO> getComparisonTime(List<xsjsglxt_staff> policeman,
			ComparisonTimeVO comparisonTimeVO) {
		// TODO Auto-generated method stub
		List<ComparisonTimeDTO> comparistionTimeDTOList = new ArrayList<ComparisonTimeDTO>();
		String hql = null;
		String queryCondition = "";
		if (comparisonTimeVO.getComparisonTimeStart() != null
				&& comparisonTimeVO.getComparisonTimeStart().trim().length() > 0) {
			queryCondition = queryCondition + " and breakcase_arrested_time >= '"
					+ comparisonTimeVO.getComparisonTimeStart() + "'";
		}
		if (comparisonTimeVO.getComparisonTimeEnd() != null
				&& comparisonTimeVO.getComparisonTimeEnd().trim().length() > 0) {
			queryCondition = queryCondition + " and breakcase_arrested_time<='"
					+ comparisonTimeVO.getComparisonTimeEnd() + "'";
		}
		ComparisonTimeDTO c = null;
		Session session = this.getSession();
		for (xsjsglxt_staff staff : policeman) {
			hql = "select count(*) from xsjsglxt_breakcase where breakcase_contrast_contraster = '"
					+ staff.getXsjsglxt_name() + "'";
			hql = hql + queryCondition;
			long count = (long) session.createQuery(hql).uniqueResult();
			c = new ComparisonTimeDTO();
			c.setComparisonTime((int) count);
			c.setPolicemanname(staff.getXsjsglxt_name());
			comparistionTimeDTOList.add(c);
		}
		return comparistionTimeDTOList;
	}
}
