package com.xsjsglxt.domain.DO;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.xsjsglxt.dao.Case.SenceDao;
import com.xsjsglxt.domain.VO.Case.page_list_senceInformationVO;
import com.xsjsglxt.service.Case.SenceService;

public class test {
	private String username;
	private String password;
   private xsjsglxt_case Case;
   private   page_list_senceInformationVO           page_list_senceInformation;
	@Override
	public String toString() {
		return "test [username=" + username + ", password=" + password + "]";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	@Resource
	private SenceService senceService;



	public xsjsglxt_case getCase() {
		return Case;
	}

	public void setCase(xsjsglxt_case case1) {
		Case = case1;
	}

	public SenceService getSenceService() {
		return senceService;
	}

	public void setSenceService(SenceService senceService) {
		this.senceService = senceService;
	}

	@Test
public void test(){
	System.out.println(senceService.getSenceInformationInquestId());
}
	//@Test
//	public void test1(){
//		List<xsjsglxt_case> Case1=new ArrayList<xsjsglxt_case>();
//		senceDao.save(Case);
//	}
	@Resource
	private SenceDao senceDao;

	public void setSenceDao(SenceDao senceDao) {
		this.senceDao = senceDao;
	}
	@Test
	public void test3(){
		System.out.println(senceDao.getSenceInformationInquestId());
	}
	
}
