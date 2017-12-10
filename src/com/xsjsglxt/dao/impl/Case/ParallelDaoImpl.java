<<<<<<< HEAD
package com.xsjsglxt.dao.impl.Case;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xsjsglxt.dao.Case.ParallelDao;
import com.xsjsglxt.domain.DO.xsjsglxt_briefdetails;
import com.xsjsglxt.domain.DO.xsjsglxt_case;
import com.xsjsglxt.domain.DO.xsjsglxt_lost;
import com.xsjsglxt.domain.DO.xsjsglxt_parallel;
import com.xsjsglxt.domain.DO.xsjsglxt_resevidence;
import com.xsjsglxt.domain.DO.xsjsglxt_snece;
import com.xsjsglxt.domain.VO.Case.page_list_parallelInformationVO;

import util.TeamUtil;

public class ParallelDaoImpl implements ParallelDao {
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
	public void saveparallel(xsjsglxt_parallel parallel) {
		try {
			// TODO Auto-generated method stub
			getSession().save(parallel);
		} catch (Error e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public void save(xsjsglxt_case xsjsglxt_case) {
		// TODO Auto-generated method stub
		try {
			getSession().save(xsjsglxt_case);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public xsjsglxt_case getCaseByNum(String case_id) {
		// TODO Auto-generated method stub
		Session session = getSession();
		xsjsglxt_case CaseInformation = null;
		String hql = "from xsjsglxt_case case1 where case1.xsjsglxt_case_id='" + case_id + "'";
		Query query = session.createQuery(hql);
		CaseInformation = (xsjsglxt_case) query.uniqueResult();
       return CaseInformation;
	}

	@Override
	public int getCountParallelInformationByPage(page_list_parallelInformationVO page_list_parallelInformation) {
		// TODO Auto-generated method stub
		Session session = getSession();
		Long i;
		String hql = "select count(*) from xsjsglxt_parallel where 1=1";
		String startTime = "0000-00-00";
		String stopTime = "9999-99-99";
		  // 1
		if (page_list_parallelInformation.getParallel_casename() != null
				&& page_list_parallelInformation.getParallel_casename().trim().length() > 0) {
			String parallel_casename = "%" + page_list_parallelInformation.getParallel_casename() + "%";
			hql = hql + " and parallel_casename like '" + parallel_casename + "'";
				
		}
		// 2
		if (page_list_parallelInformation.getParallel_person() != null
				&& page_list_parallelInformation.getParallel_person().trim().length() > 0) {
			String parallel_person = "%" + page_list_parallelInformation.getParallel_person() + "%";
			hql = hql + " and parallel_person like '" + parallel_person + "'";
		}
		
		if (page_list_parallelInformation.getStart_time() != null && page_list_parallelInformation.getStart_time().trim().length() > 0) {
			startTime = page_list_parallelInformation.getStart_time();
		}
		if (page_list_parallelInformation.getStop_time() != null && page_list_parallelInformation.getStop_time().trim().length() > 0) {
			stopTime = page_list_parallelInformation.getStop_time();
		}
		hql = hql + " and parallel_date>='" + startTime + "' and parallel_date<='"
				+ stopTime + "' order by parallel_date";
		System.out.println(hql);
		Query query = session.createQuery(hql);	
		i = (Long) query.uniqueResult();
		session.clear();
		return i.intValue();
	}

	@Override
	public List<xsjsglxt_parallel> getListParallelInformatioByPage(
			page_list_parallelInformationVO page_list_parallelInformation) {
		// TODO Auto-generated method stub
		Session session = getSession();
		List<xsjsglxt_parallel> listParallelInformationByPage = new ArrayList<xsjsglxt_parallel>();
		String hql = "from xsjsglxt_parallel where 1=1";
		String startTime = "0000-00-00";
		String stopTime = "9999-99-99";
		  // 1
				if (page_list_parallelInformation.getParallel_casename() != null
						&& page_list_parallelInformation.getParallel_casename().trim().length() > 0) {
					String parallel_casename = "%" + page_list_parallelInformation.getParallel_casename() + "%";
					hql = hql + " and parallel_casename like '" + parallel_casename + "'";
						
				}
				// 2
				if (page_list_parallelInformation.getParallel_person() != null
						&& page_list_parallelInformation.getParallel_person().trim().length() > 0) {
					String parallel_person = "%" + page_list_parallelInformation.getParallel_person() + "%";
					hql = hql + " and parallel_person like '" + parallel_person + "'";
				}
				
				if (page_list_parallelInformation.getStart_time() != null && page_list_parallelInformation.getStart_time().trim().length() > 0) {
					startTime = page_list_parallelInformation.getStart_time();
				}
				if (page_list_parallelInformation.getStop_time() != null && page_list_parallelInformation.getStop_time().trim().length() > 0) {
					stopTime = page_list_parallelInformation.getStop_time();
				}
				hql = hql + " and parallel_date>='" + startTime + "' and parallel_date<='"
						+ stopTime + "' order by parallel_date";
		Query query = session.createQuery(hql);	
		query.setFirstResult(
				(page_list_parallelInformation.getPageIndex() - 1) * page_list_parallelInformation.getPageSize());
		query.setMaxResults(page_list_parallelInformation.getPageSize());
		listParallelInformationByPage = query.list();
		session.clear();
		return listParallelInformationByPage;
	}

	@Override
	public xsjsglxt_parallel getparallelById(xsjsglxt_parallel parallel) {
		// TODO Auto-generated method stub
		Session session = getSession();

		String hql = "from xsjsglxt_parallel parallel where parallel.xsjsglxt_parallel_id='" + parallel.getXsjsglxt_parallel_id() + "'";

		Query query = session.createQuery(hql);

		 parallel = (xsjsglxt_parallel) query.uniqueResult();

		return parallel;
	}

	@Override
	public xsjsglxt_case getcaseByparallelId(xsjsglxt_parallel parallel) {
		// TODO Auto-generated method stub
		Session session = getSession();

		String hql = "from xsjsglxt_case case1 where case1.case_parallel='" + parallel.getXsjsglxt_parallel_id() + "'";

		Query query = session.createQuery(hql);

		xsjsglxt_case	 case1 = (xsjsglxt_case) query.uniqueResult();

		return case1;
	}

	@Override
	public xsjsglxt_snece getsneceByCaseId(xsjsglxt_case case1) {
		// TODO Auto-generated method stub
		Session session = getSession();

		String hql = "from xsjsglxt_snece sence where sence.snece_case='" + case1.getXsjsglxt_case_id() + "'";

		Query query = session.createQuery(hql);

		xsjsglxt_snece	 sence = (xsjsglxt_snece) query.uniqueResult();

		return sence;
	}

	@Override
	public xsjsglxt_briefdetails getbriefdetailsByCaseId(xsjsglxt_case case1) {
		// TODO Auto-generated method stub
		Session session = getSession();

		String hql = "from xsjsglxt_briefdetails briefdetails where briefdetails.briefdetails_case='" + case1.getXsjsglxt_case_id() + "'";

		Query query = session.createQuery(hql);

		xsjsglxt_briefdetails	 briefdetails = (xsjsglxt_briefdetails) query.uniqueResult();

		return briefdetails;
	}

	@Override
	public xsjsglxt_resevidence getresevidenceByCaseId(xsjsglxt_case case1) {
		// TODO Auto-generated method stub
		Session session = getSession();

		String hql = "from xsjsglxt_resevidence resevidence where resevidence.resevidence_case='" + case1.getXsjsglxt_case_id() + "'";

		Query query = session.createQuery(hql);

		xsjsglxt_resevidence	 resevidence = (xsjsglxt_resevidence) query.uniqueResult();

		return resevidence;
	}

	@Override
	public int getMaxParallelNum() {
		// TODO Auto-generated method stub
		int i;
	
		String year =TeamUtil.getCurrentYear();
		String li="";
	
		String hql = "select substring(parallel_num,-1,4) from xsjsglxt_parallel where substring(parallel_num,1,8)='"+year+"' order by substring(parallel_num,-1,4) desc limit 1";
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
	public void updateParallel(xsjsglxt_parallel parallel) {
		// TODO Auto-generated method stub
		try {
			getSession().saveOrUpdate(parallel);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
=======
package com.xsjsglxt.dao.impl.Case;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xsjsglxt.dao.Case.ParallelDao;
import com.xsjsglxt.domain.DO.xsjsglxt_briefdetails;
import com.xsjsglxt.domain.DO.xsjsglxt_case;
import com.xsjsglxt.domain.DO.xsjsglxt_lost;
import com.xsjsglxt.domain.DO.xsjsglxt_parallel;
import com.xsjsglxt.domain.DO.xsjsglxt_resevidence;
import com.xsjsglxt.domain.DO.xsjsglxt_snece;
import com.xsjsglxt.domain.VO.Case.page_list_parallelInformationVO;

import util.TeamUtil;

public class ParallelDaoImpl implements ParallelDao {
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
	public void saveparallel(xsjsglxt_parallel parallel) {
		try {
			// TODO Auto-generated method stub
			getSession().save(parallel);
		} catch (Error e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public void save(xsjsglxt_case xsjsglxt_case) {
		// TODO Auto-generated method stub
		try {
			getSession().save(xsjsglxt_case);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public xsjsglxt_case getCaseByNum(String case_id) {
		// TODO Auto-generated method stub
		Session session = getSession();
		xsjsglxt_case CaseInformation = null;
		String hql = "from xsjsglxt_case case1 where case1.xsjsglxt_case_id='" + case_id + "'";
		Query query = session.createQuery(hql);
		CaseInformation = (xsjsglxt_case) query.uniqueResult();
       return CaseInformation;
	}

	@Override
	public int getCountParallelInformationByPage(page_list_parallelInformationVO page_list_parallelInformation) {
		// TODO Auto-generated method stub
		Session session = getSession();
		Long i;
		String hql = "select count(*) from xsjsglxt_parallel where 1=1";
		String startTime = "0000-00-00";
		String stopTime = "9999-99-99";
		  // 1
		if (page_list_parallelInformation.getParallel_casename() != null
				&& page_list_parallelInformation.getParallel_casename().trim().length() > 0) {
			String parallel_casename = "%" + page_list_parallelInformation.getParallel_casename() + "%";
			hql = hql + " and parallel_casename like '" + parallel_casename + "'";
				
		}
		// 2
		if (page_list_parallelInformation.getParallel_person() != null
				&& page_list_parallelInformation.getParallel_person().trim().length() > 0) {
			String parallel_person = "%" + page_list_parallelInformation.getParallel_person() + "%";
			hql = hql + " and parallel_person like '" + parallel_person + "'";
		}
		
		if (page_list_parallelInformation.getStart_time() != null && page_list_parallelInformation.getStart_time().trim().length() > 0) {
			startTime = page_list_parallelInformation.getStart_time();
		}
		if (page_list_parallelInformation.getStop_time() != null && page_list_parallelInformation.getStop_time().trim().length() > 0) {
			stopTime = page_list_parallelInformation.getStop_time();
		}
		hql = hql + " and parallel_date>='" + startTime + "' and parallel_date<='"
				+ stopTime + "' order by parallel_date";
		System.out.println(hql);
		Query query = session.createQuery(hql);	
		i = (Long) query.uniqueResult();
		session.clear();
		return i.intValue();
	}

	@Override
	public List<xsjsglxt_parallel> getListParallelInformatioByPage(
			page_list_parallelInformationVO page_list_parallelInformation) {
		// TODO Auto-generated method stub
		Session session = getSession();
		List<xsjsglxt_parallel> listParallelInformationByPage = new ArrayList<xsjsglxt_parallel>();
		String hql = "from xsjsglxt_parallel where 1=1";
		String startTime = "0000-00-00";
		String stopTime = "9999-99-99";
		  // 1
				if (page_list_parallelInformation.getParallel_casename() != null
						&& page_list_parallelInformation.getParallel_casename().trim().length() > 0) {
					String parallel_casename = "%" + page_list_parallelInformation.getParallel_casename() + "%";
					hql = hql + " and parallel_casename like '" + parallel_casename + "'";
						
				}
				// 2
				if (page_list_parallelInformation.getParallel_person() != null
						&& page_list_parallelInformation.getParallel_person().trim().length() > 0) {
					String parallel_person = "%" + page_list_parallelInformation.getParallel_person() + "%";
					hql = hql + " and parallel_person like '" + parallel_person + "'";
				}
				
				if (page_list_parallelInformation.getStart_time() != null && page_list_parallelInformation.getStart_time().trim().length() > 0) {
					startTime = page_list_parallelInformation.getStart_time();
				}
				if (page_list_parallelInformation.getStop_time() != null && page_list_parallelInformation.getStop_time().trim().length() > 0) {
					stopTime = page_list_parallelInformation.getStop_time();
				}
				hql = hql + " and parallel_date>='" + startTime + "' and parallel_date<='"
						+ stopTime + "' order by parallel_date";
		Query query = session.createQuery(hql);	
		query.setFirstResult(
				(page_list_parallelInformation.getPageIndex() - 1) * page_list_parallelInformation.getPageSize());
		query.setMaxResults(page_list_parallelInformation.getPageSize());
		listParallelInformationByPage = query.list();
		session.clear();
		return listParallelInformationByPage;
	}

	@Override
	public xsjsglxt_parallel getparallelById(xsjsglxt_parallel parallel) {
		// TODO Auto-generated method stub
		Session session = getSession();

		String hql = "from xsjsglxt_parallel parallel where parallel.xsjsglxt_parallel_id='" + parallel.getXsjsglxt_parallel_id() + "'";

		Query query = session.createQuery(hql);

		 parallel = (xsjsglxt_parallel) query.uniqueResult();

		return parallel;
	}

	@Override
	public xsjsglxt_case getcaseByparallelId(xsjsglxt_parallel parallel) {
		// TODO Auto-generated method stub
		Session session = getSession();

		String hql = "from xsjsglxt_case case1 where case1.case_parallel='" + parallel.getXsjsglxt_parallel_id() + "'";

		Query query = session.createQuery(hql);

		xsjsglxt_case	 case1 = (xsjsglxt_case) query.uniqueResult();

		return case1;
	}

	@Override
	public xsjsglxt_snece getsneceByCaseId(xsjsglxt_case case1) {
		// TODO Auto-generated method stub
		Session session = getSession();

		String hql = "from xsjsglxt_snece sence where sence.snece_case='" + case1.getXsjsglxt_case_id() + "'";

		Query query = session.createQuery(hql);

		xsjsglxt_snece	 sence = (xsjsglxt_snece) query.uniqueResult();

		return sence;
	}

	@Override
	public xsjsglxt_briefdetails getbriefdetailsByCaseId(xsjsglxt_case case1) {
		// TODO Auto-generated method stub
		Session session = getSession();

		String hql = "from xsjsglxt_briefdetails briefdetails where briefdetails.briefdetails_case='" + case1.getXsjsglxt_case_id() + "'";

		Query query = session.createQuery(hql);

		xsjsglxt_briefdetails	 briefdetails = (xsjsglxt_briefdetails) query.uniqueResult();

		return briefdetails;
	}

	@Override
	public xsjsglxt_resevidence getresevidenceByCaseId(xsjsglxt_case case1) {
		// TODO Auto-generated method stub
		Session session = getSession();

		String hql = "from xsjsglxt_resevidence resevidence where resevidence.resevidence_case='" + case1.getXsjsglxt_case_id() + "'";

		Query query = session.createQuery(hql);

		xsjsglxt_resevidence	 resevidence = (xsjsglxt_resevidence) query.uniqueResult();

		return resevidence;
	}

	@Override
	public int getMaxParallelNum() {
		// TODO Auto-generated method stub
		int i;
	
		String year =TeamUtil.getCurrentYear();
		String li="";
	
		String hql = "select substring(parallel_num,-1,4) from xsjsglxt_parallel where substring(parallel_num,1,8)='"+year+"' order by substring(parallel_num,-1,4) desc limit 1";
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
>>>>>>> origin/HY
