package com.xsjsglxt.service.impl.Team;

import java.util.List;

import com.xsjsglxt.dao.Team.StaffStudentDao;
import com.xsjsglxt.domain.DO.xsjsglxt_staffStudent;
import com.xsjsglxt.service.Team.StaffStudentService;

import util.TeamUtil;

public class StaffStudentServiceImpl implements StaffStudentService {
	private StaffStudentDao staffStudentDao;

	public StaffStudentDao getStaffStudentDao() {
		return staffStudentDao;
	}

	public void setStaffStudentDao(StaffStudentDao staffStudentDao) {
		this.staffStudentDao = staffStudentDao;
	}

	@Override
	public String saveStudents(List<xsjsglxt_staffStudent> students) {
		// TODO Auto-generated method stub
		for (xsjsglxt_staffStudent xsjsglxt_staffStudent : students) {
			xsjsglxt_staffStudent.setXsjsglxt_staffStudent_id(TeamUtil.getUuid());
			xsjsglxt_staffStudent.setStaffStudent_gmt_create(TeamUtil.getStringSecond());
			xsjsglxt_staffStudent.setStaffStudent_gmt_modified(TeamUtil.getStringSecond());
		}
		String result = staffStudentDao.saveStudents(students);
		return result;
	}

	@Override
	public String deleteStudent(String xsjsglxt_staffStudent_id) {
		// TODO Auto-generated method stub
		String result = staffStudentDao.deleteStudent(xsjsglxt_staffStudent_id);
		return result;
	}

	@Override
	public String deleteStudents(String staffStudent_staff) {
		// TODO Auto-generated method stub
		String result = staffStudentDao.deleteStudents(staffStudent_staff);
		return result;
	}

	@Override
	public String upadteStudent(xsjsglxt_staffStudent student) {
		// TODO Auto-generated method stub
		xsjsglxt_staffStudent oldStudent = staffStudentDao.getStudent(student.getXsjsglxt_staffStudent_id());
		oldStudent.setStaffStudent_gmt_modified(TeamUtil.getStringSecond());
		oldStudent.setStaffStudent_remarks(student.getStaffStudent_remarks());
		oldStudent.setStaffStudent_address(student.getStaffStudent_address());
		oldStudent.setStaffStudent_evection(student.getStaffStudent_evection());
		oldStudent.setStaffStudent_startTime(student.getStaffStudent_startTime());
		oldStudent.setStaffStudent_stopTime(student.getStaffStudent_stopTime());
		return "updateSuccess";
	}

	@Override
	public xsjsglxt_staffStudent getStudent(String xsjsglxt_staffStudent_id) {
		// TODO Auto-generated method stub
		return staffStudentDao.getStudent(xsjsglxt_staffStudent_id);
	}

	@Override
	public List<xsjsglxt_staffStudent> getStudents(String staffStudent_staff) {
		// TODO Auto-generated method stub
		return staffStudentDao.getStudents(staffStudent_staff);
	}
}
