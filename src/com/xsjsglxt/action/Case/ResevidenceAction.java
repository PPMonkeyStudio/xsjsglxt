package com.xsjsglxt.action.Case;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.aspectj.util.FileUtil;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.ActionSupport;
import com.xsjsglxt.domain.DO.xsjsglxt_case;
import com.xsjsglxt.domain.DO.xsjsglxt_circulation;
import com.xsjsglxt.domain.DO.xsjsglxt_resevidence;
import com.xsjsglxt.domain.DTO.Case.ResevidenceInformationDTO;
import com.xsjsglxt.domain.VO.Case.page_list_ResevidenceInformationVO;
import com.xsjsglxt.service.Case.ResevidenceService;

import util.TeamUtil;

public class ResevidenceAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {
	private ResevidenceService resevidenceService;

	private HttpServletResponse http_response;

	private HttpServletRequest http_request;

	private xsjsglxt_resevidence resevidence;

	private xsjsglxt_case case1;

	private xsjsglxt_circulation circulation;

	private List<String> useResevidenceInformationNumList;

	private ResevidenceInformationDTO resevidenceInformationDTO;

	private page_list_ResevidenceInformationVO page_list_ResevidenceInformation;

	private File resevidenceImage; // 上传物证图片文件

	private String resevidenceImageFileName;

	private String resevidenceImageContentType;

	private String downloadFileName;

