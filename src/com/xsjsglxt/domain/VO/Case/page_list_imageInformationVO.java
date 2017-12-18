package com.xsjsglxt.domain.VO.Case;

import java.util.List;

import com.xsjsglxt.domain.DTO.Case.ImageInformationDTO;

public class page_list_imageInformationVO {
	 // 首页
	private int pageIndex = 1;
    //总记录数
	private int totalRecords = 0;
    //每页的记录数
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
	
private String image_number;//光盘编号
private String picture_identifier;//照片编号
private List<ImageInformationDTO> ImageInformationDTOList;
public String getImage_number() {
	return image_number;
}
public void setImage_number(String image_number) {
	this.image_number = image_number;
}
public String getPicture_identifier() {
	return picture_identifier;
}
public void setPicture_identifier(String picture_identifier) {
	this.picture_identifier = picture_identifier;
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


public List<ImageInformationDTO> getImageInformationDTOList() {
	return ImageInformationDTOList;
}
public void setImageInformationDTOList(List<ImageInformationDTO> imageInformationDTOList) {
	ImageInformationDTOList = imageInformationDTOList;
}
@Override
public String toString() {
	return "page_list_imageInformationVO [pageIndex=" + pageIndex + ", totalRecords=" + totalRecords + ", pageSize="
			+ pageSize + ", totalPages=" + totalPages + ", HavePrePage=" + HavePrePage + ", HaveNextPage="
			+ HaveNextPage + ", start_time=" + start_time + ", stop_time=" + stop_time + ", image_number="
			+ image_number + ", picture_identifier=" + picture_identifier + ", ImageInformationDTOList="
			+ ImageInformationDTOList + "]";
}



}
