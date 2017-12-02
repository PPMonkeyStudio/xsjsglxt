package com.xsjsglxt.domain.VO.Case;

import java.util.List;

import com.xsjsglxt.domain.DTO.Case.SenceInformationDTO;

public class page_list_senceInformationVO {
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
		//案件总类别
	    private String case_totalCategory; 
	   //案件子类别
	    private String  case_sonCategory;
	    //案件分类
	    private String case_classify;
	    //选择住所
	    private String case_residence;
	    //选择具体住所
	    private String case_concreteResidence;
	    //勘验人员
	    private String snece_inquestPerson;
	    //作案时段
	    private String case_makeTime;
	    //作案手段
	    private String case_makeMeans;
	    //作案具体手段
	    private String case_concreteMakeMeans;
	    
	    private List<SenceInformationDTO> SenceInformationDTOList;
	    
		
	
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



		public String getCase_classify() {
			return case_classify;
		}



		public void setCase_classify(String case_classify) {
			this.case_classify = case_classify;
		}



		public String getCase_residence() {
			return case_residence;
		}



		public void setCase_residence(String case_residence) {
			this.case_residence = case_residence;
		}



		public String getCase_concreteResidence() {
			return case_concreteResidence;
		}



		public void setCase_concreteResidence(String case_concreteResidence) {
			this.case_concreteResidence = case_concreteResidence;
		}



		public String getSnece_inquestPerson() {
			return snece_inquestPerson;
		}



		public void setSnece_inquestPerson(String snece_inquestPerson) {
			this.snece_inquestPerson = snece_inquestPerson;
		}



		public String getCase_makeTime() {
			return case_makeTime;
		}



		public void setCase_makeTime(String case_makeTime) {
			this.case_makeTime = case_makeTime;
		}



		public String getCase_makeMeans() {
			return case_makeMeans;
		}



		public void setCase_makeMeans(String case_makeMeans) {
			this.case_makeMeans = case_makeMeans;
		}



		public String getCase_concreteMakeMeans() {
			return case_concreteMakeMeans;
		}



		public void setCase_concreteMakeMeans(String case_concreteMakeMeans) {
			this.case_concreteMakeMeans = case_concreteMakeMeans;
		}



		public List<SenceInformationDTO> getSenceInformationDTOList() {
			return SenceInformationDTOList;
		}



		public void setSenceInformationDTOList(List<SenceInformationDTO> senceInformationDTOList) {
			SenceInformationDTOList = senceInformationDTOList;
		}



		@Override
		public String toString() {
			return "page_list_senceInformationVO [pageIndex=" + pageIndex + ", totalRecords=" + totalRecords
					+ ", pageSize=" + pageSize + ", totalPages=" + totalPages + ", HavePrePage=" + HavePrePage
					+ ", HaveNextPage=" + HaveNextPage + ", start_time=" + start_time + ", stop_time=" + stop_time
					+ ", case_totalCategory=" + case_totalCategory + ", case_sonCategory=" + case_sonCategory
					+ ", case_classify=" + case_classify + ", case_residence=" + case_residence
					+ ", case_concreteResidence=" + case_concreteResidence + ", snece_inquestPerson="
					+ snece_inquestPerson + ", case_makeTime=" + case_makeTime + ", case_makeMeans=" + case_makeMeans
					+ ", case_concreteMakeMeans=" + case_concreteMakeMeans + ", SenceInformationDTOList="
					+ SenceInformationDTOList + "]";
		}
		
		
	    
		
	    
}
