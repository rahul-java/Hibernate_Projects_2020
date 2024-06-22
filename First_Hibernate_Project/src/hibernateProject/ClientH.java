package hibernateProject;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class ClientH {
	public static void main(String[] args) {
		UserBean userBean=new UserBean();
		
		userBean.setName("rajaram");
		userBean.setAdd("Gr Delhi");
		try {
			Session s = SessionUtility.getSesss();
			Transaction tx = s.beginTransaction();
			
			//s.persist(userBean);
			/*Integer t = (Integer)s.save(userBean);
			 if(t>0)
			 {
		 tx.commit();
			System.out.println("insert data "+t);
			 }*/
			
			s.save(userBean);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
