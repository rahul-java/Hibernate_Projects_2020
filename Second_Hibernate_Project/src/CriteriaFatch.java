import java.util.List;

import max.Child;
import max.Father;
import max.SessionUtility;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;


public class CriteriaFatch {
public static void main(String[] args) {
	try {
		Session s = SessionUtility.getSesss();
		Transaction tx = s.beginTransaction();
		 Criteria cr = s.createCriteria(Father.class);
		 //cr.addOrder(Order.desc("fid"));
		   cr.add(Restrictions.eq("fid", new Integer(1)));
		List<Father> list = cr.list();
		for(Father f:list)
		{

			System.out.println(f.getFid()+ " "+f.getName()+" "+f.getAdd());
		    List<Child> clist = f.getClist();
		    for(Child c:clist)
		    {
		    	System.out.println(c.getCid()+ " "+c.getName()+ " "+c.getAdd());
		    }
		}
		tx.commit();
	} catch (Exception e) {
		e.printStackTrace();
	}
}
}
