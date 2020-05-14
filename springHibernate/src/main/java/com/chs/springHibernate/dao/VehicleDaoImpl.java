package com.chs.springHibernate.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.chs.springHibernate.entity.Vehicle;

@Repository
public class VehicleDaoImpl implements VehicleDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void add(Vehicle vehicle) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(vehicle);
	}

}
