package com.xsjsglxt.service.impl.Case;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.xsjsglxt.dao.Case.ImageDao;
import com.xsjsglxt.domain.DO.xsjsglxt_briefdetails;
import com.xsjsglxt.domain.DO.xsjsglxt_case;
import com.xsjsglxt.domain.DO.xsjsglxt_image;
import com.xsjsglxt.domain.DO.xsjsglxt_lost;
import com.xsjsglxt.domain.DO.xsjsglxt_lost_computer;
import com.xsjsglxt.domain.DO.xsjsglxt_lost_mobilephone;
import com.xsjsglxt.domain.DO.xsjsglxt_picture;
import com.xsjsglxt.domain.DO.xsjsglxt_resevidence;
import com.xsjsglxt.domain.DO.xsjsglxt_snece;
import com.xsjsglxt.domain.DTO.Case.SenceInformationDTO;
import com.xsjsglxt.domain.DTO.Case.ImageInformationDTO;
import com.xsjsglxt.domain.VO.Case.page_list_imageInformationVO;
import com.xsjsglxt.service.Case.ImageService;

import util.TeamUtil;

public class ImageServiceImpl implements ImageService {
private ImageDao imageDao;

public ImageDao getImageDao() {
	return imageDao;
}

public void setImageDao(ImageDao imageDao) {
	this.imageDao = imageDao;
}

@Override
public void saveCD(xsjsglxt_image image) {
	// TODO Auto-generated method stub
	image.setXsjsglxt_image_id(TeamUtil.getUuid());
	image.setImage_gmt_create(TeamUtil.getStringSecond());
	image.setImage_gmt_modified(image.getImage_gmt_create());
	imageDao.saveCD(image);
}

@Override
public void savePicture(xsjsglxt_picture picture) {
	// TODO Auto-generated method stub
	picture.setXsjsglxt_picture_id(TeamUtil.getUuid());
	picture.setPicture_gmt_create(TeamUtil.getStringSecond());
	picture.setPicture_gmt_modified(picture.getPicture_gmt_create());
	imageDao.savePicture(picture);
}

@Override
public String getMaxImage_number() {
	// TODO Auto-generated method stub
	int i = imageDao.getMaxImage_number();
	String num = "";
	num = num.format("%04d", i+1);
	Date date = new Date();
	DateFormat format = new SimpleDateFormat("yyyyMM");
	String time = format.format(date);
	String Image_number ="G" + time + num ;
	return Image_number;
}

@Override
public String getMaxPicture_identifier() {
	// TODO Auto-generated method stub
	int i = imageDao.getMaxPicture_identifier();
	System.out.println("aaaaaaaaa"+i);
	//System.out.println("iiiiii"+i);
	String num = "";
	num = num.format("%04d", i+1);
	System.out.println("mummunmumn"+num);
	Date date = new Date();
	DateFormat format = new SimpleDateFormat("yyyyMM");
	String time = format.format(date);
	String Picture_identifier ="Z" + time + num ;
	//System.out.println("SenceInformationInquestIdSenceInformationInquestIdSenceInformationInquestId"+SenceInformationInquestId);
	return Picture_identifier;
}

@Override
public page_list_imageInformationVO VO_ImageInformation_By_PageAndSearch(
		page_list_imageInformationVO page_list_imageInformation) {
	// TODO Auto-generated method stub
	List<ImageInformationDTO> imageInformationDTOList = new ArrayList<ImageInformationDTO>();
	List<xsjsglxt_picture> listPicture = new ArrayList<xsjsglxt_picture>();
	ImageInformationDTO imageInformationDTO;

	xsjsglxt_image image;
	xsjsglxt_case case1;
	
//筛选条件的记录数
	int i = imageDao.getCountImageInformationByPage(page_list_imageInformation);

	page_list_imageInformation.setTotalRecords(i);
	page_list_imageInformation.setTotalPages(((i - 1) / page_list_imageInformation.getPageSize()) + 1);
	if (page_list_imageInformation.getPageIndex() <= 1) {
		page_list_imageInformation.setHavePrePage(false);
	} else {
		page_list_imageInformation.setHavePrePage(true);
	}
	if (page_list_imageInformation.getPageIndex() >= page_list_imageInformation.getTotalPages()) {
		page_list_imageInformation.setHaveNextPage(false);
	} else {
		page_list_imageInformation.setHaveNextPage(true);
	}

	// 记录
	listPicture = imageDao.getListImageInformatioByPage(page_list_imageInformation);
	
	for (xsjsglxt_picture picture : listPicture) {
		
		image = imageDao.get_image_Byxsjsglxt_picture_id(picture);// 1
		

		case1 = imageDao.get_case1_Byxsjsglxt_picture_id(picture);// 2

		
		imageInformationDTO = new ImageInformationDTO(case1,image,picture );

		imageInformationDTOList.add(imageInformationDTO);
	}
	page_list_imageInformation.setImageInformationDTOList(imageInformationDTOList);
	
	return page_list_imageInformation;
}

@Override
public ImageInformationDTO ImageInformationOne(xsjsglxt_picture picture) {
	// TODO Auto-generated method stu
	picture=imageDao.getpictureById(picture);
	
	xsjsglxt_image image=imageDao.getImageBypictureId(picture);
	
	xsjsglxt_case case1 =  imageDao.getCaseBypictureId(picture);
	
	List<xsjsglxt_image> imageList=new ArrayList<xsjsglxt_image>();
	
	imageList=imageDao.getAllImage();

	ImageInformationDTO imageInformationDTO =new ImageInformationDTO(case1,image,picture);
	imageInformationDTO.setIamgeList(imageList);
	return imageInformationDTO;

}

@Override
public void updateImage(xsjsglxt_image image) {
	// TODO Auto-generated method stub
	image.setImage_gmt_modified(TeamUtil.getStringSecond());
	imageDao.updateImage(image);
}

@Override
public void updatePicture(xsjsglxt_picture picture) {
	// TODO Auto-generated method stub
	//xsjsglxt_picture oldpicture=imageDao.getImageBypictureId(xsjsglxt_image_id);
	//picture.setXsjsglxt_picture_id(oldpicture.getXsjsglxt_picture_id());
	//picture.setPicture_case(oldpicture.getPicture_case());
	//picture.setPicture_gmt_create(oldpicture.getPicture_gmt_create());
	//picture.setPicture_image(oldpicture.getPicture_image());
	picture.setPicture_gmt_modified(TeamUtil.getStringSecond());
	imageDao.updatePicture(picture);
}

@Override
public boolean remove_PictureInformationList(List<String> usePictureInformationNumList) {
	// TODO Auto-generated method stub
	boolean flag = false;
	for (String picture_id : usePictureInformationNumList) {
		xsjsglxt_picture xsjsglxt_picture = imageDao.getPictureByNum(picture_id);
		flag = imageDao.deletePictureById(xsjsglxt_picture.getXsjsglxt_picture_id());// ����
		
	}
	return flag;
}

@Override
public boolean remove_ImageInformationList(List<String> useImageInformationNumList) {
	// TODO Auto-generated method stub
	boolean flag = false;
	for (String iamge_id : useImageInformationNumList) {
		xsjsglxt_image xsjsglxt_image = imageDao.getImageByNum(iamge_id);
		flag = imageDao.deleteImageById(xsjsglxt_image.getXsjsglxt_image_id());// ����
		
	}
	return flag;
}

}
