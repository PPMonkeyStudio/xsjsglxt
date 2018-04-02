package com.xsjsglxt.dao.impl.Team;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xsjsglxt.dao.Team.StaffMoveDao;
import com.xsjsglxt.domain.DO.xsjsglxt_staffMove;

public class StaffMoveDaoImpl implements StaffMoveDao {
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {

		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public String saveMove(List<xsjsglxt_staffMove> moves) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		for (xsjsglxt_staffMove xsjsglxt_staffMove : moves) {
			session.save(xsjsglxt_staffMove);
		}
		return "saveSuccess";
	}

	@Override
	public String deleteMove(xsjsglxt_staffMove move) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		session.delete(move);
		return "deleteSuccess";
	}

	@Override
	public String deleteMoves(String staffMove_staff) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		String hql = "delete from xsjsglxt_staffMove where staffMove_staff='" + staffMove_staff + "'";
		session.createQuery(hql).executeUpdate();
		return "deleteSuccess";
	}

	@Override
	public xsjsglxt_staffMove getMoveByMoveId(String xsjsglxt_staffMove_id) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		xsjsglxt_staffMove move = (xsjsglxt_staffMove) session.get(xsjsglxt_staffMove.class, xsjsglxt_staffMove_id);
		return move;
	}

	@Override
	public List<xsjsglxt_staffMove> getMoveByStaffId(String staffMove_staff) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		String hql = "from xsjsglxt_staffMove where staffMove_staff='" + staffMove_staff + "'";
		return session.createQuery(hql).list();
	}

}
