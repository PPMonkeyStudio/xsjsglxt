package com.xsjsglxt.action.Case;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.ActionSupport;
import com.xsjsglxt.domain.DO.xsjsglxt_case;
import com.xsjsglxt.domain.DO.xsjsglxt_image;
import com.xsjsglxt.domain.DO.xsjsglxt_picture;
import com.xsjsglxt.service.Case.ImageService;

public class ImageAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {
private ImageService imageService;
private HttpServletResponse http_response;
private xsjsglxt_image image;
private HttpServletRequest http_request;	
private xsjsglxt_picture picture;
private xsjsglxt_case case1;
/*
 * 保存光盘
 */
public void saveCD() throws IOException{
	try {
		
		imageService.saveCD(image);
		http_response.setContentType("text/html;charset=utf-8");
		http_response.getWriter().write("success");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		http_response.setContentType("text/html;charset=utf-8");
		http_response.getWriter().write("error");
	}
}
/*
 * 保存照片
 */
public void savePicture() throws IOException{
try {
	picture.setPicture_case(case1.getXsjsglxt_case_id());
	picture.setPicture_image(image.getXsjsglxt_image_id());
		imageService.savePicture(picture);
		http_response.setContentType("text/html;charset=utf-8");
		http_response.getWriter().write("success");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		http_response.setContentType("text/html;charset=utf-8");
		http_response.getWriter().write("error");
	}
}

/*
 * 光盘编号
 */
public void getImage_number() throws IOException {
	GsonBuilder gsonBuilder = new GsonBuilder();
	gsonBuilder.setPrettyPrinting();// ��ʽ��json����
	Gson gson = gsonBuilder.create();
	String Image_number = imageService.getMaxImage_number();
	http_response.setContentType("text/html;charset=utf-8");
	http_response.getWriter().write(gson.toJson(Image_number));
}

/*
 * 照片编号
 */
public void getPicture_identifier() throws IOException {
	GsonBuilder gsonBuilder = new GsonBuilder();
	gsonBuilder.setPrettyPrinting();// ��ʽ��json����
	Gson gson = gsonBuilder.create();
	String Picture_identifier = imageService.getMaxPicture_identifier();
	http_response.setContentType("text/html;charset=utf-8");
	http_response.getWriter().write(gson.toJson(Picture_identifier));
}
	public ImageService getImageService() {
	return imageService;
}

public void setImageService(ImageService imageService) {
	this.imageService = imageService;
}

	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
		this.http_response = arg0;
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		this.http_request = arg0;
	}
	public HttpServletResponse getHttp_response() {
		return http_response;
	}
	public void setHttp_response(HttpServletResponse http_response) {
		this.http_response = http_response;
	}
	public xsjsglxt_image getImage() {
		return image;
	}
	public void setImage(xsjsglxt_image image) {
		this.image = image;
	}
	public HttpServletRequest getHttp_request() {
		return http_request;
	}
	public void setHttp_request(HttpServletRequest http_request) {
		this.http_request = http_request;
	}
	public xsjsglxt_picture getPicture() {
		return picture;
	}
	public void setPicture(xsjsglxt_picture picture) {
		this.picture = picture;
	}
	public xsjsglxt_case getCase1() {
		return case1;
	}
	public void setCase1(xsjsglxt_case case1) {
		this.case1 = case1;
	}

}
