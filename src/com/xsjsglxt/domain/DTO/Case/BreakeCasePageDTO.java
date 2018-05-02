package com.xsjsglxt.domain.DTO.Case;

public class BreakeCasePageDTO {
	private String xsjsglxt_breakecase_id; // 破案id
	private String snece_inquestId; // 勘验编号
	private String case_name; // 案件名
	private String breakecase_type; // 案件类型
	private String breakecase_person; // 破案人
	private String breakecase_according; // 破案方式
	private String breakecase_caseTime; // 破案时间
	private String breakecase_suspect; // 嫌疑人

	public BreakeCasePageDTO(String xsjsglxt_breakecase_id, String snece_inquestId, String case_name,
			String breakecase_type, String breakecase_person, String breakecase_according, String breakecase_caseTime) {
		super();
		this.xsjsglxt_breakecase_id = xsjsglxt_breakecase_id;
		this.snece_inquestId = snece_inquestId;
		this.case_name = case_name;
		this.breakecase_type = breakecase_type;
		this.breakecase_person = breakecase_person;
		this.breakecase_according = breakecase_according;
		this.breakecase_caseTime = breakecase_caseTime;
	}

	public BreakeCasePageDTO(String xsjsglxt_breakecase_id, String snece_inquestId) {
		super();
		this.xsjsglxt_breakecase_id = xsjsglxt_breakecase_id;
		this.snece_inquestId = snece_inquestId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BreakeCasePageDTO [xsjsglxt_breakecase_id=" + xsjsglxt_breakecase_id + ", snece_inquestId="
				+ snece_inquestId + ", case_name=" + case_name + ", breakecase_type=" + breakecase_type
				+ ", breakecase_person=" + breakecase_person + ", breakecase_according=" + breakecase_according
				+ ", breakecase_caseTime=" + breakecase_caseTime + "]";
	}

	/**
	 * @return the xsjsglxt_breakecase_id
	 */
	public String getXsjsglxt_breakecase_id() {
		return xsjsglxt_breakecase_id;
	}

	public String getBreakecase_suspect() {
		return breakecase_suspect;
	}

	public void setBreakecase_suspect(String breakecase_suspect) {
		this.breakecase_suspect = breakecase_suspect;
	}

	/**
	 * @param xsjsglxt_breakecase_id the xsjsglxt_breakecase_id to set
	 */
	public void setXsjsglxt_breakecase_id(String xsjsglxt_breakecase_id) {
		this.xsjsglxt_breakecase_id = xsjsglxt_breakecase_id;
	}

	/**
	 * @return the snece_inquestId
	 */
	public String getSnece_inquestId() {
		return snece_inquestId;
	}

	/**
	 * @param snece_inquestId the snece_inquestId to set
	 */
	public void setSnece_inquestId(String snece_inquestId) {
		this.snece_inquestId = snece_inquestId;
	}

	/**
	 * @return the case_name
	 */
	public String getCase_name() {
		return case_name;
	}

	/**
	 * @param case_name the case_name to set
	 */
	public void setCase_name(String case_name) {
		this.case_name = case_name;
	}

	/**
	 * @return the breakecase_type
	 */
	public String getBreakecase_type() {
		return breakecase_type;
	}

	/**
	 * @param breakecase_type the breakecase_type to set
	 */
	public void setBreakecase_type(String breakecase_type) {
		this.breakecase_type = breakecase_type;
	}

	/**
	 * @return the breakecase_person
	 */
	public String getBreakecase_person() {
		return breakecase_person;
	}

	/**
	 * @param breakecase_person the breakecase_person to set
	 */
	public void setBreakecase_person(String breakecase_person) {
		this.breakecase_person = breakecase_person;
	}

	/**
	 * @return the breakecase_according
	 */
	public String getBreakecase_according() {
		return breakecase_according;
	}

	/**
	 * @param breakecase_according the breakecase_according to set
	 */
	public void setBreakecase_according(String breakecase_according) {
		this.breakecase_according = breakecase_according;
	}

	/**
	 * @return the breakecase_caseTime
	 */
	public String getBreakecase_caseTime() {
		return breakecase_caseTime;
	}

	/**
	 * @param breakecase_caseTime the breakecase_caseTime to set
	 */
	public void setBreakecase_caseTime(String breakecase_caseTime) {
		this.breakecase_caseTime = breakecase_caseTime;
	}

}
