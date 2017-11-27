package com.xsjsglxt.domain.DTO.InspectionIdentification;

import com.xsjsglxt.domain.DO.xsjsglxt_check_entrustment_book;
import com.xsjsglxt.domain.DO.xsjsglxt_identifieder_case_confirm_book;
import com.xsjsglxt.domain.DO.xsjsglxt_not_acceptance_entrustment_inform;

public class EntrustmentBookManagementDTO {

	private xsjsglxt_check_entrustment_book xsjsglxt_check_entrustment_book;
	private xsjsglxt_identifieder_case_confirm_book xsjsglxt_identifieder_case_confirm_book;
	private xsjsglxt_not_acceptance_entrustment_inform xsjsglxt_not_acceptance_entrustment_inform;

	@Override
	public String toString() {
		return "EntrustmentBookManagementDTO [xsjsglxt_check_entrustment_book=" + xsjsglxt_check_entrustment_book
				+ ", xsjsglxt_identifieder_case_confirm_book=" + xsjsglxt_identifieder_case_confirm_book
				+ ", xsjsglxt_not_acceptance_entrustment_inform=" + xsjsglxt_not_acceptance_entrustment_inform + "]";
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

	public void setXsjsglxt_check_entrustment_book(xsjsglxt_check_entrustment_book xsjsglxt_check_entrustment_book) {
		this.xsjsglxt_check_entrustment_book = xsjsglxt_check_entrustment_book;
	}

	public void setXsjsglxt_identifieder_case_confirm_book(
			xsjsglxt_identifieder_case_confirm_book xsjsglxt_identifieder_case_confirm_book) {
		this.xsjsglxt_identifieder_case_confirm_book = xsjsglxt_identifieder_case_confirm_book;
	}

	public void setXsjsglxt_not_acceptance_entrustment_inform(
			xsjsglxt_not_acceptance_entrustment_inform xsjsglxt_not_acceptance_entrustment_inform) {
		this.xsjsglxt_not_acceptance_entrustment_inform = xsjsglxt_not_acceptance_entrustment_inform;
	}

}
