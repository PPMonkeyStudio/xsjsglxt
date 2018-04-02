package com.xsjsglxt.dao.Team;

import java.util.List;

import com.xsjsglxt.domain.DO.xsjsglxt_staffPrinciple;

public interface StaffPrincipleDao {

	String savePrinciples(List<xsjsglxt_staffPrinciple> principles);

	String deletePrinciple(xsjsglxt_staffPrinciple principle);

	String deletePrinciples(String staffPrinciple_staff);

	xsjsglxt_staffPrinciple getPrincipleByPrincipleId(String xsjsglxt_staffPrinciple_id);

	List<xsjsglxt_staffPrinciple> getPrinciples(String staffPrinciple_staff);

}
