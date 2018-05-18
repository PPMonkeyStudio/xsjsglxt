package com.xsjsglxt.dao.impl.Statistics;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xsjsglxt.dao.Statistics.ExpenditureDao;
import com.xsjsglxt.domain.DO.xsjsglxt_expenditure;
import com.xsjsglxt.domain.VO.Statistics.ExpenditureVO;

public class ExpenditureDaoImpl implements ExpenditureDao {
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

	@Override
	public boolean saveExpenditure(xsjsglxt_expenditure expenditure) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		try {
			session.save(expenditure);
			return true;
		} catch (HibernateException e) {
			// TODO: handle exception
			return false;
		}

	}

	@Override
	public boolean deleteExpenditure(xsjsglxt_expenditure expenditure) {
		// TODO Auto-generated method stub
		Session session = this.getSession();

		try {
			session.delete(expenditure);
			return true;
		} catch (HibernateException e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public xsjsglxt_expenditure getExpenditureById(String expenditure_id) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		xsjsglxt_expenditure expenditure = (xsjsglxt_expenditure) session.get(xsjsglxt_expenditure.class,
				expenditure_id);
		session.clear();
		return expenditure;
	}

	@Override
	public boolean updateExpenditure(xsjsglxt_expenditure expenditure) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		try {
			session.update(expenditure);
			return true;
		} catch (HibernateException e) {
			// TODO: handle exception
			return false;
		}

	}

	@Override
	public int getCountBySearch(ExpenditureVO expenditureVO) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		String hql = "select count(*) from xsjsglxt_expenditure where 1=1";
		if (expenditureVO.getSearchStartTime() != null && !"".equals(expenditureVO.getSearchStartTime().trim()))
			hql = hql + " and expenditure_time >= '" + expenditureVO.getSearchStartTime() + "'";
		if (expenditureVO.getSearchEndTime() != null && !"".equals(expenditureVO.getSearchEndTime().trim()))
			hql = hql + " and expenditure_time <= '" + expenditureVO.getSearchEndTime() + "'";
		if (expenditureVO.getSearchDetachment() != null && !"".equals(expenditureVO.getSearchDetachment().trim()))
			hql = hql + " and expenditure_detachment like '" + expenditureVO.getSearchDetachment() + "'";
		if (expenditureVO.getSearchName() != null && !"".equals(expenditureVO.getSearchName().trim()))
			hql = hql + " and expenditure_name like '" + expenditureVO.getSearchName() + "'";
		if (expenditureVO.getSearchType() != null && !"".equals(expenditureVO.getSearchType().trim()))
			hql = hql + " and expenditure_type = '" + expenditureVO.getSearchType() + "'";
		long count = (long) session.createQuery(hql).uniqueResult();
		return (int) count;
	}

	@Override
	public List<xsjsglxt_expenditure> getSearchExpenditureByPage(ExpenditureVO expenditureVO) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		String hql = "from xsjsglxt_expenditure where 1=1";
		if (expenditureVO.getSearchStartTime() != null && !"".equals(expenditureVO.getSearchStartTime().trim()))
			hql = hql + " and expenditure_time >= '" + expenditureVO.getSearchStartTime() + "'";
		if (expenditureVO.getSearchEndTime() != null && !"".equals(expenditureVO.getSearchEndTime().trim()))
			hql = hql + " and expenditure_time <= '" + expenditureVO.getSearchEndTime() + "'";
		if (expenditureVO.getSearchDetachment() != null && !"".equals(expenditureVO.getSearchDetachment().trim()))
			hql = hql + " and expenditure_detachment like '" + expenditureVO.getSearchDetachment() + "'";
		if (expenditureVO.getSearchName() != null && !"".equals(expenditureVO.getSearchName().trim()))
			hql = hql + " and expenditure_name like '" + expenditureVO.getSearchName() + "'";
		if (expenditureVO.getSearchType() != null && !"".equals(expenditureVO.getSearchType().trim()))
			hql = hql + " and expenditure_type = '" + expenditureVO.getSearchType() + "'";
		hql = hql + " order by expenditure_time " + expenditureVO.getSearchSort();
		Query query = session.createQuery(hql);
		List<xsjsglxt_expenditure> expenditures = query
				.setFirstResult((expenditureVO.getCurrPage() - 1) * expenditureVO.getPageSize())
				.setMaxResults(expenditureVO.getPageSize()).list();
		return expenditures;
	}

	@Override
	public int getTotalMoneyBySearch(ExpenditureVO expenditureVO) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		String hql = "select sum(expenditure_money) from xsjsglxt_expenditure where 1=1";
		if (expenditureVO.getSearchStartTime() != null && !"".equals(expenditureVO.getSearchStartTime().trim()))
			hql = hql + " and expenditure_time >= '" + expenditureVO.getSearchStartTime() + "'";
		if (expenditureVO.getSearchEndTime() != null && !"".equals(expenditureVO.getSearchEndTime().trim()))
			hql = hql + " and expenditure_time <= '" + expenditureVO.getSearchEndTime() + "'";
		if (expenditureVO.getSearchDetachment() != null && !"".equals(expenditureVO.getSearchDetachment().trim()))
			hql = hql + " and expenditure_detachment like '" + expenditureVO.getSearchDetachment() + "'";
		if (expenditureVO.getSearchName() != null && !"".equals(expenditureVO.getSearchName().trim()))
			hql = hql + " and expenditure_name like '" + expenditureVO.getSearchName() + "'";
		if (expenditureVO.getSearchType() != null && !"".equals(expenditureVO.getSearchType().trim()))
			hql = hql + " and expenditure_type = '" + expenditureVO.getSearchType() + "'";
		String totalMoney = (String) session.createQuery(hql).uniqueResult();
		if (totalMoney == null) {
			return 0;
		} else {
			return Integer.parseInt(totalMoney);
		}
	}

}
