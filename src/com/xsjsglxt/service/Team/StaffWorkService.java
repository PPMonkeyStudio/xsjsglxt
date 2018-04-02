package com.xsjsglxt.service.Team;

import java.util.List;

import com.xsjsglxt.domain.DO.xsjsglxt_staffWork;

public interface StaffWorkService {

	List<xsjsglxt_staffWork> getWorks(String staffWork_staff);

	xsjsglxt_staffWork getWork(String xsjsglxt_staffWork_id);

	String upadteWork(xsjsglxt_staffWork work);

	String deleteWorks(String staffWork_staff);

	String deleteWork(String xsjsglxt_staffWork_id);

	String saveWorks(List<xsjsglxt_staffWork> works);

}
