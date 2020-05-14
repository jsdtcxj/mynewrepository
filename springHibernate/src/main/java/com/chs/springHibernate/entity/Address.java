package com.chs.springHibernate.entity;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.NamedNativeQueries;
import org.hibernate.annotations.NamedNativeQuery;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

@Entity
@Table(name="Address")
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
@NamedQueries({
	@NamedQuery(name="Address_FindByCountry", 
			query="from Address a where a.country=:country")
})
@NamedNativeQueries({
	@NamedNativeQuery(name="Address_FindByCountry2",
			query="select * from address a where a.country=:country",
			resultClass=Address.class
)})
public class Address {

	@Id
	@GeneratedValue
	private int id;
	
	@Column(name="address")
	private String address;
	
	@Column(name="country")
	private String country;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", address=" + address + ", country=" + country + "]";
	}
}
