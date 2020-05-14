package com.chs.coreJava.designPatterns;

public class TemplateSample {

	public static void main(String[] args) {
		Computer standard = new StandardComputerBuilder().buildComputer();
		System.out.println(standard);
	}
}
