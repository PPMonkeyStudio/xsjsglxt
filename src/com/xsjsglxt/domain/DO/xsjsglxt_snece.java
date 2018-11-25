package com.xsjsglxt.domain.DO;

//现场勘验表
public class xsjsglxt_snece {

	private String xsjsglxt_snece_id;// 现场勘验ID

	private String snece_case;// 所属案件

	private String snece_inquestId;// 勘验编号

	private String snece_inquestSystemId;// 勘验系统编号

	private String snece_mobileStation;// 移动基站号

	private String snece_mobileVillage;// 移动小区号

	private String snece_unicomSwitchboard;// 联通交换机

	private String snece_unicomVillage;// 联通小区号

	private String snece_telecomStation;// 电信基站号

	private String snece_weather;// 天气

	private String snece_weatherTemperature;// 天气温度

	private String snece_inquestPerson;// 勘验人员

	private String snece_fillPerson;// 填表人员

	private String snece_fillUnit;// 填表单位

	private String snece_fillTime;// 填表时间

	private int snece_photographed;// 已拍照

	private int snece_entered;// 已录入

	private int snece_areadymade;// 已制作

	private int snece_parsed;// 已分析

	private int snece_archived;// 已存档

	private int snece_identified;// 已认定

	private String snece_gmt_create;// 创建时间

	private String snece_gmt_modified;// 修改时间

	public xsjsglxt_snece() {

		// TODO Auto-generated constructor stub
	}

	public xsjsglxt_snece(String xsjsglxt_snece_id, String snece_case, String snece_inquestId,
			String snece_inquestSystemId, String snece_mobileStation, String snece_mobileVillage,
			String snece_unicomSwitchboard, String snece_unicomVillage, String snece_telecomStation,
			String snece_weather, String snece_weatherTemperature, String snece_inquestPerson, String snece_fillPerson,
			String snece_fillUnit, String snece_fillTime, int snece_photographed, int snece_entered,
			int snece_areadymade, int snece_parsed, int snece_archived, int snece_identified, String snece_gmt_create,
			String snece_gmt_modified) {

		this.xsjsglxt_snece_id = xsjsglxt_snece_id;
		this.snece_case = snece_case;
		this.snece_inquestId = snece_inquestId;
		this.snece_inquestSystemId = snece_inquestSystemId;
		this.snece_mobileStation = snece_mobileStation;
		this.snece_mobileVillage = snece_mobileVillage;
		this.snece_unicomSwitchboard = snece_unicomSwitchboard;
		this.snece_unicomVillage = snece_unicomVillage;
		this.snece_telecomStation = snece_telecomStation;
		this.snece_weather = snece_weather;
		this.snece_weatherTemperature = snece_weatherTemperature;
		this.snece_inquestPerson = snece_inquestPerson;
		this.snece_fillPerson = snece_fillPerson;
		this.snece_fillUnit = snece_fillUnit;
		this.snece_fillTime = snece_fillTime;
		this.snece_photographed = snece_photographed;
		this.snece_entered = snece_entered;
		this.snece_areadymade = snece_areadymade;
		this.snece_parsed = snece_parsed;
		this.snece_archived = snece_archived;
		this.snece_identified = snece_identified;
		this.snece_gmt_create = snece_gmt_create;
		this.snece_gmt_modified = snece_gmt_modified;
	}

	@Override
	public String toString() {
		return "snece [xsjsglxt_snece_id=" + xsjsglxt_snece_id + ", snece_case=" + snece_case + ", snece_inquestId="
				+ snece_inquestId + ", snece_inquestSystemId=" + snece_inquestSystemId + ", snece_mobileStation="
				+ snece_mobileStation + ", snece_mobileVillage=" + snece_mobileVillage + ", snece_unicomSwitchboard="
				+ snece_unicomSwitchboard + ", snece_unicomVillage=" + snece_unicomVillage + ", snece_telecomStation="
				+ snece_telecomStation + ", snece_weather=" + snece_weather + ", snece_weatherTemperature="
				+ snece_weatherTemperature + ", snece_inquestPerson=" + snece_inquestPerson + ", snece_fillPerson="
				+ snece_fillPerson + ", snece_fillUnit=" + snece_fillUnit + ", snece_fillTime=" + snece_fillTime
				+ ", snece_photographed=" + snece_photographed + ", snece_entered=" + snece_entered
				+ ", snece_areadymade=" + snece_areadymade + ", snece_parsed=" + snece_parsed + ", snece_archived="
				+ snece_archived + ", snece_identified=" + snece_identified + ", snece_gmt_create=" + snece_gmt_create
				+ ", snece_gmt_modified=" + snece_gmt_modified + "]";
	}

