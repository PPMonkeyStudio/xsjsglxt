package com.xsjsglxt.action.InspectionIdentification;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
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
import com.xsjsglxt.domain.DO.xsjsglxt_damage_inspection_record;
import com.xsjsglxt.domain.DO.xsjsglxt_death_inspection_record;
import com.xsjsglxt.domain.DO.xsjsglxt_entrustment_sample;
import com.xsjsglxt.domain.DO.xsjsglxt_identifieder_case_confirm_book;
import com.xsjsglxt.domain.DO.xsjsglxt_inspection_record;
import com.xsjsglxt.domain.DO.xsjsglxt_not_acceptance_entrustment_inform;
import com.xsjsglxt.domain.VO.InspectionIdentification.EntrustmentBookManagementVO;
import com.xsjsglxt.service.InspectionIdentification.InspectionIdentificationService;

import util.TeamUtil;

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
	// 批量的检材
	private List<String> listEntrustmentSample;
	// 鉴定事项确认书
	private xsjsglxt_identifieder_case_confirm_book identifiederCaseConfirmBook;
	// 尸体检验记录表
	private xsjsglxt_death_inspection_record deathInspectionRecord;
	// 检材表
	private xsjsglxt_entrustment_sample entrustment_sample;
	// 损伤检验记录表
	private xsjsglxt_damage_inspection_record damageInspectionRecord;
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
	// 尸体检验记录表 图片文件
	private File[] death;
	// 尸体检验记录表 图片名称
	private String[] deathFileName;
	// 文件类型
	private String[] deathContentType;
	// 判断文件顺序
	// 1: 有
	// 2 ： 无
	private String[] positionFile;

	/**
	 * 
	 * 
	 */

	/**
	 * 根据案件id获取委托书列表
	 * 
	 * @param tranceCheckBook.getCheckCaseId()
	 *            案件id
	 * @return listEnstrustment委托书列表
	 */
	public void getListEntrustmentByCaseId() {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();
		List<xsjsglxt_check_entrustment_book> listEnstrustment = new ArrayList<>();
		listEnstrustment = inspectionIdentificationService
				.getListEnstrustmentByCaseId(tranceCheckBook.getCheckCaseId());
		response.setContentType("text/html;charset=utf-8");
		try {
			response.getWriter().write(gson.toJson(listEnstrustment));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @author 孙毅
	 * 保存检验记录
	 */

	public void saveInspectionRecord() {
		inspectionRecord.setXsjsglxt_inspection_record_id(TeamUtil.getUuid());
		inspectionIdentificationService.saveInspectionRecords(inspectionRecord);
	}

	/**
	 * 根据物证id获取委托书 tranceCheckBook.getCheckEvidenceId() 物证id
	 * 
	 * @return listEntrustmentBook委托书
	 * 
	 */
	public void getListEntrustmentByEvidenceId() {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();
		List<xsjsglxt_check_entrustment_book> listEntrustmentBook = new ArrayList<>();
		listEntrustmentBook = inspectionIdentificationService
				.getListEnstrustmentByEvidenceId(tranceCheckBook.getCheckEvidenceId());
		response.setContentType("text/html;charset=utf-8");
		try {
			response.getWriter().write(gson.toJson(listEntrustmentBook));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 根据案件id获取检验记录
	 * 
	 * @param inspectionRecord.getInspectionCaseId()
	 *            案件id
	 * @return listInspectionRecord检验记录列表
	 */
	public void getListInspectionRecordByCaseId() {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();
		List<xsjsglxt_inspection_record> listInspectionRecord = new ArrayList<>();
		listInspectionRecord = inspectionIdentificationService
				.listInspectionRecordByCaseId(inspectionRecord.getInspectionCaseId());
		response.setContentType("text/html;charset=utf-8");
		try {
			response.getWriter().write(gson.toJson(listInspectionRecord));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 根据物证id获取委托书inspectionRecord.getInspectionEvidenceId() 物证id
	 * 
	 * @return listInspectionRecord检验记录
	 * 
	 */
	public void getListIndsectionRecordByEvidenceId() {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();
		List<xsjsglxt_inspection_record> listInspectionRecord = new ArrayList<>();
		listInspectionRecord = inspectionIdentificationService
				.listInspectionRecordByEvidenceId(inspectionRecord.getInspectionEvidenceId());
		response.setContentType("text/html;charset=utf-8");
		try {
			response.getWriter().write(gson.toJson(listInspectionRecord));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

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

	// 填写尸体检验记录表
	public void addDeathInspectionRecord() {
		try {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write("" + inspectionIdentificationService
					.saveDeathInspectionRecord(deathInspectionRecord, death, deathFileName, positionFile));
		} catch (IOException e) {
			System.out.println("填写尸体检验记录表报错");
			e.printStackTrace();
		}
	}

	// 填写检材表
	public void addEntrustmentSample() {
		try {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write("" + inspectionIdentificationService.saveEntrustmentSample(entrustment_sample));
		} catch (IOException e) {
			System.out.println("填写尸体检验记录表报错");
			e.printStackTrace();
		}
	}

	// 填写损伤检验记录表
	public void addDamageInspectionRecord() {
		try {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write("" + inspectionIdentificationService
					.saveDamageInspectionRecord(damageInspectionRecord, death, deathFileName, positionFile));
		} catch (IOException e) {
			System.out.println("填写损伤检验记录表报错");
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

	// 单独删除检材
	public void deleteEntrustmentSample() {
		System.out.println("sdsdsddsds");
		System.out.println(listEntrustmentSample);
		try {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter()
					.write("" + inspectionIdentificationService.deleteEntrustmentSample(listEntrustmentSample));
		} catch (IOException e) {
			System.out.println("删除检材表报错");
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

	// 更改尸体检验记录表
	public void updateDeathInspectionRecord() {
		try {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write("" + inspectionIdentificationService
					.updateDeathInspectionRecord(deathInspectionRecord, death, deathFileName, positionFile));
		} catch (IOException e) {
			System.out.println("更改尸体检验记录表报错");
			e.printStackTrace();
		}
	}

	// 更改损伤检验记录表
	public void updateDamageInspectionRecord() {
		try {
			response.setContentType("text/html;charset=utf-8");
			System.out.println("lplp:" + damageInspectionRecord.getDamage_inspection_record_belong_entrustment_book());
			response.getWriter().write("" + inspectionIdentificationService
					.updateDamageInspectionRecord(damageInspectionRecord, death, deathFileName, positionFile));
		} catch (IOException e) {
			System.out.println("更改损伤检验记录表报错");
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

	// 导出检验委托书
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

	// 导出确认书
	public String exportConfirmBook() throws Exception {
		File exportConfirmBookFile = inspectionIdentificationService.exportIdentifiederCaseConfirmBook(
				identifiederCaseConfirmBook.getXsjsglxt_identifieder_case_confirm_book_id());
		fileName = inspectionIdentificationService.exportIdentifiederCaseConfirmBookName(
				identifiederCaseConfirmBook.getXsjsglxt_identifieder_case_confirm_book_id());
		if (fileName != null) {
			fileName = new String(("检验事项确认书：" + fileName + ".docx").getBytes("GBK"), "ISO-8859-1");
		} else {
			fileName = new String(("鉴定事项确认书：" + ".docx").getBytes("GBK"), "ISO-8859-1");
		}
		inputStream = new FileInputStream(exportConfirmBookFile);
		exportConfirmBookFile.delete();
		return "exportConfirmBook";
	}

	// 导出受理回执
	// 接收：确认书ID
	public String exportAcceptanceReturnReceipt() throws Exception {
		File exportAcceptanceReturnReceiptFile = inspectionIdentificationService.exportAcceptanceReturnReceipt(
				identifiederCaseConfirmBook.getXsjsglxt_identifieder_case_confirm_book_id());
		fileName = inspectionIdentificationService.exportIdentifiederCaseConfirmBookName(
				identifiederCaseConfirmBook.getXsjsglxt_identifieder_case_confirm_book_id());
		if (fileName != null) {
			fileName = new String(("受理回执单：" + fileName + ".docx").getBytes("GBK"), "ISO-8859-1");
		} else {
			fileName = new String(("受理回执单：" + ".docx").getBytes("GBK"), "ISO-8859-1");
		}
		inputStream = new FileInputStream(exportAcceptanceReturnReceiptFile);
		exportAcceptanceReturnReceiptFile.delete();
		return "exportAcceptanceReturnReceipt";
	}

	//
	public String exportNotAcceptanceIdentifieder() throws Exception {

		File exportNotAcceptanceIdentifiederFile = inspectionIdentificationService.exportNotAcceptanceIdentifieder(
				notAcceptanceEntrustmentInform.getXsjsglxt_not_acceptance_entrustment_inform_id());
		// 获取委托书编号
		fileName = inspectionIdentificationService.exportNotAccetpBookName(
				notAcceptanceEntrustmentInform.getXsjsglxt_not_acceptance_entrustment_inform_id());
		if (fileName != null) {
			fileName = new String(("不受理受理回执单：" + fileName + ".docx").getBytes("GBK"), "ISO-8859-1");
		} else {
			fileName = new String(("不受理回执单：" + ".docx").getBytes("GBK"), "ISO-8859-1");
		}
		inputStream = new FileInputStream(exportNotAcceptanceIdentifiederFile);
		exportNotAcceptanceIdentifiederFile.delete();
		return "exportNotAcceptanceIdentifieder";
	}

	//
	public String exportInspectionRecord() throws Exception {
		File exportInspectionRecordFile = inspectionIdentificationService
				.exportInspectionRecord(inspectionRecord.getXsjsglxt_inspection_record_id());
		// 获取委托书编号
		fileName = inspectionIdentificationService
				.exportInspectionRecordName(inspectionRecord.getXsjsglxt_inspection_record_id());
		if (fileName != null) {
			fileName = new String(("痕迹检验记录：" + fileName + ".docx").getBytes("GBK"), "ISO-8859-1");
		} else {
			fileName = new String(("痕迹检验记录：" + ".docx").getBytes("GBK"), "ISO-8859-1");
		}
		inputStream = new FileInputStream(exportInspectionRecordFile);
		exportInspectionRecordFile.delete();
		return "export";
	}

	//
	public String exportDeathInspectionRecord() throws Exception {
		File exportDeathInspectionRecordFile = inspectionIdentificationService
				.exportDeathInspectionRecord(deathInspectionRecord.getXsjsglxt_death_inspection_record_id());
		fileName = inspectionIdentificationService
				.exportDeathInspectionRecordName(deathInspectionRecord.getXsjsglxt_death_inspection_record_id());
		if (fileName != null) {
			fileName = new String(("死因检验记录：" + fileName + ".docx").getBytes("GBK"), "ISO-8859-1");
		} else {
			fileName = new String(("死因检验记录：" + ".docx").getBytes("GBK"), "ISO-8859-1");
		}
		inputStream = new FileInputStream(exportDeathInspectionRecordFile);
		exportDeathInspectionRecordFile.delete();
		return "export";
	}

	//
	public String exportDamageInspectionRecord() throws Exception {
		File exportDamageInspectionRecordFile = inspectionIdentificationService
				.exportDamageInspectionRecord(damageInspectionRecord.getXsjsglxt_damage_inspection_record_id());
		fileName = inspectionIdentificationService
				.exportDamageInspectionRecordName(damageInspectionRecord.getXsjsglxt_damage_inspection_record_id());
		if (fileName != null) {
			fileName = new String(("损伤检验记录：" + fileName + ".docx").getBytes("GBK"), "ISO-8859-1");
		} else {
			fileName = new String(("损伤检验记录：" + ".docx").getBytes("GBK"), "ISO-8859-1");
		}
		inputStream = new FileInputStream(exportDamageInspectionRecordFile);
		exportDamageInspectionRecordFile.delete();
		return "export";
	}

	//
	public String exportAppraisalLetter() throws Exception {
		System.out.println("ll");
		System.out.println("appraisalLetter:" + appraisalLetter);
		File exportAppraisalLetterFile = inspectionIdentificationService
				.exportAppraisalLetter(appraisalLetter.getXsjsglxt_appraisal_letter_id());
		fileName = inspectionIdentificationService
				.exportAppraisalLetterName(appraisalLetter.getXsjsglxt_appraisal_letter_id());
		if (fileName != null) {
			fileName = new String(("鉴定书：" + fileName + ".docx").getBytes("GBK"), "ISO-8859-1");
		} else {
			fileName = new String(("鉴定书：" + ".docx").getBytes("GBK"), "ISO-8859-1");
		}
		inputStream = new FileInputStream(exportAppraisalLetterFile);
		exportAppraisalLetterFile.delete();
		return "export";
	}

	//
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

	public xsjsglxt_entrustment_sample getEntrustment_sample() {
		return entrustment_sample;
	}

	public void setEntrustment_sample(xsjsglxt_entrustment_sample entrustment_sample) {
		this.entrustment_sample = entrustment_sample;
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

	public xsjsglxt_death_inspection_record getDeathInspectionRecord() {
		return deathInspectionRecord;
	}

	public xsjsglxt_damage_inspection_record getDamageInspectionRecord() {
		return damageInspectionRecord;
	}

	public void setDeathInspectionRecord(xsjsglxt_death_inspection_record deathInspectionRecord) {
		this.deathInspectionRecord = deathInspectionRecord;
	}

	public void setDamageInspectionRecord(xsjsglxt_damage_inspection_record damageInspectionRecord) {
		this.damageInspectionRecord = damageInspectionRecord;
	}

	public String[] getDeathContentType() {
		return deathContentType;
	}

	public File[] getDeath() {
		return death;
	}

	public void setDeath(File[] death) {
		this.death = death;
	}

	public String[] getDeathFileName() {
		return deathFileName;
	}

	public void setDeathFileName(String[] deathFileName) {
		this.deathFileName = deathFileName;
	}

	public void setDeathContentType(String[] deathContentType) {
		this.deathContentType = deathContentType;
	}

	public String[] getPositionFile() {
		return positionFile;
	}

	public void setPositionFile(String[] positionFile) {
		this.positionFile = positionFile;
	}

	public List<String> getListEntrustmentSample() {
		return listEntrustmentSample;
	}

	public void setListEntrustmentSample(List<String> listEntrustmentSample) {
		this.listEntrustmentSample = listEntrustmentSample;
	}

}
