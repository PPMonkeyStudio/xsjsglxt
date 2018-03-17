package com.xsjsglxt.action.User;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import com.xsjsglxt.domain.DO.xsjsglxt_memorabilia;
import com.xsjsglxt.domain.VO.User.memorabiliaByPageAndSearchVO;
import com.xsjsglxt.service.User.MemorabiliaService;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import util.TeamUtil;

public class MemorabiliaAction extends ActionSupport {
	private MemorabiliaService memorabiliaService;
	private String memorabilia_id;
	private memorabiliaByPageAndSearchVO memorabiliaVO;
	private xsjsglxt_memorabilia memorabilia;
	private HttpServletResponse response = ServletActionContext.getResponse();

	public String skipToMemorabilia() {
		return "skipSuccess";
	}

	public void saveMemorabilia() throws IOException {
		String result = memorabiliaService.saveMemorabilia(memorabilia);
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write(result);
		response.getWriter().flush();
		response.getWriter().close();
	}

	public void updateMemorabilia() throws IOException {
		memorabilia.setMemorabilia_gmt_create(
				memorabiliaService.getMemorabiliaById(memorabilia.getMemorabilia_id()).getMemorabilia_gmt_create());
		memorabilia.setMemorabilia_gmt_modified(TeamUtil.getStringSecond());
		String result = memorabiliaService.updateMemorabilia(memorabilia);
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write(result);
		response.getWriter().flush();
		response.getWriter().close();
	}

	public void deleteMemorabilia() throws IOException {
		String result = memorabiliaService.delteMemorabilia(memorabilia_id);
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write(result);
		response.getWriter().flush();
		response.getWriter().close();
	}

	public void getMemorabiliaList() throws IOException, InterruptedException {
		memorabiliaByPageAndSearchVO memorabiliaVO = memorabiliaService.getMemorabiliaByList(this.memorabiliaVO);
		Gson gson = new Gson();
		String result = gson.toJson(memorabiliaVO);
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write(result);
		response.getWriter().flush();
		response.getWriter().close();
	}

	public void getMemorabiliaById() throws IOException {
		xsjsglxt_memorabilia memorabilia = memorabiliaService.getMemorabiliaById(memorabilia_id);
		Gson gson = new Gson();
		String result = gson.toJson(memorabilia);
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write(result);
		response.getWriter().flush();
		response.getWriter().close();
	}

	public void exportMemorabiliaWord() throws IOException, TemplateException {
		xsjsglxt_memorabilia memorabilia = memorabiliaService.getMemorabiliaById(memorabilia_id);
		Map<String, String> mapData = new HashMap<String, String>();
		mapData.put("year", memorabilia.getMemorabilia_time().substring(0, 4));
		mapData.put("title", memorabilia.getMemorabilia_title());
		mapData.put("human", memorabilia.getMemorabilia_join_human());
		mapData.put("content", memorabilia.getMemorabilia_content());
		mapData.put("time", memorabilia.getMemorabilia_time());
		Configuration configuration = new Configuration();
		configuration.setDefaultEncoding("utf-8");
		configuration.setClassForTemplateLoading(this.getClass(), "");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/msword");
		String filename = memorabilia.getMemorabilia_title();
		response.addHeader("Content-Disposition",
				"attachment;filename=\"" + new String(filename.getBytes(), "ISO-8859-1") + ".doc\"");
		PrintWriter pw = response.getWriter();
		Template t = configuration.getTemplate("memorabilia.ftl", "utf-8");
		t.process(mapData, pw);
		pw.flush();
		pw.close();
	}

	// ----------------------------------------------getter/setter------------------------------------------------------
	public MemorabiliaService getMemorabiliaService() {
		return memorabiliaService;
	}

	public void setMemorabiliaService(MemorabiliaService memorabiliaService) {
		this.memorabiliaService = memorabiliaService;
	}

	public String getMemorabilia_id() {
		return memorabilia_id;
	}

	public void setMemorabilia_id(String memorabilia_id) {
		this.memorabilia_id = memorabilia_id;
	}

	public memorabiliaByPageAndSearchVO getMemorabiliaVO() {
		return memorabiliaVO;
	}

	public void setMemorabiliaVO(memorabiliaByPageAndSearchVO memorabiliaVO) {
		this.memorabiliaVO = memorabiliaVO;
	}

	public xsjsglxt_memorabilia getMemorabilia() {
		return memorabilia;
	}

	public void setMemorabilia(xsjsglxt_memorabilia memorabilia) {
		this.memorabilia = memorabilia;
	}
}
