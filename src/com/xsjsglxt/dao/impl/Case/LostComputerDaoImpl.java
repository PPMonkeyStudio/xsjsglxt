package com.xsjsglxt.dao.impl.Case;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xsjsglxt.dao.Case.LostComputerDao;
import com.xsjsglxt.domain.DO.xsjsglxt_case;
import com.xsjsglxt.domain.DO.xsjsglxt_lost_computer;
import com.xsjsglxt.domain.DO.xsjsglxt_lost_mobilephone;
import com.xsjsglxt.domain.DO.xsjsglxt_snece;
import com.xsjsglxt.domain.VO.Case.page_list_CasematerialVO;

public class LostComputerDaoImpl implements LostComputerDao {
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
 * (non-Javadoc)±£´æËðÊ§µçÄÔ
 * @see com.xsjsglxt.dao.Case.LostComputerDao#saveLostComputer(com.xsjsglxt.domain.DO.xsjsglxt_lost_computer)
 */
	@Override
	public void saveLostComputer(xsjsglxt_lost_computer lost_computer) {
		// TODO Auto-generated method stub
		try {
			getSession().save(lost_computer);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
/*
 * (non-Javadoc)µçÄÔËðÊ§±í
 * @see com.xsjsglxt.dao.Case.LostComputerDao#getCountLostComputerInformationByPage(com.xsjsglxt.domain.VO.Case.page_list_CasematerialVO)
 */
	@Override
	public int getCountLostComputerInformationByPage(page_list_CasematerialVO page_list_Casematerial) {
		// TODO Auto-generated method stub
		Session session = getSession();
		Long i;
		String hql = "select count(*) from xsjsglxt_lost_computer where 1=1 order by lost_computer_gmt_create";
		//1
		if (page_list_Casematerial.getLost_computer_brand() != null
				&& page_list_Casematerial.getLost_computer_brand().trim().length() > 0) {
			String lost_computer_brand = "%" + page_list_Casematerial.getLost_computer_brand() + "%";
			hql = hql + " and lost_computer_brand like '" + lost_computer_brand + "'";
				
		}
		//2
		if (page_list_Casematerial.getLost_computer_internetAccount() != null
				&& page_list_Casematerial.getLost_computer_internetAccount().trim().length() > 0) {
			String lost_computer_internetAccount = "%" + page_list_Casematerial.getLost_computer_internetAccount() + "%";
			hql = hql + " and lost_computer_internetAccount like '" + lost_computer_internetAccount + "'";
				
		}
		//3
		if (page_list_Casematerial.getLost_computer_MAC() != null
				&& page_list_Casematerial.getLost_computer_MAC().trim().length() > 0) {
			String lost_computer_MAC = "%" + page_list_Casematerial.getLost_computer_MAC() + "%";
			hql = hql + " and lost_computer_MAC like '" + lost_computer_MAC + "'";
				
		}
		Query query = session.createQuery(hql);	
		i = (Long) query.uniqueResult();
		session.clear();
		return i.intValue();
	}

	@Override
	public List<xsjsglxt_lost_computer> getListLostComputerInformatioByPage(
			page_list_CasematerialVO page_list_Casematerial) {
		// TODO Auto-generated method stub
		Session session = getSession();
		List<xsjsglxt_lost_computer> listLostComputerInformationByPage = new ArrayList<xsjsglxt_lost_computer>();
		String hql = "from xsjsglxt_lost_computer where 1=1 order by lost_computer_gmt_create";
		//1
				if (page_list_Casematerial.getLost_computer_brand() != null
						&& page_list_Casematerial.getLost_computer_brand().trim().length() > 0) {
					String lost_computer_brand = "%" + page_list_Casematerial.getLost_computer_brand() + "%";
					hql = hql + " and lost_computer_brand like '" + lost_computer_brand + "'";
						
				}
				//2
				if (page_list_Casematerial.getLost_computer_internetAccount() != null
						&& page_list_Casematerial.getLost_computer_internetAccount().trim().length() > 0) {
					String lost_computer_internetAccount = "%" + page_list_Casematerial.getLost_computer_internetAccount() + "%";
					hql = hql + " and lost_computer_internetAccount like '" + lost_computer_internetAccount + "'";
						
				}
				//3
				if (page_list_Casematerial.getLost_computer_MAC() != null
						&& page_list_Casematerial.getLost_computer_MAC().trim().length() > 0) {
					String lost_computer_MAC = "%" + page_list_Casematerial.getLost_computer_MAC() + "%";
					hql = hql + " and lost_computer_MAC like '" + lost_computer_MAC + "'";
						
				}
		Query query = session.createQuery(hql);	
		query.setFirstResult(
				(page_list_Casematerial.getPageIndex() - 1) * page_list_Casematerial.getPageSize());
		query.setMaxResults(page_list_Casematerial.getPageSize());
		listLostComputerInformationByPage = query.list();
		System.out.println(hql);
		session.clear();
		return listLostComputerInformationByPage;
	}

	@Override
	public xsjsglxt_case getCaseByxsjsglxt_lost_computer_id(xsjsglxt_lost_computer lost_computer) {
		// TODO Auto-generated method stub
		Session session = getSession();
		String hql = "from xsjsglxt_case case1 where case1.xsjsglxt_case_id='" + lost_computer.getLost_computer_case() + "'";

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
	public xsjsglxt_lost_computer getLostComputerById(xsjsglxt_lost_computer lost_computer) {
		// TODO Auto-generated method stub
		Session session = getSession();

		String hql = "from xsjsglxt_lost_computer lost_computer where lost_computer.xsjsglxt_lost_computer_id='" + lost_computer.getXsjsglxt_lost_computer_id() + "'";

		Query query = session.createQuery(hql);

		 lost_computer = (xsjsglxt_lost_computer) query.uniqueResult();

		return lost_computer;
	}
}
