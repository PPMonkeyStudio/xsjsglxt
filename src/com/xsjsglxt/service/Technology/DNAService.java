package com.xsjsglxt.service.Technology;

import java.util.List;

import com.xsjsglxt.domain.DO.xsjsglxt_dna;
import com.xsjsglxt.domain.VO.Technology.DNAVO;

public interface DNAService {
	
	
	String create_dna_num();
	
	DNAVO list_xsjsglxt_dna(DNAVO dNAVO);
	
	int saveDNA(xsjsglxt_dna DNA);
	
	int deleteDNA(String dna_id);

	int deleteListDNA(List<String> listDeleteDNAID);
	
	int modifiedDNA(xsjsglxt_dna dNA);

	xsjsglxt_dna get_dna(String dna_id);
}
