package com.xsjsglxt.action.InspectionIdentification;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.ActionSupport;
import com.xsjsglxt.domain.DO.xsjsglxt_appraisal_letter;
import com.xsjsglxt.domain.DO.xsjsglxt_check_entrustment_book;
import com.xsjsglxt.domain.DO.xsjsglxt_identifieder_case_confirm_book;
import com.xsjsglxt.domain.DO.xsjsglxt_inspection_record;
import com.xsjsglxt.domain.DO.xsjsglxt_not_acceptance_entrustment_inform;
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
	// 检验委托书
	private xsjsglxt_check_entrustment_book tranceCheckBook;
	// 分页显示委托书
	private EntrustmentBookManagementVO entrustmentBookManagementVO;
	// 批量的委托书ID
	private List<String> listCheckEntrustmentBookId;
	// 鉴定事项确认书
	private xsjsglxt_identifieder_case_confirm_book identifiederCaseConfirmBook;
	// 不受理委托鉴定告知
	private xsjsglxt_not_acceptance_entrustment_inform notAcceptanceEntrustmentInform;
	// 检验记录
	private xsjsglxt_inspection_record inspectionRecord;
	// 鉴定文书表
	private xsjsglxt_appraisal_letter appraisalLetter;
	// 流
	private InputStream inputStream;
	// 名
	private String fileName;

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
			response.getWriter().write(
					"" + inspectionIdentificationService.deleteListCheckEntrustmentBook(listCheckEntrustmentBookId));
		} catch (IOException e) {
			System.out.println("批量删除委托书出错");
			e.printStackTrace();
		}
	}

	// 点击填写确认书表
	public void addConfirmBook() {
		try {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write(
					"" + inspectionIdentificationService.saveIdentifiederCaseConfirmBook(identifiederCaseConfirmBook));
		} catch (IOException e) {
			System.out.println("填写确认书报错");
			e.printStackTrace();
		}
	}

	// 点击填写不受理委托鉴定告知表
	public void addNotAcceptance() {
		try {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write(
					"" + inspectionIdentificationService.saveNotAcceptanceInform(notAcceptanceEntrustmentInform));
		} catch (IOException e) {
			System.out.println("填写不受理委托鉴定告知报错");
			e.printStackTrace();
		}
	}

	// 填写检验记录表
	// 1 OK
	// 2 失败
	// 3 开启状态不对
	public void addInspectionRecord() {
		try {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write("" + inspectionIdentificationService.saveInspectionRecord(inspectionRecord));
		} catch (IOException e) {
			System.out.println("填写不受理委托鉴定告知报错");
			e.printStackTrace();
		}
	}

	// 填写鉴定文书表
	public void addAppraisalLetter() {
		try {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write("" + inspectionIdentificationService.saveAppraisalLetter(appraisalLetter));
		} catch (IOException e) {
			System.out.println("填写鉴定文书表报错");
			e.printStackTrace();
		}
	}

	// 更改委托书
	public void updateTranceCheckBook() {
		try {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write("" + inspectionIdentificationService.updateTranceCheckBook(tranceCheckBook));
		} catch (IOException e) {
			System.out.println("更改委托书报错");
			e.printStackTrace();
		}
	}

	// 更改鉴定事项确认书表
	public void updateIdentifiederCaseConfirmBook() {
		try {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write(""
					+ inspectionIdentificationService.updateIdentifiederCaseConfirmBook(identifiederCaseConfirmBook));
		} catch (IOException e) {
			System.out.println("更改鉴定事项确认书报错");
			e.printStackTrace();
		}
	}

	// 更改不受理委托鉴定告知表
	public void updateNotAcceptanceInform() {
		try {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write(
					"" + inspectionIdentificationService.updateNotAcceptanceInform(notAcceptanceEntrustmentInform));
		} catch (IOException e) {
			System.out.println("更改不受理委托鉴定告知报错");
			e.printStackTrace();
		}
	}

	// 更改检验记录
	public void updateInspectionRecord() {
		try {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write("" + inspectionIdentificationService.updateInspectionRecord(inspectionRecord));
		} catch (IOException e) {
			System.out.println("更改不受理委托鉴定告知报错");
			e.printStackTrace();
		}
	}

	// 更改鉴定文书表
	public void updateAppraisalLetter() {
		try {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write("" + inspectionIdentificationService.updateAppraisalLetter(appraisalLetter));
		} catch (IOException e) {
			System.out.println("更改不受理委托鉴定告知报错");
			e.printStackTrace();
		}
	}

	public String exportTranceCheckBook() throws Exception {
		File exportTranceCheckBookFile = inspectionIdentificationService
				.exportTranceCheckBook(tranceCheckBook.getXsjsglxt_check_entrustment_book_id());
		fileName = new String(("鉴定委托书" + inspectionIdentificationService
				.exportTraceCheckBookName(tranceCheckBook.getXsjsglxt_check_entrustment_book_id()) + ".docx")
						.getBytes("GBK"),
				"ISO-8859-1");
		inputStream = new FileInputStream(exportTranceCheckBookFile);
		exportTranceCheckBookFile.delete();
		return "exportTranceCheckBook";
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

	public xsjsglxt_appraisal_letter getAppraisalLetter() {
		return appraisalLetter;
	}

	public void setAppraisalLetter(xsjsglxt_appraisal_letter appraisalLetter) {
		this.appraisalLetter = appraisalLetter;
	}

	public xsjsglxt_inspection_record getInspectionRecord() {
		return inspectionRecord;
	}

	public void setInspectionRecord(xsjsglxt_inspection_record inspectionRecord) {
		this.inspectionRecord = inspectionRecord;
	}

	public xsjsglxt_not_acceptance_entrustment_inform getNotAcceptanceEntrustmentInform() {
		return notAcceptanceEntrustmentInform;
	}

	public void setNotAcceptanceEntrustmentInform(
			xsjsglxt_not_acceptance_entrustment_inform notAcceptanceEntrustmentInform) {
		this.notAcceptanceEntrustmentInform = notAcceptanceEntrustmentInform;
	}

	public xsjsglxt_identifieder_case_confirm_book getIdentifiederCaseConfirmBook() {
		return identifiederCaseConfirmBook;
	}

	public void setIdentifiederCaseConfirmBook(xsjsglxt_identifieder_case_confirm_book identifiederCaseConfirmBook) {
		this.identifiederCaseConfirmBook = identifiederCaseConfirmBook;
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

	public InputStream getInputStream() {
		return inputStream;
	}

	public String getFileName() {
		return fileName;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

}
