package com.test.many.many.client;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;


import com.test.many.many.pojo.College;
import com.test.many.many.pojo.Student;
import com.test.many.many.utill.ResourceManager;

public class ClientCode {
	
	public static void main(String[] args) {
		
		try {
			
			Student student = new Student();
			student.setBranch("It");
			student.setCollegename("cmatpppp");
			student.setRollno(1405608);
			student.setStudentname("veer");
			
			
			Set<Student> studt = new HashSet<Student>();
			
			studt.add(student);
			
			College college = new College();
			college.setAffilationTo("uptu");
			college.setCollegeid(143);
			college.setCollegename("c-mat");
			
			Set<College> colleges = new HashSet<College>();
			colleges.add(college);
			
			//college.setStudents(studt);
			student.setColleges(colleges);
									
			Session session = ResourceManager.currentSession();
			//session.save(college);
			session.save(student);
			
			session.beginTransaction().commit();
			System.out.println("table is created into data base and new table is created ");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

}
//inverse by default false
//if inverse =true both hbm file or false than data inserted in new table
// if inverse =false any one hbm file than data inserted in new table which is primary key.
//you use lazy=true only the object of class will be loaded without the dependencies
//if you make lazy=false all the dependencies be loaded

//or
//If lazy=ture..loads only parent records (primary key records) only and its recommondad for memroy optimizations. lazy=false loads parent records and child records as well
//in single query
