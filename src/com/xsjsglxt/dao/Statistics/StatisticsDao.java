package com.xsjsglxt.dao.Statistics;

import java.util.List;

import com.xsjsglxt.domain.DO.xsjsglxt_staff;
import com.xsjsglxt.domain.DTO.Statistics.CaseTimeDTO;
import com.xsjsglxt.domain.DTO.Statistics.policemanOutTimesDTO;
import com.xsjsglxt.domain.VO.Statistics.CaseTimeVO;
import com.xsjsglxt.domain.VO.Statistics.OutTimeVO;

public interface StatisticsDao {

	List<xsjsglxt_staff> getPolicemanByName(String policemanName);

	List<CaseTimeDTO> getCaseTime(CaseTimeVO caseTimeVO);

	void getPolicemanOutTimes(policemanOutTimesDTO policemanDTO, OutTimeVO outTimeVO);

	void getEvidence(policemanOutTimesDTO policemanDTO, OutTimeVO outTimeVO);

	void getRadio(policemanOutTimesDTO policemanDTO, OutTimeVO outTimeVO);

}
