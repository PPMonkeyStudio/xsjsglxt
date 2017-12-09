package com.xsjsglxt.dao.impl.InspectionIdentification;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xsjsglxt.dao.InspectionIdentification.InspectionIdentificationDao;
import com.xsjsglxt.domain.DO.xsjsglxt_appraisal_letter;
import com.xsjsglxt.domain.DO.xsjsglxt_check_entrustment_book;
import com.xsjsglxt.domain.DO.xsjsglxt_damage_inspection_record;
import com.xsjsglxt.domain.DO.xsjsglxt_death_inspection_record;
import com.xsjsglxt.domain.DO.xsjsglxt_identifieder_case_confirm_book;
import com.xsjsglxt.domain.DO.xsjsglxt_inspection_record;
import com.xsjsglxt.domain.DO.xsjsglxt_not_acceptance_entrustment_inform;
import com.xsjsglxt.domain.VO.InspectionIdentification.EntrustmentBookManagementVO;

public class InspectionIdentificationDaoImpl implements InspectionIdentificationDao {
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	// 保存
	@Override
	public int saveObject(Object object) {
		int i = 1;
		try {
			getSession().saveOrUpdate(object);
		} catch (Exception e) {
			i = 2;
			e.printStackTrace();
		}
		getSession().flush();
		return i;
	}

	@Override
	public int getMaxCheckNum(String check_entrustment_book_year, String type) {
		int i = 0;
		String ji = "";
		String hql = "select substring(check_entrustment_book_num,5) from xsjsglxt_check_entrustment_book where substring(check_entrustment_book_num,1,4)='"
				+ check_entrustment_book_year + "' and check_entrustment_book_type='" + type
				+ "' order by substring(check_entrustment_book_num,5) desc limit 1";
		Query query = getSession().createSQLQuery(hql);
		ji = (String) query.uniqueResult();
		if (ji == null || ji.trim().length() <= 0) {
			getSession().clear();
			return 0;
		}
		i = Integer.parseInt(ji);
		getSession().clear();
		return i;
	}

	@Override
	public int getCountByPageAndSearch(EntrustmentBookManagementVO checkEntrustmentBookVO) {
		Long i;
		String startTime = "0000-00-00";
		String stopTime = "9999-99-99";
		String hql = "select count(*) from xsjsglxt_check_entrustment_book where 1=1 ";
		if (checkEntrustmentBookVO.getSearch() != null && checkEntrustmentBookVO.getSearch().trim().length() > 0) {
			String search = "%" + checkEntrustmentBookVO.getSearch().trim() + "%";
			hql = hql + " and check_entrustment_book_num like '" + search
					+ "' or check_entrustment_book_case_name like '" + search + "'";
		}
		if (checkEntrustmentBookVO.getState() != null && checkEntrustmentBookVO.getState().trim().length() > 0) {
			hql = hql + " and check_entrustment_book_state='" + checkEntrustmentBookVO.getState().trim() + "'";
		}
		if (checkEntrustmentBookVO.getUnitName() != null && checkEntrustmentBookVO.getUnitName().trim().length() > 0) {
			hql = hql + " and check_entrustment_book_entrustment_unit_name='"
					+ checkEntrustmentBookVO.getUnitName().trim() + "'";
		}
		if (checkEntrustmentBookVO.getType() != null && checkEntrustmentBookVO.getType().trim().length() > 0) {
			hql = hql + " and check_entrustment_book_type='" + checkEntrustmentBookVO.getType().trim() + "'";
		}
		if (checkEntrustmentBookVO.getStart_time() != null
				&& checkEntrustmentBookVO.getStart_time().trim().length() > 0) {
			startTime = checkEntrustmentBookVO.getStart_time();
		}
		if (checkEntrustmentBookVO.getStop_time() != null
				&& checkEntrustmentBookVO.getStop_time().trim().length() > 0) {
			stopTime = checkEntrustmentBookVO.getStop_time();
		}
		hql = hql + " and check_entrustment_book_inspect_time>='" + startTime
				+ "' and check_entrustment_book_inspect_time<='" + stopTime
				+ "' order by check_entrustment_book_inspect_time,check_entrustment_book_num desc";
		Query query = getSession().createQuery(hql);

		System.out.println(hql);
		
		i = (Long) query.uniqueResult();
		getSession().clear();
		return i.intValue();
	}

