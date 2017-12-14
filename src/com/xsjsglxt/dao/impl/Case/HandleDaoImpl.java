package com.xsjsglxt.dao.impl.Case;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xsjsglxt.dao.Case.HandleDao;
import com.xsjsglxt.domain.DO.xsjsglxt_handle;
import com.xsjsglxt.domain.VO.Case.page_list_HandleInformationVO;

public class HandleDaoImpl implements HandleDao {
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
	public void saveHandle(xsjsglxt_handle handle) {
		// TODO Auto-generated method stub
		try {
			getSession().saveOrUpdate(handle);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public int getCountHandleInformationByPage(page_list_HandleInformationVO page_list_HandleInformation) {
		// TODO Auto-generated method stub
		Session session = getSession();
		Long i;
		String hql = "select count(*) from xsjsglxt_handle  where 1=1 ";
		//拘留起始时间
		String handle_StartTimeaOfDetention_start_time = "0000-00-00";
		String handle_StartTimeaOfDetention_stop_time = "9999-99-99";
		//逮捕时间
		String handle_arrestTime_start_time= "0000-00-00";
		String handle_arrestTime_stop_time = "9999-99-99";
		//起诉时间
		String handle_prosecuteTime_start_time= "0000-00-00";
	    String handle_prosecuteTime_stop_time = "9999-99-99";
	    //退查时间
	    String handle_checkbackTime_start_time= "0000-00-00";
	    String handle_checkbackTime_stop_time = "9999-99-99";
	    //取保候审时间
	    String handle_pbatTime_start_time= "0000-00-00";
	    String handle_pbatTime_stop_time = "9999-99-99";
	    //监视居住时间
	    String handle_lhusTime_start_time= "0000-00-00";
        String handle_lhusTime_stop_time = "9999-99-99";
		  // 1
		if (page_list_HandleInformation.getHandle_administrativeCase() != null
				&& page_list_HandleInformation.getHandle_administrativeCase().trim().length() > 0) {
			String handle_administrativeCase = "%" + page_list_HandleInformation.getHandle_administrativeCase() + "%";
			hql = hql + " and handle_administrativeCase like '" + handle_administrativeCase + "'";
				
		}
		// 2
		if (page_list_HandleInformation.getHandle_detentionDay() != null
				&& page_list_HandleInformation.getHandle_detentionDay().trim().length() > 0) {
			String handle_detentionDay = "%" + page_list_HandleInformation.getHandle_detentionDay() + "%";
			hql = hql + " and handle_detentionDay like '" + handle_detentionDay + "'";
		}
		// 3
		if (page_list_HandleInformation.getHandle_squadronleader() != null
				&& page_list_HandleInformation.getHandle_squadronleader().trim().length() > 0) {
			String handle_squadronleader = "%" + page_list_HandleInformation.getHandle_squadronleader() + "%";
			hql = hql + " and handle_squadronleader like '" + handle_squadronleader + "'";
		}
		// 4
		if (page_list_HandleInformation.getHandle_PoliceInHandlingCases() != null
				&& page_list_HandleInformation.getHandle_PoliceInHandlingCases().trim().length() > 0) {
			String handle_PoliceInHandlingCases = "%" + page_list_HandleInformation.getHandle_PoliceInHandlingCases() + "%";
			hql = hql + " and handle_PoliceInHandlingCases like '" + handle_PoliceInHandlingCases + "'";
		}
		//拘留起始时间
		if (page_list_HandleInformation.getHandle_StartTimeaOfDetention_start_time() != null && page_list_HandleInformation.getHandle_StartTimeaOfDetention_start_time().trim().length() > 0) {
			handle_StartTimeaOfDetention_start_time = page_list_HandleInformation.getHandle_StartTimeaOfDetention_start_time();
		}
		if (page_list_HandleInformation.getHandle_StartTimeaOfDetention_stop_time() != null && page_list_HandleInformation.getHandle_StartTimeaOfDetention_stop_time().trim().length() > 0) {
			handle_StartTimeaOfDetention_stop_time = page_list_HandleInformation.getHandle_StartTimeaOfDetention_stop_time();
		}
		hql = hql + " and handle_StartTimeaOfDetention>='" + handle_StartTimeaOfDetention_start_time + "' and handle_StartTimeaOfDetention<='"
				+ handle_StartTimeaOfDetention_stop_time + "' ";
		//逮捕时间
		if (page_list_HandleInformation.getHandle_arrestTime_start_time() != null && page_list_HandleInformation.getHandle_arrestTime_start_time().trim().length() > 0) {
			handle_arrestTime_start_time = page_list_HandleInformation.getHandle_arrestTime_start_time();
		}
		if (page_list_HandleInformation.getHandle_arrestTime_stop_time() != null && page_list_HandleInformation.getHandle_arrestTime_stop_time().trim().length() > 0) {
			handle_arrestTime_stop_time = page_list_HandleInformation.getHandle_arrestTime_stop_time();
		}
		hql = hql + " and handle_arrestTime>='" + handle_arrestTime_start_time + "' and handle_arrestTime<='"
				+ handle_arrestTime_stop_time + "' ";
		//起诉时间
		if (page_list_HandleInformation.getHandle_prosecuteTime_start_time() != null && page_list_HandleInformation.getHandle_prosecuteTime_start_time().trim().length() > 0) {
			handle_prosecuteTime_start_time = page_list_HandleInformation.getHandle_prosecuteTime_start_time();
		}
		if (page_list_HandleInformation.getHandle_prosecuteTime_stop_time() != null && page_list_HandleInformation.getHandle_prosecuteTime_stop_time().trim().length() > 0) {
			handle_prosecuteTime_stop_time = page_list_HandleInformation.getHandle_prosecuteTime_stop_time();
		}
		hql = hql + " and handle_prosecuteTime>='" + handle_prosecuteTime_start_time + "' and handle_prosecuteTime<='"
				+ handle_prosecuteTime_stop_time + "' ";
		//退查时间
		if (page_list_HandleInformation.getHandle_checkbackTime_start_time() != null && page_list_HandleInformation.getHandle_checkbackTime_start_time().trim().length() > 0) {
			handle_checkbackTime_start_time = page_list_HandleInformation.getHandle_checkbackTime_start_time();
		}
		if (page_list_HandleInformation.getHandle_checkbackTime_stop_time() != null && page_list_HandleInformation.getHandle_checkbackTime_stop_time().trim().length() > 0) {
			handle_checkbackTime_stop_time = page_list_HandleInformation.getHandle_checkbackTime_stop_time();
		}
		hql = hql + " and handle_checkbackTime>='" + handle_checkbackTime_start_time + "' and handle_checkbackTime<='"
				+ handle_checkbackTime_stop_time + "' ";
		//取保候审时间
		if (page_list_HandleInformation.getHandle_pbatTime_start_time() != null && page_list_HandleInformation.getHandle_pbatTime_start_time().trim().length() > 0) {
			handle_pbatTime_start_time = page_list_HandleInformation.getHandle_pbatTime_start_time();
		}
		if (page_list_HandleInformation.getHandle_pbatTime_stop_time() != null && page_list_HandleInformation.getHandle_pbatTime_stop_time().trim().length() > 0) {
			handle_pbatTime_stop_time = page_list_HandleInformation.getHandle_pbatTime_stop_time();
		}
		hql = hql + " and handle_pbatTime>='" + handle_pbatTime_start_time + "' and handle_pbatTime<='"
				+ handle_pbatTime_stop_time + "' ";
		//监视居住时间
		if (page_list_HandleInformation.getHandle_lhusTime_start_time() != null && page_list_HandleInformation.getHandle_lhusTime_start_time().trim().length() > 0) {
			handle_lhusTime_start_time = page_list_HandleInformation.getHandle_lhusTime_start_time();
		}
		if (page_list_HandleInformation.getHandle_lhusTime_stop_time() != null && page_list_HandleInformation.getHandle_lhusTime_stop_time().trim().length() > 0) {
			handle_lhusTime_stop_time = page_list_HandleInformation.getHandle_lhusTime_stop_time();
		}
		hql = hql + " and handle_lhusTime>='" + handle_lhusTime_start_time + "' and handle_lhusTime<='"
				+ handle_lhusTime_stop_time + "' ";
		System.out.println(hql);
		Query query = session.createQuery(hql);	
		i = (Long) query.uniqueResult();
		session.clear();
		return i.intValue();
	}

	@Override
	public List<xsjsglxt_handle> getListHandleInformatioByPage(
			page_list_HandleInformationVO page_list_HandleInformation) {
		// TODO Auto-generated method stub
		return null;
	}
}
