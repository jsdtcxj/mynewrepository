package com.chs.coreJava.proxy;

public class CustomerServiceImpl implements CustomerService {

	@Override
	public String getUserName() {
		return "James Lee";
	}

	@Override
	public void setUserName(String name) {
		System.out.println("Save user info: " + name);
	}

}
