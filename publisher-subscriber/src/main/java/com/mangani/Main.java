package com.mangani;

import java.util.ArrayList;
import java.util.List;

import com.mangani.publisher.subscriber.Observable;
import com.mangani.publisher.subscriber.impl.Person;
import com.mangani.publisher.subscriber.impl.Produto;

public class Main {
	
	public static void main(String[] args) {

		List<Observable> consumers = generateConsumers();
		
		Produto produto =  new Produto.Builder("Samsung", "Galaxy Ranger").availability("unvailable").observables(consumers).build();
		produto.setAvailability("Available");
	}
	
	public static List<Observable> generateConsumers(){
		
		String[] names=  {"Rosemeire Dourado", "Gustavo Dourado", "Paulo Sérgio Bruno"};
		List<Observable> persons = new ArrayList<Observable>();
		
		for (String name : names) {
			Person person = new Person(name);
			persons.add(person);
		}
		
		return persons;
	}
}
