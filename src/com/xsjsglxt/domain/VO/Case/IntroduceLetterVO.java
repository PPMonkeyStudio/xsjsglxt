package com.xsjsglxt.domain.VO.Case;

import java.util.List;

import com.xsjsglxt.domain.DO.xsjsglxt_introduce_letter;

public class IntroduceLetterVO {
	private int currPage; // 当前页数
	private int totalPage; // 总页数
	private int totalCount; // 总数目
	private int pageSize;// 最大显示数目
	private String queryContent;// 输入框模糊查询内容
	private String query_time_start;// 查询开始时间
	private String query_time_end;// 查询结束时间
	private String query_time_sort;// 时间排序
	private List<xsjsglxt_introduce_letter> letterList;

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

	public String getQueryContent() {
		return queryContent;
	}

	public void setQueryContent(String queryContent) {
		this.queryContent = queryContent;
	}

	public String getQuery_time_start() {
		return query_time_start;
	}

	public void setQuery_time_start(String query_time_start) {
		this.query_time_start = query_time_start;
	}

	public String getQuery_time_end() {
		return query_time_end;
	}

	public void setQuery_time_end(String query_time_end) {
		this.query_time_end = query_time_end;
	}

	public String getQuery_time_sort() {
		return query_time_sort;
	}

	public void setQuery_time_sort(String query_time_sort) {
		this.query_time_sort = query_time_sort;
	}

	public List<xsjsglxt_introduce_letter> getLetterList() {
		return letterList;
	}

	public void setLetterList(List<xsjsglxt_introduce_letter> letterList) {
		this.letterList = letterList;
	}

	@Override
	public String toString() {
		return "IntroduceLetterVO [currPage=" + currPage + ", totalPage=" + totalPage + ", totalCount=" + totalCount
				+ ", pageSize=" + pageSize + ", queryContent=" + queryContent + ", query_time_start=" + query_time_start
				+ ", query_time_end=" + query_time_end + ", query_time_sort=" + query_time_sort + ", letterList="
				+ letterList + "]";
	}

}
