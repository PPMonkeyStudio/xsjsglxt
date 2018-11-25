
package com.xsjsglxt.action.Case;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.ActionSupport;
import com.xsjsglxt.domain.DO.xsjsglxt_handle;
import com.xsjsglxt.domain.DO.xsjsglxt_introduce_letter;
import com.xsjsglxt.domain.VO.Case.IntroduceLetterVO;
import com.xsjsglxt.domain.VO.Case.page_list_HandleInformationVO;
import com.xsjsglxt.service.Case.HandleService;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class HandleAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {
	private HandleService handleService;

	private xsjsglxt_handle handle;
	private List<String> useHandleInformationNumList;
	private HttpServletResponse http_response;
	private HttpServletRequest http_request;
	private page_list_HandleInformationVO page_list_HandleInformation;
	private IntroduceLetterVO letterVO;
	private xsjsglxt_introduce_letter letter;
	private String[] letter_id;

	// ---------------------------------------------介绍信内容-----------------------------------------
	/**
	 * @author 孙毅
	 * 介绍信
	 */

	public String into_introduce_page() {
		return "introduce_page";
	}

	public void saveIntroduceLetter() {
		String result = handleService.saveIntroduceLetter(letter);
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

	public void deleteIntroduceLetter() {
		String result = handleService.deleteIntroduceLetter(letter_id);
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

	public void getIntroduceLetterById() {
		String result = handleService.getIntroduceLetterById(letter.getXsjsglxt_introduce_letter_id());
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

	public void updateIntroduceLetter() {
		String result = handleService.updateIntroduceLetter(letter);
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

	public void getLetterByPage() {
		handleService.getLetterByPage(letterVO);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		try {
			PrintWriter pw = response.getWriter();
			pw.write(new Gson().toJson(letterVO));
			pw.flush();
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void exportLetter() throws ParseException, IOException, TemplateException {
		xsjsglxt_introduce_letter letter1 = handleService
				.getIntroduceLetterByIdObject(letter.getXsjsglxt_introduce_letter_id());
		Map<String, String> map = new HashMap<String, String>();
		HttpServletResponse response = ServletActionContext.getResponse();
		map.put("serialNumber", letter1.getIntroduce_letter_serial_number());
		map.put("toUnit", letter1.getIntroduce_letter_tounit());
		map.put("introducedMan", letter1.getIntroduce_letter_introduceMan());
		map.put("number_", letter1.getIntroduce_letter_number() + "");
		map.put("introduceReasons", letter1.getIntroduce_letter_reasons());
		map.put("year_", letter1.getIntroduce_time().substring(0, 4));
		map.put("month_", letter1.getIntroduce_time().substring(5, 7));
		map.put("day_", letter1.getIntroduce_time().substring(8));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date d = sdf.parse(letter1.getIntroduce_time());
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		c.add(Calendar.DATE, Integer.parseInt(letter1.getIntroduce_time_limit()));
		map.put("month_limit", Integer.toString(c.get(Calendar.MONTH) + 1));
		map.put("day_limit", Integer.toString(c.get(Calendar.DATE)));
		Configuration configuration = new Configuration();
		configuration.setDefaultEncoding("utf-8");
		// 设置默认的编码方式，将数据以utf-8的方式进行编码
		configuration.setClassForTemplateLoading(this.getClass(), "");
		response.setCharacterEncoding("utf-8");
		// 设置响应的编码方式(以utf-8的方式将字符编码成字节)
		response.setContentType("application/msword");
		String filename = "介绍信";
		response.addHeader("Content-Disposition",
				"attachment;filename=\"" + new String(filename.getBytes(), "ISO-8859-1") + ".doc\"");
		PrintWriter pw = response.getWriter();
		Template t = configuration.getTemplate("introduceLetter.ftl", "utf-8");
		t.process(map, pw);
		pw.flush();
		pw.close();
	}

	public void updateApproveStatus() {
		String result = handleService.updateApproveStatus(letter);
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

	// ----------------------------------------------办案内容----------------------------------------------
	/*
	 * 保存办案信息
	 */
	public void saveHandle() throws IOException {
		try {

			handleService.saveHandle(handle);
			http_response.setContentType("text/html;charset=utf-8");
			http_response.getWriter().write("success");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			http_response.setContentType("text/html;charset=utf-8");
			http_response.getWriter().write("error");
		}
	}

	/*
	 * 得到序号
	 */
	public void xuhao() throws IOException {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();
		int Id = handleService.getMaxId();
		http_response.setContentType("text/html;charset=utf-8");
		http_response.getWriter().write(gson.toJson(Id));
	}

	/*
	 * 列表信息
	 */
	public void ListHandleInformationByPageAndSearch() throws IOException {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();

		page_list_HandleInformation = handleService.VO_HandleInformation_By_PageAndSearch(page_list_HandleInformation);

		http_response.setContentType("text/html;charset=utf-8");

		http_response.getWriter().write(gson.toJson(page_list_HandleInformation));
	}

	/*
	 * 详细信息
	 */
	public void HandleInformationOne() throws IOException {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();
		handle = handleService.HandleInformationOne(handle);
		http_response.setContentType("text/html;charset=utf-8");

		http_response.getWriter().write(gson.toJson(handle));
	}

	/*
	 * 修改信息
	 */
	public void updateHandleInformation() throws IOException {
		try {

			handleService.updateHandleInformation(handle);
			http_response.setContentType("text/html;charset=utf-8");
			http_response.getWriter().write("success");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			http_response.setContentType("text/html;charset=utf-8");
			http_response.getWriter().write("error");
		}
	}

	/*
	 * 删除信息
	 */
	public void remove_HandleInformationList() {

		if (handleService.remove_HandleInformationList(useHandleInformationNumList)) {
			http_response.setContentType("text/html;charset=utf-8");
			try {
				http_response.getWriter().write("success");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			http_response.setContentType("text/html;charset=utf-8");
			try {
				http_response.getWriter().write("error");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/*
	 * 所有的中队长、办案民警
	 */
	public void allPoliceInHandlingCases() throws IOException {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();
		List<xsjsglxt_handle> handleList = new ArrayList<xsjsglxt_handle>();
		handleList = handleService.allPoliceInHandlingCases();
		http_response.setContentType("text/html;charset=utf-8");

		http_response.getWriter().write(gson.toJson(handleList));
	}

	/**
	 * @author 孙毅
	 * 获得办理时间超期的案件
	 */

	public void getHandleExceedTime() {
		List<String> caseList = handleService.getHandleExceedTime();
		Gson gson = new Gson();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		try {
			PrintWriter pw = response.getWriter();
			pw.write(gson.toJson(caseList));
			pw.flush();
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @author 孙毅
	 * 获得拘留天数到期
	 * 
	 */

	public void getDetention() {
		List<xsjsglxt_handle> list = handleService.getDetention();
		Gson gson = new Gson();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		try {
			PrintWriter pw = response.getWriter();
			pw.write(gson.toJson(list));
			pw.flush();
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @author 孙毅
	 * 获得取保候审超期提醒
	 * 
	 */

	public void getOutTime() {
		Map<String, List<xsjsglxt_handle>> map = handleService.getOutTime();
		Gson gson = new Gson();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		try {
			PrintWriter pw = response.getWriter();
			pw.write(gson.toJson(map));
			pw.flush();
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// -----------------------------------setter/getter----------------------------

	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
		this.http_response = arg0;
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		this.http_request = arg0;
	}

	public HandleService getHandleService() {
		return handleService;
	}

	public void setHandleService(HandleService handleService) {
		this.handleService = handleService;
	}

	public HttpServletResponse getHttp_response() {
		return http_response;
	}

	public void setHttp_response(HttpServletResponse http_response) {
		this.http_response = http_response;
	}

	public HttpServletRequest getHttp_request() {
		return http_request;
	}

	public void setHttp_request(HttpServletRequest http_request) {
		this.http_request = http_request;
	}

	public xsjsglxt_handle getHandle() {
		return handle;
	}

	public void setHandle(xsjsglxt_handle handle) {
		this.handle = handle;
	}

	public page_list_HandleInformationVO getPage_list_HandleInformation() {
		return page_list_HandleInformation;
	}

	public void setPage_list_HandleInformation(page_list_HandleInformationVO page_list_HandleInformation) {
		this.page_list_HandleInformation = page_list_HandleInformation;
	}

	public List<String> getUseHandleInformationNumList() {
		return useHandleInformationNumList;
	}

	public void setUseHandleInformationNumList(List<String> useHandleInformationNumList) {
		this.useHandleInformationNumList = useHandleInformationNumList;
	}

	public IntroduceLetterVO getLetterVO() {
		return letterVO;
	}

	public void setLetterVO(IntroduceLetterVO letterVO) {
		this.letterVO = letterVO;
	}

	public xsjsglxt_introduce_letter getLetter() {
		return letter;
	}

	public void setLetter(xsjsglxt_introduce_letter letter) {
		this.letter = letter;
	}

	public String[] getLetter_id() {
		return letter_id;
	}

	public void setLetter_id(String[] letter_id) {
		this.letter_id = letter_id;
	}

}
