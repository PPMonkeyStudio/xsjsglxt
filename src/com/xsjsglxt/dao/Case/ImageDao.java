package com.xsjsglxt.dao.Case;

import com.xsjsglxt.domain.DO.xsjsglxt_image;
import com.xsjsglxt.domain.DO.xsjsglxt_picture;

public interface ImageDao {

public	void saveCD(xsjsglxt_image image);

public void savePicture(xsjsglxt_picture picture);

public int getMaxImage_number();

public int getMaxPicture_identifier();

}
