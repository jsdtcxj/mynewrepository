package com.chs.springHibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="vehicle")
@Inheritance(strategy=InheritanceType.JOINED)
public class Vehicle {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="vehicle_name")
	private String vehicleName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", vehicleName=" + vehicleName + "]";
	}
}
