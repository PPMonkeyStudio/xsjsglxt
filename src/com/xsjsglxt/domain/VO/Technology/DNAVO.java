package com.xsjsglxt.domain.VO.Technology;

import java.util.List;

import com.xsjsglxt.domain.DO.xsjsglxt_dna;

public class DNAVO {
	// 当前页
	private int pageIndex = 1;
	// 总记录数
	private int totalRecords = 0;
	// 每页显示记录数
	private int pageSize = 10;
	// 总页数
	private int totalPages = 1;
	// 是否有上一页
	private boolean HavePrePage = false;
	// 是否有下一页
	private boolean HaveNextPage = false;
	// 搜索
	private String search;
	// 搜索建档
	private String searchDnaBuilder;
	// 搜索建档情况
	private String searchFingerBuilder;
	// 学生列表
	private List<xsjsglxt_dna> list_xsjsglxt_dna;

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public boolean isHavePrePage() {
		return HavePrePage;
	}

	public void setHavePrePage(boolean havePrePage) {
		HavePrePage = havePrePage;
	}

	public boolean isHaveNextPage() {
		return HaveNextPage;
	}

	public void setHaveNextPage(boolean haveNextPage) {
		HaveNextPage = haveNextPage;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public List<xsjsglxt_dna> getList_xsjsglxt_dna() {
		return list_xsjsglxt_dna;
	}

	public void setList_xsjsglxt_dna(List<xsjsglxt_dna> list_xsjsglxt_dna) {
		this.list_xsjsglxt_dna = list_xsjsglxt_dna;
	}

	public String getSearchDnaBuilder() {
		return searchDnaBuilder;
	}

	public void setSearchDnaBuilder(String searchDnaBuilder) {
		this.searchDnaBuilder = searchDnaBuilder;
	}

	public String getSearchFingerBuilder() {
		return searchFingerBuilder;
	}

	public void setSearchFingerBuilder(String searchFingerBuilder) {
		this.searchFingerBuilder = searchFingerBuilder;
	}

	@Override
	public String toString() {
		return "DNAVO [pageIndex=" + pageIndex + ", totalRecords=" + totalRecords + ", pageSize=" + pageSize
				+ ", totalPages=" + totalPages + ", HavePrePage=" + HavePrePage + ", HaveNextPage=" + HaveNextPage
				+ ", search=" + search + ", list_xsjsglxt_dna=" + list_xsjsglxt_dna + "]";
	}

}
