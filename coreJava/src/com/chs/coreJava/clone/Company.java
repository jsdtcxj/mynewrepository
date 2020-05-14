package com.chs.coreJava.clone;

import java.io.Serializable;

public class Company implements Cloneable, Serializable {
	private static final long serialVersionUID = 388112813149185816L;

	private Employee employee;
	
	private String address;
	
	public Company(String address, Employee employee) {
		this.address = address;
		this.employee = employee;
	}

	@Override
	public boolean equals(Object obj) {
		Company company = (Company)obj;
		return company.getAddress().equals(address) && 
				company.getEmployee().equals(employee);
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		Company company = (Company)super.clone();
		company.setEmployee((Employee)employee.clone());
		return company;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
