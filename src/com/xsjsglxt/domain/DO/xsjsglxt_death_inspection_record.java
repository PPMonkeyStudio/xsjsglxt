package com.xsjsglxt.domain.DO;

//尸体检验记录表
public class xsjsglxt_death_inspection_record {
	private String xsjsglxt_death_inspection_record_id;// 尸体检验记录ID
	private String death_inspection_record_belong_entrustment_book;// 所属委托书
	private String death_inspection_record_undertake_personnel;// 承办人员
	private String death_inspection_record_phone;// 联系电话
	private String death_inspection_record_death_name;// 死者姓名
	private String death_inspection_record_death_sex;// 性别
	private String death_inspection_record_death_birth_date;// 出生日期
	private String death_inspection_record_private_capital;// 民族
	private String death_inspection_record_unit_service;// 服务处所
	private String death_inspection_record_address;// 住址
	private String death_inspection_record_inspector;// 检验人
	private String death_inspection_record_inspect_time;// 检验开始时间
	private String death_inspection_record_inspect_stop_time;// 检验结束时间
	private String death_inspection_record_inspect_place;// 检验地点
	private String death_inspection_record_inspect_ambient_temperature;// 检验环境温度
	private String death_inspection_record_ambient_humidity;// 检验环境湿度
	private String death_inspection_record_site_profile;// 现场尸体与血迹概况（尸体所处地点、位置、姿势及与周围环境相互关系等）
	private String death_inspection_record_death_clothing;// 尸体衣着、饰物、随身物品性状与数量及其它物品
	private String death_inspection_record_handover_of_goods;// 随身物品移交情况
	private String death_inspection_record_receiver_goods;// 接收物品人员
	private String death_inspection_record_mark;// 备注
	private String death_inspection_record_autopsy_surface_table_test;// 尸表检验
	private String death_inspection_record_autopsy_surface_table_test_recorder;// 尸表检验记录人
	private String death_inspection_record_autopsy_surface_table_test_recorder_time;// 尸表检验记录时间
	private String death_inspection_record_autopsy_table_test_picture1;// 尸表检验图1
	private String death_inspection_record_autopsy_table_test_picture2;// 尸表检验图2
	private String death_inspection_record_autopsy_table_test_picture3;// 尸表检验图3
	private String death_inspection_record_anatomic_test;// 解剖检验
	private String death_inspection_record_anatomic_time;// 解剖时间
	private String death_inspection_record_anatomic_place;// 解剖地点
	private String death_inspection_record_autopsy_table_test_photographer;// 尸体检验拍照人
	private String death_inspection_record_autopsy_table_test_video;// 尸体检验录像人
	private String death_inspection_record_autopsy_table_test_recorder;// 尸体检验记录人
	private String death_inspection_record_autopsy_table_test_recorder_time;// 尸体检验记录时间
	private String death_inspection_record_anatomy_picture1;// 解剖检验图1
	private String death_inspection_record_anatomy_picture2;// 解剖检验图2
	private String death_inspection_record_anatomy_picture3;// 解剖检验图3
	private String death_inspection_record_gmt_create;
	private String death_inspection_record_gmt_modified;

