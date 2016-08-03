package com.mangani.publisher.subscriber;

public interface Subscrible {
	
	public void registerObserver(Observable observable);  
    public void notifyObservers();
    public void removeObserver(Observable observable);  
}
