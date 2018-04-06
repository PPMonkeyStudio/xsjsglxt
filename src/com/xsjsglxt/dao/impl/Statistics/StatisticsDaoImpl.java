package com.xsjsglxt.dao.impl.Statistics;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xsjsglxt.dao.Statistics.StatisticsDao;
import com.xsjsglxt.domain.DO.xsjsglxt_staff;
import com.xsjsglxt.domain.DTO.Statistics.CaseTimeDTO;
import com.xsjsglxt.domain.DTO.Statistics.ComparisonTimeDTO;
import com.xsjsglxt.domain.DTO.Statistics.policemanOutTimesDTO;
import com.xsjsglxt.domain.VO.Statistics.CaseTimeVO;
import com.xsjsglxt.domain.VO.Statistics.ComparisonTimeVO;
import com.xsjsglxt.domain.VO.Statistics.OutTimeVO;

public class StatisticsDaoImpl implements StatisticsDao {
	private SessionFactory sessionFactory;
	private final static String[] FIRST_CATEGORY = { "入室盗窃案", "盗窃汽车案", "盗窃车内物品案", "电缆盗窃案", "单位盗窃案", "其它盗窃案", "入户抢劫案",
			"拦路抢劫案", "麻醉抢劫案", "其它抢劫案", "尾随抢夺案", "飞车抢夺案", "其它抢夺案", "强奸案", "绑架案", "杀人案", "故意伤害案", "爆炸案", "放火案", "非法拘禁案",
			"非正常死亡", "故意损坏公私财物", "其他" };
	private final static String[] THEFT_CASE = { "入室盗窃案", "盗窃汽车案", "盗窃车内物品案", "电缆盗窃案", "单位盗窃案", "其它盗窃案" };
	private final static String[] LOOT_CASE = { "尾随抢夺案", "飞车抢夺案s", "其它抢夺案" };
	private final static String[] ROB_CASE = { "入户抢劫案", "拦路抢劫案", "麻醉抢劫案", "其它抢劫案" };
	private final static String[] POLICE_STATION = { "东大派出所", "高坑派出所", "青山派出所", "安源派出所", "八一派出所", "白源派出所", "城郊派出所",
			"丹江派出所", "凤凰派出所", "后埠派出所", "李子园派出所", "五陂下派出所", "其他", };

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Override
	public List<xsjsglxt_staff> getPolicemanByName(String policemanName) {
		// TODO Auto-generated method stub
		String hql = "from xsjsglxt_staff where 1=1";
		System.out.println(hql);
		if (policemanName != null && !"".equals(policemanName)) {
			hql = hql + " and xsjsglxt_name like '%" + policemanName + "%'";
		}
		Session session = this.getSession();
		List<xsjsglxt_staff> policemans = session.createQuery(hql).list();
		return policemans;
	}

	@Override
	public List<policemanOutTimesDTO> getTimes(List<xsjsglxt_staff> policeman, OutTimeVO outTimeVO) {
		// TODO Auto-generated method stub
		List<policemanOutTimesDTO> policemanDTO = new ArrayList<policemanOutTimesDTO>();
		Session session = this.getSession();
		String hql = null;
		String queryCondition = "";
		if (outTimeVO.getTimeStart() != null && !"".equals(outTimeVO.getTimeStart())) {
			queryCondition = queryCondition + " and c.case_receivingAlarmDate>='" + outTimeVO.getTimeStart() + "'";
		}
		if (outTimeVO.getTimeEnd() != null && !"".equals(outTimeVO.getTimeEnd())) {
			queryCondition = queryCondition + " and c.case_receivingAlarmDate<='" + outTimeVO.getTimeEnd() + "'";
		}
		for (xsjsglxt_staff xsjsglxt_staff : policeman) {
			hql = "select count(*) from xsjsglxt_snece as s , xsjsglxt_case as c where s.snece_case=c.xsjsglxt_case_id and s.snece_inquestPerson like '%"
					+ xsjsglxt_staff.getXsjsglxt_name() + "%'";
			hql = hql + queryCondition;
			System.out.println(hql);
			long count = (long) session.createQuery(hql).uniqueResult();
			policemanOutTimesDTO p = new policemanOutTimesDTO();
			p.setOutTimes(new Long(count).intValue());
			p.setPolicemanName(xsjsglxt_staff.getXsjsglxt_name());
			policemanDTO.add(p);
		}
		return policemanDTO;
	}

