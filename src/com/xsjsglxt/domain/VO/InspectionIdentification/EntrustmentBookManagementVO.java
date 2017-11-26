package com.xsjsglxt.domain.VO.InspectionIdentification;

import java.util.List;

import com.xsjsglxt.domain.DO.xsjsglxt_check_entrustment_book;

public class EntrustmentBookManagementVO {

	// 委托书
	private List<xsjsglxt_check_entrustment_book> listCheckEntrustmentBook;
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
	// 委托日期开始时间
	private String start_time = "0000-00-00";
	// 委托日期结束时间
	private String stop_time = "9999-99-99";
	// 搜索委托编号
	private String bookNum;
	// 搜索案事件名称
	private String caseName;
	// 筛选鉴定机构名称
	private String unitName;
	// 类别
	private String type;
	// 状态
	private String state;

	@Override
	public String toString() {
		return "CheckEntrustmentBookVO [listCheckEntrustmentBook=" + listCheckEntrustmentBook + ", pageIndex="
				+ pageIndex + ", totalRecords=" + totalRecords + ", pageSize=" + pageSize + ", totalPages=" + totalPages
				+ ", HavePrePage=" + HavePrePage + ", HaveNextPage=" + HaveNextPage + ", start_time=" + start_time
				+ ", stop_time=" + stop_time + ", bookNum=" + bookNum + ", caseName=" + caseName + ", unitName="
				+ unitName + ", type=" + type + ", state=" + state + "]";
	}

	public List<xsjsglxt_check_entrustment_book> getListCheckEntrustmentBook() {
		return listCheckEntrustmentBook;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public int getTotalRecords() {
		return totalRecords;
	}

	public int getPageSize() {
		return pageSize;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public boolean isHavePrePage() {
		return HavePrePage;
	}

	public boolean isHaveNextPage() {
		return HaveNextPage;
	}

	public String getStart_time() {
		return start_time;
	}

	public String getStop_time() {
		return stop_time;
	}

	public String getBookNum() {
		return bookNum;
	}

	public String getCaseName() {
		return caseName;
	}

	public String getUnitName() {
		return unitName;
	}

	public String getType() {
		return type;
	}

	public String getState() {
		return state;
	}

	public void setListCheckEntrustmentBook(List<xsjsglxt_check_entrustment_book> listCheckEntrustmentBook) {
		this.listCheckEntrustmentBook = listCheckEntrustmentBook;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public void setHavePrePage(boolean havePrePage) {
		HavePrePage = havePrePage;
	}

	public void setHaveNextPage(boolean haveNextPage) {
		HaveNextPage = haveNextPage;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	public void setStop_time(String stop_time) {
		this.stop_time = stop_time;
	}

	public void setBookNum(String bookNum) {
		this.bookNum = bookNum;
	}

	public void setCaseName(String caseName) {
		this.caseName = caseName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setState(String state) {
		this.state = state;
	}

}
