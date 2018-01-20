package com.xsjsglxt.domain.VO.User;

import java.util.List;

import com.xsjsglxt.domain.DTO.User.meetingSearchDTO;

public class meetingByPageAndSerarchVO {
	private String queryTitle; // 查询条件
	private String startTimeSort; // 开始时间排序 desc降序 asc升序
	private String query_start_time_start;
	private String query_start_time_end;
	private int pageCount; // 总页数
	private int currPage; // 当前页数
	private int pageSize; // 一页显示数目
	private int totalCount; // 总记录数
	private List<meetingSearchDTO> meetDTO;

	public String getQuery_start_time_start() {
		return query_start_time_start;
	}

	public void setQuery_start_time_start(String query_start_time_start) {
		this.query_start_time_start = query_start_time_start;
	}

	public String getQuery_start_time_end() {
		return query_start_time_end;
	}

	public void setQuery_start_time_end(String query_start_time_end) {
		this.query_start_time_end = query_start_time_end;
	}

	public String getQueryTitle() {
		return queryTitle;
	}

	public void setQueryTitle(String queryTitle) {
		this.queryTitle = queryTitle;
	}

	public String getStartTimeSort() {
		return startTimeSort;
	}

	public void setStartTimeSort(String startTimeSort) {
		this.startTimeSort = startTimeSort;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getCurrPage() {
		return currPage;
	}

	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public List<meetingSearchDTO> getMeetDTO() {
		return meetDTO;
	}

	public void setMeetDTO(List<meetingSearchDTO> meetDTO) {
		this.meetDTO = meetDTO;
	}

}
