package com.mangani.publisher.subscriber.impl;

import java.util.List;

import com.mangani.publisher.subscriber.Observable;
import com.mangani.publisher.subscriber.Subscrible;

public class Produto implements Subscrible{
	
	private final List<Observable> observables;
	private final String productName;
	private final String productType;
	private String availability;
	
	public Produto(Builder builder){
		this.observables = builder.observables;
		this.productName = builder.productName;
		this.productType = builder.productType;
		this.availability = builder.availability;
	}
	
	public static class Builder{

		private String productName;
		private String productType;
		private String availability;
		private List<Observable> observables;
		
		public Builder(String productName, String productType) {
			this.productName = productName;
			this.productType = productType;
		}
		
		public Builder availability(String availability){
			this.availability = availability;
			return this;
		}
		
		public Builder observables(List<Observable> observables){
			
			if(observables == null){
				throw new AssertionError("A lista de ouvintes nao pode ser null!");
			}
			
			this.observables = observables;
			return this;
		}
		
		public Produto build(){
			return new Produto(this);
		}
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
		this.notifyObservers();
	}

	public List<Observable> getObservables() {
		return observables;
	}

	public String getProductName() {
		return productName;
	}

	public String getProductType() {
		return productType;
	}

	public void registerObserver(Observable observable) {
		this.observables.add(observable);
		
	}

	public void notifyObservers() {
		System.out.println("Noficando os observadores");  
		for (Observable observable : observables) {
			observable.update(this.availability);
		}
	}

	public void removeObserver(Observable observable) {
		this.observables.remove(observable);
	}
}
