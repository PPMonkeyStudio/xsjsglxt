package com.xsjsglxt.domain.DTO.Case;

import java.util.List;

import com.xsjsglxt.domain.DO.xsjsglxt_briefdetails;
import com.xsjsglxt.domain.DO.xsjsglxt_case;
import com.xsjsglxt.domain.DO.xsjsglxt_lost;
import com.xsjsglxt.domain.DO.xsjsglxt_lost_computer;
import com.xsjsglxt.domain.DO.xsjsglxt_lost_mobilephone;
import com.xsjsglxt.domain.DO.xsjsglxt_picture;
import com.xsjsglxt.domain.DO.xsjsglxt_resevidence;
import com.xsjsglxt.domain.DO.xsjsglxt_snece;

public class SenceInformationAllDTO {
private xsjsglxt_briefdetails briefdetails;
private xsjsglxt_case case1;
private List<xsjsglxt_lost_computer> lost_computer;
private List<xsjsglxt_lost_mobilephone> lost_mobilephone;
private List<xsjsglxt_lost> lost;
private List<xsjsglxt_picture> picture ;
private xsjsglxt_snece sence;
private List<xsjsglxt_resevidence> resevidence;


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
public List<xsjsglxt_lost_computer> getLost_computer() {
	return lost_computer;
}
public void setLost_computer(List<xsjsglxt_lost_computer> lost_computer) {
	this.lost_computer = lost_computer;
}
public List<xsjsglxt_lost_mobilephone> getLost_mobilephone() {
	return lost_mobilephone;
}
public void setLost_mobilephone(List<xsjsglxt_lost_mobilephone> lost_mobilephone) {
	this.lost_mobilephone = lost_mobilephone;
}
public List<xsjsglxt_lost> getLost() {
	return lost;
}
public void setLost(List<xsjsglxt_lost> lost) {
	this.lost = lost;
}
public List<xsjsglxt_picture> getPicture() {
	return picture;
}
public void setPicture(List<xsjsglxt_picture> picture) {
	this.picture = picture;
}
public List<xsjsglxt_resevidence> getResevidence() {
	return resevidence;
}
public void setResevidence(List<xsjsglxt_resevidence> resevidence) {
	this.resevidence = resevidence;
}
public xsjsglxt_snece getSence() {
	return sence;
}
public void setSence(xsjsglxt_snece sence) {
	this.sence = sence;
}


public SenceInformationAllDTO(xsjsglxt_briefdetails briefdetails, xsjsglxt_case case1,
		List<xsjsglxt_lost_computer> lost_computer, List<xsjsglxt_lost_mobilephone> lost_mobilephone,
		List<xsjsglxt_lost> lost, List<xsjsglxt_picture> picture, xsjsglxt_snece sence,
		List<xsjsglxt_resevidence> resevidence) {
	super();
	this.briefdetails = briefdetails;
	this.case1 = case1;
	this.lost_computer = lost_computer;
	this.lost_mobilephone = lost_mobilephone;
	this.lost = lost;
	this.picture = picture;
	this.sence = sence;
	this.resevidence = resevidence;
}
@Override
public String toString() {
	return "SenceInformationAllDTO [briefdetails=" + briefdetails + ", case1=" + case1 + ", lost_computer="
			+ lost_computer + ", lost_mobilephone=" + lost_mobilephone + ", lost=" + lost + ", picture=" + picture
			+ ", sence=" + sence + ", resevidence=" + resevidence + "]";
}
}
