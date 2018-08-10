package com.xsjsglxt.domain.DO;

/**
 * XsjsglxtHandleSuspect entity. @author MyEclipse Persistence Tools
 */

public class XsjsglxtHandleSuspect implements java.io.Serializable {

	// Fields

	private String xsjsglxiHandleSuspectId;// id
	private String xsjsglxtHandleId;// 所属办案
	private String handleSuspectName;// 嫌疑人姓名
	private String handleSuspectSex;// 嫌疑人性别
	private String handleSuspectCard;// 嫌疑人身份证
	private String handleSuspectRecipient;// 涉嫌罪名
	private String handleSuspectCatch;// 抓取时间
	private String handleSuspectGoods;// 携带物品
	private String handleSuspectHand;// 交移时间
	private String handleSuspectPeople;// 交移人
	private String handleSuspectReceive;// 接收人
	private String handleSuspectHandling;// 处理方式
	private String handleSuspectTime;// 处理时间
	private String handleSuspectPicture;// 照片
	private String handleSuspectProcessing;// 处理类型
	private String handleSuspectProcessingTime;// 日期
	private String handleSuspectDetentionDay;// 拘留天数
	private String handleEndTimeaOfDetention;// 拘留结束日期
	private String handleGmtCreate;//创建日期
	private String handleGmtModified;//修改日期

	// Constructors

	/** default constructor */
	public XsjsglxtHandleSuspect() {
	}

	/** minimal constructor */
	public XsjsglxtHandleSuspect(String xsjsglxiHandleSuspectId) {
		this.xsjsglxiHandleSuspectId = xsjsglxiHandleSuspectId;
	}

	/** full constructor */
	public XsjsglxtHandleSuspect(String xsjsglxiHandleSuspectId, String xsjsglxtHandleId, String handleSuspectName,
			String handleSuspectSex, String handleSuspectCard, String handleSuspectCatch, String handleSuspectGoods,
			String handleSuspectHand, String handleSuspectPeople, String handleSuspectReceive,
			String handleSuspectRecipient, String handleSuspectHandling, String handleSuspectTime,
			String handleSuspectPicture, String handleGmtCreate, String handleGmtModified) {
		this.xsjsglxiHandleSuspectId = xsjsglxiHandleSuspectId;
		this.xsjsglxtHandleId = xsjsglxtHandleId;
		this.handleSuspectName = handleSuspectName;
		this.handleSuspectSex = handleSuspectSex;
		this.handleSuspectCard = handleSuspectCard;
		this.handleSuspectCatch = handleSuspectCatch;
		this.handleSuspectGoods = handleSuspectGoods;
		this.handleSuspectHand = handleSuspectHand;
		this.handleSuspectPeople = handleSuspectPeople;
		this.handleSuspectReceive = handleSuspectReceive;
		this.handleSuspectRecipient = handleSuspectRecipient;
		this.handleSuspectHandling = handleSuspectHandling;
		this.handleSuspectTime = handleSuspectTime;
		this.handleSuspectPicture = handleSuspectPicture;
		this.handleGmtCreate = handleGmtCreate;
		this.handleGmtModified = handleGmtModified;
	}

	// Property accessors

	public String getXsjsglxiHandleSuspectId() {
		return this.xsjsglxiHandleSuspectId;
	}

	public void setXsjsglxiHandleSuspectId(String xsjsglxiHandleSuspectId) {
		this.xsjsglxiHandleSuspectId = xsjsglxiHandleSuspectId;
	}

	public String getXsjsglxtHandleId() {
		return this.xsjsglxtHandleId;
	}

	public void setXsjsglxtHandleId(String xsjsglxtHandleId) {
		this.xsjsglxtHandleId = xsjsglxtHandleId;
	}

	public String getHandleSuspectName() {
		return this.handleSuspectName;
	}

	public void setHandleSuspectName(String handleSuspectName) {
		this.handleSuspectName = handleSuspectName;
	}

	public String getHandleSuspectSex() {
		return this.handleSuspectSex;
	}

	public void setHandleSuspectSex(String handleSuspectSex) {
		this.handleSuspectSex = handleSuspectSex;
	}

	public String getHandleSuspectCard() {
		return this.handleSuspectCard;
	}

	public void setHandleSuspectCard(String handleSuspectCard) {
		this.handleSuspectCard = handleSuspectCard;
	}

	public String getHandleSuspectCatch() {
		return this.handleSuspectCatch;
	}

	public void setHandleSuspectCatch(String handleSuspectCatch) {
		this.handleSuspectCatch = handleSuspectCatch;
	}

	public String getHandleSuspectGoods() {
		return this.handleSuspectGoods;
	}

