package com.xsjsglxt.dao.impl.Case;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xsjsglxt.dao.Case.BreakecaseDao;
import com.xsjsglxt.domain.DO.xsjsglxt_breakecase;
import com.xsjsglxt.domain.DO.xsjsglxt_breakecasesuspect;

public class BreakecaseDaoImpl implements BreakecaseDao {
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
	public String saveBreakeCase(xsjsglxt_breakecase breakeCase) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		String result = (String) session.save(breakeCase);
		return result;
	}

	@Override
	public String saveBreakecaseSuspect(xsjsglxt_breakecasesuspect xsjsglxt_breakecasesuspect) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		String result = (String) session.save(xsjsglxt_breakecasesuspect);
		return result;
	}

	@Override
	public boolean deleteBreakeCase(String string) {
		// TODO Auto-generated method stub
		xsjsglxt_breakecase breake = new xsjsglxt_breakecase();
		breake.setXsjsglxt_breakecase_id(string);
		Session session = this.getSession();
		try {
			session.delete(breake);
			return true;
		} catch (HibernateException e) {
			return false;
			// TODO: handle exception
		}
	}

	// 根据案件id删除嫌疑人
	@Override
	public boolean deleteSuspectByCaseId(String string) {
		// TODO Auto-generated method stub
		String hql = "delete from xsjsglxt_breakecasesuspect where breakecaseSuspect_breakecase = '" + string + "'";
		Session session = this.getSession();
		try {
			int result = session.createQuery(hql).executeUpdate();
			return true;
		} catch (HibernateException e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public boolean addOneSuspect(xsjsglxt_breakecasesuspect suspect) {
		// TODO Auto-generated method stub

		Session session = this.getSession();
		try {
			session.save(suspect);
			return true;
		} catch (HibernateException e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public void deleteSuspectBySuspectId(xsjsglxt_breakecasesuspect suspect) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		try {
			session.delete(suspect);
		} catch (HibernateException e) {
			// TODO: handle exception
		}

	}

	@Override
	public boolean updateBreakeCase(xsjsglxt_breakecase breakeCase) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		try {
			session.saveOrUpdate(breakeCase);
			return true;
		} catch (HibernateException e) {
			// TODO: handle exception
			return false;
		}

	}

	@Override
	public xsjsglxt_breakecase getBreakeCase(String xsjsglxt_breakecase_id) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		xsjsglxt_breakecase breakeCase = (xsjsglxt_breakecase) session.get(xsjsglxt_breakecase.class,
				xsjsglxt_breakecase_id);
		return breakeCase;
	}

	@Override
	public xsjsglxt_breakecasesuspect getBreakeCaseSuspect(String xsjsglxt_breakecaseSuspect_id) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		xsjsglxt_breakecasesuspect suspect = (xsjsglxt_breakecasesuspect) session.get(xsjsglxt_breakecasesuspect.class,
				xsjsglxt_breakecaseSuspect_id);
		return suspect;
	}

	@Override
	public boolean updateBreakeCaseSuspect(xsjsglxt_breakecasesuspect suspect) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		try {
			session.saveOrUpdate(suspect);
			return true;
		} catch (HibernateException e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public List<xsjsglxt_breakecasesuspect> getBreakeCaseSuspectByBreakeCaseId(String xsjsglxt_breakecase_id) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		String hql = "from xsjsglxt_breakecasesuspect where breakecaseSuspect_breakecase ='" + xsjsglxt_breakecase_id
				+ "'";
		List<xsjsglxt_breakecasesuspect> list = session.createQuery(hql).list();
		return list;
	}

}
