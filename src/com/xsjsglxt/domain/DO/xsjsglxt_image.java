package com.xsjsglxt.domain.DO;

public class xsjsglxt_image {
	
private String xsjsglxt_image_id;//影像光盘ID

private String image_number;//影像光盘编号

private String image_remarks;//备注

private String image_gmt_create;//创建时间

private String image_gmt_modified;//修改时间

public xsjsglxt_image() {

	// TODO Auto-generated constructor stub
}



public xsjsglxt_image(String xsjsglxt_image_id, String image_number, String image_remarks, String image_gmt_create,
		String image_gmt_modified) {

	this.xsjsglxt_image_id = xsjsglxt_image_id;
	this.image_number = image_number;
	this.image_remarks = image_remarks;
	this.image_gmt_create = image_gmt_create;
	this.image_gmt_modified = image_gmt_modified;
}




@Override
public String toString() {
	return "xsjsglxt_image [xsjsglxt_image_id=" + xsjsglxt_image_id + ", image_number=" + image_number
			+ ", image_remarks=" + image_remarks + ", image_gmt_create=" + image_gmt_create + ", image_gmt_modified="
			+ image_gmt_modified + "]";
}



public String getXsjsglxt_image_id() {
	return xsjsglxt_image_id;
}

public void setXsjsglxt_image_id(String xsjsglxt_image_id) {
	this.xsjsglxt_image_id = xsjsglxt_image_id;
}

public String getImage_remarks() {
	return image_remarks;
}

public void setImage_remarks(String image_remarks) {
	this.image_remarks = image_remarks;
}

public String getImage_gmt_create() {
	return image_gmt_create;
}

public void setImage_gmt_create(String image_gmt_create) {
	this.image_gmt_create = image_gmt_create;
}

public String getImage_gmt_modified() {
	return image_gmt_modified;
}

public void setImage_gmt_modified(String image_gmt_modified) {
	this.image_gmt_modified = image_gmt_modified;
}



public String getImage_number() {
	return image_number;
}



public void setImage_number(String image_number) {
	this.image_number = image_number;
}


}
