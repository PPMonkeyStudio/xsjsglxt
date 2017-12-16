package com.xsjsglxt.domain.DTO.Case;

import com.xsjsglxt.domain.DO.xsjsglxt_briefdetails;
import com.xsjsglxt.domain.DO.xsjsglxt_case;
import com.xsjsglxt.domain.DO.xsjsglxt_lost;
import com.xsjsglxt.domain.DO.xsjsglxt_lost_computer;
import com.xsjsglxt.domain.DO.xsjsglxt_lost_mobilephone;
import com.xsjsglxt.domain.DO.xsjsglxt_picture;
import com.xsjsglxt.domain.DO.xsjsglxt_resevidence;
import com.xsjsglxt.domain.DO.xsjsglxt_snece;

public class SenceInformationDTO {
private xsjsglxt_briefdetails briefdetails;
private xsjsglxt_case case1;
//private xsjsglxt_lost_computer lost_computer;
//private xsjsglxt_lost_mobilephone lost_mobilephone;
//private xsjsglxt_lost lost;
private xsjsglxt_picture picture ;
private xsjsglxt_snece sence;
private xsjsglxt_resevidence resevidence;

public xsjsglxt_resevidence getResevidence() {
	return resevidence;
}
public void setResevidence(xsjsglxt_resevidence resevidence) {
	this.resevidence = resevidence;
}
public xsjsglxt_briefdetails getBriefdetails() {
	return briefdetails;
}
public void setBriefdetails(xsjsglxt_briefdetails briefdetails) {
	this.briefdetails = briefdetails;
}

public xsjsglxt_case getCase1() {
	return case1;
}
public void setCase1(xsjsglxt_case case1) {
	this.case1 = case1;
}
//public xsjsglxt_lost_computer getLost_computer() {
//	return lost_computer;
//}
//public void setLost_computer(xsjsglxt_lost_computer lost_computer) {
//	this.lost_computer = lost_computer;
//}
//public xsjsglxt_lost_mobilephone getLost_mobilephone() {
//	return lost_mobilephone;
//}
//public void setLost_mobilephone(xsjsglxt_lost_mobilephone lost_mobilephone) {
//	this.lost_mobilephone = lost_mobilephone;
//}
//public xsjsglxt_lost getLost() {
//	return lost;
//}
//public void setLost(xsjsglxt_lost lost) {
//	this.lost = lost;
//}
public xsjsglxt_picture getPicture() {
	return picture;
}
public void setPicture(xsjsglxt_picture picture) {
	this.picture = picture;
}
public xsjsglxt_snece getSence() {
	return sence;
}
public void setSence(xsjsglxt_snece sence) {
	this.sence = sence;
}




public SenceInformationDTO(xsjsglxt_briefdetails briefdetails, xsjsglxt_case case1, xsjsglxt_picture picture,
		xsjsglxt_snece sence, xsjsglxt_resevidence resevidence) {
	
	this.briefdetails = briefdetails;
	this.case1 = case1;
	this.picture = picture;
	this.sence = sence;
	this.resevidence = resevidence;
}
@Override
public String toString() {
	return "SenceInformationDTO [briefdetails=" + briefdetails + ", case1=" + case1 + ", picture=" + picture
			+ ", sence=" + sence + ", resevidence=" + resevidence + "]";
}




}
