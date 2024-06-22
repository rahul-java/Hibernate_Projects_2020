package HQLFatch;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import max.Child;
import max.Father;
import max.SessionUtility;

public class FatchByHQL {
public static void main(String[] args) {
	try {
		Session s = SessionUtility.getSesss();
		Transaction tx = s.beginTransaction();
		Query q = s.createQuery("from Father where fid=:fd");
		q.setParameter("fd", 5);
		List<Father> list = q.list();
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
