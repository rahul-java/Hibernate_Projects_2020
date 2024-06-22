package rahul.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class Fetch_Emp_Client
{
 public static void main(String[] args) {
	 Configuration cfg = new Configuration();
	 SessionFactory sf = cfg.configure("/rahul/hibernate/hibernate.cfg.xml").buildSessionFactory();
	 Session s = sf.openSession();
	 Transaction tx = s.beginTransaction();
	 
//	 Query q = s.createQuery("from EmpBean where emp_id=:eid");
//	 q.setParameter("eid", 1);
//	 List<EmpBean> l = q.list();
	 
	 Criteria cr=s.createCriteria(EmpBean.class);
	  // cr.addOrder(Order.desc("emp_id"));
	   //cr.add(Restrictions.eq("emp_id", new Integer(1)));
	 List<EmpBean> l = cr.list();
	 
	 for(EmpBean e:l)
	 {
		 System.out.println(e.getEmp_id()+"  "+e.getEmp_name()+"   "+e.getEmp_email());
	 }
	 
	  tx.commit();
}
}
