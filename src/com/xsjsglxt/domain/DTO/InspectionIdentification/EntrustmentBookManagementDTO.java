package com.xsjsglxt.domain.DTO.InspectionIdentification;

import java.util.List;

import com.xsjsglxt.domain.DO.xsjsglxt_appraisal_letter;
import com.xsjsglxt.domain.DO.xsjsglxt_check_entrustment_book;
import com.xsjsglxt.domain.DO.xsjsglxt_damage_inspection_record;
import com.xsjsglxt.domain.DO.xsjsglxt_death_inspection_record;
import com.xsjsglxt.domain.DO.xsjsglxt_entrustment_sample;
import com.xsjsglxt.domain.DO.xsjsglxt_identifieder_case_confirm_book;
import com.xsjsglxt.domain.DO.xsjsglxt_inspection_record;
import com.xsjsglxt.domain.DO.xsjsglxt_not_acceptance_entrustment_inform;

public class EntrustmentBookManagementDTO {

	private xsjsglxt_check_entrustment_book xsjsglxt_check_entrustment_book;
	private xsjsglxt_identifieder_case_confirm_book xsjsglxt_identifieder_case_confirm_book;
	private xsjsglxt_not_acceptance_entrustment_inform xsjsglxt_not_acceptance_entrustment_inform;
	private xsjsglxt_inspection_record xsjsglxt_inspection_record;
	private xsjsglxt_appraisal_letter xsjsglxt_appraisal_letter;
	private xsjsglxt_death_inspection_record xsjsglxt_death_inspection_record;
	private xsjsglxt_damage_inspection_record xsjsglxt_damage_inspection_record;

	// 检材情况
	private List<xsjsglxt_entrustment_sample> listEntrustmentSample;

	@Override
	public String toString() {
		return "EntrustmentBookManagementDTO [xsjsglxt_check_entrustment_book=" + xsjsglxt_check_entrustment_book + ", xsjsglxt_identifieder_case_confirm_book="
				+ xsjsglxt_identifieder_case_confirm_book + ", xsjsglxt_not_acceptance_entrustment_inform=" + xsjsglxt_not_acceptance_entrustment_inform
				+ ", xsjsglxt_inspection_record=" + xsjsglxt_inspection_record + ", xsjsglxt_appraisal_letter=" + xsjsglxt_appraisal_letter + ", xsjsglxt_death_inspection_record="
				+ xsjsglxt_death_inspection_record + ", xsjsglxt_damage_inspection_record=" + xsjsglxt_damage_inspection_record + ", listEntrustmentSample=" + listEntrustmentSample
				+ "]";
	}

	public List<xsjsglxt_entrustment_sample> getListEntrustmentSample() {
		return listEntrustmentSample;
	}

	public void setListEntrustmentSample(List<xsjsglxt_entrustment_sample> listEntrustmentSample) {
		this.listEntrustmentSample = listEntrustmentSample;
	}

	public xsjsglxt_check_entrustment_book getXsjsglxt_check_entrustment_book() {
		return xsjsglxt_check_entrustment_book;
	}

	public xsjsglxt_identifieder_case_confirm_book getXsjsglxt_identifieder_case_confirm_book() {
		return xsjsglxt_identifieder_case_confirm_book;
	}

	public xsjsglxt_not_acceptance_entrustment_inform getXsjsglxt_not_acceptance_entrustment_inform() {
		return xsjsglxt_not_acceptance_entrustment_inform;
	}

	public xsjsglxt_inspection_record getXsjsglxt_inspection_record() {
		return xsjsglxt_inspection_record;
	}

	public xsjsglxt_appraisal_letter getXsjsglxt_appraisal_letter() {
		return xsjsglxt_appraisal_letter;
	}

	public xsjsglxt_death_inspection_record getXsjsglxt_death_inspection_record() {
		return xsjsglxt_death_inspection_record;
	}

	public xsjsglxt_damage_inspection_record getXsjsglxt_damage_inspection_record() {
		return xsjsglxt_damage_inspection_record;
	}

	public void setXsjsglxt_check_entrustment_book(xsjsglxt_check_entrustment_book xsjsglxt_check_entrustment_book) {
		this.xsjsglxt_check_entrustment_book = xsjsglxt_check_entrustment_book;
	}

	public void setXsjsglxt_identifieder_case_confirm_book(xsjsglxt_identifieder_case_confirm_book xsjsglxt_identifieder_case_confirm_book) {
		this.xsjsglxt_identifieder_case_confirm_book = xsjsglxt_identifieder_case_confirm_book;
	}

	public void setXsjsglxt_not_acceptance_entrustment_inform(xsjsglxt_not_acceptance_entrustment_inform xsjsglxt_not_acceptance_entrustment_inform) {
		this.xsjsglxt_not_acceptance_entrustment_inform = xsjsglxt_not_acceptance_entrustment_inform;
	}

	public void setXsjsglxt_inspection_record(xsjsglxt_inspection_record xsjsglxt_inspection_record) {
		this.xsjsglxt_inspection_record = xsjsglxt_inspection_record;
	}

	public void setXsjsglxt_appraisal_letter(xsjsglxt_appraisal_letter xsjsglxt_appraisal_letter) {
		this.xsjsglxt_appraisal_letter = xsjsglxt_appraisal_letter;
	}

	public void setXsjsglxt_death_inspection_record(xsjsglxt_death_inspection_record xsjsglxt_death_inspection_record) {
		this.xsjsglxt_death_inspection_record = xsjsglxt_death_inspection_record;
	}

	public void setXsjsglxt_damage_inspection_record(xsjsglxt_damage_inspection_record xsjsglxt_damage_inspection_record) {
		this.xsjsglxt_damage_inspection_record = xsjsglxt_damage_inspection_record;
	}

}
