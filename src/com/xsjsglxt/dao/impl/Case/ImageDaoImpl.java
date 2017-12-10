package com.xsjsglxt.dao.impl.Case;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xsjsglxt.dao.Case.ImageDao;
import com.xsjsglxt.domain.DO.xsjsglxt_case;
import com.xsjsglxt.domain.DO.xsjsglxt_image;
import com.xsjsglxt.domain.DO.xsjsglxt_picture;
import com.xsjsglxt.domain.DO.xsjsglxt_resevidence;
import com.xsjsglxt.domain.VO.Case.page_list_imageInformationVO;

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

	@Override
	public int getCountImageInformationByPage(page_list_imageInformationVO page_list_imageInformation) {
		// TODO Auto-generated method stub
		Session session = getSession();
		Long i;
		String startTime = "0000-00-00";
		String stopTime = "9999-99-99";
		String hql = "SELECT	count(*)FROM	xsjsglxt_image image,	xsjsglxt_picture picture,	xsjsglxt_case case1 WHERE	1 = 1 AND image.xsjsglxt_image_id = picture.picture_image AND picture.picture_case = case1.xsjsglxt_case_id ";
		//1
		if (page_list_imageInformation.getImage_number() != null
				&& page_list_imageInformation.getImage_number().trim().length() > 0) {
			String image_number = "%" + page_list_imageInformation.getImage_number() + "%";
			hql = hql + " and image_number like '" + image_number + "'";
				
		}
		//2
		if (page_list_imageInformation.getPicture_identifier() != null
				&& page_list_imageInformation.getPicture_identifier().trim().length() > 0) {
			String picture_identifier = "%" + page_list_imageInformation.getImage_number() + "%";
			hql = hql + " and picture_identifier like '" + picture_identifier + "'";
				
		}
		if (page_list_imageInformation.getStart_time() != null && page_list_imageInformation.getStart_time().trim().length() > 0) {
			startTime = page_list_imageInformation.getStart_time();
		}
		if (page_list_imageInformation.getStop_time() != null && page_list_imageInformation.getStop_time().trim().length() > 0) {
			stopTime = page_list_imageInformation.getStop_time();
		}
		hql = hql + " and case_receivingAlarmDate>='" + startTime + "' and case_receivingAlarmDate<='"
				+ stopTime + "' order by case_receivingAlarmDate";
		Query query = session.createQuery(hql);	
		i = (Long) query.uniqueResult();
		session.clear();
		return i.intValue();
	}

	@Override
	public List<xsjsglxt_picture> getListImageInformatioByPage(
			page_list_imageInformationVO page_list_imageInformation) {
		// TODO Auto-generated method stub
		Session session = getSession();
		String startTime = "0000-00-00";
		String stopTime = "9999-99-99";
		List<xsjsglxt_picture> listImageInformationByPage = new ArrayList<xsjsglxt_picture>();
		String hql = "SELECT picture FROM	xsjsglxt_image image,	xsjsglxt_picture picture,	xsjsglxt_case case1 WHERE	1 = 1 AND image.xsjsglxt_image_id = picture.picture_image AND picture.picture_case = case1.xsjsglxt_case_id  ";
		//1
				if (page_list_imageInformation.getImage_number() != null
						&& page_list_imageInformation.getImage_number().trim().length() > 0) {
					String image_number = "%" + page_list_imageInformation.getImage_number() + "%";
					hql = hql + " and image_number like '" + image_number + "'";
						
				}
				//2
				if (page_list_imageInformation.getPicture_identifier() != null
						&& page_list_imageInformation.getPicture_identifier().trim().length() > 0) {
					String picture_identifier = "%" + page_list_imageInformation.getImage_number() + "%";
					hql = hql + " and picture_identifier like '" + picture_identifier + "'";
						
				}
				if (page_list_imageInformation.getStart_time() != null && page_list_imageInformation.getStart_time().trim().length() > 0) {
					startTime = page_list_imageInformation.getStart_time();
				}
				if (page_list_imageInformation.getStop_time() != null && page_list_imageInformation.getStop_time().trim().length() > 0) {
					stopTime = page_list_imageInformation.getStop_time();
				}
				hql = hql + " and case_receivingAlarmDate>='" + startTime + "' and case_receivingAlarmDate<='"
						+ stopTime + "' order by case_receivingAlarmDate";
		Query query = session.createQuery(hql);	
		query.setFirstResult(
				(page_list_imageInformation.getPageIndex() - 1) * page_list_imageInformation.getPageSize());
		query.setMaxResults(page_list_imageInformation.getPageSize());
		listImageInformationByPage = query.list();
		System.out.println(hql);
		session.clear();
		return listImageInformationByPage;
	}

	@Override
	public xsjsglxt_image get_image_Byxsjsglxt_picture_id(xsjsglxt_picture picture) {
		// TODO Auto-generated method stub
		Session session = getSession();
		String hql = "from xsjsglxt_image image where image.xsjsglxt_image_id='" + picture.getPicture_image() + "'";

		Query query = session.createQuery(hql);

		xsjsglxt_image image = (xsjsglxt_image) query.uniqueResult();

		return image;
	}

	@Override
	public xsjsglxt_case get_case1_Byxsjsglxt_picture_id(xsjsglxt_picture picture) {
		// TODO Auto-generated method stub
		Session session = getSession();
		String hql = "from xsjsglxt_case case1 where case1.xsjsglxt_case_id='" + picture.getPicture_case() + "'";

		Query query = session.createQuery(hql);

		xsjsglxt_case case1 = (xsjsglxt_case) query.uniqueResult();

		return case1;
	}

	@Override
	public xsjsglxt_picture getpictureById(xsjsglxt_picture picture) {
		// TODO Auto-generated method stub
		Session session = getSession();

		String hql = "from xsjsglxt_picture picture where picture.xsjsglxt_picture_id='" + picture.getXsjsglxt_picture_id() + "'";

		Query query = session.createQuery(hql);

		picture = (xsjsglxt_picture) query.uniqueResult();

		return picture;
	}

	@Override
	public xsjsglxt_image getImageBypictureId(xsjsglxt_picture picture) {
		// TODO Auto-generated method stub
		Session session = getSession();

		String hql = "from xsjsglxt_image image where image.xsjsglxt_image_id='" + picture.getPicture_image() + "'";

		Query query = session.createQuery(hql);

		xsjsglxt_image	image = (xsjsglxt_image) query.uniqueResult();

		return image;
	}

	@Override
	public xsjsglxt_case getCaseBypictureId(xsjsglxt_picture picture) {
		// TODO Auto-generated method stub
		Session session = getSession();

		String hql = "from xsjsglxt_case case1 where case1.xsjsglxt_case_id='" + picture.getPicture_case() + "'";

		Query query = session.createQuery(hql);

		xsjsglxt_case	case1 = (xsjsglxt_case) query.uniqueResult();

		return case1;
	}
}
