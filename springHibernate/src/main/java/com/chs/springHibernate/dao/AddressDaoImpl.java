package com.chs.springHibernate.dao;

import java.util.List;

import javax.persistence.LockModeType;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.chs.springHibernate.entity.Address;

@Repository
public class AddressDaoImpl implements AddressDao {
	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Address get(int id) {
		return sessionFactory.getCurrentSession().get(Address.class, id);
	}
	
	@Override
	public void save(Address address) {
		sessionFactory.getCurrentSession().save(address);
	}

	@Override
	public List<Address> getAddresses() {
		Session session = sessionFactory.getCurrentSession();
//		Query query = session.createQuery("from Address").
//				setHint("org.hibernate.cacheable", true);
		
		Query query = session.createNativeQuery("select a.id, a.address, a.country from Address a", Address.class);
		query.setHint("org.hibernate.cacheable", true);
		return query.getResultList();
	}

	@Override
	public void update(String attribute, String value) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createNativeQuery("update Address a set a." + attribute + "=:"+attribute);
		query.setParameter(attribute, value);
		query.unwrap(org.hibernate.SQLQuery.class).addSynchronizedEntityClass(Address.class);
		query.executeUpdate();
	}

	@Override
	public void update(Address address) {
		Session session = sessionFactory.getCurrentSession();
		session.merge(address);
	}

	@Override
	public List<Address> findByCountry(String value) {
		Session session = sessionFactory.getCurrentSession();
//		Query query = session.createNamedQuery("Address_FindByCountry", Address.class);
		Query query = session.createNamedQuery("Address_FindByCountry2", Address.class);
		query.setParameter("country", value);
		return query.getResultList();
	}

}
