package com.test.many.many;

import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Session;

import com.test.many.many.pojo.College;
import com.test.many.many.pojo.Student;
import com.test.many.many.utill.ResourceManager;

public class Fatch {
	public static void main(String[] args) {
		try {
			Session session = ResourceManager.currentSession();
			Criteria q = session.createCriteria(Student.class);
			
		List<Student> t = q.list();
		
		      for(Student p : t)
		      {
		    	  System.out.println(p.getBranch());
		    	Set<College> f = p.getColleges();
		    	  for(College g :f)
		    	  {
		    		  System.out.println(g.getCollegename());
		    	  }
		    	System.out.println("jj "+f.size());
		      }
		
		
		System.out.println("list "+t.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
