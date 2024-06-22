package com.test.many.many.pojo;

import java.io.Serializable;
import java.util.Set;

public class College implements Serializable{
	
	private String collegename;
	private int collegeid;
	private String affilationTo;
	
	private Set<Student>students;
	
	public String getCollegename() {
		return collegename;
	}
	public void setCollegename(String collegename) {
		this.collegename = collegename;
	}
	public int getCollegeid() {
		return collegeid;
	}
	public void setCollegeid(int collegeid) {
		this.collegeid = collegeid;
	}
	public String getAffilationTo() {
		return affilationTo;
	}
	public void setAffilationTo(String affilationTo) {
		this.affilationTo = affilationTo;
	}
	public Set<Student> getStudents() {
		return students;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
}
