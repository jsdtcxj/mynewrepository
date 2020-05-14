package com.chs.coreJava.clone;

import java.io.Serializable;

public class Employee implements Cloneable, Serializable {
	
	private static final long serialVersionUID = -8392912776069464363L;

	private int age;
	
	private String name;

	public Employee(String name, int age) {
		this.age = age;
		this.name = name;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object obj) {
		Employee e = (Employee)obj;
		return e.getAge() == age && e.getName().equals(name);
	}

	@Override
	public String toString() {
		return "Employee [age=" + age + ", name=" + name + "]";
	}

}
