package max;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class CriteriyaClient {
public static void main(String[] args) {
	    try {
	    	Session s = SessionUtility.getSession();
	    	Transaction tx = s.beginTransaction();
	    	  Criteria cr = s.createCriteria(User.class);
	    	  //  cr.addOrder(Order.asc("name"));
	    	  cr.add(Restrictions.ilike("name", "%lok%"));
	           
	    	  List<User> list = cr.list();
	    	for(User p:list)
	    	{
	    		System.out.println(p.getUid()+ " "+p.getName()+ " "+p.getAdd());
	    	}
	    	  
	    	  
		} catch (Exception e) {
			// TODO: handle exception
		}
}
}
