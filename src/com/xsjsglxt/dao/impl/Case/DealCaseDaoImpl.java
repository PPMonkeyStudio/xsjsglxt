package com.xsjsglxt.dao.impl.Case;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xsjsglxt.dao.Case.DealCaseDao;
import com.xsjsglxt.domain.DO.xsjsglxt_handle_case;
import com.xsjsglxt.domain.DO.xsjsglxt_suspect_infor;
import com.xsjsglxt.domain.DO.xsjsglxt_suspect_state;
import com.xsjsglxt.domain.DO.xsjsglxt_take_goods;
import com.xsjsglxt.domain.DTO.Case.MessageDTO;
import com.xsjsglxt.domain.DTO.Case.SuspectInforDTO;
import com.xsjsglxt.domain.VO.Case.HandleCaseListVO;
import com.xsjsglxt.domain.VO.Case.SuspectListVO;

public class DealCaseDaoImpl implements DealCaseDao {
	private SessionFactory sessionFactory;

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public boolean saveHandleCase(xsjsglxt_handle_case handleCase) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		try {
			session.save(handleCase);
			return true;
		} catch (HibernateException e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public xsjsglxt_handle_case getHandleCaseById(String handle_case_id) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		xsjsglxt_handle_case handleCase = (xsjsglxt_handle_case) session.get(xsjsglxt_handle_case.class,
				handle_case_id);
		session.clear();
		return handleCase;
	}

	@Override
	public boolean updateHandleCase(xsjsglxt_handle_case handleCase) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		try {
			session.saveOrUpdate(handleCase);
			return true;
		} catch (HibernateException e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public List<xsjsglxt_suspect_infor> getSuspectByCaseId(String handleCase_id) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		String hql = "from xsjsglxt_suspect_infor where suspect_case = '" + handleCase_id + "'";
		Query query = session.createQuery(hql);
		return query.list();
	}

