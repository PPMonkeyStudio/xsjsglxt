package com.xsjsglxt.service.Team;

import com.xsjsglxt.domain.DO.xsjsglxt_staffFurlough;

public interface StaffFurloughService {

	String saveFurlough(xsjsglxt_staffFurlough furlough);

	String deleteFurloughByFurloughId(xsjsglxt_staffFurlough furlough);

	String deleteFurloughByStaffId(String staffFurlough_staff);

	xsjsglxt_staffFurlough getFurloughByFurloughId(String xsjsglxt_staffFurlough_id);

}
