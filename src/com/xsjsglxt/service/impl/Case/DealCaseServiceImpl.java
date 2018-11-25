package com.xsjsglxt.service.impl.Case;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.xsjsglxt.dao.Case.DealCaseDao;
import com.xsjsglxt.domain.DO.xsjsglxt_handle_case;
import com.xsjsglxt.domain.DO.xsjsglxt_suspect_infor;
import com.xsjsglxt.domain.DO.xsjsglxt_suspect_state;
import com.xsjsglxt.domain.DO.xsjsglxt_take_goods;
import com.xsjsglxt.domain.DTO.Case.MessageDTO;
import com.xsjsglxt.domain.VO.Case.HandleCaseListVO;
import com.xsjsglxt.domain.VO.Case.SuspectListVO;
import com.xsjsglxt.service.Case.DealCaseService;

import util.TeamUtil;

public class DealCaseServiceImpl implements DealCaseService {
	private DealCaseDao dealCaseDao;

	// 保存案件基本信息
	@Override
	public boolean saveHandleCase(xsjsglxt_handle_case handleCase) {
		// TODO Auto-generated method stub

		return dealCaseDao.saveHandleCase(handleCase);
	}

	@Override
	public boolean updateHandleCase(xsjsglxt_handle_case handleCase) {
		// TODO Auto-generated method stub
		xsjsglxt_handle_case oldHandleCase = dealCaseDao.getHandleCaseById(handleCase.getHandle_case_id());
		handleCase.setHandle_gmt_create(oldHandleCase.getHandle_gmt_create());
		handleCase.setHandle_gmt_modified(TeamUtil.getStringSecond());
		return dealCaseDao.updateHandleCase(handleCase);
	}

	public DealCaseDao getDealCaseDao() {
		return dealCaseDao;
	}

	public void setDealCaseDao(DealCaseDao dealCaseDao) {
		this.dealCaseDao = dealCaseDao;
	}

	@Override
	public boolean deleteHandleCase(String handleCase_id) {
		// TODO Auto-generated method stub
		// 获得所有涉案嫌疑人
		List<xsjsglxt_suspect_infor> suspectList = dealCaseDao.getSuspectByCaseId(handleCase_id);
		// 循环获得嫌疑人的所有随身物品
		for (xsjsglxt_suspect_infor xsjsglxt_suspect_infor : suspectList) {
			List<xsjsglxt_take_goods> goodsList = dealCaseDao
					.getGoodsBySuspectId(xsjsglxt_suspect_infor.getSuspect_id());
			// 删除所有随身物品以及删除所有嫌疑人
			for (xsjsglxt_take_goods xsjsglxt_take_goods : goodsList) {
				boolean flag = dealCaseDao.deleteGoods(xsjsglxt_take_goods);
			}
			boolean flag1 = dealCaseDao.deleteState(xsjsglxt_suspect_infor);
			boolean flag = dealCaseDao.deleteSuspect(xsjsglxt_suspect_infor);
		}
		// 删除该案件
		xsjsglxt_handle_case x = new xsjsglxt_handle_case();
		x.setHandle_case_id(handleCase_id);
		boolean flag = dealCaseDao.deleteHandleCase(x);
		return flag;
	}

	@Override
	public xsjsglxt_handle_case gainHandleCaseById(String handleCase_id) {
		// TODO Auto-generated method stub

		return dealCaseDao.getHandleCaseById(handleCase_id);
	}

	@Override
	public void pageList(HandleCaseListVO handleCaseListVO) {
		// TODO Auto-generated method stub
		// 获得总数
		int totalSize = dealCaseDao.getCountByCondition(handleCaseListVO);
		handleCaseListVO.setTotalSize(totalSize);
		handleCaseListVO.setTotalPage((int) Math.ceil((double) totalSize / (double) handleCaseListVO.getPageSize()));
		List<xsjsglxt_handle_case> handleCaseList = dealCaseDao.getCaseByPage(handleCaseListVO);
		handleCaseListVO.setCaseList(handleCaseList);
	}

	@Override
	public boolean saveSuspect(xsjsglxt_suspect_infor suspectInfor) {
		// TODO Auto-generated method stub

		return dealCaseDao.saveSuspect(suspectInfor);
	}

	@Override
	public boolean updateSuspect(xsjsglxt_suspect_infor suspectInfor, int isChangeType) {
		// TODO Auto-generated method stub
		xsjsglxt_suspect_infor oldSuspect = dealCaseDao.getSuspectById(suspectInfor.getSuspect_id());
		if (isChangeType == 1) {
			// 保存记录
			xsjsglxt_suspect_state state = new xsjsglxt_suspect_state();
			state.setState_id(TeamUtil.getUuid());
			state.setState_suspect(oldSuspect.getSuspect_id());
			state.setState_type(oldSuspect.getSuspect_process_type());
			state.setState_start(oldSuspect.getSuspect_start_time());
			state.setState_end(oldSuspect.getSuspect_end_time());
			state.setState_gmt_create(TeamUtil.getStringSecond());
			state.setState_gmt_modified(TeamUtil.getStringSecond());
			dealCaseDao.saveState(state);
		}
		suspectInfor.setSuspect_case(oldSuspect.getSuspect_case());
		suspectInfor.setSuspect_gmt_create(oldSuspect.getSuspect_gmt_create());
		suspectInfor.setSuspect_gmt_modified(TeamUtil.getStringSecond());
		return dealCaseDao.updateSuspect(suspectInfor);
	}

