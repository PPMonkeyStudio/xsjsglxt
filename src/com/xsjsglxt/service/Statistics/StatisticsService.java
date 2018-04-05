package com.xsjsglxt.service.Statistics;

import java.util.List;

import com.xsjsglxt.domain.DTO.Statistics.ComparisonTimeDTO;
import com.xsjsglxt.domain.DTO.Statistics.policemanOutTimesDTO;
import com.xsjsglxt.domain.VO.Statistics.ComparisonTimeVO;
import com.xsjsglxt.domain.VO.Statistics.OutTimeVO;

public interface StatisticsService {

	List<policemanOutTimesDTO> policemanOutTime(OutTimeVO outTimeVO);

	List<ComparisonTimeDTO> comparisonTime(ComparisonTimeVO comparisonTimeVO);

}
