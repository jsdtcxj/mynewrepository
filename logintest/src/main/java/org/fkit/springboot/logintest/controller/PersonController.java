package org.fkit.springboot.logintest.controller;

import javax.annotation.Resource;

import org.fkit.springboot.logintest.bean.Person;
import org.fkit.springboot.logintest.service.PersonService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class PersonController {

	@Resource
	PersonService personService;
	
	@RequestMapping("/insertPerson")
	public String insertPerson() {
		
		return "insert : " + personService.insertPerson(); 
	}
	
	@RequestMapping("/findByUsername")
	public Person findByUsername(String username) {
		return personService.findByusername(username);
	}
	
	@RequestMapping("/insertGetKey")
	public Person insertGetKey(Person person) {
		return personService.insertGetKey(person);
	}
}
