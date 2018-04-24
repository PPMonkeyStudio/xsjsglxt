package com.xsjsglxt.dao.Case;

import java.util.List;
import java.util.Map;

import com.xsjsglxt.domain.DO.xsjsglxt_handle;
import com.xsjsglxt.domain.DO.xsjsglxt_introduce_letter;
import com.xsjsglxt.domain.VO.Case.IntroduceLetterVO;
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

	public List<String> getHandleExceedTime(String oldTime);

	public Map<String, List<xsjsglxt_handle>> getOutTime();

	public List<xsjsglxt_handle> getDetention();

	public int getLetterMaxId();

	public String saveIntroduceLetter(xsjsglxt_introduce_letter xsjsglxt_introduce_letter);

	public void deleteIntroduceLetter(String string);

	public xsjsglxt_introduce_letter getIntroduceLetterById(String xsjsglxt_introduce_letter_id);

	public String updateIntroduceLetter(xsjsglxt_introduce_letter letter);

	public int getCountByCondition(IntroduceLetterVO letterVO);

	public void getLetterByPage(IntroduceLetterVO letterVO);

	public String updateApproveStatus(xsjsglxt_introduce_letter letter);

}
