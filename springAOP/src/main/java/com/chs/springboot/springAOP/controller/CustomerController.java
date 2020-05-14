package com.chs.springboot.springAOP.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chs.springboot.springAOP.service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
//	@Qualifier("customerService")
	private CustomerService service;
	
	public CustomerService getService() {
		return service;
	}

	public void setService(CustomerService service) {
		this.service = service;
	}

	@RequestMapping("/")
	public String hello() {
		service.addCustomer();
		service.getCustomer("Jack");
		return "Welcome, " + service.getCustomer();
	}
}
