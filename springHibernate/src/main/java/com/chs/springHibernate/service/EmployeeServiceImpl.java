package com.chs.springHibernate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.chs.springHibernate.dao.EmployeeDao;
import com.chs.springHibernate.entity.Employee;
import com.chs.springHibernate.entity.EmployeeDtl;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	private EmployeeDao employeeDao;
	
	@Override
	@Transactional
	public List getEmployees() {
		return employeeDao.getEmployees();
	}

	@Override
	@Transactional
	public void add(Employee employee) {
		employeeDao.add(employee);
	}

	@Override
	@Transactional
	public Employee findById(int id) {
		return employeeDao.findById(id);
	}

	@Override
	@Transactional
	public Employee findBy(String name, String value) {
		return employeeDao.findBy(name, value);
	}

	@Override
	@Transactional
	public List<Object[]> getEmails() {
		return employeeDao.getEmailAndDep();
	}

	@Override
	@Transactional
	public List<Employee> getDepartment() {
		return employeeDao.getDepartment();
	}

	@Override
	@Transactional
	public List<EmployeeDtl> getEmployeeDtls() {
		return employeeDao.getEmployeeDtls();
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public Employee load(int id) {
		Employee employee = employeeDao.load(id);
		System.out.println(employee);//fetch it eagerly
		return employee;
	}

}
