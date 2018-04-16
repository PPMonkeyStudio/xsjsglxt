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
		if (policemans != null && policemans.size() > 0) {
			policemanOutTimesDTO policemanDTO = null;
			for (xsjsglxt_staff staff : policemans) {
				policemanDTO = new policemanOutTimesDTO();
				policemanDTO.setPolicemanName(staff.getXsjsglxt_name());
				statisticsDao.getPolicemanOutTimes(policemanDTO, outTimeVO);
				statisticsDao.getEvidence(policemanDTO, outTimeVO);
				statisticsDao.getRadio(policemanDTO, outTimeVO);
				statisticsDao.getBreakeNum(policemanDTO, outTimeVO);
				policemanDTOList.add(policemanDTO);
			}
		}
		outTimeVO.setTotalCount(policemanDTOList.size());
		outTimeVO.setPageSize(10);
		outTimeVO.setCurrPage(outTimeVO.getCurrPage());
		outTimeVO.setTotalPage((int) Math.ceil(((double) outTimeVO.getTotalCount()) / outTimeVO.getPageSize()));
		List<policemanOutTimesDTO> newList = new ArrayList<policemanOutTimesDTO>();
		if (policemanDTOList.size() > 0) {
			for (int i = (outTimeVO.getCurrPage() - 1) * outTimeVO.getPageSize(); i < (outTimeVO.getCurrPage() - 1)
					* outTimeVO.getPageSize() + outTimeVO.getPageSize(); i++) {
				if (i >= policemanDTOList.size())
					break;
				else
					newList.add(policemanDTOList.get(i));
			}
		}
		return newList;
	}

	@Override
	public List<CaseTimeDTO> caseTime(CaseTimeVO caseTimeVO) {
		// TODO Auto-generated method stub
		List<CaseTimeDTO> caseTimeDTOList = statisticsDao.getCaseTime(caseTimeVO);
		return caseTimeDTOList;
	}

}
