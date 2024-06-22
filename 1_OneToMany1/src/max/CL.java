package max;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class CL {
	public static void main(String[] args) {
		
		Father f = new Father();
		f.setName("ramu");
		f.setAdd("noida");
		
		List<Child> clist=new ArrayList<Child>();
		Child c = new Child();
		c.setName("amitwww");
		c.setAge("23");
		clist.add(c);
		
		Child c1 = new Child();
		c1.setName("amit kumar");
		c1.setAge("25");
		clist.add(c1);
		
		Child c2 = new Child();
		c2.setName("vikaram amit");
		c2.setAge("43");
		clist.add(c2);
		f.setChildList(clist);
		try
		{
		Session ses = SessionUtility.getSession();
		Transaction tx = ses.beginTransaction();
		
		Integer i = (Integer)ses.save(f);
		tx.commit();
		if(i>0)
		{
			System.out.println("sucesss fulll");
		}
		else
		{
			System.out.println("failll");
		}
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}

}
