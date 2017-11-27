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
import com.xsjsglxt.domain.DO.xsjsglxt_briefdetails;
import com.xsjsglxt.domain.DO.xsjsglxt_case;
import com.xsjsglxt.domain.DO.xsjsglxt_lost;
import com.xsjsglxt.domain.DO.xsjsglxt_lost_computer;
import com.xsjsglxt.domain.DO.xsjsglxt_lost_mobilephone;
import com.xsjsglxt.domain.DO.xsjsglxt_picture;
import com.xsjsglxt.domain.DO.xsjsglxt_resevidence;
import com.xsjsglxt.domain.DO.xsjsglxt_snece;
import com.xsjsglxt.domain.VO.Case.page_list_senceInformationVO;

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

	@Override
	public void save(xsjsglxt_lost lost) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				try {
					getSession().save(lost);
					
				} catch (Error e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}

	@Override
	public void save(xsjsglxt_lost_mobilephone lost_mobilephone) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				try {
					getSession().save(lost_mobilephone);
					
				} catch (Error e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}

	@Override
	public void save(xsjsglxt_lost_computer lost_computer) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				try {
					getSession().save(lost_computer);
					
				} catch (Error e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
/*
 * (non-Javadoc)获得勘探编号
 * @see com.xsjsglxt.dao.Case.SenceDao#getSenceInformationInquestId()
 */
	@Override
	public String getSenceInformationInquestId() {
		// TODO Auto-generated method stub
		Session session = getSession();
		String hql = "SELECT COUNT(*) FROM xsjsglxt_snece WHERE DATE_FORMAT( snece_gmt_create, '%Y%m' ) = DATE_FORMAT( CURDATE( ) , '%Y%m' )";
		org.hibernate.Query query = session.createQuery(hql);
		int count = ((Number) query.uniqueResult()).intValue();
		Date date = new Date();
		DateFormat format = new SimpleDateFormat("yyyyMM");
		String time = format.format(date);
		String SenceInformationInquestId = null;
		if (count < 9) {
			SenceInformationInquestId = "K360302001" + time + "000" + (count + 1);
		} else if (9 <= count && count < 99) {
			SenceInformationInquestId = "K360302001" + time + "00" + (count + 1);
		} else if (99 <= count && count < 999) {
			SenceInformationInquestId = "K360302001" + time + "0" + (count + 1);
		} else if (999 <= count && count < 9999) {
			SenceInformationInquestId = "K360302001" + time + (count + 1);
		}
		session.clear();
		return SenceInformationInquestId;
		
	}

	@Override
	public int getCountSenceInformationByPage(page_list_senceInformationVO page_list_senceInformation) {
		// TODO Auto-generated method stub
		Session session = getSession();
		Long i;
		String hql = "select count(*) from xsjsglxt_case,xsjsglxt_snece where snece_case=xsjsglxt_case_id";
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
			String person = "%"+page_list_senceInformation.getSnece_inquestPerson().trim()+"%";
			hql = hql + " and snece_inquestPerson='"+person+"'";
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
		String hql = "from xsjsglxt_case,xsjsglxt_snece where snece_case=xsjsglxt_case_id";
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
			String person = "%"+page_list_senceInformation.getSnece_inquestPerson().trim()+"%";
			hql = hql + " and snece_inquestPerson='"+person+"'";
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
		session.clear();
		return listSenceInformationByPage;
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
		// TODO Auto-generated method stub
		Session session = getSession();

		String hql = "from xsjsglxt_snece sence where sence.snece_case='" + case1.getXsjsglxt_case_id() + "'";

		Query query = session.createQuery(hql);

		xsjsglxt_snece sence = (xsjsglxt_snece) query.uniqueResult();

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
 * (non-Javadoc)删除案件
 * @see com.xsjsglxt.dao.Case.SenceDao#getCaseByNum(java.lang.String)
 */
	@Override
	public xsjsglxt_case getCaseByNum(String case_id) {
		// TODO Auto-generated method stub
		Session session = getSession();
		xsjsglxt_case CaseInformation = null;
		String hql = "from xsjsglxt_case Case where Case.xsjsglxt_case_id='" + case_id + "'";
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
		String hql = "delete from xsjsglxt_case where briefdetails_case='" + xsjsglxt_case_id + "'";
		Query query = session.createQuery(hql);
		query.executeUpdate();
       return true;
	}

	@Override
	public boolean deleteLost_computerById(String xsjsglxt_case_id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteLost_mobilephoneById(String xsjsglxt_case_id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteLostById(String xsjsglxt_case_id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deletePictureById(String xsjsglxt_case_id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteSenceById(String xsjsglxt_case_id) {
		// TODO Auto-generated method stub
		return false;
	}
}
