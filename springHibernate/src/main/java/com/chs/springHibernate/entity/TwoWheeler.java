package com.chs.springHibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="two_wheeler")
public class TwoWheeler extends Vehicle {

	@Column(name="steering_type")
	private String steeringType;

	public String getSteeringType() {
		return steeringType;
	}

	public void setSteeringType(String steeringType) {
		this.steeringType = steeringType;
	}
}
