package com.xsjsglxt.domain.VO.Case;

import java.util.List;

import com.xsjsglxt.domain.DO.xsjsglxt_parallel;

public class page_list_parallelInformationVO {
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
			
			private String parallel_casename;//��������
			
			private String parallel_person;//������
			
			private String parallel_num;
			
			private String parallel_date;
			
			private String parallel_breakecaseSituation;
			//升序/降序
			private String order;
			
			private List<xsjsglxt_parallel> parallelList;

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

			public String getParallel_casename() {
				return parallel_casename;
			}

			public void setParallel_casename(String parallel_casename) {
				this.parallel_casename = parallel_casename;
			}

			public String getParallel_person() {
				return parallel_person;
			}

			public void setParallel_person(String parallel_person) {
				this.parallel_person = parallel_person;
			}

			public List<xsjsglxt_parallel> getParallelList() {
				return parallelList;
			}

			public void setParallelList(List<xsjsglxt_parallel> parallelList) {
				this.parallelList = parallelList;
			}

			public String getParallel_num() {
				return parallel_num;
			}

			public void setParallel_num(String parallel_num) {
				this.parallel_num = parallel_num;
			}

			public String getParallel_date() {
				return parallel_date;
			}

			public void setParallel_date(String parallel_date) {
				this.parallel_date = parallel_date;
			}

			public String getParallel_breakecaseSituation() {
				return parallel_breakecaseSituation;
			}

			public void setParallel_breakecaseSituation(String parallel_breakecaseSituation) {
				this.parallel_breakecaseSituation = parallel_breakecaseSituation;
			}

			public String getOrder() {
				return order;
			}

			public void setOrder(String order) {
				this.order = order;
			}

			@Override
			public String toString() {
				return "page_list_parallelInformationVO [pageIndex=" + pageIndex + ", totalRecords=" + totalRecords
						+ ", pageSize=" + pageSize + ", totalPages=" + totalPages + ", HavePrePage=" + HavePrePage
						+ ", HaveNextPage=" + HaveNextPage + ", start_time=" + start_time + ", stop_time=" + stop_time
						+ ", parallel_casename=" + parallel_casename + ", parallel_person=" + parallel_person
						+ ", parallel_num=" + parallel_num + ", parallel_date=" + parallel_date
						+ ", parallel_breakecaseSituation=" + parallel_breakecaseSituation + ", order=" + order
						+ ", parallelList=" + parallelList + "]";
			}

			

		
			
}
