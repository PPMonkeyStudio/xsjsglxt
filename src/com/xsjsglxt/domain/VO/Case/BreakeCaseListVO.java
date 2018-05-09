package com.xsjsglxt.domain.VO.Case;

import java.util.List;

import com.xsjsglxt.domain.DTO.Case.BreakeCasePageDTO;

public class BreakeCaseListVO {
	private int currPage;
	private int totalPage;
	private int totalCount;
	private int pageSize;
	private String query_sence_inquestId; // 查询
	private String query_case_name; // 查询案件名
	private String query_breake_time_start; // 查询破案时间起始
	private String query_breake_time_end; // 查询破案时间结束
	private String query_breake_person; // 查询破案人
	private String query_breake_according;// 破案方式
	private String query_breake_time_sort; // 破案时间升序降序
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

	public String getQuery_breake_according() {
		return query_breake_according;
	}

	public void setQuery_breake_according(String query_breake_according) {
		this.query_breake_according = query_breake_according;
	}

	public String getQuery_breake_time_sort() {
		return query_breake_time_sort;
	}

	public void setQuery_breake_time_sort(String query_breake_time_sort) {
		this.query_breake_time_sort = query_breake_time_sort;
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
	public String getQuery_sence_inquestId() {
		return query_sence_inquestId;
	}

	/**
	 * @param query_sence_inquestId the query_sence_inquestId to set
	 */
	public void setQuery_sence_inquestId(String query_sence_inquestId) {
		this.query_sence_inquestId = query_sence_inquestId;
	}

	/**
	 * @return the query_case_name
	 */
	public String getQuery_case_name() {
		return query_case_name;
	}

	/**
	 * @param query_case_name the query_case_name to set
	 */
	public void setQuery_case_name(String query_case_name) {
		this.query_case_name = query_case_name;
	}

	/**
	 * @return the query_breake_time_start
	 */
	public String getQuery_breake_time_start() {
		return query_breake_time_start;
	}

	/**
	 * @param query_breake_time_start the query_breake_time_start to set
	 */
	public void setQuery_breake_time_start(String query_breake_time_start) {
		this.query_breake_time_start = query_breake_time_start;
	}

	/**
	 * @return the query_breake_time_end
	 */
	public String getQuery_breake_time_end() {
		return query_breake_time_end;
	}

	/**
	 * @param query_breake_time_end the query_breake_time_end to set
	 */
	public void setQuery_breake_time_end(String query_breake_time_end) {
		this.query_breake_time_end = query_breake_time_end;
	}

	/**
	 * @return the query_breake_person
	 */
	public String getQuery_breake_person() {
		return query_breake_person;
	}

	/**
	 * @param query_breake_person the query_breake_person to set
	 */
	public void setQuery_breake_person(String query_breake_person) {
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
