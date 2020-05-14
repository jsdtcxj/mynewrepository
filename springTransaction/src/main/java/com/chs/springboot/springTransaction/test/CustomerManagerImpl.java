package com.chs.springboot.springTransaction.test;

import org.springframework.transaction.annotation.Transactional;

import com.chs.springboot.springTransaction.model.Customer;

public class CustomerManagerImpl implements  CustomerManager {
	private CustomerDAO customerDAO;

	public void setCustomerDAO(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}

	@Override
	@Transactional
	public void createCustomer(Customer cust) {
		customerDAO.create(cust);
	}
}
