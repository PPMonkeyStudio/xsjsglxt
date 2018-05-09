package com.xsjsglxt.dao.impl.Technology;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xsjsglxt.dao.Technology.FingerPrintDao;
import com.xsjsglxt.domain.DO.xsjsglxt_fingerprint;
import com.xsjsglxt.domain.VO.Technology.FingerPrintVO;

import util.TeamUtil;

public class FingerPrintDaoImpl implements FingerPrintDao {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public int saveFingerPrint(xsjsglxt_fingerprint fingerprint) {
		Session session = getSession();
		try {
			session.save(fingerprint);
			return 1;
		} catch (Exception e) {
			return 2;
		}
	}

	@Override
	public int getFeild() {
		Session session = getSession();
		String year = TeamUtil.getCurrentYear();
		String hql = "select right(fingerprint_num,4) FROM xsjsglxt_fingerprint  where LEFT(fingerprint_gmt_create,4) ='"
				+ year + "' ORDER BY right(fingerprint_num,4)  desc limit 1";
		/**
		 * 这里要记得使用  createSQLQuery  可能hql并不支持这种用法
		 */
		Query query = session.createSQLQuery(hql);
		String field = (String) query.uniqueResult();
		if (field == null || field.length() == 0) {
			session.clear();
			return 0;
		}
		session.clear();
		return Integer.parseInt(field);
	}

	// 获取总记录数量
	@Override
	public int count_fingerprint_all(FingerPrintVO fingerprintVO) {
		Session session = getSession();
		String hql = "select count(*) from xsjsglxt_fingerprint where 1=1";
		if (fingerprintVO.getSearch() != null && fingerprintVO.getSearch().trim().length() > 0) {
			String search = "%" + fingerprintVO.getSearch().trim() + "%";
			hql = hql + " and fingerprint_num like '" + search + "' or fingerprint_name like '" + search + "'";
		}
		hql = hql + " order by fingerprint_gmt_create";
		Query query = session.createQuery(hql);
		Long i = (Long) query.uniqueResult();
		int count = i.intValue();
		session.clear();
		return count;
	}

	@Override
	public int deleteFingerPrint(String xsjsglxt_fingerprint_id) {
		Session session = getSession();
		String hql = "delete from xsjsglxt_fingerprint where xsjsglxt_fingerprint_id='" + xsjsglxt_fingerprint_id + "'";
		Query query = session.createQuery(hql);
		int result = query.executeUpdate();
		return result;
	}

	@Override
	public xsjsglxt_fingerprint get_fingerprint(String xsjsglxt_fingerprint_id) {
		Session session = getSession();
		String hql = "from xsjsglxt_fingerprint where xsjsglxt_fingerprint_id='" + xsjsglxt_fingerprint_id + "'";
		Query query = session.createQuery(hql);
		xsjsglxt_fingerprint finger = (xsjsglxt_fingerprint) query.uniqueResult();
		return finger;
	}

	@Override
	public int modifiedFingerPrint(xsjsglxt_fingerprint fingerprint) {
		Session session = getSession();
		String hql = "update xsjsglxt_fingerprint set fingerprint_name='" + fingerprint.getFingerprint_name()
				+ "', fingerprint_sex='" + fingerprint.getFingerprint_sex() + "' ,fingerprint_birthday='"
				+ fingerprint.getFingerprint_birthday() + "', fingerprint_identity='"
				+ fingerprint.getFingerprint_identity() + "',fingerprint_address='"
				+ fingerprint.getFingerprint_address() + "', fingerprint_illegal_fact='"
				+ fingerprint.getFingerprint_illegal_fact() + "',fingerprint_record_organization='"
				+ fingerprint.getFingerprint_record_organization() + "' ,fingerprint_organizer='"
				+ fingerprint.getFingerprint_organizer() + "' ,fingerprint_record_time='"
				+ fingerprint.getFingerprint_record_time() + "' ,fingerprint_submit_time='"
				+ fingerprint.getFingerprint_submit_time() + "',fingerprint_remark='"
				+ fingerprint.getFingerprint_remark() + "' ,fingerprint_gmt_modified='"
				+ fingerprint.getFingerprint_gmt_modified() + "' where xsjsglxt_fingerprint_id='"
				+ fingerprint.getXsjsglxt_fingerprint_id() + "'";
		Query query = session.createQuery(hql);
		int result = query.executeUpdate();
		return result;
	}

	@Override
	public List<xsjsglxt_fingerprint> list_xsjsglxt_finger(FingerPrintVO fingerprintVO) {
		Session session = getSession();
		String hql = "from xsjsglxt_fingerprint where 1=1";
		if (fingerprintVO.getSearch() != null && fingerprintVO.getSearch().trim().length() > 0) {
			String search = "%" + fingerprintVO.getSearch().trim() + "%";
			hql = hql + " and fingerprint_num like '" + search + "' or fingerprint_name like '" + search + "'";
		}
		hql = hql + " order by fingerprint_gmt_create desc";
		Query query = session.createQuery(hql);
		query.setFirstResult((fingerprintVO.getPageIndex() - 1) * fingerprintVO.getPageSize());
		query.setMaxResults(fingerprintVO.getPageSize());
		List<xsjsglxt_fingerprint> list = query.list();
		session.clear();
		return list;
	}

}
