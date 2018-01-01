package com.xsjsglxt.domain.VO.Case;

import java.util.List;

import com.xsjsglxt.domain.DTO.Case.SenceInformationDTO;

public class page_list_senceInformationVO {
	    // ��ǰҳ
		private int pageIndex = 1;
	    //�ܼ�¼��
		private int totalRecords = 0;
	    //ÿҳ��ʾ��¼��
		private int pageSize = 20;
		// ��ҳ��
		private int totalPages = 1;
		// �Ƿ�����һҳ
		private boolean HavePrePage = false;
		// �Ƿ�����һҳ
		private boolean HaveNextPage = false;
		// ��ʼʱ��
		private String start_time = "0000-00-00";

		// ����ʱ��
		private String stop_time = "9999-99-99";
		//���������
	    private String case_totalCategory; 
	   //���������
	    private String  case_sonCategory;
	    //��������
	    private String case_classify;
	    //ѡ��ס��
	    private String case_residence;
	    //ѡ�����ס��
	    private String case_concreteResidence;
	    //������Ա
	    private String snece_inquestPerson;
	    //����ʱ��
	    private String case_makeTime;
	    //�����ֶ�
	    private String case_makeMeans;
	    //���������ֶ�
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
