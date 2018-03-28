package com.xsjsglxt.dao.Team;

import java.util.List;

import com.xsjsglxt.domain.DO.xsjsglxt_staffPunishment;

public interface StaffPunishmentDao {

	String savePunishment(List<xsjsglxt_staffPunishment> punishments);

	String deletePunishment(String xsjsglxt_staffPunishment_id);

	String deletePunishments(String staffPunishment_staff);

	xsjsglxt_staffPunishment getPunishment(String xsjsglxt_staffPunishment_id);

	List<xsjsglxt_staffPunishment> getPunishments(String staffPunishment_staff);

}
