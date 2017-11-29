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

public 	void save(xsjsglxt_snece sence);

public boolean save(xsjsglxt_case case1);

public void save(xsjsglxt_briefdetails briefdetails);

public void save(xsjsglxt_lost lost);

public void save(xsjsglxt_lost_mobilephone lost_mobilephone);

public void save(xsjsglxt_lost_computer lost_computer);

public void save(xsjsglxt_picture picture);
/*
 * 获得勘探编号
 */
public String getSenceInformationInquestId();
/*
 * 现场信息列表
 */
public page_list_senceInformationVO VO_SneceInformation_By_PageAndSearch(
		page_list_senceInformationVO page_list_senceInformation);

/*
 * 删除现场信息列表
 */
public boolean remove_SenceInformationList(List<String> useSenceInformationNumList);


public String getMaxSenceInquestId();
/*
 * 现场详细信息
 */
public SenceInformationDTO SecneInformationOne(xsjsglxt_snece sence);

}
