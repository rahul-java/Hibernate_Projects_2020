package max;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionUtility {
	private SessionUtility()
	{
		
	}
	private static ThreadLocal<Session> ses=new ThreadLocal<Session>();
	static SessionFactory sf;
	static
	{
		Configuration congf = new Configuration();
		congf.configure("/max/hibernate.cfg.xml");
		 sf = congf.buildSessionFactory();
	}
	
	public static Session getSesss()
	{
		Session s = ses.get();
		if(s==null)
		{
			s=sf.openSession();
			ses.set(s);
		}
		return s;
		
}
	
	public static void clossSessss()
	{
		Session s = ses.get();
		if(s!=null)
		{
			ses.set(null);
		}
	}
	
	
	
}