	@Override
	public List<xsjsglxt_take_goods> getGoodsBySuspectId(String suspect_id) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		String hql = "from xsjsglxt_take_goods where goods_suspect = '" + suspect_id + "'";
		Query query = session.createQuery(hql);
		return query.list();
	}

	@Override
	public boolean deleteGoods(xsjsglxt_take_goods xsjsglxt_take_goods) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		try {
			session.delete(xsjsglxt_take_goods);
			return true;
		} catch (HibernateException e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public boolean deleteSuspect(xsjsglxt_suspect_infor xsjsglxt_suspect_infor) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		try {
			session.delete(xsjsglxt_suspect_infor);
			return true;
		} catch (HibernateException e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public boolean deleteHandleCase(xsjsglxt_handle_case x) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		try {
			session.delete(x);
			return true;
		} catch (HibernateException e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public xsjsglxt_handle_case gainHandleCaseById(String handleCase_id) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		return null;
	}

	@Override
	public int getCountByCondition(HandleCaseListVO handleCaseListVO) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		String hql = "select count(*) from xsjsglxt_handle_case where 1=1";
		if (handleCaseListVO.getSearchAssistantPolice() != null
				&& !"".equals(handleCaseListVO.getSearchAssistantPolice())) {
			hql = hql + " and handle_assistant_police like '%" + handleCaseListVO.getSearchAssistantPolice() + "%'";
		}
		if (handleCaseListVO.getSearchCaseName() != null && !"".equals(handleCaseListVO.getSearchCaseName())) {
			hql = hql + " and handle_case_name like '%" + handleCaseListVO.getSearchCaseName() + "%'";
		}
		if (handleCaseListVO.getSearchMainPolice() != null && !"".equals(handleCaseListVO.getSearchMainPolice())) {
			hql = hql + " and handle_main_police like '%" + handleCaseListVO.getSearchMainPolice() + "%'";
		}
		if (handleCaseListVO.getSearchMiddleCaptaion() != null
				&& !"".equals(handleCaseListVO.getSearchMiddleCaptaion())) {
			hql = hql + " and handle_middle_captain like '%" + handleCaseListVO.getSearchMiddleCaptaion() + "%'";
		}
		if (handleCaseListVO.getSearchCaseState() != null && !"".equals(handleCaseListVO.getSearchCaseState().trim())) {
			hql = hql + " and handle_case_state like '%" + handleCaseListVO.getSearchCaseState() + "%'";
		}
		hql = hql + " order by handle_gmt_modified desc";
		long count = (long) session.createQuery(hql).uniqueResult();
		return (int) count;
	}

	@Override
	public List<xsjsglxt_handle_case> getCaseByPage(HandleCaseListVO handleCaseListVO) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		String hql = "from xsjsglxt_handle_case where 1=1";
		if (handleCaseListVO.getSearchAssistantPolice() != null
				&& !"".equals(handleCaseListVO.getSearchAssistantPolice())) {
			hql = hql + " and handle_assistant_police like '%" + handleCaseListVO.getSearchAssistantPolice() + "%'";
		}
		if (handleCaseListVO.getSearchCaseName() != null && !"".equals(handleCaseListVO.getSearchCaseName())) {
			hql = hql + " and handle_case_name like '%" + handleCaseListVO.getSearchCaseName() + "%'";
		}
		if (handleCaseListVO.getSearchMainPolice() != null && !"".equals(handleCaseListVO.getSearchMainPolice())) {
			hql = hql + " and handle_main_police like '%" + handleCaseListVO.getSearchMainPolice() + "%'";
		}
		if (handleCaseListVO.getSearchMiddleCaptaion() != null
				&& !"".equals(handleCaseListVO.getSearchMiddleCaptaion())) {
			hql = hql + " and handle_middle_captain like '%" + handleCaseListVO.getSearchMiddleCaptaion() + "%'";
		}
		if (handleCaseListVO.getSearchCaseState() != null && !"".equals(handleCaseListVO.getSearchCaseState().trim())) {
			hql = hql + " and handle_case_state like '%" + handleCaseListVO.getSearchCaseState() + "%'";
		}
		hql = hql + " order by handle_gmt_modified desc";
		Query query = session.createQuery(hql)
				.setFirstResult((handleCaseListVO.getCurrPage() - 1) * handleCaseListVO.getPageSize())
				.setMaxResults(handleCaseListVO.getPageSize());
		List<xsjsglxt_handle_case> handleList = query.list();
		return handleList;
	}

	@Override
	public boolean saveSuspect(xsjsglxt_suspect_infor suspectInfor) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		try {
			session.save(suspectInfor);
			return true;
		} catch (HibernateException e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public xsjsglxt_suspect_infor getSuspectById(String suspect_id) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		xsjsglxt_suspect_infor suspect = (xsjsglxt_suspect_infor) session.get(xsjsglxt_suspect_infor.class, suspect_id);
		session.clear();
		return suspect;
	}

	@Override
	public boolean updateSuspect(xsjsglxt_suspect_infor suspectInfor) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		try {
			session.saveOrUpdate(suspectInfor);
			return true;
		} catch (HibernateException e) {
			// TODO: handle exception
			return false;
		}

	}

	@Override
	public boolean saveTakeGoods(xsjsglxt_take_goods takeGoods) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		try {
			session.save(takeGoods);
			return true;
		} catch (HibernateException e) {
			// TODO: handle exception
			return false;
		}

	}

	@Override
	public xsjsglxt_take_goods getGoodsById(String string) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		xsjsglxt_take_goods goods = (xsjsglxt_take_goods) session.get(xsjsglxt_take_goods.class, string);
		session.clear();
		return goods;
	}

	@Override
	public boolean updateTakeGoods(xsjsglxt_take_goods takeGoods) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		try {
			session.saveOrUpdate(takeGoods);
			return true;
		} catch (HibernateException e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public int getSuspectCount(SuspectListVO suspectVO) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		String hql = "select count(*) from xsjsglxt_suspect_infor as infor,xsjsglxt_handle_case as handle where handle.handle_case_id = infor.suspect_case";
		if (suspectVO.getSearchCaseName() != null && !"".equals(suspectVO.getSearchCaseName().trim())) {
			hql = hql + " and handle.handle_case_name like '%" + suspectVO.getSearchCaseName() + "%'";
		}
		if (suspectVO.getSearchName() != null && !"".equals(suspectVO.getSearchName().trim())) {
			hql = hql + " and infor.suspect_name like '%" + suspectVO.getSearchName() + "%'";
		}
		if (suspectVO.getSearchType() != null && !"".equals(suspectVO.getSearchType().trim())) {
			hql = hql + " and infor.suspect_process_type = '" + suspectVO.getSearchType() + "'";
		}
		long count = (long) session.createQuery(hql).uniqueResult();
		return (int) count;
	}

	@Override
	public void getSUspectList(SuspectListVO suspectVO) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		String hql = "select new com.xsjsglxt.domain.DTO.Case.SuspectInforDTO(infor.suspect_id,handle.handle_case_name"
				+ ",infor.suspect_name,infor.suspect_sex" + ",infor.suspect_process_type,infor.suspect_start_time"
				+ ",infor.suspect_end_time) from xsjsglxt_suspect_infor as infor,xsjsglxt_handle_case as handle"
				+ " where handle.handle_case_id = infor.suspect_case";
		if (suspectVO.getSearchCaseName() != null && !"".equals(suspectVO.getSearchCaseName().trim())) {
			hql = hql + " and handle.handle_case_name like '%" + suspectVO.getSearchCaseName() + "%'";
		}
		if (suspectVO.getSearchName() != null && !"".equals(suspectVO.getSearchName().trim())) {
			hql = hql + " and infor.suspect_name like '%" + suspectVO.getSearchName() + "%'";
		}
		if (suspectVO.getSearchType() != null && !"".equals(suspectVO.getSearchType().trim())) {
			hql = hql + " and infor.suspect_process_type = '" + suspectVO.getSearchType() + "'";
		}
		List<SuspectInforDTO> list = (List<SuspectInforDTO>) session.createQuery(hql)
				.setFirstResult((suspectVO.getCurrPage() - 1) * suspectVO.getPageSize())
				.setMaxResults(suspectVO.getPageSize()).list();
		suspectVO.setSuspectDTO(list);
	}

	@Override
	public void saveState(xsjsglxt_suspect_state state) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		session.save(state);
	}

	@Override
	public List<xsjsglxt_suspect_state> getSuspectStates(String suspect_id) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		String hql = "from xsjsglxt_suspect_state where state_suspect = '" + suspect_id + "'";
		List<xsjsglxt_suspect_state> list = session.createQuery(hql).list();
		return list;
	}

	// 获得拘留三天的通知
	@Override
	public List<MessageDTO> getDetentionMessageThree() {
		// TODO Auto-generated method stub
		Calendar nowTime = Calendar.getInstance();
		nowTime.setTime(new Date());
		nowTime.add(Calendar.DAY_OF_MONTH, 2 - 1);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String currTime = sdf.format(nowTime.getTime());
		nowTime.clear();
		String hql = "select new com.xsjsglxt.domain.DTO.Case.MessageDTO(infor.suspect_process_type,infor.suspect_name,handle.handle_main_police) from xsjsglxt_suspect_infor as infor , xsjsglxt_handle_case as handle "
				+ "where handle.handle_case_id = infor.suspect_case and infor.suspect_end_time <= '" + currTime
				+ "' and infor.suspect_process_type = '0' and infor.suspect_process_long = '3'";
		Session session = this.getSession();
		List<MessageDTO> list = session.createQuery(hql).list();
		return list;
	}

	@Override
	public List<MessageDTO> getDetentionMessageSeven() {
		// TODO Auto-generated method stub
		Calendar nowTime = Calendar.getInstance();
		nowTime.setTime(new Date());
		nowTime.add(Calendar.DAY_OF_MONTH, 5 - 1);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String currTime = sdf.format(nowTime.getTime());
		nowTime.clear();
		String hql = "select new com.xsjsglxt.domain.DTO.Case.MessageDTO(infor.suspect_process_type,infor.suspect_name,handle.handle_main_police) from xsjsglxt_suspect_infor as infor , xsjsglxt_handle_case as handle "
				+ "where handle.handle_case_id = infor.suspect_case and infor.suspect_end_time <= '" + currTime
				+ "' and infor.suspect_process_type = '0' and infor.suspect_process_long = '7'";
		Session session = this.getSession();
		List<MessageDTO> list = session.createQuery(hql).list();
		return list;
	}

	@Override
	public List<MessageDTO> getDetentionMessageMonth() {
		// TODO Auto-generated method stub
		Calendar nowTime = Calendar.getInstance();
		nowTime.setTime(new Date());
		nowTime.add(Calendar.DAY_OF_MONTH, 20 - 1);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String currTime = sdf.format(nowTime.getTime());
		nowTime.clear();
		String hql = "select new com.xsjsglxt.domain.DTO.Case.MessageDTO(infor.suspect_process_type,infor.suspect_name,handle.handle_main_police) from xsjsglxt_suspect_infor as infor , xsjsglxt_handle_case as handle "
				+ "where handle.handle_case_id = infor.suspect_case and infor.suspect_end_time <= '" + currTime
				+ "' and infor.suspect_process_type = '0' and infor.suspect_process_long = '30'";
		Session session = this.getSession();
		List<MessageDTO> list = session.createQuery(hql).list();
		return list;
	}

	@Override
	public List<MessageDTO> getArrestMessage() {
		// TODO Auto-generated method stub
		Calendar nowTime = Calendar.getInstance();
		nowTime.setTime(new Date());
		nowTime.add(Calendar.DAY_OF_MONTH, 15 - 1);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String currTime = sdf.format(nowTime.getTime());
		nowTime.clear();
		String hql = "select new com.xsjsglxt.domain.DTO.Case.MessageDTO(infor.suspect_process_type,infor.suspect_name,handle.handle_main_police) from xsjsglxt_suspect_infor as infor , xsjsglxt_handle_case as handle "
				+ "where handle.handle_case_id = infor.suspect_case and infor.suspect_end_time <= '" + currTime
				+ "' and infor.suspect_process_type = '1'";
		Session session = this.getSession();
		List<MessageDTO> list = session.createQuery(hql).list();
		return list;
	}

	@Override
	public List<MessageDTO> getCheckBackMessage() {
		// TODO Auto-generated method stub
		Calendar nowTime = Calendar.getInstance();
		nowTime.setTime(new Date());
		nowTime.add(Calendar.DAY_OF_MONTH, 15 - 1);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String currTime = sdf.format(nowTime.getTime());
		nowTime.clear();
		String hql = "select new com.xsjsglxt.domain.DTO.Case.MessageDTO(infor.suspect_process_type,infor.suspect_name,handle.handle_main_police) from xsjsglxt_suspect_infor as infor , xsjsglxt_handle_case as handle "
				+ "where handle.handle_case_id = infor.suspect_case and infor.suspect_end_time <= '" + currTime
				+ "' and infor.suspect_process_type = '3'";
		Session session = this.getSession();
		List<MessageDTO> list = session.createQuery(hql).list();
		return list;
	}

	@Override
	public List<MessageDTO> getMonitorMessage() {
		// TODO Auto-generated method stub
		Calendar nowTime = Calendar.getInstance();
		nowTime.setTime(new Date());
		nowTime.add(Calendar.DAY_OF_MONTH, 10 - 1);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String currTime = sdf.format(nowTime.getTime());
		nowTime.clear();
		String hql = "select new com.xsjsglxt.domain.DTO.Case.MessageDTO(infor.suspect_process_type,infor.suspect_name,handle.handle_main_police) from xsjsglxt_suspect_infor as infor , xsjsglxt_handle_case as handle "
				+ "where handle.handle_case_id = infor.suspect_case and infor.suspect_end_time <= '" + currTime
				+ "' and infor.suspect_process_type = '4'";
		Session session = this.getSession();
		List<MessageDTO> list = session.createQuery(hql).list();
		return list;
	}

	@Override
	public boolean deleteState(xsjsglxt_suspect_infor xsjsglxt_suspect_infor) {
		// TODO Auto-generated method stub
		String hql = "delete from xsjsglxt_suspect_state where state_suspect = '"
				+ xsjsglxt_suspect_infor.getSuspect_id() + "'";
		Session session = this.getSession();
		session.createQuery(hql).executeUpdate();
		return true;
	}

}
