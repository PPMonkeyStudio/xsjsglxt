package com.xsjsglxt.service.impl.InspectionIdentification;

import com.xsjsglxt.dao.InspectionIdentification.InspectionIdentificationDao;
import com.xsjsglxt.service.InspectionIdentification.InspectionIdentificationService;

public class InspectionIdentificationServiceImpl implements InspectionIdentificationService{
	private InspectionIdentificationDao inspectionIdentificationDao;

	public void setInspectionIdentificationDao(InspectionIdentificationDao inspectionIdentificationDao) {
		this.inspectionIdentificationDao = inspectionIdentificationDao;
	}
	
}
