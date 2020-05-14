package com.chs.coreJava.designPatterns;

public class ObserverSample {

	public static void main(String[] args) {
		NewsObservable observable = new NewsObservable();
		NewsObserver observer = new NewsObserver();
		
		observable.addObserver(observer);
		observable.setNews("NBA news ....");
		System.out.println(observer.getNews());
		
		TextChangeObservable observable2 = new TextChangeObservable();
		TextChangeObserver observer2 = new TextChangeObserver();
		observable2.addObserver(observer2);
		observable2.notifyObservers("GO Go GO!!!");
	}

}
