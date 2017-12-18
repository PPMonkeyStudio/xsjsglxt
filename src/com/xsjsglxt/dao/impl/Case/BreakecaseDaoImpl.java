package com.xsjsglxt.dao.impl.Case;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xsjsglxt.dao.Case.BreakecaseDao;
import com.xsjsglxt.domain.DO.xsjsglxt_breakecase;
import com.xsjsglxt.domain.DO.xsjsglxt_case;
import com.xsjsglxt.domain.DO.xsjsglxt_lost_mobilephone;
import com.xsjsglxt.domain.DO.xsjsglxt_picture;
import com.xsjsglxt.domain.DO.xsjsglxt_snece;
import com.xsjsglxt.domain.VO.Case.page_list_BreakecaseInformationVO;

public class BreakecaseDaoImpl implements BreakecaseDao {
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
	public void saveBreakecase(xsjsglxt_breakecase breakecase) {
		// TODO Auto-generated method stub
		try {
			getSession().save(breakecase);

		} catch (Error e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public int getCountBreakecaseInformationByPage(page_list_BreakecaseInformationVO page_list_BreakecaseInformation) {
		// TODO Auto-generated method stub
		Session session = getSession();
		Long i;
		// String hql = "select count(*) from xsjsglxt_case,xsjsglxt_snece where
		// xsjsglxt_case_id=snece_case";
		String hql = "select count(*) from xsjsglxt_case,xsjsglxt_snece,xsjsglxt_breakecase where 1=1 and snece_case= xsjsglxt_case_id and breakecase_case=xsjsglxt_case_id";
		String startTime = "0000-00-00";
		String stopTime = "9999-99-99";
		// 1
		if (page_list_BreakecaseInformation.getSnece_inquestId() != null
				&& page_list_BreakecaseInformation.getSnece_inquestId().trim().length() > 0) {
			String snece_inquestId = "%" + page_list_BreakecaseInformation.getSnece_inquestId() + "%";
			hql = hql + " and snece_inquestId like '" + snece_inquestId + "'";

		}
		// 2
		if (page_list_BreakecaseInformation.getCase_totalCategory() != null
				&& page_list_BreakecaseInformation.getCase_totalCategory().trim().length() > 0) {
			String case_totalCategory = "%" + page_list_BreakecaseInformation.getCase_totalCategory() + "%";
			hql = hql + " and case_totalCategory like '" + case_totalCategory + "'";
		}
		// 3
		if (page_list_BreakecaseInformation.getCase_sonCategory() != null
				&& page_list_BreakecaseInformation.getCase_sonCategory().trim().length() > 0) {
			String case_sonCategory = "%" + page_list_BreakecaseInformation.getCase_sonCategory() + "%";
			hql = hql + " and case_sonCategory like '" + case_sonCategory + "'";
		}
		// 4
		if (page_list_BreakecaseInformation.getBreakecase_suspectName() != null
				&& page_list_BreakecaseInformation.getBreakecase_suspectName().trim().length() > 0) {
			String breakecase_suspectName = "%" + page_list_BreakecaseInformation.getBreakecase_suspectName() + "%";
			hql = hql + " and breakecase_suspectName like '" + breakecase_suspectName + "'";
		}
		// 5
		if (page_list_BreakecaseInformation.getBreakecase_captureUnit() != null
				&& page_list_BreakecaseInformation.getBreakecase_captureUnit().trim().length() > 0) {
			String breakecase_captureUnit = "%" + page_list_BreakecaseInformation.getBreakecase_captureUnit() + "%";
			hql = hql + " and breakecase_captureUnit like '" + breakecase_captureUnit + "'";
		}

		if (page_list_BreakecaseInformation.getStart_time() != null
				&& page_list_BreakecaseInformation.getStart_time().trim().length() > 0) {
			startTime = page_list_BreakecaseInformation.getStart_time();
		}
		if (page_list_BreakecaseInformation.getStop_time() != null
				&& page_list_BreakecaseInformation.getStop_time().trim().length() > 0) {
			stopTime = page_list_BreakecaseInformation.getStop_time();
		}
		hql = hql + " and case_receivingAlarmDate>='" + startTime + "' and case_receivingAlarmDate<='" + stopTime
				+ "' order by case_receivingAlarmDate";
		System.out.println(hql);
		Query query = session.createQuery(hql);
		i = (Long) query.uniqueResult();
		session.clear();
		return i.intValue();
	}

	@Override
	public List<xsjsglxt_breakecase> getListBreakecaseInformatioByPage(
			page_list_BreakecaseInformationVO page_list_BreakecaseInformation) {
		// TODO Auto-generated method stub
		Session session = getSession();
		List<xsjsglxt_breakecase> listBreakecaseInformationByPage = new ArrayList<xsjsglxt_breakecase>();
		String hql = "select breakecase  from xsjsglxt_case case1,xsjsglxt_snece sence,xsjsglxt_breakecase breakecase  where 1=1 and sence.snece_case=case1.xsjsglxt_case_id and breakecase.breakecase_case=case1.xsjsglxt_case_id";
		String startTime = "0000-00-00";
		String stopTime = "9999-99-99";
		// 1
		if (page_list_BreakecaseInformation.getSnece_inquestId() != null
				&& page_list_BreakecaseInformation.getSnece_inquestId().trim().length() > 0) {
			String snece_inquestId = "%" + page_list_BreakecaseInformation.getSnece_inquestId() + "%";
			hql = hql + " and snece_inquestId like '" + snece_inquestId + "'";

		}
		// 2
		if (page_list_BreakecaseInformation.getCase_totalCategory() != null
				&& page_list_BreakecaseInformation.getCase_totalCategory().trim().length() > 0) {
			String case_totalCategory = "%" + page_list_BreakecaseInformation.getCase_totalCategory() + "%";
			hql = hql + " and case_totalCategory like '" + case_totalCategory + "'";
		}
		// 3
		if (page_list_BreakecaseInformation.getCase_sonCategory() != null
				&& page_list_BreakecaseInformation.getCase_sonCategory().trim().length() > 0) {
			String case_sonCategory = "%" + page_list_BreakecaseInformation.getCase_sonCategory() + "%";
			hql = hql + " and case_sonCategory like '" + case_sonCategory + "'";
		}
		// 4
		if (page_list_BreakecaseInformation.getBreakecase_suspectName() != null
				&& page_list_BreakecaseInformation.getBreakecase_suspectName().trim().length() > 0) {
			String breakecase_suspectName = "%" + page_list_BreakecaseInformation.getBreakecase_suspectName() + "%";
			hql = hql + " and breakecase_suspectName like '" + breakecase_suspectName + "'";
		}
		// 5
		if (page_list_BreakecaseInformation.getBreakecase_captureUnit() != null
				&& page_list_BreakecaseInformation.getBreakecase_captureUnit().trim().length() > 0) {
			String breakecase_captureUnit = "%" + page_list_BreakecaseInformation.getBreakecase_captureUnit() + "%";
			hql = hql + " and breakecase_captureUnit like '" + breakecase_captureUnit + "'";
		}

		if (page_list_BreakecaseInformation.getStart_time() != null
				&& page_list_BreakecaseInformation.getStart_time().trim().length() > 0) {
			startTime = page_list_BreakecaseInformation.getStart_time();
		}
		if (page_list_BreakecaseInformation.getStop_time() != null
				&& page_list_BreakecaseInformation.getStop_time().trim().length() > 0) {
			stopTime = page_list_BreakecaseInformation.getStop_time();
		}
		hql = hql + " and case_receivingAlarmDate>='" + startTime + "' and case_receivingAlarmDate<='" + stopTime
				+ "' order by case_receivingAlarmDate";
		Query query = session.createQuery(hql);
		query.setFirstResult(
				(page_list_BreakecaseInformation.getPageIndex() - 1) * page_list_BreakecaseInformation.getPageSize());
		query.setMaxResults(page_list_BreakecaseInformation.getPageSize());
		listBreakecaseInformationByPage = query.list();
		System.out.println(hql);

		session.clear();
		return listBreakecaseInformationByPage;
	}

	@Override
	public xsjsglxt_case get_case_ByBreakecaseId(xsjsglxt_breakecase breakecase) {
		// TODO Auto-generated method stub
		Session session = getSession();

		String hql = "from xsjsglxt_case case1 where case1.xsjsglxt_case_id='" + breakecase.getBreakecase_case() + "'";

		Query query = session.createQuery(hql);

		xsjsglxt_case case1 = (xsjsglxt_case) query.uniqueResult();

		session.clear();
		return case1;
	}

	// substring(snece_inquestId,9)
	@Override
	public xsjsglxt_snece get_sence_Byxsjsglxt_case_id(xsjsglxt_case case1) {
		// TODO Auto-generated method stub
		Session session = getSession();

		String hql = "from xsjsglxt_snece sence where sence.snece_case='" + case1.getXsjsglxt_case_id() + "'";

		Query query = session.createQuery(hql);

		xsjsglxt_snece sence = (xsjsglxt_snece) query.uniqueResult();
		
		session.clear();
		return sence;
	}

	@Override
	public xsjsglxt_case getCaseById(xsjsglxt_case case1) {
		// TODO Auto-generated method stub
		Session session = getSession();

		String hql = "from xsjsglxt_case case1 where case1.xsjsglxt_case_id='" + case1.getXsjsglxt_case_id() + "'";

		Query query = session.createQuery(hql);

		case1 = (xsjsglxt_case) query.uniqueResult();

		return case1;
	}

	@Override
	public xsjsglxt_snece getSenceByID(xsjsglxt_case case1) {
		// TODO Auto-generated method stub
		Session session = getSession();

		String hql = "from xsjsglxt_snece sence where sence.snece_case='" + case1.getXsjsglxt_case_id() + "'";

		Query query = session.createQuery(hql);

		xsjsglxt_snece sence = (xsjsglxt_snece) query.uniqueResult();

		return sence;
	}

	@Override
	public xsjsglxt_breakecase getBreakecaseById(xsjsglxt_case case1) {
		// TODO Auto-generated method stub
		Session session = getSession();

		String hql = "from xsjsglxt_breakecase breakecase where breakecase.breakecase_case='"
				+ case1.getXsjsglxt_case_id() + "'";

		Query query = session.createQuery(hql);

		xsjsglxt_breakecase breakecase = (xsjsglxt_breakecase) query.uniqueResult();

		return breakecase;
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
	public xsjsglxt_breakecase getByID(String xsjsglxt_case_id) {
		// TODO Auto-generated method stub
		Session session = getSession();

		String hql = "from xsjsglxt_breakecase breakecase where breakecase.breakecase_case='" + xsjsglxt_case_id + "'";

		Query query = session.createQuery(hql);

		xsjsglxt_breakecase breakecase = (xsjsglxt_breakecase) query.uniqueResult();

		return breakecase;
	}

	@Override
	public void updateBreakcase(xsjsglxt_breakecase breakecase) {
		// TODO Auto-generated method stub
		try {
			getSession().saveOrUpdate(breakecase);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public xsjsglxt_snece getByCID(String xsjsglxt_case_id) {
		// TODO Auto-generated method stub
		Session session = getSession();

		String hql = "from xsjsglxt_snece snece where snece.snece_case='" + xsjsglxt_case_id + "'";

		Query query = session.createQuery(hql);

		xsjsglxt_snece snece = (xsjsglxt_snece) query.uniqueResult();

		return snece;
	}

	@Override
	public void updateSence(xsjsglxt_snece sence) {
		// TODO Auto-generated method stub
		try {
			getSession().saveOrUpdate(sence);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public xsjsglxt_breakecase getBreakecaseByNum(String breakecase_id) {
		// TODO Auto-generated method stub
		Session session = getSession();
		xsjsglxt_breakecase BreakecaseInformation = null;
		String hql = "from xsjsglxt_breakecase breakecase where breakecase.xsjsglxt_breakecase_id='" + breakecase_id
				+ "'";
		Query query = session.createQuery(hql);
		BreakecaseInformation = (xsjsglxt_breakecase) query.uniqueResult();
		return BreakecaseInformation;
	}

	@Override
	public boolean deleteBreakecaseById(String xsjsglxt_breakecase_id) {
		// TODO Auto-generated method stub
		Session session = getSession();
		String hql = "delete from xsjsglxt_breakecase where xsjsglxt_breakecase_id='" + xsjsglxt_breakecase_id + "'";
		Query query = session.createQuery(hql);
		query.executeUpdate();
		return true;
	}
}
