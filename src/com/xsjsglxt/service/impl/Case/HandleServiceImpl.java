package com.xsjsglxt.service.impl.Case;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.xsjsglxt.dao.Case.HandleDao;
import com.xsjsglxt.domain.DO.xsjsglxt_handle;
import com.xsjsglxt.domain.DO.xsjsglxt_introduce_letter;
import com.xsjsglxt.domain.VO.Case.IntroduceLetterVO;
import com.xsjsglxt.domain.VO.Case.page_list_HandleInformationVO;
import com.xsjsglxt.service.Case.HandleService;

import util.TeamUtil;

public class HandleServiceImpl implements HandleService {
	private HandleDao handleDao;

	public HandleDao getHandleDao() {
		return handleDao;
	}

	public void setHandleDao(HandleDao handleDao) {
		this.handleDao = handleDao;
	}

	@Override
	public void saveHandle(xsjsglxt_handle handle) {
		// TODO Auto-generated method stub
		handle.setXsjsglxt_handle_id(TeamUtil.getUuid());
		handle.setHandle_gnt_create(TeamUtil.getStringSecond());
		handle.setHandle_gmt_modified(handle.getHandle_gnt_create());
		handleDao.saveHandle(handle);
	}

	@Override
	public page_list_HandleInformationVO VO_HandleInformation_By_PageAndSearch(
			page_list_HandleInformationVO page_list_HandleInformation) {
		// TODO Auto-generated method stub
		List<xsjsglxt_handle> listHandle = new ArrayList<xsjsglxt_handle>();
		// BreakecaseInformationDTO breakecaseInformationDTO;

		int i = handleDao.getCountHandleInformationByPage(page_list_HandleInformation);
		System.out.println("总记录" + i);
		page_list_HandleInformation.setTotalRecords(i);
		page_list_HandleInformation.setTotalPages(((i - 1) / page_list_HandleInformation.getPageSize()) + 1);
		if (page_list_HandleInformation.getPageIndex() <= 1) {
			page_list_HandleInformation.setHavePrePage(false);
		} else {
			page_list_HandleInformation.setHavePrePage(true);
		}
		if (page_list_HandleInformation.getPageIndex() >= page_list_HandleInformation.getTotalPages()) {
			page_list_HandleInformation.setHaveNextPage(false);
		} else {
			page_list_HandleInformation.setHaveNextPage(true);
		}

		// 符合条件的记录
		listHandle = handleDao.getListHandleInformatioByPage(page_list_HandleInformation);

		page_list_HandleInformation.setListHandle(listHandle);

		return page_list_HandleInformation;
	}

	@Override
	public xsjsglxt_handle HandleInformationOne(xsjsglxt_handle handle) {
		// TODO Auto-generated method stub
		return handleDao.HandleInformationOne(handle);
	}

	@Override
	public void updateHandleInformation(xsjsglxt_handle handle) {
		// TODO Auto-generated method stub
		handle.setHandle_gmt_modified(TeamUtil.getStringSecond());
		handleDao.updateHandleInformation(handle);
	}

	@Override
	public boolean remove_HandleInformationList(List<String> useHandleInformationNumList) {
		// TODO Auto-generated method stub
		boolean flag = false;
		for (String handle_id : useHandleInformationNumList) {
			xsjsglxt_handle xsjsglxt_handle = handleDao.getHandleByNum(handle_id);
			flag = handleDao.deleteHandleById(xsjsglxt_handle.getXsjsglxt_handle_id());// ����

		}
		return flag;
	}

	@Override
	public int getMaxId() {
		// TODO Auto-generated method stub
		int i = handleDao.getMaxId();
		return (i + 1);
	}

	@Override
	public List<xsjsglxt_handle> allPoliceInHandlingCases() {
		// TODO Auto-generated method stub

		return handleDao.allPoliceInHandlingCases();
	}

	@Override
	public List<String> getHandleExceedTime() {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, -25);
		String oldTime = sdf.format(c.getTime());
		System.out.println(oldTime);
		List<String> caseList = handleDao.getHandleExceedTime(oldTime);
		c.clear();
		return caseList;
	}

	@Override
	public Map<String, List<xsjsglxt_handle>> getOutTime() {
		// TODO Auto-generated method stub
		return handleDao.getOutTime();
	}

	@Override
	public List<xsjsglxt_handle> getDetention() {
		// TODO Auto-generated method stub

		return handleDao.getDetention();
	}

	@Override
	public String saveIntroduceLetter(xsjsglxt_introduce_letter xsjsglxt_introduce_letter) {
		// TODO Auto-generated method stub
		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		c.clear();
		year = year * 10000;
		int number_ = handleDao.getLetterMaxId();
		number_ = year + number_;
		xsjsglxt_introduce_letter.setXsjsglxt_introduce_letter_id(TeamUtil.getUuid());
		xsjsglxt_introduce_letter.setIntroduce_letter_serial_number(Integer.toString(number_));
		xsjsglxt_introduce_letter.setIntroduce_gmt_create(TeamUtil.getStringSecond());
		xsjsglxt_introduce_letter.setIntroduce_gmt_modified(TeamUtil.getStringSecond());
		String returnId = handleDao.saveIntroduceLetter(xsjsglxt_introduce_letter);
		return returnId;
	}

	@Override
	public String deleteIntroduceLetter(String[] letter_id) {
		// TODO Auto-generated method stub
		for (int i = 0; i < letter_id.length; i++) {
			handleDao.deleteIntroduceLetter(letter_id[i]);
		}

		return "deleteSuccess";
	}

	@Override
	public String getIntroduceLetterById(String xsjsglxt_introduce_letter_id) {
		// TODO Auto-generated method stub
		xsjsglxt_introduce_letter letter = handleDao.getIntroduceLetterById(xsjsglxt_introduce_letter_id);
		Gson gson = new Gson();
		return gson.toJson(letter);
	}

	@Override
	public String updateIntroduceLetter(xsjsglxt_introduce_letter letter) {
		// TODO Auto-generated method stub
		xsjsglxt_introduce_letter oldLetter = handleDao
				.getIntroduceLetterById(letter.getXsjsglxt_introduce_letter_id());
		letter.setIntroduce_gmt_create(oldLetter.getIntroduce_gmt_create());
		letter.setIntroduce_letter_serial_number(oldLetter.getIntroduce_letter_serial_number());
		letter.setIntroduce_gmt_modified(TeamUtil.getStringSecond());
		letter.setIntroduce_approve_status(oldLetter.getIntroduce_approve_status());
		String result = handleDao.updateIntroduceLetter(letter);
		return result;
	}

	@Override
	public void getLetterByPage(IntroduceLetterVO letterVO) {
		// TODO Auto-generated method stub
		int count = handleDao.getCountByCondition(letterVO);
		letterVO.setPageSize(10);
		letterVO.setTotalCount(count);
		letterVO.setTotalPage((int) Math.ceil((double) count / letterVO.getPageSize()));
		handleDao.getLetterByPage(letterVO);
	}

	@Override
	public xsjsglxt_introduce_letter getIntroduceLetterByIdObject(String xsjsglxt_introduce_letter_id) {
		// TODO Auto-generated method stub
		xsjsglxt_introduce_letter letter = handleDao.getIntroduceLetterById(xsjsglxt_introduce_letter_id);
		return letter;
	}

	@Override
	public String updateApproveStatus(xsjsglxt_introduce_letter letter) {
		// TODO Auto-generated method stub

		return handleDao.updateApproveStatus(letter);
	}

}
