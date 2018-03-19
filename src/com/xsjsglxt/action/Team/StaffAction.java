package com.xsjsglxt.action.Team;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.aspectj.util.FileUtil;

import com.opensymphony.xwork2.ActionSupport;
import com.xsjsglxt.domain.DO.xsjsglxt_staff;
import com.xsjsglxt.service.Team.StaffService;

import util.TeamUtil;

/*
 * @author 孙毅
 * @description 警员管理Action
 */
public class StaffAction extends ActionSupport {

	private StaffService staffService;
	private xsjsglxt_staff policeman;
	private File staff_image;
	private String staff_imageContentType;
	private String staff_imageFileName;

	// -----------------------------------进入人员管理---------------------------------------
	public String page_staffList() {
		return "StaffIndex";
	}

	// -----------------------------------添加警员基本信息------------------------------------

	public void saveStaff() {
		// 上传头像
		if (staff_imageFileName != null && staff_imageFileName.trim().length() > 0) {
			String realPath = ServletActionContext.getServletContext().getRealPath("/upload/staffImage");
			// 判断文件夹是否存在
			File fileHome = new File(realPath);
			if (!fileHome.exists())
				fileHome.mkdirs();
			// 截取文件名获得文件类型
			String fileType = staff_imageFileName.substring(staff_imageFileName.lastIndexOf("."));
			// 重新构造文件名
			String newFileName = TeamUtil.getUuid();
			String newFilePath = realPath + "/" + newFileName + fileType;
			try {
				// 拷贝文件到服务器目录
				FileUtil.copyFile(staff_image, new File(newFilePath));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			policeman.setStaff_photo(newFileName + fileType);
		}
		String result = staffService.saveStaff(policeman);
		HttpServletResponse response = ServletActionContext.getResponse();
		System.out.println("开始保存");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw;
		try {
			pw = response.getWriter();
			pw.write(result);
			pw.flush();
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// ------------------------------------删除警员信息-------------------------------------

	// ------------------------------------setter/getter-----------------------------------
	public StaffService getStaffService() {
		return staffService;
	}

	public xsjsglxt_staff getPoliceman() {
		return policeman;
	}

	public void setPoliceman(xsjsglxt_staff policeman) {
		this.policeman = policeman;
	}

	public void setStaffService(StaffService staffService) {
		this.staffService = staffService;
	}

	public File getStaff_image() {
		return staff_image;
	}

	public void setStaff_image(File staff_image) {
		this.staff_image = staff_image;
	}

	public String getStaff_imageContentType() {
		return staff_imageContentType;
	}

	public void setStaff_imageContentType(String staff_imageContentType) {
		this.staff_imageContentType = staff_imageContentType;
	}

	public String getStaff_imageFileName() {
		return staff_imageFileName;
	}

	public void setStaff_imageFileName(String staff_imageFileName) {
		this.staff_imageFileName = staff_imageFileName;
	}
}
