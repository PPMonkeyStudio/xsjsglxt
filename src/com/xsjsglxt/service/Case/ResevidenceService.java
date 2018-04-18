package com.xsjsglxt.service.Case;

import java.util.List;

import com.xsjsglxt.domain.DO.xsjsglxt_circulation;
import com.xsjsglxt.domain.DO.xsjsglxt_resevidence;
import com.xsjsglxt.domain.DTO.Case.ResevidenceInformationDTO;
import com.xsjsglxt.domain.VO.Case.page_list_ResevidenceInformationVO;

public interface ResevidenceService {

	public void saveResevidence(xsjsglxt_resevidence resevidence);

	public page_list_ResevidenceInformationVO VO_Resevidenceformation_By_PageAndSearch(
			page_list_ResevidenceInformationVO page_list_ResevidenceInformation);

	public ResevidenceInformationDTO ResevidenceInformationOne(xsjsglxt_resevidence resevidence);

	/*
	 * 保存物证流转信息
	 */
	public void saveCirculation(xsjsglxt_circulation circulation);

	/*
	 * 删除物证
	 */
	public boolean removeResevidenceInformationList(List<String> useResevidenceInformationNumList);

	/*
	 * 修改物证信息
	 */
	public void updateResevidenceIn(xsjsglxt_resevidence resevidence);

	public void updateStatus(xsjsglxt_resevidence resevidence);

}
