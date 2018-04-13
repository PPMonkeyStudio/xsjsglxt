package com.xsjsglxt.action.Scheduling;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.xsjsglxt.domain.DO.xsjsglxt_scheduling;
import com.xsjsglxt.service.Scheduling.SchedulingService;

/**
 * 
 * @author 孙毅
 * 排班action
 */
public class SchedulingAction {
	private SchedulingService schedulingService;
	private List<xsjsglxt_scheduling> schedulingList;
	private xsjsglxt_scheduling scheduling;
	private String[] scheduling_id;

	public String page_list() {
		return "intoScheduling";
	}

	// -----------------------保存值班表
	public void saveScheduling() {
		boolean flag = schedulingService.saveScheduling(scheduling);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		try {
			PrintWriter pw = response.getWriter();
			if (flag) {
				pw.write("saveSuccess");
			} else {
				pw.write("saveError"); // 改日期已被占用
			}
			pw.flush();
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// --------------------获得值班表通过id
	public void getSchedulingById() {
		schedulingService.getSchedulingById(scheduling);
		Gson gson = new Gson();
		String result = gson.toJson(scheduling);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		try {
			PrintWriter pw = response.getWriter();
			pw.write(result);
			pw.flush();
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// ----------------------删除值班表
	public void deleteScheduling() {
		boolean flag = false;
		flag = schedulingService.delteShceduling(scheduling_id);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		try {
			PrintWriter pw = response.getWriter();
			pw.write("deleteSuccess");
			pw.flush();
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// ----------------------修改值班表
	public void updateScheduling() {
		boolean flag = false;
		flag = schedulingService.updateScheduling(scheduling);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		try {
			PrintWriter pw = response.getWriter();
			if (flag) {
				pw.write("updateSuccess");
			} else {
				pw.write("updateError");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// ------------------------------------setter/getter

	public List<xsjsglxt_scheduling> getSchedulingList() {
		return schedulingList;
	}

	public SchedulingService getSchedulingService() {
		return schedulingService;
	}

	public void setSchedulingService(SchedulingService schedulingService) {
		this.schedulingService = schedulingService;
	}

	public void setSchedulingList(List<xsjsglxt_scheduling> schedulingList) {
		this.schedulingList = schedulingList;
	}

	public xsjsglxt_scheduling getScheduling() {
		return scheduling;
	}

	public void setScheduling(xsjsglxt_scheduling scheduling) {
		this.scheduling = scheduling;
	}

	public String[] getScheduling_id() {
		return scheduling_id;
	}

	public void setScheduling_id(String[] scheduling_id) {
		this.scheduling_id = scheduling_id;
	}

}
