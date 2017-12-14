package com.xsjsglxt.domain.VO.Case;

import java.util.List;

import com.xsjsglxt.domain.DO.xsjsglxt_handle;
import com.xsjsglxt.domain.DTO.Case.ImageInformationDTO;

public class page_list_HandleInformationVO {
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
		//拘留起始时间
		private String handle_StartTimeaOfDetention_start_time= "0000-00-00";
		private String handle_StartTimeaOfDetention_stop_time = "9999-99-99";
		//逮捕时间
		private String handle_arrestTime_start_time= "0000-00-00";
		private String handle_arrestTime_stop_time = "9999-99-99";
		//起诉时间
		private String handle_prosecuteTime_start_time= "0000-00-00";
		private String handle_prosecuteTime_stop_time = "9999-99-99";
		//退查时间
		private String handle_checkbackTime_start_time= "0000-00-00";
		private String handle_checkbackTime_stop_time = "9999-99-99";
		//取保候审时间
		private String handle_pbatTime_start_time= "0000-00-00";
		private String handle_pbatTime_stop_time = "9999-99-99";
		//监视居住时间
		private String handle_lhusTime_start_time= "0000-00-00";
		private String handle_lhusTime_stop_time = "9999-99-99";
		//拘留天数
		private String handle_detentionDay;
		//行政案件名称
		private String handle_administrativeCase;
		//中队长
		private String handle_squadronleader;
		//办案民警
		private String handle_PoliceInHandlingCases;
		
		private List<xsjsglxt_handle> listHandle;
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
		public String getHandle_StartTimeaOfDetention_start_time() {
			return handle_StartTimeaOfDetention_start_time;
		}
		public void setHandle_StartTimeaOfDetention_start_time(String handle_StartTimeaOfDetention_start_time) {
			this.handle_StartTimeaOfDetention_start_time = handle_StartTimeaOfDetention_start_time;
		}
		public String getHandle_StartTimeaOfDetention_stop_time() {
			return handle_StartTimeaOfDetention_stop_time;
		}
		public void setHandle_StartTimeaOfDetention_stop_time(String handle_StartTimeaOfDetention_stop_time) {
			this.handle_StartTimeaOfDetention_stop_time = handle_StartTimeaOfDetention_stop_time;
		}
		public String getHandle_arrestTime_start_time() {
			return handle_arrestTime_start_time;
		}
		public void setHandle_arrestTime_start_time(String handle_arrestTime_start_time) {
			this.handle_arrestTime_start_time = handle_arrestTime_start_time;
		}
		public String getHandle_arrestTime_stop_time() {
			return handle_arrestTime_stop_time;
		}
		public void setHandle_arrestTime_stop_time(String handle_arrestTime_stop_time) {
			this.handle_arrestTime_stop_time = handle_arrestTime_stop_time;
		}
		public String getHandle_prosecuteTime_start_time() {
			return handle_prosecuteTime_start_time;
		}
		public void setHandle_prosecuteTime_start_time(String handle_prosecuteTime_start_time) {
			this.handle_prosecuteTime_start_time = handle_prosecuteTime_start_time;
		}
		public String getHandle_prosecuteTime_stop_time() {
			return handle_prosecuteTime_stop_time;
		}
		public void setHandle_prosecuteTime_stop_time(String handle_prosecuteTime_stop_time) {
			this.handle_prosecuteTime_stop_time = handle_prosecuteTime_stop_time;
		}
		public String getHandle_checkbackTime_start_time() {
			return handle_checkbackTime_start_time;
		}
		public void setHandle_checkbackTime_start_time(String handle_checkbackTime_start_time) {
			this.handle_checkbackTime_start_time = handle_checkbackTime_start_time;
		}
		public String getHandle_checkbackTime_stop_time() {
			return handle_checkbackTime_stop_time;
		}
		public void setHandle_checkbackTime_stop_time(String handle_checkbackTime_stop_time) {
			this.handle_checkbackTime_stop_time = handle_checkbackTime_stop_time;
		}
		public String getHandle_pbatTime_start_time() {
			return handle_pbatTime_start_time;
		}
		public void setHandle_pbatTime_start_time(String handle_pbatTime_start_time) {
			this.handle_pbatTime_start_time = handle_pbatTime_start_time;
		}
		public String getHandle_pbatTime_stop_time() {
			return handle_pbatTime_stop_time;
		}
		public void setHandle_pbatTime_stop_time(String handle_pbatTime_stop_time) {
			this.handle_pbatTime_stop_time = handle_pbatTime_stop_time;
		}
		public String getHandle_lhusTime_start_time() {
			return handle_lhusTime_start_time;
		}
		public void setHandle_lhusTime_start_time(String handle_lhusTime_start_time) {
			this.handle_lhusTime_start_time = handle_lhusTime_start_time;
		}
		public String getHandle_lhusTime_stop_time() {
			return handle_lhusTime_stop_time;
		}
		public void setHandle_lhusTime_stop_time(String handle_lhusTime_stop_time) {
			this.handle_lhusTime_stop_time = handle_lhusTime_stop_time;
		}
		public String getHandle_detentionDay() {
			return handle_detentionDay;
		}
		public void setHandle_detentionDay(String handle_detentionDay) {
			this.handle_detentionDay = handle_detentionDay;
		}
		public String getHandle_administrativeCase() {
			return handle_administrativeCase;
		}
		public void setHandle_administrativeCase(String handle_administrativeCase) {
			this.handle_administrativeCase = handle_administrativeCase;
		}
		public String getHandle_squadronleader() {
			return handle_squadronleader;
		}
		public void setHandle_squadronleader(String handle_squadronleader) {
			this.handle_squadronleader = handle_squadronleader;
		}
		public String getHandle_PoliceInHandlingCases() {
			return handle_PoliceInHandlingCases;
		}
		public void setHandle_PoliceInHandlingCases(String handle_PoliceInHandlingCases) {
			this.handle_PoliceInHandlingCases = handle_PoliceInHandlingCases;
		}
		
