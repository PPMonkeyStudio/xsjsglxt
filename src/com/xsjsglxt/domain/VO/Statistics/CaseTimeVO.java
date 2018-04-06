package com.xsjsglxt.domain.VO.Statistics;

import com.xsjsglxt.domain.DTO.Statistics.CaseTimeDTO;

public class CaseTimeVO {
	private String caseTimeStart;
	private String caseTimeEnd;
	private String firstCategory;
	private String secondCategory;
	private CaseTimeDTO caseTimtDTO;

	public CaseTimeDTO getCaseTimtDTO() {
		return caseTimtDTO;
	}

	public void setCaseTimtDTO(CaseTimeDTO caseTimtDTO) {
		this.caseTimtDTO = caseTimtDTO;
	}

	public String getFirstCategory() {
		return firstCategory;
	}

	public void setFirstCategory(String firstCategory) {
		this.firstCategory = firstCategory;
	}

	public String getSecondCategory() {
		return secondCategory;
	}

	public void setSecondCategory(String secondCategory) {
		this.secondCategory = secondCategory;
	}

	public String getCaseTimeStart() {
		return caseTimeStart;
	}

	public void setCaseTimeStart(String caseTimeStart) {
		this.caseTimeStart = caseTimeStart;
	}

	public String getCaseTimeEnd() {
		return caseTimeEnd;
	}

	public void setCaseTimeEnd(String caseTimeEnd) {
		this.caseTimeEnd = caseTimeEnd;
	}

}
