package max;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

public class CreteriaDAO {
	public static List<Father> getRecords(int fid)
	{
		try {
			Session s = SessionUtility.getSession();
			Transaction tx = s.beginTransaction();
			Criteria cr = s.createCriteria(Father.class);
			  cr.add(Restrictions.eq("fid", 1));
			 // cr.add(Restrictions.eq("name", "ram"));
			 // cr.add(Restrictions.or(Restrictions.));
	List<Father> list = cr.list();
			
	
	return list;
	
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
	
	
	public static List<Father> getRecords()
	{
		try {
			Session s = SessionUtility.getSession();
			Transaction tx = s.beginTransaction();
			Criteria cr = s.createCriteria(Father.class);
	List<Father> list = cr.list();
			
	
	return list;
	
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
