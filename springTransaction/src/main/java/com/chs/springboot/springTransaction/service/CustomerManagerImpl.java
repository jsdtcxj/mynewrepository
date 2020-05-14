package com.chs.springboot.springTransaction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.chs.springboot.springTransaction.dao.CustomerDao;
import com.chs.springboot.springTransaction.model.Customer;

@Service
public class CustomerManagerImpl implements CustomerManager {
	@Autowired
	private CustomerDao customerDao;

	public CustomerDao getCustomerDao() {
		return customerDao;
	}

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	@Override
	@Transactional
	public void create(Customer customer) {
		TransactionStatus status = TransactionAspectSupport.currentTransactionStatus();
		System.out.println(status);
		customerDao.create(customer);
	}

}
