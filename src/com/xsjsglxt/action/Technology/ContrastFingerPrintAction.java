package com.xsjsglxt.action.Technology;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.ActionSupport;
import com.xsjsglxt.domain.DO.xsjsglxt_contrast_fingerprint;
import com.xsjsglxt.domain.DO.xsjsglxt_dna;
import com.xsjsglxt.domain.DO.xsjsglxt_equipment;
import com.xsjsglxt.domain.DO.xsjsglxt_fingerprint;
import com.xsjsglxt.domain.VO.Technology.ContrastFingerPrintVO;
import com.xsjsglxt.domain.VO.Technology.DNAVO;
import com.xsjsglxt.service.Technology.ContrastFingerPrintService;

import util.ExcelToBean2;


public class ContrastFingerPrintAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {

	private ContrastFingerPrintService contrastFingerPrintService;

	private HttpServletResponse http_response;

	private HttpServletRequest http_request;

	private ContrastFingerPrintVO contrastFingerPrintVO;

	private xsjsglxt_contrast_fingerprint contrastFingerPrint;
	private String query_name;// 导出execl表的属性条件,逗号隔开
	private String query_id;// 导出execl表的ID字段条件,逗号隔开
	private String time_interval;// 时间区间
	private String tableName;// 查询的表名
	private File file; // execl文件
	private String fileFileName; // file+FileName为固定写法,否则取不到
	private String fileContentType; // file+ContentType为固定写法
		
		
	public void ListContrastByPageAndSearch() throws IOException {
		ContrastFingerPrintVO vo = contrastFingerPrintService.list_xsjsglxt_contrast(contrastFingerPrintVO);
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();
		http_response.setContentType("text/html;charset=utf-8");
		http_response.getWriter().write(gson.toJson(vo));
	}

	public void CreateContrast() throws IOException {
		int result = contrastFingerPrintService.saveContrast(contrastFingerPrint);
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();
		http_response.setContentType("text/html;charset=utf-8");
		http_response.getWriter().write(gson.toJson(result));
	}

	public void deleteContrast() throws IOException {
		int result = contrastFingerPrintService.deleteContrast(contrast_fingerprint_id);
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();
		http_response.setContentType("text/html;charset=utf-8");
		http_response.getWriter().write(gson.toJson(result));
	}

	public void deleteListContrast() throws IOException {
		int result = contrastFingerPrintService.deleteListContrast(listDeleteContrastID);
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();
		http_response.setContentType("text/html;charset=utf-8");
		http_response.getWriter().write(gson.toJson(result));
	}
 
	public void modifiedContrast() throws IOException {
		int result = contrastFingerPrintService.modifiedContrast(contrastFingerPrint);
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();
		http_response.setContentType("text/html;charset=utf-8");
		http_response.getWriter().write(gson.toJson(result));
	}

