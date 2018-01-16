package com.xsjsglxt.dao.impl.Case;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xsjsglxt.dao.Case.SenceDao;
import com.xsjsglxt.domain.DO.xsjsglxt_breakecase;
import com.xsjsglxt.domain.DO.xsjsglxt_briefdetails;
import com.xsjsglxt.domain.DO.xsjsglxt_case;
import com.xsjsglxt.domain.DO.xsjsglxt_circulation;
import com.xsjsglxt.domain.DO.xsjsglxt_lost;
import com.xsjsglxt.domain.DO.xsjsglxt_lost_computer;
import com.xsjsglxt.domain.DO.xsjsglxt_lost_mobilephone;
import com.xsjsglxt.domain.DO.xsjsglxt_picture;
import com.xsjsglxt.domain.DO.xsjsglxt_resevidence;
import com.xsjsglxt.domain.DO.xsjsglxt_snece;
import com.xsjsglxt.domain.VO.Case.page_list_senceInformationVO;

import util.TeamUtil;

public class SenceDaoImpl implements SenceDao {
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
	public void save(xsjsglxt_snece sence) {
		// TODO Auto-generated method stub
		try {
			getSession().save(sence);
			
		} catch (Error e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void save(xsjsglxt_case case1) {
		// TODO Auto-generated method stub
		try {
			getSession().save(case1);
		} catch (Error e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void save(xsjsglxt_briefdetails briefdetails) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				try {
					getSession().save(briefdetails);
					
				} catch (Error e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}

	

	public int getMaxSenceInquestId() {
		int i;
		//201711
		String yearAndMonth =TeamUtil.yearAndMonth();
		String li="";
		//List<xsjsglxt_snece> xsjsglxt_snece = new ArrayList<xsjsglxt_snece>();
		//K3603020012017110001
		String hql = "select right(snece_inquestId,4) from xsjsglxt_snece ORDER BY right(snece_inquestId,4) desc limit 1";
		
		System.out.println(hql);
		Query query = getSession().createSQLQuery(hql);
		li=(String) query.uniqueResult();
		if(li==null || li.trim().length()<=0){
			getSession().clear();
			return 0;
		}
		i=Integer.parseInt(li);
		getSession().clear();
		return i;
		//i = Integer.parseInt((String) query.uniqueResult());
		//xsjsglxt_snece = query.list();
		//i = Integer.parseInt((String) query.uniqueResult());
   
		// i=xsjsglxt_snece.size();
		
		
	}

	@Override
	public int getCountSenceInformationByPage(page_list_senceInformationVO page_list_senceInformation) {
		// TODO Auto-generated method stub
		Session session = getSession();
		Long i;
		//String hql = "select count(*) from xsjsglxt_case,xsjsglxt_snece where xsjsglxt_case_id=snece_case";
		String hql = "select count(*) from xsjsglxt_case,xsjsglxt_snece  where 1=1 and snece_case= xsjsglxt_case_id";
		String startTime = "0000-00-00";
		String stopTime = "9999-99-99";
		  // 1
		if (page_list_senceInformation.getCase_totalCategory() != null
				&& page_list_senceInformation.getCase_totalCategory().trim().length() > 0) {
			String case_totalCategory = "%" + page_list_senceInformation.getCase_totalCategory() + "%";
			hql = hql + " and case_totalCategory like '" + case_totalCategory + "'";
				
		}
		// 2
		if (page_list_senceInformation.getCase_sonCategory() != null
				&& page_list_senceInformation.getCase_sonCategory().trim().length() > 0) {
			String case_sonCategory = "%" + page_list_senceInformation.getCase_sonCategory() + "%";
			hql = hql + " and case_sonCategory like '" + case_sonCategory + "'";
		}
		// 3
		if (page_list_senceInformation.getCase_classify() != null
				&& page_list_senceInformation.getCase_classify().trim().length() > 0) {
			String case_classify = "%" + page_list_senceInformation.getCase_classify() + "%";
			hql = hql + " and case_classify like '" + case_classify + "'";
		}
		// 4
		if (page_list_senceInformation.getCase_residence() != null
				&& page_list_senceInformation.getCase_residence().trim().length() > 0) {
			String case_residence = "%" + page_list_senceInformation.getCase_residence() + "%";
			hql = hql + " and case_residence like '" + case_residence + "'";
		}
		// 5
		if (page_list_senceInformation.getCase_concreteResidence() != null
				&& page_list_senceInformation.getCase_concreteResidence().trim().length() > 0) {
			String case_concreteResidence = "%" + page_list_senceInformation.getCase_concreteResidence() + "%";
			hql = hql + " and case_concreteResidence like '" + case_concreteResidence + "'";
		}
		// 6
		if (page_list_senceInformation.getSnece_inquestPerson() != null
				&& page_list_senceInformation.getSnece_inquestPerson().trim().length() > 0) {
			String person = "%" + page_list_senceInformation.getSnece_inquestPerson().trim()+ "%";
			hql = hql + " and snece_inquestPerson like'" + person+ "'";
		}
		// 7
		if (page_list_senceInformation.getCase_makeTime() != null
				&& page_list_senceInformation.getCase_makeTime().trim().length() > 0) {
			String case_makeTime = "%" + page_list_senceInformation.getCase_makeTime() + "%";
			hql = hql + " and case_makeTime like '" + case_makeTime + "'";
		}
		// 8
		if (page_list_senceInformation.getCase_makeMeans() != null
				&& page_list_senceInformation.getCase_makeMeans().trim().length() > 0) {
			String case_makeMeans = "%" + page_list_senceInformation.getCase_makeMeans() + "%";
			hql = hql + " and case_makeMeans like '" + case_makeMeans + "'";
		}
		// 9
		if (page_list_senceInformation.getCase_concreteMakeMeans() != null
				&& page_list_senceInformation.getCase_concreteMakeMeans().trim().length() > 0) {
			String case_concreteMakeMeans = "%" + page_list_senceInformation.getCase_concreteMakeMeans() + "%";
			hql = hql + " and case_concreteMakeMeans like '" + case_concreteMakeMeans + "'";
		}
		if (page_list_senceInformation.getStart_time() != null && page_list_senceInformation.getStart_time().trim().length() > 0) {
			startTime = page_list_senceInformation.getStart_time();
		}
		if (page_list_senceInformation.getStop_time() != null && page_list_senceInformation.getStop_time().trim().length() > 0) {
			stopTime = page_list_senceInformation.getStop_time();
		}
		hql = hql + " and case_receivingAlarmDate>='" + startTime + "' and case_receivingAlarmDate<='"
				+ stopTime + "' order by case_receivingAlarmDate";
		System.out.println(hql);
		Query query = session.createQuery(hql);	
		i = (Long) query.uniqueResult();
		session.clear();
		return i.intValue();
	}

	@Override
	public List<xsjsglxt_case> getListSenceInformatioByPage(page_list_senceInformationVO page_list_senceInformation) {
		// TODO Auto-generated method stub
		Session session = getSession();
		List<xsjsglxt_case> listSenceInformationByPage = new ArrayList<xsjsglxt_case>();
		String hql = "select case1  from xsjsglxt_case case1,xsjsglxt_snece sence where 1=1 and sence.snece_case=case1.xsjsglxt_case_id";
		System.out.println("每条数据"+hql);
		String startTime = "0000-00-00";
		String stopTime = "9999-99-99";
		  // 1
		if (page_list_senceInformation.getCase_totalCategory() != null
				&& page_list_senceInformation.getCase_totalCategory().trim().length() > 0) {
			String case_totalCategory = "%" + page_list_senceInformation.getCase_totalCategory() + "%";
			hql = hql + " and case_totalCategory like '" + case_totalCategory + "'";
				
		}
		// 2
		if (page_list_senceInformation.getCase_sonCategory() != null
				&& page_list_senceInformation.getCase_sonCategory().trim().length() > 0) {
			String case_sonCategory = "%" + page_list_senceInformation.getCase_sonCategory() + "%";
			hql = hql + " and case_sonCategory like '" + case_sonCategory + "'";
		}
		// 3
		if (page_list_senceInformation.getCase_classify() != null
				&& page_list_senceInformation.getCase_classify().trim().length() > 0) {
			String case_classify = "%" + page_list_senceInformation.getCase_classify() + "%";
			hql = hql + " and case_classify like '" + case_classify + "'";
		}
		// 4
		if (page_list_senceInformation.getCase_residence() != null
				&& page_list_senceInformation.getCase_residence().trim().length() > 0) {
			String case_residence = "%" + page_list_senceInformation.getCase_residence() + "%";
			hql = hql + " and case_residence like '" + case_residence + "'";
		}
		// 5
		if (page_list_senceInformation.getCase_concreteResidence() != null
				&& page_list_senceInformation.getCase_concreteResidence().trim().length() > 0) {
			String case_concreteResidence = "%" + page_list_senceInformation.getCase_concreteResidence() + "%";
			hql = hql + " and case_concreteResidence like '" + case_concreteResidence + "'";
		}
		// 6
		if (page_list_senceInformation.getSnece_inquestPerson() != null
				&& page_list_senceInformation.getSnece_inquestPerson().trim().length() > 0) {
			String person ="%" + page_list_senceInformation.getSnece_inquestPerson().trim()+ "%";
			hql = hql + " and snece_inquestPerson like '"+ person + "'";
		}
		// 7
		if (page_list_senceInformation.getCase_makeTime() != null
				&& page_list_senceInformation.getCase_makeTime().trim().length() > 0) {
			String case_makeTime = "%" + page_list_senceInformation.getCase_makeTime() + "%";
			hql = hql + " and case_makeTime like '" + case_makeTime + "'";
		}
		// 8
		if (page_list_senceInformation.getCase_makeMeans() != null
				&& page_list_senceInformation.getCase_makeMeans().trim().length() > 0) {
			String case_makeMeans = "%" + page_list_senceInformation.getCase_makeMeans() + "%";
			hql = hql + " and case_makeMeans like '" + case_makeMeans + "'";
		}
		// 9
		if (page_list_senceInformation.getCase_concreteMakeMeans() != null
				&& page_list_senceInformation.getCase_concreteMakeMeans().trim().length() > 0) {
			String case_concreteMakeMeans = "%" + page_list_senceInformation.getCase_concreteMakeMeans() + "%";
			hql = hql + " and case_concreteMakeMeans like '" + case_concreteMakeMeans + "'";
		}
		if (page_list_senceInformation.getStart_time() != null && page_list_senceInformation.getStart_time().trim().length() > 0) {
			startTime = page_list_senceInformation.getStart_time();
		}
		if (page_list_senceInformation.getStop_time() != null && page_list_senceInformation.getStop_time().trim().length() > 0) {
			stopTime = page_list_senceInformation.getStop_time();
		}
		hql = hql + " and case_receivingAlarmDate>='" + startTime + "' and case_receivingAlarmDate<='"
				+ stopTime + "' order by case_receivingAlarmDate";
		Query query = session.createQuery(hql);	
		query.setFirstResult(
				(page_list_senceInformation.getPageIndex() - 1) * page_list_senceInformation.getPageSize());
		query.setMaxResults(page_list_senceInformation.getPageSize());
		listSenceInformationByPage = query.list();
		System.out.println(hql);
	
		session.clear();
		return listSenceInformationByPage;
	}
	@Override
	public xsjsglxt_snece getSeceByCaseId(xsjsglxt_case case1) {
		// TODO Auto-generated method stub
		Session session = getSession();

		String hql = "from xsjsglxt_snece sence where sence.snece_case='" + case1.getXsjsglxt_case_id() + "'";

		Query query = session.createQuery(hql);

		xsjsglxt_snece sence = (xsjsglxt_snece) query.uniqueResult();

		return sence;
	}

	@Override
	public xsjsglxt_case getCaseByCaseId(xsjsglxt_case case1) {
		// TODO Auto-generated method stub
		Session session = getSession();

		String hql = "from xsjsglxt_case case1 where case1.xsjsglxt_case_id='" + case1.getXsjsglxt_case_id() + "'";

		Query query = session.createQuery(hql);

		 case1 = (xsjsglxt_case) query.uniqueResult();

		return case1;
	}
	@Override
	public xsjsglxt_briefdetails get_briefdetails_Byxsjsglxt_case_id(xsjsglxt_case case1) {
		// TODO Auto-generated method stub
		Session session = getSession();

		String hql = "from xsjsglxt_briefdetails briefdetails where briefdetails.briefdetails_case='" + case1.getXsjsglxt_case_id() + "'";

		Query query = session.createQuery(hql);

		xsjsglxt_briefdetails briefdetails = (xsjsglxt_briefdetails) query.uniqueResult();

		return briefdetails;
	}

	@Override
	public xsjsglxt_lost_computer get_lost_computer_Byxsjsglxt_case_id(xsjsglxt_case case1) {
		// TODO Auto-generated method stub
		Session session = getSession();

		String hql = "from xsjsglxt_lost_computer lost_computer where lost_computer.lost_computer_case='" + case1.getXsjsglxt_case_id() + "'";

		Query query = session.createQuery(hql);

		xsjsglxt_lost_computer lost_computer = (xsjsglxt_lost_computer) query.uniqueResult();

		return lost_computer;
	}

	@Override
	public xsjsglxt_lost_mobilephone get_lost_mobilephone_Byxsjsglxt_case_id(xsjsglxt_case case1) {
		// TODO Auto-generated method stub
		Session session = getSession();

		String hql = "from xsjsglxt_lost_mobilephone lost_mobilephone where lost_mobilephone.lost_mobilephone_case='" + case1.getXsjsglxt_case_id() + "'";

		Query query = session.createQuery(hql);

		xsjsglxt_lost_mobilephone lost_mobilephone = (xsjsglxt_lost_mobilephone) query.uniqueResult();

		return lost_mobilephone;
	}

	@Override
	public xsjsglxt_lost get_lost_Byxsjsglxt_case_id(xsjsglxt_case case1) {
		// TODO Auto-generated method stub
		Session session = getSession();

		String hql = "from xsjsglxt_lost lost where lost.lost_case='" + case1.getXsjsglxt_case_id() + "'";

		Query query = session.createQuery(hql);

		xsjsglxt_lost lost = (xsjsglxt_lost) query.uniqueResult();

		return lost;
	}

	@Override
	public xsjsglxt_picture get_picture_Byxsjsglxt_case_id(xsjsglxt_case case1) {
		// TODO Auto-generated method stub
		Session session = getSession();

		String hql = "from xsjsglxt_picture picture where picture.picture_case='" + case1.getXsjsglxt_case_id() + "'";

		Query query = session.createQuery(hql);

		xsjsglxt_picture picture = (xsjsglxt_picture) query.uniqueResult();

		return picture;
	}

	@Override
	public xsjsglxt_snece get_sence_Byxsjsglxt_case_id(xsjsglxt_case case1) {
		Session session = getSession();
		String hql = "from xsjsglxt_snece sence where sence.snece_case='" + case1.getXsjsglxt_case_id() + "'";
		Query query = session.createQuery(hql);
		xsjsglxt_snece sence = (xsjsglxt_snece) query.uniqueResult();
		session.clear();
		return sence;
	}

	@Override
	public xsjsglxt_resevidence get_resevidence_Byxsjsglxt_case_id(xsjsglxt_case case1) {
		// TODO Auto-generated method stub
		Session session = getSession();

		String hql = "from xsjsglxt_resevidence resevidence where resevidence.resevidence_case='" + case1.getXsjsglxt_case_id() + "'";

		Query query = session.createQuery(hql);

		xsjsglxt_resevidence resevidence = (xsjsglxt_resevidence) query.uniqueResult();

		return resevidence;
	}
/*
 * (non-Javadoc)ɾ������
 * @see com.xsjsglxt.dao.Case.SenceDao#getCaseByNum(java.lang.String)
 */
	@Override
	public xsjsglxt_case getCaseByNum(String case_id) {
		// TODO Auto-generated method stub
		Session session = getSession();
		xsjsglxt_case CaseInformation = null;
		String hql = "from xsjsglxt_case case1 where case1.xsjsglxt_case_id='" + case_id + "'";
		Query query = session.createQuery(hql);
		CaseInformation = (xsjsglxt_case) query.uniqueResult();
       return CaseInformation;
	}

	@Override
	public boolean deleteBriefdetailsById(String xsjsglxt_case_id) {
		// TODO Auto-generated method stub
		Session session = getSession();
		String hql = "delete from xsjsglxt_briefdetails where briefdetails_case='" + xsjsglxt_case_id + "'";
		Query query = session.createQuery(hql);
		query.executeUpdate();
       return true;
	}

	@Override
	public boolean deleteCaseById(String xsjsglxt_case_id) {
		// TODO Auto-generated method stub
		Session session = getSession();
		String hql = "delete from xsjsglxt_case where xsjsglxt_case_id='" + xsjsglxt_case_id + "'";
		Query query = session.createQuery(hql);
		query.executeUpdate();
       return true;
	}

	@Override
	public boolean deleteLost_computerById(String xsjsglxt_case_id) {
		// TODO Auto-generated method stub
		Session session = getSession();
		String hql = "delete from xsjsglxt_lost_computer where lost_computer_case='" + xsjsglxt_case_id + "'";
		Query query = session.createQuery(hql);
		query.executeUpdate();
       return true;
	}

	@Override
	public boolean deleteLost_mobilephoneById(String xsjsglxt_case_id) {
		// TODO Auto-generated method stub
		Session session = getSession();
		String hql = "delete from xsjsglxt_lost_mobilephone where lost_mobilephone_case='" + xsjsglxt_case_id + "'";
		Query query = session.createQuery(hql);
		query.executeUpdate();
       return true;
	}

	@Override
	public boolean deleteLostById(String xsjsglxt_case_id) {
		// TODO Auto-generated method stub
		Session session = getSession();
		String hql = "delete from xsjsglxt_lost where lost_case='" + xsjsglxt_case_id + "'";
		Query query = session.createQuery(hql);
		query.executeUpdate();
       return true;
	}

	@Override
	public boolean deletePictureById(String xsjsglxt_case_id) {
		// TODO Auto-generated method stub
		Session session = getSession();
		String hql = "delete from xsjsglxt_picture where picture_case='" + xsjsglxt_case_id + "'";
		Query query = session.createQuery(hql);
		query.executeUpdate();
       return true;
	}

	@Override
	public boolean deleteSenceById(String xsjsglxt_case_id) {
		// TODO Auto-generated method stub
		Session session = getSession();
		String hql = "delete from xsjsglxt_snece where snece_case='" + xsjsglxt_case_id + "'";
		Query query = session.createQuery(hql);
		query.executeUpdate();
       return true;
	}
/*
 * (non-Javadoc)��ϸ�ֳ���Ϣ
 * @see com.xsjsglxt.dao.Case.SenceDao#getSeceBySenceId(com.xsjsglxt.domain.DO.xsjsglxt_snece)
 */
	

	@Override
	public xsjsglxt_briefdetails getBriefdetailsByCaseID(xsjsglxt_case case1) {
		// TODO Auto-generated method stub
		Session session = getSession();

		String hql = "from xsjsglxt_briefdetails briefdetails where briefdetails.briefdetails_case='" + case1.getXsjsglxt_case_id() + "'";

		Query query = session.createQuery(hql);

		xsjsglxt_briefdetails	briefdetails = (xsjsglxt_briefdetails) query.uniqueResult();

		return briefdetails;
	}

	@Override
	public xsjsglxt_lost getLostByCaseID(xsjsglxt_case case1) {
		// TODO Auto-generated method stub
		Session session = getSession();

		String hql = "from xsjsglxt_lost lost where lost.lost_case='" + case1.getXsjsglxt_case_id() + "'";

		Query query = session.createQuery(hql);

		xsjsglxt_lost	lost = (xsjsglxt_lost) query.uniqueResult();

		return lost;
	}

	@Override
	public xsjsglxt_lost_mobilephone getLost_mobilephoneByCaseId(xsjsglxt_case case1) {
		// TODO Auto-generated method stub
		Session session = getSession();

		String hql = "from xsjsglxt_lost_mobilephone lost_mobilephone where lost_mobilephone.lost_mobilephone_case='" + case1.getXsjsglxt_case_id() + "'";

		Query query = session.createQuery(hql);

		xsjsglxt_lost_mobilephone	lost_mobilephone = (xsjsglxt_lost_mobilephone) query.uniqueResult();

		return lost_mobilephone;
	}

	@Override
	public xsjsglxt_resevidence getResevidenceByCaseId(xsjsglxt_case case1) {
		// TODO Auto-generated method stub
		Session session = getSession();

		String hql = "from xsjsglxt_resevidence resevidence where resevidence.resevidence_case='" + case1.getXsjsglxt_case_id() + "'";

		Query query = session.createQuery(hql);

		xsjsglxt_resevidence	resevidence = (xsjsglxt_resevidence) query.uniqueResult();

		return resevidence;
	}

	@Override
	public xsjsglxt_lost_computer getLost_computerByCaseId(xsjsglxt_case case1) {
		// TODO Auto-generated method stub
		Session session = getSession();

		String hql = "from xsjsglxt_lost_computer lost_computer where lost_computer.lost_computer_case='" + case1.getXsjsglxt_case_id() + "'";

		Query query = session.createQuery(hql);

		xsjsglxt_lost_computer	lost_computer = (xsjsglxt_lost_computer) query.uniqueResult();

		return lost_computer;
	}

	@Override
	public xsjsglxt_picture getPicturtByCaseId(xsjsglxt_case case1) {
		// TODO Auto-generated method stub
		Session session = getSession();

		String hql = "from xsjsglxt_picture picture where picture.picture_case='" + case1.getXsjsglxt_case_id() + "'";

		Query query = session.createQuery(hql);

		xsjsglxt_picture	picture = (xsjsglxt_picture) query.uniqueResult();

		return picture;
	}

	@Override
	public void updateSence(xsjsglxt_snece sence) {
		// TODO Auto-generated method stub
		try {
			getSession().merge(sence);
			getSession().saveOrUpdate(sence);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void updateCase(xsjsglxt_case case1) {
		// TODO Auto-generated method stub
		try {
			getSession().saveOrUpdate(case1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void updateBriefdetails(xsjsglxt_briefdetails briefdetails) {
		// TODO Auto-generated method stub
		try {
			getSession().merge(briefdetails);
			getSession().saveOrUpdate(briefdetails);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public xsjsglxt_snece getSenceById(String case1) {
		// TODO Auto-generated method stub
		Session session = getSession();

		String hql = "from xsjsglxt_snece sence where sence.snece_case='" + case1 + "'";

		Query query = session.createQuery(hql);

		xsjsglxt_snece	sence = (xsjsglxt_snece) query.uniqueResult();

		return sence;
	}

	@Override
	public xsjsglxt_briefdetails getBriefdetailsById(String case1) {
		// TODO Auto-generated method stub
		Session session = getSession();

		String hql = "from xsjsglxt_briefdetails briefdetails where briefdetails.briefdetails_case='" + case1 + "'";

		Query query = session.createQuery(hql);

		xsjsglxt_briefdetails	briefdetails = (xsjsglxt_briefdetails) query.uniqueResult();

		return briefdetails;
	}

	@Override
	public xsjsglxt_resevidence getResevidenceById(String xsjsglxt_case_id) {
		// TODO Auto-generated method stub
		Session session = getSession();

		String hql = "from xsjsglxt_resevidence resevidence where resevidence.resevidence_case='" + xsjsglxt_case_id + "'";

		Query query = session.createQuery(hql);

		xsjsglxt_resevidence	resevidence = (xsjsglxt_resevidence) query.uniqueResult();

		return resevidence;
	}

	@Override
	public boolean deleteCirculationById(String xsjsglxt_resevidence_id) {
		// TODO Auto-generated method stub
		Session session = getSession();
		String hql = "delete from xsjsglxt_circulation where circulation_resevidence='" + xsjsglxt_resevidence_id + "'";
		Query query = session.createQuery(hql);
		query.executeUpdate();
       return true;
	}

	@Override
	public boolean deleteResevidenceById(String xsjsglxt_case_id) {
		// TODO Auto-generated method stub
		Session session = getSession();
		String hql = "delete from xsjsglxt_resevidence where resevidence_case='" + xsjsglxt_case_id + "'";
		Query query = session.createQuery(hql);
		query.executeUpdate();
       return true;
	}

	@Override
	public boolean deleteBreakecaseById(String xsjsglxt_case_id) {
		// TODO Auto-generated method stub
		Session session = getSession();
		String hql = "delete from xsjsglxt_breakecase where breakecase_case='" + xsjsglxt_case_id + "'";
		Query query = session.createQuery(hql);
		query.executeUpdate();
       return true;
	}

	@Override
	public List<xsjsglxt_case> AllCase() {
		// TODO Auto-generated method stub
		Session session = getSession();
	
		String hql="from xsjsglxt_case";
		Query query = session.createQuery(hql);

		List<xsjsglxt_case> AllcaseList = query.list();
	
		return AllcaseList;
	}

	@Override
	public xsjsglxt_circulation get_circulation_Byresevidenceid(xsjsglxt_resevidence resevidence) {
		// TODO Auto-generated method stub
		Session session = getSession();

		String hql = "from xsjsglxt_circulation circulation where circulation.circulation_resevidence='" + resevidence.getXsjsglxt_resevidence_id()+ "'";

		Query query = session.createQuery(hql);

		xsjsglxt_circulation circulation = (xsjsglxt_circulation) query.uniqueResult();

		return circulation;
	
	}

	@Override
	public xsjsglxt_breakecase get_breakecase_Byxsjsglxt_case_id(xsjsglxt_case xsjsglxt_case) {
		// TODO Auto-generated method stub
		Session session = getSession();

		String hql = "from xsjsglxt_breakecase breakecase where breakecase.breakecase_case='" + xsjsglxt_case.getXsjsglxt_case_id()+ "'";

		Query query = session.createQuery(hql);

		xsjsglxt_breakecase breakecase = (xsjsglxt_breakecase) query.uniqueResult();

		return breakecase;
	}
	
}