	@Override
	public String toString() {
		return "xsjsglxt_death_inspection_record [xsjsglxt_death_inspection_record_id="
				+ xsjsglxt_death_inspection_record_id + ", death_inspection_record_belong_entrustment_book="
				+ death_inspection_record_belong_entrustment_book + ", death_inspection_record_undertake_personnel="
				+ death_inspection_record_undertake_personnel + ", death_inspection_record_phone="
				+ death_inspection_record_phone + ", death_inspection_record_death_name="
				+ death_inspection_record_death_name + ", death_inspection_record_death_sex="
				+ death_inspection_record_death_sex + ", death_inspection_record_death_birth_date="
				+ death_inspection_record_death_birth_date + ", death_inspection_record_private_capital="
				+ death_inspection_record_private_capital + ", death_inspection_record_unit_service="
				+ death_inspection_record_unit_service + ", death_inspection_record_address="
				+ death_inspection_record_address + ", death_inspection_record_inspector="
				+ death_inspection_record_inspector + ", death_inspection_record_inspect_time="
				+ death_inspection_record_inspect_time + ", death_inspection_record_inspect_stop_time="
				+ death_inspection_record_inspect_stop_time + ", death_inspection_record_inspect_place="
				+ death_inspection_record_inspect_place + ", death_inspection_record_inspect_ambient_temperature="
				+ death_inspection_record_inspect_ambient_temperature + ", death_inspection_record_ambient_humidity="
				+ death_inspection_record_ambient_humidity + ", death_inspection_record_site_profile="
				+ death_inspection_record_site_profile + ", death_inspection_record_death_clothing="
				+ death_inspection_record_death_clothing + ", death_inspection_record_handover_of_goods="
				+ death_inspection_record_handover_of_goods + ", death_inspection_record_receiver_goods="
				+ death_inspection_record_receiver_goods + ", death_inspection_record_mark="
				+ death_inspection_record_mark + ", death_inspection_record_autopsy_surface_table_test="
				+ death_inspection_record_autopsy_surface_table_test
				+ ", death_inspection_record_autopsy_surface_table_test_recorder="
				+ death_inspection_record_autopsy_surface_table_test_recorder
				+ ", death_inspection_record_autopsy_surface_table_test_recorder_time="
				+ death_inspection_record_autopsy_surface_table_test_recorder_time
				+ ", death_inspection_record_autopsy_table_test_picture1="
				+ death_inspection_record_autopsy_table_test_picture1
				+ ", death_inspection_record_autopsy_table_test_picture2="
				+ death_inspection_record_autopsy_table_test_picture2
				+ ", death_inspection_record_autopsy_table_test_picture3="
				+ death_inspection_record_autopsy_table_test_picture3 + ", death_inspection_record_anatomic_test="
				+ death_inspection_record_anatomic_test + ", death_inspection_record_anatomic_time="
				+ death_inspection_record_anatomic_time + ", death_inspection_record_anatomic_place="
				+ death_inspection_record_anatomic_place + ", death_inspection_record_autopsy_table_test_photographer="
				+ death_inspection_record_autopsy_table_test_photographer
				+ ", death_inspection_record_autopsy_table_test_video="
				+ death_inspection_record_autopsy_table_test_video
				+ ", death_inspection_record_autopsy_table_test_recorder="
				+ death_inspection_record_autopsy_table_test_recorder
				+ ", death_inspection_record_autopsy_table_test_recorder_time="
				+ death_inspection_record_autopsy_table_test_recorder_time
				+ ", death_inspection_record_anatomy_picture1=" + death_inspection_record_anatomy_picture1
				+ ", death_inspection_record_anatomy_picture2=" + death_inspection_record_anatomy_picture2
				+ ", death_inspection_record_anatomy_picture3=" + death_inspection_record_anatomy_picture3
				+ ", death_inspection_record_gmt_create=" + death_inspection_record_gmt_create
				+ ", death_inspection_record_gmt_modified=" + death_inspection_record_gmt_modified + "]";
	}

	public String getXsjsglxt_death_inspection_record_id() {
		return xsjsglxt_death_inspection_record_id;
	}

	public String getDeath_inspection_record_belong_entrustment_book() {
		return death_inspection_record_belong_entrustment_book;
	}

	public String getDeath_inspection_record_undertake_personnel() {
		return death_inspection_record_undertake_personnel;
	}

	public String getDeath_inspection_record_phone() {
		return death_inspection_record_phone;
	}

	public String getDeath_inspection_record_inspect_stop_time() {
		return death_inspection_record_inspect_stop_time;
	}

	public void setDeath_inspection_record_inspect_stop_time(String death_inspection_record_inspect_stop_time) {
		this.death_inspection_record_inspect_stop_time = death_inspection_record_inspect_stop_time;
	}

