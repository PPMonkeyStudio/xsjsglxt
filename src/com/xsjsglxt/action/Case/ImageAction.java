package com.xsjsglxt.action.Case;

import java.io.IOException;
import java.util.List;

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
import com.xsjsglxt.domain.DTO.Case.ImageInformationDTO;
import com.xsjsglxt.domain.VO.Case.page_list_imageInformationVO;
import com.xsjsglxt.service.Case.ImageService;

import util.TeamUtil;

public class ImageAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {
	private ImageService imageService;
	private HttpServletResponse http_response;
	private xsjsglxt_image image;
	private HttpServletRequest http_request;
	private xsjsglxt_picture picture;
	private xsjsglxt_case case1;
	private List<String> usePictureInformationNumList;
	private List<String> useImageInformationNumList;
	private ImageInformationDTO imageInformationDTO;
	private page_list_imageInformationVO page_list_imageInformation;

	/*
	 * 保存光盘
	 */
	public void saveCD() throws IOException {
		try {
			String uuid = TeamUtil.getUuid();
			image.setXsjsglxt_image_id(uuid);
			imageService.saveCD(image);
			http_response.setContentType("text/html;charset=utf-8");
			http_response.getWriter().write(uuid);
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
	public void savePicture() throws IOException {
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

	/**
	 * 获取单个照片信息
	 */
	public void getPictureOne() {
		try {
			GsonBuilder gsonBuilder = new GsonBuilder();
			gsonBuilder.setPrettyPrinting();// 格式化json数据
			Gson gson = gsonBuilder.create();
			xsjsglxt_picture pictureOne = imageService.getPictureOne(picture);
			http_response.setContentType("text/html;charset=utf-8");
			http_response.getWriter().write(gson.toJson(pictureOne));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/*
	 * 光盘编号
	 */
	public void getImage_number() throws IOException {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
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
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();
		String Picture_identifier = imageService.getMaxPicture_identifier();
		http_response.setContentType("text/html;charset=utf-8");
		http_response.getWriter().write(gson.toJson(Picture_identifier));
	}

	/*
	 * 修改光盘信息
	 */
	public void updateImage() throws IOException {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();
		imageService.updateImage(image);
		// imageService.updatePicture(picture,image.getXsjsglxt_image_id());
		http_response.setContentType("text/html;charset=utf-8");
		http_response.getWriter().write("success");
	}

	/*
	 * 修改照片信息
	 */
	public void updatePicture() throws IOException {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();
		imageService.updatePicture(picture);
		http_response.setContentType("text/html;charset=utf-8");
		http_response.getWriter().write("success");
	}

	/*
	 * 删除照片
	 */
	public void remove_PictureInformationList() {

		if (imageService.remove_PictureInformationList(usePictureInformationNumList)) {
			http_response.setContentType("text/html;charset=utf-8");
			try {
				http_response.getWriter().write("success");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			http_response.setContentType("text/html;charset=utf-8");
			try {
				http_response.getWriter().write("error");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/*
	 * 删除光盘
	 */
	public void remove_ImageInformationList() {

		if (imageService.remove_ImageInformationList(useImageInformationNumList)) {
			http_response.setContentType("text/html;charset=utf-8");
			try {
				http_response.getWriter().write("success");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			http_response.setContentType("text/html;charset=utf-8");
			try {
				http_response.getWriter().write("error");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public ImageService getImageService() {
		return imageService;
	}

	public void setImageService(ImageService imageService) {
		this.imageService = imageService;
	}

	/*
	 * 列表信息
	 * 
	 */
	public void ListImageInformationByPageAndSearch() throws IOException {

		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();

		page_list_imageInformation = imageService.VO_ImageInformation_By_PageAndSearch(page_list_imageInformation);

		http_response.setContentType("text/html;charset=utf-8");

		http_response.getWriter().write(gson.toJson(page_list_imageInformation));

	}

	/**
	 * 获取全部的光盘信息
	 */
	public void ListAllImageInformation() {
		try {
			GsonBuilder gsonBuilder = new GsonBuilder();
			gsonBuilder.setPrettyPrinting();// 格式化json数据
			Gson gson = gsonBuilder.create();
			List<xsjsglxt_image> list = imageService.ListAllImageInformation();
			http_response.setContentType("text/html;charset=utf-8");

			http_response.getWriter().write(gson.toJson(list));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ImageInformationDTO getImageInformationDTO() {
		return imageInformationDTO;
	}

	public void setImageInformationDTO(ImageInformationDTO imageInformationDTO) {
		this.imageInformationDTO = imageInformationDTO;
	}

	public page_list_imageInformationVO getPage_list_imageInformation() {
		return page_list_imageInformation;
	}

	public void setPage_list_imageInformation(page_list_imageInformationVO page_list_imageInformation) {
		this.page_list_imageInformation = page_list_imageInformation;
	}

	/*
	 * 详细信息
	 * 
	 */
	public void ImageInformationOne() throws IOException {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();
		imageInformationDTO = imageService.ImageInformationOne(image, picture);
		http_response.setContentType("text/html;charset=utf-8");

		http_response.getWriter().write(gson.toJson(imageInformationDTO));
	}

	/**
	 * 获取所有光盘💿
	 */
	/*
	 * 详细信息
	 * 
	 */
	public void getAllImageInformation() throws IOException {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();
		// imageInformationDTO = imageService.ImageInformationOne(image);
		List<xsjsglxt_image> list = imageService.ListAllImageInformation();
		http_response.setContentType("text/html;charset=utf-8");

		http_response.getWriter().write(gson.toJson(list));
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

	public List<String> getUsePictureInformationNumList() {
		return usePictureInformationNumList;
	}

	public void setUsePictureInformationNumList(List<String> usePictureInformationNumList) {
		this.usePictureInformationNumList = usePictureInformationNumList;
	}

	public List<String> getUseImageInformationNumList() {
		return useImageInformationNumList;
	}

	public void setUseImageInformationNumList(List<String> useImageInformationNumList) {
		this.useImageInformationNumList = useImageInformationNumList;
	}

}
