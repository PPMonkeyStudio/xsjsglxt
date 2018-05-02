package com.xsjsglxt.domain.DTO.Team;

public class policemanListDTO {
	private String xsjsglxt_staff_id;
	private String xsjsglxt_name;
	private String xsjsglxt_sex;
	private String xsjsglxt_age;
	private String staff_politicalStatus;
	private String staff_thePoliceTime;
	private String staff_phone;

	public String getXsjsglxt_staff_id() {
		return xsjsglxt_staff_id;
	}

	public void setXsjsglxt_staff_id(String xsjsglxt_staff_id) {
		this.xsjsglxt_staff_id = xsjsglxt_staff_id;
	}

	public String getXsjsglxt_name() {
		return xsjsglxt_name;
	}

	public void setXsjsglxt_name(String xsjsglxt_name) {
		this.xsjsglxt_name = xsjsglxt_name;
	}

	public String getXsjsglxt_sex() {
		return xsjsglxt_sex;
	}

	public void setXsjsglxt_sex(String xsjsglxt_sex) {
		this.xsjsglxt_sex = xsjsglxt_sex;
	}

	public String getXsjsglxt_age() {
		return xsjsglxt_age;
	}

	public void setXsjsglxt_age(String xsjsglxt_age) {
		this.xsjsglxt_age = xsjsglxt_age;
	}

	public String getStaff_politicalStatus() {
		return staff_politicalStatus;
	}

	public void setStaff_politicalStatus(String staff_politicalStatus) {
		this.staff_politicalStatus = staff_politicalStatus;
	}

	public String getStaff_thePoliceTime() {
		return staff_thePoliceTime;
	}

	public void setStaff_thePoliceTime(String staff_thePoliceTime) {
		this.staff_thePoliceTime = staff_thePoliceTime;
	}

	@Override
	public String toString() {
		return "policemanListDTO [xsjsglxt_staff_id=" + xsjsglxt_staff_id + ", xsjsglxt_name=" + xsjsglxt_name
				+ ", xsjsglxt_sex=" + xsjsglxt_sex + ", xsjsglxt_age=" + xsjsglxt_age + ", staff_politicalStatus="
				+ staff_politicalStatus + ", staff_thePoliceTime=" + staff_thePoliceTime + "]";
	}

	public policemanListDTO(String xsjsglxt_staff_id, String xsjsglxt_name, String xsjsglxt_sex, String xsjsglxt_age,
			String staff_politicalStatus, String staff_thePoliceTime) {
		super();
		this.xsjsglxt_staff_id = xsjsglxt_staff_id;
		this.xsjsglxt_name = xsjsglxt_name;
		this.xsjsglxt_sex = xsjsglxt_sex;
		this.xsjsglxt_age = xsjsglxt_age;
		this.staff_politicalStatus = staff_politicalStatus;
		this.staff_thePoliceTime = staff_thePoliceTime;
	}

	public policemanListDTO(String xsjsglxt_staff_id, String xsjsglxt_name, String xsjsglxt_sex, String xsjsglxt_age,
			String staff_politicalStatus, String staff_thePoliceTime, String staff_phone) {
		super();
		this.xsjsglxt_staff_id = xsjsglxt_staff_id;
		this.xsjsglxt_name = xsjsglxt_name;
		this.xsjsglxt_sex = xsjsglxt_sex;
		this.xsjsglxt_age = xsjsglxt_age;
		this.staff_politicalStatus = staff_politicalStatus;
		this.staff_thePoliceTime = staff_thePoliceTime;
		this.staff_phone = staff_phone;
	}

	public String getStaff_phone() {
		return staff_phone;
	}

	public void setStaff_phone(String staff_phone) {
		this.staff_phone = staff_phone;
	}

}
