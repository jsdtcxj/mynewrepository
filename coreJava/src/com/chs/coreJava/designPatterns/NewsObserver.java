package com.chs.coreJava.designPatterns;

import java.util.Observable;
import java.util.Observer;

public class NewsObserver implements Observer{
	
	public String getNews() {
		return news;
	}

	public void setNews(String news) {
		this.news = news;
	}

	private String news = null;

	@Override
	public void update(Observable o, Object arg) {
		setNews((String)arg);
	}

}
