package com.chs.coreJava.annotation.streams;

public class Person {
	String name;
	int age;
	
	public Person(int age, String name) {
		this.age = age;
		this.name = name;
	}
	
	@Override
	public String toString() {
		return name;
	}
}
