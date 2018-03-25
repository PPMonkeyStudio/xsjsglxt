package com.xsjsglxt.action.Team;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.aspectj.util.FileUtil;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import com.xsjsglxt.domain.DO.xsjsglxt_staff;
import com.xsjsglxt.domain.VO.Team.policemanListVO;
import com.xsjsglxt.service.Team.StaffService;

import util.TeamUtil;

/*
 * @author 孙毅
 * @description 基本信息action
 */
public class StaffAction extends ActionSupport {

	private StaffService staffService;
	private xsjsglxt_staff policeman;
	private File staff_image;
	private String staff_imageContentType;
	private String staff_imageFileName;
	private policemanListVO policemanVO;

	private String xsjsglxt_staff_id;

	// -----------------------------------进入人员管理---------------------------------------
	public String page_staffList() {
		return "StaffIndex";
	}

	public String page_newStaff() {
		return "NewStaff";
	}

	public String page_staffDetails() {
		return "staffDetails";
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
			// 拷贝文件到服务器目录
			Thread thread = new Thread(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					try {
						FileUtil.copyFile(staff_image, new File(newFilePath));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
			thread.start();
			policeman.setStaff_photo(newFileName + fileType);
		}
		String result = staffService.saveStaff(policeman);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw;
		try {
			pw = response.getWriter();
			pw.write(policeman.getXsjsglxt_staff_id());
			pw.flush();
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// ------------------------------------删除警员信息-------------------------------------
	public void deletePoliceman() {

		// 删除警员的照片
		xsjsglxt_staff oldPoliceman = staffService.getPolicemanByStaffId(policeman.getXsjsglxt_staff_id());
		if (oldPoliceman.getStaff_photo() != null && oldPoliceman.getStaff_photo().trim().length() > 0) {
			String realPath = ServletActionContext.getServletContext().getRealPath("/upload/staffImage");
			File oldPhoto = new File(realPath + "/" + oldPoliceman.getStaff_photo());
			if (oldPhoto.exists()) {
				oldPhoto.delete();
			}
		}
		String result = staffService.deletePoliceman(policeman);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		try {
			PrintWriter pw = response.getWriter();
			pw.write(result);
			pw.flush();
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// ------------------------------------修改警员信息-------------------------------------
	public void updatePoliceman() {
		// 判断是否修改了照片
		xsjsglxt_staff oldPoliceman = staffService.getPolicemanByStaffId(policeman.getXsjsglxt_staff_id());
		if (staff_imageFileName != null && staff_imageFileName.trim().length() > 0) {
			// 获得数据库中原有的信息，并删除原有照片
			String realPath = ServletActionContext.getServletContext().getRealPath("/upload/staffImage");
			File oldPhoto = new File(realPath + "/" + oldPoliceman.getStaff_photo());
			if (oldPhoto.exists())
				oldPhoto.delete();
			// 获得服务器中的文件仓储位置，并判断是否存在
			File photoFactory = new File(realPath);
			if (!photoFactory.exists())
				photoFactory.mkdirs();
			// 获取修改后的文件的文件类型
			String photoType = staff_imageFileName.substring(staff_imageFileName.lastIndexOf("."));
			// 构建新文件名
			String photoName = TeamUtil.getUuid();
			Thread thread = new Thread(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					try {
						// 拷贝文件
						FileUtil.copyFile(staff_image, new File(realPath + "/" + photoName + photoType));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
			thread.start();
			policeman.setStaff_photo(photoName + photoType);
		} else {
			policeman.setStaff_photo(oldPoliceman.getStaff_photo());
		}
		policeman.setStaff_gmt_create(oldPoliceman.getStaff_gmt_create());
		String result = staffService.updatePoliceman(policeman);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		try {
			PrintWriter pw = response.getWriter();
			pw.write(result);
			pw.flush();
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// ----------------------------------------获得一个警员基本信息----------------------------

	public void getPolicemanByStaffId() {
		xsjsglxt_staff staff = staffService.getPolicemanByStaffId(policeman.getXsjsglxt_staff_id());
		Gson gson = new Gson();
		String result = gson.toJson(staff);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		try {
			PrintWriter pw = response.getWriter();
			pw.write(result);
			pw.flush();
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// ----------------------------------------获得多个警员信息(查询/分页)----------------------
	public void getPolicemansByPage() {
		staffService.getPolicemansByPage(policemanVO);
		Gson gson = new Gson();
		String result = gson.toJson(policemanVO);
		System.out.println(result);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		try {
			PrintWriter pw = response.getWriter();
			pw.write(result);
			pw.flush();
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// ---------------------------------------下载头像--------------------------------------
	public void downloadPhoto() {
		HttpServletResponse response = ServletActionContext.getResponse();
		try {
			response.addHeader("Content-Disposition",
					"attachment; filename=\"" + new String(staff_imageFileName.getBytes(), "ISO-8859-1") + "\"");
			String filePath = ServletActionContext.getServletContext()
					.getRealPath("/upload/staffImage/" + staff_imageFileName);
			try {
				OutputStream os = response.getOutputStream();

				File file = new File(filePath);
				byte[] buffer = new byte[1024];
				int length = 1024;
				FileInputStream fins;
				try {
					fins = new FileInputStream(file);
					try {
						while (fins.read(buffer, 0, length) != -1) {
							os.write(buffer);
						}
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
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	// ------------------------------------setter/getter-----------------------------------

	public StaffService getStaffService() {
		return staffService;
	}

	public String getXsjsglxt_staff_id() {
		return xsjsglxt_staff_id;
	}

	public void setXsjsglxt_staff_id(String xsjsglxt_staff_id) {
		this.xsjsglxt_staff_id = xsjsglxt_staff_id;
	}

	public policemanListVO getPolicemanVO() {
		return policemanVO;
	}

	public void setPolicemanVO(policemanListVO policemanVO) {
		this.policemanVO = policemanVO;
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
