package org.fkit.springboot.logintest.service;

import javax.annotation.Resource;

import org.fkit.springboot.logintest.bean.Person;
import org.fkit.springboot.logintest.repository.PersonRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

	@Resource
	PersonRepository personRepository;
	
	public int insertPerson() {
		return personRepository.insertPerson();
	}
	
	public Person findByusername(String username) {
		return personRepository.findByUsername(username);
	}
	
	public Person insertGetKey(Person person) {
		return personRepository.insertGetKey(person);
	}
}
