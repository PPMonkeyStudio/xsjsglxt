package com.xsjsglxt.domain.VO.User;

import java.util.List;

import com.xsjsglxt.domain.DO.xsjsglxt_meeting;

public class meetingByPageAndSerarchVO {
	private String queryCondition; // 查询条件
	private String startTimeSort; // 开始时间排序 desc降序 asc升序
	private int pageCount; // 总页数
	private int currPage; // 当前页数
	private int pageSize; // 一页显示数目
	private int totalCount; // 总记录数
	private List<xsjsglxt_meeting> meet;

	public String getQueryCondition() {
		return queryCondition;
	}

	public void setQueryCondition(String queryCondition) {
		this.queryCondition = queryCondition;
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

	public List<xsjsglxt_meeting> getMeet() {
		return meet;
	}

	public void setMeet(List<xsjsglxt_meeting> meet) {
		this.meet = meet;
	}

}
