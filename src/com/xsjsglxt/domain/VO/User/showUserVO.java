package com.xsjsglxt.domain.VO.User;

import java.util.List;

import com.xsjsglxt.domain.DO.xsjsglxt_user;

public class showUserVO {
	private int currPage;
	private int totalPage;
	private int count;
	private int pageSize;
	private String queryString;
	private List<xsjsglxt_user> list;

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

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getQueryString() {
		return queryString;
	}

	public void setQueryString(String queryString) {
		this.queryString = queryString;
	}

	public List<xsjsglxt_user> getList() {
		return list;
	}

	public void setList(List<xsjsglxt_user> list) {
		this.list = list;
	}

}
