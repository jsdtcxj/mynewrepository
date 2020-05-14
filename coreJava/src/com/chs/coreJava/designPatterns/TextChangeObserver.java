package com.chs.coreJava.designPatterns;

public class TextChangeObserver implements ChangeObserver {

	@Override
	public void update(String value) {
		System.out.println("Text value got changed to " + value);
	}

	
}
