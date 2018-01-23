package com.xsjsglxt.action.User;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.xsjsglxt.domain.DO.xsjsglxt_memorabilia;
import com.xsjsglxt.domain.VO.User.memorabiliaByPageAndSearchVO;
import com.xsjsglxt.service.User.MemorabiliaService;

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

	public void getMemorabiliaById() {
		xsjsglxt_memorabilia memorabilia = memorabiliaService.getMemorabiliaById(memorabilia_id);
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
