package org.fkit.springboot.test.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;

public class Teacher {
	
	private String name;
	
	private EnglishBook book;
	
	@Autowired
	public Teacher(EnglishBook book) {
		this.book = book;
		System.out.println("autowired the Book ... " + book.getBeanName());
	}

	public String getName() {
		return name;
	}

	@Required
	public void setName(String name) {
		this.name = name;
	}

	public Teacher() {
		System.out.println("intialize Teacher Object ...");
	}
}
