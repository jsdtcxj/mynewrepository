package com.chs.coreJava.designPatterns;

public class ExpensiveObjectImpl implements ExpensiveObject {

	@Override
	public void process() {
		System.out.println("Process expensive object ...");
	}

}
