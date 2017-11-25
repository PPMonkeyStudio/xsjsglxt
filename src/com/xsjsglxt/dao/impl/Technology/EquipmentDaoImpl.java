package com.xsjsglxt.dao.impl.Technology;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xsjsglxt.dao.Technology.EquipmentDao;
import com.xsjsglxt.domain.DO.xsjsglxt_equipment;
import com.xsjsglxt.domain.VO.Technology.EquipmentVO;

public class EquipmentDaoImpl implements EquipmentDao {
	
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public int saveEquipment(xsjsglxt_equipment equipment) {
		Session session = getSession();
		try {
			session.saveOrUpdate(equipment);
			return 1;
		} catch (Exception e) {
			return 2;
		}
	}

	@Override
	public int count_equipment_all() {
		Session session = getSession();
		String hql = "select count(*) from xsjsglxt_equipment";
		Query query = session.createQuery(hql);
		Long i = (Long)query.uniqueResult();
		int count = i.intValue();
		session.clear();
		return count;
	}

	@Override
	public int deleteEquipment(String xsjsglxt_equipment_id) {
		Session session = getSession();
		String hql = "delete from xsjsglxt_equipment where xsjsglxt_equipment_id='" + xsjsglxt_equipment_id + "'";
		Query query = session.createQuery(hql);
		int result = query.executeUpdate();
		return result;
	}

	@Override
	public int modifiedEquipment(xsjsglxt_equipment equipment) {
		Session session = getSession();
		String hql = "update xsjsglxt_equipment set equipment_name='"+equipment.getEquipment_name()
						+"', equipment_type='"+equipment.getEquipment_type()
						+"' ,equipment_feature='" +equipment.getEquipment_feature()
						+"', equipment_number='"+equipment.getEquipment_number()
						+"',equipment_money='"+equipment.getEquipment_money()
						+"', equipment_enablement_time='"+equipment.getEquipment_enablement_time()
						+"',equipment_use_note='"+equipment.getEquipment_use_note()
						+"' ,equipment_remark='"+equipment.getEquipment_remark()
						+ "' where xsjsglxt_equipment_id='" + equipment.getXsjsglxt_equipment_id() + "'";
		Query query = session.createQuery(hql);
		int result = query.executeUpdate();
		return result;
	}

	@Override
	public xsjsglxt_equipment get_equipment(String xsjsglxt_equipment_id) {
		Session session = getSession();
		String hql = "from xsjsglxt_equipment where xsjsglxt_equipment_id='" + xsjsglxt_equipment_id + "'";
		Query query = session.createQuery(hql);
		xsjsglxt_equipment equipment  = (xsjsglxt_equipment) query.uniqueResult();
		return equipment ;
	}

	@Override
	public List<xsjsglxt_equipment> list_xsjsglxt_equipment(EquipmentVO equipmentVO) {
		Session session = getSession();
		String hql = "from xsjsglxt_equipment where 1=1";
		if (equipmentVO.getSearch() != null && equipmentVO.getSearch().trim().length() > 0) {
			String search = "%" + equipmentVO.getSearch().trim() + "%";
			hql = hql + " and equipment_name like '" + search + "'";
		}
		hql = hql + " order by equipment_enablement_time";
		Query query = session.createQuery(hql);
		query.setFirstResult((equipmentVO.getPageIndex() - 1) * equipmentVO.getPageSize());
		query.setMaxResults(equipmentVO.getPageSize());
		return query.list();
	}

}
