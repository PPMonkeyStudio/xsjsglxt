package com.xsjsglxt.domain.DTO.Case;

public class MessageDTO {
	private int type;
	private String name;
	private String policeName;

	public MessageDTO(int type, String name, String policeName) {
		super();
		this.type = type;
		this.name = name;
		this.policeName = policeName;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPoliceName() {
		return policeName;
	}

	public void setPoliceName(String policeName) {
		this.policeName = policeName;
	}

}
