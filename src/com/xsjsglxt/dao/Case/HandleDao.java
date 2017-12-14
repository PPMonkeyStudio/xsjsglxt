package com.xsjsglxt.dao.Case;

import java.util.List;

import com.xsjsglxt.domain.DO.xsjsglxt_handle;
import com.xsjsglxt.domain.VO.Case.page_list_HandleInformationVO;

public interface HandleDao {

public	void saveHandle(xsjsglxt_handle handle);

public int getCountHandleInformationByPage(page_list_HandleInformationVO page_list_HandleInformation);

public List<xsjsglxt_handle> getListHandleInformatioByPage(page_list_HandleInformationVO page_list_HandleInformation);

}