	public String getDeath_inspection_record_death_name() {
		return death_inspection_record_death_name;
	}

	public String getDeath_inspection_record_death_sex() {
		return death_inspection_record_death_sex;
	}

	public String getDeath_inspection_record_death_birth_date() {
		return death_inspection_record_death_birth_date;
	}

	public String getDeath_inspection_record_private_capital() {
		return death_inspection_record_private_capital;
	}

	public String getDeath_inspection_record_unit_service() {
		return death_inspection_record_unit_service;
	}

	public String getDeath_inspection_record_address() {
		return death_inspection_record_address;
	}

	public String getDeath_inspection_record_inspector() {
		return death_inspection_record_inspector;
	}

	public String getDeath_inspection_record_inspect_time() {
		return death_inspection_record_inspect_time;
	}

	public String getDeath_inspection_record_inspect_place() {
		return death_inspection_record_inspect_place;
	}

	public String getDeath_inspection_record_inspect_ambient_temperature() {
		return death_inspection_record_inspect_ambient_temperature;
	}

	public String getDeath_inspection_record_ambient_humidity() {
		return death_inspection_record_ambient_humidity;
	}

	public String getDeath_inspection_record_site_profile() {
		return death_inspection_record_site_profile;
	}

	public String getDeath_inspection_record_death_clothing() {
		return death_inspection_record_death_clothing;
	}

	public String getDeath_inspection_record_handover_of_goods() {
		return death_inspection_record_handover_of_goods;
	}

	public String getDeath_inspection_record_receiver_goods() {
		return death_inspection_record_receiver_goods;
	}

	public String getDeath_inspection_record_mark() {
		return death_inspection_record_mark;
	}

	public String getDeath_inspection_record_autopsy_surface_table_test() {
		return death_inspection_record_autopsy_surface_table_test;
	}

	public String getDeath_inspection_record_autopsy_surface_table_test_recorder() {
		return death_inspection_record_autopsy_surface_table_test_recorder;
	}

	public String getDeath_inspection_record_autopsy_surface_table_test_recorder_time() {
		return death_inspection_record_autopsy_surface_table_test_recorder_time;
	}

	public String getDeath_inspection_record_autopsy_table_test_picture1() {
		return death_inspection_record_autopsy_table_test_picture1;
	}

	public String getDeath_inspection_record_autopsy_table_test_picture2() {
		return death_inspection_record_autopsy_table_test_picture2;
	}

	public String getDeath_inspection_record_autopsy_table_test_picture3() {
		return death_inspection_record_autopsy_table_test_picture3;
	}

	public String getDeath_inspection_record_anatomic_test() {
		return death_inspection_record_anatomic_test;
	}

	public String getDeath_inspection_record_anatomic_time() {
		return death_inspection_record_anatomic_time;
	}

	public String getDeath_inspection_record_anatomic_place() {
		return death_inspection_record_anatomic_place;
	}

	public String getDeath_inspection_record_autopsy_table_test_photographer() {
		return death_inspection_record_autopsy_table_test_photographer;
	}

	public String getDeath_inspection_record_autopsy_table_test_video() {
		return death_inspection_record_autopsy_table_test_video;
	}

	public String getDeath_inspection_record_autopsy_table_test_recorder() {
		return death_inspection_record_autopsy_table_test_recorder;
	}

	public String getDeath_inspection_record_autopsy_table_test_recorder_time() {
		return death_inspection_record_autopsy_table_test_recorder_time;
	}

	public String getDeath_inspection_record_anatomy_picture1() {
		return death_inspection_record_anatomy_picture1;
	}

	public String getDeath_inspection_record_anatomy_picture2() {
		return death_inspection_record_anatomy_picture2;
	}

	public String getDeath_inspection_record_anatomy_picture3() {
		return death_inspection_record_anatomy_picture3;
	}

	public String getDeath_inspection_record_gmt_create() {
		return death_inspection_record_gmt_create;
	}

	public String getDeath_inspection_record_gmt_modified() {
		return death_inspection_record_gmt_modified;
	}

