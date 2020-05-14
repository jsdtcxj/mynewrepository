package com.chs.springboot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.chs.springboot.entity.Customer;
import com.chs.springboot.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		List<Customer> customers = customerService.getCustomers(); 
		theModel.addAttribute("customers", customers);
		return "list-customers";
	}
	
	@GetMapping("/showForm")
	public String showFormForAdd(Model theModel) {
		Customer customer = new Customer();
		theModel.addAttribute("customer", customer);
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {
		customerService.saveCustomer(customer);
		return "redirect:/customer/list";
	}
	
	@GetMapping("/updateForm")
	public String showFormForUpdate(@RequestParam("customerId") int custId, Model theModel) {
		Customer customer = customerService.getCustomer(custId);
		theModel.addAttribute("customer", customer);
        return "customer-form";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int custId) {
		customerService.deleteCustomer(custId);
		return "redirect:/customer/list";
	}
}
