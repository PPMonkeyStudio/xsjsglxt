package com.xsjsglxt.service.impl.Case;

import com.xsjsglxt.dao.Case.HandleDao;
import com.xsjsglxt.service.Case.HandleService;

public class HandleServiceImpl implements HandleService {
private HandleDao handleDao;

public HandleDao getHandleDao() {
	return handleDao;
}

public void setHandleDao(HandleDao handleDao) {
	this.handleDao = handleDao;
}

}
