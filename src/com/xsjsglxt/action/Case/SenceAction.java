
package com.xsjsglxt.action.Case;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.aspectj.util.FileUtil;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.xsjsglxt.domain.DO.xsjsglxt_briefdetails;
import com.xsjsglxt.domain.DO.xsjsglxt_case;
import com.xsjsglxt.domain.DO.xsjsglxt_lost;
import com.xsjsglxt.domain.DO.xsjsglxt_lost_computer;
import com.xsjsglxt.domain.DO.xsjsglxt_lost_mobilephone;
import com.xsjsglxt.domain.DO.xsjsglxt_picture;
import com.xsjsglxt.domain.DO.xsjsglxt_resevidence;
import com.xsjsglxt.domain.DO.xsjsglxt_snece;
import com.xsjsglxt.domain.DTO.Case.SenceInformationAllDTO;
import com.xsjsglxt.domain.DTO.Case.SenceInformationDTO;
import com.xsjsglxt.domain.VO.Case.page_list_senceInformationVO;
import com.xsjsglxt.service.Case.SenceService;

import util.TeamUtil;

/**
 * 
 * @author 孙毅 修改时间 ：2018-04-17 修改内容：上传下载
 */
public class SenceAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {
	private SenceService senceService;
	private xsjsglxt_snece sence;
	private xsjsglxt_case case1;
	private xsjsglxt_briefdetails briefdetails;
	private xsjsglxt_lost lost;
	private xsjsglxt_lost_mobilephone lost_mobilephone;
	private xsjsglxt_picture picture;
	private xsjsglxt_lost_computer lost_computer;

	private List<xsjsglxt_resevidence> resevidencelist;
	private List<xsjsglxt_lost> lostlist;
	private List<xsjsglxt_lost_mobilephone> lost_mobilephonelist;
	private List<xsjsglxt_picture> picturelist;
	private List<xsjsglxt_lost_computer> lost_computerlist;

	private List<String> useSenceInformationNumList;
	private HttpServletResponse http_response;
	private HttpServletRequest http_request;
	private page_list_senceInformationVO page_list_senceInformation;
	private SenceInformationDTO senceInformationDTO;
	private SenceInformationAllDTO senceInformationAllDTO;

	private File evidenceImage;
	private String evidenceImageFileName;
	private String evidenceContentType;
	private File writeText;
	private String writeTextFileName;
	private String writeTextContentType;
	private File senceImage;
	private String senceImageFileName;
	private String senceImageContentType;
	private String filePosition;// 1 === 物证图片 2 === 笔录文件3 === 现场图
	private String downloadFileName;

	/**
	 * @author 孙毅 修改内容：修改立案时间 修改时间：2018-04-23
	 */

	public void updateCaseTime() {
		case1.setCase_registerTime(TeamUtil.getStringDay());
		senceService.updateCaseTime(case1);
	}

