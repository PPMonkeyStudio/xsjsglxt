package com.xsjsglxt.action.Case;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.google.gson.Gson;
import com.xsjsglxt.domain.DO.xsjsglxt_handle_case;
import com.xsjsglxt.domain.DO.xsjsglxt_suspect_infor;
import com.xsjsglxt.domain.DO.xsjsglxt_suspect_state;
import com.xsjsglxt.domain.DO.xsjsglxt_take_goods;
import com.xsjsglxt.domain.DTO.Case.MessageDTO;
import com.xsjsglxt.domain.VO.Case.HandleCaseListVO;
import com.xsjsglxt.domain.VO.Case.SuspectListVO;
import com.xsjsglxt.service.Case.DealCaseService;

import util.TeamUtil;

//办案模块
public class DealCaseAction implements ServletRequestAware, ServletResponseAware {
	private DealCaseService dealCaseService;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private xsjsglxt_handle_case handleCase;
	private String handleCase_id;
	private HandleCaseListVO handleCaseListVO;
	private xsjsglxt_suspect_infor suspectInfor;
	private xsjsglxt_take_goods takeGoods;

	private File goodsPhoto;
	private String goodsPhotoFileName;
	private String goodsPhotoContentType;

	private String downloadFileName;
	private SuspectListVO suspectVO;
	private int isChangeType;

	// 获得所有通知
	public void getMessage() throws IOException {
		response.setContentType("text/html;charset=utf-8");
		Set<MessageDTO> messageList = dealCaseService.getMessage();
		Gson gson = new Gson();
		String result = gson.toJson(messageList);
		PrintWriter pw = response.getWriter();
		pw.write(result);
		pw.flush();
		pw.close();
	}

	// 嫌疑人分页
	public void suspectList() throws IOException {
		response.setContentType("text/html;charset=utf-8");
		dealCaseService.getSuspectList(suspectVO);
		Gson gson = new Gson();
		String result = gson.toJson(suspectVO);
		PrintWriter pw = response.getWriter();
		pw.write(result);
		pw.flush();
		pw.close();
	}

	// 跳转页面
	public String intoSuspectList() {
		return "intoSuspectList";
	}

	// 获得嫌疑人的状态记录
	public void suspectStates() throws IOException {
		response.setContentType("text/html;charset=utf-8");
		List<xsjsglxt_suspect_state> list = dealCaseService.getSuspectStates(suspectInfor.getSuspect_id());
		Gson gson = new Gson();
		String result = gson.toJson(list);
		PrintWriter pw = response.getWriter();
		pw.write(result);
		pw.flush();
		pw.close();

	}

	// 保存办案基本信息（测试成功）
	public void saveHandleCase() throws IOException {
		response.setContentType("text/html;charset=utf-8");
		String id = TeamUtil.getUuid();
		handleCase.setHandle_case_id(id);
		handleCase.setHandle_gmt_create(TeamUtil.getStringSecond());
		handleCase.setHandle_gmt_modified(TeamUtil.getStringSecond());
		boolean flag = dealCaseService.saveHandleCase(handleCase);
		PrintWriter pw = response.getWriter();
		if (flag) {
			pw.write(id);
		} else {
			pw.write("saveError");
		}
		pw.flush();
		pw.close();
	}

	// 修改办案基本信息（测试成功）
	public void updateHandleCase() throws IOException {
		response.setContentType("text/html;charset=utf-8");
		boolean flag = dealCaseService.updateHandleCase(handleCase);
		PrintWriter pw = response.getWriter();
		if (flag) {
			pw.write("updateSuccess");
		} else {
			pw.write("updateError");
		}
		pw.flush();
		pw.close();
	}

	// 删除办案基本信息--连带删除嫌疑人以及随带物品（测试无误）
	public void deleteHandleCase() throws IOException {
		response.setContentType("text/html;charset=utf-8");
		boolean flag = dealCaseService.deleteHandleCase(handleCase_id);
		PrintWriter pw = response.getWriter();
		if (flag) {
			pw.write("deleteSuccess");
		} else {
			pw.write("deleteError");
		}
		pw.flush();
		pw.close();
	}

	// 查看详细办案信息（测试无误）
	public void gainHandleCaseById() throws IOException {
		response.setContentType("text/html;charset=utf-8");
		xsjsglxt_handle_case handleCase = dealCaseService.gainHandleCaseById(handleCase_id);
		Gson gson = new Gson();
		String result = gson.toJson(handleCase);
		PrintWriter pw = response.getWriter();
		pw.write(result);
		pw.flush();
		pw.close();
	}

	// 列表查询办案信息（测试无误）
	public void pageList() throws IOException {
		response.setContentType("text/html;charset=utf-8");
		dealCaseService.pageList(handleCaseListVO);
		Gson gson = new Gson();
		String result = gson.toJson(handleCaseListVO);
		PrintWriter pw = response.getWriter();
		pw.write(result);
		pw.flush();
		pw.close();
	}

