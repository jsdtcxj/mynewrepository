package com.chs.coreJava.defaultMethods;

public interface Formula {
	
	double calculate(int a);
	
	default double sqrt(int a) {
		return Math.sqrt(a);
	}
	
	default double sqrt2(int b) {
		return Math.sqrt(b) * 2;
	}
}
