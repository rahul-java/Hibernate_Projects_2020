package rahul.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Emp_Client 
{
 public static void main(String[] args)
 {
	 EmpBean empBean = new EmpBean();
	 empBean.setEmp_id(1001);
	 empBean.setEmp_name("Rahul");
	 empBean.setEmp_email("rahul@gmail.com");
	 try {
		 Configuration cfg = new Configuration();
		 SessionFactory sf = cfg.configure("/rahul/hibernate/hibernate.cfg.xml").buildSessionFactory();
		 
		 //ThreadLocal<Session> ses=new ThreadLocal<Session>();
		 
		// Session s = ses.get();
		 Session s = sf.openSession();
		 s.save(empBean);
		// ses.set(s);
		 Transaction tx = s.beginTransaction();
		  tx.commit();
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	 
	 
}
}
