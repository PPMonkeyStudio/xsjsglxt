package com.xsjsglxt.domain.VO.Case;

import java.util.List;

import com.xsjsglxt.domain.DTO.Case.BreakeCasePageDTO;

public class BreakeCaseListVO {
	private int currPage;
	private int totalPage;
	private int totalCount;
	private int pageSize;
	private int query_sence_inquestId;
	private int query_case_name;
	private int query_breake_time_start;
	private int query_breake_time_end;
	private int query_breake_person;
	private List<BreakeCasePageDTO> breakeCaseDTOList;

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BreakeCaseListVO [currPage=" + currPage + ", totalPage=" + totalPage + ", totalCount=" + totalCount
				+ ", pageSize=" + pageSize + ", query_sence_inquestId=" + query_sence_inquestId + ", query_case_name="
				+ query_case_name + ", query_breake_time_start=" + query_breake_time_start + ", query_breake_time_end="
				+ query_breake_time_end + ", query_breake_person=" + query_breake_person + ", breakeCaseDTOList="
				+ breakeCaseDTOList + "]";
	}

	/**
	 * @return the currPage
	 */
	public int getCurrPage() {
		return currPage;
	}

	/**
	 * @param currPage the currPage to set
	 */
	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}

	/**
	 * @return the totalPage
	 */
	public int getTotalPage() {
		return totalPage;
	}

	/**
	 * @param totalPage the totalPage to set
	 */
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	/**
	 * @return the totalCount
	 */
	public int getTotalCount() {
		return totalCount;
	}

	/**
	 * @param totalCount the totalCount to set
	 */
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	/**
	 * @return the pageSize
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * @param pageSize the pageSize to set
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * @return the query_sence_inquestId
	 */
	public int getQuery_sence_inquestId() {
		return query_sence_inquestId;
	}

	/**
	 * @param query_sence_inquestId the query_sence_inquestId to set
	 */
	public void setQuery_sence_inquestId(int query_sence_inquestId) {
		this.query_sence_inquestId = query_sence_inquestId;
	}

	/**
	 * @return the query_case_name
	 */
	public int getQuery_case_name() {
		return query_case_name;
	}

	/**
	 * @param query_case_name the query_case_name to set
	 */
	public void setQuery_case_name(int query_case_name) {
		this.query_case_name = query_case_name;
	}

	/**
	 * @return the query_breake_time_start
	 */
	public int getQuery_breake_time_start() {
		return query_breake_time_start;
	}

	/**
	 * @param query_breake_time_start the query_breake_time_start to set
	 */
	public void setQuery_breake_time_start(int query_breake_time_start) {
		this.query_breake_time_start = query_breake_time_start;
	}

	/**
	 * @return the query_breake_time_end
	 */
	public int getQuery_breake_time_end() {
		return query_breake_time_end;
	}

	/**
	 * @param query_breake_time_end the query_breake_time_end to set
	 */
	public void setQuery_breake_time_end(int query_breake_time_end) {
		this.query_breake_time_end = query_breake_time_end;
	}

	/**
	 * @return the query_breake_person
	 */
	public int getQuery_breake_person() {
		return query_breake_person;
	}

	/**
	 * @param query_breake_person the query_breake_person to set
	 */
	public void setQuery_breake_person(int query_breake_person) {
		this.query_breake_person = query_breake_person;
	}

	/**
	 * @return the breakeCaseDTOList
	 */
	public List<BreakeCasePageDTO> getBreakeCaseDTOList() {
		return breakeCaseDTOList;
	}

	/**
	 * @param breakeCaseDTOList the breakeCaseDTOList to set
	 */
	public void setBreakeCaseDTOList(List<BreakeCasePageDTO> breakeCaseDTOList) {
		this.breakeCaseDTOList = breakeCaseDTOList;
	}

}