	@Override
	public List<ComparisonTimeDTO> getComparisonTime(List<xsjsglxt_staff> policeman,
			ComparisonTimeVO comparisonTimeVO) {
		// TODO Auto-generated method stub
		List<ComparisonTimeDTO> comparistionTimeDTOList = new ArrayList<ComparisonTimeDTO>();
		String hql = null;
		String queryCondition = "";
		if (comparisonTimeVO.getComparisonTimeStart() != null
				&& comparisonTimeVO.getComparisonTimeStart().trim().length() > 0) {
			queryCondition = queryCondition + " and breakcase_arrested_time >= '"
					+ comparisonTimeVO.getComparisonTimeStart() + "'";
		}
		if (comparisonTimeVO.getComparisonTimeEnd() != null
				&& comparisonTimeVO.getComparisonTimeEnd().trim().length() > 0) {
			queryCondition = queryCondition + " and breakcase_arrested_time<='"
					+ comparisonTimeVO.getComparisonTimeEnd() + "'";
		}
		ComparisonTimeDTO c = null;
		Session session = this.getSession();
		for (xsjsglxt_staff staff : policeman) {
			hql = "select count(*) from xsjsglxt_breakcase where breakcase_contrast_contraster = '"
					+ staff.getXsjsglxt_name() + "'";
			hql = hql + queryCondition;
			long count = (long) session.createQuery(hql).uniqueResult();
			c = new ComparisonTimeDTO();
			c.setComparisonTime((int) count);
			c.setPolicemanname(staff.getXsjsglxt_name());
			comparistionTimeDTOList.add(c);
		}
		return comparistionTimeDTOList;
	}

