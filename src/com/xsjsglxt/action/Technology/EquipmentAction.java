package com.xsjsglxt.action.Technology;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.ActionSupport;
import com.xsjsglxt.domain.DO.xsjsglxt_equipment;
import com.xsjsglxt.domain.VO.Technology.EquipmentVO;
import com.xsjsglxt.service.Technology.EquipmentService;

public class EquipmentAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {
	
	private EquipmentService equipmentService;

	private HttpServletResponse http_response;

	private HttpServletRequest http_request;

	private EquipmentVO equipmentVO;

	private xsjsglxt_equipment equipment;

	private List<String> listDeleteEquipmentID;
	
	private String xsjsglxt_equipment_id;
	
	public void CreateEquipment() throws IOException {
		int result = equipmentService.saveEquipment(equipment);
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();
		http_response.setContentType("text/html;charset=utf-8");
		http_response.getWriter().write(gson.toJson(result));
	}
 
	public void deleteEquipment() throws IOException {
		int result = equipmentService.deleteEquipment(xsjsglxt_equipment_id);
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();
		http_response.setContentType("text/html;charset=utf-8");
		http_response.getWriter().write(gson.toJson(result));
	}
	
	public void deleteListEquipment() throws IOException {
		int result = equipmentService.deleteListEquipment(listDeleteEquipmentID);
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();
		http_response.setContentType("text/html;charset=utf-8");
		http_response.getWriter().write(gson.toJson(result));
	}
	
	public void modifiedEquipment() throws IOException {
		int result = equipmentService.modifiedEquipment(equipment);
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();
		http_response.setContentType("text/html;charset=utf-8");
		http_response.getWriter().write(gson.toJson(result));
	}
	
	public void get_equipment() throws IOException {
		xsjsglxt_equipment e = equipmentService.get_equipment(xsjsglxt_equipment_id);
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();
		http_response.setContentType("text/html;charset=utf-8");
		http_response.getWriter().write(gson.toJson(e));
	}
	
	public void ListEquipmentByPageAndSearch() throws IOException {
		EquipmentVO vo = equipmentService.list_xsjsglxt_equipment(equipmentVO);
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();
		http_response.setContentType("text/html;charset=utf-8");
		http_response.getWriter().write(gson.toJson(vo));
	}
	
	public String EquipmentManagementPage() {
		return "EquipmentManagementPage";
	}

	@Override
	public void setServletResponse(HttpServletResponse http_response) {
		this.http_response = http_response;
	}

	@Override
	public void setServletRequest(HttpServletRequest http_request) {
		this.http_request= http_request;
	}

	@Override
	public String toString() {
		return "EquipmentAction [equipmentService=" + equipmentService + ", http_response=" + http_response
				+ ", http_request=" + http_request + ", equipmentVO=" + equipmentVO + ", equipment=" + equipment
				+ ", listDeleteEquipmentID=" + listDeleteEquipmentID + ", xsjsglxt_equipment_id="
				+ xsjsglxt_equipment_id + "]";
	}

	public EquipmentService getEquipmentService() {
		return equipmentService;
	}

	public void setEquipmentService(EquipmentService equipmentService) {
		this.equipmentService = equipmentService;
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

	public EquipmentVO getEquipmentVO() {
		return equipmentVO;
	}

	public void setEquipmentVO(EquipmentVO equipmentVO) {
		this.equipmentVO = equipmentVO;
	}

	public xsjsglxt_equipment getEquipment() {
		return equipment;
	}

	public void setEquipment(xsjsglxt_equipment equipment) {
		this.equipment = equipment;
	}

	public List<String> getListDeleteEquipmentID() {
		return listDeleteEquipmentID;
	}

	public void setListDeleteEquipmentID(List<String> listDeleteEquipmentID) {
		this.listDeleteEquipmentID = listDeleteEquipmentID;
	}

	public String getXsjsglxt_equipment_id() {
		return xsjsglxt_equipment_id;
	}

	public void setXsjsglxt_equipment_id(String xsjsglxt_equipment_id) {
		this.xsjsglxt_equipment_id = xsjsglxt_equipment_id;
	}
	
	

}
