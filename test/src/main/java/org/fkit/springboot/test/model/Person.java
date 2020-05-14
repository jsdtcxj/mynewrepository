package org.fkit.springboot.test.model;

import org.springframework.context.annotation.Configuration;

@Configuration
public class Person {
	
	public Person() {
		System.out.println("initialize Person Object ...");
	}
	
	private long id;
	
	private String name;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
