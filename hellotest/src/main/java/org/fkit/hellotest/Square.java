package org.fkit.hellotest;

@FunctionalInterface
public interface Square <Integer> {
	
	int COUNT = 100;

	int calculate(int x);
	
	static int calculate2(int x) {
		return x*2;
	}
	
	static <Integer> void printNum(int n) {
		System.out.println("interface static method: " + n);
	}
	
	default <Integer> void printDef(int n) {
		System.out.println("interface default method: " + n);
	}
}
