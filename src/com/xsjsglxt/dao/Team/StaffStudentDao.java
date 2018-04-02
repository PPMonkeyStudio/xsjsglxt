package com.xsjsglxt.dao.Team;

import java.util.List;

import com.xsjsglxt.domain.DO.xsjsglxt_staffStudent;

public interface StaffStudentDao {

	String saveStudents(List<xsjsglxt_staffStudent> students);

	String deleteStudent(String xsjsglxt_staffStudent_id);

	String deleteStudents(String staffStudent_staff);

	xsjsglxt_staffStudent getStudent(String xsjsglxt_staffStudent_id);

	List<xsjsglxt_staffStudent> getStudents(String staffStudent_staff);

}
