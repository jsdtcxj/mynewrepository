package com.chs.coreJava.designPatterns;

import java.util.Observable;

public class NewsObservable extends Observable{
	
	public void setNews(String news) {
		setChanged();
		notifyObservers(news);
	}
}
