package com.chs.springboot.springTransaction.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.chs.springboot.springTransaction.model.hibernate.Address;
import com.chs.springboot.springTransaction.model.hibernate.Customer;

//@Repository
public class UserDaoImpl implements UserDao {
//	private Session session = null;

//	@Autowired
	private SessionFactory sessionFactory;

//	@PersistenceContext
//	private EntityManager em;

//	@Autowired
//	private HibernateTemplate template;

	@Override
	public void create(Customer customer, Address address) {
//		Transaction tx = getCurrentSession().beginTransaction();
		getCurrentSession().save(customer);
//		getCurrentSession().save(address);
//		tx.commit();
//		template.save(customer);
	}

	/**
	 *  From hibernate5 onwards, we need to get session like this:
	 * 
	 * @return
	 */
	private Session getCurrentSession() {
//	    if(session == null) {
//	    	session = em.unwrap( Session.class);
//	    }
//	    return session;
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void create(List<Customer> list) {
		for(Customer customer : list) {
			getCurrentSession().save(customer);
		}
		
	}
}
