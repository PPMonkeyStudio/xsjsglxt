package com.xsjsglxt.domain.DO;

/**
 * XsjsglxtHandle entity. @author MyEclipse Persistence Tools
 */

public class XsjsglxtHandle implements java.io.Serializable {

	// Fields

	private String xsjsglxtHandleId;//办案id
	private String handleAdministrativeCase;//办案名称
	private String handleAdministrativeType;//案件类型
	private String handleSponsoredPolice;//主办民警
	private String handleAssistingPolice;//协办民警
	private String handleSquadronLeader;//中队长
	private String handleGntCreate;
	private String handleGmtModified;

	// Constructors

	/** default constructor */
	public XsjsglxtHandle() {
	}

	/** minimal constructor */
	public XsjsglxtHandle(String xsjsglxtHandleId) {
		this.xsjsglxtHandleId = xsjsglxtHandleId;
	}

	/** full constructor */
	public XsjsglxtHandle(String xsjsglxtHandleId, String handleAdministrativeCase, String handleAdministrativeType,
			String handleSponsoredPolice, String handleAssistingPolice, String handleSquadronLeader,
			String handleGntCreate, String handleGmtModified) {
		this.xsjsglxtHandleId = xsjsglxtHandleId;
		this.handleAdministrativeCase = handleAdministrativeCase;
		this.handleAdministrativeType = handleAdministrativeType;
		this.handleSponsoredPolice = handleSponsoredPolice;
		this.handleAssistingPolice = handleAssistingPolice;
		this.handleSquadronLeader = handleSquadronLeader;
		this.handleGntCreate = handleGntCreate;
		this.handleGmtModified = handleGmtModified;
	}

	// Property accessors

	public String getXsjsglxtHandleId() {
		return this.xsjsglxtHandleId;
	}

	public void setXsjsglxtHandleId(String xsjsglxtHandleId) {
		this.xsjsglxtHandleId = xsjsglxtHandleId;
	}

	public String getHandleAdministrativeCase() {
		return this.handleAdministrativeCase;
	}

	public void setHandleAdministrativeCase(String handleAdministrativeCase) {
		this.handleAdministrativeCase = handleAdministrativeCase;
	}

	public String getHandleAdministrativeType() {
		return this.handleAdministrativeType;
	}

	public void setHandleAdministrativeType(String handleAdministrativeType) {
		this.handleAdministrativeType = handleAdministrativeType;
	}

	public String getHandleSponsoredPolice() {
		return this.handleSponsoredPolice;
	}

	public void setHandleSponsoredPolice(String handleSponsoredPolice) {
		this.handleSponsoredPolice = handleSponsoredPolice;
	}

	public String getHandleAssistingPolice() {
		return this.handleAssistingPolice;
	}

	public void setHandleAssistingPolice(String handleAssistingPolice) {
		this.handleAssistingPolice = handleAssistingPolice;
	}

	public String getHandleSquadronLeader() {
		return this.handleSquadronLeader;
	}

	public void setHandleSquadronLeader(String handleSquadronLeader) {
		this.handleSquadronLeader = handleSquadronLeader;
	}

	public String getHandleGntCreate() {
		return this.handleGntCreate;
	}

	public void setHandleGntCreate(String handleGntCreate) {
		this.handleGntCreate = handleGntCreate;
	}

	public String getHandleGmtModified() {
		return this.handleGmtModified;
	}

	public void setHandleGmtModified(String handleGmtModified) {
		this.handleGmtModified = handleGmtModified;
	}

	@Override
	public String toString() {
		return "XsjsglxtHandle [xsjsglxtHandleId=" + xsjsglxtHandleId + ", handleAdministrativeCase="
				+ handleAdministrativeCase + ", handleAdministrativeType=" + handleAdministrativeType
				+ ", handleSponsoredPolice=" + handleSponsoredPolice + ", handleAssistingPolice="
				+ handleAssistingPolice + ", handleSquadronLeader=" + handleSquadronLeader + ", handleGntCreate="
				+ handleGntCreate + ", handleGmtModified=" + handleGmtModified + "]";
	}

}