	/**
	 * 上传物证图片
	 * 
	 */
	public void uploadFile() {
		String fileSavePath = null;
		String newFileName = null;
		xsjsglxt_case uploadCase = senceService.getCaseByCaseId(case1);
		switch (filePosition) {
		case "1":
			fileSavePath = ServletActionContext.getServletContext().getRealPath("/upload/case/caseImage");
			System.out.println(fileSavePath);
			File fileHome = new File(fileSavePath);
			if (!fileHome.exists())
				fileHome.mkdirs();
			newFileName = TeamUtil.getUuid() + evidenceImageFileName.substring(evidenceImageFileName.lastIndexOf("."));
			String newFilePath = fileSavePath + "/" + newFileName;
			if (uploadCase.getCase_imageFile() != null && !"".equals(uploadCase.getCase_imageFile().trim())) {
				File oldFile = new File(fileSavePath + "/" + uploadCase.getCase_imageFile());
				if (oldFile.exists())
					oldFile.delete();
			}
			Thread thread = new Thread(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					try {
						FileUtil.copyFile(evidenceImage, new File(newFilePath));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
			thread.start();
			break;
		case "2":
			fileSavePath = ServletActionContext.getServletContext().getRealPath("/upload/case/caseWrite");
			File fileHome1 = new File(fileSavePath);
			if (!fileHome1.exists())
				fileHome1.mkdirs();
			newFileName = TeamUtil.getUuid() + writeTextFileName.substring(writeTextFileName.lastIndexOf("."));
			String newFilePath1 = fileSavePath + "/" + newFileName;
			if (uploadCase.getCase_writeFile() != null && !"".equals(uploadCase.getCase_writeFile().trim())) {
				File oldFile = new File(fileSavePath + "/" + uploadCase.getCase_writeFile());
				if (oldFile.exists())
					oldFile.delete();
			}
			Thread thread1 = new Thread(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					try {
						FileUtil.copyFile(writeText, new File(newFilePath1));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
			thread1.start();
			break;
		case "3":
			fileSavePath = ServletActionContext.getServletContext().getRealPath("/upload/case/caseSenceImage");
			File fileHome2 = new File(fileSavePath);
			if (!fileHome2.exists())
				fileHome2.mkdirs();
			newFileName = TeamUtil.getUuid() + senceImageFileName.substring(senceImageFileName.lastIndexOf("."));
			String newFilePath2 = fileSavePath + "/" + newFileName;
			if (uploadCase.getCase_senceImageFile() != null && !"".equals(uploadCase.getCase_senceImageFile().trim())) {
				File oldFile = new File(fileSavePath + "/" + uploadCase.getCase_senceImageFile());
				if (oldFile.exists())
					oldFile.delete();
			}
			Thread thread2 = new Thread(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					try {
						FileUtil.copyFile(senceImage, new File(newFilePath2));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
			thread2.start();
			break;

		}

		// 修改数据库中的文件名
		senceService.updateFileName(newFileName, filePosition, case1);
	}

	/**
	 * 下载
	 */
	public void download() {
		HttpServletResponse response = ServletActionContext.getResponse();
		switch (filePosition) {
		case "1":
			try {
				response.addHeader("Content-Disposition",
						"attachment; filename=\"" + new String(
								("物证图" + downloadFileName.substring(downloadFileName.lastIndexOf("."))).getBytes(),
								"ISO-8859-1") + "\"");
				File file = new File(ServletActionContext.getServletContext()
						.getRealPath("/upload/case/caseImage/" + downloadFileName + "/"));
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
			break;
		case "2":
			try {
				response.addHeader("Content-Disposition",
						"attachment; filename=\"" + new String(
								("笔录" + downloadFileName.substring(downloadFileName.lastIndexOf("."))).getBytes(),
								"ISO-8859-1") + "\"");
				File file = new File(ServletActionContext.getServletContext()
						.getRealPath("/upload/case/caseWrite/" + downloadFileName + "/"));
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
			break;
		case "3":
			try {
				response.addHeader("Content-Disposition",
						"attachment; filename=\"" + new String(
								("现场图" + downloadFileName.substring(downloadFileName.lastIndexOf("."))).getBytes(),
								"ISO-8859-1") + "\"");
				File file = new File(ServletActionContext.getServletContext()
						.getRealPath("/upload/case/caseSenceImage/" + downloadFileName + "/"));
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
			break;

		}

	}

	public String page_intoDetails() {
		return "page_intoDetails";
	}

	public String page_printPage() {
		return "page_printPage";
	}

	/*
	 * 跳转页面
	 */
	public String page_SiteManagement() {
		return "page_SiteManagement";
	}

	/*
	 * 跳转现场录入页面
	 */
	public String page_Sneceinput() {
		return "page_Sneceinput";
	}

	/*
	 * ��ת�ֳ�¼��ҳ��
	 */
	public String page_CaseMergerList() {
		return "page_CaseMergerList";
	}

	/*
	 * 跳转现场录入页面
	 */
	public String page_CaseMerger() {
		return "page_CaseMerger";
	}

	/*
	 * 
	 * ��ת�ֳ�¼��ҳ��
	 * 
	 */
	public String page_CaseMaterials() {
		return "page_CaseMaterials";
	}

	/*
	 * 
	 * ��ת��������ҳ��
	 * 
	 */
	public String page_CaseDetails() {
		ActionContext.getContext().getValueStack().set("id", http_request.getParameter("id"));
		return "page_CaseDetails";
	}

	/*
	 * 
	 * ��ת��������ҳ��
	 * 
	 */
	public String page_Handle() {
		return "page_Handle";
	}

	/**
	 * @author 孙毅 进入物证管理页面
	 */

	public String page_intoEvidence() {
		return "intoEvidence";
	}

	/*
	 * 
	 * 保存信息
	 * 
	 */
	public void saveSenceInformation() {

		try {
			GsonBuilder gsonBuilder = new GsonBuilder();
			gsonBuilder.setPrettyPrinting();// 格式化json数据
			Gson gson = gsonBuilder.create();

			senceService.save(case1);

			sence.setSnece_case(case1.getXsjsglxt_case_id());
			String fillPerson = (String) ActionContext.getContext().getSession().get("user_name");

			sence.setSnece_fillPerson(fillPerson);
			String unit = (String) ActionContext.getContext().getSession().get("user_unit");
			System.out.println(unit);
			sence.setSnece_fillUnit(unit);
			sence.setSnece_fillTime(TeamUtil.getStringSecond());
			senceService.save(sence);
			briefdetails.setBriefdetails_case(case1.getXsjsglxt_case_id());
			senceService.save(briefdetails);

			/*
			 * private List<xsjsglxt_lost> lostlist; private
			 * List<xsjsglxt_lost_mobilephone> lost_mobilephonelist; private
			 * List<xsjsglxt_picture> picturelist; private
			 * List<xsjsglxt_lost_computer> lost_computerlist;
			 */
			if (resevidencelist != null) {
				for (xsjsglxt_resevidence resevidence : resevidencelist) {
					resevidence.setResevidence_case(case1.getXsjsglxt_case_id());
					senceService.save(resevidence);
				}
			}

			if (lostlist != null) {
				for (xsjsglxt_lost lost : lostlist) {
					lost.setLost_case(case1.getXsjsglxt_case_id());
					senceService.save(lost);
				}
			}

			if (lost_mobilephonelist != null) {
				for (xsjsglxt_lost_mobilephone mobilephone : lost_mobilephonelist) {
					mobilephone.setLost_mobilephone_case(case1.getXsjsglxt_case_id());
					senceService.save(mobilephone);
				}
			}
			if (picturelist != null) {
				for (xsjsglxt_picture picture : picturelist) {
					picture.setPicture_case(case1.getXsjsglxt_case_id());
					senceService.save(picture);
				}
			}
			if (lost_computerlist != null) {
				for (xsjsglxt_lost_computer computer : lost_computerlist) {
					computer.setLost_computer_case(case1.getXsjsglxt_case_id());
					senceService.save(computer);
				}
			}
			// lost.setLost_case(Case.getXsjsglxt_case_id());
			// senceService.save(lost);

			// lost_mobilephone.setLost_mobilephone_case(Case.getXsjsglxt_case_id());
			// senceService.save(lost_mobilephone);

			// lost_computer.setLost_computer_case(Case.getXsjsglxt_case_id());
			// senceService.save(lost_computer);

			// picture.setPicture_case(Case.getXsjsglxt_case_id());
			// senceService.save(picture);
			http_response.setContentType("text/html;charset=utf-8");
			http_response.getWriter().write(gson.toJson(case1.getXsjsglxt_case_id()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			http_response.setContentType("text/html;charset=utf-8");
			try {
				http_response.getWriter().write("error");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}

	/*
	 * 得到勘验编号
	 */
	public void getSenceInquestId() throws IOException {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();
		String senceInformationInquestId = senceService.getMaxSenceInquestId();
		http_response.setContentType("text/html;charset=utf-8");
		http_response.getWriter().write(gson.toJson(senceInformationInquestId));
	}

	/*
	 * 列表信息
	 */
	public void ListSneceInformationByPageAndSearch() throws IOException {

		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();

		page_list_senceInformation = senceService.VO_SneceInformation_By_PageAndSearch(page_list_senceInformation);

		http_response.setContentType("text/html;charset=utf-8");

		http_response.getWriter().write(gson.toJson(page_list_senceInformation));

	}

	/*
	 * 详细信息
	 */
	public void SecneInformationOne() throws IOException {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();
		senceInformationAllDTO = senceService.SecneInformationOne(case1);
		http_response.setContentType("text/html;charset=utf-8");

		http_response.getWriter().write(gson.toJson(senceInformationAllDTO));
	}

	/*
	 * 修改信息
	 */
	public void updateSenceInformation() {
		try {
			System.out.println("开始");
			GsonBuilder gsonBuilder = new GsonBuilder();
			gsonBuilder.setPrettyPrinting();// 格式化json数据
			Gson gson = gsonBuilder.create();

			senceService.updateSence(sence, case1.getXsjsglxt_case_id());

			senceService.updateBriefdetails(briefdetails, case1.getXsjsglxt_case_id());
			senceService.updateCase(case1);
			http_response.setContentType("text/html;charset=utf-8");
			http_response.getWriter().write("success");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/*
	 * 删除信息
	 */
	public void remove_SenceInformationList() {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();
		if (senceService.remove_SenceInformationList(useSenceInformationNumList)) {
			http_response.setContentType("text/html;charset=utf-8");
			try {
				http_response.getWriter().write("success");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	/*
	 * 所有案件
	 */
	public void AllCase() throws IOException {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();
		List<xsjsglxt_case> Allcase = new ArrayList<xsjsglxt_case>();
		Allcase = senceService.AllCase();
		http_response.setContentType("text/html;charset=utf-8");

		http_response.getWriter().write(gson.toJson(Allcase));
	}

	public SenceService getSenceService() {
		return senceService;
	}

	public void setSenceService(SenceService senceService) {
		this.senceService = senceService;
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

	public xsjsglxt_snece getSence() {
		return sence;
	}

	public void setSence(xsjsglxt_snece sence) {
		this.sence = sence;
	}

	public xsjsglxt_case getCase1() {
		return case1;
	}

	public void setCase1(xsjsglxt_case case1) {
		this.case1 = case1;
	}

	public xsjsglxt_briefdetails getBriefdetails() {
		return briefdetails;
	}

	public void setBriefdetails(xsjsglxt_briefdetails briefdetails) {
		this.briefdetails = briefdetails;
	}

	public xsjsglxt_lost getLost() {
		return lost;
	}

	public void setLost(xsjsglxt_lost lost) {
		this.lost = lost;
	}

	public xsjsglxt_lost_mobilephone getLost_mobilephone() {
		return lost_mobilephone;
	}

	public void setLost_mobilephone(xsjsglxt_lost_mobilephone lost_mobilephone) {
		this.lost_mobilephone = lost_mobilephone;
	}

	public xsjsglxt_lost_computer getLost_computer() {
		return lost_computer;
	}

	public void setLost_computer(xsjsglxt_lost_computer lost_computer) {
		this.lost_computer = lost_computer;
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

	public xsjsglxt_picture getPicture() {
		return picture;
	}

	public void setPicture(xsjsglxt_picture picture) {
		this.picture = picture;
	}

	public page_list_senceInformationVO getPage_list_senceInformation() {
		return page_list_senceInformation;
	}

	public void setPage_list_senceInformation(page_list_senceInformationVO page_list_senceInformation) {
		this.page_list_senceInformation = page_list_senceInformation;
	}

	public SenceInformationDTO getSenceInformationDTO() {
		return senceInformationDTO;
	}

	public void setSenceInformationDTO(SenceInformationDTO senceInformationDTO) {
		this.senceInformationDTO = senceInformationDTO;
	}

	public List<String> getUseSenceInformationNumList() {
		return useSenceInformationNumList;
	}

	public void setUseSenceInformationNumList(List<String> useSenceInformationNumList) {
		this.useSenceInformationNumList = useSenceInformationNumList;
	}

	public SenceInformationAllDTO getSenceInformationAllDTO() {
		return senceInformationAllDTO;
	}

	public void setSenceInformationAllDTO(SenceInformationAllDTO senceInformationAllDTO) {
		this.senceInformationAllDTO = senceInformationAllDTO;
	}

	public File getEvidenceImage() {
		return evidenceImage;
	}

	public void setEvidenceImage(File evidenceImage) {
		this.evidenceImage = evidenceImage;
	}

	public String getEvidenceImageFileName() {
		return evidenceImageFileName;
	}

	public void setEvidenceImageFileName(String evidenceImageFileName) {
		this.evidenceImageFileName = evidenceImageFileName;
	}

	public String getEvidenceContentType() {
		return evidenceContentType;
	}

	public void setEvidenceContentType(String evidenceContentType) {
		this.evidenceContentType = evidenceContentType;
	}

	public File getWriteText() {
		return writeText;
	}

	public void setWriteText(File writeText) {
		this.writeText = writeText;
	}

	public String getWriteTextFileName() {
		return writeTextFileName;
	}

	public void setWriteTextFileName(String writeTextFileName) {
		this.writeTextFileName = writeTextFileName;
	}

	public String getWriteTextContentType() {
		return writeTextContentType;
	}

	public void setWriteTextContentType(String writeTextContentType) {
		this.writeTextContentType = writeTextContentType;
	}

	public File getSenceImage() {
		return senceImage;
	}

	public void setSenceImage(File senceImage) {
		this.senceImage = senceImage;
	}

	public String getSenceImageFileName() {
		return senceImageFileName;
	}

	public void setSenceImageFileName(String senceImageFileName) {
		this.senceImageFileName = senceImageFileName;
	}

	public String getSenceImageContentType() {
		return senceImageContentType;
	}

	public void setSenceImageContentType(String senceImageContentType) {
		this.senceImageContentType = senceImageContentType;
	}

	public String getFilePosition() {
		return filePosition;
	}

	public void setFilePosition(String filePosition) {
		this.filePosition = filePosition;
	}

	public String getDownloadFileName() {
		return downloadFileName;
	}

	public void setDownloadFileName(String downloadFileName) {
		this.downloadFileName = downloadFileName;
	}

	public List<xsjsglxt_lost> getLostlist() {
		return lostlist;
	}

	public void setLostlist(List<xsjsglxt_lost> lostlist) {
		this.lostlist = lostlist;
	}

	public List<xsjsglxt_lost_mobilephone> getLost_mobilephonelist() {
		return lost_mobilephonelist;
	}

	public void setLost_mobilephonelist(List<xsjsglxt_lost_mobilephone> lost_mobilephonelist) {
		this.lost_mobilephonelist = lost_mobilephonelist;
	}

	public List<xsjsglxt_picture> getPicturelist() {
		return picturelist;
	}

	public void setPicturelist(List<xsjsglxt_picture> picturelist) {
		this.picturelist = picturelist;
	}

	public List<xsjsglxt_lost_computer> getLost_computerlist() {
		return lost_computerlist;
	}

	public void setLost_computerlist(List<xsjsglxt_lost_computer> lost_computerlist) {
		this.lost_computerlist = lost_computerlist;
	}

	public List<xsjsglxt_resevidence> getResevidencelist() {
		return resevidencelist;
	}

	public void setResevidencelist(List<xsjsglxt_resevidence> resevidencelist) {
		this.resevidencelist = resevidencelist;
	}

}