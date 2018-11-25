package com.xsjsglxt.domain.DTO.Case;

public class SuspectInforDTO {
	private String id;
	private String case_name;
	private String name;
	private int sex;
	private int processType;
	private String start;
	private String end;

	public SuspectInforDTO(String id, String case_name, String name, int sex, int processType, String start,
			String end) {
		super();
		this.id = id;
		this.case_name = case_name;
		this.name = name;
		this.sex = sex;
		this.processType = processType;
		this.start = start;
		this.end = end;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCase_name() {
		return case_name;
	}

	public void setCase_name(String case_name) {
		this.case_name = case_name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public int getProcessType() {
		return processType;
	}

	public void setProcessType(int processType) {
		this.processType = processType;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

}
