package logout;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import hbnt.SessionUtility;

public class LogoutDAO {
	public String logout(String uid)
	{
		try {
			Session s = SessionUtility.getSession();
		Transaction x = s.beginTransaction();
			Query q = s.createQuery("update LoginBean set status =:status where uid =:uid");
		  q.setParameter("status", "Y");
		  q.setParameter("uid", uid);
		  int t = q.executeUpdate();
		  x.commit();
		  if(t>0)
		  {
			  return uid;
		  }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
