package com.xsjsglxt.service.Case;

import java.util.List;
import java.util.Set;

import com.xsjsglxt.domain.DO.xsjsglxt_handle_case;
import com.xsjsglxt.domain.DO.xsjsglxt_suspect_infor;
import com.xsjsglxt.domain.DO.xsjsglxt_suspect_state;
import com.xsjsglxt.domain.DO.xsjsglxt_take_goods;
import com.xsjsglxt.domain.DTO.Case.MessageDTO;
import com.xsjsglxt.domain.VO.Case.HandleCaseListVO;
import com.xsjsglxt.domain.VO.Case.SuspectListVO;

public interface DealCaseService {

	boolean saveHandleCase(xsjsglxt_handle_case handleCase);

	boolean updateHandleCase(xsjsglxt_handle_case handleCase);

	boolean deleteHandleCase(String handleCase_id);

	xsjsglxt_handle_case gainHandleCaseById(String handleCase_id);

	void pageList(HandleCaseListVO handleCaseListVO);

	boolean saveSuspect(xsjsglxt_suspect_infor suspectInfor);

	boolean deleteSuspect(xsjsglxt_suspect_infor suspectInfor);

	xsjsglxt_suspect_infor getSuspectById(String suspect_id);

	List<xsjsglxt_suspect_infor> getSuspectByCaseId(String handleCase_id);

	boolean saveTakeGoods(xsjsglxt_take_goods takeGoods);

	boolean updateTakeGoods(xsjsglxt_take_goods takeGoods);

	boolean deleteTakeGoods(xsjsglxt_take_goods takeGoods);

	xsjsglxt_take_goods getTakeGoodsById(String goods_id);

	List<xsjsglxt_take_goods> getTakeGoodsBySuspectId(String suspect_id);

	void getSuspectList(SuspectListVO suspectVO);

	boolean updateSuspect(xsjsglxt_suspect_infor suspectInfor, int isChangeType);

	List<xsjsglxt_suspect_state> getSuspectStates(String suspect_id);

	Set<MessageDTO> getMessage();

}
