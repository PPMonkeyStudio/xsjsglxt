package com.xsjsglxt.dao.impl.Technology;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xsjsglxt.dao.Technology.DNADao;
import com.xsjsglxt.domain.DO.xsjsglxt_dna;
import com.xsjsglxt.domain.VO.Technology.DNAVO;

import util.TeamUtil;

public class DNADaoImpl implements DNADao {

	// 获取总记录数
	public int count_DNA_all(DNAVO dNAVO) {
		Session session = getSession();
		String hql = "select count(*) from xsjsglxt_dna where 1=1";
		if (dNAVO.getSearch() != null && dNAVO.getSearch().trim().length() > 0) {
			String search = "%" + dNAVO.getSearch().trim() + "%";
			hql = hql + " and dna_num like '" + search + "' or dna_name like '" + search + "'";
		}
		if (dNAVO.getSearchDnaBuilder() != null && dNAVO.getSearchDnaBuilder().trim().length() > 0)
			hql = hql + " and dna_builder = '" + dNAVO.getSearchDnaBuilder() + "'";
		if (dNAVO.getSearchFingerBuilder() != null && dNAVO.getSearchFingerBuilder().trim().length() > 0)
			hql = hql + " and finger_builder = '" + dNAVO.getSearchFingerBuilder() + "'";
		hql = hql + " order by dna_gmt_create";
		Query query = session.createQuery(hql);
		Long i = (Long) query.uniqueResult();
		int count = i.intValue();
		session.clear();
		return count;
	}

	// 分页
	public List<xsjsglxt_dna> list_xsjsglxt_dna(DNAVO dNAVO) {
		Session session = getSession();
		String hql = "from xsjsglxt_dna where 1=1";
		if (dNAVO.getSearch() != null && dNAVO.getSearch().trim().length() > 0) {
			String search = "%" + dNAVO.getSearch().trim() + "%";
			hql = hql + " and dna_num like '" + search + "' or dna_name like '" + search + "'";
		}
		if (dNAVO.getSearchDnaBuilder() != null && dNAVO.getSearchDnaBuilder().trim().length() > 0)
			hql = hql + " and dna_builder = '" + dNAVO.getSearchDnaBuilder() + "'";
		if (dNAVO.getSearchFingerBuilder() != null && dNAVO.getSearchFingerBuilder().trim().length() > 0)
			hql = hql + " and finger_builder = '" + dNAVO.getSearchFingerBuilder() + "'";
		hql = hql + " order by dna_gmt_create desc";
		Query query = session.createQuery(hql);
		query.setFirstResult((dNAVO.getPageIndex() - 1) * dNAVO.getPageSize());
		query.setMaxResults(dNAVO.getPageSize());
		List<xsjsglxt_dna> list = query.list();
		session.clear();
		return list;
	}

	// 得到最后插入记录字段值最后四位数
	@Override
	public int getFeild() {
		Session session = getSession();
		String year = TeamUtil.getCurrentYear();
		String hql = "select right(dna_num,6) FROM xsjsglxt_dna where LEFT(dna_gmt_create,4) ='" + year
				+ "'  ORDER BY right(dna_num,6) desc limit 1";
		/**
		 * 这里要记得使用 createSQLQuery 可能hql并不支持这种用法
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

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public int saveDNA(xsjsglxt_dna dNA) {
		Session session = getSession();
		try {
			session.save(dNA);
			// session.clear();//去掉，因为会切断数据库连接，切断前无法保证事务是否提交
			return 1;
		} catch (Exception e) {
			return 2;
		}
	}

	@Override
	public int deleteDNA(String xsjsglxt_dna_id) {
		Session session = getSession();
		String hql = "delete from xsjsglxt_dna where xsjsglxt_dna_id='" + xsjsglxt_dna_id + "'";
		Query query = session.createQuery(hql);
		int result = query.executeUpdate();
		return result;
	}

	@Override
	public xsjsglxt_dna get_dna(String xsjsglxt_dna_id) {
		Session session = getSession();
		String hql = "from xsjsglxt_dna where xsjsglxt_dna_id='" + xsjsglxt_dna_id + "'";
		Query query = session.createQuery(hql);
		xsjsglxt_dna dna = (xsjsglxt_dna) query.uniqueResult();
		return dna;
	}

	@Override
	public int modifiedDNA(xsjsglxt_dna dna) {
		Session session = getSession();
		String hql = "update xsjsglxt_dna set dna_name='" + dna.getDna_name() + "', dna_sex='" + dna.getDna_sex()
				+ "' ,dna_birthday='" + dna.getDna_birthday() + "', dna_identity='" + dna.getDna_identity()
				+ "',dna_address='" + dna.getDna_address() + "',dna_illegal_fact='" + dna.getDna_illegal_fact()
				+ "',dna_record_organization='" + dna.getDna_record_organization() + "' ,dna_organizer='"
				+ dna.getDna_organizer() + "' ,dna_record_time='" + dna.getDna_record_time() + "' ,dna_submit_time='"
				+ dna.getDna_submit_time() + "',dna_remark='" + dna.getDna_remark() + "' ,dna_gmt_modified='"
				+ dna.getDna_gmt_modified() + "'";
		Query query = session.createQuery(hql);
		int result = query.executeUpdate();
		return result;
	}

}