		public List<xsjsglxt_handle> getListHandle() {
			return listHandle;
		}
		public void setListHandle(List<xsjsglxt_handle> listHandle) {
			this.listHandle = listHandle;
		}
		@Override
		public String toString() {
			return "page_list_HandleInformationVO [pageIndex=" + pageIndex + ", totalRecords=" + totalRecords
					+ ", pageSize=" + pageSize + ", totalPages=" + totalPages + ", HavePrePage=" + HavePrePage
					+ ", HaveNextPage=" + HaveNextPage + ", handle_StartTimeaOfDetention_start_time="
					+ handle_StartTimeaOfDetention_start_time + ", handle_StartTimeaOfDetention_stop_time="
					+ handle_StartTimeaOfDetention_stop_time + ", handle_arrestTime_start_time="
					+ handle_arrestTime_start_time + ", handle_arrestTime_stop_time=" + handle_arrestTime_stop_time
					+ ", handle_prosecuteTime_start_time=" + handle_prosecuteTime_start_time
					+ ", handle_prosecuteTime_stop_time=" + handle_prosecuteTime_stop_time
					+ ", handle_checkbackTime_start_time=" + handle_checkbackTime_start_time
					+ ", handle_checkbackTime_stop_time=" + handle_checkbackTime_stop_time
					+ ", handle_pbatTime_start_time=" + handle_pbatTime_start_time + ", handle_pbatTime_stop_time="
					+ handle_pbatTime_stop_time + ", handle_lhusTime_start_time=" + handle_lhusTime_start_time
					+ ", handle_lhusTime_stop_time=" + handle_lhusTime_stop_time + ", handle_detentionDay="
					+ handle_detentionDay + ", handle_administrativeCase=" + handle_administrativeCase
					+ ", handle_squadronleader=" + handle_squadronleader + ", handle_PoliceInHandlingCases="
					+ handle_PoliceInHandlingCases + ", listHandle=" + listHandle + "]";
		}
		
		
}
