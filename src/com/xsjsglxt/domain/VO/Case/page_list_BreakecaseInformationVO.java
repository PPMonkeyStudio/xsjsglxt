package com.xsjsglxt.domain.VO.Case;

import java.util.List;

import com.xsjsglxt.domain.DTO.Case.BreakecaseInformationDTO;

public class page_list_BreakecaseInformationVO {
	//首页
	private int pageIndex = 1;
    //总记录数
	private int totalRecords = 0;
    //每页显示的页数
	private int pageSize = 20;
	// 总页数
	private int totalPages = 1;
	// 上一页
	private boolean HavePrePage = false;
	// 下一页
	private boolean HaveNextPage = false;
	// 开始时间
	private String start_time = "0000-00-00";

	// 结束时间
	private String stop_time = "9999-99-99";
	private String snece_inquestId;// 勘验编号
	private String case_name;// 案件名
	private String case_totalCategory;// 案件总类别
	private String case_sonCategory;// 案件子类别
	private String breakecase_suspectName;// 嫌疑人姓名
	private String breakecase_captureUnit;// 抓获单位
	
	private List<BreakecaseInformationDTO> BreakecaseInformationDTOList;

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

	public String getStart_time() {
		return start_time;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	public String getStop_time() {
		return stop_time;
	}

	public void setStop_time(String stop_time) {
		this.stop_time = stop_time;
	}

	public String getSnece_inquestId() {
		return snece_inquestId;
	}

	public void setSnece_inquestId(String snece_inquestId) {
		this.snece_inquestId = snece_inquestId;
	}

	public String getCase_name() {
		return case_name;
	}

	public void setCase_name(String case_name) {
		this.case_name = case_name;
	}

	public String getCase_totalCategory() {
		return case_totalCategory;
	}

	public void setCase_totalCategory(String case_totalCategory) {
		this.case_totalCategory = case_totalCategory;
	}

	public String getCase_sonCategory() {
		return case_sonCategory;
	}

	public void setCase_sonCategory(String case_sonCategory) {
		this.case_sonCategory = case_sonCategory;
	}

	public String getBreakecase_suspectName() {
		return breakecase_suspectName;
	}

	public void setBreakecase_suspectName(String breakecase_suspectName) {
		this.breakecase_suspectName = breakecase_suspectName;
	}

	public String getBreakecase_captureUnit() {
		return breakecase_captureUnit;
	}

	public void setBreakecase_captureUnit(String breakecase_captureUnit) {
		this.breakecase_captureUnit = breakecase_captureUnit;
	}

	public List<BreakecaseInformationDTO> getBreakecaseInformationDTOList() {
		return BreakecaseInformationDTOList;
	}

	public void setBreakecaseInformationDTOList(List<BreakecaseInformationDTO> breakecaseInformationDTOList) {
		BreakecaseInformationDTOList = breakecaseInformationDTOList;
	}

	@Override
	public String toString() {
		return "page_list_BreakecaseInformationVO [pageIndex=" + pageIndex + ", totalRecords=" + totalRecords
				+ ", pageSize=" + pageSize + ", totalPages=" + totalPages + ", HavePrePage=" + HavePrePage
				+ ", HaveNextPage=" + HaveNextPage + ", start_time=" + start_time + ", stop_time=" + stop_time
				+ ", snece_inquestId=" + snece_inquestId + ", case_name=" + case_name + ", case_totalCategory="
				+ case_totalCategory + ", case_sonCategory=" + case_sonCategory + ", breakecase_suspectName="
				+ breakecase_suspectName + ", breakecase_captureUnit=" + breakecase_captureUnit
				+ ", BreakecaseInformationDTOList=" + BreakecaseInformationDTOList + "]";
	}

}
