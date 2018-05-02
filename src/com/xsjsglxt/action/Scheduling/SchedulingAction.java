package com.xsjsglxt.action.Scheduling;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import com.xsjsglxt.domain.DO.xsjsglxt_scheduling;
import com.xsjsglxt.domain.DTO.Scheduling.schedulingDTO;
import com.xsjsglxt.domain.VO.Scheduling.SchedulingDTOListVO;
import com.xsjsglxt.service.Scheduling.SchedulingService;

import util.ExportExcelCollection;

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
		xsjsglxt_scheduling schedulingTemp = null;
		for (int i = 0; i < scheduling_days; i++) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date d = null;
			try {
				d = sdf.parse(scheduling.getScheduling_time());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Calendar c = Calendar.getInstance();
			c.setTime(d);
			c.set(Calendar.DAY_OF_MONTH, i + 1);
			schedulingTemp = new xsjsglxt_scheduling();
			schedulingTemp.setScheduling_leader(leader[i % leader.length]);
			schedulingTemp.setScheduling_main(main[i % main.length]);
			schedulingTemp.setScheduling_main_technology(mainTech[i % mainTech.length]);
			if (i % assistatn.length + 1 >= assistatn.length) {
				schedulingTemp.setScheduling_assistant(assistatn[i % assistatn.length] + "、" + assistatn[0]);
			} else {
				schedulingTemp.setScheduling_assistant(
						assistatn[i % assistatn.length] + "、" + assistatn[i % assistatn.length + 1]);
			}
			schedulingTemp.setScheduling_time(sdf.format(c.getTime()));
			c.clear();
			boolean flag = schedulingService.saveScheduling(schedulingTemp);
		}
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

	// --------------------------导出值班表
	public void exportScheduling() throws UnsupportedEncodingException {
		schedulingListVO
				.setQueryTimeStart(new String(schedulingListVO.getQueryTimeStart().getBytes("ISO-8859-1"), "utf-8"));
		schedulingListVO
				.setQueryTimeEnd(new String(schedulingListVO.getQueryTimeEnd().getBytes("ISO-8859-1"), "utf-8"));
		schedulingListVO.setQuery_name(new String(schedulingListVO.getQuery_name().getBytes("ISO-8859-1"), "utf-8"));
		String[] heard = { "日期", "带班领导", "侦查值班人员", "技术值班人员", "值班辅警", "巡逻人员", "加班人员", "外协人员", "出差人员" };
		schedulingService.schedulingList(schedulingListVO);
		List<schedulingDTO> dtoList = schedulingListVO.getSchedulingDTOList();
		List<Map<String, String>> dataList = new ArrayList<Map<String, String>>();
		for (schedulingDTO schedulingDTO : dtoList) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("1", schedulingDTO.getScheduling_time());
			map.put("2", schedulingDTO.getScheduling_leader());
			map.put("3", schedulingDTO.getScheduling_main());
			map.put("4", schedulingDTO.getScheduling_mainTec());
			map.put("5", schedulingDTO.getScheduling_assistant());
			if (schedulingDTO.getScheduling_patrol() == null)
				map.put("6", "");
			else {
				map.put("6", schedulingDTO.getScheduling_patrol());
			}
			if (schedulingDTO.getScheduling_overtime() == null)
				map.put("7", "");
			else {
				map.put("7", schedulingDTO.getScheduling_overtime());
			}
			if (schedulingDTO.getScheduling_out_help() == null)
				map.put("8", "");
			else {
				map.put("8", schedulingDTO.getScheduling_out_help());
			}
			if (schedulingDTO.getScheduling_evection() == null)
				map.put("9", "");
			else {
				map.put("9", schedulingDTO.getScheduling_evection());
			}
			dataList.add(map);
		}
		XSSFWorkbook workbook = ExportExcelCollection.exportExcel(null, heard, dataList);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.addHeader("Content-Disposition",
				"attachment;filename=\"" + new String("值班表".getBytes(), "ISO-8859-1") + ".xlsx\"");
		try {
			OutputStream os = response.getOutputStream();
			workbook.write(os);
			os.flush();
			os.close();
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
