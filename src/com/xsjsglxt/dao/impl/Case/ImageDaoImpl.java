package com.xsjsglxt.dao.impl.Case;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xsjsglxt.dao.Case.ImageDao;
import com.xsjsglxt.domain.DO.xsjsglxt_image;
import com.xsjsglxt.domain.DO.xsjsglxt_picture;

import util.TeamUtil;

public class ImageDaoImpl implements ImageDao {
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
	public void saveCD(xsjsglxt_image image) {
		// TODO Auto-generated method stub
		try {
			getSession().save(image);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void savePicture(xsjsglxt_picture picture) {
		// TODO Auto-generated method stub
		try {
			getSession().save(picture);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public int getMaxImage_number() {
		// TODO Auto-generated method stub
		int i;
		//201711
		String yearAndMonth =TeamUtil.yearAndMonth();
		String li="";
		
		String hql = "select right(image_number,4) from xsjsglxt_image ORDER BY right(image_number,4) desc limit 1";
		System.out.println(hql);
		Query query = getSession().createSQLQuery(hql);
		li=(String) query.uniqueResult();
		if(li==null || li.trim().length()<=0){
			getSession().clear();
			return 0;
		}
		i=Integer.parseInt(li);
		getSession().clear();
		return i;
		
		
	}

	@Override
	public int getMaxPicture_identifier() {
		// TODO Auto-generated method stub
		int i;
		//201711
		String yearAndMonth =TeamUtil.yearAndMonth();
		String li="";
	
		String hql = "select right(picture_identifier,4) from xsjsglxt_picture ORDER BY right(picture_identifier,4) desc limit 1";
		System.out.println(hql);
		Query query = getSession().createSQLQuery(hql);
		li=(String) query.uniqueResult();
		if(li==null || li.trim().length()<=0){
			getSession().clear();
			return 0;
		}
		i=Integer.parseInt(li);
		getSession().clear();
		return i;
	}
}
