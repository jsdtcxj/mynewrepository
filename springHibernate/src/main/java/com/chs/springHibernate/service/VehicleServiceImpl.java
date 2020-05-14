package com.chs.springHibernate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chs.springHibernate.dao.VehicleDao;
import com.chs.springHibernate.entity.Vehicle;

@Service
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	private VehicleDao vehicleDao;
	
	@Override
	@Transactional
	public void add(Vehicle vehicle) {
		vehicleDao.add(vehicle);
	}

}
