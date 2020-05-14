package com.chs.springboot.springAOP.service;

import org.springframework.stereotype.Component;

@Component
public class ProductServiceImpl {

	public void addProduct() {
		System.out.println("addProduct() running ...");
	}
	
	public void deleteProduct() {
		System.out.println("deleteProduct() running ...");
	}
}
