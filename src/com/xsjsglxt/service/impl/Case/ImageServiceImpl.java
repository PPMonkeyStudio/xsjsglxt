package com.xsjsglxt.service.impl.Case;

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

}
