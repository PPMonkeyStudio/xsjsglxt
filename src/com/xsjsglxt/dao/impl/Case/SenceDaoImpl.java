package com.xsjsglxt.dao.impl.Case;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xsjsglxt.dao.Case.SenceDao;
import com.xsjsglxt.domain.DO.xsjsglxt_briefdetails;
import com.xsjsglxt.domain.DO.xsjsglxt_case;
import com.xsjsglxt.domain.DO.xsjsglxt_lost;
import com.xsjsglxt.domain.DO.xsjsglxt_lost_computer;
import com.xsjsglxt.domain.DO.xsjsglxt_lost_mobilephone;
import com.xsjsglxt.domain.DO.xsjsglxt_snece;

public class SenceDaoImpl implements SenceDao {
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
	public void save(xsjsglxt_snece sence) {
		// TODO Auto-generated method stub
		try {
			getSession().save(sence);
			
		} catch (Error e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void save(xsjsglxt_case case1) {
		// TODO Auto-generated method stub
		try {
			getSession().save(case1);
			
		} catch (Error e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void save(xsjsglxt_briefdetails briefdetails) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				try {
					getSession().save(briefdetails);
					
				} catch (Error e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}

	@Override
	public void save(xsjsglxt_lost lost) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				try {
					getSession().save(lost);
					
				} catch (Error e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}

	@Override
	public void save(xsjsglxt_lost_mobilephone lost_mobilephone) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				try {
					getSession().save(lost_mobilephone);
					
				} catch (Error e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}

	@Override
	public void save(xsjsglxt_lost_computer lost_computer) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				try {
					getSession().save(lost_computer);
					
				} catch (Error e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
/*
 * (non-Javadoc)获得勘探编号
 * @see com.xsjsglxt.dao.Case.SenceDao#getSenceInformationInquestId()
 */
	@Override
	public String getSenceInformationInquestId() {
		// TODO Auto-generated method stub
		Session session = getSession();
		String hql = "SELECT COUNT(*) FROM xsjsglxt_snece WHERE DATE_FORMAT( snece_gmt_create, '%Y%m' ) = DATE_FORMAT( CURDATE( ) , '%Y%m' )";
		org.hibernate.Query query = session.createQuery(hql);
		int count = ((Number) query.uniqueResult()).intValue();
		Date date = new Date();
		DateFormat format = new SimpleDateFormat("yyyyMM");
		String time = format.format(date);
		String SenceInformationInquestId = null;
		if (count < 9) {
			SenceInformationInquestId = "K360302001" + time + "000" + (count + 1);
		} else if (9 <= count && count < 99) {
			SenceInformationInquestId = "K360302001" + time + "00" + (count + 1);
		} else if (99 <= count && count < 999) {
			SenceInformationInquestId = "K360302001" + time + "0" + (count + 1);
		} else if (999 <= count && count < 9999) {
			SenceInformationInquestId = "K360302001" + time + (count + 1);
		}
		session.clear();
		return SenceInformationInquestId;
		
	}
}
