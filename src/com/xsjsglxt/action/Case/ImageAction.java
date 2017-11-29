package com.xsjsglxt.action.Case;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

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
private xsjsglxt_case Case;
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
	picture.setPicture_case(Case.getXsjsglxt_case_id());
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

}
