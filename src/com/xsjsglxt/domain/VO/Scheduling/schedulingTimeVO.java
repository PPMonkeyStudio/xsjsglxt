package com.xsjsglxt.domain.VO.Scheduling;

import java.util.List;

import com.xsjsglxt.domain.DTO.Scheduling.schedulingTimeDTO;

public class schedulingTimeVO {
	private String queryTimeStart;
	private String queryTimeEnd;
	private String queryName;
	private List<schedulingTimeDTO> timeDTOList;

	public String getQueryTimeStart() {
		return queryTimeStart;
	}

	public void setQueryTimeStart(String queryTimeStart) {
		this.queryTimeStart = queryTimeStart;
	}

	public String getQueryTimeEnd() {
		return queryTimeEnd;
	}

	public void setQueryTimeEnd(String queryTimeEnd) {
		this.queryTimeEnd = queryTimeEnd;
	}

	public String getQueryName() {
		return queryName;
	}

	public void setQueryName(String queryName) {
		this.queryName = queryName;
	}

	public List<schedulingTimeDTO> getTimeDTOList() {
		return timeDTOList;
	}

	public void setTimeDTOList(List<schedulingTimeDTO> timeDTOList) {
		this.timeDTOList = timeDTOList;
	}

}
