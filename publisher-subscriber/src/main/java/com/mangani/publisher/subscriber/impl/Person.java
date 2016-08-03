package com.mangani.publisher.subscriber.impl;

import com.mangani.publisher.subscriber.Observable;

public class Person implements Observable {
	
	private String personName;
	private String availability;
	
	public Person(String personName) {

		this.personName = personName;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}


	public void update(String availability) {
		
		if(availability == null || "".equals(availability)){
			this.availability = availability;
			return;
		}
		
		if(availability.equalsIgnoreCase(this.availability)){
			return;
		}
		
		this.availability = availability;
		
		System.out.println("Hello "+personName+", Product is now " + availability +" on flipkart");		
	}
}
