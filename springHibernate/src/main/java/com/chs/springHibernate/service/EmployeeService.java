package com.chs.springHibernate.service;

import java.util.List;

import com.chs.springHibernate.entity.Employee;
import com.chs.springHibernate.entity.EmployeeDtl;

public interface EmployeeService {
	List getEmployees();
	
	void add(Employee employee);
	
	Employee findById(int id);
	
	Employee findBy(String name, String value);
	
	List<Object[]> getEmails();
	
	List<Employee> getDepartment();
	
	List<EmployeeDtl> getEmployeeDtls();
	
	Employee load(int id);
}
