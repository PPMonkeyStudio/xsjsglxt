package com.xsjsglxt.service.Case;


import java.util.List;

import com.xsjsglxt.domain.DO.xsjsglxt_handle;
import com.xsjsglxt.domain.VO.Case.page_list_HandleInformationVO;

public interface HandleService {
/*
 * 保存办案信息
 */
public	void saveHandle(xsjsglxt_handle handle);
/*
 * 列表信息
 */
public page_list_HandleInformationVO VO_HandleInformation_By_PageAndSearch(
		page_list_HandleInformationVO page_list_HandleInformation);
public xsjsglxt_handle HandleInformationOne(xsjsglxt_handle handle);
public void updateHandleInformation(xsjsglxt_handle handle);
public boolean remove_HandleInformationList(List<String> useHandleInformationNumList);

public int getMaxId();
public List<xsjsglxt_handle> allPoliceInHandlingCases();


}



