package com.xsjsglxt.dao.Case;

import java.util.List;

import com.xsjsglxt.domain.DO.xsjsglxt_handle;
import com.xsjsglxt.domain.VO.Case.page_list_HandleInformationVO;

public interface HandleDao {

	public void saveHandle(xsjsglxt_handle handle);

	public int getCountHandleInformationByPage(page_list_HandleInformationVO page_list_HandleInformation);

	public List<xsjsglxt_handle> getListHandleInformatioByPage(
			page_list_HandleInformationVO page_list_HandleInformation);

	public xsjsglxt_handle HandleInformationOne(xsjsglxt_handle handle);

	public void updateHandleInformation(xsjsglxt_handle handle);

	public com.xsjsglxt.domain.DO.xsjsglxt_handle getHandleByNum(String handle_id);

	public boolean deleteHandleById(String xsjsglxt_handle_id);

	public int getMaxId();

	public List<xsjsglxt_handle> allPoliceInHandlingCases();

}
