package com.xsjsglxt.dao.Case;

import com.xsjsglxt.domain.DO.xsjsglxt_briefdetails;
import com.xsjsglxt.domain.DO.xsjsglxt_case;
import com.xsjsglxt.domain.DO.xsjsglxt_lost;
import com.xsjsglxt.domain.DO.xsjsglxt_lost_computer;
import com.xsjsglxt.domain.DO.xsjsglxt_lost_mobilephone;
import com.xsjsglxt.domain.DO.xsjsglxt_snece;

public interface SenceDao {

public 	void save(xsjsglxt_snece sence);

public void save(xsjsglxt_case case1);

public void save(xsjsglxt_briefdetails briefdetails);

public void save(xsjsglxt_lost lost);

public void save(xsjsglxt_lost_mobilephone lost_mobilephone);

public void save(xsjsglxt_lost_computer lost_computer);

public String getSenceInformationInquestId();

}
