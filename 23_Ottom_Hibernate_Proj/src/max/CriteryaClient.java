package max;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CriteryaClient
{
	
	public static void main(String[] args) 
	{
		try {
			
		Session s = SessionUtility.getSession();
		Transaction tx = s.beginTransaction();
		
		  Criteria cr = s.createCriteria(Father.class);
		  List<Father> list = cr.list();
		  
		  for(Father p:list)
		  {  
			  System.out.println("----Father Details-----");
			  System.out.println(p.getFid()+ " "+p.getName()+ " "+p.getAdhar());
			  
			  List<Child> c = p.getClist();
			  System.out.println("Child Details ");
			    for(Child t:c)
			    {
			    	
			    	System.out.println("child "+t.getCid()+ " "+t.getName()+ " "+t.getAdd());
			    }
			  
			  
			  
		  }
		  tx.commit();
		  
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
