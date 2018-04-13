package com.xsjsglxt.domain.VO.Scheduling;

import java.util.List;

import com.xsjsglxt.domain.DTO.Scheduling.schedulingDTO;

public class SchedulingDTOListVO {
	private int currPage; // 当前页数
	private int totalPage; // 总页数
	private int totalCount; // 总记录数
	private int pageSize; // 页面总条数
	private String query_name;
	private String queryTimeStart;
	private String queryTimeEnd;
	private List<schedulingDTO> schedulingDTOList;

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

	public int getCurrPage() {
		return currPage;
	}

	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getQuery_name() {
		return query_name;
	}

	public void setQuery_name(String query_name) {
		this.query_name = query_name;
	}

	public List<schedulingDTO> getSchedulingDTOList() {
		return schedulingDTOList;
	}

	public void setSchedulingDTOList(List<schedulingDTO> schedulingDTOList) {
		this.schedulingDTOList = schedulingDTOList;
	}

}
