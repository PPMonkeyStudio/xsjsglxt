package com.xsjsglxt.domain.DTO.Case;

import com.xsjsglxt.domain.DO.xsjsglxt_case;
import com.xsjsglxt.domain.DO.xsjsglxt_resevidence;
import com.xsjsglxt.domain.DO.xsjsglxt_snece;

public class ResevidenceInformationDTO {
private xsjsglxt_resevidence resevidence ;
private xsjsglxt_case Case;
private xsjsglxt_snece sence;
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
public ResevidenceInformationDTO(xsjsglxt_resevidence resevidence, xsjsglxt_case case1, xsjsglxt_snece sence) {

	this.resevidence = resevidence;
	Case = case1;
	this.sence = sence;
}
@Override
public String toString() {
	return "ResevidenceInformationDTO [resevidence=" + resevidence + ", Case=" + Case + ", sence=" + sence + "]";
}


}