	// 分页查询所有
	@Override
	public List<xsjsglxt_check_entrustment_book> getListCheckEntrustmentBookByPage(
			EntrustmentBookManagementVO checkEntrustmentBookVO) {
		String startTime = "0000-00-00";
		String stopTime = "9999-99-99";
		String hql = "from xsjsglxt_check_entrustment_book where 1=1 ";
		List<xsjsglxt_check_entrustment_book> listPage = new ArrayList<xsjsglxt_check_entrustment_book>();
		if (checkEntrustmentBookVO.getSearch() != null && checkEntrustmentBookVO.getSearch().trim().length() > 0) {
			String search = "%" + checkEntrustmentBookVO.getSearch().trim() + "%";
			hql = hql + " and check_entrustment_book_num like '" + search
					+ "' or check_entrustment_book_case_name like '" + search + "'";
		}
		if (checkEntrustmentBookVO.getState() != null && checkEntrustmentBookVO.getState().trim().length() > 0) {
			hql = hql + " and check_entrustment_book_state='" + checkEntrustmentBookVO.getState().trim() + "'";
		}
		if (checkEntrustmentBookVO.getUnitName() != null && checkEntrustmentBookVO.getUnitName().trim().length() > 0) {
			hql = hql + " and check_entrustment_book_entrustment_unit_name='"
					+ checkEntrustmentBookVO.getUnitName().trim() + "'";
		}
		if (checkEntrustmentBookVO.getType() != null && checkEntrustmentBookVO.getType().trim().length() > 0) {
			hql = hql + " and check_entrustment_book_type='" + checkEntrustmentBookVO.getType().trim() + "'";
		}
		if (checkEntrustmentBookVO.getStart_time() != null
				&& checkEntrustmentBookVO.getStart_time().trim().length() > 0) {
			startTime = checkEntrustmentBookVO.getStart_time();
		}
		if (checkEntrustmentBookVO.getStop_time() != null
				&& checkEntrustmentBookVO.getStop_time().trim().length() > 0) {
			stopTime = checkEntrustmentBookVO.getStop_time();
		}
		hql = hql + " and check_entrustment_book_inspect_time>='" + startTime
				+ "' and check_entrustment_book_inspect_time<='" + stopTime
				+ "' order by check_entrustment_book_inspect_time,check_entrustment_book_num desc";
		Query query = getSession().createQuery(hql);
		query.setFirstResult((checkEntrustmentBookVO.getPageIndex() - 1) * checkEntrustmentBookVO.getPageSize());
		query.setMaxResults(checkEntrustmentBookVO.getPageSize());
		listPage = query.list();
		if (checkEntrustmentBookVO.getSearch() != null && checkEntrustmentBookVO.getSearch().trim().length() > 0) {
			for (xsjsglxt_check_entrustment_book xsjsglxt_check_entrustment_book : listPage) {
				if (xsjsglxt_check_entrustment_book.getCheck_entrustment_book_case_name() != null
						&& xsjsglxt_check_entrustment_book.getCheck_entrustment_book_case_name().trim().length() > 0) {
					xsjsglxt_check_entrustment_book.setCheck_entrustment_book_case_name(
							xsjsglxt_check_entrustment_book.getCheck_entrustment_book_case_name().replaceAll(
									checkEntrustmentBookVO.getSearch().trim(), "<span style='color: #ff5063;'>"
											+ checkEntrustmentBookVO.getSearch().trim() + "</span>"));
				}
				if (xsjsglxt_check_entrustment_book.getCheck_entrustment_book_num() != null
						&& xsjsglxt_check_entrustment_book.getCheck_entrustment_book_num().trim().length() > 0) {
					xsjsglxt_check_entrustment_book.setCheck_entrustment_book_num(
							xsjsglxt_check_entrustment_book.getCheck_entrustment_book_num().replaceAll(
									checkEntrustmentBookVO.getSearch().trim(), "<span style='color: #ff5063;'>"
											+ checkEntrustmentBookVO.getSearch().trim() + "</span>"));
				}
			}
		}
		getSession().clear();
		return listPage;
	}

