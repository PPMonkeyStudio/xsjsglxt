package com.xsjsglxt.domain.DTO.Case;

import com.xsjsglxt.domain.DO.xsjsglxt_case;
import com.xsjsglxt.domain.DO.xsjsglxt_circulation;
import com.xsjsglxt.domain.DO.xsjsglxt_resevidence;
import com.xsjsglxt.domain.DO.xsjsglxt_snece;

public class ResevidenceInformationDTO {
private xsjsglxt_resevidence resevidence ;
private xsjsglxt_case Case;
private xsjsglxt_snece sence;
private xsjsglxt_circulation circulation;
public xsjsglxt_resevidence getResevidence() {
	return resevidence;
}
public void setResevidence(xsjsglxt_resevidence resevidence) {
	this.resevidence = resevidence;
}
public xsjsglxt_case getCase() {
	return Case;
}
public void setCase(xsjsglxt_case case1) {
	Case = case1;
}
public xsjsglxt_snece getSence() {
	return sence;
}
public void setSence(xsjsglxt_snece sence) {
	this.sence = sence;
}

public xsjsglxt_circulation getCirculation() {
	return circulation;
}
public void setCirculation(xsjsglxt_circulation circulation) {
	this.circulation = circulation;
}

public ResevidenceInformationDTO(xsjsglxt_resevidence resevidence, xsjsglxt_case case1, xsjsglxt_snece sence,
		xsjsglxt_circulation circulation) {
	
	this.resevidence = resevidence;
	Case = case1;
	this.sence = sence;
	this.circulation = circulation;
}
@Override
public String toString() {
	return "ResevidenceInformationDTO [resevidence=" + resevidence + ", Case=" + Case + ", sence=" + sence
			+ ", circulation=" + circulation + "]";
}


}