	// 添加嫌疑人(测试无误)
	public void saveSuspect() throws IOException {
		response.setContentType("text/html;charset=utf-8");
		suspectInfor.setSuspect_id(TeamUtil.getUuid());
		suspectInfor.setSuspect_gmt_create(TeamUtil.getStringSecond());
		suspectInfor.setSuspect_gmt_modified(TeamUtil.getStringSecond());
		boolean flag = dealCaseService.saveSuspect(suspectInfor);
		PrintWriter pw = response.getWriter();
		if (flag) {
			pw.write("saveSuccess");
		} else {
			pw.write("saveError");
		}
		pw.flush();
		pw.close();
	}

	// 修改嫌疑人（测试无误）
	public void updateSuspect() throws IOException {
		response.setContentType("text/html;charset=utf-8");
		boolean flag = dealCaseService.updateSuspect(suspectInfor, isChangeType);
		PrintWriter pw = response.getWriter();
		if (flag) {
			pw.write("updateSuccess");
		} else {
			pw.write("updateError");
		}
		pw.flush();
		pw.close();
	}

	// 删除嫌疑人（测试无误）
	public void deleteSuspect() throws IOException {
		response.setContentType("text/html;charset=utf-8");
		boolean flag = dealCaseService.deleteSuspect(suspectInfor);
		PrintWriter pw = response.getWriter();
		if (flag) {
			pw.write("deleteSuccess");
		} else {
			pw.write("deleteError");
		}
		pw.flush();
		pw.close();
	}

	// 获得一个嫌疑人（测试无误）
	public void getSuspectById() throws IOException {
		response.setContentType("text/html;charset=utf-8");
		xsjsglxt_suspect_infor suspect = dealCaseService.getSuspectById(suspectInfor.getSuspect_id());
		Gson gson = new Gson();
		String result = gson.toJson(suspect);
		PrintWriter pw = response.getWriter();
		pw.write(result);
		pw.flush();
		pw.close();
	}

	// 通过案件id获得所有嫌疑人（测试无误）
	public void getSuspectByCaseId() throws IOException {
		response.setContentType("text/html;charset=utf-8");
		List<xsjsglxt_suspect_infor> suspectList = dealCaseService.getSuspectByCaseId(handleCase_id);
		Gson gson = new Gson();
		String result = gson.toJson(suspectList);
		PrintWriter pw = response.getWriter();
		pw.write(result);
		pw.flush();
		pw.close();
	}

	// 添加随身物品（照片）（测试无误）
	public void saveTakeGoods() throws IOException {
		response.setContentType("text/html;charset=utf-8");
		if (goodsPhoto != null) {
			String filename = ServletActionContext.getServletContext().getRealPath("/upload/takePhoto/"
					+ TeamUtil.getUuid() + goodsPhotoFileName.substring(goodsPhotoFileName.lastIndexOf(".")));
			File deskFile = new File(filename);
			FileUtils.copyFile(goodsPhoto, deskFile);
			takeGoods.setGoods_photo_path(filename);
		} else {
			takeGoods.setGoods_photo_path("noPhoto");
		}
		takeGoods.setGoods_id(TeamUtil.getUuid());
		takeGoods.setGoods_gmt_create(TeamUtil.getStringSecond());
		takeGoods.setGoods_gmt_modified(TeamUtil.getStringSecond());
		boolean flag = dealCaseService.saveTakeGoods(takeGoods);
		PrintWriter pw = response.getWriter();
		if (flag) {
			pw.write("saveSuccess");
		} else {
			pw.write("saveError");
		}
		pw.flush();
		pw.close();
	}

	// 修改随身物品
	public void updateTakeGoods() throws IOException {
		response.setContentType("text/html;charset=utf-8");
		xsjsglxt_take_goods goods = dealCaseService.getTakeGoodsById(takeGoods.getGoods_id());
		if (goodsPhoto != null) {
			if (!goods.getGoods_photo_path().equals("noPhoto")) {
				File oldFile = new File(goods.getGoods_photo_path());
				if (oldFile.exists())
					oldFile.delete();
			}
			String filename = ServletActionContext.getServletContext().getRealPath("/upload/takePhoto/"
					+ TeamUtil.getUuid() + goodsPhotoFileName.substring(goodsPhotoFileName.lastIndexOf(".")));
			File deskFile = new File(filename);
			FileUtils.copyFile(goodsPhoto, deskFile);
			takeGoods.setGoods_photo_path(filename);
		} else {
			takeGoods.setGoods_photo_path(goods.getGoods_photo_path());
		}
		boolean flag = dealCaseService.updateTakeGoods(takeGoods);
		PrintWriter pw = response.getWriter();
		if (flag) {
			pw.write("updateSuccess");
		} else {
			pw.write("updateError");
		}
		pw.flush();
		pw.close();
	}

