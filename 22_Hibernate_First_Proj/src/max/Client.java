package max;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Client {
  public static void main(String[] args) {
	  while(true)
	  {
	  User u = new User();
	     u.setName("raja");
	     u.setAdd("meerut");
	     try {
			
	    	Session s = SessionUtility.getSession();
	    	   Transaction tx = s.beginTransaction();
	    	   s.persist(u);
	    	   tx.commit();
	    	   System.out.println("succcesss");
	       Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
}
  }
}