	@Override
	public List<CaseTimeDTO> getCaseTime(CaseTimeVO caseTimeVO) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		List<CaseTimeDTO> caseTimeDTOList = new ArrayList<CaseTimeDTO>();
		if (caseTimeVO.getSecondCategory() != null && caseTimeVO.getSecondCategory().trim().length() > 0) {
			String hql = "select case_jurisdiction,count(*) as time from xsjsglxt_case where case_sonCategory ='"
					+ caseTimeVO.getSecondCategory() + "'";
			if (caseTimeVO.getCaseTimeStart() != null && caseTimeVO.getCaseTimeStart().trim().length() > 0) {
				hql = hql + " and case_receivingAlarmDate >= '" + caseTimeVO.getCaseTimeStart() + "'";
			}
			if (caseTimeVO.getCaseTimeEnd() != null && caseTimeVO.getCaseTimeEnd().trim().length() > 0) {
				hql = hql + " and case_receivingAlarmDate <= '" + caseTimeVO.getCaseTimeEnd() + "'";
			}
			hql = hql + " group by case_jurisdiction";
			List<Object[]> list = session.createSQLQuery(hql).list();
			CaseTimeDTO caseTimeDTO = new CaseTimeDTO();
			caseTimeDTO.setCaseCategory(caseTimeVO.getSecondCategory());
			for (Object[] objects : list) {
				this.setData((String) objects[0], ((BigInteger) objects[1]).intValue(), caseTimeDTO);
			}
			caseTimeDTOList.add(caseTimeDTO);
		} else {
			if (caseTimeVO.getFirstCategory() != null) {
				switch (caseTimeVO.getFirstCategory()) {
				case "所有案件": // 执行所有条件
					for (int i = 0; i < FIRST_CATEGORY.length; i++) {
						CaseTimeDTO caseTimeDTO = new CaseTimeDTO();
						if (i < 13) {
							String hql = "select case_jurisdiction,count(*) as time from xsjsglxt_case where case_sonCategory ='"
									+ FIRST_CATEGORY[i] + "'";
							if (caseTimeVO.getCaseTimeStart() != null
									&& caseTimeVO.getCaseTimeStart().trim().length() > 0) {
								hql = hql + " and case_receivingAlarmDate >= '" + caseTimeVO.getCaseTimeStart() + "'";
							}
							if (caseTimeVO.getCaseTimeEnd() != null
									&& caseTimeVO.getCaseTimeEnd().trim().length() > 0) {
								hql = hql + " and case_receivingAlarmDate <= '" + caseTimeVO.getCaseTimeEnd() + "'";
							}
							hql = hql + " group by case_jurisdiction";
							List<Object[]> list = session.createSQLQuery(hql).list();
							caseTimeDTO.setCaseCategory(FIRST_CATEGORY[i]);
							for (Object[] objects : list) {
								this.setData((String) objects[0], ((BigInteger) objects[1]).intValue(), caseTimeDTO);
							}
							caseTimeDTOList.add(caseTimeDTO);
						} else {
							String hql = "select case_jurisdiction,count(*) as time from xsjsglxt_case where case_totalCategory ='"
									+ FIRST_CATEGORY[i] + "'";
							if (caseTimeVO.getCaseTimeStart() != null
									&& caseTimeVO.getCaseTimeStart().trim().length() > 0) {
								hql = hql + " and case_receivingAlarmDate >= '" + caseTimeVO.getCaseTimeStart() + "'";
							}
							if (caseTimeVO.getCaseTimeEnd() != null
									&& caseTimeVO.getCaseTimeEnd().trim().length() > 0) {
								hql = hql + " and case_receivingAlarmDate <= '" + caseTimeVO.getCaseTimeEnd() + "'";
							}
							hql = hql + " group by case_jurisdiction";
							List<Object[]> list = session.createSQLQuery(hql).list();
							caseTimeDTO.setCaseCategory(FIRST_CATEGORY[i]);
							for (Object[] objects : list) {
								this.setData((String) objects[0], ((BigInteger) objects[1]).intValue(), caseTimeDTO);
							}
							caseTimeDTOList.add(caseTimeDTO);
						}
					}
					break;
				case "盗窃案": // 执行多次
					for (int i = 0; i < THEFT_CASE.length; i++) {
						CaseTimeDTO caseTimeDTO = new CaseTimeDTO();
						String hql = "select case_jurisdiction,count(*) as time from xsjsglxt_case where case_sonCategory ='"
								+ THEFT_CASE[i] + "'";
						if (caseTimeVO.getCaseTimeStart() != null
								&& caseTimeVO.getCaseTimeStart().trim().length() > 0) {
							hql = hql + " and case_receivingAlarmDate >= '" + caseTimeVO.getCaseTimeStart() + "'";
						}
						if (caseTimeVO.getCaseTimeEnd() != null && caseTimeVO.getCaseTimeEnd().trim().length() > 0) {
							hql = hql + " and case_receivingAlarmDate <= '" + caseTimeVO.getCaseTimeEnd() + "'";
						}
						hql = hql + " group by case_jurisdiction";
						List<Object[]> list = session.createSQLQuery(hql).list();
						caseTimeDTO.setCaseCategory(THEFT_CASE[i]);
						for (Object[] objects : list) {
							this.setData((String) objects[0], ((BigInteger) objects[1]).intValue(), caseTimeDTO);
						}
						caseTimeDTOList.add(caseTimeDTO);
					}
					break;
				case "抢劫案":
					for (int i = 0; i < ROB_CASE.length; i++) {
						CaseTimeDTO caseTimeDTO = new CaseTimeDTO();
						String hql = "select case_jurisdiction,count(*) as time from xsjsglxt_case where case_sonCategory ='"
								+ ROB_CASE[i] + "'";
						if (caseTimeVO.getCaseTimeStart() != null
								&& caseTimeVO.getCaseTimeStart().trim().length() > 0) {
							hql = hql + " and case_receivingAlarmDate >= '" + caseTimeVO.getCaseTimeStart() + "'";
						}
						if (caseTimeVO.getCaseTimeEnd() != null && caseTimeVO.getCaseTimeEnd().trim().length() > 0) {
							hql = hql + " and case_receivingAlarmDate <= '" + caseTimeVO.getCaseTimeEnd() + "'";
						}
						hql = hql + " group by case_jurisdiction";
						List<Object[]> list = session.createSQLQuery(hql).list();
						caseTimeDTO.setCaseCategory(ROB_CASE[i]);
						for (Object[] objects : list) {
							this.setData((String) objects[0], ((BigInteger) objects[1]).intValue(), caseTimeDTO);
						}
						caseTimeDTOList.add(caseTimeDTO);
					}
					break;

				case "抢夺案":
					for (int i = 0; i < LOOT_CASE.length; i++) {
						CaseTimeDTO caseTimeDTO = new CaseTimeDTO();
						String hql = "select case_jurisdiction,count(*) as time from xsjsglxt_case where case_sonCategory ='"
								+ LOOT_CASE[i] + "'";
						if (caseTimeVO.getCaseTimeStart() != null
								&& caseTimeVO.getCaseTimeStart().trim().length() > 0) {
							hql = hql + " and case_receivingAlarmDate >= '" + caseTimeVO.getCaseTimeStart() + "'";
						}
						if (caseTimeVO.getCaseTimeEnd() != null && caseTimeVO.getCaseTimeEnd().trim().length() > 0) {
							hql = hql + " and case_receivingAlarmDate <= '" + caseTimeVO.getCaseTimeEnd() + "'";
						}
						hql = hql + " group by case_jurisdiction";
						List<Object[]> list = session.createSQLQuery(hql).list();
						caseTimeDTO.setCaseCategory(LOOT_CASE[i]);
						for (Object[] objects : list) {
							this.setData((String) objects[0], ((BigInteger) objects[1]).intValue(), caseTimeDTO);
						}
						caseTimeDTOList.add(caseTimeDTO);
					}
					break;
				default:
					CaseTimeDTO caseTimeDTO = new CaseTimeDTO();
					String hql = "select case_jurisdiction,count(*) as time from xsjsglxt_case where case_totalCategory ='"
							+ caseTimeVO.getFirstCategory() + "'";
					if (caseTimeVO.getCaseTimeStart() != null && caseTimeVO.getCaseTimeStart().trim().length() > 0) {
						hql = hql + " and case_receivingAlarmDate >= '" + caseTimeVO.getCaseTimeStart() + "'";
					}
					if (caseTimeVO.getCaseTimeEnd() != null && caseTimeVO.getCaseTimeEnd().trim().length() > 0) {
						hql = hql + " and case_receivingAlarmDate <= '" + caseTimeVO.getCaseTimeEnd() + "'";
					}
					hql = hql + " group by case_jurisdiction";
					List<Object[]> list = session.createSQLQuery(hql).list();
					caseTimeDTO.setCaseCategory(caseTimeVO.getFirstCategory());
					for (Object[] objects : list) {
						this.setData((String) objects[0], ((BigInteger) objects[1]).intValue(), caseTimeDTO);
					}
					caseTimeDTOList.add(caseTimeDTO);
					break;
				}
			}
		}

