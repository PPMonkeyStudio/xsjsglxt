package com.xsjsglxt.service.impl.Statistics;

import java.util.ArrayList;
import java.util.List;

import com.xsjsglxt.dao.Statistics.StatisticsDao;
import com.xsjsglxt.domain.DO.xsjsglxt_staff;
import com.xsjsglxt.domain.DTO.Statistics.CaseTimeDTO;
import com.xsjsglxt.domain.DTO.Statistics.policemanOutTimesDTO;
import com.xsjsglxt.domain.VO.Statistics.CaseTimeVO;
import com.xsjsglxt.domain.VO.Statistics.OutTimeVO;
import com.xsjsglxt.service.Statistics.StatisticsService;

public class StatisticsServiceImpl implements StatisticsService {
	private StatisticsDao statisticsDao;

	public StatisticsDao getStatisticsDao() {
		return statisticsDao;
	}

	public void setStatisticsDao(StatisticsDao statisticsDao) {
		this.statisticsDao = statisticsDao;
	}

	@Override
	public List<policemanOutTimesDTO> policemanOutTime(OutTimeVO outTimeVO) {
		// TODO Auto-generated method stub
		// 1.获得所有警员名字
		List<xsjsglxt_staff> policemans = statisticsDao.getPolicemanByName(outTimeVO.getPolicemanName());
		List<policemanOutTimesDTO> policemanDTOList = new ArrayList<policemanOutTimesDTO>();
		// 2.通过警员名字获得警员的出警数量
		// if (policeman != null && policeman.size() > 0) {
		// policemanDTO = statisticsDao.getTimes(policeman, outTimeVO);
		// return policemanDTO;
		// } else {
		// return policemanDTO;
		// }
		policemanOutTimesDTO policemanDTO = null;
		for (xsjsglxt_staff staff : policemans) {
			policemanDTO = new policemanOutTimesDTO();
			policemanDTO.setPolicemanName(staff.getXsjsglxt_name());
			statisticsDao.getPolicemanOutTimes(policemanDTO, outTimeVO);
		}
		return policemanDTOList;

	}

	@Override
	public List<CaseTimeDTO> caseTime(CaseTimeVO caseTimeVO) {
		// TODO Auto-generated method stub
		List<CaseTimeDTO> caseTimeDTOList = statisticsDao.getCaseTime(caseTimeVO);
		return caseTimeDTOList;
	}

}
