package com.xsjsglxt.dao.Case;

import java.util.List;

import com.xsjsglxt.domain.DO.xsjsglxt_handle_case;
import com.xsjsglxt.domain.DO.xsjsglxt_suspect_infor;
import com.xsjsglxt.domain.DO.xsjsglxt_suspect_state;
import com.xsjsglxt.domain.DO.xsjsglxt_take_goods;
import com.xsjsglxt.domain.DTO.Case.MessageDTO;
import com.xsjsglxt.domain.VO.Case.HandleCaseListVO;
import com.xsjsglxt.domain.VO.Case.SuspectListVO;

public interface DealCaseDao {

	boolean saveHandleCase(xsjsglxt_handle_case handleCase);

	xsjsglxt_handle_case getHandleCaseById(String handle_case_id);

	boolean updateHandleCase(xsjsglxt_handle_case handleCase);

	List<xsjsglxt_suspect_infor> getSuspectByCaseId(String handleCase_id);

	List<xsjsglxt_take_goods> getGoodsBySuspectId(String suspect_id);

	boolean deleteGoods(xsjsglxt_take_goods xsjsglxt_take_goods);

	boolean deleteSuspect(xsjsglxt_suspect_infor xsjsglxt_suspect_infor);

	boolean deleteHandleCase(xsjsglxt_handle_case x);

	xsjsglxt_handle_case gainHandleCaseById(String handleCase_id);

	int getCountByCondition(HandleCaseListVO handleCaseListVO);

	List<xsjsglxt_handle_case> getCaseByPage(HandleCaseListVO handleCaseListVO);

	boolean saveSuspect(xsjsglxt_suspect_infor suspectInfor);

	xsjsglxt_suspect_infor getSuspectById(String suspect_id);

	boolean updateSuspect(xsjsglxt_suspect_infor suspectInfor);

	boolean saveTakeGoods(xsjsglxt_take_goods takeGoods);

	xsjsglxt_take_goods getGoodsById(String string);

	boolean updateTakeGoods(xsjsglxt_take_goods takeGoods);

	int getSuspectCount(SuspectListVO suspectVO);

	void getSUspectList(SuspectListVO suspectVO);

	void saveState(xsjsglxt_suspect_state state);

	List<xsjsglxt_suspect_state> getSuspectStates(String suspect_id);

	List<MessageDTO> getDetentionMessageThree();

	List<MessageDTO> getDetentionMessageSeven();

	List<MessageDTO> getDetentionMessageMonth();

	List<MessageDTO> getArrestMessage();

	List<MessageDTO> getCheckBackMessage();

	List<MessageDTO> getMonitorMessage();

	boolean deleteState(xsjsglxt_suspect_infor xsjsglxt_suspect_infor);

}
