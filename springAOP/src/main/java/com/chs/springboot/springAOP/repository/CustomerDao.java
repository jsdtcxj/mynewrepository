package com.chs.springboot.springAOP.repository;

import org.springframework.stereotype.Component;

@Component
public class CustomerDao {

	public void add() {
		System.out.println("[CustomerDao]add customer ...");
	}
}
