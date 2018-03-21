package com.xsjsglxt.dao.Team;

import java.util.List;

import com.xsjsglxt.domain.DO.xsjsglxt_staffWork;

public interface StaffWorkDao {

	List<xsjsglxt_staffWork> getWorks(String staffWork_staff);

	xsjsglxt_staffWork getWork(String xsjsglxt_staffWork_id);

	String deleteWorks(String staffWork_staff);

	String deleteWork(String xsjsglxt_staffWork_id);

	String saveWorks(List<xsjsglxt_staffWork> works);

}