		return caseTimeDTOList;

	}

	public void setData(String policeStation, int Time, CaseTimeDTO caseTimeDTO) {

		if (policeStation.equals(POLICE_STATION[0])) {
			caseTimeDTO.setDongDaTime(Time);
		} else if (policeStation.equals(POLICE_STATION[1])) {
			caseTimeDTO.setGaoKangTime(Time);
		} else if (policeStation.equals(POLICE_STATION[2]))
			caseTimeDTO.setQingshanTime(Time);
		else if (policeStation.equals(POLICE_STATION[3]))
			caseTimeDTO.setAnyuanTime(Time);
		else if (policeStation.equals(POLICE_STATION[4]))
			caseTimeDTO.setBayiTime(Time);
		else if (policeStation.equals(POLICE_STATION[5]))
			caseTimeDTO.setBaiyuanTime(Time);
		else if (policeStation.equals(POLICE_STATION[6]))
			caseTimeDTO.setChengjiaoTime(Time);
		else if (policeStation.equals(POLICE_STATION[7]))
			caseTimeDTO.setDanjiangTime(Time);
		else if (policeStation.equals(POLICE_STATION[8]))
			caseTimeDTO.setFenghuangTime(Time);
		else if (policeStation.equals(POLICE_STATION[9]))
			caseTimeDTO.setHoufuTime(Time);
		else if (policeStation.equals(POLICE_STATION[10]))
			caseTimeDTO.setLiziyuanTime(Time);
		else if (policeStation.equals(POLICE_STATION[11]))
			caseTimeDTO.setWupoxiaTime(Time);
		else if (policeStation.equals(POLICE_STATION[12]))
			caseTimeDTO.setQitaTime(Time);
	}
}
