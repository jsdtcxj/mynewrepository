package com.chs.springHibernate.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CONTRACT_PER")
public class ContractPerson extends Person{

	@Column(name="per_type")
	private String perType;

	public String getPerType() {
		return perType;
	}

	public void setPerType(String perType) {
		this.perType = perType;
	}
}
