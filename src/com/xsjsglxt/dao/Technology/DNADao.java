package com.xsjsglxt.dao.Technology;

import java.util.List;

import com.xsjsglxt.domain.DO.xsjsglxt_dna;
import com.xsjsglxt.domain.VO.Technology.DNAVO;

public interface DNADao {
	
//	xsjsglxt_dnaVO list_xsjsglxt_dna_all(xsjsglxt_dnaVO xsjsglxt_dna_VO);
	
	List<xsjsglxt_dna> list_xsjsglxt_dna(DNAVO xsjsglxt_dna_VO);
	
	int saveDNA(xsjsglxt_dna dNA);
	
	int deleteDNA(String dna_id);
	
	int count_DNA_all(DNAVO dNAVO);
	
	int getFeild();

	int modifiedDNA(xsjsglxt_dna dNA);
	
	xsjsglxt_dna get_dna(String dna_id);

}
