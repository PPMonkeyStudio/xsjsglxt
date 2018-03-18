package com.xsjsglxt.dao.impl.User;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xsjsglxt.dao.User.MemorabiliaDao;
import com.xsjsglxt.domain.DO.xsjsglxt_memorabilia;
import com.xsjsglxt.domain.DTO.User.memorabiliaListDTO;
import com.xsjsglxt.domain.VO.User.memorabiliaByPageAndSearchVO;

public class MemorabiliaDaoImpl implements MemorabiliaDao {
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

	@Override
	public String saveMemorablilia(xsjsglxt_memorabilia memorabilia) {
		// TODO Auto-generated method stub

		Session session = this.getSession();
		try {
			session.save(memorabilia);
		} catch (Exception e) {
			// TODO: handle exception
			return "saveFail";
		}
		return "saveSuccess";

	}

	@Override
	public String updateMemorabilia(xsjsglxt_memorabilia memorabilia) {
		// TODO Auto-generated method stub

		Session session = this.getSession();
		try {
			session.saveOrUpdate(memorabilia);
		} catch (Exception e) {
			// TODO: handle exception
			return "updateFail";
		}

		return "updateSuccess";
	}

	@Override
	public xsjsglxt_memorabilia getMemorabiliaById(String memorabilia_id) {
		// TODO Auto-generated method stub

		Session session = this.getSession();

		return (xsjsglxt_memorabilia) session.get(xsjsglxt_memorabilia.class, memorabilia_id);
	}

	@Override
	public String deleteMemorabiliaById(String memorabilia_id) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		xsjsglxt_memorabilia memorabilia = new xsjsglxt_memorabilia();
		memorabilia.setMemorabilia_id(memorabilia_id);
		try {
			session.delete(memorabilia);
		} catch (Exception e) {
			// TODO: handle exception
			return "deleteFail";
		}
		return "deleteSuccess";
	}

	@Override
	public int getMemorabiliaCount(memorabiliaByPageAndSearchVO memorabiliaVO) {
		// TODO Auto-generated method stub

		String hql = "select count(*) from xsjsglxt_memorabilia where 1=1";
		if (memorabiliaVO.getSearchContent() != null && memorabiliaVO.getSearchContent().trim().length() > 0) {
			hql = hql + " and memorabilia_title like '%" + memorabiliaVO.getSearchContent()
					+ "%' and memorabilia_join_human like '%" + memorabiliaVO.getSearchContent() + "%'";
		}
		if (memorabiliaVO.getCreate_time_start() != null && memorabiliaVO.getCreate_time_start().trim().length() > 0) {
			hql = hql + " and memorabilia_time >= '" + memorabiliaVO.getCreate_time_start() + "'";
		}
		if (memorabiliaVO.getCreate_time_end() != null && memorabiliaVO.getCreate_time_end().trim().length() > 0) {
			hql = hql + " and memorabilia_time <= '" + memorabiliaVO.getCreate_time_end() + "'";
		}

		Session session = this.getSession();
		long count = (long) session.createQuery(hql).uniqueResult();

		return (int) count;
	}

	@Override
	public List<memorabiliaListDTO> getMemorabiliaByPageAndSearch(memorabiliaByPageAndSearchVO memorabiliaVO) {
		// TODO Auto-generated method stub

		String hql = "select new com.xsjsglxt.domain.DTO.User.memorabiliaListDTO(m.memorabilia_id as memorabilia_id,m.memorabilia_title as memorabilia_title,m.memorabilia_join_human as memorabilia_join_human,m.memorabilia_time as memorabilia_time) from xsjsglxt_memorabilia m where 1=1";
		if (memorabiliaVO.getSearchContent() != null && memorabiliaVO.getSearchContent().trim().length() > 0) {
			hql = hql + " and memorabilia_title like '%" + memorabiliaVO.getSearchContent()
					+ "%' and memorabilia_join_human like '%" + memorabiliaVO.getSearchContent() + "%'";
		}
		if (memorabiliaVO.getCreate_time_start() != null && memorabiliaVO.getCreate_time_start().trim().length() > 0) {
			hql = hql + " and memorabilia_time >= '" + memorabiliaVO.getCreate_time_start() + "'";
		}
		if (memorabiliaVO.getCreate_time_end() != null && memorabiliaVO.getCreate_time_end().trim().length() > 0) {
			hql = hql + " and memorabilia_time <= '" + memorabiliaVO.getCreate_time_end() + "'";
		}
		hql = hql + " order by memorabilia_time " + memorabiliaVO.getQuerySort();
		Session session = this.getSession();
		Query query = session.createQuery(hql)
				.setFirstResult((memorabiliaVO.getCurrPage() - 1) * memorabiliaVO.getPageSize())
				.setMaxResults(memorabiliaVO.getPageSize());
		List<memorabiliaListDTO> list = query.list();
		if (memorabiliaVO.getSearchContent() != null && memorabiliaVO.getSearchContent().trim().length() > 0) {
			for (memorabiliaListDTO memorabiliaListDTO : list) {
				if (memorabiliaListDTO.getMemorabilia_title() != null
						&& memorabiliaListDTO.getMemorabilia_title().trim().length() > 0) {
					memorabiliaListDTO.setMemorabilia_join_human(
							memorabiliaListDTO.getMemorabilia_join_human().replaceAll(memorabiliaVO.getSearchContent(),
									"<span style=\"color: red;\">" + memorabiliaVO.getSearchContent() + "</span>"));
				}
				if (memorabiliaListDTO.getMemorabilia_join_human() != null
						&& memorabiliaListDTO.getMemorabilia_join_human().trim().length() > 0) {
					memorabiliaListDTO.setMemorabilia_title(
							memorabiliaListDTO.getMemorabilia_title().replaceAll(memorabiliaVO.getSearchContent(),
									"<span style=\"color: red;\">" + memorabiliaVO.getSearchContent() + "</span>"));
				}
			}
		}
		return list;
	}

}
