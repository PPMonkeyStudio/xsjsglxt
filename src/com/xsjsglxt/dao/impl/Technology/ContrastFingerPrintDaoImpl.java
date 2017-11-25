package com.xsjsglxt.dao.impl.Technology;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xsjsglxt.dao.Technology.ContrastFingerPrintDao;
import com.xsjsglxt.domain.DO.xsjsglxt_contrast_fingerprint;
import com.xsjsglxt.domain.DO.xsjsglxt_dna;

public class ContrastFingerPrintDaoImpl implements ContrastFingerPrintDao {
	
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}	

	@Override
	public int saveContrast(xsjsglxt_contrast_fingerprint contrastFingerPrint) {
		Session session = getSession();
		try {
			session.save(contrastFingerPrint);
//			session.clear();去掉，因为会切断数据库连接，切断前无法保证事务是否提交
			return 1;
		} catch (Exception e) {
			return 2;
		}
	}

	@Override
	public int deleteContrast(String contrast_fingerprint_id) {
		Session session = getSession();
		String hql = "delete from xsjsglxt_contrast_fingerprint where contrast_fingerprint_id='" + contrast_fingerprint_id + "'";
		Query query = session.createQuery(hql);
		int result = query.executeUpdate();
		return result;
	}

	@Override
	public int modifiedDNA(xsjsglxt_contrast_fingerprint contrastFingerPrint) {
		Session session = getSession();
		String hql = "update xsjsglxt_contrast_fingerprint set contrast_fingerprint_time='"+ contrastFingerPrint.getContrast_fingerprint_time()
						+"', contrast_fingerprint_way='"+contrastFingerPrint.getContrast_fingerprint_way()
						+"' ,contrast_fingerprint_locale_fingerprint_number='" +contrastFingerPrint.getContrast_fingerprint_locale_fingerprint_number()
						+"', contrast_fingerprint_press_fingerprint_number='"+contrastFingerPrint.getContrast_fingerprint_press_fingerprint_number()
						+"',contrast_fingerprint_case_type='"+contrastFingerPrint.getContrast_fingerprint_case_type()
						+"',contrast_fingerprint_case_territorial='"+contrastFingerPrint.getContrast_fingerprint_case_territorial()
						+"',contrast_fingerprint_level='"+contrastFingerPrint.getContrast_fingerprint_level()
						+"' ,contrast_fingerprint_case_note='"+contrastFingerPrint.getContrast_fingerprint_case_note()
						+"' ,contrast_fingerprint_suspecter_name='"+contrastFingerPrint.getContrast_fingerprint_suspecter_name()
						+"' ,contrast_fingerprint_suspecter_sex='"+contrastFingerPrint.getContrast_fingerprint_suspecter_sex()
						+"',contrast_fingerprint_suspecter_birthday='"+contrastFingerPrint.getContrast_fingerprint_suspecter_birthday()
						+"' ,contrast_fingerprint_suspecter_domicile='"+contrastFingerPrint.getContrast_fingerprint_suspecter_domicile()
						+"',contrast_fingerprint_suspecter_identity='"+contrastFingerPrint.getContrast_fingerprint_suspecter_identity()
						+"',contrast_fingerprint_present_address='"+contrastFingerPrint.getContrast_fingerprint_present_address()						
						+"',contrast_fingerprint_suspecter_arrested='"+contrastFingerPrint.getContrast_fingerprint_suspecter_arrested()
						+"',contrast_fingerprint_press_department='"+contrastFingerPrint.getContrast_fingerprint_press_department()
						+"',contrast_fingerprint_extract_department='"+contrastFingerPrint.getContrast_fingerprint_extract_department()
						+"',contrast_fingerprint_presser='"+contrastFingerPrint.getContrast_fingerprint_presser()
						+"',contrast_fingerprint_press_time='"+contrastFingerPrint.getContrast_fingerprint_press_time()
						+"',contrast_fingerprint_extracter='"+contrastFingerPrint.getContrast_fingerprint_extracter()
						+"',contrast_fingerprint_fingerposition='"+contrastFingerPrint.getContrast_fingerprint_fingerposition()
						+"',contrast_fingerprint_contrast_organization='"+contrastFingerPrint.getContrast_fingerprint_contrast_organization()
						+"',contrast_fingerprint_contraster='"+contrastFingerPrint.getContrast_fingerprint_contraster()
						+"',contrast_fingerprint_reviewer='"+contrastFingerPrint.getContrast_fingerprint_reviewer()
						+"',contrast_fingerprint_arrested_organization='"+contrastFingerPrint.getContrast_fingerprint_arrested_organization()
						+"',contrast_fingerprint_arrested_time='"+contrastFingerPrint.getContrast_fingerprint_arrested_time()
						+"',contrast_fingerprint_contract_number='"+contrastFingerPrint.getContrast_fingerprint_contract_number()
						+"',contrast_fingerprint_remark='"+contrastFingerPrint.getContrast_fingerprint_remark()
						+"',contrast_fingerprint_gmt_modified='"+contrastFingerPrint.getContrast_fingerprint_gmt_modified()
						+ "' where contrast_fingerprint_id='" + contrastFingerPrint.getContrast_fingerprint_id() + "'";
		Query query = session.createQuery(hql);
		int result = query.executeUpdate();
		return result;
	}

	@Override
	public xsjsglxt_contrast_fingerprint get_contrast(String contrast_fingerprint_id) {
		Session session = getSession();
		String hql = "from xsjsglxt_contrast_fingerprint where contrast_fingerprint_id='" + contrast_fingerprint_id + "'";
		Query query = session.createQuery(hql);
		xsjsglxt_contrast_fingerprint contrast = (xsjsglxt_contrast_fingerprint) query.uniqueResult();
		return contrast;
	}

}
