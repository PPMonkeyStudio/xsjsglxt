package com.xsjsglxt.domain.VO.Statistics;

import java.util.List;

import com.xsjsglxt.domain.DO.xsjsglxt_expenditure;

public class ExpenditureVO {
	private String searchStartTime; // 查询开始时间
	private String searchEndTime; // 查询结束时间
	private String searchDetachment; // 查询中队
	private String searchType; // 查询类型
	private String searchName; // 查询姓名
	private String searchSort;// 时间排序
	private int totalMoney; // 总金额
	private int pageSize;
	private int currPage;
	private int totalPage;
	private int totalCount;
	private List<xsjsglxt_expenditure> expenditures;

	public String getSearchStartTime() {
		return searchStartTime;
	}

	public void setSearchStartTime(String searchStartTime) {
		this.searchStartTime = searchStartTime;
	}

	public String getSearchEndTime() {
		return searchEndTime;
	}

	public void setSearchEndTime(String searchEndTime) {
		this.searchEndTime = searchEndTime;
	}

	public String getSearchDetachment() {
		return searchDetachment;
	}

	public void setSearchDetachment(String searchDetachment) {
		this.searchDetachment = searchDetachment;
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getSearchName() {
		return searchName;
	}

	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}

	public int getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(int totalMoney) {
		this.totalMoney = totalMoney;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
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

	public List<xsjsglxt_expenditure> getExpenditures() {
		return expenditures;
	}

	public void setExpenditures(List<xsjsglxt_expenditure> expenditures) {
		this.expenditures = expenditures;
	}

	public String getSearchSort() {
		return searchSort;
	}

	public void setSearchSort(String searchSort) {
		this.searchSort = searchSort;
	}

}
