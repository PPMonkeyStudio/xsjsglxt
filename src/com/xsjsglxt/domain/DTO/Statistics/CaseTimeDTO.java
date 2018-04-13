package com.xsjsglxt.domain.DTO.Statistics;

public class CaseTimeDTO {
	private String caseCategory;
	private int dongDaTime;
	private int gaoKangTime;
	private int qingshanTime;
	private int anyuanTime;
	private int bayiTime;
	private int baiyuanTime;
	private int chengjiaoTime;
	private int danjiangTime;
	private int fenghuangTime;
	private int houfuTime;
	private int liziyuanTime;
	private int wupoxiaTime;
	private int qitaTime;

	public CaseTimeDTO() { // TODO Auto-generated constructor stub
		this.dongDaTime = 0;
		this.gaoKangTime = 0;
		this.qingshanTime = 0;
		this.anyuanTime = 0;
		this.bayiTime = 0;
		this.baiyuanTime = 0;
		this.chengjiaoTime = 0;
		this.danjiangTime = 0;
		this.fenghuangTime = 0;
		this.liziyuanTime = 0;
		this.wupoxiaTime = 0;
		this.houfuTime = 0;
		this.qitaTime = 0;

	}

	public String getCaseCategory() {
		return caseCategory;
	}

	public void setCaseCategory(String caseCategory) {
		this.caseCategory = caseCategory;
	}

	public int getDongDaTime() {
		return dongDaTime;
	}

	public void setDongDaTime(int dongDaTime) {
		this.dongDaTime = dongDaTime;
	}

	public int getGaoKangTime() {
		return gaoKangTime;
	}

	public void setGaoKangTime(int gaoKangTime) {
		this.gaoKangTime = gaoKangTime;
	}

	public int getQingshanTime() {
		return qingshanTime;
	}

	public void setQingshanTime(int qingshanTime) {
		this.qingshanTime = qingshanTime;
	}

	public int getAnyuanTime() {
		return anyuanTime;
	}

	public void setAnyuanTime(int anyuanTime) {
		this.anyuanTime = anyuanTime;
	}

	public int getBayiTime() {
		return bayiTime;
	}

	public void setBayiTime(int bayiTime) {
		this.bayiTime = bayiTime;
	}

	public int getBaiyuanTime() {
		return baiyuanTime;
	}

	public void setBaiyuanTime(int baiyuanTime) {
		this.baiyuanTime = baiyuanTime;
	}

	public int getChengjiaoTime() {
		return chengjiaoTime;
	}

	public void setChengjiaoTime(int chengjiaoTime) {
		this.chengjiaoTime = chengjiaoTime;
	}

	public int getDanjiangTime() {
		return danjiangTime;
	}

	public void setDanjiangTime(int danjiangTime) {
		this.danjiangTime = danjiangTime;
	}

	public int getFenghuangTime() {
		return fenghuangTime;
	}

	public void setFenghuangTime(int fenghuangTime) {
		this.fenghuangTime = fenghuangTime;
	}

	public int getHoufuTime() {
		return houfuTime;
	}

	public void setHoufuTime(int houfuTime) {
		this.houfuTime = houfuTime;
	}

	public int getLiziyuanTime() {
		return liziyuanTime;
	}

	public void setLiziyuanTime(int liziyuanTime) {
		this.liziyuanTime = liziyuanTime;
	}

	public int getWupoxiaTime() {
		return wupoxiaTime;
	}

	public void setWupoxiaTime(int wupoxiaTime) {
		this.wupoxiaTime = wupoxiaTime;
	}

	public int getQitaTime() {
		return qitaTime;
	}

	public void setQitaTime(int qitaTime) {
		this.qitaTime = qitaTime;
	}

	@Override
	public String toString() {
		return "CaseTimeDTO [caseCategory=" + caseCategory + ", dongDaTime=" + dongDaTime + ", gaoKangTime="
				+ gaoKangTime + ", qingshanTime=" + qingshanTime + ", anyuanTime=" + anyuanTime + ", bayiTime="
				+ bayiTime + ", baiyuanTime=" + baiyuanTime + ", chengjiaoTime=" + chengjiaoTime + ", danjiangTime="
				+ danjiangTime + ", fenghuangTime=" + fenghuangTime + ", houfuTime=" + houfuTime + ", liziyuanTime="
				+ liziyuanTime + ", wupoxiaTime=" + wupoxiaTime + ", qitaTime=" + qitaTime + "]";
	}

}
