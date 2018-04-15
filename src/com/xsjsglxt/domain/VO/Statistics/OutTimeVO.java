package com.xsjsglxt.domain.VO.Statistics;

import java.util.List;

import com.xsjsglxt.domain.DTO.Statistics.policemanOutTimesDTO;

public class OutTimeVO {
	private String policemanName;// 警员姓名
	private String timeStart;// 接警时间开始
	private String timeEnd;// 接警时间结束
	private int currPage; // 当前页数
	private int totalPage; // 总页数
	private int totalCount; // 总记录数
	private int pageSize; // 一页显示记录数
	private List<policemanOutTimesDTO> policemanOutDTOList;

	@Override
	public String toString() {
		return "OutTimeVO [policemanName=" + policemanName + ", timeStart=" + timeStart + ", timeEnd=" + timeEnd
				+ ", currPage=" + currPage + ", totalPage=" + totalPage + ", totalCount=" + totalCount + ", pageSize="
				+ pageSize + ", policemanOutDTOList=" + policemanOutDTOList + "]";
	}

	public List<policemanOutTimesDTO> getPolicemanOutDTOList() {
		return policemanOutDTOList;
	}

	public void setPolicemanOutDTOList(List<policemanOutTimesDTO> policemanOutDTOList) {
		this.policemanOutDTOList = policemanOutDTOList;
	}

	/**
	 * @return the currPage
	 */
	public int getCurrPage() {
		return currPage;
	}

	/**
	 * @param currPage the currPage to set
	 */
	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}

	/**
	 * @return the totalPage
	 */
	public int getTotalPage() {
		return totalPage;
	}

	/**
	 * @param totalPage the totalPage to set
	 */
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	/**
	 * @return the totalCount
	 */
	public int getTotalCount() {
		return totalCount;
	}

	/**
	 * @param totalCount the totalCount to set
	 */
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	/**
	 * @return the pageSize
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * @param pageSize the pageSize to set
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getPolicemanName() {
		return policemanName;
	}

	public void setPolicemanName(String policemanName) {
		this.policemanName = policemanName;
	}

	public String getTimeStart() {
		return timeStart;
	}

	public void setTimeStart(String timeStart) {
		this.timeStart = timeStart;
	}

	public String getTimeEnd() {
		return timeEnd;
	}

	public void setTimeEnd(String timeEnd) {
		this.timeEnd = timeEnd;
	}

}
