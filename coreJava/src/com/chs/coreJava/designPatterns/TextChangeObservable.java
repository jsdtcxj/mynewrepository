package com.chs.coreJava.designPatterns;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class TextChangeObservable {

	private Set<ChangeObserver> observers = new HashSet();
	
	public void addObserver(ChangeObserver observer) {
		observers.add(observer);
	}
	
	public void removeObserver(ChangeObserver observer) {
		observers.remove(observer);
	}
	
	public void notifyObservers(String value) {
		if(value != null) {
			Iterator<ChangeObserver> it = observers.iterator();
			while(it.hasNext()) {
				it.next().update(value);
			}
		}
	}
}
