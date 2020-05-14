package com.chs.coreJava.methodConstructorRef;

public class Test {

	public static void main(String[] args) {
		//static method reference
		Converter<String, Integer> converter = Integer::valueOf;
		System.out.println(converter.convert("123"));
		
		//constructor reference
		PersonFactory<Person> factory = Person::new;
		Person person = factory.create("Thomas", "Jack");
		System.out.println(person);
		//object method reference
		converter = person::convert;
		System.out.println(converter.convert("456"));
	}

}
