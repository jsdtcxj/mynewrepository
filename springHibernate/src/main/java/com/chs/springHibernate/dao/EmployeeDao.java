package com.chs.springHibernate.dao;

import java.util.List;

import com.chs.springHibernate.entity.Employee;
import com.chs.springHibernate.entity.EmployeeDtl;

public interface EmployeeDao {
	
	List getEmployees();
	
	void add(Employee employee);
	
	Employee findById(int id);
	
	Employee findBy(String name, String value);
	
	List<Object[]> getEmailAndDep();
	
	List<Employee> getDepartment();
	
	List<EmployeeDtl> getEmployeeDtls();
	
	Employee load(int id);
}
