package com.xsjsglxt.service.impl.Statistics;

import java.util.List;

import com.xsjsglxt.dao.Statistics.StatisticsDao;
import com.xsjsglxt.domain.DO.xsjsglxt_staff;
import com.xsjsglxt.domain.DTO.Statistics.policemanOutTimesDTO;
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
		List<xsjsglxt_staff> policeman = statisticsDao.getPolicemanByName(outTimeVO.getPolicemanName());
		List<policemanOutTimesDTO> policemanDTO = null;
		// 2.通过警员名字获得警员的出警数量
		if (policeman != null && policeman.size() > 0) {
			policemanDTO = statisticsDao.getTimes(policeman, outTimeVO);
			return policemanDTO;
		} else {
			return policemanDTO;
		}

	}

}
