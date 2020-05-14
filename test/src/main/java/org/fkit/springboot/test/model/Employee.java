package org.fkit.springboot.test.model;

public class Employee extends Person{
	
	private int age;
	private String name;
	
	public Employee() {
		super();
		System.out.println("Initialize Employee ...");
	}
	
	public Employee(int age, String name) {
		this.age = age;
		this.name = name;
		System.out.println("Initialize Emp[age="+age+"][name="+name+"] ...");
	}
	
	public static class Manager{
		
		public Manager() {
			System.out.println("Initialize Manager ...");
		}
	}

}
