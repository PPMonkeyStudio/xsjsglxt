package com.xsjsglxt.domain.DTO.Scheduling;

public class schedulingTimeDTO {
	private String policemanName; // 民警名字
	private String schedulingTime; // 值班天数
	private String patrolTime; // 巡逻天数
	private String overTime; // 加班天数
	private String outTime; // 外协天数
	private String evectionTime;// 出差次数

	public String getPolicemanName() {
		return policemanName;
	}

	public void setPolicemanName(String policemanName) {
		this.policemanName = policemanName;
	}

	public String getSchedulingTime() {
		return schedulingTime;
	}

	public void setSchedulingTime(String schedulingTime) {
		this.schedulingTime = schedulingTime;
	}

	public String getPatrolTime() {
		return patrolTime;
	}

	public void setPatrolTime(String patrolTime) {
		this.patrolTime = patrolTime;
	}

	public String getOverTime() {
		return overTime;
	}

	public void setOverTime(String overTime) {
		this.overTime = overTime;
	}

	public String getOutTime() {
		return outTime;
	}

	public void setOutTime(String outTime) {
		this.outTime = outTime;
	}

	public String getEvectionTime() {
		return evectionTime;
	}

	public void setEvectionTime(String evectionTime) {
		this.evectionTime = evectionTime;
	}

}
