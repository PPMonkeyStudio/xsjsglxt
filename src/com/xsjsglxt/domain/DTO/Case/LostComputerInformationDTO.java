package com.xsjsglxt.domain.DTO.Case;

import com.xsjsglxt.domain.DO.xsjsglxt_case;
import com.xsjsglxt.domain.DO.xsjsglxt_lost_computer;
import com.xsjsglxt.domain.DO.xsjsglxt_snece;

public class LostComputerInformationDTO {
	private xsjsglxt_case Case;

	private xsjsglxt_snece snece;
	
	private xsjsglxt_lost_computer lost_computer ;

	public xsjsglxt_case getCase() {
		return Case;
	}

	public void setCase(xsjsglxt_case case1) {
		Case = case1;
	}

	public xsjsglxt_snece getSnece() {
		return snece;
	}

	public void setSnece(xsjsglxt_snece snece) {
		this.snece = snece;
	}

	public xsjsglxt_lost_computer getLost_computer() {
		return lost_computer;
	}

	public void setLost_computer(xsjsglxt_lost_computer lost_computer) {
		this.lost_computer = lost_computer;
	}

	public LostComputerInformationDTO(xsjsglxt_case case1, xsjsglxt_snece snece, xsjsglxt_lost_computer lost_computer) {
		
		Case = case1;
		this.snece = snece;
		this.lost_computer = lost_computer;
	}

	@Override
	public String toString() {
		return "LostComputerInformationDTO [Case=" + Case + ", snece=" + snece + ", lost_computer=" + lost_computer
				+ "]";
	}
	
	
}
