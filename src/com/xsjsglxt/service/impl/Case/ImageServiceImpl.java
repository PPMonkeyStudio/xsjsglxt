package com.xsjsglxt.service.impl.Case;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.xsjsglxt.dao.Case.ImageDao;
import com.xsjsglxt.domain.DO.xsjsglxt_image;
import com.xsjsglxt.domain.DO.xsjsglxt_picture;
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
	System.out.println("aaaaaaaaa"+i);
	//System.out.println("iiiiii"+i);
	String num = "";
	num = num.format("%04d", i+1);
	System.out.println("mummunmumn"+num);
	Date date = new Date();
	DateFormat format = new SimpleDateFormat("yyyyMM");
	String time = format.format(date);
	String Image_number ="G" + time + num ;
	//System.out.println("SenceInformationInquestIdSenceInformationInquestIdSenceInformationInquestId"+SenceInformationInquestId);
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

}
