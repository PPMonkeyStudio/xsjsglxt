package com.xsjsglxt.dao.impl.InspectionIdentification;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xsjsglxt.dao.InspectionIdentification.InspectionIdentificationDao;
import com.xsjsglxt.domain.DO.xsjsglxt_check_entrustment_book;
import com.xsjsglxt.domain.VO.InspectionIdentification.CheckEntrustmentBookVO;

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
		String hql = "select count(*) from xsjsglxt_check_entrustment_book where substring(check_entrustment_book_num,1,4)='"
				+ check_entrustment_book_year + "' and check_entrustment_book_type='" + type + "'";
		Query query = getSession().createQuery(hql);
		i = (Long) query.uniqueResult();
		getSession().clear();
		return i.intValue();
	}

	@Override
	public int getCountByPageAndSearch(CheckEntrustmentBookVO checkEntrustmentBookVO) {
		Long i;
		String startTime = "0000-00-00";
		String stopTime = "9999-99-99";
		String hql = "select count(*) from xsjsglxt_check_entrustment_book where 1=1 ";
		if (checkEntrustmentBookVO.getBookNum() != null && checkEntrustmentBookVO.getBookNum().trim().length() > 0) {
			String bookNum = "%" + checkEntrustmentBookVO.getBookNum().trim() + "%";
			hql = hql + " and check_entrustment_book_num like '" + bookNum + "'";
		}
		if (checkEntrustmentBookVO.getCaseName() != null && checkEntrustmentBookVO.getCaseName().trim().length() > 0) {
			String caseName = "%" + checkEntrustmentBookVO.getCaseName() + "%";
			hql = hql + " and check_entrustment_book_case_name like '" + caseName + "'";
		}
		if (checkEntrustmentBookVO.getUnitName() != null && checkEntrustmentBookVO.getUnitName().trim().length() > 0) {
			hql = hql + " and check_entrustment_book_entrustment_unit_name='"
					+ checkEntrustmentBookVO.getUnitName().trim() + "'";
		}
		if (checkEntrustmentBookVO.getType() != null && checkEntrustmentBookVO.getType().trim().length() > 0) {
			hql = hql + " and check_entrustment_book_type='" + checkEntrustmentBookVO.getType().trim() + "'";
		}
		if (checkEntrustmentBookVO.getStart_time() != null
				&& checkEntrustmentBookVO.getStart_time().trim().length() > 0) {
			startTime = checkEntrustmentBookVO.getStart_time();
		}
		if (checkEntrustmentBookVO.getStop_time() != null
				&& checkEntrustmentBookVO.getStop_time().trim().length() > 0) {
			stopTime = checkEntrustmentBookVO.getStop_time();
		}
		hql = hql + " and check_entrustment_book_inspect_time>='" + startTime
				+ "' and check_entrustment_book_inspect_time<='" + stopTime
				+ "' order by check_entrustment_book_inspect_time";
		Query query = getSession().createQuery(hql);
		i = (Long) query.uniqueResult();
		getSession().clear();
		return i.intValue();
	}

	// 分页查询所有
	@Override
	public List<xsjsglxt_check_entrustment_book> getListCheckEntrustmentBookByPage(
			CheckEntrustmentBookVO checkEntrustmentBookVO) {
		String startTime = "0000-00-00";
		String stopTime = "9999-99-99";
		String hql = "from xsjsglxt_check_entrustment_book where 1=1 ";
		List<xsjsglxt_check_entrustment_book> listPage = new ArrayList<xsjsglxt_check_entrustment_book>();
		if (checkEntrustmentBookVO.getBookNum() != null && checkEntrustmentBookVO.getBookNum().trim().length() > 0) {
			String bookNum = "%" + checkEntrustmentBookVO.getBookNum().trim() + "%";
			hql = hql + " and check_entrustment_book_num like '" + bookNum + "'";
		}
		if (checkEntrustmentBookVO.getCaseName() != null && checkEntrustmentBookVO.getCaseName().trim().length() > 0) {
			String caseName = "%" + checkEntrustmentBookVO.getCaseName() + "%";
			hql = hql + " and check_entrustment_book_case_name like '" + caseName + "'";
		}
		if (checkEntrustmentBookVO.getUnitName() != null && checkEntrustmentBookVO.getUnitName().trim().length() > 0) {
			hql = hql + " and check_entrustment_book_entrustment_unit_name='"
					+ checkEntrustmentBookVO.getUnitName().trim() + "'";
		}
		if (checkEntrustmentBookVO.getType() != null && checkEntrustmentBookVO.getType().trim().length() > 0) {
			hql = hql + " and check_entrustment_book_type='" + checkEntrustmentBookVO.getType().trim() + "'";
		}
		if (checkEntrustmentBookVO.getStart_time() != null
				&& checkEntrustmentBookVO.getStart_time().trim().length() > 0) {
			startTime = checkEntrustmentBookVO.getStart_time();
		}
		if (checkEntrustmentBookVO.getStop_time() != null
				&& checkEntrustmentBookVO.getStop_time().trim().length() > 0) {
			stopTime = checkEntrustmentBookVO.getStop_time();
		}
		hql = hql + " and check_entrustment_book_inspect_time>='" + startTime
				+ "' and check_entrustment_book_inspect_time<='" + stopTime
				+ "' order by check_entrustment_book_inspect_time";
		Query query = getSession().createQuery(hql);
		query.setFirstResult((checkEntrustmentBookVO.getPageIndex() - 1) * checkEntrustmentBookVO.getPageSize());
		query.setMaxResults(checkEntrustmentBookVO.getPageSize());
		listPage = query.list();
		if (checkEntrustmentBookVO.getBookNum() != null && checkEntrustmentBookVO.getBookNum().trim().length() > 0) {

		}
		if (checkEntrustmentBookVO.getCaseName() != null && checkEntrustmentBookVO.getCaseName().trim().length() > 0) {
			for (xsjsglxt_check_entrustment_book xsjsglxt_check_entrustment_book : listPage) {
				xsjsglxt_check_entrustment_book.setCheck_entrustment_book_case_name(
						xsjsglxt_check_entrustment_book.getCheck_entrustment_book_case_name().replaceAll(
								checkEntrustmentBookVO.getCaseName().trim(), "<span style='color: #ff5063;'>"
										+ checkEntrustmentBookVO.getCaseName().trim() + "</span>"));
			}
		}
		if (checkEntrustmentBookVO.getBookNum() != null && checkEntrustmentBookVO.getBookNum().trim().length() > 0) {
			for (xsjsglxt_check_entrustment_book check_entrustment_book : listPage) {
				check_entrustment_book
						.setCheck_entrustment_book_num(check_entrustment_book.getCheck_entrustment_book_num()
								.replaceAll(checkEntrustmentBookVO.getBookNum().trim(), "<span style='color: #ff5063;'>"
										+ checkEntrustmentBookVO.getBookNum().trim() + "</span>"));
			}
		}
		getSession().clear();
		return listPage;
	}

	@Override
	public int deleteCheckEntrustmentBookById(String checkEntrustmentBookId) {
		int i = 1;
		String hql = "delete xsjsglxt_check_entrustment_book where xsjsglxt_check_entrustment_book_id='"
				+ checkEntrustmentBookId + "'";
		try {
			Query query = getSession().createQuery(hql);
			query.executeUpdate();
		} catch (HibernateException e) {
			i = 2;
			e.printStackTrace();
		}
		return i;
	}
}
