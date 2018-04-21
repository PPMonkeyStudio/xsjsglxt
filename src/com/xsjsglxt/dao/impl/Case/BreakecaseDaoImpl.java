package com.xsjsglxt.dao.impl.Case;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xsjsglxt.dao.Case.BreakecaseDao;
import com.xsjsglxt.domain.DO.xsjsglxt_breakecase;
import com.xsjsglxt.domain.DO.xsjsglxt_breakecasesuspect;
import com.xsjsglxt.domain.DO.xsjsglxt_takeBreakeCase;
import com.xsjsglxt.domain.DTO.Case.BreakeCasePageDTO;
import com.xsjsglxt.domain.VO.Case.BreakeCaseListVO;

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
		session.clear();
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

	@Override
	public List<xsjsglxt_breakecase> getBreakeCaseByCaseId(String breakecase_case) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		String hql = "from xsjsglxt_breakecase where breakecase_case ='" + breakecase_case + "'";
		return session.createQuery(hql).list();
	}

	@Override
	public int getCountBreakeCase(BreakeCaseListVO breakeCaseListVO) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		String hql = "select count(*) from xsjsglxt_breakecase as breake , xsjsglxt_case as xCase,xsjsglxt_snece as sence where breake.breakecase_case = xCase.xsjsglxt_case_id and sence.snece_case = xCase.xsjsglxt_case_id";
		if (breakeCaseListVO.getQuery_breake_person() != null
				&& breakeCaseListVO.getQuery_breake_person().trim().length() > 0)
			hql = hql + " and breake.breakecase_person like '%" + breakeCaseListVO.getQuery_breake_person() + "%'";
		if (breakeCaseListVO.getQuery_breake_time_end() != null
				&& breakeCaseListVO.getQuery_breake_time_end().trim().length() > 0)
			hql = hql + " and breake.breakecase_caseTime <= '" + breakeCaseListVO.getQuery_breake_time_end() + "'";
		if (breakeCaseListVO.getQuery_breake_time_start() != null
				&& breakeCaseListVO.getQuery_breake_time_start().trim().length() > 0)
			hql = hql + " and breake.breakecase_caseTime >= '" + breakeCaseListVO.getQuery_breake_time_start() + "'";
		if (breakeCaseListVO.getQuery_case_name() != null && breakeCaseListVO.getQuery_case_name().trim().length() > 0)
			hql = hql + " and xCase.case_name like '%" + breakeCaseListVO.getQuery_case_name() + "%'";
		if (breakeCaseListVO.getQuery_sence_inquestId() != null
				&& breakeCaseListVO.getQuery_sence_inquestId().trim().length() > 0)
			hql = hql + " and sence.snece_inquestId like '%" + breakeCaseListVO.getQuery_sence_inquestId() + "%'";
		if (breakeCaseListVO.getQuery_breake_according() != null
				&& breakeCaseListVO.getQuery_breake_according().trim().length() > 0)
			hql = hql + " and breake.breakecase_according like '%" + breakeCaseListVO.getQuery_breake_according()
					+ "%'";

		hql = hql + " order by breakecase_caseTime " + breakeCaseListVO.getQuery_breake_time_sort();
		long count = (long) session.createQuery(hql).uniqueResult();
		return (int) count;
	}

	@Override
	public void getBreakeCaseByPage(BreakeCaseListVO breakeCaseListVO) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		String hql = "select new com.xsjsglxt.domain.DTO.Case.BreakeCasePageDTO(breake.xsjsglxt_breakecase_id as xsjsglxt_breakecase_id , "
				+ "sence.snece_inquestId as snece_inquestId , " + "xCase.case_name as case_name , "
				+ "breake.breakecase_type as breakecase_type , " + "breake.breakecase_person as breakecase_person , "
				+ "breake.breakecase_according as breakecase_according , "
				+ "breake.breakecase_caseTime as breakecase_caseTime)"
				+ " from xsjsglxt_breakecase as breake , xsjsglxt_case as xCase,xsjsglxt_snece as sence where breake.breakecase_case = xCase.xsjsglxt_case_id and sence.snece_case = xCase.xsjsglxt_case_id and 1=1";
		if (breakeCaseListVO.getQuery_breake_person() != null
				&& breakeCaseListVO.getQuery_breake_person().trim().length() > 0)
			hql = hql + " and breake.breakecase_person like '%" + breakeCaseListVO.getQuery_breake_person() + "%'";
		if (breakeCaseListVO.getQuery_breake_time_end() != null
				&& breakeCaseListVO.getQuery_breake_time_end().trim().length() > 0)
			hql = hql + " and breake.breakecase_caseTime <= '" + breakeCaseListVO.getQuery_breake_time_end() + "'";
		if (breakeCaseListVO.getQuery_breake_time_start() != null
				&& breakeCaseListVO.getQuery_breake_time_start().trim().length() > 0)
			hql = hql + " and breake.breakecase_caseTime >= '" + breakeCaseListVO.getQuery_breake_time_start() + "'";
		if (breakeCaseListVO.getQuery_case_name() != null && breakeCaseListVO.getQuery_case_name().trim().length() > 0)
			hql = hql + " and xCase.case_name like '%" + breakeCaseListVO.getQuery_case_name() + "%'";
		if (breakeCaseListVO.getQuery_sence_inquestId() != null
				&& breakeCaseListVO.getQuery_sence_inquestId().trim().length() > 0)
			hql = hql + " and sence.snece_inquestId like '%" + breakeCaseListVO.getQuery_sence_inquestId() + "%'";
		if (breakeCaseListVO.getQuery_breake_according() != null
				&& breakeCaseListVO.getQuery_breake_according().trim().length() > 0)
			hql = hql + " and breake.breakecase_according like '%" + breakeCaseListVO.getQuery_breake_according()
					+ "%'";
		hql = hql + " order by breake.breakecase_caseTime desc";
		List<BreakeCasePageDTO> pageDTO = session.createQuery(hql)
				.setFirstResult((breakeCaseListVO.getCurrPage() - 1) * breakeCaseListVO.getPageSize())
				.setMaxResults(breakeCaseListVO.getPageSize()).list();
		breakeCaseListVO.setBreakeCaseDTOList(pageDTO);

	}

	@Override
	public void saveTakeBreakeCase(xsjsglxt_takeBreakeCase dBreakeCase) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		session.save(dBreakeCase);
	}

	@Override
	public List<xsjsglxt_takeBreakeCase> getTakeBreakeCaseByBreakeCaseId(String xsjsglxt_breakecase_id) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		String hql = "from xsjsglxt_takeBreakeCase where take_case ='" + xsjsglxt_breakecase_id + "'";
		return session.createQuery(hql).list();
	}

}