	// 删除随身物品（测试无误）
	public void deleteTakeGoods() throws IOException {
		response.setContentType("text/html;charset=utf-8");
		boolean flag = dealCaseService.deleteTakeGoods(takeGoods);
		PrintWriter pw = response.getWriter();
		if (flag) {
			pw.write("updateSuccess");
		} else {
			pw.write("updateError");
		}
		pw.flush();
		pw.close();
	}

	// 获得一个随身物品
	public void getTakeGoodsById() throws IOException {
		response.setContentType("text/html;charset=utf-8");
		xsjsglxt_take_goods goods = dealCaseService.getTakeGoodsById(takeGoods.getGoods_id());
		Gson gson = new Gson();
		String result = gson.toJson(goods);
		PrintWriter pw = response.getWriter();
		pw.write(result);
		pw.flush();
		pw.close();
	}

	// 通过嫌疑人id获得所有随身物品（测试无误）
	public void getTakeGoodsBySuspectId() throws IOException {
		response.setContentType("text/html;charset=utf-8");
		List<xsjsglxt_take_goods> goodsList = dealCaseService.getTakeGoodsBySuspectId(suspectInfor.getSuspect_id());
		Gson gson = new Gson();
		String result = gson.toJson(goodsList);
		PrintWriter pw = response.getWriter();
		pw.write(result);
		pw.flush();
		pw.close();
	}

	// 下载照片
	public void downloadTakeGoods() throws IOException {
		downloadFileName = ServletActionContext.getServletContext()
				.getRealPath("/upload/takePhoto/" + downloadFileName);
		response.addHeader("Content-Disposition",
				"attachment; filename=\"" + new String("随带物品".getBytes(), "ISO-8859-1") + "\"");
		OutputStream os = response.getOutputStream();
		File file = new File(downloadFileName);
		if (file.exists()) {
			byte[] buffer = new byte[1024];
			FileInputStream fis = new FileInputStream(file);
			while (fis.read(buffer, 0, 1024) != -1) {
				os.write(buffer);
				os.flush();
			}
			fis.close();
		}
		os.close();
	}

	public DealCaseService getDealCaseService() {
		return dealCaseService;
	}

	public xsjsglxt_handle_case getHandleCase() {
		return handleCase;
	}

	public void setHandleCase(xsjsglxt_handle_case handleCase) {
		this.handleCase = handleCase;
	}

	public void setDealCaseService(DealCaseService dealCaseService) {
		this.dealCaseService = dealCaseService;
	}

	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
		this.response = arg0;
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		this.request = arg0;
	}

	public String getHandleCase_id() {
		return handleCase_id;
	}

	public void setHandleCase_id(String handleCase_id) {
		this.handleCase_id = handleCase_id;
	}

	public HandleCaseListVO getHandleCaseListVO() {
		return handleCaseListVO;
	}

	public void setHandleCaseListVO(HandleCaseListVO handleCaseListVO) {
		this.handleCaseListVO = handleCaseListVO;
	}

	public xsjsglxt_suspect_infor getSuspectInfor() {
		return suspectInfor;
	}

	public void setSuspectInfor(xsjsglxt_suspect_infor suspectInfor) {
		this.suspectInfor = suspectInfor;
	}

	public File getGoodsPhoto() {
		return goodsPhoto;
	}

	public void setGoodsPhoto(File goodsPhoto) {
		this.goodsPhoto = goodsPhoto;
	}

	public String getGoodsPhotoFileName() {
		return goodsPhotoFileName;
	}

	public void setGoodsPhotoFileName(String goodsPhotoFileName) {
		this.goodsPhotoFileName = goodsPhotoFileName;
	}

	public String getGoodsPhotoContentType() {
		return goodsPhotoContentType;
	}

	public void setGoodsPhotoContentType(String goodsPhotoContentType) {
		this.goodsPhotoContentType = goodsPhotoContentType;
	}

	public xsjsglxt_take_goods getTakeGoods() {
		return takeGoods;
	}

	public void setTakeGoods(xsjsglxt_take_goods takeGoods) {
		this.takeGoods = takeGoods;
	}

	public String getDownloadFileName() {
		return downloadFileName;
	}

	public void setDownloadFileName(String downloadFileName) {
		this.downloadFileName = downloadFileName;
	}

	public SuspectListVO getSuspectVO() {
		return suspectVO;
	}

	public void setSuspectVO(SuspectListVO suspectVO) {
		this.suspectVO = suspectVO;
	}

	public int getIsChangeType() {
		return isChangeType;
	}

	public void setIsChangeType(int isChangeType) {
		this.isChangeType = isChangeType;
	}

}
