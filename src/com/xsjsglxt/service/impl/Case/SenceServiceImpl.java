package com.xsjsglxt.service.impl.Case;

import com.xsjsglxt.dao.Case.SenceDao;
import com.xsjsglxt.domain.DO.xsjsglxt_briefdetails;
import com.xsjsglxt.domain.DO.xsjsglxt_case;
import com.xsjsglxt.domain.DO.xsjsglxt_lost;
import com.xsjsglxt.domain.DO.xsjsglxt_lost_computer;
import com.xsjsglxt.domain.DO.xsjsglxt_lost_mobilephone;
import com.xsjsglxt.domain.DO.xsjsglxt_snece;
import com.xsjsglxt.service.Case.SenceService;

public class SenceServiceImpl implements SenceService {
private SenceDao  senceDao;

public SenceDao getSenceDao() {
	return senceDao;
}

public void setSenceDao(SenceDao senceDao) {
	this.senceDao = senceDao;
}

@Override
public void save(xsjsglxt_snece sence) {
	// TODO Auto-generated method stub
	senceDao.save(sence);
}

@Override
public void save(xsjsglxt_case case1) {
	// TODO Auto-generated method stub
	senceDao.save(case1);
}

@Override
public void save(xsjsglxt_briefdetails briefdetails) {
	// TODO Auto-generated method stub
	senceDao.save(briefdetails);
}

@Override
public void save(xsjsglxt_lost lost) {
	// TODO Auto-generated method stub
	senceDao.save(lost);
}

@Override
public void save(xsjsglxt_lost_mobilephone lost_mobilephone) {
	// TODO Auto-generated method stub
	senceDao.save(lost_mobilephone);
}

@Override
public void save(xsjsglxt_lost_computer lost_computer) {
	// TODO Auto-generated method stub
	senceDao.save(lost_computer);
}
/*
 * (non-Javadoc)获得勘探编号
 * @see com.xsjsglxt.service.Case.SenceService#getSenceInformationInquestId()
 */
@Override
public String getSenceInformationInquestId() {
	// TODO Auto-generated method stub
       String senceInformationId = senceDao.getSenceInformationInquestId();
	return senceInformationId;
}

}