	@Override
	public int deleteCheckEntrustmentBookById(String checkEntrustmentBookId) {
		int i = 1;
		String hql = "delete from xsjsglxt_check_entrustment_book where xsjsglxt_check_entrustment_book_id='"
				+ checkEntrustmentBookId + "'";
		try {
			Query query = getSession().createQuery(hql);
			query.executeUpdate();
		} catch (HibernateException e) {
			i = 2;
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public int deleteIdentifiederCaseConfirmBookId(String xsjsglxt_identifieder_case_confirm_book_id) {
		int i = 1;
		String hql = "delete from xsjsglxt_identifieder_case_confirm_book where xsjsglxt_identifieder_case_confirm_book_id='"
				+ xsjsglxt_identifieder_case_confirm_book_id + "'";
		try {
			Query query = getSession().createQuery(hql);
			query.executeUpdate();
		} catch (HibernateException e) {
			i = 2;
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public int deleteNotAcceptanceEntrusmentInformById(String xsjsglxt_not_acceptance_entrustment_inform_id) {
		int i = 1;
		String hql = "delete from xsjsglxt_not_acceptance_entrustment_inform where xsjsglxt_not_acceptance_entrustment_inform_id='"
				+ xsjsglxt_not_acceptance_entrustment_inform_id + "'";
		try {
			Query query = getSession().createQuery(hql);
			query.executeUpdate();
		} catch (HibernateException e) {
			i = 2;
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public int deleteDamageInspectionRecordById(String xsjsglxt_damage_inspection_record_id) {
		int i = 1;
		String hql = "delete from xsjsglxt_damage_inspection_record where xsjsglxt_damage_inspection_record_id='"
				+ xsjsglxt_damage_inspection_record_id + "'";
		try {
			Query query = getSession().createQuery(hql);
			query.executeUpdate();
		} catch (HibernateException e) {
			i = 2;
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public int deleteDeathInspectionRecordById(String xsjsglxt_death_inspection_record_id) {
		int i = 1;
		String hql = "delete from xsjsglxt_death_inspection_record where xsjsglxt_death_inspection_record_id='"
				+ xsjsglxt_death_inspection_record_id + "'";
		try {
			Query query = getSession().createQuery(hql);
			query.executeUpdate();
		} catch (HibernateException e) {
			i = 2;
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public int deleteInsoectionRecordById(String xsjsglxt_inspection_record_id) {
		int i = 1;
		String hql = "delete from xsjsglxt_inspection_record where xsjsglxt_inspection_record_id='"
				+ xsjsglxt_inspection_record_id + "'";
		try {
			Query query = getSession().createQuery(hql);
			query.executeUpdate();
		} catch (HibernateException e) {
			i = 2;
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public int deleteAppraisalLetter(String xsjsglxt_appraisal_letter_id) {
		int i = 1;
		String hql = "delete from xsjsglxt_appraisal_letter where xsjsglxt_appraisal_letter_id='"
				+ xsjsglxt_appraisal_letter_id + "'";
		try {
			Query query = getSession().createQuery(hql);
			query.executeUpdate();
		} catch (HibernateException e) {
			i = 2;
			e.printStackTrace();
		}
		return i;
	}

	// 根据id获取委托书
	@Override
	public xsjsglxt_check_entrustment_book getCheckEntrustmentBookById(
			String identifieder_case_confirm_book_belong_entrustment_book) {
		xsjsglxt_check_entrustment_book checkEntrustmentBook = new xsjsglxt_check_entrustment_book();
		Session session = getSession();
		String hql = "from xsjsglxt_check_entrustment_book where xsjsglxt_check_entrustment_book_id='"
				+ identifieder_case_confirm_book_belong_entrustment_book + "'";
		Query query = session.createQuery(hql);
		checkEntrustmentBook = (xsjsglxt_check_entrustment_book) query.uniqueResult();
		session.clear();
		return checkEntrustmentBook;
	}

	// 根据ID获取鉴定事项确认书表
	@Override
	public xsjsglxt_identifieder_case_confirm_book getIdentifiederCaseConfirmBookById(
			String xsjsglxt_check_entrustment_book_id) {
		xsjsglxt_identifieder_case_confirm_book identifiederCaseConfirmBook = new xsjsglxt_identifieder_case_confirm_book();
		Session session = getSession();
		String hql = "from xsjsglxt_identifieder_case_confirm_book where identifieder_case_confirm_book_belong_entrustment_book='"
				+ xsjsglxt_check_entrustment_book_id + "'";
		Query query = session.createQuery(hql);
		identifiederCaseConfirmBook = (xsjsglxt_identifieder_case_confirm_book) query.uniqueResult();
		session.clear();
		return identifiederCaseConfirmBook;
	}

	@Override
	public xsjsglxt_not_acceptance_entrustment_inform getNotAcceptanceEntrustmentInform(
			String xsjsglxt_check_entrustment_book_id) {
		xsjsglxt_not_acceptance_entrustment_inform notAcceptanceEntrustmentInform = new xsjsglxt_not_acceptance_entrustment_inform();
		Session session = getSession();
		String hql = "from xsjsglxt_not_acceptance_entrustment_inform where not_acceptance_entrustment_inform_belong_entrustment_book='"
				+ xsjsglxt_check_entrustment_book_id + "'";
		Query query = session.createQuery(hql);
		notAcceptanceEntrustmentInform = (xsjsglxt_not_acceptance_entrustment_inform) query.uniqueResult();
		session.clear();
		return notAcceptanceEntrustmentInform;
	}

	@Override
	public xsjsglxt_inspection_record getInspectionRecordById(String xsjsglxt_check_entrustment_book_id) {
		xsjsglxt_inspection_record xsjsglxt_inspection_record = new xsjsglxt_inspection_record();
		Session session = getSession();
		String hql = "from xsjsglxt_inspection_record where inspection_belong_entrustment_book='"
				+ xsjsglxt_check_entrustment_book_id + "'";
		Query query = session.createQuery(hql);
		xsjsglxt_inspection_record = (xsjsglxt_inspection_record) query.uniqueResult();
		session.clear();
		return xsjsglxt_inspection_record;
	}

	// 根据委托书ID获取尸体检验记录表
	@Override
	public xsjsglxt_death_inspection_record getDeathInspectionRecordById(String xsjsglxt_check_entrustment_book_id) {
		xsjsglxt_death_inspection_record xsjsglxt_death_inspection_record = new xsjsglxt_death_inspection_record();
		Session session = getSession();
		String hql = "from xsjsglxt_death_inspection_record where death_inspection_record_belong_entrustment_book='"
				+ xsjsglxt_check_entrustment_book_id + "'";
		Query query = session.createQuery(hql);
		xsjsglxt_death_inspection_record = (xsjsglxt_death_inspection_record) query.uniqueResult();
		session.clear();
		return xsjsglxt_death_inspection_record;
	}

	// 根据委托书ID获取损伤检验记录表
	@Override
	public xsjsglxt_damage_inspection_record getDamageInspectionRecordById(String xsjsglxt_check_entrustment_book_id) {
		xsjsglxt_damage_inspection_record xsjsglxt_damage_inspection_record = new xsjsglxt_damage_inspection_record();
		Session session = getSession();
		String hql = "from xsjsglxt_damage_inspection_record where damage_inspection_record_belong_entrustment_book='"
				+ xsjsglxt_check_entrustment_book_id + "'";
		Query query = session.createQuery(hql);
		xsjsglxt_damage_inspection_record = (xsjsglxt_damage_inspection_record) query.uniqueResult();
		session.clear();
		return xsjsglxt_damage_inspection_record;
	}

	@Override
	public xsjsglxt_appraisal_letter getAppraisalLetterById(String xsjsglxt_check_entrustment_book_id) {
		xsjsglxt_appraisal_letter xsjsglxt_appraisal_letter = new xsjsglxt_appraisal_letter();
		Session session = getSession();
		String hql = "from xsjsglxt_appraisal_letter where appraisal_letter_belong_entrustment_book='"
				+ xsjsglxt_check_entrustment_book_id + "'";
		Query query = session.createQuery(hql);
		xsjsglxt_appraisal_letter = (xsjsglxt_appraisal_letter) query.uniqueResult();
		session.clear();
		return xsjsglxt_appraisal_letter;
	}

	@Override
	public xsjsglxt_identifieder_case_confirm_book getIdentifiederCaseConfirmBookByOwnId(String xsjsglxt_identifieder_case_confirm_book_id) {
		xsjsglxt_identifieder_case_confirm_book identifiederCaseConfirmBook = new xsjsglxt_identifieder_case_confirm_book();
		Session session = getSession();
		String hql = "from xsjsglxt_identifieder_case_confirm_book where xsjsglxt_identifieder_case_confirm_book_id='"
				+ xsjsglxt_identifieder_case_confirm_book_id + "'";
		Query query = session.createQuery(hql);
		identifiederCaseConfirmBook = (xsjsglxt_identifieder_case_confirm_book) query.uniqueResult();
		session.clear();
		return identifiederCaseConfirmBook;
	}

	@Override
	public xsjsglxt_not_acceptance_entrustment_inform getNotAcceptanceEntrustmentInformByOwnId(String xsjsglxt_not_acceptance_entrustment_inform_id) {
		xsjsglxt_not_acceptance_entrustment_inform notAcceptanceEntrustmentInform = new xsjsglxt_not_acceptance_entrustment_inform();
		Session session = getSession();
		String hql = "from xsjsglxt_not_acceptance_entrustment_inform where xsjsglxt_not_acceptance_entrustment_inform_id='"
				+ xsjsglxt_not_acceptance_entrustment_inform_id + "'";
		Query query = session.createQuery(hql);
		notAcceptanceEntrustmentInform = (xsjsglxt_not_acceptance_entrustment_inform) query.uniqueResult();
		session.clear();
		return notAcceptanceEntrustmentInform;
	}

	@Override
	public xsjsglxt_inspection_record getInspectionRecordByOwnId(String xsjsglxt_inspection_record_id) {
		xsjsglxt_inspection_record xsjsglxt_inspection_record = new xsjsglxt_inspection_record();
		Session session = getSession();
		String hql = "from xsjsglxt_inspection_record where xsjsglxt_inspection_record_id='"
				+ xsjsglxt_inspection_record_id + "'";
		Query query = session.createQuery(hql);
		xsjsglxt_inspection_record = (xsjsglxt_inspection_record) query.uniqueResult();
		session.clear();
		return xsjsglxt_inspection_record;
	}

	@Override
	public xsjsglxt_death_inspection_record getDeathInspectionRecordOwnId(String xsjsglxt_death_inspection_record_id) {
		xsjsglxt_death_inspection_record xsjsglxt_death_inspection_record = new xsjsglxt_death_inspection_record();
		Session session = getSession();
		String hql = "from xsjsglxt_death_inspection_record where xsjsglxt_inspection_record_id='"
				+ xsjsglxt_death_inspection_record_id + "'";
		Query query = session.createQuery(hql);
		xsjsglxt_death_inspection_record = (xsjsglxt_death_inspection_record) query.uniqueResult();
		session.clear();
		return xsjsglxt_death_inspection_record;
	}

	// 获取损伤记录表
	@Override
	public xsjsglxt_damage_inspection_record getDamageInspectionRecordByOwnId(String xsjsglxt_damage_inspection_record_id) {
		xsjsglxt_damage_inspection_record xsjsglxt_damage_inspection_record = new xsjsglxt_damage_inspection_record();
		Session session = getSession();
		String hql = "from xsjsglxt_damage_inspection_record where xsjsglxt_damage_inspection_record_id='"
				+ xsjsglxt_damage_inspection_record_id + "'";
		Query query = session.createQuery(hql);
		xsjsglxt_damage_inspection_record = (xsjsglxt_damage_inspection_record) query.uniqueResult();
		session.clear();
		return xsjsglxt_damage_inspection_record;
	}

	@Override
	public xsjsglxt_appraisal_letter getAppraisalLetterByOwnId(String xsjsglxt_appraisal_letter_id) {
		xsjsglxt_appraisal_letter xsjsglxt_appraisal_letter = new xsjsglxt_appraisal_letter();
		Session session = getSession();
		String hql = "from xsjsglxt_appraisal_letter where xsjsglxt_appraisal_letter_id='"
				+ xsjsglxt_appraisal_letter_id + "'";
		Query query = session.createQuery(hql);
		xsjsglxt_appraisal_letter = (xsjsglxt_appraisal_letter) query.uniqueResult();
		session.clear();
		return xsjsglxt_appraisal_letter;
	}

	@Override
	public int getMaxCofirmBook(String currentYear) {
		int i = 0;
		String ji = "";
		String hql = "select substring(identifieder_case_confirm_book_acceptance_num,5) from xsjsglxt_identifieder_case_confirm_book where substring(identifieder_case_confirm_book_acceptance_num,1,4)='"
				+ currentYear + "' order by substring(identifieder_case_confirm_book_acceptance_num,5) desc limit 1";
		Query query = getSession().createSQLQuery(hql);
		ji = (String) query.uniqueResult();
		if (ji == null || ji.trim().length() <= 0) {
			getSession().clear();
			return 0;
		}
		i = Integer.parseInt(ji);
		getSession().clear();
		return i;
	}

}