	public void get_contrast() throws IOException {
		xsjsglxt_contrast_fingerprint contrast = contrastFingerPrintService.get_contrast(contrast_fingerprint_id);
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();
		http_response.setContentType("text/html;charset=utf-8");
		http_response.getWriter().write(gson.toJson(contrast));
	}
	// 导出信息excel表 用MAP集合
		public void userExportExcelCollection() {
			XSSFWorkbook workbook = contrastFingerPrintService.getExcel(query_name, tableName, query_id);
			OutputStream out = null;
			try {
				HttpServletResponse response = ServletActionContext.getResponse();
				out = response.getOutputStream();
				response.setHeader("Content-disposition", "attachment; filename=" + tableName + ".xls");// filename是下载的xls的名，建议最好用英文
				response.setContentType("application/msexcel;charset=UTF-8");// 设置类型
				response.setHeader("Pragma", "No-cache");// 设置头
				response.setHeader("Cache-Control", "no-cache");// 设置头
				response.setDateHeader("Expires", 0);// 设置日期头
				workbook.write(out);
				out.flush();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if (out != null) {
						out.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		// execl信息表导入到数据库
		@SuppressWarnings("unchecked")
		public void importDatabase() {
			try {
				FileInputStream is = new FileInputStream(file);
				String propertiesName = null;
				System.out.println(fileFileName);
				System.out.println(fileContentType);
				Class cla = null;
				if (fileFileName.contains("比中")) {
					propertiesName = "xsjsglxt_contrast_fingerprint";
					cla = xsjsglxt_contrast_fingerprint.class;
				} else if (fileFileName.contains("DNA")) {
					propertiesName = "xsjsglxt_dna";
					cla = xsjsglxt_dna.class;
				} else if (fileFileName.contains("器材")) {
					propertiesName = "xsjsglxt_equipment";
					cla = xsjsglxt_equipment.class;
				} else if (fileFileName.contains("指纹")) {
					propertiesName = "xsjsglxt_fingerprint";
					cla = xsjsglxt_fingerprint.class;
				} 
				 else {
				}
				XSSFWorkbook workbook = new XSSFWorkbook(is);

				List<Object> list = ExcelToBean2.toObjectPerproList(
						ExcelToBean2.parseUpdateExcel(workbook, "com.xsjsglxt.domain.DO." + propertiesName), cla);
				contrastFingerPrintService.addinfo(list);
			} catch (Error e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	public String ContrastFingerPrintManagementPage() {
		return "ContrastFingerPrintManagementPage";
	}

	@Override
	public String toString() {
		return "ContrastFingerPrintAction [contrastFingerPrintService=" + contrastFingerPrintService
				+ ", http_response=" + http_response + ", http_request=" + http_request + ", contrastFingerPrintVO="
				+ contrastFingerPrintVO + ", contrastFingerPrint=" + contrastFingerPrint + ", listDeleteContrastID="
				+ listDeleteContrastID + ", contrast_fingerprint_id=" + contrast_fingerprint_id + "]";
	}

	public ContrastFingerPrintService getContrastFingerPrintService() {
		return contrastFingerPrintService;
	}

	public void setContrastFingerPrintService(ContrastFingerPrintService contrastFingerPrintService) {
		this.contrastFingerPrintService = contrastFingerPrintService;
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

	public ContrastFingerPrintVO getContrastFingerPrintVO() {
		return contrastFingerPrintVO;
	}

	public void setContrastFingerPrintVO(ContrastFingerPrintVO contrastFingerPrintVO) {
		this.contrastFingerPrintVO = contrastFingerPrintVO;
	}

	public xsjsglxt_contrast_fingerprint getContrastFingerPrint() {
		return contrastFingerPrint;
	}

	public void setContrastFingerPrint(xsjsglxt_contrast_fingerprint contrastFingerPrint) {
		this.contrastFingerPrint = contrastFingerPrint;
	}

	public List<String> getListDeleteContrastID() {
		return listDeleteContrastID;
	}

	public void setListDeleteContrastID(List<String> listDeleteContrastID) {
		this.listDeleteContrastID = listDeleteContrastID;
	}

	public String getContrast_fingerprint_id() {
		return contrast_fingerprint_id;
	}

	public void setContrast_fingerprint_id(String contrast_fingerprint_id) {
		this.contrast_fingerprint_id = contrast_fingerprint_id;
	}

	private List<String> listDeleteContrastID;

	private String contrast_fingerprint_id;

	@Override
	public void setServletResponse(HttpServletResponse http_response) {
		this.http_response = http_response;
	}

	@Override
	public void setServletRequest(HttpServletRequest http_request) {
		this.http_request = http_request;
	}

	public String getQuery_name() {
		return query_name;
	}

	public void setQuery_name(String query_name) {
		this.query_name = query_name;
	}

	public String getQuery_id() {
		return query_id;
	}

	public void setQuery_id(String query_id) {
		this.query_id = query_id;
	}

	public String getTime_interval() {
		return time_interval;
	}

	public void setTime_interval(String time_interval) {
		this.time_interval = time_interval;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

}
