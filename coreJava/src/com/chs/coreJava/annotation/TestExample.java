package com.chs.coreJava.annotation;

import com.chs.coreJava.annotation.TesterInfo.Priority;

@TesterInfo (
	priority=Priority.HIGH,
	createdBy="chs.com",
	tags= {"pig", "dog"}
)
public class TestExample {
	@Test
	void testA() {
		if(true) {
			throw new RuntimeException("This test will always be failed.");
		}
	}
	
	@Test(enabled=false)
	void testB() {
		if(true) {
			throw new RuntimeException("This test pass without errors.");
		}
	}
	
	@Test(enabled=true)
	void testC() {
		if(1 < 10) {
			System.out.println("TestC is running ...");
		}
	}
}
