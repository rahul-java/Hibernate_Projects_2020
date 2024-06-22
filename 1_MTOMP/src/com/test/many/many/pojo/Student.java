package com.test.many.many.pojo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Student  implements Serializable{
	
	private String  studentname;
	private int rollno;
	private String branch;
	private String collegename;
	
	private Set<College>colleges;
	
	public String getStudentname() {
		return studentname;
	}
	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getCollegename() {
		return collegename;
	}
	public void setCollegename(String collegename) {
		this.collegename = collegename;
	}
	public Set<College> getColleges() {
		return colleges;
	}
	public void setColleges(Set<College> colleges) {
		this.colleges = colleges;
	}
}
