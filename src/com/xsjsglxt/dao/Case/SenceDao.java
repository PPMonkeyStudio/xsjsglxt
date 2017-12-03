package com.xsjsglxt.dao.Case;

import java.util.List;

import com.xsjsglxt.domain.DO.xsjsglxt_briefdetails;
import com.xsjsglxt.domain.DO.xsjsglxt_case;
import com.xsjsglxt.domain.DO.xsjsglxt_lost;
import com.xsjsglxt.domain.DO.xsjsglxt_lost_computer;
import com.xsjsglxt.domain.DO.xsjsglxt_lost_mobilephone;
import com.xsjsglxt.domain.DO.xsjsglxt_picture;
import com.xsjsglxt.domain.DO.xsjsglxt_resevidence;
import com.xsjsglxt.domain.DO.xsjsglxt_snece;
import com.xsjsglxt.domain.VO.Case.page_list_senceInformationVO;

public interface SenceDao {
/*
 * 保存现场勘验表信息
 */
public 	void save(xsjsglxt_snece sence);
/*
 * 保存案件表信息
 */
public void save(xsjsglxt_case case1);
/*
 * 保存简要详情表信息
 */
public void save(xsjsglxt_briefdetails briefdetails);

/*
 * 案件的记录数
 */
public int getCountSenceInformationByPage(page_list_senceInformationVO page_list_senceInformation);

public List<xsjsglxt_case> getListSenceInformatioByPage(page_list_senceInformationVO page_list_senceInformation);

public xsjsglxt_briefdetails get_briefdetails_Byxsjsglxt_case_id(xsjsglxt_case case1);

public xsjsglxt_lost_computer get_lost_computer_Byxsjsglxt_case_id(xsjsglxt_case case1);

public xsjsglxt_lost_mobilephone get_lost_mobilephone_Byxsjsglxt_case_id(xsjsglxt_case case1);

public xsjsglxt_lost get_lost_Byxsjsglxt_case_id(xsjsglxt_case case1);

public xsjsglxt_picture get_picture_Byxsjsglxt_case_id(xsjsglxt_case case1);

public xsjsglxt_snece get_sence_Byxsjsglxt_case_id(xsjsglxt_case case1);

public xsjsglxt_resevidence get_resevidence_Byxsjsglxt_case_id(xsjsglxt_case case1);

public com.xsjsglxt.domain.DO.xsjsglxt_case getCaseByNum(String case_id);

public boolean deleteBriefdetailsById(String xsjsglxt_case_id);

public boolean deleteCaseById(String xsjsglxt_case_id);

public boolean deleteLost_computerById(String xsjsglxt_case_id);

public boolean deleteLost_mobilephoneById(String xsjsglxt_case_id);

public boolean deleteLostById(String xsjsglxt_case_id);

public boolean deletePictureById(String xsjsglxt_case_id);

public boolean deleteSenceById(String xsjsglxt_case_id);

public int getMaxSenceInquestId();

public xsjsglxt_snece getSeceByCaseId(xsjsglxt_case case1);

public xsjsglxt_case getCaseByCaseId(xsjsglxt_case case1);

public xsjsglxt_briefdetails getBriefdetailsByCaseID(xsjsglxt_case case1);

public xsjsglxt_lost getLostByCaseID(xsjsglxt_case case1);

public xsjsglxt_lost_mobilephone getLost_mobilephoneByCaseId(xsjsglxt_case case1);

public xsjsglxt_resevidence getResevidenceByCaseId(xsjsglxt_case case1);

public xsjsglxt_lost_computer getLost_computerByCaseId(xsjsglxt_case case1);

public xsjsglxt_picture getPicturtByCaseId(xsjsglxt_case case1);

}
