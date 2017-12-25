package com.xsjsglxt.service.impl.Technology;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.xsjsglxt.dao.Technology.DNADao;
import com.xsjsglxt.domain.DO.xsjsglxt_dna;
import com.xsjsglxt.domain.VO.Technology.DNAVO;
import com.xsjsglxt.service.Technology.DNAService;

import util.TeamUtil;

public class DNAServiceImpl implements DNAService {

	private DNADao dNADao;

	// 自动创建DNA编号
	public String create_dna_num() {
		StringBuffer num = new StringBuffer("D360302001");
		String time = new SimpleDateFormat("yyyyMM").format(new Date());
		int lastFour = dNADao.getFeild();
		String four = "";
		four = four.format("%04d", lastFour+1);
		num.append(time);
		num.append(four);
		return num.toString();	
	}
	
	// 分页
	public DNAVO list_xsjsglxt_dna(DNAVO dNAVO) {
		int totalRecords = dNADao.count_DNA_all(dNAVO);
		DNAVO vo = new DNAVO();
		vo.setPageIndex(dNAVO.getPageIndex());
		vo.setPageSize(dNAVO.getPageSize());
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
		List<xsjsglxt_dna> list = dNADao.list_xsjsglxt_dna(dNAVO);
		for (xsjsglxt_dna dna : list) {
			if (dNAVO.getSearch() != null && dNAVO.getSearch().trim().length() > 0) {
				dna.setDna_num(dna.getDna_num().replaceAll(dNAVO.getSearch(),
						"<span style='color: #ff5063;'>" + dNAVO.getSearch() + "</span>"));
				dna.setDna_name(dna.getDna_name().replaceAll(dNAVO.getSearch(),
						"<span style='color: #ff5063;'>" + dNAVO.getSearch() + "</span>"));
			}
		}
		vo.setList_xsjsglxt_dna(list);
		return vo;
	}

	public DNADao getdNADao() {
		return dNADao;
	}

	public void setdNADao(DNADao dNADao) {
		this.dNADao = dNADao;
	}

	@Override
	public int saveDNA(xsjsglxt_dna dNA) {
		dNA.setXsjsglxt_dna_id(TeamUtil.getUuid());
		dNA.setDna_num(this.create_dna_num());
		dNA.setDna_gmt_create(TeamUtil.getStringSecond());
//		dNA.setDna_gmt_modified(TeamUtil.getStringSecond());
		int result = dNADao.saveDNA(dNA);
		if (result > 0) {
			return 1;
		}
		return 2;
	}

	@Override
	public int deleteListDNA(List<String> listDeleteDNAID) {
		int result = 0;
		for (String dna_id : listDeleteDNAID) {
			result += dNADao.deleteDNA(dna_id);
		}
		if (result == listDeleteDNAID.size()) {
			return 1;
		}
		return 2;
	}


	@Override
	public int deleteDNA(String xsjsglxt_dna_id) {
		int result = dNADao.deleteDNA(xsjsglxt_dna_id);
		if (result > 0) {
			return 1;
		}
		return 2;
	}

	@Override
	public xsjsglxt_dna get_dna(String xsjsglxt_dna_id) {
		xsjsglxt_dna dna = dNADao.get_dna(xsjsglxt_dna_id);
		return dna;
	}

	@Override
	public int modifiedDNA(xsjsglxt_dna dNA) {
		dNA.setDna_gmt_modified(TeamUtil.getStringSecond());
		int result = dNADao.modifiedDNA(dNA);
		if (result > 0) {
			return 1;
		}
		return 2;
	}

}
