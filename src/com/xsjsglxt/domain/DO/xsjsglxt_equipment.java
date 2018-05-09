package com.xsjsglxt.domain.DO;

public class xsjsglxt_equipment {
	// id
	private String xsjsglxt_equipment_id;
	// 序号
	private String equipment_serial_number;
	// 装备种类
	private String equipment_kind;
	// 装备名称
	private String equipment_name;
	// 装备类型
	private String equipment_type;
	// 装备特征
	private String equipment_feature;
	// 数量
	private Integer equipment_number;
	// 金额
	private String equipment_money;
	// 启用日期
	private String equipment_enablement_time;
	// 使用情况
	private String equipment_use_note;
	// 备注
	private String equipment_remark;
	// 创建时间
	private String equipment_gmt_create;
	// 修改时间
	private String equipment_gmt_modified;

	public String getXsjsglxt_equipment_id() {
		return xsjsglxt_equipment_id;
	}

	public void setXsjsglxt_equipment_id(String xsjsglxt_equipment_id) {
		this.xsjsglxt_equipment_id = xsjsglxt_equipment_id;
	}

	public String getEquipment_serial_number() {
		return equipment_serial_number;
	}

	public void setEquipment_serial_number(String equipment_serial_number) {
		this.equipment_serial_number = equipment_serial_number;
	}

	public String getEquipment_name() {
		return equipment_name;
	}

	public void setEquipment_name(String equipment_name) {
		this.equipment_name = equipment_name;
	}

	public String getEquipment_type() {
		return equipment_type;
	}

	public void setEquipment_type(String equipment_type) {
		this.equipment_type = equipment_type;
	}

	public String getEquipment_feature() {
		return equipment_feature;
	}

	public void setEquipment_feature(String equipment_feature) {
		this.equipment_feature = equipment_feature;
	}

	public String getEquipment_money() {
		return equipment_money;
	}

	public void setEquipment_money(String equipment_money) {
		this.equipment_money = equipment_money;
	}

	public String getEquipment_enablement_time() {
		return equipment_enablement_time;
	}

	public void setEquipment_enablement_time(String equipment_enablement_time) {
		this.equipment_enablement_time = equipment_enablement_time;
	}

	public String getEquipment_use_note() {
		return equipment_use_note;
	}

	public void setEquipment_use_note(String equipment_use_note) {
		this.equipment_use_note = equipment_use_note;
	}

	public String getEquipment_remark() {
		return equipment_remark;
	}

	public void setEquipment_remark(String equipment_remark) {
		this.equipment_remark = equipment_remark;
	}

	public String getEquipment_gmt_create() {
		return equipment_gmt_create;
	}

	public void setEquipment_gmt_create(String equipment_gmt_create) {
		this.equipment_gmt_create = equipment_gmt_create;
	}

	public Integer getEquipment_number() {
		return equipment_number;
	}

	public void setEquipment_number(Integer equipment_number) {
		this.equipment_number = equipment_number;
	}

	public String getEquipment_gmt_modified() {
		return equipment_gmt_modified;
	}

	public void setEquipment_gmt_modified(String equipment_gmt_modified) {
		this.equipment_gmt_modified = equipment_gmt_modified;
	}

	public String getEquipment_kind() {
		return equipment_kind;
	}

	public void setEquipment_kind(String equipment_kind) {
		this.equipment_kind = equipment_kind;
	}

	@Override
	public String toString() {
		return "xsjsglxt_equipment [xsjsglxt_equipment_id=" + xsjsglxt_equipment_id + ", equipment_serial_number="
				+ equipment_serial_number + ", equipment_name=" + equipment_name + ", equipment_type=" + equipment_type
				+ ", equipment_feature=" + equipment_feature + ", equipment_number=" + equipment_number
				+ ", equipment_money=" + equipment_money + ", equipment_enablement_time=" + equipment_enablement_time
				+ ", equipment_use_note=" + equipment_use_note + ", equipment_remark=" + equipment_remark
				+ ", equipment_gmt_create=" + equipment_gmt_create + ", equipment_gmt_modified="
				+ equipment_gmt_modified + "]";
	}

}
