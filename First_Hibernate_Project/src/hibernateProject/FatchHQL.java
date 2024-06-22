package hibernateProject;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class FatchHQL {
	public static void main(String[] args) {
		try {
			Session s = SessionUtility.getSesss();
			Transaction tx = s.beginTransaction();
	// fatch data by HQL
			//Query q = s.createQuery("from UserBean");
		// Fatch Data By Criteria	
			Criteria cr = s.createCriteria(UserBean.class);
			
		//List<UserBean> list = q.list();
			List<UserBean> list = cr.list();
		for(UserBean p:list)
		{
			System.out.println(p.getUid()+ " "+p.getName()+ " "+p.getAdd());
		}
		tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
