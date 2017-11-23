package com.xsjsglxt.action.InspectionIdentification;

import com.opensymphony.xwork2.ActionSupport;
import com.xsjsglxt.service.InspectionIdentification.InspectionIdentificationService;

public class InspectionIdentificationAction extends ActionSupport{
	private InspectionIdentificationService inspectionIdentificationService;

	public void setInspectionIdentificationService(InspectionIdentificationService inspectionIdentificationService) {
		this.inspectionIdentificationService = inspectionIdentificationService;
	}

	// 点击进入检验鉴定委托管理
	public String tranceCheckEntrustmentBookManagement() {
		return "traceCheckBookManagement";
	}

}
