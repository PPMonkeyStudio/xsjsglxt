
package com.xsjsglxt.dao.impl.Team;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xsjsglxt.dao.Team.StaffDao;
import com.xsjsglxt.domain.DO.xsjsglxt_staff;
import com.xsjsglxt.domain.DTO.Team.policemanListDTO;
import com.xsjsglxt.domain.VO.Team.policemanListVO;

public class StaffDaoImpl implements StaffDao {
	private SessionFactory sessionFactory;
	private final static String DELETE = "deleteSuccess";
	private final static String UPDATE = "updateSuccess";

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
	public String savePoliceman(xsjsglxt_staff policeman) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		session.save(policeman);
		return "saveSuccess";
	}

	@Override
	public String deletePoliceman(xsjsglxt_staff policeman) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		session.delete(policeman);
		return DELETE;
	}

	@Override
	public xsjsglxt_staff getPolicemanByStaffId(String xsjsglxt_staff_id) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		return (xsjsglxt_staff) session.get(xsjsglxt_staff.class, xsjsglxt_staff_id);
	}

	@Override
	public String updatePoliceman(xsjsglxt_staff policeman) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		session.saveOrUpdate(policeman);
		return UPDATE;
	}
	// new
	//

	@Override
	public int getPolicemanCount(policemanListVO policemanVO) {
		// TODO Auto-generated method stub
		String hql = "select count(*) from xsjsglxt_staff where 1=1";
		if (policemanVO.getPolicemanName() != null && policemanVO.getPolicemanName().trim().length() > 0) {
			String name = "%" + policemanVO.getPolicemanName() + "%";
			hql = hql + " and xsjsglxt_name like '" + name + "'";
		}
		if (policemanVO.getPolicemanSex() != null && policemanVO.getPolicemanSex().trim().length() > 0) {
			hql = hql + " and xsjsglxt_sex='" + policemanVO.getPolicemanSex() + "'";
		}
		if (policemanVO.getPoliticalStatus() != null && policemanVO.getPoliticalStatus().trim().length() > 0) {
			hql = hql + " and staff_politicalStatus='" + policemanVO.getPoliticalStatus() + "'";
		}
		hql = hql + "order by staff_thePoliceTime " + policemanVO.getInPoliceTimeSort();
		Session session = this.getSession();
		long count;
		count = (long) session.createQuery(hql).uniqueResult();
		return (int) count;
	}

	@Override
	public List<policemanListDTO> getPolicemansByPage(policemanListVO policemanVO) {
		// TODO Auto-generated method stub
		String hql = "select new com.xsjsglxt.domain.DTO.Team.policemanListDTO(x.xsjsglxt_staff_id as xsjsglxt_staff_id,x.xsjsglxt_name as xsjsglxt_name,"
				+ "x.xsjsglxt_sex as xsjsglxt_sex,x.xsjsglxt_age as xsjsglxt_age,x.staff_politicalStatus as staff_politicalStatus,x.staff_thePoliceTime as staff_thePoliceTime,x.staff_phone as staff_phone) from xsjsglxt_staff x where 1=1 ";
		if (policemanVO.getPolicemanName() != null && policemanVO.getPolicemanName().trim().length() > 0) {
			String name = "%" + policemanVO.getPolicemanName() + "%";
			hql = hql + " and xsjsglxt_name like '" + name + "'";
		}
		if (policemanVO.getPolicemanSex() != null && policemanVO.getPolicemanSex().trim().length() > 0) {
			hql = hql + " and xsjsglxt_sex='" + policemanVO.getPolicemanSex() + "'";
		}
		if (policemanVO.getPoliticalStatus() != null && policemanVO.getPoliticalStatus().trim().length() > 0) {
			hql = hql + " and staff_politicalStatus='" + policemanVO.getPoliticalStatus() + "'";
		}
		hql = hql + "order by staff_thePoliceTime " + policemanVO.getInPoliceTimeSort();
		Session session = this.getSession();
		List<policemanListDTO> policemans = session.createQuery(hql)
				.setFirstResult((policemanVO.getCurrPage() - 1) * policemanVO.getPageCount())
				.setMaxResults(policemanVO.getPageCount()).list();
		session.clear();
		for (policemanListDTO policemanListDTO : policemans) {
			if (policemanListDTO.getXsjsglxt_name() != null
					&& policemanListDTO.getXsjsglxt_name().trim().length() > 0) {
				policemanListDTO
						.setXsjsglxt_name(policemanListDTO.getXsjsglxt_name().replaceAll(policemanVO.getPolicemanName(),
								"<span style='color:red;'>" + policemanVO.getPolicemanName() + "</span>"));
			}
		}
		return policemans;
	}

	public void getConnect() {
		String hql = "select * from xsjsglxt_staff as s left join xsjsglxt_staffFamily as f on s.xsjsglxt_staff_id=f.staffFamily_staff";
		Session session = this.getSession();
		Query query = session.createSQLQuery(hql);
		List<Object[]> list = query.list();
		Object[] object = list.get(0);
		System.out.println(object[0]);
		// xsjsglxt_staff policeman = (xsjsglxt_staff) object[0];
		// System.out.println(policeman.getXsjsglxt_staff_id());
	}

	@Override
	public List<xsjsglxt_staff> getAllPoliceman() {
		// TODO Auto-generated method stub
		String hql = "from xsjsglxt_staff";
		Session session = this.getSession();
		Query query = session.createQuery(hql);
		List<xsjsglxt_staff> result = query.list();
		return result;
	}

	@Override
	public List<xsjsglxt_staff> getSchedulingStaff(String pointer) {
		// TODO Auto-generated method stub
		String hql = null;
		switch (pointer) {
		case "leader":
			hql = "from xsjsglxt_staff where staff_duty = '大队长' or staff_duty ='教导员' or staff_duty ='副大队长' or staff_duty ='副教导员' or staff_duty ='中队长' or staff_duty ='副中队长'";
			break;
		case "main":
			hql = "from xsjsglxt_staff where staff_duty = '侦查民警' or staff_duty ='法医民警'";
			break;
		case "mainTech":
			hql = "from xsjsglxt_staff where staff_duty = '技术民警'";
			break;
		case "assistant":
			hql = "from xsjsglxt_staff where staff_duty = '辅警'";
			break;
		}
		Session session = this.getSession();
		Query query = session.createQuery(hql);
		List<xsjsglxt_staff> staffList = query.list();
		return staffList;
	}

	@Override
	public List<xsjsglxt_staff> getMeetCompere() {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		String hql = "from xsjsglxt_staff where staff_duty ='大队长' or staff_duty ='教导员' or staff_duty ='副大队长' or staff_duty ='副教导员' or staff_duty ='中队长' or staff_duty ='副局长'";
		Query query = session.createQuery(hql);
		List<xsjsglxt_staff> staffList = query.list();
		return staffList;
	}

	@Override
	public List<xsjsglxt_staff> getMeetRecorder() {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		String hql = "from xsjsglxt_staff where staff_duty = '内勤民警'";
		Query query = session.createQuery(hql);
		List<xsjsglxt_staff> staffList = query.list();
		return staffList;
	}

	@Override
	public Map<String, List<xsjsglxt_staff>> getInquestPerson() {
		// TODO Auto-generated method stub
		Map<String, List<xsjsglxt_staff>> map = new HashMap<String, List<xsjsglxt_staff>>();
		Session session = this.getSession();
		String hqlLeader = "from xsjsglxt_staff where staff_duty ='局长' or staff_duty='政委' or staff_duty ='大队长' or staff_duty ='教导员' or staff_duty ='副大队长' or staff_duty ='副教导员' or staff_duty ='中队长' or staff_duty ='副局长'";
		String hqlHuman = "from xsjsglxt_staff where staff_duty ='技术民警'";
		List<xsjsglxt_staff> leader = session.createQuery(hqlLeader).list();
		map.put("leader", leader);
		List<xsjsglxt_staff> human = session.createQuery(hqlHuman).list();
		map.put("human", human);
		return map;
	}

	@Override
	public List<xsjsglxt_staff> getHandleCenter() {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		String hql = "from xsjsglxt_staff where staff_duty ='中队长'";
		return session.createQuery(hql).list();
	}

	@Override
	public List<xsjsglxt_staff> getHandleCheck() {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		String hql = "from xsjsglxt_staff where staff_duty ='侦查民警'";
		return session.createQuery(hql).list();
	}

	@Override
	public List<xsjsglxt_staff> getAllStaff(String duty) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		String hql = "from xsjsglxt_staff where 1=1";
		if (duty != null && !"".equals(duty.trim()))
			hql = hql + " and staff_duty = '" + duty + "'";
		return session.createQuery(hql).list();
	}
}
