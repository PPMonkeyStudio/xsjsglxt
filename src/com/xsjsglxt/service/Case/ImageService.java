package com.xsjsglxt.service.Case;

import java.util.List;

import com.xsjsglxt.domain.DO.xsjsglxt_image;
import com.xsjsglxt.domain.DO.xsjsglxt_picture;
import com.xsjsglxt.domain.DTO.Case.ImageInformationDTO;
import com.xsjsglxt.domain.VO.Case.page_list_imageInformationVO;

public interface ImageService {

	public void saveCD(xsjsglxt_image image);

	public void savePicture(xsjsglxt_picture picture);

	public String getMaxImage_number();

	public String getMaxPicture_identifier();

	public page_list_imageInformationVO VO_ImageInformation_By_PageAndSearch(
			page_list_imageInformationVO page_list_imageInformation);// 列表

	public ImageInformationDTO ImageInformationOne(xsjsglxt_image image, xsjsglxt_picture picture);

	public void updateImage(xsjsglxt_image image);

	public void updatePicture(xsjsglxt_picture picture);

	public boolean remove_PictureInformationList(List<String> usePictureInformationNumList);

	public boolean remove_ImageInformationList(List<String> useImageInformationNumList);

	public List<xsjsglxt_image> ListAllImageInformation();

	public xsjsglxt_picture getPictureOne(xsjsglxt_picture picture);

}
