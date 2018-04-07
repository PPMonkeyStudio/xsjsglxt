package com.xsjsglxt.domain.VO.Statistics;

/**
 * 
 * @author 孙毅
 *出警次数筛选条件
 */
public class OutTimeVO {
	private String policemanName;// 警员姓名
	private String timeStart;// 接警时间开始
	private String timeEnd;// 接警时间结束

	public String getPolicemanName() {
		return policemanName;
	}

	public void setPolicemanName(String policemanName) {
		this.policemanName = policemanName;
	}

	public String getTimeStart() {
		return timeStart;
	}

	public void setTimeStart(String timeStart) {
		this.timeStart = timeStart;
	}

	public String getTimeEnd() {
		return timeEnd;
	}

	public void setTimeEnd(String timeEnd) {
		this.timeEnd = timeEnd;
	}

}
