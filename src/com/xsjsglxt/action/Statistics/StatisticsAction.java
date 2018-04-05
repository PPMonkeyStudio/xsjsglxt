package com.xsjsglxt.action.Statistics;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.xsjsglxt.domain.DTO.Statistics.ComparisonTimeDTO;
import com.xsjsglxt.domain.DTO.Statistics.policemanOutTimesDTO;
import com.xsjsglxt.domain.VO.Statistics.ComparisonTimeVO;
import com.xsjsglxt.domain.VO.Statistics.OutTimeVO;
import com.xsjsglxt.service.Statistics.StatisticsService;

/**
 * 
 * @author 孙毅
 * 统计警员出现场的数量
 *
 */
public class StatisticsAction {
	private StatisticsService statisticsService;
	private String policemanName;
	private OutTimeVO outTimeVO;
	private ComparisonTimeVO comparisonTimeVO;

	// --------------------------------进入统计首页-----------------------------------------
	public String intoMain() {
		return "intoMain";
	}

	// ----------------------------------获得警员出警次数统计---------------------------------
	public void policemanOutTime() throws IOException, InterruptedException {
		if (outTimeVO == null) {
			outTimeVO = new OutTimeVO();
			outTimeVO.setPolicemanName("");
		}
		List<policemanOutTimesDTO> result = statisticsService.policemanOutTime(outTimeVO);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		Gson gson = new Gson();
		PrintWriter pw = response.getWriter();
		if (result != null && result.size() >= 0) {
			pw.write(gson.toJson(result));
			pw.flush();
			pw.close();
		} else {
			pw.write("不存在此警员记录");
			pw.flush();
			pw.close();
		}
	}

	// ------------------------------获得警员比对指纹次数--------------------------------------

	public void policemanComparisonTime() throws IOException {
		if (comparisonTimeVO == null) {
			comparisonTimeVO = new ComparisonTimeVO();
			comparisonTimeVO.setComparisonPolicemanName("");
		}
		List<ComparisonTimeDTO> result = statisticsService.comparisonTime(comparisonTimeVO);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		Gson gson = new Gson();
		PrintWriter pw = response.getWriter();
		if (result != null && result.size() >= 0) {
			pw.write(gson.toJson(result));
			pw.flush();
			pw.close();
		} else {
			pw.write("不存在此警员记录");
			pw.flush();
			pw.close();
		}
	}
	// -----------------------setter/getter-------------------------------

	public OutTimeVO getOutTimeVO() {
		return outTimeVO;
	}

	public ComparisonTimeVO getComparisonTimeVO() {
		return comparisonTimeVO;
	}

	public void setComparisonTimeVO(ComparisonTimeVO comparisonTimeVO) {
		this.comparisonTimeVO = comparisonTimeVO;
	}

	public void setOutTimeVO(OutTimeVO outTimeVO) {
		this.outTimeVO = outTimeVO;
	}

	public StatisticsService getStatisticsService() {
		return statisticsService;
	}

	public String getPolicemanName() {
		return policemanName;
	}

	public void setPolicemanName(String policemanName) {
		this.policemanName = policemanName;
	}

	public void setStatisticsService(StatisticsService statisticsService) {
		this.statisticsService = statisticsService;
	}
}
