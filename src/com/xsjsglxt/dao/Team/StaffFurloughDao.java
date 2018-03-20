package com.xsjsglxt.dao.Team;

import com.xsjsglxt.domain.DO.xsjsglxt_staffFurlough;

public interface StaffFurloughDao {

	String saveFurlough(xsjsglxt_staffFurlough furlough);

	String deleteFurloughByFurloughId(xsjsglxt_staffFurlough furlough);

	String deleteFurloughByStaffId(String staffFurlough_staff);

	xsjsglxt_staffFurlough getFurloughByFurloughId(String xsjsglxt_staffFurlough_id);

}