	/*
	 * 保存物证
	 * 
	 */
	public void saveResevidence() throws IOException {
		http_response.setContentType("text/html;charset=utf-8");
		if (resevidenceImage != null && resevidenceImage.exists()) {
			String path = ServletActionContext.getServletContext().getRealPath("/upload/resevidence"); // 保存路径
			File factory = new File(path);
			if (!factory.exists())
				factory.mkdirs();
			String filename = TeamUtil.getUuid()
					+ resevidenceImageFileName.substring(resevidenceImageFileName.lastIndexOf("."));
			File file = new File(path + "/" + filename);
			if (!file.exists())
				file.createNewFile();
			FileUtil.copyFile(resevidenceImage, file);
			resevidence.setResevidence_image(filename);
		} else {
			resevidence.setResevidence_image("");
		}
		String result = null;
		try {
			String uuid = TeamUtil.getUuid();
			resevidence.setXsjsglxt_resevidence_id(uuid);
			resevidence.setResevidence_case(case1.getXsjsglxt_case_id());
			resevidenceService.saveResevidence(resevidence);
			result = uuid;
		} catch (Exception e) {
			e.printStackTrace();
			result = "error";
		} finally {
			try {
				http_response.getWriter().write(result);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	// 下载物证图片
	public void downloadResevidence() {
		HttpServletResponse response = ServletActionContext.getResponse();
		try {
			response.addHeader("Content-Disposition",
					"attachment; filename=\"" + new String(
							("物证图" + downloadFileName.substring(downloadFileName.lastIndexOf("."))).getBytes(),
							"ISO-8859-1") + "\"");
			File file = new File(ServletActionContext.getServletContext()
					.getRealPath("/upload/resevidence/" + downloadFileName + "/"));
			try {
				FileInputStream fi = new FileInputStream(file);
				try {
					OutputStream os = response.getOutputStream();
					byte[] buffer = new byte[2048];
					while (fi.read(buffer) != -1) {
						os.write(buffer);
						os.flush();
					}
					os.close();
					fi.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * 列表信息
	 */
	public void ListResevidenceInformationByPageAndSearch() throws IOException {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();
		page_list_ResevidenceInformation = resevidenceService
				.VO_Resevidenceformation_By_PageAndSearch(page_list_ResevidenceInformation);

		http_response.setContentType("text/html;charset=utf-8");

		http_response.getWriter().write(gson.toJson(page_list_ResevidenceInformation));
	}

	/*
	 * 详细信息
	 */
	public void ResevidenceInformationOne() throws IOException {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();
		resevidenceInformationDTO = resevidenceService.ResevidenceInformationOne(resevidence);
		http_response.setContentType("text/html;charset=utf-8");

		http_response.getWriter().write(gson.toJson(resevidenceInformationDTO));
	}

	/*
	 * 保存流转信息
	 */
	public void saveCirculation() throws IOException {
		try {
			circulation.setCirculation_resevidence(resevidence.getXsjsglxt_resevidence_id());
			resevidenceService.saveCirculation(circulation);
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
	 * 流转信息列表
	 */
	public void getCirculationList() throws IOException {
		try {
			List<xsjsglxt_circulation> list = resevidenceService.getCirculationList(resevidence);
			http_response.setContentType("text/html;charset=utf-8");
			http_response.getWriter().write(new Gson().toJson(list));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			http_response.setContentType("text/html;charset=utf-8");
			http_response.getWriter().write("error");
		}
	}

	/*
	 * 修改物证信息
	 */
	public void updateResevidenceInformation() throws IOException {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();
		resevidenceService.updateResevidenceIn(resevidence);

		http_response.setContentType("text/html;charset=utf-8");

		http_response.getWriter().write("success");

	}

	/*
	 * 删除信息
	 */
	public void remove_ResevidenceInformationList() {

		if (resevidenceService.removeResevidenceInformationList(useResevidenceInformationNumList)) {
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

	/**
	 * @author 孙毅 修改流转状态
	 */
	public void updateStatus() {
		resevidenceService.updateStatus(resevidence);
	}

	/**
	 * @author 孙毅 修改检验状态
	 */
	public void updateResevidenceCheckState() {
		resevidenceService.updateResevidenceCheckState(resevidence);
	}

	/**
	 * @author 孙毅 修改送检状态
	 */
	public void updateResevidenceSendCheckState() {
		resevidenceService.updateResevidenceSendCheckState(resevidence);
	}

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

	public ResevidenceService getResevidenceService() {
		return resevidenceService;
	}

	public void setResevidenceService(ResevidenceService resevidenceService) {
		this.resevidenceService = resevidenceService;
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

	public xsjsglxt_resevidence getResevidence() {
		return resevidence;
	}

	public void setResevidence(xsjsglxt_resevidence resevidence) {
		this.resevidence = resevidence;
	}

	public xsjsglxt_case getCase1() {
		return case1;
	}

	public void setCase1(xsjsglxt_case case1) {
		this.case1 = case1;
	}

	public xsjsglxt_circulation getCirculation() {
		return circulation;
	}

	public void setCirculation(xsjsglxt_circulation circulation) {
		this.circulation = circulation;
	}

	public ResevidenceInformationDTO getResevidenceInformationDTO() {
		return resevidenceInformationDTO;
	}

	public void setResevidenceInformationDTO(ResevidenceInformationDTO resevidenceInformationDTO) {
		this.resevidenceInformationDTO = resevidenceInformationDTO;
	}

	public page_list_ResevidenceInformationVO getPage_list_ResevidenceInformation() {
		return page_list_ResevidenceInformation;
	}

	public void setPage_list_ResevidenceInformation(
			page_list_ResevidenceInformationVO page_list_ResevidenceInformation) {
		this.page_list_ResevidenceInformation = page_list_ResevidenceInformation;
	}

	public List<String> getUseResevidenceInformationNumList() {
		return useResevidenceInformationNumList;
	}

	public void setUseResevidenceInformationNumList(List<String> useResevidenceInformationNumList) {
		this.useResevidenceInformationNumList = useResevidenceInformationNumList;
	}

	public File getResevidenceImage() {
		return resevidenceImage;
	}

	public void setResevidenceImage(File resevidenceImage) {
		this.resevidenceImage = resevidenceImage;
	}

	public String getResevidenceImageFileName() {
		return resevidenceImageFileName;
	}

	public void setResevidenceImageFileName(String resevidenceImageFileName) {
		this.resevidenceImageFileName = resevidenceImageFileName;
	}

	public String getResevidenceImageContentType() {
		return resevidenceImageContentType;
	}

	public void setResevidenceImageContentType(String resevidenceImageContentType) {
		this.resevidenceImageContentType = resevidenceImageContentType;
	}

	public String getDownloadFileName() {
		return downloadFileName;
	}

	public void setDownloadFileName(String downloadFileName) {
		this.downloadFileName = downloadFileName;
	}

}
