package org.fkit.hellotest;

public class Employee implements Comparable<Employee>, Moveable {
	
	public Employee(String name, double salary) {
		this.name = name;
		this.salary = salary;
	}
	
	private String name;
	
	private double salary;

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "[name: "+name+", salary: "+salary+"]";
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public int compareTo(Employee o) {
		return Double.compare(salary, o.getSalary());
	}

	@Override
	public void move(int a, int b) {
		
	}

}
