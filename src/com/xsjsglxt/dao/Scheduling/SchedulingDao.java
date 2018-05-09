package com.xsjsglxt.dao.Scheduling;

import java.util.List;

import com.xsjsglxt.domain.DO.xsjsglxt_scheduling;
import com.xsjsglxt.domain.DO.xsjsglxt_staff;
import com.xsjsglxt.domain.DTO.Scheduling.schedulingDTO;
import com.xsjsglxt.domain.VO.Scheduling.SchedulingDTOListVO;
import com.xsjsglxt.domain.VO.Scheduling.schedulingTimeVO;

public interface SchedulingDao {

	xsjsglxt_scheduling getSchedulingByDate(xsjsglxt_scheduling scheduling);

	boolean saveScheduling(xsjsglxt_scheduling scheduling);

	xsjsglxt_scheduling getSchedulingById(String xsjsglxt_scheduling_id);

	boolean deleteScheduling(String string);

	void updateScheduling(xsjsglxt_scheduling scheduling);

	int getSchedulingCount(SchedulingDTOListVO schedulingListVO);

	List<schedulingDTO> getSchedulingByPage(SchedulingDTOListVO schedulingListVO);

	List<xsjsglxt_staff> getStaffByQuery(String queryName);

	int getSchedulingTime(schedulingTimeVO schedulingTimeVO, String xsjsglxt_name);

	int getOutTime(schedulingTimeVO schedulingTimeVO, String xsjsglxt_name);

	int getOverTime(schedulingTimeVO schedulingTimeVO, String xsjsglxt_name);

	int getPatrolTime(schedulingTimeVO schedulingTimeVO, String xsjsglxt_name);

	int getEvectionTime(schedulingTimeVO schedulingTimeVO, String xsjsglxt_staff_id);

}
