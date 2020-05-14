package com.chs.springHibernate.service;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.persistence.LockModeType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.chs.springHibernate.dao.AddressDao;
import com.chs.springHibernate.entity.Address;

@Service
public class AddressServiceImpl implements AddressService {
	
	@Autowired
	private AddressDao addressDao;
	
	@Override
	public AddressDao getAddressDao() {
		return addressDao;
	}

	public void setAddressDao(AddressDao addressDao) {
		this.addressDao = addressDao;
	}

	@Override
	@Transactional
	public Address get(int id) {
		return addressDao.get(id);
	}

	@Override
	@Transactional
	public void save(Address address) {
		addressDao.save(address);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	public List<Address> getAddresses() {
		return addressDao.getAddresses();
	}

	@Override
	@Transactional
	public void update(String attribute, String value) {
		addressDao.update(attribute, value);
	}

	@Override
	@Transactional
	public void update(Address address) {
		addressDao.update(address);
	}

	@Override
	@Transactional
	public List<Address> findByCountry(String value) {
		return addressDao.findByCountry(value);
	}

}
