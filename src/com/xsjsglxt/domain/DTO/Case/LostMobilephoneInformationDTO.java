package com.xsjsglxt.domain.DTO.Case;

import com.xsjsglxt.domain.DO.xsjsglxt_case;
import com.xsjsglxt.domain.DO.xsjsglxt_lost_mobilephone;
import com.xsjsglxt.domain.DO.xsjsglxt_snece;

public class LostMobilephoneInformationDTO {
	private xsjsglxt_case case1;

	private xsjsglxt_snece snece;
	
	private xsjsglxt_lost_mobilephone lost_mobilephone;

	

	public LostMobilephoneInformationDTO(xsjsglxt_case case1, xsjsglxt_snece snece,
			xsjsglxt_lost_mobilephone lost_mobilephone) {
	
		this.case1 = case1;
		this.snece = snece;
		this.lost_mobilephone = lost_mobilephone;
	}

	

	public xsjsglxt_case getCase1() {
		return case1;
	}



	public void setCase1(xsjsglxt_case case1) {
		this.case1 = case1;
	}



	public xsjsglxt_snece getSnece() {
		return snece;
	}

	public void setSnece(xsjsglxt_snece snece) {
		this.snece = snece;
	}

	public xsjsglxt_lost_mobilephone getLost_mobilephone() {
		return lost_mobilephone;
	}

	public void setLost_mobilephone(xsjsglxt_lost_mobilephone lost_mobilephone) {
		this.lost_mobilephone = lost_mobilephone;
	}



	@Override
	public String toString() {
		return "LostMobilephoneInformationDTO [case1=" + case1 + ", snece=" + snece + ", lost_mobilephone="
				+ lost_mobilephone + "]";
	}

	
	
}
