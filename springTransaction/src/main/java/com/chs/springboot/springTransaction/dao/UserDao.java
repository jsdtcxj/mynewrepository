package com.chs.springboot.springTransaction.dao;

import java.util.List;

import com.chs.springboot.springTransaction.model.hibernate.Address;
import com.chs.springboot.springTransaction.model.hibernate.Customer;

public interface UserDao {
	void create(Customer customer, Address address);
	
	void create(List<Customer> list);
}
