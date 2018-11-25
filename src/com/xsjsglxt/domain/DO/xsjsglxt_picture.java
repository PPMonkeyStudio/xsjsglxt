package com.xsjsglxt.domain.DO;

//照片表
public class xsjsglxt_picture {

	private String xsjsglxt_picture_id;// 照片ID

	private String picture_image;// 所属影像光盘

	private String picture_case;// 所属案件

	private String picture_identifier;// 照片编号

	private String picture_remarks;// 备注

	private String picture_gmt_create;// 创建时间

	private String picture_gmt_modified;// 修改时间

	public xsjsglxt_picture() {

		// TODO Auto-generated constructor stub
	}

	public xsjsglxt_picture(String xsjsglxt_picture_id, String picture_image, String picture_case,
			String picture_identifier, String picture_remarks, String picture_gmt_create, String picture_gmt_modified) {

		this.xsjsglxt_picture_id = xsjsglxt_picture_id;
		this.picture_image = picture_image;
		this.picture_case = picture_case;
		this.picture_identifier = picture_identifier;
		this.picture_remarks = picture_remarks;
		this.picture_gmt_create = picture_gmt_create;
		this.picture_gmt_modified = picture_gmt_modified;
	}

	@Override
	public String toString() {
		return "picture [xsjsglxt_picture_id=" + xsjsglxt_picture_id + ", picture_image=" + picture_image
				+ ", picture_case=" + picture_case + ", picture_identifier=" + picture_identifier + ", picture_remarks="
				+ picture_remarks + ", picture_gmt_create=" + picture_gmt_create + ", picture_gmt_modified="
				+ picture_gmt_modified + "]";
	}

	public String getXsjsglxt_picture_id() {
		return xsjsglxt_picture_id;
	}

	public void setXsjsglxt_picture_id(String xsjsglxt_picture_id) {
		this.xsjsglxt_picture_id = xsjsglxt_picture_id;
	}

	public String getPicture_image() {
		return picture_image;
	}

	public void setPicture_image(String picture_image) {
		this.picture_image = picture_image;
	}

	public String getPicture_case() {
		return picture_case;
	}

	public void setPicture_case(String picture_case) {
		this.picture_case = picture_case;
	}

	public String getPicture_identifier() {
		return picture_identifier;
	}

	public void setPicture_identifier(String picture_identifier) {
		this.picture_identifier = picture_identifier;
	}

	public String getPicture_remarks() {
		return picture_remarks;
	}

	public void setPicture_remarks(String picture_remarks) {
		this.picture_remarks = picture_remarks;
	}

	public String getPicture_gmt_create() {
		return picture_gmt_create;
	}

	public void setPicture_gmt_create(String picture_gmt_create) {
		this.picture_gmt_create = picture_gmt_create;
	}

	public String getPicture_gmt_modified() {
		return picture_gmt_modified;
	}

	public void setPicture_gmt_modified(String picture_gmt_modified) {
		this.picture_gmt_modified = picture_gmt_modified;
	}

}
