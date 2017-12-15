package com.xsjsglxt.service.Case;

import java.util.List;

import com.xsjsglxt.domain.DO.xsjsglxt_briefdetails;
import com.xsjsglxt.domain.DO.xsjsglxt_case;
import com.xsjsglxt.domain.DO.xsjsglxt_lost;
import com.xsjsglxt.domain.DO.xsjsglxt_lost_computer;
import com.xsjsglxt.domain.DO.xsjsglxt_lost_mobilephone;
import com.xsjsglxt.domain.DO.xsjsglxt_picture;
import com.xsjsglxt.domain.DO.xsjsglxt_snece;
import com.xsjsglxt.domain.DTO.Case.SenceInformationDTO;
import com.xsjsglxt.domain.VO.Case.page_list_senceInformationVO;

public interface SenceService {
/*
 * 保存现场勘验表信息
 */
public 	void save(xsjsglxt_snece sence);
/*
 * 保存案件表信息
 */
public boolean save(xsjsglxt_case case1);
/*
 * 保存简要详情表信息
 */
public void save(xsjsglxt_briefdetails briefdetails);

/*
 * 列表信息
 */
public page_list_senceInformationVO VO_SneceInformation_By_PageAndSearch(
		page_list_senceInformationVO page_list_senceInformation);

/*
 * 删除信息
 */
public boolean remove_SenceInformationList(List<String> useSenceInformationNumList);

/*
 * 得到勘验编号
 */
public String getMaxSenceInquestId();
/*
 * 单条详细信息
 */
public SenceInformationDTO SecneInformationOne(xsjsglxt_case case1);
/*
 * 修改信息
 */
public void updateSence(xsjsglxt_snece sence, String case1);
public void updateCase(xsjsglxt_case case1);
public void updateBriefdetails(xsjsglxt_briefdetails briefdetails,String case1);
public List<xsjsglxt_case> AllCase();

}
