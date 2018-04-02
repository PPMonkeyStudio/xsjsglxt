package com.xsjsglxt.domain.VO.Team;

import java.util.List;

import com.xsjsglxt.domain.DTO.Team.policemanListDTO;

public class policemanListVO {
	private int totalPage; // 总页数
	private int currPage;// 当前页数
	private int totalCount;// 总记录数
	private int pageCount;// 一页显示条数
	private String inPoliceTimeSort = "desc"; // 入警时间排序
	private String policemanName; // 警员名字查询
	private String policemanSex;// 警员性别查询
	private String politicalStatus; // 警员政治面貌
	private List<policemanListDTO> policemans;

	public List<policemanListDTO> getPolicemans() {
		return policemans;
	}

	public void setPolicemans(List<policemanListDTO> policemans) {
		this.policemans = policemans;
	}

	public String getInPoliceTimeSort() {
		return inPoliceTimeSort;
	}

	public void setInPoliceTimeSort(String inPoliceTimeSort) {
		this.inPoliceTimeSort = inPoliceTimeSort;
	}

	public String getPolicemanName() {
		return policemanName;
	}

	public void setPolicemanName(String policemanName) {
		this.policemanName = policemanName;
	}

	public String getPolicemanSex() {
		return policemanSex;
	}

	public void setPolicemanSex(String policemanSex) {
		this.policemanSex = policemanSex;
	}

	public String getPoliticalStatus() {
		return politicalStatus;
	}

	public void setPoliticalStatus(String politicalStatus) {
		this.politicalStatus = politicalStatus;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getCurrPage() {
		return currPage;
	}

	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

}
