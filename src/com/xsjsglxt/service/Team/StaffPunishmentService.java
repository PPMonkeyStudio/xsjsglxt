package com.xsjsglxt.service.Team;

import java.util.List;

import com.xsjsglxt.domain.DO.xsjsglxt_staffPunishment;

public interface StaffPunishmentService {

	String savePunishment(List<xsjsglxt_staffPunishment> punishments);

	String deletePunishment(String xsjsglxt_staffPunishment_id);

	String deletePunishments(String staffPunishment_staff);

	String updatePunishment(xsjsglxt_staffPunishment punishment);

	xsjsglxt_staffPunishment getPunishment(String xsjsglxt_staffPunishment_id);

	List<xsjsglxt_staffPunishment> getPunishments(String staffPunishment_staff);

}
