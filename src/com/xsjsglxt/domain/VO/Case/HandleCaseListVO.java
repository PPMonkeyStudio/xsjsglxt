package com.xsjsglxt.domain.VO.Case;

import java.util.List;

import com.xsjsglxt.domain.DO.xsjsglxt_handle_case;

public class HandleCaseListVO {
	private List<xsjsglxt_handle_case> caseList;
	private int pageSize;
	private int currPage;
	private int totalPage;
	private int totalSize;
	private String searchCaseName;
	private String searchMainPolice;
	private String searchAssistantPolice;
	private String searchMiddleCaptaion;
	private String searchCaseState;

	public List<xsjsglxt_handle_case> getCaseList() {
		return caseList;
	}

	public void setCaseList(List<xsjsglxt_handle_case> caseList) {
		this.caseList = caseList;
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

	public int getTotalSize() {
		return totalSize;
	}

	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}

	public String getSearchCaseName() {
		return searchCaseName;
	}

	public void setSearchCaseName(String searchCaseName) {
		this.searchCaseName = searchCaseName;
	}

	public String getSearchMainPolice() {
		return searchMainPolice;
	}

	public void setSearchMainPolice(String searchMainPolice) {
		this.searchMainPolice = searchMainPolice;
	}

	public String getSearchAssistantPolice() {
		return searchAssistantPolice;
	}

	public void setSearchAssistantPolice(String searchAssistantPolice) {
		this.searchAssistantPolice = searchAssistantPolice;
	}

	public String getSearchMiddleCaptaion() {
		return searchMiddleCaptaion;
	}

	public void setSearchMiddleCaptaion(String searchMiddleCaptaion) {
		this.searchMiddleCaptaion = searchMiddleCaptaion;
	}

	public String getSearchCaseState() {
		return searchCaseState;
	}

	public void setSearchCaseState(String searchCaseState) {
		this.searchCaseState = searchCaseState;
	}

}
