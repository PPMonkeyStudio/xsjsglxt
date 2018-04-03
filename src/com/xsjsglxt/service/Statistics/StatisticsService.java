package com.xsjsglxt.service.Statistics;

import java.util.List;

import com.xsjsglxt.domain.DTO.Statistics.policemanOutTimesDTO;

public interface StatisticsService {

	List<policemanOutTimesDTO> policemanOutTime(String policemanName);

}
