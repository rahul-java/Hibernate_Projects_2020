package max;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class RegistDAO {
	
	public boolean insertData(RegistBean registBean)
	{
		try {
	Session s = SessionUtility.getSession();
		Transaction tx = s.beginTransaction();
			
		String adhar=(String)s.save(registBean);
		tx.commit();
		if(adhar.equalsIgnoreCase(registBean.getAdhar()))
		{
			return true;
		}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
