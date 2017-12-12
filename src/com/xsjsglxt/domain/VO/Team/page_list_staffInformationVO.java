package com.xsjsglxt.domain.VO.Team;

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
}
