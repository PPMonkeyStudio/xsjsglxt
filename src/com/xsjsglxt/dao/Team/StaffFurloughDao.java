package com.xsjsglxt.dao.Team;

import java.util.List;

import com.xsjsglxt.domain.DO.xsjsglxt_staffFurlough;

public interface StaffFurloughDao {

	String saveFurlough(List<xsjsglxt_staffFurlough> furloughs);

	String deleteFurloughByFurloughId(xsjsglxt_staffFurlough furlough);

	String deleteFurloughByStaffId(String staffFurlough_staff);

	xsjsglxt_staffFurlough getFurloughByFurloughId(String xsjsglxt_staffFurlough_id);

	List<xsjsglxt_staffFurlough> getFurloughByStaffId(String staffFurlough_staff);

	String updateFurlough(xsjsglxt_staffFurlough furlough);

}
