package com.chs.coreJava.defaultMethods;

public class DefaultMethodsTest {

	public static void main(String[] args) {
		//default methods is not supported by lambda expression
		Formula formula = new Formula() {
			@Override
			public double calculate(int a) {
				return sqrt(a)*2;
			}
		};
		System.out.println(formula.calculate(16));
	}

}
