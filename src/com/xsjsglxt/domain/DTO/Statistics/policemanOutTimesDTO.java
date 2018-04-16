package com.xsjsglxt.domain.DTO.Statistics;

public class policemanOutTimesDTO {
	private String policemanName;
	private int outTimes;
	private int fingerprint;
	private int footprint;
	private int instrument;
	private int biology;
	private int physicochemical;
	private int other;
	private String extractionRadio;
	private int breakeNumber;

	@Override
	public String toString() {
		return "policemanOutTimesDTO [policemanName=" + policemanName + ", outTimes=" + outTimes + ", fingerprint="
				+ fingerprint + ", footprint=" + footprint + ", instrument=" + instrument + ", biology=" + biology
				+ ", physicochemical=" + physicochemical + ", other=" + other + ", extractionRadio=" + extractionRadio
				+ ", breakeNumber=" + breakeNumber + "]";
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

	public int getFingerprint() {
		return fingerprint;
	}

	public void setFingerprint(int fingerprint) {
		this.fingerprint = fingerprint;
	}

	public int getFootprint() {
		return footprint;
	}

	public void setFootprint(int footprint) {
		this.footprint = footprint;
	}

	public int getInstrument() {
		return instrument;
	}

	public void setInstrument(int instrument) {
		this.instrument = instrument;
	}

	public int getBiology() {
		return biology;
	}

	public void setBiology(int biology) {
		this.biology = biology;
	}

	public int getPhysicochemical() {
		return physicochemical;
	}

	public void setPhysicochemical(int physicochemical) {
		this.physicochemical = physicochemical;
	}

	public int getOther() {
		return other;
	}

	public void setOther(int other) {
		this.other = other;
	}

	public String getExtractionRadio() {
		return extractionRadio;
	}

	public void setExtractionRadio(String extractionRadio) {
		this.extractionRadio = extractionRadio;
	}

	public int getBreakeNumber() {
		return breakeNumber;
	}

	public void setBreakeNumber(int breakeNumber) {
		this.breakeNumber = breakeNumber;
	}
}
