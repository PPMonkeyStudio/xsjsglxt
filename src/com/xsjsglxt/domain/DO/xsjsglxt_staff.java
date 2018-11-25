package com.xsjsglxt.domain.DO;

/*
 * @author 
 *      孙毅
 * @description
 *      警员基本信息类
 */

public class xsjsglxt_staff {
	private String xsjsglxt_staff_id;// 警员id
	private String xsjsglxt_name;// 警员名字
	private String xsjsglxt_sex;// 警员性别
	private String xsjsglxt_age;// 警员年龄
	private String xsjsglxt_nation;// 警员民族
	private String xsjsglxt_nativePlace;// 警员籍贯
	private String staff_birthday;// 警员出生日期
	private String staff_idNumber;// 警员身份证号码
	private String staff_address;// 警员住址
	private String staff_MaxEducationalBackground;// 警员最高学历
	private String staff_politicalStatus;// 政治面貌
	private String staff_joinPartyTime;// 入党时间
	private String staff_joinWorkTime;// 参加工作时间
	private String staff_alarm;// 警员警号
	private String staff_thePoliceTime;// 警员入警时间
	private String staff_isItFormal; // 警种
	private String staff_phone;// 警员手机号码
	private String staff_appliactionFormTime; // 提交申请书时间
	private String staff_delevopObjectTime;// 发展对象时间
	private String staff_degree;// 学位
	private String staff_throughThePolice;// 警务通号
	private String staff_homephone;// 警员家庭电话
	private String staff_QQ;// 警员qq
	private String staff_weixin;// 警员微信
	private String staff_outEmail;// 警员外网邮箱
	private String staff_inEmail;// 警员内网邮箱
	private String staff_photo;// 警员照片
	private String staff_duty;// 警员职务
	private String staff_gmt_create;
	private String staff_gmt_modified;

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "xsjsglxt_staff [xsjsglxt_staff_id=" + xsjsglxt_staff_id + ", xsjsglxt_name=" + xsjsglxt_name
				+ ", xsjsglxt_sex=" + xsjsglxt_sex + ", xsjsglxt_age=" + xsjsglxt_age + ", xsjsglxt_nation="
				+ xsjsglxt_nation + ", xsjsglxt_nativePlace=" + xsjsglxt_nativePlace + ", staff_birthday="
				+ staff_birthday + ", staff_idNumber=" + staff_idNumber + ", staff_address=" + staff_address
				+ ", staff_MaxEducationalBackground=" + staff_MaxEducationalBackground + ", staff_politicalStatus="
				+ staff_politicalStatus + ", staff_joinPartyTime=" + staff_joinPartyTime + ", staff_joinWorkTime="
				+ staff_joinWorkTime + ", staff_alarm=" + staff_alarm + ", staff_thePoliceTime=" + staff_thePoliceTime
				+ ", staff_isItFormal=" + staff_isItFormal + ", staff_phone=" + staff_phone
				+ ", staff_appliactionFormTime=" + staff_appliactionFormTime + ", staff_delevopObjectTime="
				+ staff_delevopObjectTime + ", staff_degree=" + staff_degree + ", staff_throughThePolice="
				+ staff_throughThePolice + ", staff_homephone=" + staff_homephone + ", staff_QQ=" + staff_QQ
				+ ", staff_weixin=" + staff_weixin + ", staff_outEmail=" + staff_outEmail + ", staff_inEmail="
				+ staff_inEmail + ", staff_photo=" + staff_photo + ", staff_duty=" + staff_duty + ", staff_gmt_create="
				+ staff_gmt_create + ", staff_gmt_modified=" + staff_gmt_modified + "]";
	}

	public String getXsjsglxt_staff_id() {
		return xsjsglxt_staff_id;
	}

	public void setXsjsglxt_staff_id(String xsjsglxt_staff_id) {
		this.xsjsglxt_staff_id = xsjsglxt_staff_id;
	}

	public String getStaff_appliactionFormTime() {
		return staff_appliactionFormTime;
	}

	public void setStaff_appliactionFormTime(String staff_appliactionFormTime) {
		this.staff_appliactionFormTime = staff_appliactionFormTime;
	}

	public String getStaff_delevopObjectTime() {
		return staff_delevopObjectTime;
	}

	public void setStaff_delevopObjectTime(String staff_delevopObjectTime) {
		this.staff_delevopObjectTime = staff_delevopObjectTime;
	}

	public String getStaff_degree() {
		return staff_degree;
	}

	public void setStaff_degree(String staff_degree) {
		this.staff_degree = staff_degree;
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

	public String getXsjsglxt_nation() {
		return xsjsglxt_nation;
	}

	public void setXsjsglxt_nation(String xsjsglxt_nation) {
		this.xsjsglxt_nation = xsjsglxt_nation;
	}

	public String getXsjsglxt_nativePlace() {
		return xsjsglxt_nativePlace;
	}

	public void setXsjsglxt_nativePlace(String xsjsglxt_nativePlace) {
		this.xsjsglxt_nativePlace = xsjsglxt_nativePlace;
	}

	public String getStaff_birthday() {
		return staff_birthday;
	}

	public void setStaff_birthday(String staff_birthday) {
		this.staff_birthday = staff_birthday;
	}

	public String getStaff_idNumber() {
		return staff_idNumber;
	}

	public void setStaff_idNumber(String staff_idNumber) {
		this.staff_idNumber = staff_idNumber;
	}

	public String getStaff_address() {
		return staff_address;
	}

	public void setStaff_address(String staff_address) {
		this.staff_address = staff_address;
	}

	public String getStaff_MaxEducationalBackground() {
		return staff_MaxEducationalBackground;
	}

	public void setStaff_MaxEducationalBackground(String staff_MaxEducationalBackground) {
		this.staff_MaxEducationalBackground = staff_MaxEducationalBackground;
	}

	public String getStaff_politicalStatus() {
		return staff_politicalStatus;
	}

	public void setStaff_politicalStatus(String staff_politicalStatus) {
		this.staff_politicalStatus = staff_politicalStatus;
	}

	public String getStaff_joinPartyTime() {
		return staff_joinPartyTime;
	}

	public void setStaff_joinPartyTime(String staff_joinPartyTime) {
		this.staff_joinPartyTime = staff_joinPartyTime;
	}

	public String getStaff_joinWorkTime() {
		return staff_joinWorkTime;
	}

	public void setStaff_joinWorkTime(String staff_joinWorkTime) {
		this.staff_joinWorkTime = staff_joinWorkTime;
	}

	public String getStaff_alarm() {
		return staff_alarm;
	}

	public void setStaff_alarm(String staff_alarm) {
		this.staff_alarm = staff_alarm;
	}

	public String getStaff_thePoliceTime() {
		return staff_thePoliceTime;
	}

	public void setStaff_thePoliceTime(String staff_thePoliceTime) {
		this.staff_thePoliceTime = staff_thePoliceTime;
	}

	public String getStaff_isItFormal() {
		return staff_isItFormal;
	}

	public void setStaff_isItFormal(String staff_isItFormal) {
		this.staff_isItFormal = staff_isItFormal;
	}

	public String getStaff_phone() {
		return staff_phone;
	}

	public void setStaff_phone(String staff_phone) {
		this.staff_phone = staff_phone;
	}

	public String getStaff_throughThePolice() {
		return staff_throughThePolice;
	}

	public void setStaff_throughThePolice(String staff_throughThePolice) {
		this.staff_throughThePolice = staff_throughThePolice;
	}

	public String getStaff_homephone() {
		return staff_homephone;
	}

	public void setStaff_homephone(String staff_homephone) {
		this.staff_homephone = staff_homephone;
	}

	public String getStaff_QQ() {
		return staff_QQ;
	}

	public void setStaff_QQ(String staff_QQ) {
		this.staff_QQ = staff_QQ;
	}

	public String getStaff_weixin() {
		return staff_weixin;
	}

	public void setStaff_weixin(String staff_weixin) {
		this.staff_weixin = staff_weixin;
	}

	public String getStaff_outEmail() {
		return staff_outEmail;
	}

	public void setStaff_outEmail(String staff_outEmail) {
		this.staff_outEmail = staff_outEmail;
	}

	public String getStaff_inEmail() {
		return staff_inEmail;
	}

	public void setStaff_inEmail(String staff_inEmail) {
		this.staff_inEmail = staff_inEmail;
	}

	public String getStaff_photo() {
		return staff_photo;
	}

	public void setStaff_photo(String staff_photo) {
		this.staff_photo = staff_photo;
	}

	public String getStaff_duty() {
		return staff_duty;
	}

	public void setStaff_duty(String staff_duty) {
		this.staff_duty = staff_duty;
	}

	public String getStaff_gmt_create() {
		return staff_gmt_create;
	}

	public void setStaff_gmt_create(String staff_gmt_create) {
		this.staff_gmt_create = staff_gmt_create;
	}

	public String getStaff_gmt_modified() {
		return staff_gmt_modified;
	}

	public void setStaff_gmt_modified(String staff_gmt_modified) {
		this.staff_gmt_modified = staff_gmt_modified;
	}
}
