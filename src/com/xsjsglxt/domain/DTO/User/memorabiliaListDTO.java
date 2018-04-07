package com.xsjsglxt.domain.DTO.User;

public class memorabiliaListDTO {
	private String memorabilia_id;
	private String memorabilia_title;
	private String memorabilia_join_human;
	private String memorabilia_time;

	public memorabiliaListDTO(String memorabilia_id, String memorabilia_title, String memorabilia_join_human,
			String memorabilia_time) {
		// TODO Auto-generated constructor stub
		this.memorabilia_id = memorabilia_id;
		this.memorabilia_join_human = memorabilia_join_human;
		this.memorabilia_title = memorabilia_title;
		this.memorabilia_time = memorabilia_time;
	}

	public String getMemorabilia_id() {
		return memorabilia_id;
	}

	public void setMemorabilia_id(String memorabilia_id) {
		this.memorabilia_id = memorabilia_id;
	}

	public String getMemorabilia_title() {
		return memorabilia_title;
	}

	public void setMemorabilia_title(String memorabilia_title) {
		this.memorabilia_title = memorabilia_title;
	}

	public String getMemorabilia_join_human() {
		return memorabilia_join_human;
	}

	public void setMemorabilia_join_human(String memorabilia_join_human) {
		this.memorabilia_join_human = memorabilia_join_human;
	}

	public String getMemorabilia_time() {
		return memorabilia_time;
	}

	public void setMemorabilia_time(String memorabilia_time) {
		this.memorabilia_time = memorabilia_time;
	}

	@Override
	public String toString() {
		return "memorabiliaListDTO [memorabilia_id=" + memorabilia_id + ", memorabilia_title=" + memorabilia_title
				+ ", memorabilia_join_human=" + memorabilia_join_human + ", memorabilia_time=" + memorabilia_time
				+ ", getMemorabilia_id()=" + getMemorabilia_id() + ", getMemorabilia_title()=" + getMemorabilia_title()
				+ ", getMemorabilia_join_human()=" + getMemorabilia_join_human() + ", getMemorabilia_time()="
				+ getMemorabilia_time() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

}
