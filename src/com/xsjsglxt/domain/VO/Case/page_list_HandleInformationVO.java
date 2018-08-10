package com.xsjsglxt.domain.VO.Case;

import java.util.List;

import com.xsjsglxt.domain.DO.XsjsglxtHandle;
import com.xsjsglxt.domain.DO.XsjsglxtHandleSuspect;
import com.xsjsglxt.domain.DTO.Case.HandleSuspectDTO;

public class page_list_HandleInformationVO {
	// 首页
	private int pageIndex = 1;
	// 总记录数
	private int totalRecords = 0;
	// 每页显示的页数
	private int pageSize = 20;
	// 总页数
	private int totalPages = 1;
	// 上一页
	private boolean HavePrePage = false;
	// 下一页
	private boolean HaveNextPage = false;
	// 案件名称
	private String handle_administrativeCase = "%";
	// 中队长
	private String handle_squadronleader = "%";
	// 主办民警
	private String handleSponsoredPolice = "%";
	// 案件类型
	private String handleAdministrativeType = "%";
	// 嫌疑人姓名
	private String handle_handleSuspectName = "%";
	// 处理方式
	private String handle_handleSuspectHandling = "%";
	// 嫌疑人
	private List<HandleSuspectDTO> listSuspectDTO;

	public page_list_HandleInformationVO() {
		super();
	}

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

	/* GET */
	public String getHandle_administrativeCase() {
		return handle_administrativeCase;
	}

	public String getHandle_squadronleader() {
		return handle_squadronleader;
	}


	public String getHandle_handleSuspectName() {
		return handle_handleSuspectName;
	}

	public String getHandle_handleSuspectHandling() {
		return handle_handleSuspectHandling;
	}

	public String getHandleSponsoredPolice() {
		return handleSponsoredPolice;
	}

	public String getHandleAdministrativeType() {
		return handleAdministrativeType;
	}
	
	public List<HandleSuspectDTO> getListSuspectDTO() {
		return listSuspectDTO;
	}

	/* SET */
	public void setHandle_administrativeCase(String handle_administrativeCase) {
		if ("".equals(handle_administrativeCase) || handle_administrativeCase == null)
			this.handle_administrativeCase = "%";
		else
			this.handle_administrativeCase = handle_administrativeCase;
	}

	public void setListSuspectDTO(List<HandleSuspectDTO> listSuspectDTO) {
		this.listSuspectDTO = listSuspectDTO;
	}

	public void setHandle_squadronleader(String handle_squadronleader) {
		if ("".equals(handle_squadronleader) || handle_squadronleader == null)
			this.handle_squadronleader = "%";
		else
			this.handle_squadronleader = handle_squadronleader;
	}

	public void setHandle_handleSuspectName(String handle_handleSuspectName) {
		if ("".equals(handle_handleSuspectName) || handle_handleSuspectName == null)
			this.handle_handleSuspectName = "%";
		else
			this.handle_handleSuspectName = handle_handleSuspectName;
	}

	public void setHandle_handleSuspectHandling(String handle_handleSuspectHandling) {
		if ("".equals(handle_handleSuspectHandling) || handle_handleSuspectHandling == null)
			this.handle_handleSuspectHandling = "%";
		else
			this.handle_handleSuspectHandling = handle_handleSuspectHandling;
	}

	public void setHandleSponsoredPolice(String handleSponsoredPolice) {
		if ("".equals(handleSponsoredPolice) || handleSponsoredPolice == null)
			this.handleSponsoredPolice = "%";
		else
			this.handleSponsoredPolice = handleSponsoredPolice;
	}

	public void setHandleAdministrativeType(String handleAdministrativeType) {
		if ("".equals(handleAdministrativeType) || handleAdministrativeType == null)
			this.handleAdministrativeType = "%";
		else
			this.handleAdministrativeType = handleAdministrativeType;
	}

	@Override
	public String toString() {
		return "page_list_HandleInformationVO [pageIndex=" + pageIndex + ", totalRecords=" + totalRecords
				+ ", pageSize=" + pageSize + ", totalPages=" + totalPages + ", HavePrePage=" + HavePrePage
				+ ", HaveNextPage=" + HaveNextPage + ", handle_administrativeCase=" + handle_administrativeCase
				+ ", handle_squadronleader=" + handle_squadronleader + ", handleSponsoredPolice="
				+ handleSponsoredPolice + ", handleAdministrativeType=" + handleAdministrativeType
				+ ", handle_handleSuspectName=" + handle_handleSuspectName + ", handle_handleSuspectHandling="
				+ handle_handleSuspectHandling + ", listSuspect=" + listSuspectDTO + "]";
	}

}
