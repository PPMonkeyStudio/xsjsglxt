package com.xsjsglxt.dao.Case;

import java.util.List;
import java.util.Map;

import com.xsjsglxt.domain.DO.XsjsglxtHandleSuspect;
import com.xsjsglxt.domain.DO.XsjsglxtHandle;
import com.xsjsglxt.domain.DO.xsjsglxt_introduce_letter;
import com.xsjsglxt.domain.DTO.Case.HandleSuspectDTO;
import com.xsjsglxt.domain.VO.Case.IntroduceLetterVO;
import com.xsjsglxt.domain.VO.Case.page_list_HandleInformationVO;

public interface HandleDao {

	public boolean saveObject(Object object);

	// public void saveHandle(XsjsglxtHandle handle);

	public int getCountHandleInformationByPage(page_list_HandleInformationVO page_list_HandleInformation);

	public List<HandleSuspectDTO> getListHandleInformatioByPage(
			page_list_HandleInformationVO page_list_HandleInformation);

	public XsjsglxtHandle HandleInformationOne(XsjsglxtHandle handle);

	public boolean updateHandleInformation(XsjsglxtHandle handle);

	// public com.xsjsglxt.domain.DO.xsjsglxt_handle getHandleByNum(String
	// handle_id);

	// public boolean deleteHandleById(String xsjsglxt_handle_id);

	// public int getMaxId();

	// public List<xsjsglxt_handle> allPoliceInHandlingCases();

	public List<String> getHandleExceedTime(String oldTime);

	// public Map<String, List<xsjsglxt_handle>> getOutTime();

	// public List<xsjsglxt_handle> getDetention();

	public int getLetterMaxId();

	public String saveIntroduceLetter(xsjsglxt_introduce_letter xsjsglxt_introduce_letter);

	public void deleteIntroduceLetter(String string);

	public xsjsglxt_introduce_letter getIntroduceLetterById(String xsjsglxt_introduce_letter_id);

	public String updateIntroduceLetter(xsjsglxt_introduce_letter letter);

	public int getCountByCondition(IntroduceLetterVO letterVO);

	public void getLetterByPage(IntroduceLetterVO letterVO);

	public String updateApproveStatus(xsjsglxt_introduce_letter letter);

	public List<XsjsglxtHandleSuspect> getHandleSuspectByHandId(XsjsglxtHandle xsjsglxtHandle);

	public XsjsglxtHandle getHandleByHandleId(XsjsglxtHandle handle);

	public List<XsjsglxtHandleSuspect> getSuspectBySuspectId(XsjsglxtHandleSuspect suspect);

	public boolean updateObject(XsjsglxtHandleSuspect suspect);

	public boolean removeSuspect(XsjsglxtHandleSuspect suspect);

	public boolean removeHandle(XsjsglxtHandle handle);

}
