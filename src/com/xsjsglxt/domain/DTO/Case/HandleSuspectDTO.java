package com.xsjsglxt.domain.DTO.Case;

import java.util.List;

import com.xsjsglxt.domain.DO.XsjsglxtHandle;
import com.xsjsglxt.domain.DO.XsjsglxtHandleSuspect;

public class HandleSuspectDTO {
	private XsjsglxtHandle xsjsglxtHandle;
	private List<XsjsglxtHandleSuspect> listSuspect;

	public HandleSuspectDTO() {
	}

	public HandleSuspectDTO(XsjsglxtHandle xsjsglxtHandle) {
		this.xsjsglxtHandle = xsjsglxtHandle;
	}

	public XsjsglxtHandle getXsjsglxtHandle() {
		return xsjsglxtHandle;
	}

	public void setXsjsglxtHandle(XsjsglxtHandle xsjsglxtHandle) {
		this.xsjsglxtHandle = xsjsglxtHandle;
	}

	public List<XsjsglxtHandleSuspect> getListSuspect() {
		return listSuspect;
	}

	public void setListSuspect(List<XsjsglxtHandleSuspect> listSuspect) {
		this.listSuspect = listSuspect;
	}

	@Override
	public String toString() {
		return "HandleSuspectDTO [xsjsglxtHandle=" + xsjsglxtHandle + ", listSuspect=" + listSuspect + "]";
	}

}
