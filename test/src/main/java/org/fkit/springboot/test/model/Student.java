package org.fkit.springboot.test.model;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(Teacher.class)
public abstract class Student {

	public Student() {
		System.out.println("initialize Student Object ..." + name);
	}
	
	private String name;
	
	private String classroom;
	
	public String getClassroom() {
		return classroom;
	}

	public void setClassroom(String classroom) {
		this.classroom = classroom;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private EnglishBook enBook;
	
	
	public EnglishBook getEnBook() {
		return enBook;
	}

	public void setEnBook(EnglishBook enBook) {
		this.enBook = enBook;
	}

	public void study(String name) {
		System.out.println("Reading in " + classroom + "...");
		EnglishBook book = createBook();
		book.readBook(name);
	}
	
	protected abstract EnglishBook createBook();
}
