package com.xsjsglxt.service.Team;

import java.util.List;

import com.xsjsglxt.domain.DO.xsjsglxt_staffPrinciple;

public interface StaffPrincipleService {

	String savePrinciples(List<xsjsglxt_staffPrinciple> principles);

	String deletePrinciple(xsjsglxt_staffPrinciple principle);

	String deletePrinciples(String staffPrinciple_staff);

	String updatePrinciple(xsjsglxt_staffPrinciple principle);

	xsjsglxt_staffPrinciple getPrinciple(String xsjsglxt_staffPrinciple_id);

	List<xsjsglxt_staffPrinciple> getPrinciples(String staffPrinciple_staff);

}
