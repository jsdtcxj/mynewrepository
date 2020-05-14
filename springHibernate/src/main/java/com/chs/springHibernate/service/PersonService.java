package com.chs.springHibernate.service;

import java.util.List;

import com.chs.springHibernate.entity.Person;

public interface PersonService {
	void add(Person person);
	
	List<Person> findByExample(String name, String value);
}
