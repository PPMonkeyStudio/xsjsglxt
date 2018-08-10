package com.xsjsglxt.dao.impl.Case;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xsjsglxt.dao.Case.LostDao;
import com.xsjsglxt.domain.DO.xsjsglxt_case;
import com.xsjsglxt.domain.DO.xsjsglxt_lost;
import com.xsjsglxt.domain.DO.xsjsglxt_snece;
import com.xsjsglxt.domain.VO.Case.page_list_CasematerialVO;

public class LostDaoImpl implements LostDao {
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
 * 保存遗失物品
 */
	@Override
	public void save(xsjsglxt_lost lost) {
		// TODO Auto-generated method stub
		try {
			getSession().save(lost);
			
		} catch (Error e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
/*
 * 遗失物品记录数
 */
	@Override
	public int getCountLostInformationByPage(page_list_CasematerialVO page_list_Casematerial) {
		// TODO Auto-generated method stub
		Session session = getSession();
		Long i;
		String hql = "select count(*) from xsjsglxt_lost where 1=1 ";
		if (page_list_Casematerial.getLost_name() != null
				&& page_list_Casematerial.getLost_name().trim().length() > 0) {
			String lost_name = "%" + page_list_Casematerial.getLost_name() + "%";
			hql = hql + " and lost_name like '" + lost_name + "'";
				
		}
		Query query = session.createQuery(hql);	
		i = (Long) query.uniqueResult();
		session.clear();
		return i.intValue();
	}

	@Override
	public List<xsjsglxt_lost> getListLostInformatioByPage(page_list_CasematerialVO page_list_Casematerial) {
		// TODO Auto-generated method stub
		Session session = getSession();
		List<xsjsglxt_lost> listLostInformationByPage = new ArrayList<xsjsglxt_lost>();
		String hql = "from xsjsglxt_lost where 1=1 ";
		if (page_list_Casematerial.getLost_name() != null
				&& page_list_Casematerial.getLost_name().trim().length() > 0) {
			String lost_name = "%" + page_list_Casematerial.getLost_name() + "%";
			hql = hql + " and lost_name like '" + lost_name + "'";
				
		}
		Query query = session.createQuery(hql);	
		query.setFirstResult(
				(page_list_Casematerial.getPageIndex() - 1) * page_list_Casematerial.getPageSize());
		query.setMaxResults(page_list_Casematerial.getPageSize());
		listLostInformationByPage = query.list();
		System.out.println(hql);
		session.clear();
		return listLostInformationByPage;
	}

	@Override
	public xsjsglxt_case getCaseByxsjsglxt_lost_id(xsjsglxt_lost lost) {
		// TODO Auto-generated method stub
		
		Session session = getSession();

		String hql = "from xsjsglxt_case case1 where case1.xsjsglxt_case_id='" + lost.getLost_case() + "'";

		Query query = session.createQuery(hql);

		xsjsglxt_case case1 = (xsjsglxt_case) query.uniqueResult();

		return case1;
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

	@Override
	public xsjsglxt_lost getLostById(xsjsglxt_lost lost) {
		// TODO Auto-generated method stub
		Session session = getSession();

		String hql = "from xsjsglxt_lost lost where lost.xsjsglxt_lost_id='" + lost.getXsjsglxt_lost_id() + "'";

		Query query = session.createQuery(hql);

		 lost = (xsjsglxt_lost) query.uniqueResult();

		return lost;
	}

	@Override
	public void updateLost(xsjsglxt_lost lost) {
		// TODO Auto-generated method stub
		try {
			getSession().saveOrUpdate(lost);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public xsjsglxt_lost getLostByNum(String lost_id) {
		// TODO Auto-generated method stub
		Session session = getSession();
		xsjsglxt_lost LostInformation = null;
		String hql = "from xsjsglxt_lost lost where lost.xsjsglxt_lost_id='" + lost_id + "'";
		Query query = session.createQuery(hql);
		LostInformation = (xsjsglxt_lost) query.uniqueResult();
       return LostInformation;
	}

	@Override
	public boolean deleteLostById(String xsjsglxt_lost_id) {
		// TODO Auto-generated method stub
		Session session = getSession();
		String hql = "delete from xsjsglxt_lost where xsjsglxt_lost_id='" + xsjsglxt_lost_id + "'";
		Query query = session.createQuery(hql);
		query.executeUpdate();
       return true;
	}
}

