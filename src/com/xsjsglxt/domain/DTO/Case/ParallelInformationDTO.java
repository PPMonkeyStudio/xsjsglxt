package com.xsjsglxt.domain.DTO.Case;

import com.xsjsglxt.domain.DO.xsjsglxt_briefdetails;
import com.xsjsglxt.domain.DO.xsjsglxt_case;
import com.xsjsglxt.domain.DO.xsjsglxt_parallel;
import com.xsjsglxt.domain.DO.xsjsglxt_resevidence;
import com.xsjsglxt.domain.DO.xsjsglxt_snece;

public class ParallelInformationDTO {
private xsjsglxt_parallel parallel ;
private xsjsglxt_snece snece;
private xsjsglxt_case case1;
private xsjsglxt_briefdetails briefdetails;
private xsjsglxt_resevidence resevidence;


public xsjsglxt_parallel getParallel() {
	return parallel;
}
public void setParallel(xsjsglxt_parallel parallel) {
	this.parallel = parallel;
}
public xsjsglxt_snece getSnece() {
	return snece;
}
public void setSnece(xsjsglxt_snece snece) {
	this.snece = snece;
}
public xsjsglxt_case getCase1() {
	return case1;
}
public void setCase1(xsjsglxt_case case1) {
	this.case1 = case1;
}
public xsjsglxt_briefdetails getBriefdetails() {
	return briefdetails;
}
public void setBriefdetails(xsjsglxt_briefdetails briefdetails) {
	this.briefdetails = briefdetails;
}
public xsjsglxt_resevidence getResevidence() {
	return resevidence;
}
public void setResevidence(xsjsglxt_resevidence resevidence) {
	this.resevidence = resevidence;
}
public ParallelInformationDTO(xsjsglxt_parallel parallel, xsjsglxt_snece snece, xsjsglxt_case case1,
		xsjsglxt_briefdetails briefdetails, xsjsglxt_resevidence resevidence) {

	this.parallel = parallel;
	this.snece = snece;
	this.case1 = case1;
	this.briefdetails = briefdetails;
	this.resevidence = resevidence;
}
@Override
public String toString() {
	return "ParallelInformationDTO [parallel=" + parallel + ", snece=" + snece + ", case1=" + case1 + ", briefdetails="
			+ briefdetails + ", resevidence=" + resevidence + "]";
}


}