	public void setXsjsglxt_death_inspection_record_id(String xsjsglxt_death_inspection_record_id) {
		this.xsjsglxt_death_inspection_record_id = xsjsglxt_death_inspection_record_id;
	}

	public void setDeath_inspection_record_belong_entrustment_book(
			String death_inspection_record_belong_entrustment_book) {
		this.death_inspection_record_belong_entrustment_book = death_inspection_record_belong_entrustment_book;
	}

	public void setDeath_inspection_record_undertake_personnel(String death_inspection_record_undertake_personnel) {
		this.death_inspection_record_undertake_personnel = death_inspection_record_undertake_personnel;
	}

	public void setDeath_inspection_record_phone(String death_inspection_record_phone) {
		this.death_inspection_record_phone = death_inspection_record_phone;
	}

	public void setDeath_inspection_record_death_name(String death_inspection_record_death_name) {
		this.death_inspection_record_death_name = death_inspection_record_death_name;
	}

	public void setDeath_inspection_record_death_sex(String death_inspection_record_death_sex) {
		this.death_inspection_record_death_sex = death_inspection_record_death_sex;
	}

	public void setDeath_inspection_record_death_birth_date(String death_inspection_record_death_birth_date) {
		this.death_inspection_record_death_birth_date = death_inspection_record_death_birth_date;
	}

	public void setDeath_inspection_record_private_capital(String death_inspection_record_private_capital) {
		this.death_inspection_record_private_capital = death_inspection_record_private_capital;
	}

	public void setDeath_inspection_record_unit_service(String death_inspection_record_unit_service) {
		this.death_inspection_record_unit_service = death_inspection_record_unit_service;
	}

	public void setDeath_inspection_record_address(String death_inspection_record_address) {
		this.death_inspection_record_address = death_inspection_record_address;
	}

	public void setDeath_inspection_record_inspector(String death_inspection_record_inspector) {
		this.death_inspection_record_inspector = death_inspection_record_inspector;
	}

	public void setDeath_inspection_record_inspect_time(String death_inspection_record_inspect_time) {
		this.death_inspection_record_inspect_time = death_inspection_record_inspect_time;
	}

	public void setDeath_inspection_record_inspect_place(String death_inspection_record_inspect_place) {
		this.death_inspection_record_inspect_place = death_inspection_record_inspect_place;
	}

	public void setDeath_inspection_record_inspect_ambient_temperature(
			String death_inspection_record_inspect_ambient_temperature) {
		this.death_inspection_record_inspect_ambient_temperature = death_inspection_record_inspect_ambient_temperature;
	}

	public void setDeath_inspection_record_ambient_humidity(String death_inspection_record_ambient_humidity) {
		this.death_inspection_record_ambient_humidity = death_inspection_record_ambient_humidity;
	}

	public void setDeath_inspection_record_site_profile(String death_inspection_record_site_profile) {
		this.death_inspection_record_site_profile = death_inspection_record_site_profile;
	}

	public void setDeath_inspection_record_death_clothing(String death_inspection_record_death_clothing) {
		this.death_inspection_record_death_clothing = death_inspection_record_death_clothing;
	}

	public void setDeath_inspection_record_handover_of_goods(String death_inspection_record_handover_of_goods) {
		this.death_inspection_record_handover_of_goods = death_inspection_record_handover_of_goods;
	}

	public void setDeath_inspection_record_receiver_goods(String death_inspection_record_receiver_goods) {
		this.death_inspection_record_receiver_goods = death_inspection_record_receiver_goods;
	}

	public void setDeath_inspection_record_mark(String death_inspection_record_mark) {
		this.death_inspection_record_mark = death_inspection_record_mark;
	}

	public void setDeath_inspection_record_autopsy_surface_table_test(
			String death_inspection_record_autopsy_surface_table_test) {
		this.death_inspection_record_autopsy_surface_table_test = death_inspection_record_autopsy_surface_table_test;
	}

