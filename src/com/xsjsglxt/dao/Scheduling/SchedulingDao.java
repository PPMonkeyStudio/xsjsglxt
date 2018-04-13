package com.xsjsglxt.dao.Scheduling;

import com.xsjsglxt.domain.DO.xsjsglxt_scheduling;

public interface SchedulingDao {

	xsjsglxt_scheduling getSchedulingByDate(xsjsglxt_scheduling scheduling);

	boolean saveScheduling(xsjsglxt_scheduling scheduling);

	xsjsglxt_scheduling getSchedulingById(String xsjsglxt_scheduling_id);

	boolean deleteScheduling(String string);

	void updateScheduling(xsjsglxt_scheduling scheduling);

}
