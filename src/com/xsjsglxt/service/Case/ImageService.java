package com.xsjsglxt.service.Case;

import com.xsjsglxt.domain.DO.xsjsglxt_image;
import com.xsjsglxt.domain.DO.xsjsglxt_picture;
import com.xsjsglxt.domain.DTO.Case.ImageInformationDTO;
import com.xsjsglxt.domain.VO.Case.page_list_imageInformationVO;

public interface ImageService {

public	void saveCD(xsjsglxt_image image);

public void savePicture(xsjsglxt_picture picture);

public String getMaxImage_number();

public String getMaxPicture_identifier();

public page_list_imageInformationVO VO_ImageInformation_By_PageAndSearch(
		page_list_imageInformationVO page_list_imageInformation);//列表

public ImageInformationDTO ImageInformationOne(xsjsglxt_picture picture);

}