	public void setDeath_inspection_record_autopsy_surface_table_test_recorder(
			String death_inspection_record_autopsy_surface_table_test_recorder) {
		this.death_inspection_record_autopsy_surface_table_test_recorder = death_inspection_record_autopsy_surface_table_test_recorder;
	}

	public void setDeath_inspection_record_autopsy_surface_table_test_recorder_time(
			String death_inspection_record_autopsy_surface_table_test_recorder_time) {
		this.death_inspection_record_autopsy_surface_table_test_recorder_time = death_inspection_record_autopsy_surface_table_test_recorder_time;
	}

	public void setDeath_inspection_record_autopsy_table_test_picture1(
			String death_inspection_record_autopsy_table_test_picture1) {
		this.death_inspection_record_autopsy_table_test_picture1 = death_inspection_record_autopsy_table_test_picture1;
	}

	public void setDeath_inspection_record_autopsy_table_test_picture2(
			String death_inspection_record_autopsy_table_test_picture2) {
		this.death_inspection_record_autopsy_table_test_picture2 = death_inspection_record_autopsy_table_test_picture2;
	}

	public void setDeath_inspection_record_autopsy_table_test_picture3(
			String death_inspection_record_autopsy_table_test_picture3) {
		this.death_inspection_record_autopsy_table_test_picture3 = death_inspection_record_autopsy_table_test_picture3;
	}

	public void setDeath_inspection_record_anatomic_test(String death_inspection_record_anatomic_test) {
		this.death_inspection_record_anatomic_test = death_inspection_record_anatomic_test;
	}

	public void setDeath_inspection_record_anatomic_time(String death_inspection_record_anatomic_time) {
		this.death_inspection_record_anatomic_time = death_inspection_record_anatomic_time;
	}

	public void setDeath_inspection_record_anatomic_place(String death_inspection_record_anatomic_place) {
		this.death_inspection_record_anatomic_place = death_inspection_record_anatomic_place;
	}

	public void setDeath_inspection_record_autopsy_table_test_photographer(
			String death_inspection_record_autopsy_table_test_photographer) {
		this.death_inspection_record_autopsy_table_test_photographer = death_inspection_record_autopsy_table_test_photographer;
	}

	public void setDeath_inspection_record_autopsy_table_test_video(
			String death_inspection_record_autopsy_table_test_video) {
		this.death_inspection_record_autopsy_table_test_video = death_inspection_record_autopsy_table_test_video;
	}

	public void setDeath_inspection_record_autopsy_table_test_recorder(
			String death_inspection_record_autopsy_table_test_recorder) {
		this.death_inspection_record_autopsy_table_test_recorder = death_inspection_record_autopsy_table_test_recorder;
	}

	public void setDeath_inspection_record_autopsy_table_test_recorder_time(
			String death_inspection_record_autopsy_table_test_recorder_time) {
		this.death_inspection_record_autopsy_table_test_recorder_time = death_inspection_record_autopsy_table_test_recorder_time;
	}

	public void setDeath_inspection_record_anatomy_picture1(String death_inspection_record_anatomy_picture1) {
		this.death_inspection_record_anatomy_picture1 = death_inspection_record_anatomy_picture1;
	}

	public void setDeath_inspection_record_anatomy_picture2(String death_inspection_record_anatomy_picture2) {
		this.death_inspection_record_anatomy_picture2 = death_inspection_record_anatomy_picture2;
	}

	public void setDeath_inspection_record_anatomy_picture3(String death_inspection_record_anatomy_picture3) {
		this.death_inspection_record_anatomy_picture3 = death_inspection_record_anatomy_picture3;
	}

	public void setDeath_inspection_record_gmt_create(String death_inspection_record_gmt_create) {
		this.death_inspection_record_gmt_create = death_inspection_record_gmt_create;
	}

	public void setDeath_inspection_record_gmt_modified(String death_inspection_record_gmt_modified) {
		this.death_inspection_record_gmt_modified = death_inspection_record_gmt_modified;
	}

}