	public String getXsjsglxt_snece_id() {
		return xsjsglxt_snece_id;
	}

	public void setXsjsglxt_snece_id(String xsjsglxt_snece_id) {
		this.xsjsglxt_snece_id = xsjsglxt_snece_id;
	}

	public String getSnece_case() {
		return snece_case;
	}

	public void setSnece_case(String snece_case) {
		this.snece_case = snece_case;
	}

	public String getSnece_inquestId() {
		return snece_inquestId;
	}

	public void setSnece_inquestId(String snece_inquestId) {
		this.snece_inquestId = snece_inquestId;
	}

	public String getSnece_inquestSystemId() {
		return snece_inquestSystemId;
	}

	public void setSnece_inquestSystemId(String snece_inquestSystemId) {
		this.snece_inquestSystemId = snece_inquestSystemId;
	}

	public String getSnece_mobileStation() {
		return snece_mobileStation;
	}

	public void setSnece_mobileStation(String snece_mobileStation) {
		this.snece_mobileStation = snece_mobileStation;
	}

	public String getSnece_mobileVillage() {
		return snece_mobileVillage;
	}

	public void setSnece_mobileVillage(String snece_mobileVillage) {
		this.snece_mobileVillage = snece_mobileVillage;
	}

	public String getSnece_unicomSwitchboard() {
		return snece_unicomSwitchboard;
	}

	public void setSnece_unicomSwitchboard(String snece_unicomSwitchboard) {
		this.snece_unicomSwitchboard = snece_unicomSwitchboard;
	}

	public String getSnece_unicomVillage() {
		return snece_unicomVillage;
	}

	public void setSnece_unicomVillage(String snece_unicomVillage) {
		this.snece_unicomVillage = snece_unicomVillage;
	}

	public String getSnece_telecomStation() {
		return snece_telecomStation;
	}

	public void setSnece_telecomStation(String snece_telecomStation) {
		this.snece_telecomStation = snece_telecomStation;
	}

	public String getSnece_weather() {
		return snece_weather;
	}

	public void setSnece_weather(String snece_weather) {
		this.snece_weather = snece_weather;
	}

	public String getSnece_weatherTemperature() {
		return snece_weatherTemperature;
	}

	public void setSnece_weatherTemperature(String snece_weatherTemperature) {
		this.snece_weatherTemperature = snece_weatherTemperature;
	}

	public String getSnece_inquestPerson() {
		return snece_inquestPerson;
	}

	public void setSnece_inquestPerson(String snece_inquestPerson) {
		this.snece_inquestPerson = snece_inquestPerson;
	}

	public String getSnece_fillPerson() {
		return snece_fillPerson;
	}

	public void setSnece_fillPerson(String snece_fillPerson) {
		this.snece_fillPerson = snece_fillPerson;
	}

	public String getSnece_fillUnit() {
		return snece_fillUnit;
	}

	public void setSnece_fillUnit(String snece_fillUnit) {
		this.snece_fillUnit = snece_fillUnit;
	}

	public String getSnece_fillTime() {
		return snece_fillTime;
	}

	public void setSnece_fillTime(String snece_fillTime) {
		this.snece_fillTime = snece_fillTime;
	}

	public int getSnece_photographed() {
		return snece_photographed;
	}

	public void setSnece_photographed(int snece_photographed) {
		this.snece_photographed = snece_photographed;
	}

	public int getSnece_entered() {
		return snece_entered;
	}

	public void setSnece_entered(int snece_entered) {
		this.snece_entered = snece_entered;
	}

	public int getSnece_areadymade() {
		return snece_areadymade;
	}

	public void setSnece_areadymade(int snece_areadymade) {
		this.snece_areadymade = snece_areadymade;
	}

	public int getSnece_parsed() {
		return snece_parsed;
	}

	public void setSnece_parsed(int snece_parsed) {
		this.snece_parsed = snece_parsed;
	}

	public int getSnece_archived() {
		return snece_archived;
	}

	public void setSnece_archived(int snece_archived) {
		this.snece_archived = snece_archived;
	}

	public int getSnece_identified() {
		return snece_identified;
	}

	public void setSnece_identified(int snece_identified) {
		this.snece_identified = snece_identified;
	}

	public String getSnece_gmt_create() {
		return snece_gmt_create;
	}

	public void setSnece_gmt_create(String snece_gmt_create) {
		this.snece_gmt_create = snece_gmt_create;
	}

	public String getSnece_gmt_modified() {
		return snece_gmt_modified;
	}

	public void setSnece_gmt_modified(String snece_gmt_modified) {
		this.snece_gmt_modified = snece_gmt_modified;
	}

}
