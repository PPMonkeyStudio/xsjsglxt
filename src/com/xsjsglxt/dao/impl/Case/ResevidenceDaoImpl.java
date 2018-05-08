package com.xsjsglxt.dao.impl.Case;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xsjsglxt.dao.Case.ResevidenceDao;
import com.xsjsglxt.domain.DO.xsjsglxt_case;
import com.xsjsglxt.domain.DO.xsjsglxt_circulation;
import com.xsjsglxt.domain.DO.xsjsglxt_resevidence;
import com.xsjsglxt.domain.DO.xsjsglxt_snece;
import com.xsjsglxt.domain.VO.Case.page_list_ResevidenceInformationVO;

public class ResevidenceDaoImpl implements ResevidenceDao {
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
	public void save(xsjsglxt_resevidence resevidence) {
		// TODO Auto-generated method stub
		try {
			getSession().save(resevidence);

		} catch (Error e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public int getCountResevidenceInformationByPage(
			page_list_ResevidenceInformationVO page_list_ResevidenceInformation) {
		// TODO Auto-generated method stub
		Session session = getSession();
		Long i;
		String startTime = "";
		String stopTime = "9999-99-99";
		String hql = "select count(*) from xsjsglxt_resevidence where 1=1 ";
		// 1
		if (page_list_ResevidenceInformation.getResevidence_extractPerson() != null
				&& page_list_ResevidenceInformation.getResevidence_extractPerson().trim().length() > 0) {
			String resevidence_extractPerson = "%" + page_list_ResevidenceInformation.getResevidence_extractPerson()
					+ "%";
			hql = hql + " and resevidence_extractPerson like '" + resevidence_extractPerson + "'";

		}
		if (page_list_ResevidenceInformation.getStart_time() != null
				&& page_list_ResevidenceInformation.getStart_time().trim().length() > 0) {
			startTime = page_list_ResevidenceInformation.getStart_time();
		}
		if (page_list_ResevidenceInformation.getStop_time() != null
				&& page_list_ResevidenceInformation.getStop_time().trim().length() > 0) {
			stopTime = page_list_ResevidenceInformation.getStop_time();
		}
		hql = hql + " and resevidence_extractTime>='" + startTime + "' and resevidence_extractTime<='" + stopTime
				+ "' order by resevidence_extractTime";
		Query query = session.createQuery(hql);
		i = (Long) query.uniqueResult();
		session.clear();
		return i.intValue();
	}

	@Override
	public List<xsjsglxt_resevidence> getListResevidenceInformatioByPage(
			page_list_ResevidenceInformationVO page_list_ResevidenceInformation) {
		// TODO Auto-generated method stub
		Session session = getSession();
		String startTime = "";
		String stopTime = "9999-99-99";
		List<xsjsglxt_resevidence> listResevidenceInformationByPage = new ArrayList<xsjsglxt_resevidence>();
		String hql = "from xsjsglxt_resevidence where 1=1 ";
		// 1
		if (page_list_ResevidenceInformation.getResevidence_extractPerson() != null
				&& page_list_ResevidenceInformation.getResevidence_extractPerson().trim().length() > 0) {
			String resevidence_extractPerson = "%" + page_list_ResevidenceInformation.getResevidence_extractPerson()
					+ "%";
			hql = hql + " and resevidence_extractPerson like '" + resevidence_extractPerson + "'";

		}
		if (page_list_ResevidenceInformation.getStart_time() != null
				&& page_list_ResevidenceInformation.getStart_time().trim().length() > 0) {
			startTime = page_list_ResevidenceInformation.getStart_time();
		}
		if (page_list_ResevidenceInformation.getStop_time() != null
				&& page_list_ResevidenceInformation.getStop_time().trim().length() > 0) {
			stopTime = page_list_ResevidenceInformation.getStop_time();
		}
		hql = hql + " and resevidence_extractTime>='" + startTime + "' and resevidence_extractTime<='" + stopTime
				+ "' order by resevidence_extractTime";
		Query query = session.createQuery(hql);
		query.setFirstResult(
				(page_list_ResevidenceInformation.getPageIndex() - 1) * page_list_ResevidenceInformation.getPageSize());
		query.setMaxResults(page_list_ResevidenceInformation.getPageSize());
		listResevidenceInformationByPage = query.list();
		System.out.println(hql);
		session.clear();
		return listResevidenceInformationByPage;
	}

	@Override
	public xsjsglxt_case getCaseByxsjsglxt_resevidence_id(xsjsglxt_resevidence resevidence) {
		// TODO Auto-generated method stub
		Session session = getSession();
		String hql = "from xsjsglxt_case case1 where case1.xsjsglxt_case_id='" + resevidence.getResevidence_case()
				+ "'";

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
	public List<xsjsglxt_circulation> getCirculationByxsjsglxt_resevidence_id(xsjsglxt_resevidence resevidence) {
		// TODO Auto-generated method stub
		Session session = getSession();
		String hql = "from xsjsglxt_circulation circulation where circulation.circulation_resevidence='"
				+ resevidence.getXsjsglxt_resevidence_id() + "'";

		Query query = session.createQuery(hql);

		List<xsjsglxt_circulation> circulation = query.list();

		return circulation;
	}

	@Override
	public xsjsglxt_resevidence getResevidenceById(xsjsglxt_resevidence resevidence) {
		// TODO Auto-generated method stub
		Session session = getSession();

		String hql = "from xsjsglxt_resevidence resevidence where resevidence.xsjsglxt_resevidence_id='"
				+ resevidence.getXsjsglxt_resevidence_id() + "'";

		Query query = session.createQuery(hql);

		resevidence = (xsjsglxt_resevidence) query.uniqueResult();
		session.clear();
		return resevidence;
	}

	@Override
	public xsjsglxt_case getcaseByresevidenceId(xsjsglxt_resevidence resevidence) {
		// TODO Auto-generated method stub
		Session session = getSession();

		String hql = "from xsjsglxt_case case1 where case1.xsjsglxt_case_id='" + resevidence.getResevidence_case()
				+ "'";

		Query query = session.createQuery(hql);

		xsjsglxt_case case1 = (xsjsglxt_case) query.uniqueResult();

		return case1;
	}

	@Override
	public xsjsglxt_snece getsenceBycase1Id(xsjsglxt_case case1) {
		// TODO Auto-generated method stub
		Session session = getSession();

		String hql = "from xsjsglxt_snece sence where sence.snece_case='" + case1.getXsjsglxt_case_id() + "'";

		Query query = session.createQuery(hql);

		xsjsglxt_snece sence = (xsjsglxt_snece) query.uniqueResult();

		return sence;
	}

	/**
	 * @author 何毅
	 */
	@Override
	public List<xsjsglxt_circulation> getcirculationByresevidenceId(xsjsglxt_resevidence resevidence) {
		// TODO Auto-generated method stub
		Session session = getSession();

		String hql = "from xsjsglxt_circulation circulation where circulation.circulation_resevidence='"
				+ resevidence.getXsjsglxt_resevidence_id() + "'";

		Query query = session.createQuery(hql);

		List<xsjsglxt_circulation> circulation = query.list();

		return circulation;
	}

	/*
	 * 保存物证流转信息
	 * 
	 */
	@Override
	public void saveCirculation(xsjsglxt_circulation circulation) {
		// TODO Auto-generated method stub
		try {
			getSession().save(circulation);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public xsjsglxt_resevidence getByResevidenceNum(String resevidence_id) {
		// TODO Auto-generated method stub
		Session session = getSession();
		xsjsglxt_resevidence ResevidenceInformation = null;
		String hql = "from xsjsglxt_resevidence resevidence where resevidence.xsjsglxt_resevidence_id='"
				+ resevidence_id + "'";
		Query query = session.createQuery(hql);
		ResevidenceInformation = (xsjsglxt_resevidence) query.uniqueResult();
		return ResevidenceInformation;
	}

	@Override
	public boolean deleteResevidenceById(String xsjsglxt_resevidence_id) {
		// TODO Auto-generated method stub
		Session session = getSession();
		String hql = "delete from xsjsglxt_resevidence where xsjsglxt_resevidence_id='" + xsjsglxt_resevidence_id + "'";
		Query query = session.createQuery(hql);
		query.executeUpdate();
		return true;
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
	public void updateResevidenceIn(xsjsglxt_resevidence resevidence) {
		// TODO Auto-generated method stub
		try {
			getSession().saveOrUpdate(resevidence);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @author 孙毅 修改流转状态
	 */

	@Override
	public void updateStatus(xsjsglxt_resevidence resevidence) {
		// TODO Auto-generated method stub
		String hql = "update xsjsglxt_resevidence set resevidence_circulation = '"
				+ resevidence.getResevidence_circulation() + "' where xsjsglxt_resevidence_id ='"
				+ resevidence.getXsjsglxt_resevidence_id() + "'";
		Session session = this.getSession();
		session.createQuery(hql).executeUpdate();
	}

	@Override
	public void updateResevidenceCheckState(xsjsglxt_resevidence resevidence) {
		// TODO Auto-generated method stub
		String hql = "update xsjsglxt_resevidence set resevidence_teststate = '"
				+ resevidence.getResevidence_teststate() + "' where xsjsglxt_resevidence_id ='"
				+ resevidence.getXsjsglxt_resevidence_id() + "'";
		Session session = this.getSession();
		session.createQuery(hql).executeUpdate();
	}

	@Override
	public void updateResevidenceSendCheckState(xsjsglxt_resevidence resevidence) {
		// TODO Auto-generated method stub
		String hql = "update xsjsglxt_resevidence set resevidence_sendstate = '"
				+ resevidence.getResevidence_sendstate() + "' where xsjsglxt_resevidence_id ='"
				+ resevidence.getXsjsglxt_resevidence_id() + "'";
		Session session = this.getSession();
		session.createQuery(hql).executeUpdate();
	}

}
