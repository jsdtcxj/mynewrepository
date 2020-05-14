package org.fkit.springboot.logintest;

public class Person {

	private String name;
	
	private String school;
	
	private String book;
	
	public Person(String name, String school, String book) {
		this.name = name;
		this.school = school;
		this.book = book;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getBook() {
		return book;
	}

	public void setBook(String book) {
		this.book = book;
	}
}
