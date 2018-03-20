package com.xsjsglxt.domain.VO.User;

import java.util.List;

import com.xsjsglxt.domain.DTO.User.memorabiliaListDTO;

public class memorabiliaByPageAndSearchVO {
	private String searchContent; // 搜索内容
	private String create_time_start; // 创建时间开始
	private String create_time_end; // 创建时间结束
	private String querySort;
	private int pageSize; // 每页显示数目
	private int pageCount; // 页数
	private int currPage; // 当前页数
	private int totalCount; // 总记录数
	private List<memorabiliaListDTO> memorabiliaListDTO;

	@Override
	public String toString() {
		return "memorabiliaByPageAndSearchVO [searchContent=" + searchContent + ", create_time_start="
				+ create_time_start + ", create_time_end=" + create_time_end + ", querySort=" + querySort
				+ ", pageSize=" + pageSize + ", pageCount=" + pageCount + ", currPage=" + currPage + ", totalCount="
				+ totalCount + ", memorabiliaListDTO=" + memorabiliaListDTO + ", getQuerySort()=" + getQuerySort()
				+ ", getSearchContent()=" + getSearchContent() + ", getCreate_time_start()=" + getCreate_time_start()
				+ ", getCreate_time_end()=" + getCreate_time_end() + ", getPageSize()=" + getPageSize()
				+ ", getPageCount()=" + getPageCount() + ", getCurrPage()=" + getCurrPage() + ", getTotalCount()="
				+ getTotalCount() + ", getMemorabiliaListDTO()=" + getMemorabiliaListDTO() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	public String getQuerySort() {
		return querySort;
	}

	public void setQuerySort(String querySort) {
		this.querySort = querySort;
	}

	public String getSearchContent() {
		return searchContent;
	}

	public void setSearchContent(String searchContent) {
		this.searchContent = searchContent;
	}

	public String getCreate_time_start() {
		return create_time_start;
	}

	public void setCreate_time_start(String create_time_start) {
		this.create_time_start = create_time_start;
	}

	public String getCreate_time_end() {
		return create_time_end;
	}

	public void setCreate_time_end(String create_time_end) {
		this.create_time_end = create_time_end;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
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

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public List<memorabiliaListDTO> getMemorabiliaListDTO() {
		return memorabiliaListDTO;
	}

	public void setMemorabiliaListDTO(List<memorabiliaListDTO> memorabiliaListDTO) {
		this.memorabiliaListDTO = memorabiliaListDTO;
	}
}
