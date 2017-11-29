package com.xsjsglxt.domain.DTO.Case;

import com.xsjsglxt.domain.DO.xsjsglxt_case;
import com.xsjsglxt.domain.DO.xsjsglxt_lost;
import com.xsjsglxt.domain.DO.xsjsglxt_snece;

public class LostInformationDTO {
private xsjsglxt_case Case;

private xsjsglxt_snece snece;

private  xsjsglxt_lost lost;

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

public xsjsglxt_lost getLost() {
	return lost;
}

public void setLost(xsjsglxt_lost lost) {
	this.lost = lost;
}

public LostInformationDTO(xsjsglxt_case case1, xsjsglxt_snece snece, xsjsglxt_lost lost) {
	
	Case = case1;
	this.snece = snece;
	this.lost = lost;
}

@Override
public String toString() {
	return "LostInformationDTO [Case=" + Case + ", snece=" + snece + ", lost=" + lost + "]";
}


}
