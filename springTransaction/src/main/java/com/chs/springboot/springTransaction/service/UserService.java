package com.chs.springboot.springTransaction.service;

import java.util.List;

import com.chs.springboot.springTransaction.model.hibernate.Customer;

public interface UserService {
	void add(Customer customer);
	
	void add(List<Customer> list);
}
