package com.xsjsglxt.domain.DTO.Statistics;

public class policemanOutTimesDTO {
	private String policemanName;
	private int outTimes;

	@Override
	public String toString() {
		return "policemanOutTimesDTO [policemanName=" + policemanName + ", outTimes=" + outTimes + "]";
	}

	public String getPolicemanName() {
		return policemanName;
	}

	public void setPolicemanName(String policemanName) {
		this.policemanName = policemanName;
	}

	public int getOutTimes() {
		return outTimes;
	}

	public void setOutTimes(int outTimes) {
		this.outTimes = outTimes;
	}
}
