package com.xsjsglxt.domain.VO.Team;

import java.util.List;

import com.xsjsglxt.domain.DO.xsjsglxt_staff;
import com.xsjsglxt.domain.DTO.Case.BreakecaseInformationDTO;

public class page_list_staffInformationVO {
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
		private String staff_name;//姓名
		private String staff_sex;//性别
		private String staff_politicalStatus;//政治面貌
		private List<xsjsglxt_staff> listStaff;
		
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
		public String getStaff_name() {
			return staff_name;
		}
		public void setStaff_name(String staff_name) {
			this.staff_name = staff_name;
		}
		public String getStaff_sex() {
			return staff_sex;
		}
		public void setStaff_sex(String staff_sex) {
			this.staff_sex = staff_sex;
		}
		public String getStaff_politicalStatus() {
			return staff_politicalStatus;
		}
		public void setStaff_politicalStatus(String staff_politicalStatus) {
			this.staff_politicalStatus = staff_politicalStatus;
		}
		
		public List<xsjsglxt_staff> getListStaff() {
			return listStaff;
		}
		public void setListStaff(List<xsjsglxt_staff> listStaff) {
			this.listStaff = listStaff;
		}
		@Override
		public String toString() {
			return "page_list_staffInformationVO [pageIndex=" + pageIndex + ", totalRecords=" + totalRecords
					+ ", pageSize=" + pageSize + ", totalPages=" + totalPages + ", HavePrePage=" + HavePrePage
					+ ", HaveNextPage=" + HaveNextPage + ", start_time=" + start_time + ", stop_time=" + stop_time
					+ ", staff_name=" + staff_name + ", staff_sex=" + staff_sex + ", staff_politicalStatus="
					+ staff_politicalStatus + ", listStaff=" + listStaff + "]";
		}
		
		
}
