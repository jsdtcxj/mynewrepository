package com.chs.springHibernate.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.chs.springHibernate.entity.Person;

@Repository
public class PersonDaoImpl implements PersonDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void add(Person person) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(person);
	}

	@Override
	public List<Person> findByExample(String name, String value) {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Person> cq = cb.createQuery(Person.class);
		Root<Person> root = cq.from(Person.class);
		cq.select(root).where(cb.equal(root.get(name), value));
		
		Query<Person> query = session.createQuery(cq);
		return query.getResultList();
	}

}
