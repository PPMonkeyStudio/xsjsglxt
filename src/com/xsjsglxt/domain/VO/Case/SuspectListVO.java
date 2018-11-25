package com.xsjsglxt.domain.VO.Case;

import java.util.List;

import com.xsjsglxt.domain.DTO.Case.SuspectInforDTO;

public class SuspectListVO {
	private int pageSize;
	private int currPage;
	private int totalPage;
	private int totalSize;
	private String searchCaseName;
	private String searchName;
	private String searchType;
	private List<SuspectInforDTO> suspectDTO;

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
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

	public String getSearchName() {
		return searchName;
	}

	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}

	public List<SuspectInforDTO> getSuspectDTO() {
		return suspectDTO;
	}

	public void setSuspectDTO(List<SuspectInforDTO> suspectDTO) {
		this.suspectDTO = suspectDTO;
	}
}
