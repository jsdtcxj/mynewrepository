package com.chs.springHibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="four_wheeler")
public class FourWheeler extends Vehicle {

	@Column(name="steering_type")
	private String steeringType;

	public String getSteeringType() {
		return steeringType;
	}

	public void setSteeringType(String steeringType) {
		this.steeringType = steeringType;
	}
	
}
