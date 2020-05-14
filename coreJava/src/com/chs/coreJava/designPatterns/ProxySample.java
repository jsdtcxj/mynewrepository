package com.chs.coreJava.designPatterns;

public class ProxySample implements ExpensiveObject {

	private ExpensiveObject expensiveObject = null;

	@Override
	public void process() {
		if (expensiveObject == null) {
			expensiveObject = new ExpensiveObjectImpl();
		}
		expensiveObject.process();
	}
	
	public static void main(String[] args) {
		ProxySample expensiveObject = new ProxySample();
		expensiveObject.process();
	}
	
}
