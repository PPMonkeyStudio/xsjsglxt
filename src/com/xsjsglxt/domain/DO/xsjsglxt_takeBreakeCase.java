package com.xsjsglxt.domain.DO;

public class xsjsglxt_takeBreakeCase {
	private String take_id;
	private String take_name;
	private String take_case;
	private String take_gmt_create;
	private String take_gmt_modified;

	@Override
	public String toString() {
		return "xsjsglxt_takeBreakeCase [take_id=" + take_id + ", take_name=" + take_name + ", take_case=" + take_case
				+ ", take_gmt_create=" + take_gmt_create + ", take_gmt_modified=" + take_gmt_modified + "]";
	}

	public xsjsglxt_takeBreakeCase(String take_id, String take_name, String take_case, String take_gmt_create,
			String take_gmt_modified) {
		super();
		this.take_id = take_id;
		this.take_name = take_name;
		this.take_case = take_case;
		this.take_gmt_create = take_gmt_create;
		this.take_gmt_modified = take_gmt_modified;
	}

	public String getTake_id() {
		return take_id;
	}

	public void setTake_id(String take_id) {
		this.take_id = take_id;
	}

	public String getTake_name() {
		return take_name;
	}

	public void setTake_name(String take_name) {
		this.take_name = take_name;
	}

	public String getTake_case() {
		return take_case;
	}

	public void setTake_case(String take_case) {
		this.take_case = take_case;
	}

	public String getTake_gmt_create() {
		return take_gmt_create;
	}

	public void setTake_gmt_create(String take_gmt_create) {
		this.take_gmt_create = take_gmt_create;
	}

	public String getTake_gmt_modified() {
		return take_gmt_modified;
	}

	public void setTake_gmt_modified(String take_gmt_modified) {
		this.take_gmt_modified = take_gmt_modified;
	}
}
