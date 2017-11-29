package com.xsjsglxt.domain.VO.Case;
import java.util.List;

import com.xsjsglxt.domain.DO.xsjsglxt_lost_computer;
import com.xsjsglxt.domain.DO.xsjsglxt_snece;
import com.xsjsglxt.domain.DTO.Case.LostComputerInformationDTO;
import com.xsjsglxt.domain.DTO.Case.ResevidenceInformationDTO;

public class page_list_ResevidenceInformationVO {
	 // 当前页
	private int pageIndex = 1;
    //总记录数
	private int totalRecords = 0;
    //每页显示记录数
	private int pageSize = 20;
	// 总页数
	private int totalPages = 1;
	// 是否有上一页
	private boolean HavePrePage = false;
	// 是否有下一页
	private boolean HaveNextPage = false;
	// 开始时间
	private String start_time = "0000-00-00";

	// 结束时间
	private String stop_time = "9999-99-99";
	
	private String resevidence_extractPerson;//提取人
	
	private List<ResevidenceInformationDTO> ResevidenceInformationDTOList;

	
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

	public String getResevidence_extractPerson() {
		return resevidence_extractPerson;
	}

	public void setResevidence_extractPerson(String resevidence_extractPerson) {
		this.resevidence_extractPerson = resevidence_extractPerson;
	}

	public List<ResevidenceInformationDTO> getResevidenceInformationDTOList() {
		return ResevidenceInformationDTOList;
	}

	public void setResevidenceInformationDTOList(List<ResevidenceInformationDTO> resevidenceInformationDTOList) {
		ResevidenceInformationDTOList = resevidenceInformationDTOList;
	}

	@Override
	public String toString() {
		return "page_list_ResevidenceInformationVO [pageIndex=" + pageIndex + ", totalRecords=" + totalRecords
				+ ", pageSize=" + pageSize + ", totalPages=" + totalPages + ", HavePrePage=" + HavePrePage
				+ ", HaveNextPage=" + HaveNextPage + ", start_time=" + start_time + ", stop_time=" + stop_time
				+ ", resevidence_extractPerson=" + resevidence_extractPerson + ", ResevidenceInformationDTOList="
				+ ResevidenceInformationDTOList + "]";
	}

	
	
}
