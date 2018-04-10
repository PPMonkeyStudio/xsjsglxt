package com.xsjsglxt.domain.DTO.Statistics;

public class ComparisonTimeDTO {
	private String policemanname;
	private int comparisonTime;

	@Override
	public String toString() {
		return "ComparisonTimeDTO [policemanname=" + policemanname + ", comparisonTime=" + comparisonTime + "]";
	}

	public String getPolicemanname() {
		return policemanname;
	}

	public void setPolicemanname(String policemanname) {
		this.policemanname = policemanname;
	}

	public int getComparisonTime() {
		return comparisonTime;
	}

	public void setComparisonTime(int comparisonTime) {
		this.comparisonTime = comparisonTime;
	}
}
