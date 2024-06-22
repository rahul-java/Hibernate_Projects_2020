package master;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import hbnt.SessionUtility;

public class DistrictDAO {
	
	public static StateBean getStateCode(String stShorntName)
	{
		try {
			Session s = SessionUtility.getSession();
			 Transaction tx = s.beginTransaction();
		      Criteria cr = s.createCriteria(StateBean.class);	
		cr.add(Restrictions.eq("stateShortName", stShorntName.toUpperCase()));
		  List<StateBean> list = cr.list();
		  
		 System.out.println("st-- "+list.size());
		 tx.commit();
		 return  list.get(0);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	
	public static List<DistrictBean> getDistictDetail(int stateCode)
	{
		try {
			Session s = SessionUtility.getSession();
			 Transaction tx = s.beginTransaction();
			  Criteria cr = s.createCriteria(DistrictBean.class);
		      cr.add(Restrictions.eq("stateCode", ""+stateCode));
		    cr.addOrder(Order.asc("distName"));
		      List<DistrictBean> list = cr.list();
		     tx.commit();
		     if(list.size()>0)
		     {
		    	 return list;
		     }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
