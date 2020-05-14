package com.chs.springHibernate.entity;

public class EmployeeDtl {
	private int id;
	private String email;
	private String depName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDepName() {
		return depName;
	}

	public void setDepName(String depName) {
		this.depName = depName;
	}

	@Override
	public String toString() {
		return "EmployeeDtl [id=" + id + ", email=" + email + ", depName=" + depName + "]";
	}
}
