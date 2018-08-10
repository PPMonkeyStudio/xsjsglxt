package com.xsjsglxt.service.impl.Case;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.xsjsglxt.dao.Case.HandleDao;
import com.xsjsglxt.domain.DO.xsjsglxt_introduce_letter;
import com.xsjsglxt.domain.DTO.Case.HandleSuspectDTO;
import com.xsjsglxt.domain.VO.Case.IntroduceLetterVO;
import com.xsjsglxt.domain.VO.Case.page_list_HandleInformationVO;
import com.xsjsglxt.service.Case.HandleService;
import com.xsjsglxt.domain.DO.XsjsglxtHandle;
import com.xsjsglxt.domain.DO.XsjsglxtHandleSuspect;

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
	public boolean saveHandle(XsjsglxtHandle handle, List<XsjsglxtHandleSuspect> handleSuspect) {
		boolean handleSave = false;
		// boolean suspectSave = false;
		String uid = TeamUtil.getUuid();
		handle.setXsjsglxtHandleId(uid);
		handle.setHandleGntCreate(TeamUtil.getStringSecond());
		handle.setHandleGmtModified(TeamUtil.getStringSecond());

		// for (XsjsglxtHandleSuspect xsjsglxtHandleSuspect : handleSuspect) {
		// xsjsglxtHandleSuspect.setXsjsglxiHandleSuspectId(TeamUtil.getUuid());
		// xsjsglxtHandleSuspect.setXsjsglxtHandleId(uid);
		// xsjsglxtHandleSuspect.setHandleGmtCreate(TeamUtil.getStringSecond());
		// xsjsglxtHandleSuspect.setHandleGmtModified(TeamUtil.getStringSecond());
		// suspectSave = handleDao.saveObject(xsjsglxtHandleSuspect);
		// }

		handleSave = handleDao.saveObject(handle);
		// if (handleSave && suspectSave) {
		// return true;
		// }
		if (handleSave)
			return true;
		return false;
	}

	@Override
	public boolean saveSuspect(XsjsglxtHandleSuspect suspect) {
		suspect.setXsjsglxiHandleSuspectId(TeamUtil.getUuid());
		suspect.setHandleGmtCreate(TeamUtil.getStringSecond());
		suspect.setHandleGmtModified(TeamUtil.getStringSecond());
		return handleDao.saveObject(suspect);
	}

	@Override
	public page_list_HandleInformationVO VO_HandleInformation_By_PageAndSearch(
			page_list_HandleInformationVO page_list_HandleInformation) {
		List<HandleSuspectDTO> handleSuspectDTOList = new ArrayList<HandleSuspectDTO>();
		// BreakecaseInformationDTO breakecaseInformationDTO;
		int i = handleDao.getCountHandleInformationByPage(page_list_HandleInformation);

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
		handleSuspectDTOList = handleDao.getListHandleInformatioByPage(page_list_HandleInformation);

		for (int j = 0, len = handleSuspectDTOList.size(); j < len; j++) {
			handleSuspectDTOList.get(j).setListSuspect(
					handleDao.getHandleSuspectByHandId(handleSuspectDTOList.get(j).getXsjsglxtHandle()));
		}

		page_list_HandleInformation.setListSuspectDTO(handleSuspectDTOList);

		return page_list_HandleInformation;
	}

	@Override
	public XsjsglxtHandle HandleInformationOne(XsjsglxtHandle handle) {
		return handleDao.HandleInformationOne(handle);
	}

	@Override
	public List<HandleSuspectDTO> SuspectInformation(XsjsglxtHandle handle, XsjsglxtHandleSuspect suspect) {
		List<HandleSuspectDTO> handleSuspectDTOList = new ArrayList<HandleSuspectDTO>();
		HandleSuspectDTO handleSuspectDTO = new HandleSuspectDTO();
		handleSuspectDTO.setXsjsglxtHandle(handleDao.getHandleByHandleId(handle));
		handleSuspectDTO.setListSuspect(handleDao.getSuspectBySuspectId(suspect));
		handleSuspectDTOList.add(handleSuspectDTO);
		return handleSuspectDTOList;
	}

	@Override
	public boolean updateHandleInformation(XsjsglxtHandle handle) {
		handle.setHandleGmtModified(TeamUtil.getStringSecond());
		return handleDao.updateHandleInformation(handle);
	}

	/*
	 * @Override public boolean remove_HandleInformationList(List<String>
	 * useHandleInformationNumList) { // TODO Auto-generated method stub boolean
	 * flag = false; for (String handle_id : useHandleInformationNumList) {
	 * xsjsglxt_handle xsjsglxt_handle = handleDao.getHandleByNum(handle_id);
	 * flag =
	 * handleDao.deleteHandleById(xsjsglxt_handle.getXsjsglxt_handle_id());//
	 * ����
	 * 
	 * } return flag; }
	 * 
	 * @Override public int getMaxId() { // TODO Auto-generated method stub int
	 * i = handleDao.getMaxId(); return (i + 1); }
	 * 
	 * @Override public List<xsjsglxt_handle> allPoliceInHandlingCases() { //
	 * TODO Auto-generated method stub
	 * 
	 * return handleDao.allPoliceInHandlingCases(); }
	 */
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

	/*
	 * @Override public Map<String, List<xsjsglxt_handle>> getOutTime() { //
	 * TODO Auto-generated method stub return handleDao.getOutTime(); }
	 * 
	 * @Override public List<xsjsglxt_handle> getDetention() { // TODO
	 * Auto-generated method stub
	 * 
	 * return handleDao.getDetention(); }
	 */
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
		xsjsglxt_introduce_letter letter = handleDao.getIntroduceLetterById(xsjsglxt_introduce_letter_id);
		return letter;
	}

	@Override
	public String updateApproveStatus(xsjsglxt_introduce_letter letter) {
		return handleDao.updateApproveStatus(letter);
	}

	@Override
	public boolean updateSuspect(XsjsglxtHandleSuspect suspect) {
		suspect.setHandleGmtModified(TeamUtil.getStringSecond());
		return handleDao.updateObject(suspect);
	}

	@Override
	public boolean removeSuspect(XsjsglxtHandleSuspect suspect) {
		return handleDao.removeSuspect(suspect);
	}

	@Override
	public boolean removeHandle(XsjsglxtHandle handle) {
		List<XsjsglxtHandleSuspect> list = handleDao.getHandleSuspectByHandId(handle);
		for (XsjsglxtHandleSuspect xsjsglxtHandleSuspect : list) {
			handleDao.removeSuspect(xsjsglxtHandleSuspect);
		}
		return handleDao.removeHandle(handle);
	}
}
