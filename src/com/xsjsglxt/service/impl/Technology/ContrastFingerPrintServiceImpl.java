package com.xsjsglxt.service.impl.Technology;

import java.util.Arrays;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.xsjsglxt.dao.Technology.ContrastFingerPrintDao;
import com.xsjsglxt.domain.DO.xsjsglxt_contrast_fingerprint;
import com.xsjsglxt.domain.DO.xsjsglxt_dna;
import com.xsjsglxt.domain.DO.xsjsglxt_equipment;
import com.xsjsglxt.domain.DO.xsjsglxt_fingerprint;
import com.xsjsglxt.domain.VO.Technology.ContrastFingerPrintVO;
import com.xsjsglxt.domain.VO.Technology.DNAVO;
import com.xsjsglxt.service.Technology.ContrastFingerPrintService;

import util.ExcelHead;
import util.ExportExcelCollection;
import util.MapUtil;

import util.TeamUtil;

public class ContrastFingerPrintServiceImpl implements ContrastFingerPrintService {
	
	public ContrastFingerPrintDao getContrastFingerPrintDao() {
		return contrastFingerPrintDao;
	}

	public void setContrastFingerPrintDao(ContrastFingerPrintDao contrastFingerPrintDao) {
		this.contrastFingerPrintDao = contrastFingerPrintDao;
	}

	private ContrastFingerPrintDao contrastFingerPrintDao;

	@Override
	public int saveContrast(xsjsglxt_contrast_fingerprint contrastFingerPrint) {
		contrastFingerPrint.setContrast_fingerprint_id(TeamUtil.getUuid());
//		contrastFingerPrint.setContrast_fingerprint_time(TeamUtil.getStringSecond());
//		contrastFingerPrint.setContrast_fingerprint_gmt_modified(TeamUtil.getStringSecond());
		contrastFingerPrint.setContrast_fingerprint_gmt_create(TeamUtil.getStringSecond());
		int result = contrastFingerPrintDao.saveContrast(contrastFingerPrint);
		if (result > 0) {
			return 1;
		}
		return 2;
	}

	@Override
	public int deleteContrast(String contrast_fingerprint_id) {
		int result = contrastFingerPrintDao.deleteContrast(contrast_fingerprint_id);
		if (result > 0) {
			return 1;
		}
		return 2;
	}

	@Override
	public int deleteListContrast(List<String> listDeleteContrastID) {
		int result = 0;
		for (String id : listDeleteContrastID) {
			result += contrastFingerPrintDao.deleteContrast(id);
		}
		if (result == listDeleteContrastID.size()) {
			return 1;
		}
		return 2;
	}

	@Override
	public int modifiedContrast(xsjsglxt_contrast_fingerprint contrastFingerPrint) {
		contrastFingerPrint.setContrast_fingerprint_gmt_modified(TeamUtil.getStringSecond());
		int result = contrastFingerPrintDao.modifiedContrast(contrastFingerPrint);
		if (result > 0) {
			return 1;
		}
		return 2;
	}

	@Override
	public xsjsglxt_contrast_fingerprint get_contrast(String contrast_fingerprint_id) {
		xsjsglxt_contrast_fingerprint contrast = contrastFingerPrintDao.get_contrast(contrast_fingerprint_id);
		return contrast;
	}

	@Override
	public ContrastFingerPrintVO list_xsjsglxt_contrast(ContrastFingerPrintVO contrastFingerPrintVO) {
		int totalRecords = contrastFingerPrintDao.count_contrast_all(contrastFingerPrintVO);
		ContrastFingerPrintVO vo = new ContrastFingerPrintVO();
		vo.setPageIndex(contrastFingerPrintVO.getPageIndex());
		vo.setPageSize(contrastFingerPrintVO.getPageSize());
		vo.setTotalRecords(totalRecords);
		vo.setTotalPages(((totalRecords - 1) / vo.getPageSize()) + 1);
		if (vo.getPageIndex() <= 1) {
			vo.setHavePrePage(false);
		} else {
			vo.setHavePrePage(true);
		}
		if (vo.getPageIndex() >= vo.getTotalPages()) {
			vo.setHaveNextPage(false);
		} else {
			vo.setHaveNextPage(true);
		}
		List<xsjsglxt_contrast_fingerprint> list = contrastFingerPrintDao.list_xsjsglxt_contrast(contrastFingerPrintVO);
		/*高亮现场指纹编号、按印指纹编号*/
		for (xsjsglxt_contrast_fingerprint cotrast : list) {
			if (contrastFingerPrintVO.getSearch() != null && contrastFingerPrintVO.getSearch().trim().length() > 0) {
				cotrast.setContrast_fingerprint_locale_fingerprint_number(cotrast.getContrast_fingerprint_locale_fingerprint_number().replaceAll(contrastFingerPrintVO.getSearch(),
						"<span style='color: #ff5063;'>" + contrastFingerPrintVO.getSearch() + "</span>"));
				cotrast.setContrast_fingerprint_press_fingerprint_number(cotrast.getContrast_fingerprint_press_fingerprint_number().replaceAll(contrastFingerPrintVO.getSearch(),
						"<span style='color: #ff5063;'>" + contrastFingerPrintVO.getSearch() + "</span>"));
			}
		}
		vo.setList_xsjsglxt_contrast_fingerprint(list);
		return vo;
	}

	@Override
	public XSSFWorkbook getExcel(String query_name, String tableName, String query_id) {
		// TODO Auto-generated method stub
		int index = 0;
		String[] exportid_arr = query_id.split(",");
		for (String str : exportid_arr) {
			exportid_arr[index] = "'" + str + "'";
			index++;
		}
		List<Object> list_all = contrastFingerPrintDao.export_getAInfomationByTableId(tableName, getTableInfoIdName(tableName),
				Arrays.toString(exportid_arr).replaceAll("[\\[\\]]", ""));
		/**
		 * 1.query_num：传入所需要查询的字段
		 * 2.ExcelHead.getExcelHeadArray(tableName)：依据tablename传入表格头信息
		 * 3.MapUtil.java2Map(list_all):将list_all中的对象全部用MapUtil封装到List<Map<String,String>>中
		 * 返回一个execl表
		 */
		XSSFWorkbook workbook = ExportExcelCollection.exportExcel(query_name, ExcelHead.getExcelHeadArray(tableName),
				MapUtil.java2Map(list_all, query_name));
		return workbook;
	}

	private String getTableInfoIdName(String tableName) {
		Class cla = null;
		if (("xsjsglxt_contrast_fingerprint").equals(tableName)) {
			cla = xsjsglxt_contrast_fingerprint.class;
		}
		if (("xsjsglxt_dna").equals(tableName)) {
			cla = xsjsglxt_dna.class;
		}
		if (("xsjsglxt_equipment").equals(tableName)) {
			cla = xsjsglxt_equipment.class;
		}
		if (("xsjsglxt_fingerprint").equals(tableName)) {
			cla = xsjsglxt_fingerprint.class;
		}
		
		return cla.getDeclaredFields()[0].getName();
	}

	@Override
	public boolean addinfo(List<Object> list) {
		// TODO Auto-generated method stub
	boolean	flag=false;
		for(Object obj : list){
			flag=contrastFingerPrintDao.addinfo(obj);
		}
		return flag;
	}


}
