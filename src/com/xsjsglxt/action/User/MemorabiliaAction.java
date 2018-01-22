package com.xsjsglxt.action.User;

import com.opensymphony.xwork2.ActionSupport;
import com.xsjsglxt.domain.VO.User.memorabiliaByPageAndSearchVO;
import com.xsjsglxt.service.User.MemorabiliaService;

public class MemorabiliaAction extends ActionSupport {
	private MemorabiliaService memorabiliaService;
	private String memorabilia_id;
	private memorabiliaByPageAndSearchVO memorabiliaVO;

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
}
