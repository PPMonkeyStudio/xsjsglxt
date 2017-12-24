
package com.xsjsglxt.dao.impl.Team;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xsjsglxt.dao.Team.StaffDao;
import com.xsjsglxt.domain.DO.xsjsglxt_breakecase;
import com.xsjsglxt.domain.DO.xsjsglxt_case;
import com.xsjsglxt.domain.DO.xsjsglxt_snece;
import com.xsjsglxt.domain.DO.xsjsglxt_staff;
import com.xsjsglxt.domain.VO.Team.page_list_staffInformationVO;

public class StaffDaoImpl implements StaffDao {
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
	public boolean saveStaff(xsjsglxt_staff staff) {
		// TODO Auto-generated method stub
		try {
			getSession().saveOrUpdate(staff);


			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public int getCountStaffInformationByPage(page_list_staffInformationVO page_list_staffInformation) {
		// TODO Auto-generated method stub
		Session session = getSession();
		Long i;
		//String hql = "select count(*) from xsjsglxt_case,xsjsglxt_snece where xsjsglxt_case_id=snece_case";
		String hql = "select count(*) from xsjsglxt_staff where 1=1 ";
		String startTime = "0000-00-00";
		String stopTime = "9999-99-99";
		  // 1
		if (page_list_staffInformation.getStaff_name()!= null
				&& page_list_staffInformation.getStaff_name().trim().length() > 0) {
			String staff_name = "%" + page_list_staffInformation.getStaff_name() + "%";
			hql = hql + " and staff_name like '" + staff_name + "'";
				
		}
		// 2
		if (page_list_staffInformation.getStaff_sex()!= null
				&& page_list_staffInformation.getStaff_sex().trim().length() > 0) {
			String staff_sex = "%" + page_list_staffInformation.getStaff_sex() + "%";
			hql = hql + " and staff_sex like '" + staff_sex + "'";
		}
		// 3
		if (page_list_staffInformation.getStaff_politicalStatus() != null
				&& page_list_staffInformation.getStaff_politicalStatus().trim().length() > 0) {
			String staff_politicalStatus = "%" + page_list_staffInformation.getStaff_politicalStatus()+ "%";
			hql = hql + " and staff_politicalStatus like '" + staff_politicalStatus + "'";
		}
		
	
		if (page_list_staffInformation.getStart_time() != null && page_list_staffInformation.getStart_time().trim().length() > 0) {
			startTime = page_list_staffInformation.getStart_time();
		}
		if (page_list_staffInformation.getStop_time() != null && page_list_staffInformation.getStop_time().trim().length() > 0) {
			stopTime = page_list_staffInformation.getStop_time();
		}
		hql = hql + " and staff_thePoliceTime>='" + startTime + "' and staff_thePoliceTime<='"
				+ stopTime + "' order by staff_thePoliceTime";
		System.out.println(hql);
		Query query = session.createQuery(hql);	
		i = (Long) query.uniqueResult();
		session.clear();
		return i.intValue();
	}

	@Override
	public List<xsjsglxt_staff> getListStaffInformatioByPage(page_list_staffInformationVO page_list_staffInformation) {
		// TODO Auto-generated method stub
		Session session = getSession();
		List<xsjsglxt_staff> listStaffInformationByPage = new ArrayList<xsjsglxt_staff>();
		String hql = "from xsjsglxt_staff  where 1=1 ";
		String startTime = "0000-00-00";
		String stopTime = "9999-99-99";
		  // 1
				if (page_list_staffInformation.getStaff_name()!= null
						&& page_list_staffInformation.getStaff_name().trim().length() > 0) {
					String staff_name = "%" + page_list_staffInformation.getStaff_name() + "%";
					hql = hql + " and staff_name like '" + staff_name + "'";
						
				}
				// 2
				if (page_list_staffInformation.getStaff_sex()!= null
						&& page_list_staffInformation.getStaff_sex().trim().length() > 0) {
					String staff_sex = "%" + page_list_staffInformation.getStaff_sex() + "%";
					hql = hql + " and staff_sex like '" + staff_sex + "'";
				}
				// 3
				if (page_list_staffInformation.getStaff_politicalStatus() != null
						&& page_list_staffInformation.getStaff_politicalStatus().trim().length() > 0) {
					String staff_politicalStatus = "%" + page_list_staffInformation.getStaff_politicalStatus()+ "%";
					hql = hql + " and staff_politicalStatus like '" + staff_politicalStatus + "'";
				}
				
			
				if (page_list_staffInformation.getStart_time() != null && page_list_staffInformation.getStart_time().trim().length() > 0) {
					startTime = page_list_staffInformation.getStart_time();
				}
				if (page_list_staffInformation.getStop_time() != null && page_list_staffInformation.getStop_time().trim().length() > 0) {
					stopTime = page_list_staffInformation.getStop_time();
				}
				hql = hql + " and staff_thePoliceTime>='" + startTime + "' and staff_thePoliceTime<='"
						+ stopTime + "' order by staff_thePoliceTime";
		Query query = session.createQuery(hql);	
		query.setFirstResult(
				(page_list_staffInformation.getPageIndex() - 1) * page_list_staffInformation.getPageSize());
		query.setMaxResults(page_list_staffInformation.getPageSize());
		listStaffInformationByPage = query.list();
		System.out.println(hql);
	
		session.clear();
		return listStaffInformationByPage;
	}

	@Override
	public xsjsglxt_staff StaffInformationOne(xsjsglxt_staff staff) {
		// TODO Auto-generated method stub
		Session session = getSession();

		String hql = "from xsjsglxt_staff staff where staff.xsjsglxt_staff_id='" + staff.getXsjsglxt_staff_id()  + "'";

		Query query = session.createQuery(hql);

			staff = (xsjsglxt_staff) query.uniqueResult();

		return staff;
	}

	@Override
	public void updateStaffInformation(xsjsglxt_staff staff) {
		// TODO Auto-generated method stub
		try {
			getSession().saveOrUpdate(staff);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public xsjsglxt_staff getStaffByNum(String staff_id) {
		// TODO Auto-generated method stub
		Session session = getSession();
		xsjsglxt_staff StaffInformation = null;
		String hql = "from xsjsglxt_staff staff where staff.xsjsglxt_staff_id='" + staff_id + "'";
		Query query = session.createQuery(hql);
		StaffInformation = (xsjsglxt_staff) query.uniqueResult();
       return StaffInformation;
	}

	@Override
	public boolean deleteStaffById(String xsjsglxt_staff_id) {
		// TODO Auto-generated method stub
		Session session = getSession();
		String hql = "delete from xsjsglxt_staff where xsjsglxt_staff_id='" + xsjsglxt_staff_id + "'";
		Query query = session.createQuery(hql);
		query.executeUpdate();
       return true;
	}

	
}

