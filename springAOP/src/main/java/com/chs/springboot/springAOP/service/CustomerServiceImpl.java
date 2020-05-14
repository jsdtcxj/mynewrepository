package com.chs.springboot.springAOP.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.chs.springboot.springAOP.repository.CustomerDao;

@Component
public class CustomerServiceImpl implements CustomerService{
	private CustomerDao customerDao;

	@Autowired
	public CustomerServiceImpl(CustomerDao dao) {
		this.customerDao = dao;
	}
	
	@Override
	public void addCustomer() {
		customerDao.add();
		System.out.println("addCustomer() is running ...");
	}

	@Override
	public String getCustomer() {
		System.out.println("getCustomer() is running ...");
		return "Chris";
	}

	@Override
	public String getCustomer(String username) {
		System.out.println("getCustomer(username) is running ...");
		return username;
	}

}
