package com.xsjsglxt.dao.impl.InspectionIdentification;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.opensymphony.xwork2.ActionSupport;
import com.xsjsglxt.dao.InspectionIdentification.InspectionIdentificationDao;

public class InspectionIdentificationDaoImpl implements InspectionIdentificationDao {
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	// 保存
	@Override
	public int saveObject(Object object) {
		int i = 1;
		try {
			getSession().saveOrUpdate(object);
		} catch (Exception e) {
			i = 2;
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public int getCountCheckNum(String check_entrustment_book_year, String type) {
		Long i;
		String hql = "select count(*) from xsjsglxt_check_entrustment_book where check_entrustment_book_year='"
				+ check_entrustment_book_year + "' and check_entrustment_book_type='" + type + "'";
		Query query = getSession().createQuery(hql);
		i = (Long) query.uniqueResult();
		getSession().clear();
		return i.intValue();
	}
}
