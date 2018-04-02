package com.xsjsglxt.dao.impl.Case;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xsjsglxt.dao.Case.BreakCaseDao;
import com.xsjsglxt.domain.DO.xsjsglxt_breakcase;
import com.xsjsglxt.domain.DO.xsjsglxt_briefdetails;
import com.xsjsglxt.domain.DO.xsjsglxt_case;
import com.xsjsglxt.domain.DO.xsjsglxt_snece;
import com.xsjsglxt.domain.VO.Case.page_list_BreakecaseInformationVO;

public class BreakCaseDaoImpl implements BreakCaseDao {

	@Override
	public void saveBreakecase(xsjsglxt_breakcase breakCase) {
		try {
			Session session = getSession();
			session.save(breakCase);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}
	
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Boolean deleteBreakCaseById(String breakcase_id) {
		Session session = getSession();
		String hql = "delete from xsjsglxt_breakcase where xsjsglxt_breakcase_id='" + breakcase_id + "'";
		Query query = session.createQuery(hql);
		query.executeUpdate();
		return true;
	}
	
	/**
	 * 更新简要案情表记录
	 */
	@Override
	public void updateBriefDetails(xsjsglxt_briefdetails briefDetails) {
		Session session = this.getSession();
//		session.clear();
		session.saveOrUpdate(briefDetails);
	}

	@Override
	public void updateBreakCase(xsjsglxt_breakcase breakCase) {
		Session session = this.getSession();
		session.saveOrUpdate(breakCase);
	}

	@Override
	public void saveBriefDetails(xsjsglxt_briefdetails details) {
		try {
			Session session = getSession();
			session.save(details);
//			session.clear();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public xsjsglxt_breakcase getBreakCaseById(String breakcase_id) {
		Session session = getSession();
		String hql = "from xsjsglxt_breakcase where xsjsglxt_breakcase_id = '" + breakcase_id + "'";
		Query query = session.createQuery(hql);

		xsjsglxt_breakcase bc = (xsjsglxt_breakcase) query.uniqueResult();
//		session.clear();
		return bc;
	}

	@Override
	public void deleteBriefDetailsById(String breakcase_case_note) {
		Session session = getSession();
		String hql = "delete from xsjsglxt_briefdetails where xsjsglxt_briefdetails_id='" + breakcase_case_note + "'";
		Query query = session.createQuery(hql);
		query.executeUpdate();
	}

	/**
	 * 通过id查简要案情记录
	 */
	@Override
	public xsjsglxt_briefdetails getBriedDetailsById(String case_note_id) {
		String hql = "from xsjsglxt_briefdetails where xsjsglxt_briefdetails_id = '" + case_note_id + "'";
		xsjsglxt_briefdetails briedDetails = (xsjsglxt_briefdetails)getSession().createQuery(hql);
		return briedDetails;
	}

	/**
	 * 计算符合条件总记录数
	 */
	@Override
	public int getCountBreakecaseInformationByPage(page_list_BreakecaseInformationVO page_list_BreakecaseInformation) {
		Session session = getSession();
		Long i;
		//hql语句加小括号
		String hql = "select count(*) from xsjsglxt_case,xsjsglxt_snece,xsjsglxt_breakcase where 1=1 and ((snece_case=xsjsglxt_case_id) and (breakcase_case=xsjsglxt_case_id)) ";
		String startTime = "0000-00-00";
		String stopTime = "9999-99-99";
		// 1
		System.out.println("gdhgfhfghfg:"+page_list_BreakecaseInformation);
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
				+ "'order by breakcase_gmt_modified ";
//System.out.println(hql);
		Query query = session.createQuery(hql);
		i = (Long) query.uniqueResult();
		session.clear();
		return i.intValue();
	}

	@Override
	public List<xsjsglxt_breakcase> getListBreakecaseInformatioByPage(page_list_BreakecaseInformationVO page_list_BreakecaseInformation) {
		Session session = getSession();
		List<xsjsglxt_breakcase> listBreakecaseInformationByPage = new ArrayList<xsjsglxt_breakcase>();
		String hql = "select breakcase from xsjsglxt_case case1,xsjsglxt_snece sence,xsjsglxt_breakcase breakcase  where 1=1 and ((sence.snece_case=case1.xsjsglxt_case_id) and (breakcase.breakcase_case=case1.xsjsglxt_case_id))";
		
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
				+ "' order by breakcase.breakcase_gmt_modified desc";
		Query query = session.createQuery(hql);
		query.setFirstResult(
				(page_list_BreakecaseInformation.getPageIndex() - 1) * page_list_BreakecaseInformation.getPageSize());
		query.setMaxResults(page_list_BreakecaseInformation.getPageSize());
		listBreakecaseInformationByPage = query.list();
		session.clear();
		return listBreakecaseInformationByPage;
	}

	@Override
	public xsjsglxt_case get_case_ByBreakecaseId(xsjsglxt_breakcase breakcase) {
		Session session = getSession();
		String hql = "from xsjsglxt_case case1 where case1.xsjsglxt_case_id='" + breakcase.getBreakcase_case() + "'";
		Query query = session.createQuery(hql);
		xsjsglxt_case case1 = (xsjsglxt_case) query.uniqueResult();
//		session.clear();
		return case1;
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

}
