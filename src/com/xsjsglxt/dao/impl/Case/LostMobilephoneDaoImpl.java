package com.xsjsglxt.dao.impl.Case;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xsjsglxt.dao.Case.LostMobilephoneDao;
import com.xsjsglxt.domain.DO.xsjsglxt_case;
import com.xsjsglxt.domain.DO.xsjsglxt_lost;
import com.xsjsglxt.domain.DO.xsjsglxt_lost_mobilephone;
import com.xsjsglxt.domain.DO.xsjsglxt_snece;
import com.xsjsglxt.domain.VO.Case.page_list_CasematerialVO;

public class LostMobilephoneDaoImpl implements LostMobilephoneDao {
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
/*
 * (non-Javadoc)保存损失手机
 * @see com.xsjsglxt.dao.Case.LostMobilephoneDao#saveLostMobilephone(com.xsjsglxt.domain.DO.xsjsglxt_lost_mobilephone)
 */
	@Override
	public void saveLostMobilephone(xsjsglxt_lost_mobilephone lost_mobilephone) {
		// TODO Auto-generated method stub
		try {
			getSession().save(lost_mobilephone);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
/*
 * (non-Javadoc)损失手机信息列表
 * @see com.xsjsglxt.dao.Case.LostMobilephoneDao#getCountLostMobilephoneInformationByPage(com.xsjsglxt.domain.VO.Case.page_list_CasematerialVO)
 */
	@Override
	public int getCountLostMobilephoneInformationByPage(page_list_CasematerialVO page_list_Casematerial) {
		// TODO Auto-generated method stub
		Session session = getSession();
		Long i;
		String hql = "select count(*) from xsjsglxt_lost_mobilephone where 1=1 order by lost_mobilephone_gmt_create";
		//1
		if (page_list_Casematerial.getLost_mobilephone_phone() != null
				&& page_list_Casematerial.getLost_mobilephone_phone().trim().length() > 0) {
			String lost_mobilephone_phone = "%" + page_list_Casematerial.getLost_mobilephone_phone() + "%";
			hql = hql + " and lost_mobilephone_phone like '" + lost_mobilephone_phone + "'";
				
		}
		//2
		if (page_list_Casematerial.getLost_mobilephone_IMEI() != null
				&& page_list_Casematerial.getLost_mobilephone_IMEI().trim().length() > 0) {
			String lost_mobilephone_IMEI = "%" + page_list_Casematerial.getLost_mobilephone_IMEI() + "%";
			hql = hql + " and lost_mobilephone_IMEI like '" + lost_mobilephone_IMEI + "'";
				
		}
		//3
		if (page_list_Casematerial.getLost_mobilephone_feature() != null
				&& page_list_Casematerial.getLost_mobilephone_feature().trim().length() > 0) {
			String lost_mobilephone_feature = "%" + page_list_Casematerial.getLost_mobilephone_feature() + "%";
			hql = hql + " and lost_mobilephone_feature like '" + lost_mobilephone_feature + "'";
				
		}
		Query query = session.createQuery(hql);	
		i = (Long) query.uniqueResult();
		session.clear();
		return i.intValue();
	}

	@Override
	public List<xsjsglxt_lost_mobilephone> getListLostMobilephoneInformatioByPage(
			page_list_CasematerialVO page_list_Casematerial) {
		// TODO Auto-generated method stub
		Session session = getSession();
		List<xsjsglxt_lost_mobilephone> listLostMobilephoneInformationByPage = new ArrayList<xsjsglxt_lost_mobilephone>();
		String hql = "from xsjsglxt_lost_mobilephone where 1=1 order by lost_mobilephone_gmt_create";
		//1
				if (page_list_Casematerial.getLost_mobilephone_phone() != null
						&& page_list_Casematerial.getLost_mobilephone_phone().trim().length() > 0) {
					String lost_mobilephone_phone = "%" + page_list_Casematerial.getLost_mobilephone_phone() + "%";
					hql = hql + " and lost_mobilephone_phone like '" + lost_mobilephone_phone + "'";
						
				}
				//2
				if (page_list_Casematerial.getLost_mobilephone_IMEI() != null
						&& page_list_Casematerial.getLost_mobilephone_IMEI().trim().length() > 0) {
					String lost_mobilephone_IMEI = "%" + page_list_Casematerial.getLost_mobilephone_IMEI() + "%";
					hql = hql + " and lost_mobilephone_IMEI like '" + lost_mobilephone_IMEI + "'";
						
				}
				//3
				if (page_list_Casematerial.getLost_mobilephone_feature() != null
						&& page_list_Casematerial.getLost_mobilephone_feature().trim().length() > 0) {
					String lost_mobilephone_feature = "%" + page_list_Casematerial.getLost_mobilephone_feature() + "%";
					hql = hql + " and lost_mobilephone_feature like '" + lost_mobilephone_feature + "'";
						
				}
		Query query = session.createQuery(hql);	
		query.setFirstResult(
				(page_list_Casematerial.getPageIndex() - 1) * page_list_Casematerial.getPageSize());
		query.setMaxResults(page_list_Casematerial.getPageSize());
		listLostMobilephoneInformationByPage = query.list();
		System.out.println(hql);
		session.clear();
		return listLostMobilephoneInformationByPage;
	}

	@Override
	public xsjsglxt_case getCaseByxsjsglxt_lost_mobilephone_id(xsjsglxt_lost_mobilephone lost_mobilephone) {
		// TODO Auto-generated method stub
		Session session = getSession();

		String hql = "from xsjsglxt_case Case where Case.xsjsglxt_case_id='" + lost_mobilephone.getLost_mobilephone_case() + "'";

		Query query = session.createQuery(hql);

		xsjsglxt_case Case = (xsjsglxt_case) query.uniqueResult();

		return Case;
	}

	@Override
	public xsjsglxt_snece getSenceByxsjsglxt_case_id(xsjsglxt_case case1) {
		// TODO Auto-generated method stub
		Session session = getSession();

		String hql = "from xsjsglxt_snece sence where sence.snece_case='" + case1.getXsjsglxt_case_id() + "'";

		Query query = session.createQuery(hql);

		xsjsglxt_snece sence = (xsjsglxt_snece) query.uniqueResult();

		return sence;
	}
}
