package com.chs.springHibernate.dao;

import java.util.List;

import javax.persistence.LockModeType;

import com.chs.springHibernate.entity.Address;

public interface AddressDao {
	Address get(int id);
	
	void save(Address address);
	
	List<Address> getAddresses();
	
	void update(String attribute, String value);
	
	void update(Address address);
	
	List<Address> findByCountry(String value);

}
