package max;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class HQLFatch {
	
	public static   List<Father> getAllRecords(int fid) {
		try {
			Session s = SessionUtility.getSession();
		Transaction tx = s.beginTransaction();
			
		Query q = s.createQuery("from Father where fid =:fid ");
		q.setParameter("fid", fid);
      List<Father>  list=		q.list();	
		if(list.size()>0)
		return list;
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
		
	}
	

	
	public static   List<Father> getAllRecords() {
		try {
			Session s = SessionUtility.getSession();
		Transaction tx = s.beginTransaction();
			
		Query q = s.createQuery("from Father");
      List<Father>  list=		q.list();	
		if(list.size()>0)
		return list;
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
		
	}
}
