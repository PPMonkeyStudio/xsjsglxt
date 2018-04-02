package com.xsjsglxt.dao.impl.Team;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xsjsglxt.dao.Team.StaffStudentDao;
import com.xsjsglxt.domain.DO.xsjsglxt_staffStudent;

public class StaffStudentDaoImpl implements StaffStudentDao {
	private SessionFactory sessionFactory;
	private final static String SAVE = "saveSuccess";
	private final static String DELETE = "deleteSuccess";

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
	public String saveStudents(List<xsjsglxt_staffStudent> students) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		for (xsjsglxt_staffStudent xsjsglxt_staffStudent : students) {
			session.save(xsjsglxt_staffStudent);
		}
		return SAVE;
	}

	@Override
	public String deleteStudent(String xsjsglxt_staffStudent_id) {
		// TODO Auto-generated method stub
		xsjsglxt_staffStudent student = new xsjsglxt_staffStudent();
		student.setXsjsglxt_staffStudent_id(xsjsglxt_staffStudent_id);
		this.getSession().delete(student);
		return DELETE;
	}

	@Override
	public String deleteStudents(String staffStudent_staff) {
		// TODO Auto-generated method stub
		String hql = "delete from xsjsglxt_staffStudent where staffStudent_staff='" + staffStudent_staff + "'";
		Session session = this.getSession();
		session.createQuery(hql).executeUpdate();
		return DELETE;
	}

	@Override
	public xsjsglxt_staffStudent getStudent(String xsjsglxt_staffStudent_id) {
		// TODO Auto-generated method stub
		return (xsjsglxt_staffStudent) this.getSession().get(xsjsglxt_staffStudent.class, xsjsglxt_staffStudent_id);
	}

	@Override
	public List<xsjsglxt_staffStudent> getStudents(String staffStudent_staff) {
		// TODO Auto-generated method stub
		String hql = "from xsjsglxt_staffStudent where staffStudent_staff='" + staffStudent_staff + "'";
		return this.getSession().createQuery(hql).list();
	}

}
