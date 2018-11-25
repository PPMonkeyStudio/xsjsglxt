package com.xsjsglxt.domain.DO;

//随带物品表
public class xsjsglxt_take_goods {
	private String goods_id; // 物品id
	private String goods_suspect;// 所属嫌疑人
	private String goods_name;// 物品名
	private String goods_time;// 移交时间
	private String goods_send_man;// 移交人
	private String goods_receive_man;// 接收人
	private String goods_process_method;// 处理方式
	private String goods_process_time;// 处理时间
	private String goods_photo_path;// 照片路径
	private String goods_gmt_create;// 创建时间
	private String goods_gmt_modified;// 修改时间

	public String getGoods_id() {
		return goods_id;
	}

	public void setGoods_id(String goods_id) {
		this.goods_id = goods_id;
	}

	public String getGoods_suspect() {
		return goods_suspect;
	}

	public void setGoods_suspect(String goods_suspect) {
		this.goods_suspect = goods_suspect;
	}

	public String getGoods_name() {
		return goods_name;
	}

	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}

	public String getGoods_time() {
		return goods_time;
	}

	public void setGoods_time(String goods_time) {
		this.goods_time = goods_time;
	}

	public String getGoods_send_man() {
		return goods_send_man;
	}

	public void setGoods_send_man(String goods_send_man) {
		this.goods_send_man = goods_send_man;
	}

	public String getGoods_receive_man() {
		return goods_receive_man;
	}

	public void setGoods_receive_man(String goods_receive_man) {
		this.goods_receive_man = goods_receive_man;
	}

	public String getGoods_process_method() {
		return goods_process_method;
	}

	public void setGoods_process_method(String goods_process_method) {
		this.goods_process_method = goods_process_method;
	}

	public String getGoods_process_time() {
		return goods_process_time;
	}

	public void setGoods_process_time(String goods_process_time) {
		this.goods_process_time = goods_process_time;
	}

	public String getGoods_photo_path() {
		return goods_photo_path;
	}

	public void setGoods_photo_path(String goods_photo_path) {
		this.goods_photo_path = goods_photo_path;
	}

	public String getGoods_gmt_create() {
		return goods_gmt_create;
	}

	public void setGoods_gmt_create(String goods_gmt_create) {
		this.goods_gmt_create = goods_gmt_create;
	}

	public String getGoods_gmt_modified() {
		return goods_gmt_modified;
	}

	public void setGoods_gmt_modified(String goods_gmt_modified) {
		this.goods_gmt_modified = goods_gmt_modified;
	}

}
