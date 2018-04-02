package com.xsjsglxt.service.Team;

import java.util.List;

import com.xsjsglxt.domain.DO.xsjsglxt_staffStudent;

public interface StaffStudentService {

	String saveStudents(List<xsjsglxt_staffStudent> students);

	String deleteStudent(String xsjsglxt_staffStudent_id);

	String deleteStudents(String staffStudent_staff);

	String upadteStudent(xsjsglxt_staffStudent student);

	xsjsglxt_staffStudent getStudent(String xsjsglxt_staffStudent_id);

	List<xsjsglxt_staffStudent> getStudents(String staffStudent_staff);

}
