package com.xsjsglxt.action.InspectionIdentification;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.ActionSupport;
import com.xsjsglxt.domain.DO.xsjsglxt_check_entrustment_book;
import com.xsjsglxt.domain.VO.InspectionIdentification.EntrustmentBookManagementVO;
import com.xsjsglxt.service.InspectionIdentification.InspectionIdentificationService;

@SuppressWarnings("serial")
public class InspectionIdentificationAction extends ActionSupport implements ServletResponseAware, ServletRequestAware {
	private InspectionIdentificationService inspectionIdentificationService;
	private HttpServletResponse response;
	private HttpServletRequest request;
	/**
	 * 
	 *
	 */
	// 痕迹检验委托书
	private xsjsglxt_check_entrustment_book tranceCheckBook;
	// 分页显示委托书
	private EntrustmentBookManagementVO entrustmentBookManagementVO;
	// 批量的委托书ID
	private List<String> listCheckEntrustmentBookId;

	/**
	 * 
	 * 
	 */

	// 点击进入检验鉴定委托管理
	public String EntrustmentBookManagement() {
		return "EntrustmentBookManagement";
	}

	// 点击保存
	public void addCheckBook() {
		try {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write("" + inspectionIdentificationService.saveTranceCheckBook(tranceCheckBook));
		} catch (IOException e) {
			System.out.println("保存委托书报错");
			e.printStackTrace();
		}
	}

	// 分页获取
	public void getListCheckEntrustmentBookByPage() {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();
		entrustmentBookManagementVO = inspectionIdentificationService
				.getListCheckEntrustmentBook(entrustmentBookManagementVO);
		response.setContentType("text/html;charset=utf-8");
		try {
			response.getWriter().write(gson.toJson(entrustmentBookManagementVO));
		} catch (IOException e) {
			System.out.println("分页显示委托书出错");
			e.printStackTrace();
		}
	}

	// 批量删除 -1 失败 1成功
	public void deleteListCheckEntrustmentBook() {
		try {
			response.getWriter()
					.write(inspectionIdentificationService.deleteListCheckEntrustmentBook(listCheckEntrustmentBookId));
		} catch (IOException e) {
			System.out.println("批量删除委托书出错");
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * 
	 * 
	 * 
	 */

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;

	}

	public EntrustmentBookManagementVO getEntrustmentBookManagementVO() {
		return entrustmentBookManagementVO;
	}

	public void setEntrustmentBookManagementVO(EntrustmentBookManagementVO entrustmentBookManagementVO) {
		this.entrustmentBookManagementVO = entrustmentBookManagementVO;
	}

	public InspectionIdentificationService getInspectionIdentificationService() {
		return inspectionIdentificationService;
	}

	public List<String> getListCheckEntrustmentBookId() {
		return listCheckEntrustmentBookId;
	}

	public void setListCheckEntrustmentBookId(List<String> listCheckEntrustmentBookId) {
		this.listCheckEntrustmentBookId = listCheckEntrustmentBookId;
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public xsjsglxt_check_entrustment_book getTranceCheckBook() {
		return tranceCheckBook;
	}

	public void setTranceCheckBook(xsjsglxt_check_entrustment_book tranceCheckBook) {
		this.tranceCheckBook = tranceCheckBook;
	}

	public void setInspectionIdentificationService(InspectionIdentificationService inspectionIdentificationService) {
		this.inspectionIdentificationService = inspectionIdentificationService;
	}

}
