package com.chs.springHibernate.service;

import java.util.List;

import com.chs.springHibernate.dao.AddressDao;
import com.chs.springHibernate.entity.Address;

public interface AddressService {
	AddressDao getAddressDao();
	
	Address get(int id);
	
	void save(Address address);
	
	List<Address> getAddresses();
	
	void update(String attribute, String value);
	
	void update(Address address);
	
	List<Address> findByCountry(String value);
	
}
