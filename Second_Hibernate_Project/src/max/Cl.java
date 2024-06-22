package max;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Cl
{
	public static void main(String[] args)
	{
		List<Child> l=new ArrayList<Child>();
		
		Child c = new Child();
		c.setName("bharat1");
		c.setAdd("noida1");
        l.add(c);
		
		Child c1 = new Child();
		
		c1.setName("raja1");
		c1.setAdd("Gr noida1");
		l.add(c1);
		
		Child c2 = new Child();
		c2.setName("rajaram1");
		c2.setAdd("NCR noida1");
		l.add(c2);
		
		Father f = new Father();
		f.setName("Sachin1");
		f.setAdd("Delhi1");
		f.setClist(l);
		
		try {
			Session s = SessionUtility.getSesss();
			Transaction tx = s.beginTransaction();
		Integer t = (Integer)s.save(f);
		tx.commit();
			if(t>0)
			{
				System.out.println("Insert ");
			}
			else
			{
				System.out.println("erroorrr");
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
