package max;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Client {
  public static void main(String[] args) {
	try {
		List<Child> l=new ArrayList<Child>();
		Session s = SessionUtility.getSession();
		Transaction tx = s.beginTransaction();
		Father f = new Father();
		  f.setAdhar("77777");
		  f.setName("aramchan");
		  
		Child c = new Child();  
		c.setName("rajakk");
		c.setAdd("gr noida");
		l.add(c);
		
		Child c1 = new Child();  
		c1.setName("araja");
		c1.setAdd("gr noida");
		l.add(c1);
		f.setClist(l);
		s.persist(f);
		
		//s.createCriteria(Father.class);
		tx.commit();
		System.out.println("successsss");
	} catch (Exception e) {
		e.printStackTrace();
	}
}
}