	@Override
	public boolean deleteSuspect(xsjsglxt_suspect_infor suspectInfor) {
		// TODO Auto-generated method stub
		List<xsjsglxt_take_goods> goodsList = dealCaseDao.getGoodsBySuspectId(suspectInfor.getSuspect_id());
		for (xsjsglxt_take_goods xsjsglxt_take_goods : goodsList) {
			boolean flag = dealCaseDao.deleteGoods(xsjsglxt_take_goods);
		}
		boolean flag1 = dealCaseDao.deleteState(suspectInfor);
		boolean flag = dealCaseDao.deleteSuspect(suspectInfor);
		return flag;
	}

	@Override
	public xsjsglxt_suspect_infor getSuspectById(String suspect_id) {
		// TODO Auto-generated method stub
		return dealCaseDao.getSuspectById(suspect_id);
	}

	@Override
	public List<xsjsglxt_suspect_infor> getSuspectByCaseId(String handleCase_id) {
		// TODO Auto-generated method stub
		return dealCaseDao.getSuspectByCaseId(handleCase_id);
	}

	@Override
	public boolean saveTakeGoods(xsjsglxt_take_goods takeGoods) {
		// TODO Auto-generated method stub
		return dealCaseDao.saveTakeGoods(takeGoods);
	}

	@Override
	public boolean updateTakeGoods(xsjsglxt_take_goods takeGoods) {
		// TODO Auto-generated method stub
		xsjsglxt_take_goods oldgoods = dealCaseDao.getGoodsById(takeGoods.getGoods_id());
		takeGoods.setGoods_suspect(oldgoods.getGoods_suspect());
		takeGoods.setGoods_gmt_create(oldgoods.getGoods_gmt_create());
		takeGoods.setGoods_gmt_modified(TeamUtil.getStringSecond());
		return dealCaseDao.updateTakeGoods(takeGoods);
	}

	@Override
	public boolean deleteTakeGoods(xsjsglxt_take_goods takeGoods) {
		// TODO Auto-generated method stub
		xsjsglxt_take_goods goods = dealCaseDao.getGoodsById(takeGoods.getGoods_id());
		return dealCaseDao.deleteGoods(takeGoods);
	}

	@Override
	public xsjsglxt_take_goods getTakeGoodsById(String goods_id) {
		// TODO Auto-generated method stub
		return dealCaseDao.getGoodsById(goods_id);
	}

	@Override
	public List<xsjsglxt_take_goods> getTakeGoodsBySuspectId(String suspect_id) {
		// TODO Auto-generated method stub
		return dealCaseDao.getGoodsBySuspectId(suspect_id);
	}

	@Override
	public void getSuspectList(SuspectListVO suspectVO) {
		// TODO Auto-generated method stub
		// 获得总数
		int count = dealCaseDao.getSuspectCount(suspectVO);
		suspectVO.setTotalSize(count);
		suspectVO.setTotalPage((int) Math.ceil((double) count / suspectVO.getPageSize()));
		// 分页获得数据
		dealCaseDao.getSUspectList(suspectVO);
	}

	@Override
	public List<xsjsglxt_suspect_state> getSuspectStates(String suspect_id) {
		// TODO Auto-generated method stub
		return dealCaseDao.getSuspectStates(suspect_id);
	}

	@Override
	public Set<MessageDTO> getMessage() {
		// TODO Auto-generated method stub
		List<MessageDTO> listDetentionThree = dealCaseDao.getDetentionMessageThree();
		List<MessageDTO> listDetentionSeven = dealCaseDao.getDetentionMessageSeven();
		List<MessageDTO> listDetentionMonth = dealCaseDao.getDetentionMessageMonth();
		List<MessageDTO> listArrest = dealCaseDao.getArrestMessage();
		List<MessageDTO> listCheckBack = dealCaseDao.getCheckBackMessage();
		List<MessageDTO> listMonitor = dealCaseDao.getMonitorMessage();
		Set<MessageDTO> messageSet = new HashSet<MessageDTO>();
		messageSet.addAll(listDetentionThree);
		messageSet.addAll(listDetentionSeven);
		messageSet.addAll(listDetentionMonth);
		messageSet.addAll(listArrest);
		messageSet.addAll(listCheckBack);
		messageSet.addAll(listMonitor);
		return messageSet;
	}

}
