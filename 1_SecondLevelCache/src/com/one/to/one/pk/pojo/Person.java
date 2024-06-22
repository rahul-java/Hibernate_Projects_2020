package com.one.to.one.pk.pojo;

import java.io.Serializable;

public class Person implements Serializable {

	private int personId=0;
	private String personName=null;

	public String toString() {	
		return "personId :: >> " +personId+"personName :: >> " +personName;
	}
	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}
	

}
