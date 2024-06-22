package com.one.to.one.pk.client;

import org.hibernate.Session;

import com.one.to.one.pk.pojo.Person;
import com.one.to.one.pk.utill.ResourceManager;

public class ClientOneToOne {

	public static void main(String[] args) {
		Session session = null;
		try {

			Person person = new Person();
			person.setPersonName("rajkumar");
		
			

			session  = ResourceManager.currentSession();
			session.save(person);
			
			session.beginTransaction().commit();
			session.flush();
			System.out.println(" >>>>>>>>>>>> Table is created in the database ???? ");
			

		} catch (Exception e) {
			session.beginTransaction().rollback();
			e.printStackTrace();
		}finally{
			ResourceManager.closeSession();
		}
		
	}

}
