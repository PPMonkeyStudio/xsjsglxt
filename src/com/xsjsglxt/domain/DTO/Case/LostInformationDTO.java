package com.xsjsglxt.domain.DTO.Case;

import com.xsjsglxt.domain.DO.xsjsglxt_case;
import com.xsjsglxt.domain.DO.xsjsglxt_lost;
import com.xsjsglxt.domain.DO.xsjsglxt_snece;

public class LostInformationDTO {
private xsjsglxt_case case1;

private xsjsglxt_snece snece;

private  xsjsglxt_lost lost;



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

public xsjsglxt_lost getLost() {
	return lost;
}

public void setLost(xsjsglxt_lost lost) {
	this.lost = lost;
}


public LostInformationDTO(xsjsglxt_case case1, xsjsglxt_snece snece, xsjsglxt_lost lost) {

	this.case1 = case1;
	this.snece = snece;
	this.lost = lost;
}

@Override
public String toString() {
	return "LostInformationDTO [case1=" + case1 + ", snece=" + snece + ", lost=" + lost + "]";
}




}
