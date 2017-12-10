package com.xsjsglxt.domain.DTO.Case;

import com.xsjsglxt.domain.DO.xsjsglxt_case;
import com.xsjsglxt.domain.DO.xsjsglxt_image;
import com.xsjsglxt.domain.DO.xsjsglxt_picture;

public class ImageInformationDTO {
private xsjsglxt_case case1;
private xsjsglxt_image image;
private xsjsglxt_picture picture;
public xsjsglxt_case getCase1() {
	return case1;
}
public void setCase1(xsjsglxt_case case1) {
	this.case1 = case1;
}
public xsjsglxt_image getImage() {
	return image;
}
public void setImage(xsjsglxt_image image) {
	this.image = image;
}
public xsjsglxt_picture getPicture() {
	return picture;
}
public void setPicture(xsjsglxt_picture picture) {
	this.picture = picture;
}
public ImageInformationDTO(xsjsglxt_case case1, xsjsglxt_image image, xsjsglxt_picture picture) {

	this.case1 = case1;
	this.image = image;
	this.picture = picture;
}
@Override
public String toString() {
	return "ImageInformationDTO [case1=" + case1 + ", image=" + image + ", picture=" + picture + "]";
}


}
