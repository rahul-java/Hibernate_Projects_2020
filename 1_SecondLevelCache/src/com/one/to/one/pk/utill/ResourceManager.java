package com.one.to.one.pk.utill;

import java.io.File;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ResourceManager {
	private static ThreadLocal<Session> session = new ThreadLocal<Session>();
	static Configuration config=null;
	static SessionFactory sf=null;

	static{
		File file =new File("E:\\lockdownJavaProject\\secondLevalCashe\\src\\com\\one\\to\\one\\pk\\configuration\\hibernate.cfg.xml");

		config = new Configuration();
		sf = config.configure(file).buildSessionFactory();
	}
	public static Session currentSession(){
		Session s=session.get();
		if(s==null){
			s=sf.openSession();
			session.set(s);
		}
		return s;

	}
	public static void closeSession(){
		Session s= session.get();
		if(s!=null){
			s.close();
		}
		session.set(null);
	}

}


