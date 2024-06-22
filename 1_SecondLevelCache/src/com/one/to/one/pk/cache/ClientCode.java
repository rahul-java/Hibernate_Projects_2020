package com.one.to.one.pk.cache;

import org.hibernate.Session;

import com.one.to.one.pk.pojo.Person;
import com.one.to.one.pk.utill.ResourceManager;

public class ClientCode 
{
	public static void main(String[] args) 
	{
	try {
		Session ses = ResourceManager.currentSession();
		System.out.println("HASHCODE >>>>> "+ses.hashCode());
		for(int i=1; i<=100; i++)
		{
		
		//Person p=(Person)ses.load(Person.class, 15);
		Person p=(Person)ses.get(Person.class, 15);
		System.out.println(p.getPersonId()+ " "+p.getPersonName());
		Thread.sleep(5000);
		}
	}catch (Exception e) {
			e.printStackTrace();
		}
	
	
	
		}
		//System.out.println("End of the main thread :: ");
		
		/*try 
		{
			Session ses=HibernateUtil.currentSession();
			Transaction tx=ses.beginTransaction();
			
			Person person=new Person();
			person.setPersonid(2222);
			person.setPersonname("Hibarnate");
			person.setPersoncity("Gurgaon");
			
			ses.save(person);
			tx.commit();
			ses.flush();
			ses.close();
			
			System.out.println("Data updated :: >>>> ");
	
			Session ses=HibernateUtil.currentSession();
			
			
			for (int i = 0; i < 5; i++) {
				Object o = ses.get(Person.class, new Long(1));
				System.out.println("I = "+i+" >> "+o);
				System.out.println("I = "+i+" >> "+ses.get(Person.class, new Long(2)));
				//ses.evict(o);
				
			} 
			//ses.close();
			ses=HibernateUtil.currentSession();
			for (int i = 0; i < 5; i++) {
				System.out.println("I = "+i+" >> "+ses.get(Person.class, new Long(1)));
				System.out.println("I = "+i+" >> "+ses.get(Person.class, new Long(2)));
			}
			ses.close();
			System.out.println("Done............");

			
		}   
		catch (Exception e) 
		{
			e.printStackTrace();
		}*/
		
	 }
	 

