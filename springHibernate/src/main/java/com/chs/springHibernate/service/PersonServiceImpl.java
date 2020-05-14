package com.chs.springHibernate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chs.springHibernate.dao.PersonDao;
import com.chs.springHibernate.entity.Person;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonDao personDao;
	
	@Override
	@Transactional
	public void add(Person person) {
		personDao.add(person);
	}

	@Override
	@Transactional
	public List<Person> findByExample(String name, String value) {
		return personDao.findByExample(name, value);
	}

}
