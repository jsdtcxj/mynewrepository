package com.chs.springboot.springTransaction.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chs.springboot.springTransaction.dao.UserDao;
import com.chs.springboot.springTransaction.model.hibernate.Customer;

//@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

//	@Transactional
	@Override
	public void add(Customer customer) {
		userDao.create(customer, null);
	}

	@Transactional
	@Override
	public void add(List<Customer> list) {
		userDao.create(list);
	}
}
