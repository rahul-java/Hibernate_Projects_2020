package max;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class HQLClient {
public static void main(String[] args) {
	try {
		Session s = SessionUtility.getSession();
		Transaction x = s.beginTransaction();
		Query q = s.createQuery("from User where uid=:ud");
		q.setParameter("ud", 7);
		List<User> list = q.list();
		
		for(User p:list)
		{
			System.out.println(p.getUid()+ " "+p.getName()+ " "+p.getAdd());
		}
		
		
	} catch (Exception e) {
		// TODO: handle exception
	}
}
}
