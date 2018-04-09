package com.xsjsglxt.domain.DTO.Case;

import com.xsjsglxt.domain.DO.xsjsglxt_breakcase;
import com.xsjsglxt.domain.DO.xsjsglxt_breakecase;
import com.xsjsglxt.domain.DO.xsjsglxt_case;
import com.xsjsglxt.domain.DO.xsjsglxt_snece;

public class BreakecaseInformationDTO {
private xsjsglxt_breakcase breakCase;//破案表
private xsjsglxt_breakecase breakecase;//旧破案表
private xsjsglxt_snece sence;//现场勘验表
private xsjsglxt_case case1;//案件表
public xsjsglxt_snece getSence() {
	return sence;
}
public void setSence(xsjsglxt_snece sence) {
	this.sence = sence;
}
public xsjsglxt_case getCase1() {
	return case1;
}
public void setCase1(xsjsglxt_case case1) {
	this.case1 = case1;
}
@Override
public String toString() {
	return "BreakecaseInformationDTO [breakCase=" + breakCase + ", sence=" + sence + ", case1=" + case1 + "]";
}
public BreakecaseInformationDTO(xsjsglxt_breakcase breakCase, xsjsglxt_snece sence, xsjsglxt_case case1) {
	this.breakCase = breakCase;
	this.sence = sence;
	this.case1 = case1;
}
public BreakecaseInformationDTO(xsjsglxt_breakecase breakecase, xsjsglxt_snece sence2, xsjsglxt_case case12) {
	this.breakecase = breakecase;
	this.sence = sence2;
	this.case1 = case12;
}
public xsjsglxt_breakcase getBreakCase() {
	return breakCase;
}
public void setBreakCase(xsjsglxt_breakcase breakCase) {
	this.breakCase = breakCase;
}
public xsjsglxt_breakecase getBreakecase() {
	return breakecase;
}
public void setBreakecase(xsjsglxt_breakecase breakecase) {
	this.breakecase = breakecase;
}

}
