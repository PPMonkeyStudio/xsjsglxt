package com.xsjsglxt.dao.Case;

import java.util.List;

import com.xsjsglxt.domain.DO.xsjsglxt_case;
import com.xsjsglxt.domain.DO.xsjsglxt_lost_computer;
import com.xsjsglxt.domain.DO.xsjsglxt_snece;
import com.xsjsglxt.domain.VO.Case.page_list_CasematerialVO;

public interface LostComputerDao {

public	void saveLostComputer(xsjsglxt_lost_computer lost_computer);

public int getCountLostComputerInformationByPage(page_list_CasematerialVO page_list_Casematerial);

public List<xsjsglxt_lost_computer> getListLostComputerInformatioByPage(
		page_list_CasematerialVO page_list_Casematerial);

public xsjsglxt_case getCaseByxsjsglxt_lost_computer_id(xsjsglxt_lost_computer lost_computer);

public xsjsglxt_snece getSenceByxsjsglxt_case_id(xsjsglxt_case case1);

public xsjsglxt_lost_computer getLostComputerById(xsjsglxt_lost_computer lost_computer);

}
