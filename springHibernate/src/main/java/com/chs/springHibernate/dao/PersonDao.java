package com.chs.springHibernate.dao;

import java.util.List;

import com.chs.springHibernate.entity.Person;

public interface PersonDao {
	void add(Person person);
	
	List<Person> findByExample(String name, String value);
}
