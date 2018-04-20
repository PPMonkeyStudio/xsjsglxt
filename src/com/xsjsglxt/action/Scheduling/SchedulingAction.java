package com.xsjsglxt.action.Scheduling;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import com.xsjsglxt.domain.DO.xsjsglxt_scheduling;
import com.xsjsglxt.domain.VO.Scheduling.SchedulingDTOListVO;
import com.xsjsglxt.service.Scheduling.SchedulingService;

/**
 * 
 * @author 孙毅
 * 排班action
 */
public class SchedulingAction extends ActionSupport {
	private SchedulingService schedulingService;
	private List<xsjsglxt_scheduling> schedulingList;
	private xsjsglxt_scheduling scheduling;
	private String[] scheduling_id;
	private SchedulingDTOListVO schedulingListVO;
	private int scheduling_days;
	private String[] leader;
	private String[] main;
	private String[] mainTech;
	private String[] assistatn;

	public String page_list() {
		return "intoScheduling";
	}

	public String page_print() {
		return "printCurrPage";
	}

	// -----------------------保存值班表
	public void saveScheduling() {
		// boolean flag = schedulingService.saveScheduling(scheduling);
		// HttpServletResponse response = ServletActionContext.getResponse();
		// response.setContentType("text/html;charset=utf-8");
		// try {
		// PrintWriter pw = response.getWriter();
		// if (flag) {
		// pw.write("saveSuccess");
		// } else {
		// pw.write("saveError"); // 改日期已被占用
		// }
		// pw.flush();
		// pw.close();
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
		// ------------------------获得所有待排班人员
		System.out.println(leader.length);
		xsjsglxt_scheduling schedulingTemp = null;
		for (int i = 0; i < scheduling_days; i++) {
			System.out.println("进入排班");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date d = null;
			try {
				d = sdf.parse(scheduling.getScheduling_time());
				long curr = d.getTime();
				curr = curr + (i * 24 * 60 * 60 * 1000);
				d = new Date(curr);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			schedulingTemp = new xsjsglxt_scheduling();
			schedulingTemp.setScheduling_leader(leader[i % leader.length]);
			schedulingTemp.setScheduling_main(main[i % main.length]);
			schedulingTemp.setScheduling_main_technology(mainTech[i % mainTech.length]);
			schedulingTemp.setScheduling_assistant(assistatn[i % assistatn.length]);
			schedulingTemp.setScheduling_time(sdf.format(d));
			System.out.println("排班ok" + schedulingTemp.getScheduling_time());
			boolean flag = schedulingService.saveScheduling(schedulingTemp);
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=utf-8");
			try {
				PrintWriter pw = response.getWriter();
				pw.write("saveSuccess");
				pw.flush();
				pw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// --------------------获得值班表通过id
	public void getSchedulingById() {
		xsjsglxt_scheduling o = schedulingService.getSchedulingById(scheduling);
		Gson gson = new Gson();
		String result = gson.toJson(o);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		try {
			PrintWriter pw = response.getWriter();
			pw.write(result);
			pw.flush();
			pw.close();
		} catch (IOException e) {
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
			e.printStackTrace();
		}
	}

	// -----------------------列表获得值班表
	public void schedulingList() {
		schedulingService.schedulingList(schedulingListVO);
		Gson gson = new Gson();
		String result = gson.toJson(schedulingListVO);
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

	public void getSchedulingByDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date now = new Date();
		scheduling = new xsjsglxt_scheduling();
		scheduling.setScheduling_time(sdf.format(now));
		xsjsglxt_scheduling res = schedulingService.getSchedulingByDate(scheduling);
		Gson gson = new Gson();
		String result = gson.toJson(res);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		try {
			PrintWriter pw = response.getWriter();
			if (res != null && res.getXsjsglxt_scheduling_id().trim().length() > 0) {
				pw.write(result);
			} else
				pw.write("noScheduling");
			pw.flush();
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	// ------------------------------------setter/getter

	public List<xsjsglxt_scheduling> getSchedulingList() {
		return schedulingList;
	}

	public int getScheduling_days() {
		return scheduling_days;
	}

	public void setScheduling_days(int scheduling_days) {
		this.scheduling_days = scheduling_days;
	}

	public SchedulingService getSchedulingService() {
		return schedulingService;
	}

	public void setSchedulingService(SchedulingService schedulingService) {
		this.schedulingService = schedulingService;
	}

	public SchedulingDTOListVO getSchedulingListVO() {
		return schedulingListVO;
	}

	public void setSchedulingListVO(SchedulingDTOListVO schedulingListVO) {
		this.schedulingListVO = schedulingListVO;
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

	public String[] getLeader() {
		return leader;
	}

	public void setLeader(String[] leader) {
		this.leader = leader;
	}

	public String[] getMain() {
		return main;
	}

	public void setMain(String[] main) {
		this.main = main;
	}

	public String[] getMainTech() {
		return mainTech;
	}

	public void setMainTech(String[] mainTech) {
		this.mainTech = mainTech;
	}

	public String[] getAssistatn() {
		return assistatn;
	}

	public void setAssistatn(String[] assistatn) {
		this.assistatn = assistatn;
	}

	public void setScheduling_id(String[] scheduling_id) {
		this.scheduling_id = scheduling_id;
	}

}