	public void setHandleSuspectGoods(String handleSuspectGoods) {
		this.handleSuspectGoods = handleSuspectGoods;
	}

	public String getHandleSuspectHand() {
		return this.handleSuspectHand;
	}

	public void setHandleSuspectHand(String handleSuspectHand) {
		this.handleSuspectHand = handleSuspectHand;
	}

	public String getHandleSuspectPeople() {
		return this.handleSuspectPeople;
	}

	public void setHandleSuspectPeople(String handleSuspectPeople) {
		this.handleSuspectPeople = handleSuspectPeople;
	}

	public String getHandleSuspectReceive() {
		return this.handleSuspectReceive;
	}

	public void setHandleSuspectReceive(String handleSuspectReceive) {
		this.handleSuspectReceive = handleSuspectReceive;
	}

	public String getHandleSuspectRecipient() {
		return this.handleSuspectRecipient;
	}

	public void setHandleSuspectRecipient(String handleSuspectRecipient) {
		this.handleSuspectRecipient = handleSuspectRecipient;
	}

	public String getHandleSuspectHandling() {
		return this.handleSuspectHandling;
	}

	public void setHandleSuspectHandling(String handleSuspectHandling) {
		this.handleSuspectHandling = handleSuspectHandling;
	}

	public String getHandleSuspectTime() {
		return this.handleSuspectTime;
	}

	public void setHandleSuspectTime(String handleSuspectTime) {
		this.handleSuspectTime = handleSuspectTime;
	}

	public String getHandleSuspectPicture() {
		return this.handleSuspectPicture;
	}

	public void setHandleSuspectPicture(String handleSuspectPicture) {
		this.handleSuspectPicture = handleSuspectPicture;
	}

	public String getHandleGmtCreate() {
		return this.handleGmtCreate;
	}

	public void setHandleGmtCreate(String handleGmtCreate) {
		this.handleGmtCreate = handleGmtCreate;
	}

	public String getHandleGmtModified() {
		return this.handleGmtModified;
	}

	public void setHandleGmtModified(String handleGmtModified) {
		this.handleGmtModified = handleGmtModified;
	}

	public String getHandleSuspectProcessing() {
		return handleSuspectProcessing;
	}

	public void setHandleSuspectProcessing(String handleSuspectProcessing) {
		this.handleSuspectProcessing = handleSuspectProcessing;
	}

	public String getHandleSuspectProcessingTime() {
		return handleSuspectProcessingTime;
	}

	public void setHandleSuspectProcessingTime(String handleSuspectProcessingTime) {
		this.handleSuspectProcessingTime = handleSuspectProcessingTime;
	}

	public String getHandleSuspectDetentionDay() {
		return handleSuspectDetentionDay;
	}

	public void setHandleSuspectDetentionDay(String handleSuspectDetentionDay) {
		this.handleSuspectDetentionDay = handleSuspectDetentionDay;
	}

	public String getHandleEndTimeaOfDetention() {
		return handleEndTimeaOfDetention;
	}

	public void setHandleEndTimeaOfDetention(String handleEndTimeaOfDetention) {
		this.handleEndTimeaOfDetention = handleEndTimeaOfDetention;
	}

	@Override
	public String toString() {
		return "XsjsglxtHandleSuspect [xsjsglxiHandleSuspectId=" + xsjsglxiHandleSuspectId + ", xsjsglxtHandleId="
				+ xsjsglxtHandleId + ", handleSuspectName=" + handleSuspectName + ", handleSuspectSex="
				+ handleSuspectSex + ", handleSuspectCard=" + handleSuspectCard + ", handleSuspectRecipient="
				+ handleSuspectRecipient + ", handleSuspectCatch=" + handleSuspectCatch + ", handleSuspectGoods="
				+ handleSuspectGoods + ", handleSuspectHand=" + handleSuspectHand + ", handleSuspectPeople="
				+ handleSuspectPeople + ", handleSuspectReceive=" + handleSuspectReceive + ", handleSuspectHandling="
				+ handleSuspectHandling + ", handleSuspectTime=" + handleSuspectTime + ", handleSuspectPicture="
				+ handleSuspectPicture + ", handleSuspectProcessing=" + handleSuspectProcessing
				+ ", handleSuspectProcessingTime=" + handleSuspectProcessingTime + ", handleSuspectDetentionDay="
				+ handleSuspectDetentionDay + ", handleEndTimeaOfDetention=" + handleEndTimeaOfDetention
				+ ", handleGmtCreate=" + handleGmtCreate + ", handleGmtModified=" + handleGmtModified + "]";
	}

}