package com.xsjsglxt.domain.VO.Case;

import java.util.List;

import com.xsjsglxt.domain.DTO.Case.LostComputerInformationDTO;
import com.xsjsglxt.domain.DTO.Case.LostInformationDTO;
import com.xsjsglxt.domain.DTO.Case.LostMobilephoneInformationDTO;

public class page_list_CasematerialVO {
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
			
			  private String lost_name; //损失物品名称
			  
			  private String lost_mobilephone_phone;//手机号码
			  private String lost_mobilephone_feature;//手机特征
			  private String  lost_mobilephone_IMEI;//手机串号
			  
			  private String lost_computer_brand;//电脑品牌
			  private String lost_computer_internetAccount;//上网账号
			  private String lost_computer_MAC;//MAC地址
			  
			  private List<LostInformationDTO> LostInformationDTOList;//损失物品表
			  
			  private List<LostMobilephoneInformationDTO> LostMobilephoneInformationDTOList;//损失手机表
			
			  private List<LostComputerInformationDTO> LostComputerInformationDTOList;//损失电脑表
			  
			  public List<LostInformationDTO> getLostInformationDTOList() {
				return LostInformationDTOList;
			}
			public void setLostInformationDTOList(List<LostInformationDTO> lostInformationDTOList) {
				LostInformationDTOList = lostInformationDTOList;
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
			public String getLost_name() {
				return lost_name;
			}
			public void setLost_name(String lost_name) {
				this.lost_name = lost_name;
			}
			public String getLost_mobilephone_phone() {
				return lost_mobilephone_phone;
			}
			public void setLost_mobilephone_phone(String lost_mobilephone_phone) {
				this.lost_mobilephone_phone = lost_mobilephone_phone;
			}
			public String getLost_mobilephone_feature() {
				return lost_mobilephone_feature;
			}
			public void setLost_mobilephone_feature(String lost_mobilephone_feature) {
				this.lost_mobilephone_feature = lost_mobilephone_feature;
			}
			public String getLost_mobilephone_IMEI() {
				return lost_mobilephone_IMEI;
			}
			public void setLost_mobilephone_IMEI(String lost_mobilephone_IMEI) {
				this.lost_mobilephone_IMEI = lost_mobilephone_IMEI;
			}
			public String getLost_computer_brand() {
				return lost_computer_brand;
			}
			public void setLost_computer_brand(String lost_computer_brand) {
				this.lost_computer_brand = lost_computer_brand;
			}
			public String getLost_computer_internetAccount() {
				return lost_computer_internetAccount;
			}
			public void setLost_computer_internetAccount(String lost_computer_internetAccount) {
				this.lost_computer_internetAccount = lost_computer_internetAccount;
			}
			public String getLost_computer_MAC() {
				return lost_computer_MAC;
			}
			public void setLost_computer_MAC(String lost_computer_MAC) {
				this.lost_computer_MAC = lost_computer_MAC;
			}
			
			public List<LostMobilephoneInformationDTO> getLostMobilephoneInformationDTOList() {
				return LostMobilephoneInformationDTOList;
			}
			public void setLostMobilephoneInformationDTOList(
					List<LostMobilephoneInformationDTO> lostMobilephoneInformationDTOList) {
				LostMobilephoneInformationDTOList = lostMobilephoneInformationDTOList;
			}
			
			public List<LostComputerInformationDTO> getLostComputerInformationDTOList() {
				return LostComputerInformationDTOList;
			}
			public void setLostComputerInformationDTOList(List<LostComputerInformationDTO> lostComputerInformationDTOList) {
				LostComputerInformationDTOList = lostComputerInformationDTOList;
			}
			@Override
			public String toString() {
				return "page_list_CasematerialVO [pageIndex=" + pageIndex + ", totalRecords=" + totalRecords
						+ ", pageSize=" + pageSize + ", totalPages=" + totalPages + ", HavePrePage=" + HavePrePage
						+ ", HaveNextPage=" + HaveNextPage + ", lost_name=" + lost_name + ", lost_mobilephone_phone="
						+ lost_mobilephone_phone + ", lost_mobilephone_feature=" + lost_mobilephone_feature
						+ ", lost_mobilephone_IMEI=" + lost_mobilephone_IMEI + ", lost_computer_brand="
						+ lost_computer_brand + ", lost_computer_internetAccount=" + lost_computer_internetAccount
						+ ", lost_computer_MAC=" + lost_computer_MAC + ", LostInformationDTOList="
						+ LostInformationDTOList + ", LostMobilephoneInformationDTOList="
						+ LostMobilephoneInformationDTOList + ", LostComputerInformationDTOList="
						+ LostComputerInformationDTOList + "]";
			}
			
			  
			  
}
